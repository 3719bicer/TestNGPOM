package QA_Team1;

public class CDizelCorolla extends BCorolla {

    String yakit = "Dizel";
    String motor = "1.4 dizel motor";
    String renk = "Tanimlanmadi";

    public static void main(String[] args) {

        CDizelCorolla arb1 = new CDizelCorolla();
        System.out.println(arb1.motor);  // C 1.4 dizel motor
        System.out.println(arb1.renk); // C Tanimlanmadi
        System.out.println(arb1.yakit); // C Dizel
        System.out.println(arb1.uretimYeri); // B Turkiye
        System.out.println(arb1.marka); // A Toyota

        BCorolla corolla = new BCorolla();
        BCorolla arb2 = new CDizelCorolla();
        System.out.println(arb2.yakit); // B Tanimlanmadi
        System.out.println(arb2.renk); // B Belirtilmedi
        // arb2.motor data turu olarak secilen
        // BCorolla class'inda motor variable'i olmadigindan CTE verir.
        System.out.println(arb2.uretimYeri); // B Turkiye
        System.out.println(arb2.marka); // A Toyota

//        System.out.println("BCorolla() objesi : " + corolla.uretimYeri);
//        System.out.println("BCorolla() objesi : " + corolla.marka);

        AToyota arb3 = new CDizelCorolla();
        // arb3.motor  A'da motor yok
        // arb3.renk   A'da renk yok
        // arb3.yakit  A'da yakit yok
        System.out.println(arb3.uretimYeri); // A Deger atanmadi
        System.out.println(arb3.marka); // A Toyota
    }
}
