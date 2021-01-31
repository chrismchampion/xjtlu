# Lab 1

Your first lab assignment is to use these basic constructs to write a short program that computes N! (Remember this is N*(N-1)*(N-2)…*1)

- Use loops, not math.factorial()
- If the result is even, print “Yay, even”.
- If it’s odd, print “Boo, odd”.
- You don’t need to write a function, just a simple script. Use a variable for N and your TA will tell you what N to use.

When you’re done, demonstrate your working program to the TA. **Note: this is an individual assignment.  You cannot receive help from other students, only your TA.**

# Lab 2

Your assignment this week is to write a short function that takes a list and a search value as parameters.

- Using a loop (covered last week), search the list to see if it contains the search value (you must use a loop here…)
- If the search value is found, print “search value found” and return the list index (0 to N-1, where N is the number of list elements) where it is found.
- If it is not found, print “not found” and return N
- See the comments at the end of the example Python code to see how it should be called

# Lab 3

Your assignment is to write a Python function that takes a search phrase and a file name as parameters.

- Your function should read in the file and search it for the search phrase.
- If you find the phrase, you should print the line # and the position in the line where you found it.
- Your search should be case insensitive (for example, Cat, cAT, Cat, etc all match the phrase “cat”
- You should also handle the case where punctuation follows the phrase.  For example, “cat” should match “cat.” or “cat,”.
- You might want to scan the page I gave you on regular expressions for ideas.

# Lab 4 & 5

You need to write a client and server to implement the following protocol with TCP sockets:

- Upload a file from the client to the server
  - Client sends: UPLOAD <filename> <sizeInBytes>\r\n <dataInBinary>
  - File name should not contain spaces or special characters, but may contain a “.”
  - Server replies with UPLOAD OK\r\n after it receives the data and saves it to a file with the given name.

- Download a file from the client to the server
  - Client sends: DOWNLOAD <filename>\r\n
  - Servers replies: SEND <sizeInBytes>\r\n <dataInBinary>
  - Server replies: NOT FOUND\r\n
  - No client reply. Client saves file with name given.