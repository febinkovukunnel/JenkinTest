import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by cufa-01 on 22/6/16.
 */
public class FileReceiverNew {
    public static void main(String[] arg){
        try{
            //we are creating the socket on port 1000
            ServerSocket server=new ServerSocket(8080);
            System.out.println("Server running...");
            Socket socket=server.accept();
            InputStream is=socket.getInputStream();
            FileOutputStream fos=new FileOutputStream("d:\\a1.txt");
            int ch=0;
            System.out.println("Storing received contents to d:\\a1.txt");
            while(true){
                ch=is.read();
                if(ch==-1)
                    break;
                fos.write(ch);
            }
            is.close();
            fos.close();
            System.out.println("Receive process completed");
        }

        catch(Exception e){
            e.printStackTrace();
    }
}
