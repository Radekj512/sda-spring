package pl.sda.spring.bean;

import java.time.LocalDate;

public class LocalDateBean {
    private LocalDate localDate;

    public LocalDateBean(LocalDate localDate) {
        this.localDate = localDate;
    }

    public static LocalDate now() {
         return LocalDate.now();
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

}
