package asd;

// A Java program for a Server
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Server
{
    //initialize socket and input stream
    private Socket		 socket = null;
    private ServerSocket server = null;
    private DataInputStream in	 = null;
    private DataInputStream input = null;
    private DataOutputStream out	 = null;

    // constructor with port
    public Server(int port)
    {
        // starts server and waits for a connection
        try
        {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            // takes input from terminal
            input = new DataInputStream(System.in);

            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());

            // takes input from the client socket
            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            String line = "",line2="";
            Scanner s=new Scanner(System.in);
            // reads message from client until "Over" is sent
            while (!line2.equals("Over") && !line.equals("Over"))
            {
                try
                {
                    if(s.hasNext()){
                        line = input.readLine();
                        out.writeUTF(line);
                        out.flush();
                    }
                    line2 = in.readUTF();
                    System.out.println(line2);

                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection");

            // close connection
            input.close();
            out.close();
            s.close();
            socket.close();
            in.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

    public static void main(String args[])
    {
        Server server = new Server(5000);
    }
}
