module uwu.sae201 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens uwu.sae201 to javafx.fxml;
    exports uwu.sae201;
}