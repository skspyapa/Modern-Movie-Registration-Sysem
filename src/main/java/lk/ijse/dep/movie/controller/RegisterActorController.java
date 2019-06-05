package lk.ijse.dep.movie.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import lk.ijse.dep.movie.business.custom.ActorBO;
import lk.ijse.dep.movie.business.custom.MovieBO;
import lk.ijse.dep.movie.business.custom.RegisterMovieBO;
import lk.ijse.dep.movie.dto.ActorDTO;
import lk.ijse.dep.movie.dto.MovieDTO;
import lk.ijse.dep.movie.dto.RegisterMovieDTO;
import lk.ijse.dep.movie.main.AppInitializer;

import java.util.List;

public class RegisterActorController {
    public ComboBox cmb_movie;
    public TextField txt_movie_name;
    public ComboBox cmb_actor;
    public TextField txt_actor_name;
    public TextField txt_actor_role;
    public Button btn_register;
    ActorBO actorBO = AppInitializer.ctx.getBean(ActorBO.class);
    MovieBO movieBO = AppInitializer.ctx.getBean(MovieBO.class);
    RegisterMovieBO registerMovieBO = AppInitializer.ctx.getBean(RegisterMovieBO.class);
    public void initialize(){
        initialActorLoad();
        initialMovieLoad();
        cmb_actor.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                try {
                    if (newValue != null) {
                        List<ActorDTO> all = actorBO.getAll();
                        for (ActorDTO actorDTO:all){
                            if(newValue.toString().equalsIgnoreCase(Integer.toString(actorDTO.getId()))){
                                    txt_actor_name.setText(actorDTO.getName());
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        cmb_movie.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {

                try {
                    List<MovieDTO> all = movieBO.getAll();

                    if (newValue != null) {

                        for (MovieDTO movieDTO:all){
                            if(newValue.toString().equalsIgnoreCase(Integer.toString(movieDTO.getId()))){
                                txt_movie_name.setText(movieDTO.getName());
                                break;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
}
    public void initialActorLoad(){
        try {
            List<ActorDTO> all = actorBO.getAll();
            if(all!=null) {
                for (ActorDTO actorDTO : all) {
                    cmb_actor.getItems().add(actorDTO.getId());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void initialMovieLoad(){
        try {
            List<MovieDTO> all = movieBO.getAll();
            if(all!=null) {
                for (MovieDTO movieDTO : all) {
                    cmb_movie.getItems().add(movieDTO.getId());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void cmb_movie_Action(ActionEvent actionEvent) {
    }

    public void txt_movie_name_Action(ActionEvent actionEvent) {
    }

    public void cmb_actor_Action(ActionEvent actionEvent) {
    }

    public void txt_actor_name_Action(ActionEvent actionEvent) {
    }

    public void txt_actor_role_Action(ActionEvent actionEvent) {
    }

    public void btn_register_Action(ActionEvent actionEvent) {

        try {
            if(registerMovieBO.getAll()!=null){
                for (RegisterMovieDTO registerMovieDTO : registerMovieBO.getAll()) {
                    if ((registerMovieDTO.getActor() == Integer.parseInt(cmb_actor.getValue().toString()))&&(registerMovieDTO.getMovie() == Integer.parseInt(cmb_movie.getValue().toString()))) {
                            new Alert(Alert.AlertType.INFORMATION, "BuDu Ammo...! That Actor is Already Registered With The Movie", ButtonType.OK).showAndWait();
                    }else {
                        registerMovieBO.save(new RegisterMovieDTO(Integer.parseInt(cmb_actor.getValue().toString()),Integer.parseInt(cmb_movie.getValue().toString()),txt_actor_role.getText()));
                    }
                }
            }
        }catch (NullPointerException e){
            e.printStackTrace();
            try {
                registerMovieBO.save(new RegisterMovieDTO(Integer.parseInt(cmb_actor.getValue().toString()),Integer.parseInt(cmb_movie.getValue().toString()),txt_actor_role.getText()));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
