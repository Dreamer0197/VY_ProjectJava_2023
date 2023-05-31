public class ikiliAramaAgac {
    public ikiliAgacDugum kok;
    public ikiliAramaAgac(){
        this.kok=null;
    }
    public void ekle(int deger){
        ikiliAgacDugum yeni=new ikiliAgacDugum(deger);
        if(this.kok==null){
            this.kok=yeni;
            System.out.println("Kök:"+deger);
            return;
        }
        ikiliAgacDugum parent=null;
        ikiliAgacDugum temp=this.kok;
        while(true){
            parent=temp;
            if(deger<temp.veri){
              temp=temp.sol;
              if(temp==null){
                parent.sol=yeni;
                System.out.println("Parent:"+parent.veri+ " soluna "+yeni.veri+" eklendi");
                return;
              }
            }
            else if(deger>temp.veri){
                temp=temp.sag;
                if(temp==null){
                  parent.sag=yeni;
                  System.out.println("Parent:"+parent.veri+ " sağına "+yeni.veri+" eklendi");
                  return;
                }
              }
              else{
                System.out.println("Bu deger var");
                return;
              }
        }
    }
    public ikiliAgacDugum minDugum(){
      if(this.kok==null){
        return null;
      }
      ikiliAgacDugum temp=this.kok;
      while(temp.sol!=null){
        temp=temp.sol;
      }
      return temp;
    }
    public ikiliAgacDugum maxDugum(){
      if(this.kok==null){
        return null;
      }
      ikiliAgacDugum temp=this.kok;
      while(temp.sag!=null){
        temp=temp.sag;
      }
      return temp;
    }
    public void kokOrtadaDolas(ikiliAgacDugum localRoot){
        if(localRoot!=null){
            kokOrtadaDolas(localRoot.sol);
            localRoot.yazdir();
            kokOrtadaDolas(localRoot.sag);
        }

     }
    public ikiliAgacDugum dugumBul(int deger){
      if(this.kok==null){
        return null;
      }
      ikiliAgacDugum temp=this.kok;
      while(temp!=null){
        if(temp.veri==deger){
           return temp;
        }
        else if(deger<temp.veri){
          temp=temp.sol;
        }
        else{
          temp=temp.sag;
        }
      }
      return null;
    }
    public ikiliAgacDugum dugumSil(ikiliAgacDugum kokDugum, int deger){
      if(kokDugum==null){
        System.out.println("Silme başarısız");
        return null;
      }
      if(deger<kokDugum.veri){
        kokDugum.sol=dugumSil(kokDugum.sol, deger);
        return kokDugum;     
      }
      else if(deger>kokDugum.veri){
        kokDugum.sag=dugumSil(kokDugum.sag, deger);
        return kokDugum;
      }
      else{
        if((kokDugum.sol==null)&&(kokDugum.sag==null)){
          System.out.println("Yaprak düğüm silme");
          kokDugum=null;
          return null;
        }
        else if(kokDugum.sol!=null&&kokDugum.sag==null){
           kokDugum=kokDugum.sol;
           System.out.println("Tek sol çocuklu düğüm silme");
           return kokDugum;
        }
        else if(kokDugum.sol==null&&kokDugum.sag!=null){
          kokDugum=kokDugum.sag;
          System.out.println("Tek sağ çocuklu düğüm silme");
          return kokDugum;
       }
       else{
        System.out.println("İki  çocuklu düğüm silme silme");
        ikiliAgacDugum temp=minDugum(kokDugum.sag);
        kokDugum.veri=temp.veri;
        kokDugum.sag=dugumSil(kokDugum.sag, temp.veri);
        return kokDugum;
       }
      }
      
    }
    public ikiliAgacDugum minDugum(ikiliAgacDugum kokDugum){
      if(kokDugum==null){
        return null;
      }
      ikiliAgacDugum temp=kokDugum;
      while(temp.sol!=null){
        temp=temp.sol;
      }
      return temp;
     }
  
  
  
  
  }
