import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileSystem {

    HashMap<String, ArrayList<FileData>> nameMap;
    HashMap<String, ArrayList<FileData>> dateMap;

    // TODO
    public FileSystem() {

    }

    // TODO
    public FileSystem(String inputFile) {
        // Add your code here
        try {
            File f = new File(inputFile);
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String[] data = sc.nextLine().split(", ");
                // Add your code here
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }
    }

    // TODO
    public boolean add(String fileName, String directory, String modifiedDate) {
        return true; // TODO this is a placeholder so your code compiles
    }

    // TODO
    public FileData findFile(String name, String directory) {
        return null; // TODO this is a placeholder so your code compiles
    }

    // TODO
    public ArrayList<String> findAllFilesName() {
        return null; // TODO this is a placeholder so your code compiles
    }

    // TODO
    public ArrayList<FileData> findFilesByName(String name) {
        return null; // TODO this is a placeholder so your code compiles
    }

    // TODO
    public ArrayList<FileData> findFilesByDate(String modifiedDate) {
        return null; // TODO this is a placeholder so your code compiles
    }

    // TODO
    public ArrayList<FileData> findFilesInMultDir(String modifiedDate) {
        return null; // TODO this is a placeholder so your code compiles
    }

    // TODO
    public boolean removeByName(String name) {
        return true; // TODO this is a placeholder so your code compiles
    }

    // TODO
    public boolean removeFile(String name, String directory) {
        return true; // TODO this is a placeholder so your code compiles
    }

}
