package localdb.model;

import localdb.model.base.ModelWithId;

public class Tool implements ModelWithId<Integer> {
    private int id;

    private String name;
    private float damage;
    private float hardness;
    private Enchant enchant;

    public Tool() {
    }

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

    public float getDamage() {
        return damage;
    }

    public Tool setDamage(float damage) {
        this.damage = damage;
        return this;
    }

    public float getHardness() {
        return hardness;
    }

    public Tool setHardness(float hardness) {
        this.hardness = hardness;
        return this;
    }

    public Enchant getEnchant() {
        return enchant;
    }

    public Tool setEnchant(Enchant enchant) {
        this.enchant = enchant;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "tool: " + name + "/hardness " + hardness + "/damage: " + damage;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Tool) {
            final Tool tool = (Tool) obj;
            return this.name.equals(tool.name) && this.enchant.equals(tool.enchant) && this.damage == tool.damage
                    && this.hardness == tool.hardness;
        } else return false;
    }
}
