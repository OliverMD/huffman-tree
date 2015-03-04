import org.junit.Test;

import java.util.HashMap;

/**
 * Created by oliver on 04/03/15.
 */
public class tests {

    @Test
    public void shouldAlwaysPass(){

    }

    @Test
    public void initTree(){
        HuffmanTree myTree = new HuffmanTree();
    }

    @Test
    public void buildCoding(){
        HashMap<String, String> cipher = new HashMap<String,String>();
        cipher.put("000", "A");
        cipher.put("001", "B");
        cipher.put("010", "C");
        cipher.put("011", "D");
        cipher.put("10", "E");
        cipher.put("11", "F");

        HuffmanTree tree = new HuffmanTree();
        tree.setCoding(cipher);
        System.out.print(tree);
    }

    @Test
    public void checkValidity(){
        HashMap<String, String> cipher = new HashMap<String,String>();
        cipher.put("000", "A");
        cipher.put("001", "B");
        cipher.put("010", "C");
        cipher.put("011", "D");
        cipher.put("10", "E");
        cipher.put("11", "F");

        HuffmanTree tree = new HuffmanTree();
        tree.setCoding(cipher);
        System.out.println(tree);
        System.out.println(tree.validate());
    }

    @Test
    public void testDecode(){
        HashMap<String, String> cipher = new HashMap<String,String>();
        cipher.put("000", "A");
        cipher.put("001", "B");
        cipher.put("010", "C");
        cipher.put("011", "D");
        cipher.put("10", "E");
        cipher.put("11", "F");

        HuffmanTree tree = new HuffmanTree();
        tree.setCoding(cipher);
        System.out.println(tree);
        System.out.println(tree.validate());
        System.out.println(tree.decodeWord("1100001010"));
    }
}
