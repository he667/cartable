package com.ybi.dm.cartable.models;

import javax.persistence.Entity;
import java.time.LocalDateTime;

/**
 * Created by Bouddha on 26/11/2017.
 */
@Entity
public class Metrics {
    private String name;
    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    private LocalDateTime time;
}
