package ie.atu.sw;

import java.io.*;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

public class ChatClient {

    public static void main(String[] args) throws IOException {
        System.out.println("Chat Client Booting UP...");

        try {
            InetAddress serverAddress = InetAddress.getByName("127.0.0.1");
            int port = 8080;
            Socket socket = new Socket(serverAddress, port);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Enter first message: ");
            String message = stdIn.readLine();
            out.println(message);
            System.out.println("Message sent ✓︎");

            String serverResponse = in.readLine();
            System.out.println("Received from server: " + serverResponse);

            while (true) {
                System.out.print("Enter message: ");
                String userInput = stdIn.readLine();
                if (userInput.equals("\\q")) {
                    break;
                }
                out.println(userInput);
                System.out.println("Message sent ✓︎");
                serverResponse = in.readLine();
                System.out.println("Received from server: " + serverResponse);
            }

            socket.close();

        } catch (ConnectException e) {
            System.out.println("Unable to connect to the server. Please make sure the server is running and try again.");
        } catch (SocketException e) {
            System.out.println("The connections seems to have been reset. Please reboot chat client. ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
