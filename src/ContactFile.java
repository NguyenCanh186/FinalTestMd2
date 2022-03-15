import java.io.*;
import java.util.ArrayList;

public class ContactFile {
    public ArrayList<Contacts> readFile(){
        File file = new File("list2.contact");
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object result = ois.readObject();
            ArrayList<Contacts> books = (ArrayList<Contacts>) result;
            ois.close();
            fis.close();
            return  books;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void writeFile(ArrayList<Contacts> arrayList) throws IOException {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream("list2.contact");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(arrayList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            oos.close();
            fos.close();
        }
    }
}
