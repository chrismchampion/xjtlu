import java.io.*;
import java.net.*;

public class EchoServer
{
   // the server socket:
   private static ServerSocket ss;

   // set when shutDown() is called to stop the server:
   private static boolean shutDownCalled = false;

   // shut the server down by closing the server socket
   public static void shutDown()
   {
      // flag that the server socket has been closed
      shutDownCalled = true;

      try 
      {
         ss.close();
      }
      catch (Exception e)
      {
         // something went wrong; give data:
         System.err.println("problem shutting down:");
         System.err.println(e.getMessage());
         // and trust the JVM to clean up:
         System.exit(1);
      }
   }

   private static void handleSession(Socket client)
   {
      BufferedReader in = null;
      PrintWriter out = null;

      try 
      {
         in = new BufferedReader
                  (new InputStreamReader(client.getInputStream()));
         out = new PrintWriter
                   (new OutputStreamWriter(client.getOutputStream()));

         out.println("Hello! Enter BYE to exit.");
         out.flush();

         String line;
         boolean done = false;
         while (!done)
         {
            line = in.readLine();
 
            if ((line == null)
                || (line.equals("BYE")))
               done = true;
            else if (line.equals("skasmos"))
            {
               shutDown();
               return;
            }
            else
            {
               System.out.println("Got: " + line);
               out.println("Echo: " + line);
               out.flush();
            }
         }
      }
      catch (IOException e)
      {
      }
      finally
      {
         try 
         {
            in.close();
         }
         catch(IOException e)
         {
         }
         if (out != null)
         {
            out.close();
         }
         if (client != null)
         {
            try 
            {
               client.close();
            }
            catch (IOException e)
            {
            }
         }
      }
   }

   public static void main(String[] args ) 
   {
      Socket incoming;

      try 
      {
         ss = new ServerSocket(8189);

         while (true)
         {
            incoming = ss.accept();

            handleSession(incoming);
         }
      }
      catch (SocketException se)
      {
         /*
          * will be thrown when accept() is called after closing
          * the server socket, in method shutDown().
          * If shutDownCalled, then simply exit; otherwise,
          * something else has happened:
          */
         if (! shutDownCalled)
         {
            System.err.println("socket problem:");
            System.err.println(se.getMessage());
            System.exit(1);
         }
      }
      catch (IOException ioe)
      {
         System.err.println("I/O error:");
         System.err.println(ioe.getMessage());
         System.exit(1);
      }
      finally
      {
         if (ss != null)
         {
            try 
            {
               ss.close();
            }
            catch (Exception e)
            {
               System.err.println("closing: " + e.getMessage());
            }
         }
      }
   }
}
