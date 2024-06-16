package Blocktards;
import java.security.*;
import java.security.spec.ECGenParameterSpec;

public class wallet {
    public PrivateKey privateKey;
    public PublicKey publicKey;

    public wallet(){
        generateKeyPair();
    }
    public void generateKeyPair(){
        try {
            KeyPairGenerator keyGen = KeyPairGenerator.getInstance("ESDSA", "BC");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            ECGenParameterSpec ecSpec = new ECGenParameterSpec("prime192v1");
            // Initialized Key generator and give random pair
            keyGen.initialize(ecSpec, random); //256 Bytes is fine
            KeyPair keyPair = keyGen.generateKeyPair();
            // set public and private keys
            privateKey = keyPair.getPrivate();
            publicKey = keyPair.getPublic();


        } catch(Exception e){
                throw new RuntimeException(e);
        }
    }
}
