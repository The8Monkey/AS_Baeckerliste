package presentation;

import application.Backware;
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
    ListView<String> lvPastries;

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
        lvBakeries.getSelectionModel().selectedItemProperty().addListener((ChangeListener) -> {
            refreshBackwarenliste();

        });
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
      stage.setTitle("Bäckerei hinzufügen");
      stage.setScene(new Scene(root));
      stage.showAndWait();
      refreshListView();
    }

    /***
     * Bäckerei löschen, löscht aus Datenquelle und GUI-Liste, die ausgewählte Bäckereit Bäckerei
     */
    @FXML
    public void deleteBakery(){
        if(lvBakeries.getSelectionModel().getSelectedItem() != null) {
            if (lvBakeries.getItems().size() > 0 && lvBakeries.getItems() != null) {
                fachkonzept.deleteBaeckerei(lvBakeries.getSelectionModel().getSelectedIndex());
                lvBakeries.getItems().remove(lvBakeries.getSelectionModel().getSelectedIndex());
            }
        }
    }

    /**
     */
    @FXML
    public void editBakery() throws Exception{
        if(lvBakeries.getSelectionModel().getSelectedItem() != null) {
            fachkonzept.setBaeckereiToEdit(findBaekereiByName(lvBakeries.getSelectionModel().getSelectedItem()));
            fachkonzept.setIndextOfBackwareToedit(lvPastries.getSelectionModel().getSelectedIndex());
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BaeckereiEditDialog.fxml"));
            loader.setController(new EditBaekeryDialogController());
            Parent root = loader.load();
            stage.setTitle("Bäckerei bearbeiten");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.showAndWait();
            ;
            fachkonzept.updateBaeckerei(fachkonzept.getBaeckereiToEdit());
        }
      refreshListView();
    }

    @FXML
    public void newBackware() throws IOException {
        Baeckerei baeckereiToEdit = findBaekereiByName(lvBakeries.getSelectionModel().getSelectedItem());
        System.out.println("Baeckerei ID="+baeckereiToEdit.getID());
        if(baeckereiToEdit!=null)fachkonzept.setBaeckereiToEdit(baeckereiToEdit);
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BackwareHinzufuegenDialog.fxml"));
        loader.setController(new BackwareHinzufuegenDialogController());
        Parent root = loader.load();
        stage.setTitle("Backware hinzufügen");
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
    @FXML
    public void deleteBackware(){
        System.out.println(lvPastries.getSelectionModel().getSelectedItem() );
        if(lvPastries.getSelectionModel().getSelectedItem() != null){
            fachkonzept.deleteBackware(lvPastries.getSelectionModel().getSelectedIndex());
        }
        refreshBackwarenliste();

    }
    @FXML
    public void editBackware() throws IOException {
        Baeckerei baeckereiToEdit = findBaekereiByName(lvBakeries.getSelectionModel().getSelectedItem());
        if(baeckereiToEdit!=null)fachkonzept.setBaeckereiToEdit(baeckereiToEdit);
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BackwareEditDialog.fxml"));
        loader.setController(new EditBackwareDialogController());
        stage.setTitle("Backware bearbeiten");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(loader.load()));
        stage.showAndWait();;
        refreshBackwarenliste();

    }


    /**
     * Hilfsmethode zum Aktualisieren der GUI-Liste
     */
    public void refreshListView(){
        lvBakeries.getItems().clear();
        for(Baeckerei bakery : fachkonzept.getBackereienListe()){
            lvBakeries.getItems().add(bakery.getName());
            refreshBackwarenliste();
        }
    }
      public void refreshBackwarenliste(){
            lvPastries.getItems().clear();
            Baeckerei baeckerei = findBaekereiByName(lvBakeries.getSelectionModel().getSelectedItem());
            if(baeckerei == null){
                baeckerei = fachkonzept.getBaeckereiToEdit();
            }if(baeckerei != null) {
              List<Backware> backwaren = fachkonzept.getBackwarenForBaeckerei(baeckerei);
              if (!backwaren.isEmpty()) {
                  for (Backware backware : backwaren) {
                      lvPastries.getItems().add(backware.getBezeichnung());
                  }
              }


          }
    }
}
