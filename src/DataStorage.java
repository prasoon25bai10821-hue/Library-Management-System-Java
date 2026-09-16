import java.io.*;

public class DataStorage {
    private static final String FILE_NAME = "library_data.ser";

    public static void saveLibrary(Library library) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(library);
            System.out.println("System data saved successfully to disk.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    public static Library loadLibrary() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (Library) ois.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("No previous data found. Starting a fresh database.");
            return new Library();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data. Starting fresh.");
            return new Library();
        }
    }
}