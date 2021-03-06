package data;

import application.Backware;
import application.Baeckerei;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Christoph on 02.10.2018.
 */
public class DatabaseManagement implements IDataManagement {
    private static final String DB_URL = "jdbc:sqlite:C:/USERS/USER/ideaProjects/AS_Baeckerliste/lib/database.sqlite";
    private Connection connection;
    private static final String selectAllBeackerei = "select * from baeckerei;";
    private static final String selectByIdBeackerei = "select * from baeckerei where baeckerei_id = ?;";
    private static final String insertBeackerei = "insert into baeckerei(name) values (?);";
    private static final String updateBeackerei = "UPDATE baeckerei SET name = ? WHERE baeckerei_id = ?;";
    private static final String deleteBeackerei = "delete from baeckerei where baeckerei_id = ?;";
    private static final String selectBackwareByBaecker = "select * from backware where baeckerei_id = ?;";
    private static final String insertBackware = "insert into backware(bezeichnung, baeckerei_id) values(?, ?);";
    private static final String updateBackware = "UPDATE backware SET bezeichnung = ? WHERE backware_id = ?;";
    private static final String deleteBackware = "delete from backware where backware_id = ?;";

    private void connect() {
        try {
            connection = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        try {
            if (connection != null) connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Baeckerei> getBaeckerein() {
        List<Baeckerei> baeckereiList = new ArrayList<>();
        connect();
        try {
            PreparedStatement pstmt = connection.prepareStatement(selectAllBeackerei);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                baeckereiList.add(new Baeckerei(rs.getInt("baeckerei_id"), rs.getString("name")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return baeckereiList;
    }

    @Override
    public void saveBaeckerei(String name) {
        connect();
        try {
            PreparedStatement pstmt = connection.prepareStatement(insertBeackerei);
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
    }

    @Override
    public void updateBaeckerei(Baeckerei baeckerei) {
        connect();
        try {
            PreparedStatement pstmt = connection.prepareStatement(updateBeackerei);
            pstmt.setString(1, baeckerei.getName());
            pstmt.setInt(2, baeckerei.getID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
    }

    @Override
    public void deleteBaeckerei(Baeckerei baeckerei) {
        connect();
        try {
            PreparedStatement pstmt = connection.prepareStatement(deleteBeackerei);
            pstmt.setInt(1, baeckerei.getID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
    }

    @Override
    public List<Backware> getBackwarenForBaeckerei(int baeckerei_id) {
        List<Backware> backwareList = new ArrayList<>();
        connect();
        try {
            PreparedStatement pstmt = connection.prepareStatement(selectBackwareByBaecker);
            pstmt.setInt(1, baeckerei_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                backwareList.add(new Backware(rs.getInt("backware_id"), rs.getString("bezeichnung")));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
        return backwareList;
    }

    @Override
    public void saveBackware(String name, Baeckerei baeckerei) {
        connect();
        try {
            PreparedStatement pstmt = connection.prepareStatement(insertBackware);
            pstmt.setString(1, name);
            pstmt.setInt(2, baeckerei.getID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
    }

    @Override
    public void updateBackware(Backware backware) {
        connect();
        try {
            PreparedStatement pstmt = connection.prepareStatement(updateBackware);
            pstmt.setString(1, backware.getBezeichnung());
            pstmt.setInt(2, backware.getID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
    }

    @Override
    public void deleteBackware(Backware backware) {
        connect();
        try {
            PreparedStatement pstmt = connection.prepareStatement(deleteBackware);
            pstmt.setInt(1, backware.getID());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            closeConnection();
        }
    }
}
