# CSE313 Big Data Analytics Assessment 2

## 1. My results files:

- File 1: top 10 bigram and occurrences = “Bigram.java”
- File 2: the single line contains “torture” = “Torture.java”

## 2. My code with comments:

```Bigram.java```
```Torture.java```

## 3. Hadoop command list and order used to run job and obtain results:

### Bigram

1. Copy the test file from local storage to HDFS.

```$HADOOP_HOME/bin/hadoop fs -put workspace/Bigram/pg100.txt```

2. Run the exported bigram JAR file with text file specified in arguments.

```$HADOOP_HOME/bin/hadoop jar bigram.jar edu.xjtlu.cse313.bigram.Bigram pg100.txt```

3. Display the MapReduce results contained in the output “part” file; sorted numerically by column 3, top 10 results starting from file’s head.

```$HADOOP_HOME/bin/hadoop fs -cat home/cloudera/cchamp17/part* | sort -n -k3 -r | head -n10```

Output:

```
$ [cloudera@localhost ~]$ hadoop fs -cat home/cloudera/cchamp17/part* | sort -n -k3 -r | head -n10

I am	1714
in the	1523
I have	1507
of the	1435
I will	1416
to the	1295
to be	768
I do	724
and the	677
of my	671
```

### Torture

