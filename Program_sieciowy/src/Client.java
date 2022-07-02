import java.net.*;
import java.io.*;

public class Client
{
    private Socket socket		 = null;
    private BufferedReader input = null;
    private DataInputStream in	 = null;
    private DataOutputStream out	 = null;
    String line = null;
    public Client(String address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            input = new BufferedReader(new InputStreamReader(System.in));

            in = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream()));

            out = new DataOutputStream(socket.getOutputStream());

            line = "";
        } catch(IOException u)
        {
            System.out.println(u);
        }
    }

    public void odbieraj(){
        while (!line.equals("Over")) {
            try {
                line = in.readUTF();
                System.out.println("Server:"+line);
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
        Client client = new Client("127.0.0.1", 5000);
        Thread thread1 = new Thread() {
            public void run() {
                client.odbieraj();
            }
        };
        Thread thread2 = new Thread() {
            public void run() {
                client.wysylaj();
            }
        };
        thread1.start();
        thread2.start();
    }
}
