import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.spec.KeySpec;

public class KeyGenerator {
    public static Key generateKey(char[] password) {
        try {
            // Use PBKDF2 with HMAC SHA-1 to derive the key
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            KeySpec spec = new PBEKeySpec(password, "salt".getBytes(), 65536, 128);
            byte[] rawKey = factory.generateSecret(spec).getEncoded();

            // Convert the raw key into a SecretKeySpec
            return new SecretKeySpec(rawKey, "AES");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
