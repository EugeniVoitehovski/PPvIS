/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppvis1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
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
/**
 *
 * @author eugeni
 */
public class PPvIS1 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Expection {
        
        ComboBox combobox = new ComboBox();
        TextField textCombobox = new TextField();
        Button btncombo = new Button("Button1");
        btncombo.setOnAction(event -> {
                {
                    if (combobox.getItems().add(textCombobox.getText()));
                    else { Alert error = new Alert(AlertType.ERROR);
        error.setHeaderText("error");
        error.showAndWait();}
                }
            });
       // {
        //    combobox.getItems().add(textCombobox.getText());
      //  }); 
        
        Label selectedLB1 = new Label();
        TextField textR = new TextField();
        Button selectBtn = new Button("select");
        ToggleGroup group = new ToggleGroup();
        RadioButton aBtn = new RadioButton("111");
        aBtn.setToggleGroup(group);
        RadioButton bBtn = new RadioButton("222");
        bBtn.setToggleGroup(group);
        RadioButton cBtn = new RadioButton("333");
        cBtn.setToggleGroup(group);
        selectBtn.setOnAction(event -> {
            if (textR.getText().equals("111")) aBtn.setSelected(true);
            else {
                if (textR.getText().equals("222")) bBtn.setSelected(true);
                else
                {
                    if (textR.getText().equals("333")) cBtn.setSelected(true);
                    else { Alert error = new Alert(AlertType.ERROR);
        error.setHeaderText("error");
        error.showAndWait();}
                }
            }
        });
       

        Label t2 = new Label();
        TextField text2 = new TextField();
        text2.setPrefColumnCount(11);
        Button btn2 = new Button("Button1");
        Button btn21 = new Button("Button2");
        btn2.setOnAction(event -> btn21.setText( text2.getText()));
         btn21.setOnAction(event -> 
        {
            String stop = btn2.getText();
            btn2.setText(btn21.getText());
            btn21.setText(stop);
        });
        
       
       
        TextField text4 = new TextField();
        Button checkbutton = new Button("Button");

        CheckBox checkbox1 = new CheckBox("1");
        CheckBox checkbox2 = new CheckBox("2");
        CheckBox checkbox3 = new CheckBox("3"); 
        checkbutton.setOnAction(event -> 
        {
            if (text4.getText().equals("1")) checkbox1.setSelected(true);
            else {
                if (text4.getText().equals("2")) checkbox2.setSelected(true);
                else
                {
                   if (text4.getText().equals("3")) checkbox3.setSelected(true);
                   else { Alert error = new Alert(AlertType.ERROR);
        error.setHeaderText("error");
        error.showAndWait();
                   }
                }
            }
        });
       
        
        TextField text5 = new TextField();
        Button tbutton1 = new Button("Add in 1 column");
        Button tbutton2 = new Button("Switch to 2");
        Button tbutton3 = new Button("Switch to 1");
        TableView table = new TableView();
        table.setPrefWidth(250);
        table.setPrefHeight(250);
        TableColumn column1 = new TableColumn("first");
        TableColumn column2 = new TableColumn("second");
   
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10);
        root.getChildren().addAll(combobox,textCombobox,btncombo,t2,text2,btn2,
                btn21,selectedLB1,textR,selectBtn,aBtn, bBtn, cBtn,
                checkbox1,checkbox2,checkbox3,text4,checkbutton,
                table,text5,tbutton1,tbutton2,tbutton3);
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
   

   
    
