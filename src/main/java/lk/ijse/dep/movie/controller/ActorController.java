package lk.ijse.dep.movie.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep.movie.business.custom.ActorBO;
import lk.ijse.dep.movie.dto.ActorDTO;
import lk.ijse.dep.movie.main.AppInitializer;
import lk.ijse.dep.movie.utiltm.ActorTM;

import java.util.List;

public class ActorController {
    public TextField txt_id;
    public TextField txt_name;
    public TextField txt_Age;
    public Button btn_save;
    public Button btn_delete;
    public TableView<ActorTM> tbl_actors;
    public ObservableList<ActorTM> items;
    public ActorTM seletedActorTM;
    ActorBO actorBO = AppInitializer.ctx.getBean(ActorBO.class);
    public void initialize(){
        txt_id.setEditable(false);
        tbl_actors.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tbl_actors.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tbl_actors.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("age"));
        items = tbl_actors.getItems();

        initialLoad();

tbl_actors.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ActorTM>() {
    @Override
    public void changed(ObservableValue<? extends ActorTM> observable, ActorTM oldValue, ActorTM newValue) {
        seletedActorTM=newValue;
        if(newValue!=null) {
            txt_id.setText(Integer.toString(newValue.getId()));
            txt_name.setText(newValue.getName());
            txt_Age.setText(newValue.getAge());
            btn_save.setText("Update");
        }
    }
});

    }
    public void initialLoad(){
        try {
            List<ActorDTO> all = actorBO.getAll();
            if(all !=null) {
                tbl_actors.getItems().clear();
                for (ActorDTO actor : all) {
                    items.add(new ActorTM(actor.getId(), actor.getName(), actor.getAge()));
                }
            }
            loadMaxId();
            txt_name.clear();
            txt_Age.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadMaxId(){
        try {
            txt_id.setText(Integer.toString(actorBO.getMaxId()+1));
        }catch (NullPointerException e){
            txt_id.setText("1");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void txt_id_Action(ActionEvent actionEvent) {
        txt_name.requestFocus();
    }

    public void txt_Age_Action(ActionEvent actionEvent) {
    txt_name.requestFocus();
    }

    public void txt_name_Action(ActionEvent actionEvent) {
    }

    public void btn_save_Action(ActionEvent actionEvent) {
        if (btn_save.getText().equalsIgnoreCase("Save")){
            int id = Integer.parseInt(txt_id.getText());
            String name = txt_name.getText();
            String age = txt_Age.getText();
            try {
            actorBO.save(new ActorDTO(id, name, age));
            initialLoad();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }else {
            try {
                ActorDTO actorDTO = actorBO.get(Integer.parseInt(txt_id.getText()));
                actorDTO.setName(txt_name.getText());
                actorDTO.setAge(txt_Age.getText());
                actorBO.save(actorDTO);
                tbl_actors.getItems().clear();
                initialLoad();
                btn_save.setText("Save");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void btn_delete_Action(ActionEvent actionEvent) {

        try {
            List<ActorDTO> all = actorBO.getAll();
            for (ActorDTO actorDTO:all) {
                    if(seletedActorTM.getId()==actorDTO.getId()){
                        actorBO.remove(actorDTO.getId());
                        break;
                    }
            }
            tbl_actors.getItems().clear();
            initialize();
            txt_name.clear();
            txt_Age.clear();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
