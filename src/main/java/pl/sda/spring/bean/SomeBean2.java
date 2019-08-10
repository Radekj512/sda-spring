package pl.sda.spring.bean;

import lombok.ToString;

@ToString
public class SomeBean2 {
    private String name;
    private int number;

    public SomeBean2() {
    }

    public SomeBean2(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
