public class CBListe(
    private Dugum ilk;
    public CBListe(){
        this.ilk=null;
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
)