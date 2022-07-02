import java.net.*;
import java.io.*;

public class Server
{
    private Socket		 socket = null;
    private ServerSocket server = null;
    private BufferedReader input = null;
    private DataInputStream in	 = null;
    private DataOutputStream out	 = null;
    String line=null;
    public Server(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ...");

            socket = server.accept();
            System.out.println("Client accepted");

            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));
            input = new BufferedReader(new InputStreamReader(System.in));

            out = new DataOutputStream(socket.getOutputStream());

        } catch(IOException u)
        {
            System.out.println(u);
        }
        line = "";
    }
    public void odbieraj(){
        while (!line.equals("Over")) {
            try {
                line = in.readUTF();
                System.out.println("Client:"+line);
            } catch (IOException e) {
                System.out.println(e);
                break;
            }
        }
        try
        {
            in.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
    public void wysylaj(){
        while (!line.equals("Over")) {
            try {
                    line = input.readLine();
                    out.writeUTF(line);

            } catch (IOException i) {
                System.out.println(i);
                break;
            }
        }
        try {
            input.close();
            out.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    public static void main(String[] args)
    {
        Server server = new Server(5000);
        Thread thread1 = new Thread() {
            public void run() {
                server.odbieraj();
            }
        };
        Thread thread2 = new Thread() {
            public void run() {
                server.wysylaj();
            }
        };
        thread1.start();
        thread2.start();
    }
}
