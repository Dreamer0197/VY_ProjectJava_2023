public class avlAgac {
   public int getYukseklik(avlDugum d){
    if(d==null) return 0;
    return d.yukseklik;
   } 
   public int getBalance(avlDugum d){
    if(d==null) return 0;
    return getYukseklik(d.sol)-getYukseklik(d.sag);
   }
   public avlDugum solaDondur(avlDugum p){
    avlDugum pr=p.sag;
    avlDugum prl=pr.sol;

    //sola dondurme
    p.sag=prl;
    pr.sol=p;

    //yukseklikleri güncelle
    p.yukseklik=Math.max(getYukseklik(p.sol),getYukseklik(p.sol))+1;
    pr.yukseklik=Math.max(getYukseklik(pr.sol),getYukseklik(pr.sol))+1;
    return pr;
}
   public avlDugum sagaDondur(avlDugum p){
    avlDugum pl=p.sol;
    avlDugum plr=pl.sag;
    //sağa döndürme
    p.sol=plr;
    pl.sag=p;
    //yukseklikleri güncelle
    p.yukseklik=Math.max(getYukseklik(p.sol),getYukseklik(p.sol))+1;
    pl.yukseklik=Math.max(getYukseklik(pl.sol),getYukseklik(pl.sol))+1;
    return pl;

   }
   public avlDugum ekle(avlDugum d, int deger){
    if(d==null){
        return (new avlDugum(deger));
    }
    if(deger<d.veri){
        d.sol=ekle(d.sol,deger);
    }
    if(deger>d.veri){
        d.sag=ekle(d.sag,deger);
    }
    //yukseklik guncelleme
    d.yukseklik=Math.max(getYukseklik(d.sol), getYukseklik(d.sag))+1;
    //balance faktörü incele
    int bf=getBalance(d);
    //LL durumu
    if((bf>1) && (deger<d.sol.veri)){
        return sagaDondur(d);
    }

    //RR durumu
    if((bf<-1)&&(deger>d.sag.veri)){
        return solaDondur(d);
    }
    //LR durumu
    if((bf>1) && (deger<d.sol.veri)){
        d.sol=solaDondur(d.sol);
        return sagaDondur(d);
    }
    //RL durumu
    if((bf<-1) && (deger>d.sag.veri)){
        d.sag=sagaDondur(d.sag);
        return solaDondur(d);
    }
    //dengesizlik olmadığında d yi döndereceğiz
    return d;
   }
   

}
