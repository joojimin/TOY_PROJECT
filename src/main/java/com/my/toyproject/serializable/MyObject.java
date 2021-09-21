package com.my.toyproject.serializable;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.StringJoiner;

public class MyObject implements Serializable {

    private static final long serialVersionUID = -3491748082462894312L;

    private Long id;
    private String name;
    private int age;
    private LocalDateTime registerTime;

    public MyObject(long id, String name, int age, LocalDateTime registerTime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.registerTime = registerTime;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public LocalDateTime getRegisterTime() {
        return registerTime;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MyObject.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("name='" + name + "'")
            .add("age=" + age)
            .add("registerTime=" + registerTime)
            .toString();
    }
}
