import Game.FantasyCharacter;

import java.util.*;

public class BackPack {

    public static void main(String[] args) {
       List<String> list1 = new ArrayList<>();
    }
    public static void AddInBackPack(List<String> list1, FantasyCharacter fantasyCharacter){
        list1.add(fantasyCharacter.getName());
        System.out.println(list1);
    }
}
