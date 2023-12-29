package nobody;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.file.Paths;
import java.math.BigInteger;
/**
 *
 * @author Jopec
 */
public class Aoc201504 {

    public static void main(String[] args)  throws NoSuchAlgorithmException{
        String str = "iwrupvqb";
        var result = mineAdventcoins(str);
        System.out.println(Paths.get("src/main/java/nobody/movement.txt").toAbsolutePath());
        System.out.println("Mining AdventCoins '"+ str + "' : " + result[0] + "/" + result[1]);
    }

    public static int[] mineAdventcoins(String secretKey) throws NoSuchAlgorithmException {
        int counter = 0;
        int[] result = new int[2];
        while (result[0] == 0 || result[1] == 0) {
            // Concatenate the secret key and the counter
            String input = secretKey + counter;

            // Calculate the MD5 hash of the input
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes());

            // Convertir byte array a hexadecimal
            String hexString = String.format("%032x", new BigInteger(1, digest));

            // Check if the hexadecimal hash starts with the required number of zeroes
            if (result[0] == 0 && hexString.startsWith("00000")) {
                result[0] = counter;
            }
            if (result[1] == 0 && hexString.startsWith("000000")) {
                result[1] = counter;
            }

            counter++;
        }
        return result;
    }

}
