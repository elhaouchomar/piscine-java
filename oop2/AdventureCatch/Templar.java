
public class Templar extends Character implements Healer, Tank {
    private final int healCapacity, shield;

    public Templar(String name, int maxHealth, int healCapacity, int shield, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
        this.shield = shield;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public void heal(Character c) throws DeadCharacterException {
        if (isDead())
            throw new DeadCharacterException(this);
        if (c.isDead())
            throw new DeadCharacterException(c);
        int newHealth = c.getCurrentHealth() + healCapacity;
        c.setCurrentHealth(Math.min(newHealth, c.getMaxHealth()));
    }

    @Override
    public int getShield() {
        return shield;
    }

    @Override
    public String toString() {
        if (this.getCurrentHealth() == 0) {
            return String.format(
                    "%s has been beaten, even with its %d shield. So bad, it could heal %d HP. He has the weapon %s.",
                    this.getName(), this.shield, this.healCapacity, this.getWeapon().toString());
        }

        return String.format(
                "%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d. He has the weapon %s.",
                this.getName(), this.getCurrentHealth(), this.healCapacity, this.shield, this.getWeapon().toString());
    }

    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        if (isDead())
            throw new DeadCharacterException(this);
        int actual = Math.max(0, damage - shield);
        setCurrentHealth(getCurrentHealth() - actual);
    }

    @Override
    public void attack(Character c) throws DeadCharacterException {
        if (isDead())
            throw new DeadCharacterException(this);
        int damage = getWeapon() != null ? getWeapon().getDamage() : 7;
        c.takeDamage(damage);
    }

}
