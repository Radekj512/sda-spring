package pl.sda.spring.factoryMethod;

public class Pizza {

    private Pizza(){
    }
    public static Pizza getInstance(){
        return new Pizza();
    }
}
