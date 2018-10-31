package mflaschberger;


import java.util.ArrayList;
import java.util.List;

public class GameList {
    private List<Game> GameCatalog = new ArrayList<>();
    private int nextGameNumber;

    public GameList() {
        nextGameNumber = 1;
        GameCatalog.add(new Game(nextGameNumber++, "Player Unknown Battle Grounds", 29.99, "\"PlayerUnknown's Battlegrounds (PUBG) is an online multiplayer battle royale game developed and published by PUBG Corporation."));
        GameCatalog.add(new Game(nextGameNumber++, "Fortnite", 0.00, "\"Fortnite Battle Royale is a free-to-play battle royale video game developed and published by Epic Games."));
        GameCatalog.add(new Game(nextGameNumber++, "Maddon 19", 59.99, " the next instalment of the Maddon Franchise"));
        GameCatalog.add(new Game(nextGameNumber++, "NBA 2K19", 59.99, "the next game in the 2K franchise with the amazing Greek Freak Giannis Antetokounmpo ."));
        GameCatalog.add(new Game(nextGameNumber++, "Super Mario party", 59.99, "the All new mario party for the switch going back to collecting stars and playing minigames with friends on the Nintendo Switch."));
        GameCatalog.add(new Game(nextGameNumber++, "Megaman 11", 29.99, "megaMan is back to stop dr wily and his Robots"));
        GameCatalog.add(new Game(nextGameNumber++, "Call of Duty Black ops 3", 59.99, "The 5th instalmment in the Black op series and the 15th in the Call of Duty series."));
        GameCatalog.add(new Game(nextGameNumber++, "Spider Man", 59.99, " Play as your friendly neighborhood spiderman as he swings around fighting villians."));
        GameCatalog.add(new Game(nextGameNumber++, "Dragon Ball Fighterz", 39.99, "dragon Ball Fighterz is a fighting full of your faviorte anime characters"));
    }

    public List<Game> getItemCatalog() {
        return GameCatalog;
    }

    public List<Game> getFeaturedItemCatalog() {
        List<Game> item = new ArrayList<>();

        for (Game i : GameCatalog) {
            if (i.isFeatured()) {
                item.add(i);
            }
        }
        return item;
    }

    public Game getSingleItem(int itemNum) {
        Game item = null;

        for (Game i : GameCatalog) {
            if (i.getGameNumber() == itemNum) {
                return i;
            }
        }
        return item;
    }
}



