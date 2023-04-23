package Chat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;


public class ChatServer {
    ServerSocket serverSocket;
    ArrayList<Client> clients = new ArrayList<>();
    ChatServer(){
        try {
            serverSocket = new ServerSocket(1234);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    void sendAll(String message){
        for (Client client : clients){
            client.receive(message);
        }
    }
    public void run() throws IOException {
        System.out.println("Waiting...");
        while (true) {
            try {

                // ждем клиента
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");
                clients.add(new Client(this, socket));
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws IOException {
        new ChatServer().run();

    }
}
class Client implements Runnable {
    Socket socket;
    Scanner in;
    PrintStream out;
    ChatServer server;
    public Client(ChatServer server,Socket socket) {
        this.socket = socket;
         this.server = server;
        new Thread(this).start();

    }
    void receive(String message){
        out.println(message);
    }
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            // создаем удобные средства ввода и вывода
            in = new Scanner(is);
            out = new PrintStream(os);

            // читаем из сети и пишем в сеть
            out.println("Welcome to Chat");
            String input = in.nextLine();
            while (!input.equals("bye")) {
                server.sendAll(input);
                input = in.nextLine();
            }
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}