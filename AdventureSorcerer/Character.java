import java.util.ArrayList;
import java.util.List;

public class Character {

    private final int maxHealth;
    public int currentHealth;
    private final String name;
    private static List<Character> allCharacters = new ArrayList<>();

    public Character(String name, int maxHealth) {
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;
        this.name = name;
        allCharacters.add(this);
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        if (currentHealth == 0) {
            return String.format("%s : KO", name);
        }
        return String.format("%s : %d/%d", name, currentHealth, maxHealth);
    }

    public void takeDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth < 0) {
            currentHealth = 0;
        }
    }

    public void attack(Character hero) {
        hero.takeDamage(9);
    }

    public static String printStatus() {
        int count = 0;
        String str = "------------------------------------------\nCharacters currently fighting :\n";
        for (Character c : allCharacters) {
            str += String.format(" - %s\n", c.toString());
            count++;
        }
        str += "------------------------------------------\n";

        if (count == 0) {
            str = "------------------------------------------\n" + //
                    "Nobody's fighting right now !\n" + //
                    "------------------------------------------\n";
        }
        return str;
    }

    public static Character fight(Character c1, Character c2) {
        while (true) {
            c1.attack(c2);
            if (c2.currentHealth == 0) {
                return c1;
            }
            c2.attack(c1);
            if (c1.currentHealth == 0) {
                return c2;
            }
        }
    }
}