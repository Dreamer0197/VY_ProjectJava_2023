public class yiginDugum {
    private int veri;
    private yiginDugum sonraki;

    public yiginDugum(){
        this.veri=0;
        this.sonraki=null;
    }
    public yiginDugum(int deger){
        this.veri=deger;
        this.sonraki=null;
    }
    public int getVeri() {
        return veri;
    }
    public yiginDugum getSonraki() {
        return sonraki;
    }
    public void setVeri(int veri) {
        this.veri = veri;
    }
    public void setSonraki(yiginDugum sonraki) {
        this.sonraki = sonraki;
    }
    


}
