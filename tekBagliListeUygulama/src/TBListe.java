import java.security.cert.X509CRL;

public class TBListe {
    private Dugum ilk;// listenin başlangıcını tutan değişken

    public TBListe(){
        this.ilk=null;//liste boş olarak yaratılır
    }
    //listenin başına eleman ekleme
    public void basaEkle(int deger){
        Dugum yeni=new Dugum(deger);
        //Dugum yeni=new Dugum();
        //yeni.setVeri(deger);
        yeni.setSonraki(this.ilk);//yeşil bağlantı
        this.ilk=yeni;//mavi bağlantı
    }
    
    public void basaEkle(Dugum yeni){
        yeni.setSonraki(this.ilk);
        this.ilk=yeni;
    }


    //listenin sonuna eleman ekleme
    public void sonaEkle(int deger){
        Dugum yeni=new Dugum(deger);
        if(this.ilk==null){
            this.ilk=yeni;
            return;
        }
        Dugum temp=this.ilk;
        while(temp.getSonraki()!=null){
            temp=temp.getSonraki();
        }
        //döngü çıkışında temp en son düğüm üzerine konumlanmıştır
        temp.setSonraki(yeni);
    }
    



    //listedeki eleman sayısını hesaplama
    public void elemanSayisi(){
        int sayac=0;
        Dugum temp=this.ilk;
        while(temp!=null){
            sayac++;
            temp=temp.getSonraki();
        }
        System.out.println("Eleman sayısı: "+sayac);
    }

    //listedeki tüm elemanların değerlerini ekrana yazdırma
    public void listele(){
        Dugum temp=this.ilk;
        if(temp==null){
          System.out.println("Liste boş");
          return;
        }
        while (temp!=null){
            temp.yazdir();
            //temp=temp.sonraki;
            temp=temp.getSonraki();

        }


    }

    //listede bir değeri arar ve bulduğunda o düğümü geri döndürür
     
    public Dugum elemanBul(int deger){
       Dugum temp=this.ilk;
       Dugum bulunan=null;
       while(temp!=null){
        if(temp.getVeri()!=deger){
            temp=temp.getSonraki();
        }
        else{
           temp=bulunan;
           break;
        }

       }
       return bulunan;
    }

    //ödev1: aranan değerden listede kaç tane olduğunu geri döndüren fonksiyonu kodlayınız
    public void sorguAdet(int aranan){
        int adet=0;
        Dugum temp=this.ilk;
        while(temp!=null){
            if(temp.getVeri()!=aranan){
                temp=temp.getSonraki();
            }
            else{
                adet++;
                temp=temp.getSonraki();
            }
            
        }
        System.out.println("Aradığın değerin adedi: "+adet);
    }

    // değeri verilen listede herhangi bir indexe ekleyen fonksiyon
    public void arayaEkle(int deger,int indis){

        if((this.ilk==null)||(indis==1)){//liste boş ise
            this.basaEkle(deger);
            return;
        }
        Dugum yeni=new Dugum(deger);
        Dugum temp=this.ilk;
        int sayac=1;
        while(temp.getSonraki()!=null){//eklenecek yerin bir önceki düğümüne temp in konumlandırılması
           if(sayac+1==indis){
            break;
           }
           sayac++;
           temp=temp.getSonraki();
        }
        if(temp==null){
            this.sonaEkle(deger);
            return;
        }
        yeni.setSonraki(temp.getSonraki());//yeşil bağlantı
        temp.setSonraki(yeni);//mavi bağlantı


    }
//ödev2:araya ekle fonksiyonunun sonaEkle fonk kullanılacak şekilde revize edilmesi (YAPTIM)

//ödev3:sıralıEkle fonksiyonu değerleri sayısal olarak sıralı ekleyecek şekilde yazılacak(indis parametresi olmayan)(YAPTIM)

public void siraliEkle(int deger) {
    Dugum yeni = new Dugum(deger);
    if (this.ilk == null) {
        // Liste boş, yeni düğüm ilk düğüm olacak
        this.basaEkle(deger);
    } else if (deger < this.ilk.getVeri()) {
        // Yeni düğüm ilk düğümden küçük, başa ekle
        this.basaEkle(deger);
    } else {
        Dugum temp = this.ilk;
        while (temp.getSonraki() != null && deger > temp.getSonraki().getVeri()) {
            temp = temp.getSonraki();
        }
        yeni.setSonraki(temp.getSonraki());
        temp.setSonraki(yeni);
    }
}


//ödev4:eleman silme(değere ve indise göre)(YAPTIM)
//Liste boş olabilir                                            0 döndürsün
//Silmek istediğimiz listede bulunmayabilir                    -2
//Silmek istediğimiz o indiste bulunmayabilir                  -1
//Silme işlemi tamamlandı                                       1

public int elemanSil(int deger,int indis){
    int sayac=1;
    if(this.ilk==null){
        return 0;
    }
    Dugum temp=this.ilk;
    Dugum yeni=null;
    yeni=temp.getSonraki();
    while(deger!=temp.getVeri()){//değeri listede bulamadı 
        sayac++;
        temp=yeni;
        yeni=temp.getSonraki();
        if(yeni==null){
            return -1;
        }
    }
    if(deger==temp.getVeri()&&indis!=sayac){
      return -1;
    }
    else{
        elemanSil(deger);
        return 1;
    }
    


}
    
    
    //ödev5:verilen değeri listeden silen fonksiyonu yazınız(aynı değerden birden fazla varsa hepsini sil)
    public void hepsiniSil(int deger) {
        if (this.ilk == null) {
            System.out.println("Liste boş");
            return;
        }
        Dugum temp = this.ilk;
        Dugum onceki = null;
    
        while (temp != null && temp.getVeri() == deger) {
            this.ilk = temp.getSonraki();
            temp = this.ilk;
        }
    
        while (temp != null) {
            while (temp != null && temp.getVeri() != deger) {
                onceki = temp;
                temp = temp.getSonraki();
            }
            if (temp == null) {
                return;
            }
            onceki.setSonraki(temp.getSonraki());
            temp = onceki.getSonraki();
        }
    }


                                           //verilen değerin ilkini  silen fonksiyon 
    //1. liste boş olabilir
    //2. listenin ilk elemanı silinirse liste başı değişecektir
    //3. silenecek değer listede yok silme işlemi gerçekleşmez
    //4. değer listeden silinir 
    //silme işlemi başarılı ise 0 döndürsün
    //liste boşsa -1 döndürsün
    //eleman bulunmazsa (dolayısıyla silinmezse) -2 döndürsün
      public int elemanSil(int deger){
        if(this.ilk==null){
            return -1;
        }
        if(this.ilk.getVeri()==deger){// listenin ilk elemanı silinirse
           this.ilk=this.ilk.getSonraki();
           return 0;
        }
        Dugum temp=this.ilk;
        while(temp.getSonraki().getVeri()!=deger){
            if(temp.getSonraki().getSonraki()==null){//listede eleman yoktur silinemez
                return -2;
            }
            temp=temp.getSonraki();
        }
        temp.setSonraki(temp.getSonraki().getSonraki());
        return 0;
        }


      }
