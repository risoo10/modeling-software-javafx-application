package memory_management;

import sample.Course;
import sample.School;

import java.io.*;

/**
 * Created by Riso on 12/9/2017.
 */
public class MemoryManager {

    private static MemoryManager instance = null;

    // Singleton memory manager
    public static MemoryManager getInstance(){
        if(instance == null){
            instance = new MemoryManager();
        }

        return instance;
    }



    // Serialize data to file
    public void saveObject(Serializable object) throws IOException {
        ObjectOutputStream oos = null;
        FileOutputStream fout = null;
        try{
            fout = new FileOutputStream("data.ser", true);
            oos = new ObjectOutputStream(fout);
            oos.writeObject(object);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if(oos != null){
                oos.close();
            }
        }
    }


    // Deserialize data from file
    public Serializable loadObject() throws IOException {
        ObjectInputStream objectinputstream = null;
        Serializable object = null;
        try {
            FileInputStream streamIn = new FileInputStream("data.ser");
            objectinputstream = new ObjectInputStream(streamIn);
            object = (Serializable) objectinputstream.readObject();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(objectinputstream != null){
                objectinputstream .close();
            }
        }
        return object;
    }


}
