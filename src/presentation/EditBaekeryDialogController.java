package presentation;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditBaekeryDialogController {
    @FXML
    TextField tfName;
    @FXML
    Button bCancel, bOkay;



    @FXML
    public void close(){
        Stage stage = (Stage) bCancel.getScene().getWindow();
        stage.close();
    }
}
