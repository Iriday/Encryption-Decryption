package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String algorithmMode = "enc";
        String text = "";
        String outputFilepath = null;
        String alg = "SHIFT";
        int key = 0;

        if (args.length == 0) {
            Scanner scn = new Scanner(System.in);
            System.out.println("Type instructions: -mode, -key, -data, -in, -out, -alg, exit");
            args = scn.nextLine().split(" ");
            for (String val : args) {
                if ("exit".equalsIgnoreCase(val)) {
                    System.exit(0);
                }
            }
        }

        //  input check
        if (args.length % 2 != 0) {
            System.out.println("Error, there should be even number of arguments");
            System.exit(0);
        }
        String check;
        for (int i = 0; i < args.length - 1; i++) {
            check = args[i];
            if (check.equalsIgnoreCase("-mode") || check.equalsIgnoreCase("-key") || check.equalsIgnoreCase("-data") || check.equalsIgnoreCase("-in") || check.equalsIgnoreCase("-out") || check.equalsIgnoreCase("-alg")) {
                if (check.equalsIgnoreCase("-key")) {
                    try {
                        Integer.parseInt(args[i + 1]);
                    } catch (Exception e) {
                        System.out.println("Error, incorrect value (" + args[i + 1] + ") for flag: -key. Use digits");
                        System.exit(0);
                    }
                }
                i++;
                check = args[i];
                if (check.equalsIgnoreCase("-mode") || check.equalsIgnoreCase("-key") || check.equalsIgnoreCase("-data") || check.equalsIgnoreCase("-in") || check.equalsIgnoreCase("-out") || check.equalsIgnoreCase("-alg")) {
                    System.out.println("Error, an argument: " + args[-i] + " doesn't have a valid value");
                    System.exit(0);
                }
            } else {
                System.out.println("Error, not a valid flag: " + args[i] + ", please use: -mode, -key, -data, -in, -out, -alg");
                System.exit(0);
            }
        }

        // initialisation
        for (int i = 0; i < args.length; i++) {

            if ("-mode".equalsIgnoreCase(args[i])) {
                ++i;
                algorithmMode = args[i];

            } else if ("-key".equalsIgnoreCase(args[i])) {
                ++i;
                key = Integer.parseInt(args[i]);

            } else if ("-data".equalsIgnoreCase(args[i])) {
                ++i;
                text = args[i];

            } else if ("-in".equalsIgnoreCase(args[i])) {
                ++i;
                boolean dataArgFound = false;
                for (String arg : args) {
                    if ("-data".equalsIgnoreCase(arg)) {
                        dataArgFound = true;
                        break;
                    }
                }
                if (!dataArgFound) {
                    text = InputData.fromFile(args[i]);
                }

            } else if ("-out".equalsIgnoreCase(args[i])) {
                ++i;
                outputFilepath = args[i];

            } else if ("-alg".equalsIgnoreCase(args[i])) {
                ++i;
                alg = args[i];
            }
        }

        // encrypt/decrypt data
        EncDecAlgorithm algorithm = EncDecAlgorithmFactory.getAlgorithm(alg);
        String data = algorithm.process(text, key, algorithmMode);

        // output
        if (outputFilepath != null) {
            OutputData.toFile(data, outputFilepath);
        } else {
            OutputData.toTerminal(data);
        }
    }
}
