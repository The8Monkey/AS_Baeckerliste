package application;

/**
 * Created by Ulyanovskij on 10.10.2018
 */

public class Backware {
    private String id;
    private String bezeichnung;

    public Backware(String bezeichnung) {
        bezeichnung = bezeichnung;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        bezeichnung = bezeichnung;
    }

    public String getID() {
        return id;
    }
}
