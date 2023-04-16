import java.util.Stack;


public class App {
    
    public static void main(String[] args) throws Exception {
        String ifade1="((2*(3+i))-(4-5/(2+8))+(3*k))";
        String ifade2="[A+{B*(c+{d/3})}/f]";
 
        Stack <Character> n=new Stack<>();
        char ifade_dizi2[]=ifade2.toCharArray();
        boolean gecerli2=true;
        char a1,a2;
        for(int i=0;i<ifade_dizi2.length;i++){
            a1=ifade_dizi2[i];
            if(a1=='['){
                n.push(a1);

            }
            if(a1==']'){
                if(n.isEmpty()){
                    gecerli2=false;
                    break;
                }
                a2=(char) n.pop();
                if(a2!='['){
                    gecerli2=false;
                    break;
                }

            }
            if(a1=='{'){
                n.push(a1);

            }
            if(a1=='}'){
                if(n.isEmpty()){
                    gecerli2=false;
                    break;
                }
                a2=(char) n.pop();
                if(a2!='{'){
                    gecerli2=false;
                    break;
                }

            }
            if(a1=='('){
                n.push(a1);

            }
            if(a1==')'){
                if(n.isEmpty()){
                    gecerli2=false;
                    break;
                }
                a2=(char) n.pop();
                if(a2!='('){
                    gecerli2=false;
                    break;
                }

            }
        }
        if(!n.isEmpty()){
            gecerli2=false;
        }
        System.out.println("İfade2 geçerli: "+gecerli2);      



       System.out.println("-----------------------------------------");

         
        Stack <Character> s=new Stack<>();
        char ifade_dizi1 []=ifade1.toCharArray();
        boolean gecerli1=true;
        char k1,k2;
        for(int i=0;i<ifade_dizi1.length;i++){
            k1=ifade_dizi1[i];
            if(k1=='('){
                s.push(k1);
            }
            if(k1==')'){
                if(s.isEmpty()){
                    gecerli1=false;
                    break;
                }
                k2=(char) s.pop();
                if(k2!='('){
                    gecerli1=false;
                    break;
                }
            }
        }
        if(!s.isEmpty()){
            gecerli1=false;
        }
        System.out.println("İfade1 geçerli: "+gecerli1);
        
    }
}
