/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heiko.scenarioeditor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author eiko1
 */
public class ScenarioController implements Initializable {

    @FXML
    private Parent pane;
    @FXML
    private TextArea text;
    @FXML
    private VBox box;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        App.getScenarioControllers().add(this);
        box.getChildren().add(App.loadFXML("Choice"));
        App.getWindowController().getLabel().setText(String.valueOf(App.getScenarioControllers().size()));
    }

    public Parent getPane() {
        return pane;
    }

    public TextArea getText() {
        return text;
    }

    public VBox getBox() {
        return box;
    }
}
