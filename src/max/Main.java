package max;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("views/Main.fxml"));
        Scene scene = new Scene(root);             // создание сцены
        primaryStage.setScene(scene);               // установка сцены для объекта Stage
        primaryStage.setResizable(false);
        primaryStage.setMaxHeight(600);
        primaryStage.setMaxWidth(800);
        primaryStage.setX(100);
        primaryStage.setY(100);
        //primaryStage.setScene(new Scene(root, primaryStage.getWidth(), primaryStage.getHeight()));
        primaryStage.setTitle("ComPort"); // установка заголовка окна
        primaryStage.show();                        /* отображаем окно на экране устройства */

        primaryStage.setOnCloseRequest(event -> {
            Platform.exit();
            System.exit(0);
        });
//        Button exitButton = new Button("Exit");                   // создаем кнопку закрыть приложение
//        exitButton.setOnAction(actionEvent -> Platform.exit());   // закрываем приложение
    }

}
