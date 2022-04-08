/**
 * A fitness tracking program that allows the user to input their information and get back various results form that
 * *Members:
 * Fabiha Fairuzz Subha (UCID: 30148674)
 * Amasil Rahim Zihad (UCID: 30164830)
 * * Date: 1 March 2022
 * * Demo 2 Tutorial 05
 */
package mvh.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mvh.util.Reader;

import java.io.File;
import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setTitle("This Is A Fitness Tracking Program");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        if (args.length != 0) {
            File fileInput = new File(args[0]);
            if (fileInput.exists() && fileInput.canRead()) {
                try {
                    Reader.reader(fileInput);
                } catch (IOException e) {
                    System.err.println("Not a valid Input file");
                }
            }
        } else {
            System.err.println("No argument found!");
        }
        launch(args);
    }

}
