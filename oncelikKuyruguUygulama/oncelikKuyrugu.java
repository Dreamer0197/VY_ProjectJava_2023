public class oncelikKuyrugu {

    private kuyrukDugum on;
    private kuyrukDugum arka;

    public oncelikKuyrugu(){
        this.on=this.arka=null;
    }

    public boolean bosmu (){
        if(this.on==null){
            return true;
        }
        return false;
    }


    public int cikart(){
        if(this.bosmu()){
            return -1;
        }
        int veri=this.on.getVeri();
        if(this.on.getSonraki()==null){  //kuyrukta kimse kalmadı
            this.arka=null;
        }
        this.on=this.on.getSonraki();
        return veri;
    }



    public void ekle (int deger, int öncelik){
        kuyrukDugum yeni=new kuyrukDugum(deger, öncelik);
        if(this.bosmu()){  //kuyrukta kimse yok
            this.on=yeni;
            this.arka=yeni;
            return;
        }
        if(yeni.getOncelik()<this.on.getOncelik()){   //yeni gelen en baştakinden daha öncelikli durumu (başa ekle)
            yeni.setSonraki(this.on);
            this.on=yeni;
            return;
        }
        if(yeni.getOncelik()>=this.arka.getOncelik()){//yeni gelen en sonrakinden daha az yada aynı öncelikli durumu (sona ekle)
            this.arka.setSonraki(yeni);
            this.arka=yeni;
            return;
        }
        kuyrukDugum temp=this.on;
        while(temp.getSonraki() != null){
            if(yeni.getOncelik()<temp.getSonraki().getOncelik()){
                // araya ekle
                yeni.setSonraki(temp.getSonraki());
                temp.setSonraki(yeni);
                return;
            }
            else{
                //ilerle
                temp=temp.getSonraki();
            }
        }


    }


    public void listele(){
        kuyrukDugum temp=this.on;

        if(temp==null){
            System.out.println("Liste boş");
            return;
        }
        System.out.println("Liste elemanları:");
        while(temp!=null){
            temp.yazdir();
            temp=temp.getSonraki();
        }
    }



    
}
