import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        Server serve = new Server();
        serve.execute(); 
    } 
    public void execute() throws IOException {       
            ServerSocket server = new ServerSocket(3000);
            System.out.println("3000 nolu port dinleniyor");
            Socket client = server.accept();
            System.out.println("Yeni kullanici baglandi");           
            new ServerThread(client,this).start();    
    }
}


