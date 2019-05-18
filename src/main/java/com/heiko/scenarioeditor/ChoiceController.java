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

/**
 * FXML Controller class
 *
 * @author eiko1
 */
public class ChoiceController implements Initializable {

    @FXML
    private Parent pane;
    @FXML
    private TextArea text;
    @FXML
    private TextArea id;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        App.getChoiceControllers().add(this);
        text.setStyle("text-area-background: grey;");
        id.setStyle("text-area-background: grey;");
    }

    public Parent getPane() {
        return pane;
    }

    public TextArea getText() {
        return text;
    }

    public TextArea getId() {
        return id;
    }
}
