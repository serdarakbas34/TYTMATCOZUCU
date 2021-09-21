public class Sorular{
    public static int soru1(int pay,int payda){
        return pay/payda;
    }
    public static void soru2(int[] Secenekler,int sayi1,int sayi2,int sayi3 ,int sayi4){
       int sonuc1=(sayi1/sayi2) (sayi3/sayi4)
int sonuc2= (sayi1/sayi3)+(sayi2/sayi4)
int sonuc3=(sayi3/sayi2) + (sayi1/sayi4)
int sonuc4=(sayi3/sayi1)+ (sayi2/sayi4)
for(int i=0;i<Secenekler.lenght;i++){
    if(Secenekler[i]!=sonuc1 && Secenekler[i]!=sonuc2 && Secenekler[i]!=sonuc3 && Secenekler[i]!=sonuc4 ){
        System.out.println(Secenekler[i]);
        break;
    }
}
public static int soru3(String [] kelimeler){
    int sayac=0;
    for(int i=0;i<kelimeler.Lenght;i++){
        if((kelimeler[i].charAt(0)=='A' && kelimeler[i].charAt(kelimeler[i].lenght-1) == 'N') ||(kelimeler[i.charAt(0)!='A' && kelimeler[i].charAt(kelimeler[i].lenght-1) == 'N')){
            sayac++;
    
}
    }
    return sayac;
}

    }

     public static void main(String []args){

     }
}