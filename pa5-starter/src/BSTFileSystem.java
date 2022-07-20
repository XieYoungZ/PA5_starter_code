import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Comparator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class BSTFileSystem {

    BST<String, FileData> nameTree;
    BST<String, ArrayList<FileData>> dateTree;
    DateComparator dc;
    
    // TODO
    public BSTFileSystem() {

    }


    // TODO
    public BSTFileSystem(String inputFile) {
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
    public void add(String name, String dir, String date) {
    	
    }


    // TODO
    public ArrayList<String> findFileNamesByDate(String date) {
    	return null; // TODO this is a placeholder so your code compiles
    }


    // TODO
    public BSTFileSystem filter(String startDate, String endDate) {
    	return null; // TODO this is a placeholder so your code compiles
    }
    
    
    // TODO
    public BSTFileSystem filter(String wildCard) {
    	return null; // TODO this is a placeholder so your code compiles
    }
    
    
    // TODO
    public List<String> outputNameTree(){
    	return null; // TODO this is a placeholder so your code compiles
    }
    
    
    // TODO
    public List<String> outputDateTree(){
    	return null; // TODO this is a placeholder so your code compiles
    }
    
    

    class DateComparator implements Comparator<String> {
    	
    	//TODO
    	public int compare(String date1, String date2) {
    		return 0; // TODO this is a placeholder so your code compiles
    	}
    }


}

