package presentation;

import application.Baeckerei;
import application.Fachkonzept;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BackwareHinzufuegenDialogController {
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
    public void addBackware(){
        if(!tfName.getText().equals("")  && tfName.getText() != null){
            Baeckerei baeckereiToEdit = Fachkonzept.getInstance().getBaeckereiToEdit();
            Fachkonzept.getInstance().saveBackware(tfName.getText(), baeckereiToEdit);
        }
        Stage stage = (Stage) bOkay.getScene().getWindow();
        stage.close();
    }
}
