package application;

import data.DatabaseManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ulyanovskij on 10.10.2018
 */

public class Fachkonzept implements IFachkonzept {
    DatabaseManagement databaseManagement;
    List<Baeckerei> backereienListe;
    List<Backware> backwarenListe;

    public Fachkonzept(DatabaseManagement databaseManagement) {
        this.databaseManagement = databaseManagement;
        backereienListe = new ArrayList<>();
        backwarenListe = new ArrayList<>();
    }

    @Override
    public void getBaeckereien() {
        backereienListe = databaseManagement.getBaeckerein();
    }

    @Override
    public void saveBaeckerei(String name) {
        databaseManagement.saveBaeckerei(new Baeckerei(name));
    }

    @Override
    public void updateBaeckerei(Baeckerei baeckerei) {
        databaseManagement.updateBaeckerei(baeckerei);
    }

    @Override
    public void deleteBaeckerei(Baeckerei baeckerei) {
        databaseManagement.deleteBaeckerei(baeckerei);
    }

    @Override
    public List<Backware> getBackwarenForBaeckerei(Baeckerei baeckerei) {
        return databaseManagement.getBackwarenForBaeckerei(baeckerei.getID());
    }

    @Override
    public void saveBackware(Backware backware) {
        databaseManagement.saveBackware(backware);
    }


    @Override
    public void updateBackware(Backware backware) {
        databaseManagement.updateBackware(backware);
    }

    @Override
    public void deleteBackware(Backware backware) {
        databaseManagement.deleteBackware(backware);

    }
}
