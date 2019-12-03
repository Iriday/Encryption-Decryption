package encryptdecrypt;

public interface EncDecAlgorithm {
    String process(String data, int key, String mode);
}
