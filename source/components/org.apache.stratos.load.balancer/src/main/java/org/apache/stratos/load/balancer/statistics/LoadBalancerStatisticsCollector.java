/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.stratos.load.balancer.statistics;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.stratos.load.balancer.common.statistics.LoadBalancerStatisticsReader;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This is the load balancer statistics collector.
 */
public class LoadBalancerStatisticsCollector implements LoadBalancerStatisticsReader {
    private static final Log log = LogFactory.getLog(LoadBalancerStatisticsCollector.class);

    private static volatile LoadBalancerStatisticsCollector instance;
    // Map<ClusterId, Integer>
    private Map<String, Integer> clusterIdRequestCountMap;

    private LoadBalancerStatisticsCollector() {
        clusterIdRequestCountMap = new ConcurrentHashMap<String, Integer>();
    }

    public static LoadBalancerStatisticsCollector getInstance() {
        if (instance == null) {
            synchronized (LoadBalancerStatisticsCollector.class) {
                if (instance == null) {
                    if (log.isDebugEnabled()) {
                        log.debug("Load balancer in-flight request count collector instance created");
                    }
                    instance = new LoadBalancerStatisticsCollector();
                }
            }
        }
        return instance;
    }

    /**
     * Clear load balancer statistics collector singleton instance.
     */
    public static void clear() {
        synchronized (LoadBalancerStatisticsCollector.class) {
            instance = null;
        }
    }

    public int getInFlightRequestCount(String clusterId) {
        synchronized (LoadBalancerStatisticsCollector.class) {
            if (clusterIdRequestCountMap.containsKey(clusterId)) {
                Integer count = clusterIdRequestCountMap.get(clusterId);
                if(count != null) {
                    return count;
                }
            }
            return 0;
        }
    }

    void incrementInFlightRequestCount(String clusterId) {
        synchronized (LoadBalancerStatisticsCollector.class) {
            if (StringUtils.isBlank(clusterId)) {
                if (log.isDebugEnabled()) {
                    log.debug("Cluster id is null, could not increment in-flight request count");
                }
                return;
            }
            Integer count = 0;
            if (clusterIdRequestCountMap.containsKey(clusterId)) {
                count = clusterIdRequestCountMap.get(clusterId);
            }
            count++;
            clusterIdRequestCountMap.put(clusterId, count);

            if (log.isDebugEnabled()) {
                log.debug(String.format("In-flight request count incremented: [cluster] %s [count] %s ", clusterId,
                        count));

            }
        }
    }

    void decrementInFlightRequestCount(String clusterId) {
        synchronized (LoadBalancerStatisticsCollector.class) {
            if (StringUtils.isBlank(clusterId)) {
                if (log.isDebugEnabled()) {
                    log.debug("Cluster id is null, could not decrement in-flight request count");
                }
                return;
            }

            if (!clusterIdRequestCountMap.containsKey(clusterId)) {
                if (log.isDebugEnabled()) {
                    log.debug(String.format("In-flight request count not found for cluster, could not decrement in-flight request count: [cluster] %s ", clusterId));
                }
            } else {
                Integer count = clusterIdRequestCountMap.get(clusterId);
                if (count != null) {
                    count = (count >= 1) ? (count - 1) : 0;
                }
                clusterIdRequestCountMap.put(clusterId, count);

                if (log.isDebugEnabled()) {
                    log.debug(String.format("In-flight request count decremented: [cluster] %s [count] %s ", clusterId,
                            count));
                }
            }
        }
    }
}