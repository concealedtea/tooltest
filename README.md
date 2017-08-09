<h1><p align = center>Cumultive Data Project Weeks 1-5 Internship (First Half)</p></h1>
Resources used: 
Apache Kafka, Apache Hadoop, Apache Flume, Hadoop DFS, Java, Maven, Log4J, CentOS, Apache Zookeeper. 

Steps 1-5 can be edited to just take data (if doing practice with local files) and put it onto HDFS with the command

<b> "hadoop fs -copyFromLocal 'file/address/in/linux' 'hdfs/location/' " </b>

<h1><p align = center>Step 1:</p></h1>
<p align = center>Use collected data on 1 Hive table (Hue/Company HDFS) and store it onto Personal HDFS</p>

<p align = center><b>insert overwrite directory '/user/hue/sample_test' row format delimited fields terminated by '|' select device_idfa,device_mac,device_manufacturer,device_screen_pixel_metric,device_model from adcocoa_device where device_idfa is not null and device_idfa != 'null'</b></p>

<p align = center>The command above stores the data into small pieces in /user/hue/sample_test. There the files can be downloaded and imported onto local file system</p>

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
 <p align = center><b>java -jar tooltest-VERSION-SNAPSHOT.jar</b></p>
 <p align = center> With both the Consumer/Producer running, the files from the folder will now be read into Hadoop Distributed File System (HDFS) and stored under '/user/kafka/database/%topic/%y-%m' </p>

<h1><p align = center>Step 6:</p></h1>
<p align = center> Install and configure Hive. Start up Hive. </p>
<p align = center><b> '$HIVE_HOME/bin/hive' </b> </p>
<p align = center> Create a table in hive delimited by whatever you are delimited by, in this case it's the pipe character | </p>
<p align = center><b> create table tablename(a int, b string, c string, d string, e string)</b> </p>
<p align = center><b> row format delimited </b> </p>
<p align = center><b> fields delimited by '\|'; </b> </p>
<p align = center> Load data from hdfs into hive table</p>
<p align = center><b> 'load data inpath 'filepath/path' into table tester2 </b> </p>

<h1><p align = center>Step 7:</p></h1>
<p align = center> Create sorted table that sorts by phone brand, we'll use this data to create a visual after sending to MySQL </p>
<p align = center><b> 'insert into table sortorder select phone,count(phone) as phoneCount from tester2 group by phone order by phoneCount desc;' </b> </p>
<p align = center> This is a sorted table with entries in 2 columns of phone brand and the # of times that people using that brand have accessed our app.</p>

<h1><p align = center>Step 8:</p></h1>
<p align = center> Use Sqoop (ver 1.4.6 compatible with Hadoop 2.8.0) to export data from hive warehouse to MySQL for web visual integration.</p>
<p align = center><b> ./sqoop export --connect jdbc:mysql://localhost/test --username root -P --table test --fields-terminated-by ',' --lines-terminated-by '\n' --export-dir /user/hive/warehouse/sortorder  </b> </p>
