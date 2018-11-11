package application;

import data.DatabaseManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ulyanovskij on 10.10.2018
 */

public class Fachkonzept implements IFachkonzept {
    private DatabaseManagement databaseManagement;
    private List<Baeckerei> backereienListe;
    private List<Backware> backwarenListe;
    private Baeckerei baeckereiToEdit;
    private Backware backwareToEdit;
    private int indextOfBackwareToedit;

    //Singleton-Implementation für Fabi
    private static Fachkonzept instance;

    public static Fachkonzept getInstance() {
        if (Fachkonzept.instance == null) {
            Fachkonzept.instance = new Fachkonzept(new DatabaseManagement());
        }
        return Fachkonzept.instance;
    }

    public Backware getBackwareToEdit() {
        return backwareToEdit;
    }

    public void setBackwareToEdit(Backware backwareToEdit) {
        this.backwareToEdit = backwareToEdit;
    }

    public void setBaeckereiToEdit(Baeckerei baeckereiToEdit) {
        this.baeckereiToEdit = baeckereiToEdit;
    }

    public void setIndextOfBackwareToedit(int indextOfBackwareToedit) {
        this.indextOfBackwareToedit = indextOfBackwareToedit;
    }

    public Baeckerei getBaeckereiToEdit() {
        return baeckereiToEdit;
    }

    private Fachkonzept(DatabaseManagement databaseManagement) {
        this.databaseManagement = databaseManagement;
        backereienListe = new ArrayList<>();
        backwarenListe = new ArrayList<>();
    }

    public List<Baeckerei> getBackereienListe() {
        getBaeckereien();
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
        databaseManagement.saveBaeckerei(name);
    }

    @Override
    public void updateBaeckerei(Baeckerei baeckerei) {
        databaseManagement.updateBaeckerei(baeckerei);
    }

    @Override
    public void deleteBaeckerei(int index) {
        databaseManagement.deleteBaeckerei(backereienListe.get(index));
    }

    @Override
    public List<Backware> getBackwarenForBaeckerei(Baeckerei baeckerei) {
        backwarenListe = databaseManagement.getBackwarenForBaeckerei(baeckerei.getID());
        if (backwarenListe != null) {
            return backwarenListe;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public void saveBackware(String bezeichnung, Baeckerei baeckerei) {
        backwarenListe.add(new Backware(bezeichnung));
        databaseManagement.saveBackware(bezeichnung, baeckerei);
    }

    @Override
    public void updateBackware(Backware backware) {
        databaseManagement.updateBackware(backware);
    }

    @Override
    public void deleteBackware(int index) {
        databaseManagement.deleteBackware(backwarenListe.get(index));
        backereienListe.remove(index);
    }
}
