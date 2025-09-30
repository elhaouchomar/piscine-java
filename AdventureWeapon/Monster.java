public class Monster extends Character {

    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() > 0) {
            return String.format("%s is a monster with %d HP. He has the weapon %s.",
                    getName(), getCurrentHealth(), getWeapon());
        }
        return String.format("%s is a monster and is dead. He has the weapon %s.",
                getName(), getWeapon());
    }

    @Override
    public void takeDamage(int damage) {
        setCurrentHealth(getCurrentHealth() - (int) (damage * 0.8));
    }

    @Override
    public void attack(Character c) {
        if (getDamage() > 0) {
            takeDamage(getDamage());
        } else {
            c.takeDamage(7);
        }
    }

}
