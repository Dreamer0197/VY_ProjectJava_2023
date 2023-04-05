public class yigin {
    private yiginDugum yiginUst;//liste başını tutan değişken (ilk)
    public yigin(){
        this.yiginUst=null;
    }
    public boolean isEmpty(){
        if(this.yiginUst==null){
            return true;
        }
        return false;
    }
    public void push(int deger){
        yiginDugum yeni=new yiginDugum(deger);
        yeni.setSonraki(this.yiginUst);
        this.yiginUst=yeni;
    }
    public int pop(){
        if(this.isEmpty()){
            return -1;
        }
        int deger=this.yiginUst.getVeri();
        this.yiginUst=this.yiginUst.getSonraki();
        return deger;

    }
    public int peek(){
        if(this.isEmpty()){
            return -1;
        }
        return (this.yiginUst.getVeri());

    }
    

}
