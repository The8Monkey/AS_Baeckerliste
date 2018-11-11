package application;

import java.util.List;

/**
 * Created by Ulyanovskij on 10.10.2018
 */

public interface IFachkonzept {

    void getBaeckereien();

    void saveBaeckerei(String Name);

    void updateBaeckerei(Baeckerei baeckerei);

    void deleteBaeckerei(int index);

    List<Backware> getBackwarenForBaeckerei(Baeckerei baeckerei);

    void saveBackware(String bezeichnung, Baeckerei baeckerei);

    void updateBackware(Backware backware);

    void deleteBackware(int index);
}
