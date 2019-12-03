package encryptdecrypt;

import java.io.PrintWriter;

public class OutputData {
    public static void toTerminal(String data) {
        System.out.println(data);
    }

    public static void toFile(String data, String filepath) {
        try {
            PrintWriter printWriter = new PrintWriter(filepath);
            printWriter.write(data);
            printWriter.flush();
            printWriter.close();

        } catch (Exception e) {
            System.err.println("Error, incorrect filepath: " + filepath);
            System.exit(0);
        }
    }
}
