import java.util.Stack;

public class App {
    public static void main(String[] args) throws Exception {
        yigin y=new yigin();

        y.push(20);
        y.push(30);
        y.push(40);

        System.out.println("Yığının en üstündeki eleman:"+y.peek());
        System.out.println("Yığından çekilen:"+y.pop());
        System.out.println("Yığının en üstündeki eleman:"+y.peek());
      
        y.push(50);
        System.out.println("Yığının en üstündeki eleman:"+y.peek());
        System.out.println("Yığından çekilen:"+y.pop());
        System.out.println("Yığının en üstündeki eleman:"+y.peek());

        System.out.println("Yığından çekilen:"+y.pop());
        System.out.println("Yığının en üstündeki eleman:"+y.peek());
      
        //javanın kendi yıgın sınıfının kullanılması

        Stack <String> myStack=new Stack <>();
        String dersler[]={"Veri Yapıları","Matematik","Türk Dili","Tarih"};
        for(int i=0;i<dersler.length;i++){
            myStack.push(dersler[i]);
        }
        while(myStack.isEmpty()==false){//!myStack.isEmpty de olabilir
           System.out.println(myStack.pop());
        }

    
    
    
    }
}
