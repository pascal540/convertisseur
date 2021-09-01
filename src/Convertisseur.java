import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Convertisseur extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Convertisseur.class.getResource("./fxml/convertisseur.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("convertisseur €/$");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }


}