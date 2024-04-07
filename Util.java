import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Util {
    
    /**
     * Returns a string of a line in a .txt file, prints error message if failed and
     * returns null
     * 
     * @param file - the file its reading
     * @param line - number of line its reading
     * @return - string of the file read, null if the read was unsuccesfull
     */
    public static String readFileLine(File file, int line) {
        int lines = 0;
        if (!file.exists()) {
            System.out.println("File does not exist");
            return null;
        }
        if (line <= 0) {
            System.out.println("Not valid line (<=0)");
            return null;
        }
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                fileScanner.nextLine();
                lines++;
            }
            fileScanner.close();
        } catch (IOException e) {
            System.out.print("There was an error when handeling the file");
            return null;
        }
        if (line > lines) {
            // System.out.println("Line out of index");
            return null;
        }
        try {
            int currLine = 1;
            Scanner fileScanner = new Scanner(file);
            String currString = "";
            while (fileScanner.hasNextLine()) {
                currString = fileScanner.nextLine();
                if (currLine == line) {
                    fileScanner.close();
                    return currString;
                }
                currLine++;
            }
            fileScanner.close();
        } catch (IOException e) {
            System.out.print("There was an error when handeling the file");
            return null;
        }
        return null;
    }
}
