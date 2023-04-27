import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        
        /* 100 adet 5 basamaklı pozitif tamsayı şeklindeki veriyi (data) rasgele ürertip 100 elemanlı bir hash
         * tablosuna yerleştirme (data-> index üretilmesi ve datanın dizide o pozisyona kaydedilmesi) örneği
         * Çakışmalar linear probing ile çözümlenecek
         * //çakışma olmadan yerleştirilen veri sayısı
         * çakışma sayısı
         * ve çakışmalar nedeniyle yapılan arama sayısı hesaplanacak
         * 
         * hash tablosu bir dizi olacaktır
         * hash fonksiyonu mod alma işlemi şeklindedir
         */

         int data, index;
         int hashBoyut=100;
         int hashTable[]=new int [hashBoyut];
         int hashTableQ[]=new int [hashBoyut];
         for(int i=0; i<hashBoyut ;i++){
            hashTable[i]=-1;
            hashTableQ[i]=-1;
         }
         int sayac=0; //100 adet veri üretimiyle ilgili sayac
         int say1=0; //direkt yerleşenler için sayac
         int say1q=0;
         int say2=0;  //çakışmalar sayısı
         int say2q=0;
         int say3=0;  //çakışmalar nedeniyle yapılan boş pozisyon arama sayısı
         int say3q=0;
         
         while (sayac < hashBoyut){
            Random r=new Random();
            //5 basamaklı sayılar 10000-99999 aralığındaki sayılardır
            data= 10000 + r.nextInt(90000);
            index= data % hashBoyut; // hash fonksiyonu mod alma işlemi


            // linear probing
            if(hashTable[index] < 0) {  //tablodaki pozisyon boş, çakışma yok, yerleştirme işlemi yapılır
                hashTable[index]=data;  
                say1++;
            }
            else{  //tablodaki pozisyon dolu, çakışma var
                say2++;
                int k=1;
                while(hashTable[(index+k) % hashBoyut] > 0){
                    k++;
                    say3++;
                }
                int yindex=(index+k) % hashBoyut;
                hashTable[yindex]=data; 
            }   
            
            //quadratic probing
            if(hashTableQ[index] < 0) {  //tablodaki pozisyon boş, çakışma yok, yerleştirme işlemi yapılır
                hashTableQ[index]=data;  
                say1q++;
            }
            else{  //tablodaki pozisyon dolu, çakışma var
                say2q++;
                int k=1;
                while(hashTableQ[((index + (k^2)) % hashBoyut)] > 0){
                    k++;
                    say3q++;
                }
                int yindex=(index+ (k^2) ) % hashBoyut;
                hashTableQ[yindex]=data; 
            }   



            //chaining
            hashDugum hashTableC [] =new hashDugum [hashBoyut]; 
            for (int i=0; i<hashBoyut ; i++){
                hashTableC[i]=null;
            }
            hashDugum yeni=new hashDugum(data);
            if(hashTableC[index]==null){
                hashTableC [index]=yeni;
            }
            else{
                //başa ekleme işlemi
            }
            sayac++;
         }

         System.out.println("Çakışmadan yerleşen veri sayısı: " +say1);
         System.out.println("Çakışma sayısı: " +say2);
         System.out.println("Çakışma nedeniyle arama sayısı: " +say3);


         System.out.println("Çakışmadan yerleşen veri sayısı: " +say1q);
         System.out.println("Çakışma sayısı: " +say2q);
         System.out.println("Çakışma nedeniyle arama sayısı: " +say3q);
         for(int i=0; i<100 ;i++){
            System.out.println(hashTable[i]);
         }



    }
}
