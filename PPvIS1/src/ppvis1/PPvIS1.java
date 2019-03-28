/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppvis1;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.geometry.Orientation;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author eugeni
 */
public class PPvIS1 extends Application {

    @Override
    public void start(Stage primaryStage) throws Expection {

        ComboBox combobox = new ComboBox();
        TextField textCombobox = new TextField();
        Button btncombo = new Button("Add to Combobox");
        btncombo.setOnAction(event -> {
            if (combobox.getItems().contains(textCombobox.getText())) {
                Alert error = new Alert(AlertType.ERROR);
                error.setHeaderText("already added");
                error.showAndWait();
            } else {
                combobox.getItems().add(textCombobox.getText());
            }
        });

        TextField text2 = new TextField();
        Button btn2 = new Button("Button1");
        Button btn21 = new Button("Button2");
        btn2.setOnAction(event -> btn21.setText(text2.getText()));
        btn21.setOnAction(event
                -> {
            String stop = btn2.getText();
            btn2.setText(btn21.getText());
            btn21.setText(stop);
        });

        TextField textR = new TextField();
        Button selectBtn = new Button("Button1");
        ToggleGroup group = new ToggleGroup();
        RadioButton aBtn = new RadioButton("111");
        aBtn.setToggleGroup(group);
        RadioButton bBtn = new RadioButton("222");
        bBtn.setToggleGroup(group);
        RadioButton cBtn = new RadioButton("333");
        cBtn.setToggleGroup(group);
        selectBtn.setOnAction(event -> {
            if (textR.getText().equals(aBtn.getText())) {
                aBtn.setSelected(true);
            } else {
                if (textR.getText().equals(bBtn.getText())) {
                    bBtn.setSelected(true);
                } else {
                    if (textR.getText().equals(cBtn.getText())) {
                        cBtn.setSelected(true);
                    } else {
                        Alert error = new Alert(AlertType.ERROR);
                        error.setHeaderText("doesn't exist ");
                        error.showAndWait();
                    }
                }
            }
        });

        TextField text4 = new TextField();
        Button checkbutton = new Button("Button");
        CheckBox checkbox1 = new CheckBox("1");
        CheckBox checkbox2 = new CheckBox("2");
        CheckBox checkbox3 = new CheckBox("3");
        checkbutton.setOnAction(event
                -> {
            if (text4.getText().equals(checkbox1.getText())) {
                checkbox1.setSelected(!checkbox1.isSelected());
            } else {

                if (text4.getText().equals(checkbox2.getText())) {
                    checkbox2.setSelected(!checkbox2.isSelected());
                } else {
                    if (text4.getText().equals(checkbox3.getText())) {
                        checkbox3.setSelected(!checkbox3.isSelected());
                    } else {
                        Alert error = new Alert(AlertType.ERROR);
                        error.setHeaderText("doesn't exist this value");
                        error.showAndWait();
                    }
                }
            }
        });

        TextField texttable = new TextField();
        TableColumn<Task5, String> fColumn = new TableColumn<>("   1   ");
        fColumn.setMinWidth(100);
        fColumn.setCellValueFactory(new PropertyValueFactory<>("str1"));
        TableColumn<Task5, String> sColumn = new TableColumn<>("   2   ");
        sColumn.setMinWidth(100);
        sColumn.setCellValueFactory(new PropertyValueFactory<>("str2"));
        TableView<Task5> table = new TableView<>();
        table.setMaxWidth(200);
        ObservableList<Task5> list = FXCollections.observableArrayList();
        table.setItems(list);
        table.getColumns().addAll(fColumn, sColumn);

        Button tbutton1 = new Button("Button1");
        tbutton1.setOnAction(e -> {
            ObservableList<Task5> objectList = table.getItems();
            objectList.add(new Task5(texttable.getText(), ""));
            table.setItems(objectList);
        });

        Button tbutton2 = new Button("Button2");
        tbutton2.setOnAction(e -> {
            int rowIndex = table.getSelectionModel().getFocusedIndex();
            String buff = table.getItems().get(rowIndex).getStr1();
            table.getItems().remove(rowIndex);
            table.getItems().add(rowIndex, new Task5("", buff));
        });

        Button tbutton3 = new Button("Button3");
        tbutton3.setOnAction(e -> {
            int rowIndex = table.getSelectionModel().getFocusedIndex();
            String buff = table.getItems().get(rowIndex).getStr2();
            table.getItems().remove(rowIndex);
            table.getItems().add(rowIndex, new Task5(buff, ""));
        });

        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10);
        root.getChildren().addAll(combobox, textCombobox, btncombo, text2, btn2,
                btn21, textR, selectBtn, aBtn, bBtn, cBtn, checkbox1, checkbox2,
                checkbox3, text4, checkbutton, table, texttable, tbutton1,
                tbutton2, tbutton3);
        Scene scene = new Scene(root, 1000, 1000);
        primaryStage.setScene(scene);
        primaryStage.setTitle("LAB1");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
