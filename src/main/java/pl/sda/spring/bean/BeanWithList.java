package pl.sda.spring.bean;

import lombok.ToString;

import java.util.List;

@ToString
public class BeanWithList {
    private List<Integer> list;

    public BeanWithList(List<Integer> list) {
        this.list = list;
    }

    public BeanWithList() {
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
