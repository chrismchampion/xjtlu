# CSE202 Artificial Intelligence, Week 3, 2019

## Computer Exercise 1: Basics of Prolog

Open SWI-Prolog.
To create a database, you can click File ⟶ New
To make queries, you can click File → Consult
To quit prolog try <ctrl>+D.
If you get stuck in a loop and want to force a break <ctrl>+C gives you some options.

### Exercise 1. Create the following database and save it as eat.pl.
eats(fred,oranges). /* "Fred eats oranges" */ eats(fred,t_bone_steaks). /* "Fred eats T-bone steaks" */ eats(tony,apples). /* "Tony eats apples" */ eats(john,apples). /* "John eats apples" */ eats(john,grapefruit). /* "John eats grapefruit" */
Load the eat.pl from File → Consult. Then make the following queries:
?- eats(fred,oranges). ?- eats(john,apples). ?- eats(mike,apples). ?- eats(fred,apples).
Understand the queries and the results from Prolog.

### Exercise 2. Download the family tree program (familyTree.pl) from ICE.
Load the familyTree.pl from File → Consult. Then make the following queries:
parent(ian,lucy). parent(ian,pauline). parent(cathy,peggy). female(peggy). female(lisa).

Try some queries of your own.

### Exercise 3. Formulate queries to find
(a) all the children of ian;
(b) all the parents of ian;
(c) all the males;
(d) all the people who are parents.
Remember typing ; gives you further solutions (if there are any). Note _ can be used as an anonymous variable, i.e. you won’t get any answers for it.

### Exercise 4. Add to the family tree facts such as peggy is the parent of phil and grant (note you require two rules to do this); phil and cathy are parents of ben; lisa is the parent of louise; peggy, lisa and louise are female; phil, grant, and ben are male. Note you must save and reload the family tree program after you have finished. Try some of the queries you tried in Exercise 2 to see whether you get the same answer. Why do we get a different answer for the following queries?
female(peggy). parent(lisa,louise).

### Exercise 5. Given the database below:
likes(john,mary). likes(john,trains). likes(peter,fast_cars). likes(Person1,Person2):- hobby(Person1,Hobby), hobby(Person2,Hobby). hobby(john,trainspotting). hobby(tim,sailing). hobby(helen,trainspotting). hobby(simon,sailing).
Study the following queries. Indicate whether you think a particular query will succeed or fail by answer yes or nos. Then try to confirm your answers by using SWI-Prolog.
?- likes(john,trains) ?- likes(helen,john). ?- likes(tim,helen). ?- likes(john,helen).