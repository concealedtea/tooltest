<h1><p align = center>Step 1:</p></h1>
<p align = center>Use collected data on 1 Hive table (Hue) and store it onto HDFS on Hortonworks.</p>

<p align = center><b>insert overwrite directory '/user/hue/sample_test' row format delimited fields terminated by '|' select device_idfa,device_mac,device_manufacturer,device_screen_pixel_metric,device_model from adcocoa_device where device_idfa is not null and device_idfa != 'null'</b></p>

<p align = center>The command above stores the data into small pieces in /user/hue/sample_test. There the files can be downloaded and imported onto Hortonworks.</p>

<h1><p align = center>Step 2:</p></h1>
<p align = center>Write Java Program to read files from local environment, parse linearly, and send data to Kafka using the log4j and kafka packages provided on Maven.</p>

<p align = center><b>/src/main/java/parser.java</b></p>

<h1><p align = center>Step 3:</p></h1>
<p align = center> Wrap package into .jar file and export to HDFS for Kafka/Flume Processing</p>

<h1><p align = center>Step 4:</p></h1>
<p align = center>Start up all needed resources on CentOS (Linux Distribution I'm using, yours may be different). 
  Name/Data nodes, Zookeeper, Kafka, Hadoop. 
  Do -> jps <- to make sure all of them are online. </p>
  
<h1><p align = center>Step 5:</p></h1>
<p align = center> Run Flume to have a receiver after setting up a Flume.conf file. </p>
 <p align = center><b>flume-ng agent -n flume1 -c conf -f flume.conf -    Dflume.root.logger=INFO,console</b></p>
 <p align = center> Run the java -jar file to start the Kafka Producer </p>
 <p align = center><b>java -jar tooltest-1.4-SNAPSHOT.jar</b></p>
