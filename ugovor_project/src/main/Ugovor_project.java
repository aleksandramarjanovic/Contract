
package main;

import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Ugovor_project extends Application {

    public double dragOffsetX;
    public double dragOffsetY;
    
    public static void main(String[] args) {
        
         launch(args);

    }
      @Override
    public void start(Stage stage) throws Exception {
        
        URL url = getClass().getClassLoader().getResource("pogled/form.fxml");
        GridPane root = FXMLLoader.<GridPane>load(url);
       
        Scene scena = new Scene(root);
        scena.getStylesheets().add("pogled/style.css");
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scena);
        stage.show();
        scena.setOnMousePressed((MouseEvent event) -> {
            dragOffsetX=event.getScreenX() - scena.getX();
            dragOffsetY=event.getScreenY() - scena.getY();
        });
        scena.setOnMouseDragged((MouseEvent event) -> {
            stage.setX (event.getScreenX()-dragOffsetX);
            stage.setY (event.getScreenY()-dragOffsetY);
        });
    }
   
    
}
