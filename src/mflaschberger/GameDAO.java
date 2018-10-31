package mflaschberger;

import java.util.List;

public interface GameDAO {
    public List<Game> getItemCatalog();
    public List<Game> getFeaturedItemCatalog();
    public Game getSingleItem(String itemNum);
    public void addItem(Game Game);
    public void closeDB();


}
