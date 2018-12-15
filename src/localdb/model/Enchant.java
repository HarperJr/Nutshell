package localdb.model;

import localdb.model.base.ModelWithId;

import java.sql.Time;

public class Enchant implements ModelWithId<Integer> {
    private int id;

    private String name;
    private String description;
    private Time duration;

    public Enchant() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public Enchant setDescription(String description) {
        this.description = description;
        return this;
    }

    public Time getDuration() {
        return duration;
    }

    public Enchant setDuration(Time duration) {
        this.duration = duration;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Enchant) {
            final Enchant enchant = (Enchant) obj;
            return this.id == enchant.id && this.name.equals(enchant.name) && this.description.equals(enchant.description);
        } else {
            return false;
        }
    }
}
