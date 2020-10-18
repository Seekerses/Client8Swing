package client;

import clientserverdata.Reply;
import consolehandler.TableController;

import java.awt.*;
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
            DatagramSocket finalUpdaterSocket = updaterSocket;
            new Thread(() -> {
                listenToUpdates(finalUpdaterSocket);
            }).start();
        } catch (SocketException e) {
            System.out.println("Troubles with updater.");
        }
    }

    private void listenToUpdates(DatagramSocket updaterSocket){
        try {
            while (true) {

                DatagramPacket fromServer = new DatagramPacket(new byte[1024], 1024);

                updaterSocket.receive(fromServer);

                Receiver receiver = new Receiver();
                Reply update = Serializer.deserialize(receiver.getReply(updaterSocket, true));

                if (update != null) {
                    TableController.getCurrentTable().setTable(update.getProducts());
                }

                System.out.println("Table updated");
                if (UserSession.getMainWindow() == null){
                    new Thread(() ->{
                        while (UserSession.getMainWindow() == null){}
                        EventQueue.invokeLater(() -> {
                            UserSession.getMainWindow().reDraw();
                        });
                    }).start();
                }
            }
        }catch (IOException ex){
            System.out.println("Troubles with updater. Updater will restart...");
            run();
        }
        finally {
            updaterSocket.close();
        }
    }

}

