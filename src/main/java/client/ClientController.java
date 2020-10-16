package client;

import clientserverdata.Reply;
import clientserverdata.Request;
import consolehandler.ClientInterpreter;
import consolehandler.CommandController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Arrays;

public class ClientController {

    private static DatagramSocket clientSocket = null;
    private static InetAddress destIP;
    private static Integer destPort;
    private static Integer port = null;
    private static InetAddress tempIP = null;
    private static Integer tempPort;

    static Reply handleRequest(Request request){
        byte[] serializedRequest = Serializer.serialize(request);
        assert serializedRequest != null;
        byte[] reply = null;
        try {
            sendRequestingHandshake();
            Sender.send(serializedRequest);
            Receiver receiver = new Receiver();
            reply = receiver.getReply(clientSocket);
        }
        catch(SocketTimeoutException e){
            try {
                reboot();
            } catch (SocketException ex) {
                ex.printStackTrace();
            }
            System.out.println("Server is not responding, please, try again later or change connection.");
            return null;
        }
        catch (IOException e){
            System.out.print("Oh no, some IO Exception occurs, please, try again.");
        }
        assert reply != null;
        return Serializer.deserialize(reply);
    }

    public static void reboot() throws SocketException {
        InetSocketAddress address = (InetSocketAddress) clientSocket.getLocalSocketAddress();
        clientSocket.close();
        clientSocket = new DatagramSocket(address);
    }

    public static boolean connect(){
        try {
            clientSocket = new DatagramSocket(port);
            clientSocket.setSoTimeout(5000);
            setDestIP("localhost");
            new Thread(new UpdateController()).start();
            Thread.sleep(1000);
            if(sendConnectingHandshake()){
                 System.out.println("Connection stabled.");
                 return true;
             }
             else {
                 clientSocket.close();
                 System.out.println("Connection failed. Please choose another port.");
             }

        }
        catch (SocketTimeoutException ex){
            clientSocket.close();
            System.out.println("Chosen server is not responding. Please try again...\n");
        }
        catch (BindException e){
            clientSocket.close();
            System.out.println("Your port already in use.");
        }
        catch (SocketException e){
            clientSocket.close();
            System.out.println("Port is unavailable.");
        } catch (IOException e) {
            clientSocket.close();
            System.out.println("Some IO errors occurs");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    private static boolean sendConnectingHandshake() throws IOException {
        byte[] buf = new byte[1024];
        buf[0] = 1;
        buf[1023] = 1;
        DatagramPacket packet = new DatagramPacket(buf, 0, 1024, ClientController.getDestIP(), ClientController.getDestPort());
        clientSocket.send(packet);
        DatagramPacket connect = new DatagramPacket(new byte[1024],1024);
        clientSocket.receive(connect);
        return Arrays.equals(buf, connect.getData());
    }
    private static void sendRequestingHandshake() throws IOException {
        byte[] buf = new byte[1024];
        buf[0] = 100;
        buf[1023] = 100;
        DatagramPacket packet = new DatagramPacket(buf, 0, 1024, ClientController.getDestIP(), ClientController.getDestPort());
        clientSocket.send(packet);
    }

    private static int changePort() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int port;
        while (true) {
            try {
                String p = reader.readLine();

                port = Integer.parseInt(p);
                if (port < 65535) {
                    break;
                }
                else {
                    throw new NumberFormatException();
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println("Unexpectedly port number, please, enter correct port number:");
            }
        }
        return port;
    }

    public static DatagramSocket getClientSocket(){
        return clientSocket;
    }

    static InetAddress getDestIP() {
        return destIP;
    }

    public static void setDestIP(String name){
        try {
            destIP = InetAddress.getByName(name);
        }
        catch (UnknownHostException e){
            System.out.println("IP address is not determined, please enter correct IP address:");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String IP;
            while (true) {
                try {
                    IP = reader.readLine();
                    break;
                } catch (IOException ex) {
                    System.out.println("Please enter a correct IP:");
                }
            }
            setDestIP(IP);
        }
    }

    public static void setDestPort(int destPort) {
        ClientController.destPort = destPort;
    }

    static int getDestPort() {
        return destPort;
    }

    public static InetAddress getTempIP() {
        return tempIP;
    }

    public static void setTempIP(InetAddress tempIP) {
        ClientController.tempIP = tempIP;
    }

    public static int getTempPort() {
        return tempPort;
    }

    public static void setTempPort(int tempPort) {
        ClientController.tempPort = tempPort;
    }

    public static Integer getPort() {
        return port;
    }

    public static void setPort(Integer port) {
        ClientController.port = port;
    }
}


