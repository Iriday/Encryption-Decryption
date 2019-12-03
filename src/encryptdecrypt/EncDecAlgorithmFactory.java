package encryptdecrypt;

import java.util.Locale;

public interface EncDecAlgorithmFactory {
    static EncDecAlgorithm getAlgorithm(String type) {
        switch (type.toUpperCase(Locale.ENGLISH)) {
            case "SHIFT":
                return new ShiftAlgorithm();
            case "UNICODE":
                return new UnicodeAlgorithm();
            default:
                return null;
        }
    }
}
