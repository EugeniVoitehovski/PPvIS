/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppvis1;

import java.util.Random;
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
    public void start(Stage primaryStage) throws Exception {

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

        Button tbutton1 = new Button("Add in table");
        tbutton1.setOnAction(event -> {
            ObservableList<Task5> objectList = table.getItems();
            objectList.add(new Task5(texttable.getText()));
            table.setItems(objectList);
        });

        Button tbutton2 = new Button("switch to 1 column");
        tbutton2.setOnAction(event -> {
            int rowIndex = table.getSelectionModel().getFocusedIndex();
            if (rowIndex > -1) {
                table.getItems().get(rowIndex).left();
                table.refresh();
            }
        });

        Button tbutton3 = new Button("switch to 2 column");
        tbutton3.setOnAction(event -> {
            int rowIndex = table.getSelectionModel().getFocusedIndex();
            if (rowIndex > -1) {
                table.getItems().get(rowIndex).right();
                table.refresh();
            }
        });

        Button but1 = new Button("generate numbers");
        Button but2 = new Button("start selection");
        Button but3 = new Button("stop selection");
        TextField textdop = new TextField();
        VBox vb = new VBox();
        but1.setOnAction(event -> {
            vb.getChildren().clear();
             Random a = new Random();
            int res = (a.nextInt(10 - 1)) + 1;
            textdop.setText(Integer.toString(res));
             
            //final CheckBoxItem[] items = new CheckBoxItem[res];
            //CheckBox checkboxdop[] = new CheckBox[Integer.parseInt(textdop.getText())];
            int n = Integer.parseInt(textdop.getText());
            CheckBox checkboxdop[] = new CheckBox[n];
            for (int i = 0; i < n; i++) {
                checkboxdop[i] = new CheckBox();
                vb.getChildren().add(checkboxdop[i]);
            }
        });

        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10);
        root.getChildren().addAll(combobox, textCombobox, btncombo, text2, btn2,
                btn21, textR, selectBtn, aBtn, bBtn, cBtn, checkbox1, checkbox2,
                checkbox3, text4, checkbutton, table, texttable, tbutton1,
                tbutton3, tbutton2, but1, but2, but3, textdop,vb);

        Scene scene = new Scene(root, 1000, 1000);
        primaryStage.setScene(scene);
        primaryStage.setTitle("LAB1");
        primaryStage.show();
    }

    public class Task5 {

        private String str1;
        private String str2;
        private String val;

        public Task5(String s1) {
            str1 = s1;
            str2 = "";
            val = s1;
        }

        public String getStr1() {
            return str1;
        }

        public String getStr2() {
            return str2;
        }

        public String getValue() {
            return this.val;
        }

        public void setStr1(String str1) {
            this.str1 = str1;
        }

        public void setStr2(String str2) {
            this.str2 = str2;
        }

        public void left() {
            this.str1 = val;
            this.str2 = "";
        }

        public void right() {
            this.str2 = val;
            this.str1 = "";
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
