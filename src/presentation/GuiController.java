package presentation;

import application.Baeckerei;
import application.Fachkonzept;
import data.DatabaseManagement;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.io.IOException;

public class GuiController {

    //TODO ÄNDERUNG NOTWENDIG DERZEIT NUR SPEICHERADRESSE GESPEICHERT!
    @FXML
    Button addBakery,editBakery,deleteBakery,addPastries,editPastries, deletePastries;

    @FXML
    ListView<Baeckerei> lvBakeries;
    @FXML
    ListView lvPastries;

    @FXML
    ImageView ivOSZLogo;
    Fachkonzept fachkonzept;

    public void initialize(){
        if(fachkonzept == null){
            fachkonzept = new Fachkonzept(new DatabaseManagement());
        }
    }

    @FXML
    public void newBakery(){
        Baeckerei baeckereiToAdd = new Baeckerei("deineMudda");
        //lvBakeries.getItems().add(baeckereiToAdd);
        fachkonzept.saveBaeckerei(baeckereiToAdd.getName());
        for (Baeckerei b:fachkonzept.getBackereienListe()) {
            lvBakeries.getItems().add(b);
        }
    }
    @FXML
    public void deleteBakery(){
        lvBakeries.getItems().remove(lvBakeries.getSelectionModel().getSelectedIndex());
    }

    @FXML
    public void editBakery(){
        lvBakeries.edit(lvBakeries.getSelectionModel().getSelectedIndex());
    }














}
