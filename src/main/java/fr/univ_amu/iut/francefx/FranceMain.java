package fr.univ_amu.iut.francefx;

import fr.univ_amu.iut.francefx.view.map.AcademiePath;
import fr.univ_amu.iut.francefx.view.map.France;
import fr.univ_amu.iut.francefx.view.map.FranceBuilder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;

public class FranceMain extends Application {
    France france;

    @Override
    public void init() {
        france = FranceBuilder.create()
                .backgroundColor(Color.web("#FFFFFF"))
                .fillColor(Color.web("#b6b6ff"))
                .strokeColor(Color.web("#000000"))
                .hoverColor(Color.web("#5858cd"))
                .pressedColor(Color.web("#FFFFFF"))
                .selectedColor(Color.web("#b81111"))
                .mousePressHandler(evt -> {
                    AcademiePath academiePath = (AcademiePath) evt.getSource();
                    System.out.println("On vient de cliquer sur l'"+academiePath.getAcademie().getNom());
                })
                .selectionEnabled(true)
                .build();
    }

    @Override
    public void start(Stage stage) throws IOException {
        StackPane pane = new StackPane(france);
        VBox buttons = new VBox();
        buttons.getChildren().add(new Button("coucou"));
        pane.setBackground(new Background(new BackgroundFill(france.getBackgroundColor(), CornerRadii.EMPTY, Insets.EMPTY)));
        GridPane page = new GridPane();
        buttons.setAlignment(Pos.CENTER);
        page.add(buttons, 0, 0);
        page.add(pane, 1, 0);
        Scene scene = new Scene(page);
        stage.setTitle("Carte des académie");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
