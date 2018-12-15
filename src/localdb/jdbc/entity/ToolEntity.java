package localdb.jdbc.entity;

import localdb.jdbc.entity.base.EntityWithId;

public class ToolEntity implements EntityWithId<Integer> {

    private int id;

    private String name;

    private float damage;

    private float hardness;

    private int enchantId;

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

    public float getDamage() {
        return damage;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public float getHardness() {
        return hardness;
    }

    public void setHardness(float hardness) {
        this.hardness = hardness;
    }

    public int getEnchantId() {
        return enchantId;
    }

    public void setEnchantId(int enchantId) {
        this.enchantId = enchantId;
    }
}
