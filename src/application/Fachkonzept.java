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

    public List<Baeckerei> getBackereienListe() {
        return backereienListe;
    }

    public List<Backware> getBackwarenListe() {
        return backwarenListe;
    }

    @Override
    public void getBaeckereien() {
        backereienListe = databaseManagement.getBaeckerein();
    }

    @Override
    public void saveBaeckerei(String name) {
        // databaseManagement.saveBaeckerei(new Baeckerei(name));
        backereienListe.add(new Baeckerei(name));
    }

    @Override
    public void updateBaeckerei(Baeckerei baeckerei) {
        databaseManagement.updateBaeckerei(baeckerei);
    }

    @Override
    public void deleteBaeckerei(int index) {
        backereienListe.remove(index);
        //databaseManagement.deleteBaeckerei(backereienListe.get(index));
    }

    @Override
    public void getBackwarenForBaeckerei(Baeckerei baeckerei) {
        backwarenListe = databaseManagement.getBackwarenForBaeckerei(baeckerei.getID());
    }

    @Override
    public void saveBackware(String bezeichnung, Baeckerei baeckerei) {
        backwarenListe.add(new Backware(bezeichnung));
        //databaseManagement.saveBackware(new Backware(bezeichnung), baeckerei.getID());
    }


    @Override
    public void updateBackware(Backware backware) {
        databaseManagement.updateBackware(backware);
    }

    @Override
    public void deleteBackware(int index) {
        backwarenListe.remove(index);
        //databaseManagement.deleteBackware(backwarenListe.get(index));
    }
}
