package javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static ResourceBundle bundle;

    @Override
    public void start(Stage stage) throws IOException {
        Locale.setDefault(new Locale("en"));
        scene = new Scene(loadFXML("main"));
        stage.setScene(scene);

        MenuController.mainController.set_center("login_pane.fxml");

        stage.setTitle(App.getString("title"));
        stage.show();
    }


    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        loadResources(fxmlLoader);
        return fxmlLoader.load();
    }

    private static void loadResources(FXMLLoader fxmlLoader) throws IOException {
        bundle = ResourceBundle.getBundle("config.strings");
        fxmlLoader.setResources(bundle);
    }

    public static String getString(String key){
        return bundle.getString(key);
    }


    public static void main(String[] args) {
        launch();
    }

}