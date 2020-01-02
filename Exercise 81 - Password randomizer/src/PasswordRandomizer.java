import java.util.concurrent.ThreadLocalRandom;

public class PasswordRandomizer {

    private int length;

    public PasswordRandomizer(int length) {
        this.length = length;
    }

    public String createPassword() {
        int i = 0;
        String vault = "abcdefghijklmnopqrstuvwxyz";
        String password = "";
        while (i < length) {
            int charAt = ThreadLocalRandom.current().nextInt(0, vault.length());
            password += vault.charAt(charAt);
            i++;
        }
        return password;
    }
}
