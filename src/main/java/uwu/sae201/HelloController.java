package uwu.sae201;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class HelloController {
    @FXML
    private VBox vbox;

    public void initialize(){
        System.out.println("nique");

        Button b = new Button();
        b.setText("nique");
        vbox.getChildren().add(b);
    }

}