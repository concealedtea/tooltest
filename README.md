<p>Step 1:
Use collected data on 1 Hive table (Hue) and store it onto HDFS on Hortonworks.

<b>insert overwrite directory '/user/hue/sample_test' row format delimited fields terminated by '|' select device_idfa,device_mac,device_manufacturer,device_screen_pixel_metric,device_model from adcocoa_device where device_idfa is not null and device_idfa != 'null'</b>

The command above stores the data into small pieces in /user/hue/sample_test. There the files can be downloaded and imported onto Hortonworks.</p>

<p>Step 2:
Write Java Program to read files from local environment, parse linearly, and send data to Kafka using the log4j and kafka packages provided on Maven.

<b>/src/main/java/parser.java</b>
</p>

