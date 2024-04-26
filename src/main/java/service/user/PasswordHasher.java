package service.user;
import org.mindrot.jbcrypt.BCrypt;
public class PasswordHasher {
    public static String hashPassword(String password) {

        return BCrypt.hashpw(password, BCrypt.gensalt());

    }

    public static boolean checkPassword(String password, String hashedPassword) {
        return (BCrypt.checkpw(password, hashedPassword.replace("$2y$", "$2a$")));
    }
}



