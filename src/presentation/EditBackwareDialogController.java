package presentation;

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
    public void close() {
        Stage stage = (Stage) bCancel.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void editBackware() {
        if (!tfName.getText().equals("") || tfName.getText() != null) {
            Fachkonzept.getInstance().getBackwareToEdit().setBezeichnung(tfName.getText());
        }
        Stage stage = (Stage) bOkay.getScene().getWindow();
        stage.close();
    }
}

