package com.heiko.scenarioeditor;

import java.io.File;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    private static WindowController windowController;

    private static List<ScenarioController> scenarioControllers = new ArrayList<ScenarioController>();

    private static List<ChoiceController> choiceControllers = new ArrayList<ChoiceController>();

    private boolean ctrlPressed = false;

    private static FileController fileController;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Window"));
        System.out.println("Path: " + new File("").getAbsolutePath());
        scene.getStylesheets().add(App.class.getResource("MainCSS.css").toExternalForm());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Scenario Editor");
        stage.getIcons().add(new Image(App.class.getResourceAsStream("Penis.png")));
        fileController = new FileController();
        stage.show();
        scene.setOnKeyPressed((e) -> {
            if(e.getCode().toString().equals("CONTROL")) {
                ctrlPressed = true;
            }
            if(e.getCode().toString().equals("T") && ctrlPressed) {
                windowController.getBox().getChildren().add(loadFXML("Scenario"));
                scenarioControllers.get(scenarioControllers.size() - 1).getText().requestFocus();
            }
            if(e.getCode().toString().equals("G") && ctrlPressed) {
                if(!scenarioControllers.isEmpty()) {
                    scenarioControllers.get(scenarioControllers.size() - 1).getBox().getChildren().add(loadFXML("Choice"));
                    choiceControllers.get(choiceControllers.size() - 1).getText().requestFocus();
                }
            }
            if(e.getCode().toString().equals("W") && ctrlPressed) {
                if(!windowController.getBox().getChildren().isEmpty()) {
                    for(int i = 0; i < scenarioControllers.get(scenarioControllers.size() - 1).getBox().getChildren().size(); i++) {
                        choiceControllers.remove(choiceControllers.size() - 1);
                        System.out.println(choiceControllers.size());
                    }
                    windowController.getBox().getChildren().remove(windowController.getBox().getChildren().size() - 1);
                    scenarioControllers.remove(scenarioControllers.size() - 1);
                    if(!choiceControllers.isEmpty()) {
                        choiceControllers.get(choiceControllers.size() - 1).getText().requestFocus();
                    } else if(!scenarioControllers.isEmpty()) {
                        scenarioControllers.get(scenarioControllers.size() - 1).getText().requestFocus();
                    }
                }
            }
            if(e.getCode().toString().equals("E") && ctrlPressed) {
                if(!scenarioControllers.isEmpty() && !scenarioControllers.get(scenarioControllers.size() - 1).getBox().getChildren().isEmpty()) {
                    scenarioControllers.get(scenarioControllers.size() - 1).getBox().getChildren().remove(scenarioControllers.get(scenarioControllers.size() - 1).getBox().getChildren().size() - 1);
                    choiceControllers.remove(choiceControllers.size() - 1);
                    if(scenarioControllers.get(scenarioControllers.size() - 1).getBox().getChildren().isEmpty()) {
                        scenarioControllers.get(scenarioControllers.size() - 1).getText().requestFocus();
                    } else {
                        choiceControllers.get(choiceControllers.size() - 1).getText().requestFocus();
                    }
                }
            }
            if(e.getCode().toString().equals("S") && ctrlPressed) {
                if(!scenarioControllers.isEmpty() && !choiceControllers.isEmpty()) {
                    saveAndRestart();
                    scenarioControllers.get(scenarioControllers.size() - 1).getText().requestFocus();
                }
            }
        });
        scene.setOnKeyReleased((e) -> {
            if(e.getCode().toString().equals("CONTROL")) {
                ctrlPressed = false;
            }
        });
        App.getWindowController().getBox().heightProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldvalue, Object newValue) {

                App.getWindowController().getScroller().setVvalue((Double) newValue);
            }
        });
        App.getScenarioControllers().get(App.getScenarioControllers().size() - 1).getText().requestFocus();
    }

    public void saveAndRestart() {
        fileController.saveIntoFile();
        scenarioControllers.forEach((t) -> {
            windowController.getBox().getChildren().remove(t.getPane());
        });
        scenarioControllers.clear();
        choiceControllers.clear();
        windowController.getBox().getChildren().add(loadFXML("Scenario"));
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
            return fxmlLoader.load();
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        launch();
    }

    public static WindowController getWindowController() {
        return windowController;
    }

    public static void setWindowController(WindowController windowController) {
        App.windowController = windowController;
    }

    public static List<ScenarioController> getScenarioControllers() {
        return scenarioControllers;
    }

    public static List<ChoiceController> getChoiceControllers() {
        return choiceControllers;
    }

    public static FileController getFileController() {
        return fileController;
    }
}
