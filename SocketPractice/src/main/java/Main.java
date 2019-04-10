import storage.Storage;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        File file = new File("database.json");

        Storage storage = new Storage();
        try {
            storage.createBaseDataToFile(file);
            System.out.println(storage.readFromJson(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
