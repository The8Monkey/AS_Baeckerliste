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
    Baeckerei baeckereiToEdit;
    int indextOfBackwareToedit;


    //Singleton-Implementation für Fabi
    private static Fachkonzept instance;
    public static Fachkonzept getInstance(){
        if(Fachkonzept.instance == null){
            Fachkonzept.instance = new Fachkonzept( new DatabaseManagement());
        }
        return Fachkonzept.instance;
    }

    public void setBaeckereiToEdit(Baeckerei baeckereiToEdit) {
        this.baeckereiToEdit = baeckereiToEdit;
    }
    public void setIndextOfBackwareToedit(int indextOfBackwareToedit){
        this.indextOfBackwareToedit = indextOfBackwareToedit;
    }
    public  int getIndextOfBackwareToedit(){
        return indextOfBackwareToedit;
    }

    public Baeckerei getBaeckereiToEdit(){
        return baeckereiToEdit;
    }

    public Fachkonzept(DatabaseManagement databaseManagement) {
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
        //backereienListe.add(new Baeckerei(name));
    }

    @Override
    public void updateBaeckerei(Baeckerei baeckerei) {
        databaseManagement.updateBaeckerei(baeckerei);
    }

    @Override
    public void deleteBaeckerei(int index) {
        //backereienListe.remove(index);
        databaseManagement.deleteBaeckerei(backereienListe.get(index));
    }

    @Override
    public List<Backware> getBackwarenForBaeckerei(Baeckerei baeckerei) {
        backwarenListe = databaseManagement.getBackwarenForBaeckerei(baeckerei.getID());
        if(backwarenListe!=null) return backwarenListe;
        else
            return new ArrayList<Backware>();
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
        backwarenListe.remove(index);
        //databaseManagement.deleteBackware(backwarenListe.get(index));
    }
}
