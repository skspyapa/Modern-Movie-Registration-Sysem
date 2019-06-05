package lk.ijse.dep.movie.controller;

import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class DashBoardController {

    public ImageView ManageMovie;
    public ImageView ManageActors;
    public ImageView RegisterMovie;


    public void ManageMovie_clicked(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/Movies.fxml"));
        Scene mainScene = new Scene(root);
        Stage mainstage = (Stage) ManageMovie.getScene().getWindow();
        mainstage.setScene(mainScene);
        mainstage.setTitle("ActorTM Form");
        mainstage.centerOnScreen();
        mainstage.show();
    }

    public void ManageActors_Clicked(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/Actors.fxml"));
        Scene mainScene = new Scene(root);
        Stage mainstage = (Stage) ManageActors.getScene().getWindow();
        mainstage.setScene(mainScene);
        mainstage.setTitle("ActorTM Form");
        mainstage.centerOnScreen();
        mainstage.show();

    }

    public void RegisterMovie_Clicked(MouseEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/RegisterActors.fxml"));
        Scene mainScene = new Scene(root);
        Stage mainstage = (Stage) RegisterMovie.getScene().getWindow();
        mainstage.setScene(mainScene);
        mainstage.setTitle("ActorTM Form");
        mainstage.centerOnScreen();
        mainstage.show();

    }
}
