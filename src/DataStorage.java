import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
public class DataStorage {

    private static final String FILE_NAME = "library_data.ser";

    public static void saveLibrary(Library library) {

        // saving the current library data into file
        try (ObjectOutputStream output =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            output.writeObject(library);

            System.out.println("Library data saved successfully.");

        } catch (IOException e) {

            // if saving have some problem then show error
            System.out.println(
                    "Unable to save library data: " + e.getMessage()
            );
        }
    }

    // loading library data which was saved before
    public static Library loadLibrary() {

        try (ObjectInputStream input =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            return (Library) input.readObject();

        } catch (FileNotFoundException e) {

            // file is not there so make a fresh library
            System.out.println(
                    "No saved library data found. Creating a new library."
            );

            return new Library();

        } catch (IOException | ClassNotFoundException e) {

            // if old data cannot be read then start again
            System.out.println(
                    "Could not load the saved data. Starting with a new library."
            );

            return new Library();
        }
    }
}
