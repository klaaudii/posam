package sk.posam.fsa.du.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;

public class JdbcApplication {

    private static final String url = "jdbc:postgresql://localhost:5434/dvdrental";
    private static final String user = "postgres";
    private static final String password = "password";

    private static final HikariConfig config = new HikariConfig();
    private static final HikariDataSource dataSource;


    static {
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);
        dataSource = new HikariDataSource(config);
    }

    public static void main(String[] args) {

        pocetHercov();
       // zoznamHercov();
        najdiHercaPodlaId(200);
        vlozHerca ("Janko", "Mrkva");
        pocetHercov();
    }

    /**
     * Metoda vypise pocet hercov v DB
     */
    private static void pocetHercov() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT count(*) FROM actor")) {
            resultSet.next();
            int count = resultSet.getInt(1);
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda vypise meno a priezvisko kazdeho herca ulozeneho v DB
     */
    private static void zoznamHercov() {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT actor_id, first_name, last_name FROM actor")) {
            while (resultSet.next()) {
                long id = resultSet.getLong("actor_id");
                String krstneMeno = resultSet.getString("first_name");
                String priezvisko = resultSet.getString("last_name");
                System.out.println(id + " " + krstneMeno + " " + priezvisko ); }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda najde v DB herca so zadanym ID a vrati ho ako navratovu hodnotu
     */
    private static Actor najdiHercaPodlaId(int actorId) {
        String sql = "SELECT actor_id,first_name,last_name FROM actor WHERE actor_id = ?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql))
        {
            pstmt.setInt(1, actorId);
            try(ResultSet resultSet = pstmt.executeQuery();){
                resultSet.next();
                return new Actor(resultSet.getString("first_name"), resultSet.getString("last_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Metoda vytvori v DB noveho herca a vrati true, ak sa ho podarilo vlozit
     */
    private static boolean vlozHerca(String meno, String priezvisko) {
        String sql = "INSERT INTO actor(first_name,last_name) VALUES(?,?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql))
        {
            pstmt.setString(1, meno);
            pstmt.setString(2, priezvisko);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
