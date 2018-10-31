package mflaschberger;

public class Game
{
    private int gameNumber;
    private String gameName;
    private double price;
    private String gameDescription;
    private boolean featured;

    public Game(int gameNumber, String gameName, double price, String gameDescription)
    {
        this.gameNumber = gameNumber;
        this.gameName = gameName;
        this.price = price;
        this.gameDescription = gameDescription;
        this.featured = true;
    }

    public boolean isFeatured() {
        return featured;
    }

    public int getgameNumber() {
        return gameNumber;
    }

    public String getgameName()
    {
        return gameName;
    }

    /*public void setGameName(String gameName)
    {
        this.gameName = gameName;
    }*/

    public double getPrice()
    {
        return price;
    }

    /*public void setPrice (double price)
    {
        this.price = price;
    }*/

    public String getgameDescription()
    {
        return gameDescription;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    /*public void setgameDescription(String gameDescription)
    {
        this.gameDescription = gameDescription;
    }*/

}

