================================================================================
                        Apache Stratos Load Balancer 4.0.0
================================================================================

Welcome to the Apache Stratos Load Balancer 4.0.0

Apache Stratos LB is a lightweight and easy-to-use Open Source Load Balancer
(LB) available under the Apache Software License v2.0. Apache Stratos LB allows
administrators to simply configure message load balancing, failover routing,
and auto scaling. The runtime has been designed to be completely
asynchronous, non-blocking and streaming based on the Apache Synapse core.

This is based on the revolutionary WSO2 Carbon [Middleware a' la carte]
framework. All the major features have been developed as pluggable Carbon
components. Apache Stratos Load Balancer is a compact version doing the load balancing
features of WSO2 Enterprise Service Bus.


Key Features of Apache Stratos LB
======================================

1. Non-blocking HTTP/S transports based on Apache HttpCore for ultra fast
   execution and support for thousands of connections at high concurrency with
   constant memory usage. Integrated high performing, Passthrough Transport. 
2. Load-balancing (with or without sticky sessions)/Fail-over, and clustered
   Throttling and Caching support.
3. Automatically scaling the system according to the number of requests in-flight for
   a particular service cluster - "Scale up early, scale down slowly".
4. Service aware dynamic load balancing - A single load balancer
   can centrally manage the load across the nodes of different service clusters.
5. Tenant aware load balancing - Tenants can be loaded and unloaded dynamically.
   Tenants can be partitioned to different service clusters.
6. Lightweight, XML and Web services centric messaging model.
7. Administrator friendly - Configurations are simple and easy.

System Requirements
=======================

1. Minimum memory - 1.5GB
2. Processor      - Pentium 800MHz or equivalent at minimum
3. Java SE Development Kit 1.6.0_24 or higher

Installation & Running
==========================

1. Extract the load balancer binary package and go to the extracted directory.
2. Update load balancer configuration: repository/conf/loadbalancer.conf.
3. Run bin/stratos.sh or bin/stratos.bat as appropriate.

Apache Stratos LB 2.0.5 distribution directory structure
=============================================================

    CARBON_HOME
	|- bin <folder>
	|- lib <folder>
	|- repository <folder>
	|- tmp <folder>
	|- LICENSE.txt <file>
	|- README.txt <file>
	|- INSTALL.txt <file>

    - bin
	  Contains various scripts, .sh & .bat files

    - lib
	  Contains the basic set of libraries required to startup LB
	  in standalone mode

    - repository
	  The repository where services and modules deployed in Apache Stratos LB
	  are stored. In addition to this, the components directory inside the
	  repository directory contains the carbon runtime and the user added
	  jar files including mediators, third party libraries etc. All
	  global and LB specific configuration files, generated log files
	  and other deployed artifacts are also housed under this directory.

    - tmp
	  Used for storing temporary files, and is pointed to by the
	  java.io.tmpdir System property

    - LICENSE.txt
	  Apache License 2.0 and the relevant other licenses under which
	  Apache Stratos LB is distributed.

    - README.txt
	  This document.

    - INSTALL.txt
      This document will contain information on installing Apache Stratos LB

    - release-notes.html
	  Release information for Apache Stratos load balancer.


Support
==================================

Any problem with this release can be reported to Apache Stratos mailing list
or in the JIRA issue tracker. If you are sending an email to the mailing
list make sure to add the [Apache Stratos] prefix to the subject.

Mailing list subscription:
    dev-subscribe@stratos.incubator.apache.org


Issue Tracker
==================================

Jira:
    https://issues.apache.org/jira/browse/stratos


Crypto Notice
==================================

   This distribution includes cryptographic software.  The country in
   which you currently reside may have restrictions on the import,
   possession, use, and/or re-export to another country, of
   encryption software.  BEFORE using any encryption software, please
   check your country's laws, regulations and policies concerning the
   import, possession, or use, and re-export of encryption software, to
   see if this is permitted.  See <http://www.wassenaar.org/> for more
   information.

   The U.S. Government Department of Commerce, Bureau of Industry and
   Security (BIS), has classified this software as Export Commodity
   Control Number (ECCN) 5D002.C.1, which includes information security
   software using or performing cryptographic functions with asymmetric
   algorithms.  The form and manner of this Apache Software Foundation
   distribution makes it eligible for export under the License Exception
   ENC Technology Software Unrestricted (TSU) exception (see the BIS
   Export Administration Regulations, Section 740.13) for both object
   code and source code.

   The following provides more details on the included cryptographic
   software:

   Apache Rampart   : http://ws.apache.org/rampart/
   Apache WSS4J     : http://ws.apache.org/wss4j/
   Apache Santuario : http://santuario.apache.org/
   Bouncycastle     : http://www.bouncycastle.org/


Thank you for using Apache Stratos!
The Stratos Team.
