
package eu.doppel_helix.dev.jdk.reproducecrash;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class TestBrowser implements Runnable {

    public static void main(String[] args) {
        System.setProperty("javafx.verbose", "true");
        System.setProperty("java.library.path", "");
        Platform.startup(new TestBrowser());
    }

    public void run() {
        Stage primaryStage = new Stage();

	primaryStage.setTitle("Hello World!");
	WebView view = new WebView();

	BorderPane bp = new BorderPane();
	bp.setCenter(view);
	primaryStage.setScene(new Scene(bp, 800, 600));
	primaryStage.show();

        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"de\">\n");
        sb.append("<head>\n");
        sb.append("<title>Demo Site</title>\n");
        sb.append("</head>\n");
        sb.append("<body>\n");
        sb.append("<h1>Test</h1>");
// Variant 1: Unicode characters
        sb.append("\uA9C1\u1CC0\uA9C2");
// Variant 2: Unicode entities
//        sb.append("&#xA9C1;&#x1CC0;&#xA9C2;");
        sb.append("</body>");
        sb.append("</html>");

        view.getEngine().loadContent(sb.toString());
    }
}

