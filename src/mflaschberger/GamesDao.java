package mflaschberger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GamesDao implements GameDAO {
    @Override
    public List<Game> getItemCatalog() {
        List<Game> gameList = new ArrayList<>();
        try
        {
            // Create a named constant for the URL.
            // NOTE: This value is specific for Java DB.
            final String DB_URL = "jdbc:derby:gameDB;create=true";

            // Create a connection to the database.
            Connection conn =
                    DriverManager.getConnection(DB_URL);

            Statement stmt = conn.createStatement();

            String sql = "SELECT ProdNum, ProdName, Price, Description FROM game";

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                int id = rs.getInt("ProdNum");
                String prodName = rs.getString("ProdName");
                double price = rs.getDouble("Price");
                String description = rs.getString("Description");

                Game game = new Game(id, prodName, price, description);
                gameList.add(game);
            }

            // Close the connection.
            conn.close();
        } catch (Exception e)
        {
            System.out.println("Error Creating the game Table");
            System.out.println(e.getMessage());
        }
        return gameList;
    }

    @Override
    public List<Game> getFeaturedItemCatalog() {
        List<Game> gameList = new ArrayList<>();
        try
        {
            // Create a named constant for the URL.
            // NOTE: This value is specific for Java DB.
            final String DB_URL = "jdbc:derby:gameDB;create=true";

            // Create a connection to the database.
            Connection conn =
                    DriverManager.getConnection(DB_URL);

            Statement stmt = conn.createStatement();

            String sql = "SELECT ProdNum, ProdName, Price, Description, Featured FROM game WHERE Featured = true";

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                int id = rs.getInt("ProdNum");
                String prodName = rs.getString("ProdName");
                double price = rs.getDouble("Price");
                String description = rs.getString("Description");

                Game game = new Game(id, prodName, price, description);
                gameList.add(game);
            }

            // Close the connection.
            conn.close();
        } catch (Exception e)
        {
            System.out.println("Error Creating the game Table");
            System.out.println(e.getMessage());
        }
        return gameList;
    }

    @Override
    public Game getSingleItem(String itemNum) {

        int id;
        String prodName;
        double price;
        String description;
        Game game = null;

        try
        {
            // Create a named constant for the URL.
            // NOTE: This value is specific for Java DB.
            final String DB_URL = "jdbc:derby:gameDB;create=true";

            // Create a connection to the database.
            Connection conn =
                    DriverManager.getConnection(DB_URL);

            Statement stmt = conn.createStatement();

            String sql = "SELECT ProdNum, ProdName, Price, Description FROM game WHERE ProdNum = " + itemNum;

            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                id = rs.getInt("ProdNum");
                prodName = rs.getString("ProdName");
                price = rs.getDouble("Price");
                description = rs.getString("Description");

                game = new Game(id, prodName, price, description);
            }

            // Close the connection.
            conn.close();
        } catch (Exception e)
        {
            System.out.println("Error Creating the game Table");
            System.out.println(e.getMessage());
        }
        return game;
    }

    @Override
    public void addItem(Game game) {
        try
        {
            // Create a named constant for the URL.
            // NOTE: This value is specific for Java DB.
            final String DB_URL = "jdbc:derby:gameDB;create=true";

            // Create a connection to the database.
            Connection conn =
                    DriverManager.getConnection(DB_URL);

            Statement stmt = conn.createStatement();

            String sql = "INSERT INTO game VALUES ( '" + game.getGameNumber() + "'," +
                    "'" + game.getgameName() + "'," +
                    "'" + game.getPrice() + "'," +
                    "'" + game.getgameDescription() + "'," +
                    "'" + game.isFeatured() + "')";

            stmt.execute(sql);

            // Close the connection.
            conn.close();
        } catch (Exception e)
        {
            System.out.println("Error Creating the game Table");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void closeDB() {

    }
}
