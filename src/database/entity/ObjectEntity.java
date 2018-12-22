package database.entity;

import database.entity.base.BaseEntity;

public class ObjectEntity implements BaseEntity<Integer> {

    private int id;

    private String name;

    private String type;

    public String getName() {
        return name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
