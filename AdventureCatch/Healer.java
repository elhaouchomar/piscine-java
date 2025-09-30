
public interface Healer {
    void heal(Character c) throws DeadCharacterException;
    int getHealCapacity();
}
