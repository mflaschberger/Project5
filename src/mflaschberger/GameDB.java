package mflaschberger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class GameDB {

    public GameDB()
    {

        try
        {
            // Create a named constant for the URL.
            // NOTE: This value is specific for Java DB.
            final String DB_URL = "jdbc:derby:gameDB;create=true";

            // Create a connection to the database.
            Connection conn =
                    DriverManager.getConnection(DB_URL);

            // If the DB already exists, drop the tables.
            dropTables(conn);

            // Build the game table.
            buildgameTable(conn);

            // Build the Customer table.
            buildCustomerTable(conn);

            // Close the connection.
            conn.close();
        } catch (Exception e)
        {
            System.out.println("Error Creating the game Table");
            System.out.println(e.getMessage());
        }

    }

    public static void dropTables(Connection conn)
    {
        System.out.println("Checking for existing tables.");

        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            try
            {
                // Drop the Customer table.
                stmt.execute("DROP TABLE Customer");
                System.out.println("Customer table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }

            try
            {
                // Drop the game table.
                stmt.execute("DROP TABLE game");
                System.out.println("game table dropped.");
            } catch (SQLException ex)
            {
                // No need to report an error.
                // The table simply did not exist.
            }
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * The buildgameable method creates the
     * Coffee table and adds some rows to it.
     */
    public static void buildgameTable(Connection conn)
    {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE game (" +
                    "ProdNum INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                    "ProdName CHAR(50), " +
                    "Price DOUBLE, " +
                    "Description CHAR(200)," +
                    "Featured BOOLEAN" +
                    ")");

            // Insert rows # 1 - 9.
            stmt.execute("INSERT INTO game  (ProdName, Price, Description, Featured) VALUES ( " +
                    "'Call of Duty Black ops 3', " +
                    "59.99, " +
                    "'The 5th instalmment in the Black op series and the 15th in the Call of Duty series.', " +
                    "true)");

            stmt.execute("INSERT INTO game  (ProdName, Price, Description, Featured) VALUES ( " +
                    "'Player Unknown Battle Grounds', " +
                    "400.00, " +
                    "'PlayerUnknowns Battlegrounds (PUBG) is an online multiplayer battle royale game developed and published by PUBG Corporation.'," +
                    "true)");

            stmt.execute("INSERT INTO game  (ProdName, Price, Description, Featured) VALUES ( " +
                    "'Fortnite', " +
                    "0.00, " +
                    "'Fortnite Battle Royale is a free-to-play battle royale video game developed and published by Epic Games.'," +
                    "true)");

            stmt.execute("INSERT INTO game  (ProdName, Price, Description, Featured) VALUES ( " +
                    "'Super Mario Party', " +
                    "59.99, " +
                    "'the All new mario party for the switch going back to collecting stars and playing minigames with friends on the Nintendo Switch.', " +
                    "true)");

            stmt.execute("INSERT INTO game  (ProdName, Price, Description, Featured) VALUES ( " +
                    "'Spider Man', " +
                    "59.99, " +
                    "'Play as your friendly neighborhood spiderman as he swings around fighting villians.', " +
                    "true)");

            stmt.execute("INSERT INTO game  (ProdName, Price, Description, Featured) VALUES ( " +

                    "'NBA 2K19', " +
                    "59.99, " +
                    "'the next game in the 2K franchise with the amazing Greek Freak Giannis Antetokounmpo .'," +
                    "true)");

            stmt.execute("INSERT INTO game  (ProdName, Price, Description, Featured) VALUES ( " +
                    "'Dragon Ball Fighterz', " +
                    "200.00, " +
                    "'dragon Ball Fighterz is a fighting full of your faviorte anime characters'," +
                    "true)");

            stmt.execute("INSERT INTO game  (ProdName, Price, Description, Featured) VALUES ( " +

                    "'Madden 19', " +
                    "360.00, " +
                    "'the next instalment of the Maddon Franchise'," +
                    "true)");



            System.out.println("game table created.");
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    /**
     * The buildCustomerTable method creates the
     * Customer table and adds some rows to it.
     */
    public static void buildCustomerTable(Connection conn)
    {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE Customer" +
                    "( CustomerNumber INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), " +
                    "  CustomerName CHAR(25)," +
                    "  Address CHAR(25)," +
                    "  City CHAR(12)," +
                    "  State CHAR(2)," +
                    "  Zip CHAR(5) )");

            // Add some rows to the new table.
            stmt.execute("INSERT INTO Customer  (CustomerName, Address, City, State, Zip) VALUES " +
                    "('.', '13400 Commons Dr.'," +
                    " 'Brookfield', 'WI', '53005')");

            stmt.execute("INSERT INTO Customer  (CustomerName, Address, City, State, Zip) VALUES " +
                    "('Best Buy.'," +
                    " '19555 W Bluemound Rd.'," +
                    " 'Brookfield', 'WI', '53045')");

            stmt.execute("INSERT INTO Customer  (CustomerName, Address, City, State, Zip) VALUES " +
                    "('.', '1615 Tallgrass Circle.'," +
                    " 'Waukesha', 'WI', '53188')");

            System.out.println("Customer table created.");
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}