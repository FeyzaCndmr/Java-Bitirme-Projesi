
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket client = new Socket("localhost", 3000);

        InputStreamReader isr = new InputStreamReader(client.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        PrintWriter print = new PrintWriter(client.getOutputStream());
        Scanner scanner = new Scanner(System.in);
        System.out.print("Kullanici adi girin: ");
        String userName1 = scanner.nextLine();
        print.println(userName1);
        print.flush();

        //---------------------------------------------
        ArrayList liste = new ArrayList<>();

        while (true) {
            String yazi = br.readLine();
            if (yazi.equals(" ")) {
                break;
            }
            liste.add(yazi);
        }
        Iterator itr = liste.iterator();
        while (itr.hasNext()) {
            Object obj = itr.next();
            System.out.println(obj);
        }

//----------------------------------------------------------------------------------------
        while (true) {
            System.out.print("Gonder----->: ");
            String gv = scanner.nextLine();
            print.println(gv);
            print.flush();
            if (gv.equals("bay")) {
                client.close();
                System.exit(0);
            }
            System.out.println("Server: " + br.readLine());
        }
    }
}
