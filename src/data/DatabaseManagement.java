package data;

import application.Backware;
import application.Baeckerei;

import java.sql.*;
import java.util.List;


/**
 * Created by Christoph on 02.10.2018.
 */
public class DatabaseManagement implements IDataManagement{
    private static final String USER="root";
    private static final String PASSWORD="admin";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/baeckerlist?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public Connection connection;

    public DatabaseManagement(){}

    private void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection(){
        try {
            if(connection!=null)connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Baeckerei> getBaeckerein() {
        return null;
    }

    @Override
    public void saveBaeckerei(Baeckerei baeckerei) {

    }

    @Override
    public Baeckerei getBaeckerei(int id) {
        return null;
    }

    @Override
    public void updateBaeckerei(Baeckerei baeckerei) {

    }

    @Override
    public void deleteBaeckerei(Baeckerei baeckerei) {

    }

    @Override
    public List<Backware> getBackwarenForBaeckerei(int baeckerei_id) {
        return null;
    }

    @Override
    public void saveBackware(Backware backware) {

    }

    @Override
    public Backware getBackware(int id) {
        return null;
    }

    @Override
    public void updateBackware(Backware backware) {

    }

    @Override
    public void deleteBackware(Backware backware) {

    }
}
