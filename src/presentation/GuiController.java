package presentation;

import application.Baeckerei;
import application.Fachkonzept;
import data.DatabaseManagement;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.util.List;

public class GuiController {

//GUI Elemente
    @FXML
    Button addBakery,editBakery,deleteBakery,addPastries,editPastries, deletePastries;

    @FXML
    ListView<String> lvBakeries;
    @FXML
    ListView lvPastries;

    @FXML
    ImageView ivOSZLogo;




    Fachkonzept fachkonzept;
    List<Baeckerei> lBaeckerein;


    /***
     * Wird ausgeführt wenn GUI aufgerufen wird
     */
    public void initialize(){

        if(fachkonzept == null){
            fachkonzept = Fachkonzept.getInstance();
        }
        lBaeckerein = fachkonzept.getBackereienListe();
        if(lBaeckerein != null && lBaeckerein.size() > 0){
            for(Baeckerei bakery : lBaeckerein){
                lvBakeries.getItems().add(bakery.getName());
            }
        }

    }

    /***
     * Neue Bäckerei hinzufügen, verweist auf einen Dialog und seinen Controller, wird der Dialog geschlossen wird die Liste in der GUI-Aktualiesiert
     * @throws Exception
     */
    @FXML
    public void newBakery() throws Exception{
      Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BaeckereiHinzufügenDialog.fxml"));
        loader.setController(new AddBakeryDialogController());
      Parent root = loader.load();
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.setScene(new Scene(root));
      stage.showAndWait();
     refreshListView();



    }

    /***
     * Bäckerei löschen, löscht aus Datenquelle und GUI-Liste, die ausgewählte Bäckereit Bäckerei
     */
    @FXML
    public void deleteBakery(){
        if(lvBakeries.getItems().size() > 0 && lvBakeries.getItems() != null) {
            fachkonzept.deleteBaeckerei(lvBakeries.getSelectionModel().getSelectedIndex());
            lvBakeries.getItems().remove(lvBakeries.getSelectionModel().getSelectedIndex());
        }


    }

    /**
     * TODO: derzeit noch nicht funktionstüchtig
     * @throws Exception
     */
    @FXML
    public void editBakery() throws Exception{
      Baeckerei baeckereiToEdit = findBaekereiByName(lvBakeries.getSelectionModel().getSelectedItem());
      Stage stage = new Stage();
      FXMLLoader loader = new FXMLLoader(getClass().getResource("BaeckereiEditDialog.fxml"));
      loader.setController(new EditBaekeryDialogController());
      Parent root = loader.load();
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.setScene(new Scene(root));
      stage.showAndWait();;
      refreshListView();


    }

    /***
     * Hilfmethode zum finden einer Bäckerei aus der Datenquelle and hand eines Namens
     * @param name
     * @return
     */
    private Baeckerei findBaekereiByName(String name){

        for(Baeckerei bakery : fachkonzept.getBackereienListe()){
            if (bakery.getName().equals(name)){
              return bakery;
            }
        }
        return null;
    }


    /**
     * Hilfsmethode zum Aktualisieren der GUI-Liste
     */
    public void refreshListView(){
        lvBakeries.getItems().clear();

        for(Baeckerei bakery : fachkonzept.getBackereienListe()){
            lvBakeries.getItems().add(bakery.getName());
        }
    }














}
