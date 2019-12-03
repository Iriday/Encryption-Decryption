package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputData {
    public static String fromFile(String filepath) {
        Scanner scn = null;
        StringBuilder builder = new StringBuilder();
        try {
            scn = new Scanner(new File(filepath));

            while (scn.hasNext()) {
                builder.append(scn.nextLine());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error, FileNotFoundException");

        } finally {
            scn.close();
        }
        return builder.toString();

    }
}
