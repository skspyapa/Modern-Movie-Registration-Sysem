package lk.ijse.dep.movie.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep.movie.business.custom.MovieBO;
import lk.ijse.dep.movie.dto.MovieDTO;
import lk.ijse.dep.movie.main.AppInitializer;
import lk.ijse.dep.movie.utiltm.MovieTM;

import java.util.List;

public class MovieController {
    public TextField txt_id;
    public TextField txt_name;
    public Button btn_save;
    public Button btn_delete;
    public TableView<MovieTM> tbl_movies;
    public ObservableList<MovieTM> items;
    MovieBO movieBO = AppInitializer.ctx.getBean(MovieBO.class);
    public MovieTM seletedMovieTM;
    public void initialize(){
        txt_id.setEditable(false);
        tbl_movies.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tbl_movies.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        items = tbl_movies.getItems();
        initialLoad();
        tbl_movies.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<MovieTM>() {
            @Override
            public void changed(ObservableValue<? extends MovieTM> observable, MovieTM oldValue, MovieTM newValue) {
                seletedMovieTM=newValue;
                if(newValue!=null) {
                    txt_id.setText(Integer.toString(newValue.getId()));
                    txt_name.setText(newValue.getName());
                    btn_save.setText("Update");
                }
            }
        });
}

public void initialLoad(){

    try {
        List<MovieDTO> all = movieBO.getAll();
        if(all !=null) {
            tbl_movies.getItems().clear();
            for (MovieDTO movieDTO : all) {
                items.add(new MovieTM(movieDTO.getId(), movieDTO.getName()));
            }
        }
        loadMaxId();
        txt_name.clear();
    }catch (Exception e) {
        e.printStackTrace();
    }
}

public void loadMaxId(){
    try {
        txt_id.setText(Integer.toString(movieBO.getMaxId()+1));
    }catch (NullPointerException e){
        txt_id.setText("1");
    }catch (Exception e) {
        e.printStackTrace();
    }
}

    public void txt_id_Action(ActionEvent actionEvent) {
txt_name.requestFocus();
    }

    public void txt_name_Action(ActionEvent actionEvent) {
    }

    public void btn_save_Action(ActionEvent actionEvent) {
        if (btn_save.getText().equalsIgnoreCase("Save")){
            int id = Integer.parseInt(txt_id.getText());
            String name = txt_name.getText();
            try {
                movieBO.save(new MovieDTO(id, name));
                initialLoad();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            try {
                MovieDTO movieDTO = movieBO.get(Integer.parseInt(txt_id.getText()));
                movieDTO.setName(txt_name.getText());
                movieBO.save(movieDTO);
                tbl_movies.getItems().clear();
                initialLoad();
                btn_save.setText("Save");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void btn_delete_Action(ActionEvent actionEvent) {
        try {
            List<MovieDTO> all = movieBO.getAll();
            for (MovieDTO movieDTO:all) {
                if(seletedMovieTM.getId()==movieDTO.getId()){
                    movieBO.remove(movieDTO.getId());
                    break;
                }
            }
            tbl_movies.getItems().clear();
            initialize();
            txt_name.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
