import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Channel {
    public InputReader in;
    public PrintWriter out;

    Channel(String host, int port) {
        try {
            Socket socket = new Socket(host, port);

            InputStream inStream = socket.getInputStream();
            OutputStream outStream = socket.getOutputStream();

            this.in = new InputReader(inStream);
            this.out = new PrintWriter(outStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    Channel(InputReader in, PrintWriter out) {
        this.in = in;
        this.out = out;
    }
}
