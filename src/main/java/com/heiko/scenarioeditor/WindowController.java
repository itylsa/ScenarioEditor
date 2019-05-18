/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heiko.scenarioeditor;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author eiko1
 */
public class WindowController implements Initializable {

    @FXML
    private Parent pane;
    @FXML
    private VBox box;
    @FXML
    private HBox hBox;
    @FXML
    private Label label;
    @FXML
    private ScrollPane scroller;
    @FXML
    private Button saveButton;
    @FXML
    private VBox vBox;
    @FXML
    private HBox hBox2;
    @FXML
    private VBox vBox1;
    @FXML
    private VBox vBox2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        App.setWindowController(this);
        AnchorPane pane = (AnchorPane) this.pane;
        pane.setBackground(new Background(new BackgroundImage(new Image(App.class.getResourceAsStream("Penis.png")), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        box.setBackground(new Background(new BackgroundImage(new Image(App.class.getResourceAsStream("Penis.png")), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        box.getChildren().add(App.loadFXML("Scenario"));
        for(Node p : hBox.getChildren()) {
            if(p != label && p != saveButton && p != vBox) {
                Pane pp = (Pane) p;
                pp.setBackground(new Background(new BackgroundImage(new Image(App.class.getResourceAsStream("Penis.png")), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, new BackgroundSize(60, 60, false, false, false, false))));
            }
        }
        for(Node p : hBox2.getChildren()) {
            if(p != label && p != saveButton && p != vBox) {
                Pane pp = (Pane) p;
                pp.setBackground(new Background(new BackgroundImage(new Image(App.class.getResourceAsStream("Penis.png")), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, new BackgroundSize(60, 60, false, false, false, false))));
            }
        }
        for(Node p : vBox1.getChildren()) {
            if(p != label && p != saveButton && p != vBox) {
                Pane pp = (Pane) p;
                pp.setBackground(new Background(new BackgroundImage(new Image(App.class.getResourceAsStream("Penis.png")), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, new BackgroundSize(60, 60, false, false, false, false))));
            }
        }
        for(Node p : vBox2.getChildren()) {
            if(p != label && p != saveButton && p != vBox) {
                Pane pp = (Pane) p;
                pp.setBackground(new Background(new BackgroundImage(new Image(App.class.getResourceAsStream("Penis.png")), BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, new BackgroundSize(60, 60, false, false, false, false))));
            }
        }
    }

    @FXML
    private void chooseSavePath() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Choose the folder to save your files into");
        Stage stage = new Stage();
        File file = directoryChooser.showDialog(stage);
        App.getFileController().folder = file;
    }

    public Parent getPane() {
        return pane;
    }

    public VBox getBox() {
        return box;
    }

    public HBox gethBox() {
        return hBox;
    }

    public ScrollPane getScroller() {
        return scroller;
    }

    public Label getLabel() {
        return label;
    }
}
