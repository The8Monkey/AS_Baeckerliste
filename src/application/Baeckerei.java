package application;

/**
 * Created by Ulyanovskij on 10.10.2018
 */

public class Baeckerei {
    private int ID;
    private String Name;

    public Baeckerei(String name) {
        Name = name;
    }

    public Baeckerei(int ID, String name) {
        this.ID = ID;
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getID() {
        return ID;
    }
}
