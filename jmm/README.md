1) Serial Collector with the following parameters: 6m initial heap size for when the JVM starts,
   18m maximum heap size, 2m size of the Young Generation, 20m starting size of
   the Permanent Generation, 30m maximum size of the Permanent Generation.
 
-XX:-UseSerialGC -Xms6m -Xmx18m -XX:MaxNewSize=2m -XX:MetaspaceSize=20m -XX:MaxMetaspaceSize=30m
 
2) Parallel Collector with the following parameters 3m initial heap size for when the JVM
   starts 12m maximum heap size 1m size of the Young Generation 20m starting size of
   the Permanent Generation 20 maximum size of the Permanent Generation
   
-XX:-UseParallelGC -Xms3m -Xmx12m -XX:MaxNewSize=1m -XX:MetaspaceSize=20m -XX:MaxMetaspaceSize=20m
    
3) Parallel Old Collector with the following parameters 9m initial heap size for when the JVM
   starts 18m maximum heap size 3m size of the Young Generation 40m starting size of
   the Permanent Generation 40 maximum size of the Permanent Generation

-XX:-UseParallelOldGC -Xms9m -Xmx18m -XX:MaxNewSize=3m -XX:MetaspaceSize=40m -XX:MaxMetaspaceSize=40m

4) Concurrent Mark Sweep (CMS) Collector with 2 Parallel CMS Threads with the following parameters
   6m initial heap size for when the JVM starts 18m maximum heap size 2m size of
   the Young Generation 20m starting size of the Permanent Generation 30 maximum
   size of the Permanent Generation

-XX:-UseConcMarkSweepGC -XX:ConcGCThreads=2 -Xms6m -Xmx18m -XX:MaxNewSize=2m -XX:MetaspaceSize=20m -XX:MaxMetaspaceSize=30m

5) G1 Garbage Collector with the following parameters 4m initial heap size for when the JVM
   starts 16m maximum heap size 2m size of the Young Generation 12m starting size of
   the Permanent Generation 18 maximum size of the Permanent Generation 

-XX:+UseG1GC -Xms2m -Xmx16m -XX:MaxNewSize=2m -XX:MetaspaceSize=12m -XX:MaxMetaspaceSize=18m
