# CSE210 Advanced Object Oriented Programming Coursework 2019
##### Release date: 11th, Mar, 2019 | Deadline: 12:00PM, 23rd, Apr, 2019

## 1. Description
The objective of the coursework is to develop a practical application for data processing, analysis and content search based on the object-oriented principles you learn from the CSE210 module. 

### 1. 1. Dataset 
The coursework uses a subset of the dataset (file name: twitterDataset.xlsx) published at http://followthehashtag.com/. It contains 204,820 short messages (tweets) collected from Twitter (https://twitter.com), during the period of 14-16, April, 2016, from various locations in the United States. The dataset contains many different topics, e.g., weather, leisure, sports, etc.

The dataset is stored in an EXCEL file and needs to be processed from your Java program. Each record (row) contains information about a tweet. The columns are explains as follows. 
•	Tweet Id – the ID of a tweet
•	Date – the date on which a tweet is published
•	Hour – the time when a tweet is published
•	User Name – name of a user
•	Nickname – nickname of a user
•	Tweet content – the actual message
•	Favs – number of users who like the tweet
•	RTs – number of users who re-tweet the tweet (republish)
•	Latitude – latitude of the location where a tweet is published
•	Longitude – longitude of the location where a tweet is published
•	Followers – number of followers of a user (the values are the same for the same user) = NOT TRUE; the value changes over time

### 1. 2. Data Processing and Analysis
To process data stored in an EXCEL file, you can use the Apache POI (the Java API for Microsoft Documents) library. The API is available at:
https://poi.apache.org/download.html#POI-3.17 

You need to download it and put it into your classpath in order to use it. A tutorial on how to use the library is at:
http://poi.apache.org/spreadsheet/quick-guide.html#CellContents 

You need to write code to extract data from the dataset and then perform some simple data analysis, e.g., find who the top users are. The detailed requirements are explained in Section 2.


### 1. 3. Content Search
Effective tweet searching is an important functionality for users, especially when there are millions of tweets published in each single day. The search process takes a user’s input keyword as a query and then retrieves relevant tweets. Two simple searching strategies are considered.

1.	Text matching – The idea is to find tweets based on matching the user’s keyword (only one word) with all the tweets. A tweet is regarded as relevant if the keyword appears in it. This is a basic feature of the application.
2.	Full text search – This is considered as an advanced feature of the application. To simplify the problem, you do NOT need to study the techniques in the field of Information Retrieval. According to the research reported in [1], the full text search functionality on Twitter is based on a modified version of the Apache Lucene API. However, the actual full text search on Twitter is extremely complicated. This coursework only attempts to build a much simpler full text search engine based on the original Lucene API, only for limited amount of Twitter data. Lucene can be downloaded at: https://lucene.apache.org/core/. A tutorial is available here: https://lucene.apache.org/core/7_7_1/demo/overview-summary.html. 

### 1.4. Objects in the Application
It is important to follow good object-oriented programming principles and practice, e.g., object modelling, functionality decomposition, code reuse. At the same time, you need to ensure correctness and take robustness and efficiency into account. 

You need to design a number of information objects to represent the objects together with the methods for this application. You need to design a number of helper classes in order to realise the functionalities. A separate class for testing purposes is also needed. Below is an example about the objects for this coursework; however, you can have your own design following good programming practice and style.
•	Tweet – represents a tweet message;
•	User – represents a user of the Twitter.
•	LinkedList – represents a list of (sorted) objects.
•	Utility and helper classes – as needed for data processing, analysis, and content search.
•	Test class – for testing the implemented functionalities.

## 2. Requirements and Tasks
You need to complete the following tasks. 
•	T1: develop information objects and helper classes (with their methods) needed for this application with good coding style, and design an easy-to-use interface for testing (command window is enough).
•	T2: efficiency and robustness (assessed during program testing).
•	T3: complete the following tasks which will be checked and marked during the demonstration sessions. 
Note: FAILING TO PRESENT AT THE DEMONSTRATION SESSION WILL RESULT IN ZERO MARK FOR THE DEMONSTRATION PART (SEE MARKING SCHEME).
•	T3-1: load data in the program.
•	T3-2: print top 10 tweets. Tweets should be ranked based on the sum of: (1) number of users who like the tweet (Favs), and (2) number of users who re-tweet the tweet (RTs). Relevant information, such as when, and by whom it is published, should also be shown.
•	T3-3: print top 10 users. Users should be ranked based on the number of followers that they have.
•	T3-4: tweet search based on string matching.
•	T3-5: tweet search based on full text searching using Lucene.
•	T4: use Javadoc comments to document your codes and generate HTML javadoc.
•	T5: demonstrate your work in the same order as specified in the lab group file (note that the time for each demonstration varies and you probably need to wait a bit longer than expected). You might be asked to modify your code during the demonstration (to detect plagiarism). The ability to modify code is measured in percentage and marks for demonstration will be scaled. Being able to modify code according to requirements will get 100%, not able to modify anything (will report for potential plagiarism) will get 0%. Other cases will be considered accordingly. Feedback will be provided during the demonstration if possible.

## 3. Deliverables
You should deliver ONE FILE (via ICE) according to the following description.
•	All source codes, compiled classes and any other supplementary files regarded necessary.
•	HTML documentation. This can be generated by using either the javadoc utility or the plug-in in your IDE.
•	A separate README file explaining how to run your code, e.g., path for the dataset, how to install external libraries, and how to test all the functionalities.
•	DO NOT include the external APIs and the original dataset in your submission as the size will exceed the limit on ICE.
•	Submit all the source codes, compiled classes, documentation and any supplementary files regarded necessary, in ONE ZIPPED FILE. 

After demonstrating your application, you will be asked to submit a test sheet printed on papers. 

Note: the formal procedure for submitting coursework at XJTLU is strictly followed.

## 4. References 
[1] Busch, M., Gade, K., Larson, B., Lok, P., Luckenbill, S., & Lin, J. (2012, April). Earlybird: Real-time search at twitter. In 2012 ieee 28th international conference on data engineering (pp. 1360-1369). IEEE.



## Importing the project into Eclipse

1. Unzip archive file 1719247_CSE210_CW1_Final.zip
2. Create a new project
3. File > Import > File System

- From directory:
  - Select unzipped archive file directory to import from: 1719247_CSE210_CW1_Final
- Into folder:
  - Select newly created project's src folder.
- Click Finish.

4. Add .jar referenced libraries to classpath.
5. Add twitter dataset .xlsx file path to main(String args) arg[0].

## Marking Guidelines Classification
- A first-class solution (70+%) will meet all these requirements fully; 
- A 2.I solution (60-69%) will meet most but perhaps not all of these requirements (e.g., the code may not quite implement all the desired functionality, or may lack comments, or have an untidy layout); 
- A 2.II solution (50-59%) will probably have some more serious faults (e.g., the code may fall some way short of all the desired functionality, or may contain syntactic errors); 
- A third-class (40-49%) solution will have serious faults, though it should still show that a decent attempt was made (e.g., code that falls further short of being functional - though it still shouldn't be too far away). 
- A solution getting a failing grade will simply be bad. 
- Failure to hand in a solution or plagiarised work will get a zero grade.

## Marking Sheet

<table>
  <tr>
    <th colspan="2">Component</th>
    <th>Description</th>
    <th>Weight</th>
  </tr>
  <tr>
    <td>Code design with good style and practice</td>
    <td>Task 1</td>
    <td>object orientation, source code, functional decomposition, exception handling,  data structures</td>
    <td>15%</td>
  </tr>
  <tr>
    <td rowspan="7">Implementation and demonstration</td>
    <td>Task 2</td>
    <td>efficiency and robustness, code execeution during demonstration</td>
    <td>15%</td>
  </tr>
  <tr>
    <td>Task 3-1</td>
    <td>data loading</td>
    <td>10%</td>
  </tr>
  <tr>
    <td>Task 3-2</td>
    <td>top 10 tweets</td>
    <td>10%</td>
  </tr>
  <tr>
    <td>Task 3-3</td>
    <td>top 10 users</td>
    <td>10%</td>
  </tr>
  <tr>
    <td>Task 3-4</td>
    <td>search via string matching</td>
    <td>10%</td>
  </tr>
  <tr>
    <td>Task 3-5</td>
    <td>full text search</td>
    <td>15%</td>
  </tr>
  <tr>
    <td>code modification (Task 5)</td>
    <td>see notes below</td>
    <td>-</td>
  </tr>
  <tr>
    <td>Documentation</td>
    <td>Task 4</td>
    <td>proper javadoc</td>
    <td>15%</td>
  </tr>

</table>

> NOTE: (1) rating is on scale 0-5; (2) ability to modify code measured in %. Marks for demonstration will be scaled by the %. Being able to modify code according to requirements gets 100%, not able to modify anything (will report for potential plagiarism) will get 0%. Other cases will be considered accordingly.



# CSE210 Coursework 2019 Console Output
April 30, 2019

Name: Christopher Champion

TASK T3-1: Load data in the program:

Accessing file /Users/christopher/Downloads/CSE210_CW_twitterDataset.xlsx
Processing spreadsheet...

Sheet name: Stream
Data set parse time: 7201ms

1.	Print All Tweets
2.	Print Top Tweets
3.	Print Top Users
4.	Keyword Search
5.	Full-text Search (Lucene)
6.	Quit

TASK T3-2: Print top 10 tweets:

Please choose an option (Enter 0 for menu): 
2
Please enter number of tweets (default 10): 

-----------------TOP 10 TWEETS-----------------
	USER                 DATE                 HOUR       FAVS       RT         MESSAGE   
1.	MALUMA               2016-04-16           02:46      2089       449        Y DELE 💪🏻💪🏻💪🏻... Viernes por la noche sin excusa alguna!! @ Mexico City, Mexico https://t.co/IpwfZqAtiu
2.	MALUMA               2016-04-15           23:37      2006       425        Hoy me dieron esta sorpresa en @Estacanon un programa de televisión increíble donde me llevaron… https://t.co/8CPPV1V9vu
3.	MALUMA               2016-04-14           21:58      1847       426        AGRADECER... Regla #1!! Gracias a los medios de comunicación por creer en mí y sacar un rato de… https://t.co/DmE2uDh6Yx
4.	MALUMA               2016-04-15           15:55      1576       373        😇😈 @ Mexico City, Mexico https://t.co/8I2GyzaVWL
5.	MALUMA               2016-04-15           14:26      1550       313        "MEDALLO PARAÍSO" nueva colección amelissaenlinea ya tienen la suya?? @ Mexico City, Mexico https://t.co/Jqxh5dHI5y
6.	Charlotte Ross       2016-04-16           00:29      853        499        Do I look bloated? 😊 @amellywood &amp; @echok have inspired me to try snapchat... 🙆 @ Mulholland… https://t.co/V7lTzfGWYz
7.	Tanya Burr           2016-04-15           17:22      477        103        I'm snapchatting all day at Coachella so add me - 'tanyaburr' 👻 @ Palm Springs, California https://t.co/ttxMJJ3iIM
8.	MALUMA               2016-04-14           10:36      356        70         Batman o SuperMan? @ Miami International Airport MIA International Departures https://t.co/bh0uitZ9Yv
9.	Alfredo Flores       2016-04-16           01:54      243        153        Ya boy has arriveeddddd 😝🤘🏽 #coachella @ La Quinta, California https://t.co/hpiam3nYYy
10.	Fran                2016-04-16           00:58      237        100        Prom &amp; dodger game tonight w/my lover 😻💙 https://t.co/mMOCZGokjy

TASK T3-2 (demo addendum): Print top 20 tweets:

Please choose an option (Enter 0 for menu): 
2
Please enter number of tweets (default 10): 
20
-----------------TOP 20 TWEETS-----------------
	USER                 DATE                 HOUR       FAVS       RT         MESSAGE   
1.	MALUMA               2016-04-16           02:46      2089       449        Y DELE 💪🏻💪🏻💪🏻... Viernes por la noche sin excusa alguna!! @ Mexico City, Mexico https://t.co/IpwfZqAtiu
2.	MALUMA               2016-04-15           23:37      2006       425        Hoy me dieron esta sorpresa en @Estacanon un programa de televisión increíble donde me llevaron… https://t.co/8CPPV1V9vu
3.	MALUMA               2016-04-14           21:58      1847       426        AGRADECER... Regla #1!! Gracias a los medios de comunicación por creer en mí y sacar un rato de… https://t.co/DmE2uDh6Yx
4.	MALUMA               2016-04-15           15:55      1576       373        😇😈 @ Mexico City, Mexico https://t.co/8I2GyzaVWL
5.	MALUMA               2016-04-15           14:26      1550       313        "MEDALLO PARAÍSO" nueva colección amelissaenlinea ya tienen la suya?? @ Mexico City, Mexico https://t.co/Jqxh5dHI5y
6.	Charlotte Ross       2016-04-16           00:29      853        499        Do I look bloated? 😊 @amellywood &amp; @echok have inspired me to try snapchat... 🙆 @ Mulholland… https://t.co/V7lTzfGWYz
7.	Tanya Burr           2016-04-15           17:22      477        103        I'm snapchatting all day at Coachella so add me - 'tanyaburr' 👻 @ Palm Springs, California https://t.co/ttxMJJ3iIM
8.	MALUMA               2016-04-14           10:36      356        70         Batman o SuperMan? @ Miami International Airport MIA International Departures https://t.co/bh0uitZ9Yv
9.	Alfredo Flores       2016-04-16           01:54      243        153        Ya boy has arriveeddddd 😝🤘🏽 #coachella @ La Quinta, California https://t.co/hpiam3nYYy
10.	Fran                2016-04-16           00:58      237        100        Prom &amp; dodger game tonight w/my lover 😻💙 https://t.co/mMOCZGokjy
11.	Tanya Burr           2016-04-15           17:03      188        50         Morning at the pool before the Coachella madness begins ☀️🌴👙💦 @ Avalon Hotel Palm Springs https://t.co/eK1SFQSuiN
12.	Chuck Comeau         2016-04-15           17:01      172        51         I love being on tour and doing the post-game Pizza Parties so much that I decided to throw my… https://t.co/Z4lzHxRcaP
13.	Tanya Burr           2016-04-16           00:04      165        37         💗 @ Parker Palm Springs https://t.co/A2GQZ7ITnP
14.	CHA CHA MALONE       2016-04-16           10:29      94         64         Ran into Tablo ☝🏾️언제 #AOMG #highground @ Los Angeles, California https://t.co/IQ5QGNxAyg
15.	Yo Gotti             2016-04-15           17:20      83         74         Let's Talk Money💰&amp; OWNERSHIP... @ Manhattan, New York https://t.co/hek7XpyCdr
16.	GOMITA               2016-04-14           23:25      110        39         Ya pueden comprar los producgos de mi querido campeon @chiquitaglz Entren a su pag de face… https://t.co/hPdyBHlg8g
17.	Ferny Graciano       2016-04-14           23:21      101        24         #jorgeayalaparis #MBFWMx Love it ❤️@ay_astudio @ Auditorio BlackBerry https://t.co/o3AMGTUrsT
18.	Nick Mara            2016-04-14           16:45      93         23         TURNT!!!😎.....still pissed I didnt fully land it @ North Hollywood, California https://t.co/SqQOVyopvZ
19.	Willam               2016-04-16           01:06      100        12         Please be honest and comment which Drag Race girl this looks. Tag her in fact. Yknow for fun. @… https://t.co/jmni1fLqvR
20.	WEREVERTUMORRO       2016-04-16           05:47      96         14         Last night!! @ La Santa Puerto Vallarta https://t.co/pvabr9lOGI

TASK T3-3: Print top 10 users:

Please choose an option (Enter 0 for menu): 
0

1.	Print All Tweets
2.	Print Top Tweets
3.	Print Top Users
4.	Keyword Search
5.	Full-text Search (Lucene)
6.	Quit

Please choose an option (Enter 0 for menu): 
3
Please enter number of users (default 10): 

-----------------TOP 10 USERS-----------------
	USER NAME            ALIAS                FOLLOWERS  DATE      
1.	werevertumorro       WEREVERTUMORRO       7232508    2016-04-16
2.	joelmchale           Joel McHale          3804447    2016-04-15
3.	questlove            Questlove Gomez      3627124    2016-04-14
4.	itsgabrielleu        Gabrielle Union      3043036    2016-04-15
5.	AlfredoFlores        Alfredo Flores       2742081    2016-04-16
6.	maluma               MALUMA               2525716    2016-04-16
7.	MatthewZiff          Matthew Ziff         2139467    2016-04-15
8.	PraFeBrum            Fernanda Brum        2128396    2016-04-16
9.	maxenemagalona       Maxene Magalona      2031713    2016-04-15
10.	iamdelafuente        CristiandelaFuente   1965579    2016-04-16

TASK T3-3 (demo addendum): Print top 20 users:

Please choose an option (Enter 0 for menu): 
3
Please enter number of users (default 10): 
20
-----------------TOP 20 USERS-----------------
	USER NAME            ALIAS                FOLLOWERS  DATE      
1.	werevertumorro       WEREVERTUMORRO       7232508    2016-04-16
2.	joelmchale           Joel McHale          3804447    2016-04-15
3.	questlove            Questlove Gomez      3627124    2016-04-14
4.	itsgabrielleu        Gabrielle Union      3043036    2016-04-15
5.	AlfredoFlores        Alfredo Flores       2742081    2016-04-16
6.	maluma               MALUMA               2525716    2016-04-16
7.	MatthewZiff          Matthew Ziff         2139467    2016-04-15
8.	PraFeBrum            Fernanda Brum        2128396    2016-04-16
9.	maxenemagalona       Maxene Magalona      2031713    2016-04-15
10.	iamdelafuente        CristiandelaFuente   1965579    2016-04-16
11.	TanyaBurr            Tanya Burr           1813146    2016-04-16
12.	GarciaPosti          Luis García P        1703817    2016-04-15
13.	MariMoon             MariMoon             1603758    2016-04-15
14.	Mariobatali          Mario Batali         1485605    2016-04-15
15.	terrellowens         Terrell Owens        1464055    2016-04-15
16.	dankanter            Dan Kanter           1445033    2016-04-14
17.	YoGottiKOM           Yo Gotti             1405159    2016-04-15
18.	programa_hoy         Programa Hoy         1397688    2016-04-15
19.	AgentM               Ryan Penagos         1319425    2016-04-16
20.	flacaguerrerog       mariateresaguerrero  1282254    2016-04-16

TASK T3-4: String matching-based search:

Please choose an option (Enter 0 for menu): 
0

1.	Print All Tweets
2.	Print Top Tweets
3.	Print Top Users
4.	Keyword Search
5.	Full-text Search (Lucene)
6.	Quit

Please choose an option (Enter 0 for menu): 
4
Please enter a keyword: 
kia
720737114611179521   2016-04-14      22:14     lauraelizondo_                Una sportage para llevar, por fa. 🙄 (@ kia motors linda vista) https://t.co/MN3WY6JzhX                                                                                                                                                                                                                     
720735966739214336   2016-04-14      22:10     rudolphvergara                Aquí con el mal quedado Fernando (@ KIA Motors) https://t.co/OrKghpbeMR                                                                                                                                                                                                                                     
720683571913060352   2016-04-14      18:42     jasondumoulin                 Working. (@ Regal Kia in Lakeland, FL) https://t.co/kojZzsdq1a                                                                                                                                                                                                                                              
720655612686704640   2016-04-14      16:51     Smircy35                      Say hello to my new car Stella @ Motion KIA https://t.co/NPzF01isi3                                                                                                                                                                                                                                         
4 query results

TASK T3-5(1): Lucene-based full-text search:

Please choose an option (Enter 0 for menu): 
5
Please enter a text query: 
managing bmw munich
Found 20 hits.
720661413849653248   2016-04-14      17:14     ClassicBMW                    Finally! All new #BMW #M2 Coupe! @ Classic BMW https://t.co/iDsUs6Eg2F                                                                                                                                                                                                                                      
721007904090927107   2016-04-15      16:10     juliekiss4                    Our Munich office is gearing up for summer w/ fun activities: BBQ's, Soccer, Sailing &amp; more! #munich #lifeissweet https://t.co/4KC6ZjBmil                                                                                                                                                               
721007903549833217   2016-04-15      16:10     LifeAtSugar                   Our Munich office is gearing up for summer w/ fun activities: BBQ's, Soccer, Sailing &amp; more! #munich #lifeissweet https://t.co/H4jL6RVuYJ                                                                                                                                                               
721317026313146369   2016-04-16      12:39     Mike_Tag                      #vt #waterburycentervt #bmw @bmwusa bmw #bmw3 #bmw3gt #bmwnation #bmwowner #bmw3seriesgt… https://t.co/ScDuyI6kuq                                                                                                                                                                                           
721317873197715457   2016-04-16      12:42     Mike_Tag                      #bmw #bmw3 #bmw3gt #bmwusa #bmwstories #bmwlife #bmwusa #bmwgram #bmwaddict @bmwusa bmw… https://t.co/LlVbYs3nOl                                                                                                                                                                                            
721154840114655232   2016-04-16      01:54     pcray71                       Drinking a Munich Dunkel by @BlueStallionBC at @bluestallionbc — https://t.co/mXLekhWGxX #photo                                                                                                                                                                                                             
720771427872313344   2016-04-15      00:31     87MrATK05                     At Santa Monica BMW — https://t.co/XFhfgxaY6F                                                                                                                                                                                                                                                               
721071103523860480   2016-04-15      20:22     discohirokun                  Enjoying a Paulaner Original Münchner Hell / Premium Lager / Munich Lager — https://t.co/UwGedgcFzh                                                                                                                                                                                                         
721026427760476161   2016-04-15      17:24     brandeelee7                   Managing #goBuckeye Downtown Columbus bus tours on this gorgeous… https://t.co/RXhTU8n8ii                                                                                                                                                                                                                   
721200748348973057   2016-04-16      04:57     BrandonkimBMW                 Just posted a photo @ Irvine BMW https://t.co/9huuSsiMem                                                                                                                                                                                                                                                    
720777160739434496   2016-04-15      00:54     beautygazette                 Say hello to Julia Managing  partner  @bandellettes #bandelettessummersoiree @ Apella, Event… https://t.co/8K9Mb2IBw3                                                                                                                                                                                       
721047969030660097   2016-04-15      18:50     BDogBrewWorks                 Bristol Bound, Baby! P... (Paulaner Original Münchner Hell / Premium Lager / Munich Lager) https://t.co/seGf9UDV0o #photo                                                                                                                                                                                   
721165441490690048   2016-04-16      02:36     defajardo                     #friday #ride #bmw #s1000r @ State College, Pennsylvania https://t.co/agnvfExsIZ                                                                                                                                                                                                                            
721095033999503361   2016-04-15      21:57     ClassicBMWPlano               alpinaautomobiles dinancars #b6Alpina #classicbmw #planobmw @ Classic BMW https://t.co/TO8BP9HfXe                                                                                                                                                                                                           
720779238564106240   2016-04-15      01:02     cafesoleilphoto               #fancy #shiny #bmw #filming? @ South Pasadena, California https://t.co/r7sVgZEHoD                                                                                                                                                                                                                           
721119247624237060   2016-04-15      23:33     RinckelL                      I'm a proud German, an... (Paulaner Original Münchner Hell / Premium Lager / Munich Lager) https://t.co/x29ivp2hlN #photo                                                                                                                                                                                   
720834394945028097   2016-04-15      04:41     breckbrewpub                  471 double IPA. Pale, Munich, Caramel-30 and Torricied Wheat malts with Chinook, Centenial,… https://t.co/siguebwdtz                                                                                                                                                                                        
720665734427254785   2016-04-14      17:31     laina1212                     At motorceptsinc waiting for my babe BMW @ Motorcepts https://t.co/moaZ409Aqj                                                                                                                                                                                                                               
720653959480918017   2016-04-14      16:44     tata1tati                     I'm at BMW Premium Used Cars in León https://t.co/1mPrxc0jmw                                                                                                                                                                                                                                                
720711541004218368   2016-04-14      20:33     tmj_rip_writing               #Providence, RI #Writing #Job: Managing Editor at Brown University https://t.co/ASj8HN5zpZ #Jobs #Hiring #CareerArc                                                                                                                                                                                         

TASK T3-5(2): Lucene-based full-text search:

Please choose an option (Enter 0 for menu): 
5
Please enter a text query: 
bmw
Found 20 hits.
720661413849653248   2016-04-14      17:14     ClassicBMW                    Finally! All new #BMW #M2 Coupe! @ Classic BMW https://t.co/iDsUs6Eg2F                                                                                                                                                                                                                                      
721317026313146369   2016-04-16      12:39     Mike_Tag                      #vt #waterburycentervt #bmw @bmwusa bmw #bmw3 #bmw3gt #bmwnation #bmwowner #bmw3seriesgt… https://t.co/ScDuyI6kuq                                                                                                                                                                                           
721317873197715457   2016-04-16      12:42     Mike_Tag                      #bmw #bmw3 #bmw3gt #bmwusa #bmwstories #bmwlife #bmwusa #bmwgram #bmwaddict @bmwusa bmw… https://t.co/LlVbYs3nOl                                                                                                                                                                                            
720771427872313344   2016-04-15      00:31     87MrATK05                     At Santa Monica BMW — https://t.co/XFhfgxaY6F                                                                                                                                                                                                                                                               
721200748348973057   2016-04-16      04:57     BrandonkimBMW                 Just posted a photo @ Irvine BMW https://t.co/9huuSsiMem                                                                                                                                                                                                                                                    
721165441490690048   2016-04-16      02:36     defajardo                     #friday #ride #bmw #s1000r @ State College, Pennsylvania https://t.co/agnvfExsIZ                                                                                                                                                                                                                            
721095033999503361   2016-04-15      21:57     ClassicBMWPlano               alpinaautomobiles dinancars #b6Alpina #classicbmw #planobmw @ Classic BMW https://t.co/TO8BP9HfXe                                                                                                                                                                                                           
720779238564106240   2016-04-15      01:02     cafesoleilphoto               #fancy #shiny #bmw #filming? @ South Pasadena, California https://t.co/r7sVgZEHoD                                                                                                                                                                                                                           
720665734427254785   2016-04-14      17:31     laina1212                     At motorceptsinc waiting for my babe BMW @ Motorcepts https://t.co/moaZ409Aqj                                                                                                                                                                                                                               
720653959480918017   2016-04-14      16:44     tata1tati                     I'm at BMW Premium Used Cars in León https://t.co/1mPrxc0jmw                                                                                                                                                                                                                                                
721162979065118720   2016-04-16      02:27     azrael429                     #driftingtheshitoutofshit #lbdrift #drifting #drift #bmw #m4 #smoketiresnotcrack @ Toyota Grand… https://t.co/i0MLteSlEC                                                                                                                                                                                    
721072026778214400   2016-04-15      20:25     _JayyMONEY                    #BMW #3series #FoamWash #CleaningUpAtlanta #WhosNext #illComeToYou #4044386282 @ The Twelve https://t.co/7H6Mfg08p0                                                                                                                                                                                         
720754873147506688   2016-04-14      23:25     abrahamreyes90                Zapatos nuevos :) (@ BMW Lindavista Motors in Azcapotzalco, Distrito Federal) https://t.co/SChFPjEugB                                                                                                                                                                                                       
721155840888201216   2016-04-16      01:58     TravelWedding                 I'm at Irvine BMW in Irvine, CA https://t.co/zdz7kra8fi https://t.co/sZmkr5f1Km                                                                                                                                                                                                                             
721093838731939841   2016-04-15      21:52     wosby                         Congratulations Leyal &amp; Cagdas on your new X5! @ BMW of Morristown https://t.co/0Fnpsf1Qn5                                                                                                                                                                                                              
721022103579979777   2016-04-15      17:07     KrysPhan                      Work Selfie Time!   #BMW #7series #750i #RBCHeritage #PGA #HiltonHeadSC #Octagon #8DaysAWeek @… https://t.co/yRaeAEELyy                                                                                                                                                                                     
721016966723592192   2016-04-15      16:46     streetcars2                   #windowtint #tires #lowered #custom #bmw #m5 #m3 #toyotires toyotires #memphis #streetcars… https://t.co/ZioXKiHlme                                                                                                                                                                                         
721010915093585920   2016-04-15      16:22     brianiannone                  Oh, Friday's... 😄 #rayban #aviators #bmw #friday #santamonica @ Santa Monica, California https://t.co/JmwjtqaKo6                                                                                                                                                                                           
720591383325773825   2016-04-14      12:35     KrysPhan                      Day 3 of 7 #RBCHeritage #BMW #8DaysAWeek @ Harbour Town Golf Links https://t.co/qGa3CHHIa8                                                                                                                                                                                                                  
721147206644969472   2016-04-16      01:24     singersteven                  That gorgeous body! See them lines? #bmw @ Home of S&amp;S https://t.co/kDLtCs8MAi                                                                                                                                                                                                                          
Please choose an option (Enter 0 for menu): 
0

1.	Print All Tweets
2.	Print Top Tweets
3.	Print Top Users
4.	Keyword Search
5.	Full-text Search (Lucene)
6.	Quit

Please choose an option (Enter 0 for menu): 

END OF CONSOLE OUTPUT