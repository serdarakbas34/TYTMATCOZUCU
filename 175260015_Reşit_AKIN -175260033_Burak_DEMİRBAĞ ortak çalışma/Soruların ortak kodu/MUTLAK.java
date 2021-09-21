/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mutlak;

import java.util.Scanner;

/**
 *
 * @author Reşit Akın
 */
public class MUTLAK {

      public static int esitsizlikprob(int enazartis,int enfazartis,int verilen){
    int enfazdeger,enazdeger,ortdeger,farkdeger;
   
    enazdeger=verilen+enazartis;
    enfazdeger=enazartis+verilen;
    ortdeger=((enazdeger+enfazdeger)/2);
    farkdeger=enfazdeger-enazdeger;
    
    return farkdeger;
    
    }
    public static void esitsizlikprob2(String a,String b){
        
        String s ="";
        int indis=0;
        for (int i = 0; i <a.length(); i++) {
            if (a.charAt(i)=='=') {
                indis=i;
                break;
                
            }
            
        }
        for (int i = indis+1; i <a.length(); i++) {
            s+=a.charAt(i);
            
            
        }
        int sonuc1=Integer.parseInt(s);
        s="";
        for (int i = 0; i <b.length(); i++) {
            if (b.charAt(i)=='=') {
                indis=i;
                break;
                
            }
            
        }
        for (int i = indis+1; i <b.length(); i++) {
            s+=b.charAt(i);
            
            
        }
         int sonuc2=Integer.parseInt(s);
        System.out.println("x+y=5/3");
    
    
    
    }
    
    public static void main(String[] args) {
        int tip;
        Scanner k=new Scanner(System.in);
            System.out.println("soru tipini giriniz:");
            tip=k.nextInt();
            if (tip==0) {
                int enazartis,enfazartis,verilen;
                System.out.println("en az girin");
    enazartis=k.nextInt();
        System.out.println("en fazlayı girin");
    enfazartis=k.nextInt();
        System.out.println("verilen değer");
    verilen=k.nextInt();
                System.out.println(esitsizlikprob(enazartis, enfazartis, verilen));
        }
            else{
            String denklem1,denklem2;
                System.out.println("denklemleri klavyeden giriniz");
                denklem1=k.next();
                denklem2=k.next();
                esitsizlikprob2(denklem1,denklem2);
                
            
            
            }
                    
                    
                    
                    
                    
        
    }
    
}
