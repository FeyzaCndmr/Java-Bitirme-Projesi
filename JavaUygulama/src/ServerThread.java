
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread extends Thread {

    private Socket client;
    private Server serve;

    public ServerThread(Socket socket, Server server1) {
        this.client = socket;
        this.serve = server1;
    }

    @Override
    public void run() {
        try {
            InputStreamReader in = new InputStreamReader(client.getInputStream());
            BufferedReader br = new BufferedReader(in);
            PrintWriter print = new PrintWriter(client.getOutputStream());
            Scanner scanner = new Scanner(System.in);
            String userName = br.readLine();
            System.out.println("Kullanici :" + userName);

            //-----------------------------------------------------------------------
            String deger = "";

            BufferedReader okuyucu = new BufferedReader(new FileReader("C:\\Users\\KO 5\\Desktop\\makale.txt"));

            while ((deger = okuyucu.readLine()) != null) {

                print.println(deger);
                print.flush();

            }
            print.println(" ");
            print.flush();

            okuyucu.close();

            //-----------------------------------------------------------------------
            while (true) {
                String gelenVeri = br.readLine();
                System.out.println("Client : " + gelenVeri);
                if (gelenVeri.equals("bay")) {
                    System.out.println("Kullanici " + userName + " ayrildi");
                    client.close();
                    System.exit(0);
                }

                System.out.print("Gonder---->");
                String send = scanner.nextLine();
                print.println(send);
                print.flush();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
