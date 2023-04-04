public class App {
    public static void main(String[] args) throws Exception {
        
        CBListe cbl=new CBListe();
        cbl.listele();
        cbl.arayaEkle(10,1);
        cbl.basaEkle(20);
        cbl.sonaEkle(30);
        cbl.arayaEkle(40,2);
        cbl.basaEkle(5);
        cbl.sonaEkle(10);
        cbl.listele();
        System.out.println("-------------------------");

        cbl.elemanSil(10);
        cbl.listele();
        System.out.println("-------------------------");
        cbl.elemanSil(10);
        cbl.listele();
    }
}
