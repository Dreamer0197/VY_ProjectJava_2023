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
        myList.listele();
        myList.basaEkle(10);
        myList.basaEkle(20);
        myList.sonaEkle(40);
        myList.basaEkle(5);
        myList.sonaEkle(30);
        myList.elemanSayisi();
        
        
        
        Dugum d=new Dugum(50);
        myList.basaEkle(d);
        
        Dugum dd=new Dugum(60);
        myList.sonaEkle(dd);
        myList.arayaEkle(70, 20);
        myList.sorguAdet(5);
        myList.listele();

        int sil=70;
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


        myList.elemanSayisi();






    }
}
