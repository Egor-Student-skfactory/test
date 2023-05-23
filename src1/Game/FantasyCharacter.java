package Game;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public abstract class FantasyCharacter implements Fighter {
    private String name;
    private int healthPoints;
    private int strength;
    private int dexterity;
    private int gold;
    private int xp;
    FantasyCharacter(String name,int healthPoints,int dexterity,int strength,int gold,int xp){
        this.name = name;
        this.healthPoints = healthPoints;
        this.dexterity = dexterity;
        this.strength = strength;
        this.gold = gold;
        this.xp = xp;
    }

    @Override
    public int attack() {
        if (dexterity * 3 > getRandomValue()) return strength;
        else return 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public String getName() {
        return name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getStrength() {
        return strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getGold() {
        return gold;
    }

    public int getXp() {
        return xp;
    }

    private int getRandomValue() {
        return (int) (Math.random() * 100);
    }
    public String toString(){
        return String.format("%s здоровье:%d",name,healthPoints);
    }


}
