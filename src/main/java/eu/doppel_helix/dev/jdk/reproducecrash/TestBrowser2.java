package eu.doppel_helix.dev.jdk.reproducecrash;

import java.io.File;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class TestBrowser2 implements Runnable {

    public static void main(String[] args) {
        Platform.startup(new TestBrowser2());
    }

    public void run() {
        Stage primaryStage = new Stage();

        primaryStage.setTitle("Hello World!");
        WebView view = new WebView();
        BorderPane bp = new BorderPane();
        bp.setCenter(view);
        primaryStage.setScene(new Scene(bp, 800, 600));
        primaryStage.show();

        try {
            view.getEngine().load(new File("/home/matthias/tmp/bpmn-js-examples/starter/modeler.html").toURI().toURL().toExternalForm());
        } catch (MalformedURLException ex) {
            Logger.getLogger(TestBrowser2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
