public class Monster extends Character {

    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() > 0) {
            return String.format("%s is a monster with %d HP", getName(), getCurrentHealth());
        }
        return String.format("%s is a monster and is dead", getName());
    }

    @Override
    public void takeDamage(int damage) {
        setCurrentHealth(getCurrentHealth() - (int) (damage * 0.8));
    }

    @Override
    public void attack(Character c) {
        c.takeDamage(7);
    }

}
