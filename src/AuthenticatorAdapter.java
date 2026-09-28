import java.security.MessageDigest;

public class AuthenticatorAdapter implements IModernAuthenticator {
    private LegacyAuthService legacyAuthService;

    public AuthenticatorAdapter(LegacyAuthService legacyAuthService) {
        this.legacyAuthService = legacyAuthService;
    }

    public boolean login(String username, String plainTextPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(plainTextPassword.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }

            String hexHash = sb.toString();
            return legacyAuthService.authenticateUserHex(username, hexHash);
        } catch (Exception e) {
            return false;
        }
    }
}