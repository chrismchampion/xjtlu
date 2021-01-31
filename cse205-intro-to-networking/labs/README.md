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

## Goal: To introduce you to simple client/server socket programming with TCP in Python

References:
https://docs.python.org/3/tutorial/controlflow.html
https://docs.python.org/3/reference/expressions.html#in
https://docs.python.org/3/library/socket.html
https://docs.python.org/3/library/stdtypes.html?highlight=encode#str.encode
https://docs.python.org/3/library/stdtypes.html?highlight=rstrip#str.rstrip

There are two components of this lab, the client and the server.

The server should do the following:

1. Read in a file called “songList.txt” which contains a list of song titles, one per line. (see the sample songList.txt)
2. Store these song names in a list
3.  Create a listening socket on port 4567 and wait for incoming connections (see server.py starter code)
4. Receive incoming data, and check to see if the song is in your song list.
5. If you find it, send ‘y’ to the client.  If you don’t, send ‘n’
6. Close the socket.

The client should do the following:

1. Prompt the user to input a song name
2. Open a connection to the server on port 4567
3. Send the song name to the server
4. Receive the reply from the server (either y or n)
5. If the song was found, print “Song found”.  If not, print “Song not found”.