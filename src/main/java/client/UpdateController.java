package client;

import clientserverdata.Reply;
import consolehandler.TableController;
import controllers.data.TableFiller;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Arrays;

public class UpdateController implements Runnable {
    @Override
    public void run() {

        DatagramSocket updaterSocket = null;
        
        try {
            updaterSocket = new DatagramSocket(ClientController.getPort()+1);
            updaterSocket.setSoTimeout(0);

            while(true) {

                DatagramPacket fromServer = new DatagramPacket(new byte[1024], 1024);

                updaterSocket.receive(fromServer);

                Receiver receiver = new Receiver();
                Reply update = Serializer.deserialize(receiver.getReply(updaterSocket,true));

                if (update != null){
                    TableController.getCurrentTable().setTable(update.getProducts());
                }

                System.out.println("Table updated");
                TableFiller.fill();
            }
        } catch (SocketException e) {
            System.out.println("Troubles with updater.");
        } catch (IOException e) {
            
            e.printStackTrace();
            run();
        }
        finally {
            updaterSocket.close();
        }
    }

}
