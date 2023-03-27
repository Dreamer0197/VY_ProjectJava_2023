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
    public void sonaEkle(Dugum yeni){
        if(this.ilk==null){
            this.ilk=yeni;
            return;
        }
        Dugum temp=this.ilk;
        while(temp.getSonraki()!=null){
            temp=temp.getSonraki();
        }
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
        yeni.setSonraki(temp.getSonraki());//yeşil bağlantı
        temp.setSonraki(yeni);//mavi bağlantı



    }
//ödev2:araya ekle fonksiyonunun sonaEkle fonk kullanılacak şekilde revize edilmesi
//ödev3:sıralıEkle fonksiyonu değerleri sayısal olarak sıralı ekleyecek şekilde yazılacak(indis parametresi olmayan)
//ödev4:eleman silme(değere ve indise göre)

    
}
