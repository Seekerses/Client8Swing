package client;

import clientserverdata.Reply;

import java.io.*;
import java.util.Arrays;

class Serializer {


    static <T> byte[] serialize(T obj){
        byte[] buff;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(baos);
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            buff = baos.toByteArray();
            objectOutputStream.close();
            baos.close();
            return buff;
        }
        catch (IOException e){
            System.out.println("Serialization process was broken." );
            return null;
        }
    }

    static Reply deserialize(byte[] data) {
        try{
            if (data.length>0) {
                System.out.println("data" + Arrays.toString(data));
                ObjectInput ois = null;
                Reply answ = null;
                try (ByteArrayInputStream bais = new ByteArrayInputStream(data)) {
                    ois = new ObjectInputStream(bais);
                    answ = (Reply) ois.readObject();
                }catch (EOFException e){
                    assert ois != null;
                    ois.close();
                }catch (Exception e){
                    System.out.println("Error in" + Arrays.toString(data));
                }
                if (ois != null) {
                    ois.close();
                }
                return answ;
            }
        }
        catch (IOException ioException) {
            System.out.println("Oh no, some IO exception occurs.");
            ioException.printStackTrace();
        }
        return null;
    }
    
}
