package com.elrain.whattocook.dao;

/**
 * Created by elrain on 05.06.15.
 */
public class NamedEntity {
    private long id;
    private String name;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "NamedEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
