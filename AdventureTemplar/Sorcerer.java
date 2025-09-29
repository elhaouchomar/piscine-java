public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

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
        int newHealth = c.getCurrentHealth() + healCapacity;
        if (newHealth > c.getMaxHealth()) {
            newHealth = c.getMaxHealth();
        }
        c.setCurrentHealth(newHealth);

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
