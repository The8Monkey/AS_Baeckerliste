package application;

/**
 * Created by Ulyanovskij on 10.10.2018
 */

public class Backware {
    private String ID;
    private String Bezeichnung;

    public Backware(String ID, String bezeichnung) {
        this.ID = ID;
        Bezeichnung = bezeichnung;
    }

    public String getBezeichnung() {
        return Bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        Bezeichnung = bezeichnung;
    }

    public String getID() {
        return ID;
    }
}
