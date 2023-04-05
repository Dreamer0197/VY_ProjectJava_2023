import java.util.Stack;

public class App {
    public static int hesapla(int op1,int op2,char op){
        switch(op){
        case '+':return op1+op2;
        case '-':return op1-op2;
        case '*':return op1*op2;
        case '/':return op1/op2;
        }
        return 0;
    }
    public static int oncelik(char c){
      switch(c){
        case '+':
        case '-': return 1;
        case '*':
        case '/': return 2;
        case '^': return 3;
      }  
      return -1;
    }
    public static String iFix2Postfix(String infixIfade){
    Stack <Character> s=new Stack <>();
    String postIfade="";
    for(int i=0;i<infixIfade.length();i++){
        char c=infixIfade.charAt(i);
        if(oncelik(c)>0){//c bir operatör ise
        //yığın işlemleri yapılacak
        while(!s.isEmpty()&&(oncelik(c)<=oncelik(s.peek()))){
            postIfade=postIfade+s.pop();
        }
        s.push(c);

        }
        else{
            //postfix ifadeye ekle
            postIfade=postIfade+c;
        }
    }
    int sBoyut=s.size();
    if(sBoyut>0){
        for(int i=0;i<sBoyut;i++){
        postIfade=postIfade+s.pop();  
        }
    }
    return postIfade;
   }
    public static String postfix2Islem(String postfixIfade){
    Stack <Integer> a=new Stack <>();
    int[]yigin=new int[postfixIfade.length()];
    for (int i = 0; i < postfixIfade.length(); i++) {
        char c = postfixIfade.charAt(i);

        if (oncelik(c) == -1) {
            yigin[i] = Integer.parseInt(String.valueOf(c)); // char'ı tamsayıya dönüştür ve yığıta ekle
            a.push(yigin[i]);
        } else {
            if (oncelik(c) != -1) { // koşul düzeltmesi
                int op2 = a.pop();
                int op1 = a.pop();
                int sonuc = hesapla(op1, op2, c); // işlemi gerçekleştir
                a.push(sonuc);
            } else {
                System.out.println("Hata");
            }
        }
    }

    return String.valueOf(a.pop()); // sonucu bir dize olarak döndür
}
    
    public static void main(String[] args) throws Exception {
        String inFixIfade="a + b * c - d";
        String postfixIfade="52+8*3-";
        System.out.println("Işlem sonucu:"+postfix2Islem(postfixIfade));
        System.out.println(iFix2Postfix(inFixIfade));
    }
}
