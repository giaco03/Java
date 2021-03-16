package com.volpini;

import java.time.LocalDate;
import java.time.LocalTime;

public class TimeStamp {
    private LocalDate data;
    private LocalTime ora;

    public TimeStamp(LocalDate data, LocalTime ora) {
        this.data = data;
        this.ora = ora;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setOra(LocalTime ora) {
        this.ora = ora;
    }



    @Override
    public String toString() {
        return "data='" + data + '\'' +
                "ora='" + ora + '\'';
    }
}
