package presentation;

import application.Fachkonzept;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddBakeryDialogController {
    @FXML
    Button bOkay,bCancel;
    @FXML
    TextField tfName;
    Fachkonzept fachkonzept;

   public void initialize(){
       fachkonzept = Fachkonzept.getInstance();
   }

    @FXML
    public void addNewBakery(){
        if(!tfName.getText().equals(""))  fachkonzept.saveBaeckerei(tfName.getText());
        Stage stage = (Stage) bOkay.getScene().getWindow();
        stage.hide();
   }

    @FXML
    public void close(){
        Stage stage = (Stage) bCancel.getScene().getWindow();
        stage.close();
    }
}
