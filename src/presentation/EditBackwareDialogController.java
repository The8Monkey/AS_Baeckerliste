package presentation;

import application.Backware;
import application.Baeckerei;
import application.Fachkonzept;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditBackwareDialogController {
    @FXML
    TextField tfName;
    @FXML
    Button bCancel, bOkay;



    @FXML
    public void close(){
        Stage stage = (Stage) bCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void editBackware(){
        int indexOfBackwareToEdit = Fachkonzept.getInstance().getIndextOfBackwareToedit();
        if(!tfName.getText().equals("") || tfName.getText()!=null){
            Fachkonzept.getInstance().getBackwarenForBaeckerei(Fachkonzept.getInstance().getBaeckereiToEdit()).get(indexOfBackwareToEdit).setBezeichnung(tfName.getText());
            Fachkonzept.getInstance().updateBackware(Fachkonzept.getInstance().getBackwarenForBaeckerei(Fachkonzept.getInstance().getBaeckereiToEdit()).get(indexOfBackwareToEdit));
        }
        Stage stage = (Stage) bOkay.getScene().getWindow();
        stage.close();
    }
}

