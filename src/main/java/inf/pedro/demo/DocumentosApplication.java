package inf.pedro.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DocumentosApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxml = new FXMLLoader(
                DocumentosApplication.class.getResource("/inf/pedro/demo/view/DocumentoView.fxml")
        );
        Scene scene = new Scene(fxml.load(), 750, 450);
        stage.setTitle("Cadastro de Documentos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}