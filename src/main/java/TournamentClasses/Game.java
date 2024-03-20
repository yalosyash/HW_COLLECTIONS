package TournamentClasses;

import DataClasses.Player;
import Exceptions.NotRegisteredException;

import java.util.HashMap;

public class Game {
    private HashMap<String, Integer> map = new HashMap<>();

    public void register(Player player) {
        map.put(player.getName(), player.getStrength());
    }

    public int round(String playerName1, String playerName2) {
        int strengthP1 = findPlayer(playerName1);
        int strengthP2 = findPlayer(playerName2);

        if (strengthP1 > strengthP2) {
            return 1;
        } else if (strengthP1 < strengthP2) {
            return 2;
        }
        return 0;
    }

    private int findPlayer(String playerName) {
        for (String player : map.keySet()) {
            if (player.equals(playerName)) {
                return map.get(player);
            }
        }
        throw new NotRegisteredException(playerName);
    }
}