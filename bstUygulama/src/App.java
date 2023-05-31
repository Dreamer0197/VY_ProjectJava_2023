public class App {
    public static void main(String[] args) throws Exception {
     ikiliAramaAgac myTree=new ikiliAramaAgac();
     myTree.ekle(10);
     myTree.ekle(10);
     myTree.ekle(5);
     myTree.ekle(7);
     myTree.ekle(20);
     myTree.ekle(30);
     myTree.ekle(25);
     myTree.ekle(6);
     myTree.ekle(45);
     myTree.ekle(3);
     myTree.kokOrtadaDolas(myTree.kok);


     myTree.dugumSil(myTree.kok, 10);
     System.out.println(myTree.kok.veri);
     myTree.kokOrtadaDolas(myTree.kok);

     
     ikiliAgacDugum min=myTree.minDugum();
     System.out.println("Ağaçtaki min değer:"+min.veri);

     ikiliAgacDugum max=myTree.maxDugum();
     System.out.println("Ağaçtaki max değer:"+max.veri);

     ikiliAgacDugum bulunan=myTree.dugumBul(400);
     if(bulunan!=null){
     System.out.println("Bulunan değer:"+bulunan.veri);
    }
    else{
        System.out.println("Ağaçta bu değer yok");
    }







    }
}
