
public class CBListe {
        private Dugum ilk;
        public CBListe(){

    
            this.ilk=null;
        
        }
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
        public void elemanSayisi(){
            int sayac=0;
            Dugum temp=this.ilk;
            while(temp!=null){
                sayac++;
                temp=temp.getSonraki();
            }
            System.out.println("Eleman sayısı: "+sayac);
        }
        public void basaEkle(int deger){
         
        Dugum yeni=new Dugum(deger);
        if(this.ilk==null){
            
            this.ilk=yeni;
            return;
        
        }
        this.ilk.setOnceki(yeni);
        yeni.setSonraki(this.ilk);
        this.ilk=yeni;
    
       }
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
            temp.getSonraki().setOnceki(yeni);
            temp.setSonraki(yeni);
            yeni.setOnceki(temp);
        }
    }
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
        temp.setSonraki(yeni);
        yeni.setOnceki(temp);
    
       }
        public void arayaEkle(int deger,int indis){
    
        if((this.ilk==null)||(indis==1)){
            this.basaEkle(deger);
            return;
        }
        Dugum yeni=new Dugum(deger);
        Dugum temp=this.ilk;
        int sayac=1;
        while(temp.getSonraki()!=null){
           if(sayac+1==indis){
            break;
           }
           sayac++;
           temp=temp.getSonraki();
        }
        temp.getSonraki().setOnceki(yeni);
        yeni.setSonraki(temp.getSonraki());
        temp.setSonraki(yeni);
        yeni.setOnceki(temp);
    
    }
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
        public int elemanSil(int deger){
        if(this.ilk==null){//liste boş ise
            return -1;
        }
        if(this.ilk.getVeri()==deger){// listenin ilk elemanı silinirse
           this.ilk=this.ilk.getSonraki();
           this.ilk.setOnceki(null);
           return 0;
        }
        Dugum temp=this.ilk;
        while(temp.getVeri()!=deger){
            if(temp.getSonraki()==null){//listede eleman yoktur silinemez
                return -2;
            }
            temp=temp.getSonraki();
        }
        //temp değişkeni silinecek düğümün üzerine konumlandı
        if(temp.getSonraki()!=null){
            temp.getSonraki().setOnceki(temp.getOnceki());
            temp.getOnceki().setSonraki(temp.getSonraki()); 
        }
        else{
            temp.getOnceki().setSonraki(null);
        }
        return 0;
    }
}

