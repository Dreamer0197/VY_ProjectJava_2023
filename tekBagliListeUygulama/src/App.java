public class App {
    public static void main(String[] args) throws Exception {
        /*
        Dugum d1=new Dugum();
        d1.yazdir();

        Dugum d2=new Dugum(5);
        d2.yazdir();

        temp=geçici
        current=anlık
        */



        TBListe myList=new TBListe();
        myList.arayaEkle(5, 1);
        myList.arayaEkle(6, 2);
        myList.arayaEkle(6, 3);
        myList.arayaEkle(7, 4);
        myList.arayaEkle(7, 5);
        myList.siraliEkle(52);
        myList.listele();
        myList.elemanSil(6);
        myList.listele();

        /*
        myList.elemanSayisi();
        myList.hepsiniSil(6);
        myList.listele();
        
        
        /* 
        Dugum d=new Dugum(50);
        myList.basaEkle(d);
        
        Dugum dd=new Dugum(60);
        myList.sonaEkle(dd);
        myList.arayaEkle(70, 20);
        myList.sorguAdet(5);
        myList.listele();
        
        int sil=94;
        int sonuc=myList.elemanSil(sil);
        if(sonuc==0){
            System.out.println(sil+" listeden silindi");
        }
        else if(sonuc==-1){
            System.out.println("Liste boş");
        }
        else if(sonuc==-2){
            System.out.println(sil+" listede bulunamadı");
        }
        */

        /*  
        int sil=44,indis=3;
        int sonuc=myList.elemanSil(sil, indis);
        if(sonuc==1){
            System.out.println(sil+" listeden silindi");
        }
        else if(sonuc==0){
            System.out.println("Liste boş");
        }
        else if(sonuc==-1){
            System.out.println(sil+" listede bulunamadı");
        }
        myList.listele();
        */

        myList.elemanSayisi();






    }
}
