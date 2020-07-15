import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String args[]) {
        // This is a client trying to connect to a server
        int argc = args.length;
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        Channel channel = new Channel(host, port);
        channel.out.println("Hello netcat. This is client!");
        channel.out.flush();
    }
}
