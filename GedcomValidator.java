import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class GedcomValidator {

    public static void main(String args[]) throws IOException {

        //Input test file provided
        File file = new File("/Users/mahirdhall/Desktop/Project_02_Dhall_Mahir_CS555A/proj02test.ged");


        //My custom family
        //File file = new File("/Users/mahirdhall/Desktop/Project_02_Dhall_Mahir_CS555A/My-Family-27-Jan-2020-330.ged");

        Scanner sc = new Scanner(file);

        HashMap<String, String> tags = new HashMap<>();
        tags.put("INDI", "0");
        tags.put("FAM", "0");
        tags.put("HEAD", "0");
        tags.put("TRLR", "0");
        tags.put("NOTE", "0");

        tags.put("NAME", "1");
        tags.put("SEX", "1");
        tags.put("BIRT", "1");
        tags.put("DEAT", "1");
        tags.put("FAMC", "1");
        tags.put("FAMS", "1");
        tags.put("MARR", "1");
        tags.put("HUSB", "1");
        tags.put("WIFE", "1");
        tags.put("CHIL", "1");
        tags.put("DIV", "1");

        tags.put("DATE", "2");

        //FileWriter writer = new FileWriter("/Users/mahirdhall/Desktop/customFamilOutput.txt");
        FileWriter writer = new FileWriter("/Users/mahirdhall/Desktop/inputTestFileOutput.txt");
        while (sc.hasNextLine()) {
            String currLine = sc.nextLine();

            System.out.println("-->" + currLine);
            writer.write("-->" + currLine+"\n");
            String[] currArr = currLine.split(" ");

            String level = currArr[0];

            if (level.equals("0")) {
                if (currArr[1].equals("HEAD") || currArr[1].equals("TRLR") || currArr[1].equals("NOTE")) {
                    System.out.print("<--" + level + "|" + currArr[1] + "|Y|");
                    writer.write("<--" + level + "|" + currArr[1] + "|Y|");
                    for (int i = 2; i < currArr.length; i++) {
                        writer.write(currArr[i] + " ");
                        System.out.print(currArr[i] + " ");
                    }
                } else if (currArr[2].equals("INDI") || currArr[2].equals("FAM")) {
                    writer.write("<--" + level + "|" + currArr[2] + "|Y|" + currArr[1]);
                    System.out.print("<--" + level + "|" + currArr[2] + "|Y|" + currArr[1]);
                } else {
                    writer.write("<--" + level + "|" + currArr[1] + "|N|");
                    System.out.print("<--" + level + "|" + currArr[1] + "|N|");
                    for (int i = 2; i < currArr.length; i++) {
                        writer.write(currArr[i] + " ");
                        System.out.print(currArr[i] + " ");
                    }
                }

            }

            else if (level.equals("1")) {
                if (tags.containsKey(currArr[1])) {
                    if (tags.get(currArr[1]).equals(level)) {
                        writer.write("<--" + level + "|" + currArr[1] + "|Y|");
                        System.out.print("<--" + level + "|" + currArr[1] + "|Y|");
                        for (int i = 2; i < currArr.length; i++) {
                            System.out.print(currArr[i] + " ");
                            writer.write(currArr[i] + " ");
                        }
                    } else {
                        writer.write("<--" + level + "|" + currArr[1] + "|N|");
                        System.out.print("<--" + level + "|" + currArr[1] + "|N|");
                        for (int i = 2; i < currArr.length; i++) {
                            writer.write(currArr[i] + " ");
                            System.out.print(currArr[i] + " ");
                        }
                    }
                }
                else {
                    writer.write("<--" + level + "|" + currArr[1] + "|N|");
                System.out.print("<--" +level + "|" + currArr[1] + "|N|");
                    for (int i = 2; i < currArr.length; i++) {
                    writer.write(currArr[i] + " ");
                System.out.print(currArr[i] + " ");
                }

                }
            } else if (level.equals("2")) {
                if (!currArr[1].equals("DATE")) {
                    writer.write("<--" + level + "|" + currArr[1] + "|N|");
                    System.out.print("<--" + level + "|" + currArr[1] + "|N|");
                    for (int i = 2; i < currArr.length; i++) {
                        writer.write(currArr[i] + " ");
                        System.out.print(currArr[i] + " ");
                    }
                } else {
                    writer.write("<--" + level + "|" + currArr[1] + "|Y|");
                    System.out.print("<--" + level + "|" + currArr[1] + "|Y|");
                    for (int i = 2; i < currArr.length; i++) {
                        System.out.print(currArr[i] + " ");
                        writer.write(currArr[i] + " ");
                    }

                }
            } else {
                writer.write("<--" + level + "|" + currArr[1] + "|N|");
                System.out.print("<--" + level + "|" + currArr[1] + "|N|");
                for (int i = 2; i < currArr.length; i++) {
                    writer.write(currArr[i] + " ");
                    System.out.print(currArr[i] + " ");
                }
            }
            writer.write("\n");
            System.out.println();
        }
        sc.close();
        writer.close();
    }

}