# Labs

## Week 1: Sep. 2 - Sep. 8, 2019

Can you implement for loops using only functions?

```forLoop(???, ???, ???);```

You are allowed to add helper classes. The forLoop() function must not contain for, while, do while statements.

Consider a simple case of getting the sum of the numbers in an array.


## Week 5: Oct. 7 - Oct. 13, 2019

Follow the official documentation and slides, re-create the music player.

An additional discussion about thread versus service is available: https://stackoverflow.com/questions/22933762/service-vs-thread-in-android

Read about foreground service, as they are involved with notifications.


## Week 6: Oct. 14 - Oct. 20, 2019

Use SharedPreferences to record:
- How many times your app has been launched (ie, the onCreate() method called).
- How many times your app has been shown on the screen (ie, the onStart() method called).

Build you own database to record contact information (left for you to practice after lab).


## Week 8: Oct. 28 - Nov. 3, 2019

Using ```SurfaceView```, draw a bouncing ball that keeps bouncing inside the SurfaceView area. You decide how the ball bounces.


## Week 10: Nov. 11 - Nov. 17, 2019

1. Try to collect gravity sensor data.
2. Test GPS location. 


## Week 11: Nov. 18 - Nov. 24, 2019

Server Sockets:
- On a real server, you should create a new thread to handle each ```Socket``` returned from ```accept()```.
- This allows your server to handle multiple client requests.

```
ServerSocket server = new ServerSocket(1024);
Socket socket = server.accept();
// create new thread and handle the connection.
```
