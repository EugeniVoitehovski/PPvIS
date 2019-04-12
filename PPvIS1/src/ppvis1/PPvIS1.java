/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppvis1;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    //AtomicBoolean
    public static volatile boolean work = true;
    public static CheckBox[] c = {};
    public static boolean process = true;
    public static int start = 0;
    public static int end = c.length;
    Thread myThread = createThread();

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
        List<CheckBox> checkboxdop = new ArrayList<>();
        but1.setOnAction(event -> {
            vb.getChildren().clear();
            checkboxdop.clear();
            if (textdop.getText().isEmpty()
                    || Integer.parseInt(textdop.getText()) == 0
                    || Integer.parseInt(textdop.getText()) < 0) {
                Alert error = new Alert(AlertType.ERROR);
                error.setHeaderText("Text field are empty or you have input a 0 Or, maybe you have input a negative value.");
                error.showAndWait();
            } else {
                c = new CheckBox[Integer.parseInt(textdop.getText())];
                for (int i = 0; i < Integer.parseInt(textdop.getText()); i++) {
                    c[i] = new CheckBox();
                    end = c.length;
                    vb.getChildren().add(c[i]);
                }
                start = 0;
            }
        });
        but2.setOnAction(event -> {
            work = true;
            if (c.length == 0) {
                Alert error = new Alert(AlertType.ERROR);
                error.setHeaderText("You did not generated a checkboxes.Please, input to text field number of checkbox and press 'generate numbers'.");
                error.showAndWait();
            } else {
                myThread.setDaemon(true);
                myThread.start();
            }
        });
        but3.setOnAction(event -> {
            work = false;
            myThread.interrupt();
        });

        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10);
        root.getChildren().addAll(combobox, textCombobox, btncombo, text2, btn2,
                btn21, textR, selectBtn, aBtn, bBtn, cBtn, checkbox1, checkbox2,
                checkbox3, text4, checkbutton, table, texttable, tbutton1,
                tbutton3, tbutton2, but1, but2, but3, textdop, vb);

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

    public static Thread createThread() {
        return new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {

                while (work == true) {

                    if (process == true) {
                        if (c[start].isSelected()) {
                            c[start].setSelected(false);
                        } else {
                            c[start].setSelected(true);
                        }
                        start++;
                        process = false;
                    } else {
                        if (c[end - 1].isSelected() == true) {
                            c[end - 1].setSelected(false);
                        } else {
                            c[end - 1].setSelected(true);
                        }
                        end--;
                        process = true;
                    }
                    if (start == (c.length / 2) && end == ((c.length / 2))) {
                        start = 0;
                        end = c.length;
                    }
                    
                    if (end - 1 == -1) {
                        end = c.length;
                    }
                    if (start == c.length) {
                        start = 0;
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(PPvIS1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
