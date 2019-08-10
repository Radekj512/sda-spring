package pl.sda.spring.bean;


import lombok.ToString;

@ToString
public class SomeBean {
    private String name;

    public SomeBean() {
    }

    public SomeBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
