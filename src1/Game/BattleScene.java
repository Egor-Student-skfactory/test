package Game;

public class BattleScene {
    public void fight(FantasyCharacter hero, FantasyCharacter monster,Realm.FightCallBack fightcallback){
        Runnable runnable = () -> {
            int turn = 0;
            boolean isFightEnd = false;
            while (!isFightEnd) {
                if (turn++ % 2 > 0) {
                    System.out.println("--Ход" + turn + "----");
                    isFightEnd = makeHit(monster, hero, fightcallback);
                } else {
                    System.out.println("--Ход" + turn + "----");
                    isFightEnd = makeHit(hero, monster, fightcallback);
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
    public Boolean makeHit(FantasyCharacter attacker,FantasyCharacter defender,Realm.FightCallBack callback){
        int hit = attacker.attack();
        int defenderHealth = defender.getHealthPoints() - hit;
        if (hit != 0){
            System.out.println(String.format("%s Нанес удар в количестве %d единиц ",attacker.getName(),hit));
            System.out.println(String.format("%s Получен урон в количестве %d единиц осталось %d здоровья",defender.getName(),defenderHealth - hit,defender.getHealthPoints()));
        }
        else {
            System.out.println(String.format(" Вы, Уважаемый, %s, промахнулись :(",attacker.getName()));
        }
        if (defender.getHealthPoints() < 0 && defender instanceof Hero){
            System.out.println("Вы пали в бою");
            callback.fightLost();
            return true;
        }
        else if(defenderHealth <= 0){
            System.out.println(String.format("Поздравляю Уважаемый %s у вас осталось %d",attacker.getName(),attacker.getHealthPoints()));
            attacker.setGold(attacker.getGold() + defender.getGold());
            attacker.setXp(attacker.getXp() + defender.getXp());
            callback.fightWin();
            return true;
        }
        else {
            defender.setHealthPoints(defenderHealth);
            return false;
        }
    }
}
