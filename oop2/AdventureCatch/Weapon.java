public class Weapon {
    private final String name;
    private final int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return String.format("%s deals %d damages", name, damage);
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }
}
