public class Sorcerer extends Character implements Healer {
    private int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity) {
        super(name, maxHealth);
        this.healCapacity = healCapacity;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public void heal(Character c) {
        int curr = c.getCurrentHealth();
        curr += healCapacity;
        if (curr > c.getMaxHealth()) {
            curr = c.getMaxHealth();
        }
        c.currentHealth = curr;
    }

    @Override
    public String toString() {
        if (getCurrentHealth() > 0) {
            return String.format("%s is a sorcerer with %d HP. It can heal %d HP.", getName(), getCurrentHealth(),
                    healCapacity);
        }
        return String.format("%s is a dead sorcerer. So bad, it could heal %d HP.", getName(), healCapacity);
    }
}
