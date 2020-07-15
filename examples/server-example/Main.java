import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String args[]) {
        // This is a server
        int argc = args.length;

        if (argc != 1) {
            System.err.println("Usage: java Main <port number>");
            System.exit(1);
        }

        int port = Integer.parseInt(args[0]);

        System.out.println("I'm listening on port " + port + ".\nConnect to me and I'll tell you to go away!");

    try {
            ServerSocket serverSocket = new ServerSocket(port);

            while (true) {
                Socket clientSocket = serverSocket.accept();

                InputStream inStream = clientSocket.getInputStream();
                OutputStream outStream = clientSocket.getOutputStream();

                Channel channel = new Channel(inStream, outStream);

                channel.out.println("Go away!");
                channel.out.flush();
                channel.out.close();

                clientSocket.close();
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + port + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
