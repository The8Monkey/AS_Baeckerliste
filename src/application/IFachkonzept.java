package application;

import java.util.List;

/**
 * Created by Ulyanovskij on 10.10.2018
 */

public interface IFachkonzept {

    void getBaeckereien();
    void saveBaeckerei(String Name);
    void updateBaeckerei(Baeckerei baeckerei);
    void deleteBaeckerei(Baeckerei baeckerei);
    List<Backware> getBackwarenForBaeckerei(Baeckerei baeckerei);
    void saveBackware(Backware backware);
    void updateBackware(Backware backware);
    void deleteBackware(Backware backware);
}
