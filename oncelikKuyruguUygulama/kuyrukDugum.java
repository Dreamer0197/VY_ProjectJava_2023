public class kuyrukDugum {
    private int veri;
    private kuyrukDugum sonraki;
    private int oncelik;
    
    public kuyrukDugum(){
        this.veri=0;
        this.sonraki=null;
        this.oncelik=0;
    }
    public kuyrukDugum(int deger,int oncelik){
        this.veri=deger;
        this.sonraki=null;
        this.oncelik=oncelik;
    }
    public int getVeri() {
        return veri;
    }
    public kuyrukDugum getSonraki() {
        return sonraki;
    }
    public int getOncelik() {
        return oncelik;
    }
    public void setVeri(int veri) {
        this.veri = veri;
    }
    public void setSonraki(kuyrukDugum sonraki) {
        this.sonraki = sonraki;
    }
    public void setOncelik(int oncelik) {
        this.oncelik = oncelik;
    }

    public void yazdir(){
        System.out.println("Deger:" + this.veri +"  --  Oncelik:"+ this.oncelik);
    }
    
    
}
