package com.example.ellipsejavafx;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class EllipseJAVAFX extends Application {
    @Override
    public void start(Stage stage) {
        // ГРАДИЕНТ
        Stop[] stops = new Stop[] {
                new Stop(0, Color.DODGERBLUE),
                new Stop(0.5, Color.LIGHTBLUE),
                new Stop(1.0, Color.LIGHTGREEN)
        };
        LinearGradient gradient = new LinearGradient(0, 0, 0, 1, true, CycleMethod.NO_CYCLE, stops);

        // ЭЛЛИПС
        Ellipse ellipse = new Ellipse(110, 70);
        ellipse.setFill(gradient);
        ellipse.setEffect(new DropShadow(30, 10, 10, Color.GRAY));

        //ТЕКСТ
        Text text = new Text("Эллипс");
        text.setFont(new Font("Arial Bold", 24));
        Reflection reflection = new Reflection();
        reflection.setFraction(0.8);
        reflection.setTopOffset(1.0);
        text.setEffect(reflection);

        //  КНОПКА СТАРТ СТОП
        Button startButton = new Button("Старт");

        //КОМПОНОВКА
        StackPane shapePane = new StackPane(ellipse, text);
        VBox root = new VBox(20, shapePane, startButton);
        root.setStyle("-fx-alignment: center;");

        // АНИМАЦИЯ ВРАЩЕНИЯ
        RotateTransition rotate = new RotateTransition(Duration.millis(2500), shapePane);
        rotate.setFromAngle(0);
        rotate.setToAngle(360);
        rotate.setCycleCount(Animation.INDEFINITE);
        rotate.setInterpolator(Interpolator.LINEAR);

        //ОБРАБОТЧИК КНОПКИ
        startButton.setOnAction(event -> {
            if (rotate.getStatus() == Animation.Status.RUNNING) {
                rotate.pause();
                startButton.setText("Старт");
            } else {
                rotate.play();
                startButton.setText("Стоп");
            }
        });

        //СЦЕНА
        Scene scene = new Scene(root, 350, 270, Color.LIGHTYELLOW);
        stage.setTitle("Эллипс на Жаба ФХ");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}