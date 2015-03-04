import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.BiConsumer;

/**
 * Created by oliver on 04/03/15.
 */
public class HuffmanTree {

    private class Node {
        private Node leftChild;
        private Node rightChild;
        private String data;

        public Node(){
            this.leftChild = null;
            this.rightChild = null;
            this.data = "";
        }

        public String toString(){
            return "DATA:<" +this.data + ">" + "LEFT:" + (this.leftChild != null ? this.leftChild.toString() : "") + " RIGHT:" + (this.rightChild != null ? this.rightChild.toString() : "");
        }

    }

    private Node rootNode;

    public HuffmanTree() {
        this.rootNode = new Node();
    }

    public HuffmanTree(HuffmanTree.Node node){
        this.rootNode = node;

    }

    public boolean isempty(){

        if(rootNode.leftChild == null && rootNode.rightChild == null && rootNode.data == "") {
            return true;
        } else {
            return false;
        }
    }

    public void setCoding(HashMap<String, String> coding){
        coding.forEach((String path, String data) -> {
            Node currNode = this.rootNode;
            char[] charPath = path.toCharArray();
            for (int i = 0; i < charPath.length; i++){
                if (charPath[i] == '0'){
                    if (currNode.leftChild != null){
                        currNode = currNode.leftChild;
                    } else {
                        currNode.leftChild = new Node();
                        currNode = currNode.leftChild;
                    }
                } else if (charPath[i] == '1') {
                    if (currNode.rightChild != null){
                        currNode = currNode.rightChild;
                    } else {
                        currNode.rightChild = new Node();
                        currNode = currNode.rightChild;
                    }
                } else {
                    //Error! Inavlid coding!
                }
            }
            //Now set data
            currNode.data = data;
        });

    }

    static private boolean checkValid(Node node){
        if (node.leftChild == null && node.rightChild == null && node.data == ""){
            return false;
        } else if ((node.leftChild != null && node.rightChild == null) || (node.leftChild == null && node.rightChild != null)){
            return false;
        } else if (node.rightChild != null && node.leftChild != null){
            return checkValid(node.leftChild) && checkValid(node.rightChild);
        } else {
            return true;
        }
    }

    public boolean validate(){
        return checkValid(this.rootNode);
    }

    public String decodeWord(String word){
        ArrayList<Character> retList = new ArrayList<>();
        String reString = new String();
        char[] path = word.toCharArray();
        Node currNode = this.rootNode;
        for (int i = 0; i < path.length + 1; i++){
            if (currNode.data != ""){
                reString += currNode.data;
                currNode = this.rootNode;
            }
            if (i < path.length) {
                if (path[i] == '1') {
                    currNode = currNode.rightChild;

                } else if (path[i] == '0') {
                    currNode = currNode.leftChild;
                }
            }
        }
        return reString;
    }

    public String toString() {
        return rootNode.toString();
    }
}
