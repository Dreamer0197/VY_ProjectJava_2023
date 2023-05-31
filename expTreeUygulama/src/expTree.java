import java.util.Stack;

public class expTree {
    public Node root;

    public expTree(){
        this.root=null;
    }
    /*
     * postfix bir ifadeyi alıp bunu expression tree (ikili ağac)'ye dönüştüren fonk
     * (yıgın kullanarak)
     * 23*84/+
     */
    public void createExpressionTree(String exp){
        Stack <Node> stck=new Stack<>();

        exp=exp+"#";
        int i=0;
        char symbol=exp.charAt(i);
        Node newNode;

        while(symbol!='#'){
            if((symbol>='0'&& symbol<='9')||(symbol>='a'&& symbol<='z')){
                //operantla karşılaştığında duğum olustur ve yıgına at
                newNode=new Node(symbol);
                stck.push(newNode);
            }
            else if(symbol=='+'||symbol=='-'||symbol=='*'||symbol=='/'){
               //operatörle karşılaşıldığında duğum oluştur, yığında ilk çekileni sağa bağlantı
               //ikinci çekileni sol bağlantı yap, sonucu yığına it
               newNode=new Node(symbol);
               newNode.rightChild=stck.pop();
               newNode.leftChild=stck.pop();
               stck.push(newNode);
            }
            symbol=exp.charAt(++i);
        }
        this.root=stck.pop();
    }
    public void postOrderTraverse(Node localRoot){
       if(localRoot!=null){
        postOrderTraverse(localRoot.leftChild);
        postOrderTraverse(localRoot.rightChild);
        localRoot.displayNode();
       }
    }
    public void inOrderTraverse(Node localRoot){
        if(localRoot!=null){
            inOrderTraverse(localRoot.leftChild);
            localRoot.displayNode();
            inOrderTraverse(localRoot.rightChild);
           }
    }
    public void preOrderTraverse(Node localRoot){
        if(localRoot!=null){
            localRoot.displayNode();
            preOrderTraverse(localRoot.leftChild);
            preOrderTraverse(localRoot.rightChild);
           }
    }

}
