package tests.practice;

import org.testng.annotations.Test;

public class P02 {
    @Test(priority = 10)
    public void Ebru(){
        System.out.println("Ebru");
    }
    @Test (dependsOnMethods = "Can")
    public void Elif(){
        System.out.println("Elif");
    }

    @Test(priority = -5) // -5 en kcuk olddugu icin ilk bu test methodu calısır
    public void Zeynep(){
    System.out.println("Zeynep");
    }

    @Test (enabled = false)  // testi çalıştırmayı engeller
    public void Hasan(){
        System.out.println("Hasan");
    }

    @Test (dependsOnMethods = "Gul")
    public void Can(){
        System.out.println("can");
    }
    @Test
    public void Gul(){
        System.out.println("Gul");
    }
}
