
import java.util.Scanner;


public class tytmat2 {
    public static void main(String[] args) {
  
    Scanner input = new Scanner(System.in);
    Double x = null, y = null, x1 =null ,m,c,a;
    String fx = null, gx = null, fog = null,fonksiyonOlustur ="";

        Boolean BaskaDegiskenVar = false;
        if (BaskaDegiskenVar == true){
            FonksiyonOlustur();
        }
        else{
            System.out.println("c sabitini giriniz.");
            c = input.nextDouble();
        }
        if(fx == null){
            fx = fonksiyonOlustur;
            BaskaDegiskenVar = false;
        }
        System.out.println("gx fonksiyonu oluþtur");
        if(BaskaDegiskenVar == true){
            FonksiyonOlustur();
        }
        else{
            System.out.println("c sabitini giriniz.");
            c = input.nextDouble();
        }
        if(gx == null){
            gx = fonksiyonOlustur;
            BaskaDegiskenVar = false;
        }
        System.out.println("x1 deðerini giriniz");
        x1 = input.nextDouble();
        System.out.println("y deðerini giriz");
        y = input.nextDouble();
        System.out.println("f(x) fonksiyonu: "+fx+"/n gx fonksiyonu: "+gx);
        // x^m hesaplama fonksiyonu
        double d =hesapla(x1,m);
        fx = axd+c;
        gx = axd+c;

        sonuchesapla();
    }

    private static void FonksiyonOlustur() {

        System.out.println("a ve m deðerlerini giriniz");
        a = input.nextDouble();
        fonksiyonOlustur += a;
        m = input.nextDouble();
        fonksiyonOlustur += "x^"+m;
    }
    private static Double hesapla(Double x, Double y){
        Double sonuc;
        for (int i =0; i<y;i++){
            sonuc +=x;
        }
        return sonuc;
    }
    private double sonuchesapla(){
        fx = fy - gx;
        g(x) = fy-fx;
        
        f+g = fy;
        fx = fy-gx;
        gx = fy -fx;
        return axb;
    }

}
