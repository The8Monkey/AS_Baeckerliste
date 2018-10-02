package data;

/**
 * Created by Christoph on 20.09.2018.
 */
public interface IDataManagement
{
    List<Baeckerei> getBaeckerein();
    void saveBaeckerei(Baeckerei baeckerei);
    Baecherei getBaeckerei(int id);
    void updateBaeckerei(Baeckerei baeckerei);
    void deleteBaeckerei(Baeckerei baeckerei);
    List<Backware> getBackwarenForBaeckerei(int baeckerei_id);
    void saveBackware(Backware backware);
    Backware getBackware(int id);
    void updaterBackware(Backware backware);
    void deleteBackware(Backware backware);
}
