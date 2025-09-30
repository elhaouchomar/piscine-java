public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer(String name, int maxHealth, int healCapacity, Weapon weapon) {
        super(name, maxHealth, weapon);
        this.healCapacity = healCapacity;
    }

    @Override
    public int getHealCapacity() {
        return healCapacity;
    }

    @Override
    public void heal(Character c) throws DeadCharacterException {
        if (c.getCurrentHealth() == 0) {
            throw new DeadCharacterException(c);
        }
        int newHealth = c.getCurrentHealth() + healCapacity;
        if (newHealth > c.getMaxHealth()) {
            newHealth = c.getMaxHealth();
        }
        c.setCurrentHealth(newHealth);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() > 0) {
            return String.format("%s is a sorcerer with %d HP. It can heal %d HP. He has the weapon %s.",
                    getName(), getCurrentHealth(), healCapacity, getWeapon());
        }
        return String.format("%s is a dead sorcerer. So bad, it could heal %d HP. He has the weapon %s.",
                getName(), healCapacity, getWeapon());
    }

    @Override
    public void takeDamage(int damage) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }
        setCurrentHealth(getCurrentHealth() - damage);
    }

    @Override
    public void attack(Character c) throws DeadCharacterException {
        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }

        try {
            heal(this);
        } catch (DeadCharacterException e) {
            System.out.println(e.getMessage());
        }

        int damage = (getWeapon() != null) ? getWeapon().getDamage() : 10;

        try {
            c.takeDamage(damage);
        } catch (DeadCharacterException e) {
            System.out.println(e.getMessage());
        }
    }

}
