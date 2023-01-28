import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        String host = "netology.ru";
        int port = 8081;
        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new
                     PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new
                     InputStreamReader(clientSocket.getInputStream()))) {
            out.println("GET / HTTP/1.1\n" +
                    "Host: netology.ru\n\n\n");
            String resp = in.readLine();
            System.out.println(resp);

            InetAddress inetAddress = InetAddress.getByName(host);
            System.out.println(host + ", ip address: " +
                    inetAddress.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
