package moonrock.clisocialnetwork.user.authorization;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//todo
// will be implemented later
// do not touch and modify!

/**
 * @author tsypk
 * @project CLISocialNetwork
 */
public class SHA384Cryptographer {
    private final static String encryptAlg = "SHA-384";

    /**
     * @param password password that we want to encrypt
     * @return encrypted password
     */
    public static String encryptPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance(encryptAlg);
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashText = no.toString(16);
            while (hashText.length() < 32) {
                hashText = "0" + hashText;
            }
            return hashText;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("No such algorithm");
        }
    }
}
