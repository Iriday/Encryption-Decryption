package encryptdecrypt;

import java.util.Locale;

public class UnicodeAlgorithm implements EncDecAlgorithm {
    @Override
    public String process(String data, int key, String mode) {
        if (key == 0) {
            return data;
        }
        switch (mode.toUpperCase(Locale.ENGLISH)) {
            case "ENC":
                return encrypt(data, key);
            case "DEC":
                return decrypt(data, key);
        }
        return null;
    }

    private String encrypt(String data, int key) {
        char[] d = data.toCharArray();
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < key; j++) {
                d[i] = ++d[i];
            }
        }
        return new String(d);
    }

    private String decrypt(String data, int key) {
        char[] d = data.toCharArray();
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < key; j++) {
                d[i] = --d[i];
            }
        }
        return new String(d);
    }
}