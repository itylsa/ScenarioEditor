module com.heiko.scenarioeditor {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.heiko.scenarioeditor to javafx.fxml;
    exports com.heiko.scenarioeditor;
}