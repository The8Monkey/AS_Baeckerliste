package data;

import application.Backware;
import application.Baeckerei;

import java.util.List;

/**
 * Created by Christoph on 20.09.2018.
 */
public interface IDataManagement
{
    List<Baeckerei> getBaeckerein();
    void saveBaeckerei(String name);
    Baeckerei getBaeckerei(int id);
    void updateBaeckerei(Baeckerei baeckerei);
    void deleteBaeckerei(Baeckerei baeckerei);
    List<Backware> getBackwarenForBaeckerei(int baeckerei_id);
    void saveBackware(String name, Baeckerei baeckerei);
    void updateBackware(Backware backware);
    void deleteBackware(Backware backware);
}
