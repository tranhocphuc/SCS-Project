// Add points and save it into the text file used for Covid-19 self-diagnosis

package mainPackage;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class AddPoint 
{
    public static void addPoint(int points)
    {
        try(FileReader fileReader = new FileReader("filename.txt")) 
        {
            int ch = fileReader.read();
            String chString = "";
            while (ch!=-1)
            {
                chString = chString + (char)ch;
                ch = fileReader.read();
            }
            fileReader.close();
            int outInt = Integer.parseInt(chString) + points;
            String out = String.valueOf(outInt);
            System.out.println(out);
            try (FileWriter fileWriter = new FileWriter("filename.txt"))
            {
                fileWriter.write(out);
                fileWriter.close();
            }
            catch (IOException e)
            {
            }
        }
        catch (FileNotFoundException e) 
        {
        }
        catch (IOException e)
        {
        }
    }
    
}
