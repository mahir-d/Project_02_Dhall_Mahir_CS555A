import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GedcomValidator {

    public static void main(String args[]) throws IOException {
       
        File file = new File("/Users/mahirdhall/Desktop/Project_02_Dhall_Mahir_CS555A/My-Family-27-Jan-2020-330.ged");
        
        Scanner sc = new Scanner(file);
        String fileContent = "";
        while (sc.hasNextLine()) {
            fileContent = fileContent.concat(sc.nextLine() + "\n");
            System.out.println(sc.nextLine());
        }
        
        sc.close();
    }

}