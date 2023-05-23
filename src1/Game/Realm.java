package Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Realm {
    private static BufferedReader br;
    private static BattleScene battleScene = null;
    private static FantasyCharacter player = null;

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        battleScene = new BattleScene();

        System.out.println("Уважаемый, введите имя персонажа");
        try {
            command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void command(String string) throws IOException {
        if (player == null) {
            player = new Hero(string, 100, 20, 20, 0, 0);
            System.out.println(String.format("Уважаемый,%s вызвался победить дракона,и спасти нас от неуважаемого", player.getName()));
            printNavigation();
        }
        switch (string) {
            case "1": {
                System.out.println("Торговец еще не создан");
                command(br.readLine());
                break;
            }
            case "2": {
                System.out.println("Удачи!,дальше больше");
                commitFight();
                break;
            }
            case "3": {
                System.exit(1);
                break;
            }
            case "да": {
                command("2");
                break;
            }
            case "нет": {
                printNavigation();
                command(br.readLine());
                break;
            }
        }
        command(br.readLine());
    }
        private static void commitFight() {
        battleScene.fight(player, createMonster(Monsters1.GOBLIN), new FightCallBack() {
            public void fightWin() {
                System.out.println("Хочешь продолжить свой нелегкий путь,или в город(да/нет");
                try {
                    command(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void fightLost() {
                System.out.println("Ну че по новой");
            }
        });
    }
    private static void printNavigation() {
        System.out.println("Куда вы хотите пойти?");
        System.out.println("1. К Торговцу");
        System.out.println("2. В темный лес");
        System.out.println("3. Выход");
    }
    private static FantasyCharacter createMonster(Monsters1 monster) {
        FantasyCharacter fantasyCharacter = null;
        switch (monster) {
            case GOBLIN: fantasyCharacter = new Goblin(
                    "Гоблин",
                    50,
                    10,
                    10,
                    100,
                    20
            );
                break;
            case SKELETON: fantasyCharacter = new Skeleton(
                    "Скелет",
                    25,
                    20,
                    20,
                    100,
                    10,
                    "Кость"
            );
                break;
        }
        return fantasyCharacter;
    }
    public enum Monsters1{
        GOBLIN,
        SKELETON
    }
    interface FightCallBack {
        void fightWin();
        void fightLost();
    }
}

