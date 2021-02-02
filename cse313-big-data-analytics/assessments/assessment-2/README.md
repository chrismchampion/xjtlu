# CSE313 Big Data Analytics Assessment 2

## Project

The purpose of this lab practice is to get you start using Hadoop. It provides a chance for you to experience how an analysis can be done on a computer cluster using advanced platform and programming model. You need to look at what we have done and simulate it to write, compile, debug MapReduce program (development phase) and execute a simple Hadoop Job on Cluster which deploys a Hadoop platform. You need writing MapReduce (Java) program in Eclipse and test/debug it, finally compile it to produce a Jar file. One you have a jar file for your job, you can submit your job to a Hadoop cluster (simulate) to get it run on the cluster and have your analysis results.  

## Tasks

You are given a dataset (pg100.txt, which is a book “THE SONNETS” by William Shakespeare), you are asked to write your own MapReduce program to accomplish the following task:

- Output only the top 10 most common bigram (pair of adjacent words) in the given dataset, what are they and how many appearances?
- Output only the lines that contain the word ‘torture’. 


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

1. Copy the text file from local storage to HDFS.

```$HADOOP_HOME/bin/hadoop fs -put workspace/Torture/pg100.txt```

2. Run the exported torture JAR file with text file specified in arguments.

```$HADOOP_HOME/bin/hadoop jar torture.jar edu.xjtlu.cse313.torture.Torture pg100.txt```

3. Display the MapReduce results contained in the output “part” file; sorted by line in alphabetical order. Corresponding line number displayed in column 2.

```$HADOOP_HOME/bin/hadoop fs -cat home/cloudera/cchamp17/part* | sort -n```

Output:

```
[cloudera@localhost ~]$ hadoop fs -cat home/cloudera/cchamp17/part* | sort -n

    All length is torture. Since the torch is out,	18811
    And torture him with grievous ling'ring death.	89153
    But purgatory, torture, hell itself.	195729
    By a sharp torture.	45325
    curses he shall have, the tortures he shall feel, will break the	246457
  Do in consent shake hands to torture me,	1293
    Drawn on with torture.	45457
  FIRST SOLDIER. He calls for the tortures. What will you say without	10329
    For torturers ingenious. It is I	46991
    From thee to die were torture more than death.	89471
  GEORGE. While we devise fell tortures for thy faults.	95267
    hand, to th' infernal deep, with Erebus and tortures vile also.	66211
    He may at pleasure whip or hang or torture,	17465
  IACHIMO. Thou'lt torture me to leave unspoken that	46827
    In leads or oils? What old or newer torture	243789
    I play the torturer, by small and small	179475
  Is't not enough to torture me alone,	4855
    Let hell want pains enough to torture me!	111615
    O happy torment, when my torturer	148315
    On pain of torture, from those bloody hands	191899
    On thy soul's peril and thy body's torture,	243199
  OTHELLO. If thou dost slander her and torture me,	172377
    O, torture me no more! I will confess.	89537
    Refuse me, hate me, torture me to death!	166279
  Rom. 'Tis torture, and not mercy. Heaven is here,	195751
    Say he be taken, rack'd, and tortured;	88565
  SHYLOCK. I am very glad of it; I'll plague him, I'll torture him; I	148195
  SHYLOCK. Out upon her! Thou torturest me, Tubal. It was my	148203
    Strange tortures for offenders, never heard of,	88049
    Than on the torture of the mind to lie	135863
    That same Berowne I'll torture ere I go.	131159
    That so her torture may be shortened.	84399
    then torture my wife, pluck the borrowed veil of modesty	154227
    The time, the place, the torture. O, enforce it!	175867
    This torture should be roar'd in dismal hell.	195463
    To torture thee the more, being what thou art.	189129
    Turning dispiteous torture out of door!	110457
    Which is our honour, bitter torture shall	46813
    Which to be spoke would torture thee.	46829
    With vilest torture let my life be ended.	7327
    You go about to torture me in vain.	86929
```