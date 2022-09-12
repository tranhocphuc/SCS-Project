// Create new text file to use for covid-19 self diagnosis
package mainPackage;
import java.io.File;
import java.io.IOException;

public class CreateFile {
    public static void newFile() {
        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            } 
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
    }
}

