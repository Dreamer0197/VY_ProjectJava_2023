public class App {
    public static int sayac;

    public static long factorial(int n){
        if(n==0){
            return 1;
        }
        else{
            return (n*factorial(n-1));
        }
    }
    public static double usAl(double a,int n){
        sayac++;
        if(n==0){
            return 1;
        }
        else if (n==1){
           return a;
        }
        else{
            return(a*usAl(a, n-1));
        }
    }
    public static double usAl1(double a,int n){
        sayac++;
        double y;
        if(n==0){
            return 1;
        }
        if(n%2==0){
            y=usAl1(a, n/2);
            return y*y;
        }
        else{
            y=usAl1(a, (n-1)/2);
            return a*y*y;
        }
    }
    public static int[] fiboIter(int n){
        int [] f_dizi=new int [n];
        f_dizi[0]=1;
        f_dizi[1]=1;
        for(int i=2;i<n;i++){
            f_dizi[i]=f_dizi[i-1]+f_dizi[i-2];
        }
        return f_dizi;

    }
    public static int fiboRec(int n){
        sayac++;
        if(n==0){
            return 1;
        }
        if(n==1){
             return 1;
        }
        else{
            return (fiboRec(n-1)+fiboRec(n-2));
        }
    }
    //çarpmanın toplama işlemi olarak çözümü
    public static int f1(int x,int y){
        if(y==0){
            return 0;
        }
        return x+f1(x, y-1);
    }
    //dizinin elemanları küçükten büyüğe sıralıdır.
    public static int f2(int [] dizi,int a,int b,int c){
        if(b>=a){
            int d=a+(b-a)/2;
            if(dizi[d]==c){
                return d;
            }
            if(dizi[d]>c){
                return f2(dizi, a, d-1, c);
            }
            else{
                return f2(dizi, d+1, b, c); 
            }
        }
        return -1;

    }


    public static void main(String[] args) throws Exception {
        
        int sayi=2;
        int us=11;
        System.out.println(sayi + "!="+ factorial(sayi));
        sayac=0;
        System.out.println(sayi + "^"+ us +"="+ usAl(sayi, us)+ " FÇS="+sayac);
        sayac=0;
        System.out.println(sayi + "^"+ us +"="+ usAl1(sayi, us)+ " FÇS="+sayac);
        sayac=0;
        System.out.println("10.fibonacci sayısı:"+fiboRec(10)+" FÇS:"+sayac);

    }
}
