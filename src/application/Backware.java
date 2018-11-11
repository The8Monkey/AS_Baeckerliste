package application;

/**
 * Created by Ulyanovskij on 10.10.2018
 */

public class Backware {
    private int id;
    private String bezeichnung;

    public Backware(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public Backware(int id, String bezeichnung) {
        this.id = id;
        this.bezeichnung = bezeichnung;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public int getID() {
        return id;
    }
}
