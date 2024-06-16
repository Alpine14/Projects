import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class Blockchain {

    public static Boolean isChainValid(){
        Block current;
        Block previous;
        String Hashtarget = new String(new char[difficulty]).replace('\0','0');

        for (int i = 1; i < blockChain.size(); i++){
            current = blockChain.get(i);
            previous = blockChain.get(i - 1);

            if(!current.hash.equals(current.calculateHash())){
                System.out.println("Block " + i + "hash is invalid.");
                return false;
            }
            if(!previous.hash.equals(previous.calculateHash())){
                System.out.println("Block" + (i-1) + "hash is invalid.");
                return false;
            }
            if(!current.hash.substring( 0, difficulty).equals(Hashtarget)){
                System.out.println("This block was mined unsuccessfully.");
                return false;
            }
        }
        return true;
    }
    public static ArrayList<Block> blockChain = new ArrayList<Block>();
    public static int difficulty = 5;

    public static void main(String[] args) {
        blockChain.add(new Block("First Block", "0"));
        System.out.println("Trying to mine block 1 ...");
        blockChain.get(0).mineBlock(difficulty);

        blockChain.add(new Block("Second Block", blockChain.get(blockChain.size() - 1).hash));
        System.out.println("Trying to mine block 2...");
        blockChain.get(1).mineBlock(difficulty);

        blockChain.add(new Block("Third Block", blockChain.get(blockChain.size() - 1).hash));
        System.out.println("Trying to mine block 3...");
        blockChain.get(2).mineBlock(difficulty);

        System.out.println("\nBlockchain is valid?: " + isChainValid());

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockChain);
        System.out.println("\nThe Blockchain: ");
        System.out.println(blockchainJson);
    }
}