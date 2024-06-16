import java.security.*;
import java.util.ArrayList;
public class Transaction {
    public String transactionID;
    public PublicKey sender;
    public PublicKey receiver;
    public float value;
    public byte[] signature;

    public ArrayList<TransactionInput> inputs = new ArrayList<TransactionInput>();
    public ArrayList<TransactionOutput> outputs = new ArrayList<TransactionOutput>();


    //Constructor
    public Transaction(PublicKey from, PublicKey to, float value, ArrayList<TransactionInput> inputs){
        this.sender = from;
        this.receiver = to;
        this.value = value;
        this.inputs = inputs;

    }

    private String calculateHash(){
        sequence++;
        return StringUtil.applySha256(
                StringUtil.getStringfromKey(sender) +

    }
}
