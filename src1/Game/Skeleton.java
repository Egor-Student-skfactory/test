package Game;

public class Skeleton extends FantasyCharacter {
    String loot;
    Skeleton(String name, int healthPoints, int dexterity,int strength, int gold, int xp,String loot) {
        super(name, healthPoints, dexterity,strength, gold, xp);
        this.loot = "Кость";
    }
}
