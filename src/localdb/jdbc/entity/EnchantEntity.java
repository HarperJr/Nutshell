package localdb.jdbc.entity;

import localdb.jdbc.entity.base.EntityWithId;

import java.sql.Time;

public class EnchantEntity implements EntityWithId<Integer> {
    /**
     * Id
     */
    private int id;
    /**
     * Name of enchant
     */
    private String name;
    /**
     * Description to the enchant
     */
    private String description;
    /**
     * Time which during enchant could work
     */
    private Time duration;

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }
}
