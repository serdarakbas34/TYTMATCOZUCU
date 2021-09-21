
public class CozumMantigi {
    static int usbulma(int taban,int us){
        int sonuc = taban;
        for (int i = 1; i<us ;i++){
            sonuc = sonuc*taban;
        }
        return sonuc;
    }
    static String islemler(String islem,String problem){
        int i = 1;
        while (i>0){
            if (problem.indexOf(islem)>0){
                String ilkyari = problem.substring(0,problem.indexOf(islem));
                String sonyari = problem.substring(problem.indexOf(islem)+1);
                int g_indis = 0,h_indis = 0;
                for (int q = ilkyari.length();q>0;q--){
                    String test = ilkyari.substring(q-1,q);
                    if (test.equals("^") || test.equals("*") || test.equals("/") || test.equals("+")|| test.equals("-")|| test.equals("(")){
                        g_indis = q;
                        break;
                    }
                }
                for (int q = 0 ;q<sonyari.length();q++){
                    String test = sonyari.substring(q,q+1);
                    if (test.equals("^") || test.equals("*") || test.equals("/") || test.equals("+")|| test.equals("-")|| test.equals(")")){
                        h_indis = q;
                        break;
                    }
                }
                int solsayi = Integer.parseInt(problem.substring(g_indis,problem.indexOf(islem)));
                int sagsayi = Integer.parseInt(problem.substring(problem.indexOf(islem)+1,ilkyari.length()+h_indis+1));
                int sonuc = 0;
                if (islem.equals("^"))
                    sonuc = usbulma(solsayi,sagsayi);
                else if (islem.equals("*"))
                    sonuc = solsayi*sagsayi;
                else if (islem.equals("/"))
                    sonuc = solsayi/sagsayi;
                else if (islem.equals("+"))
                    sonuc = solsayi+sagsayi;
                else if (islem.equals("-"))
                    sonuc = solsayi-sagsayi;
                problem = problem.substring(0,g_indis)+sonuc+problem.substring(ilkyari.length()+h_indis+1);
                System.out.println(problem);
            }
            else{
                break;
            }
        }
        return problem;
    }
    public static void main(String[] args) {

        String problem= "(5^3*2^4+5^4*2^3)/35";
        String problemyedek = problem;
        if (problem.substring(0,1).equals("(")){//ilk indis parantez ise
            problem = problem.substring(0,problem.indexOf(")")+1);
            problem = islemler("^",problem);
            problem = islemler("*",problem);
            problem = islemler("/",problem);
            problem = islemler("+",problem);
            problem = islemler("-",problem);
            problem = problem.substring(problem.indexOf("(")+1,problem.indexOf(")"));
            String islem = problemyedek.substring(problemyedek.indexOf(")")+1,problemyedek.indexOf(")")+2);
            problem = problem + islem + problemyedek.substring(problemyedek.indexOf(")")+2);
            problem = islemler(islem,"("+problem+")");
            problem = problem.substring(problem.indexOf("(")+1,problem.indexOf(")"));
            System.out.println(problem);
        }else{
            problem = "(" + problem + ")";
            problem = islemler("^",problem);
            problem = islemler("*",problem);
            problem = islemler("/",problem);
            problem = islemler("+",problem);
            problem = islemler("-",problem);
            problem = problem.substring(problem.indexOf("(")+1,problem.indexOf(")"));
            System.out.println(problem);
        }
    }
}
