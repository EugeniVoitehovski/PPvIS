/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppvis1;

import javafx.application.Application;
import javafx.geometry.Orientation;
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
/**
 *
 * @author eugeni
 */
public class PPvIS1 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Expection {
        Label selectedLB1 = new Label();
        TextField textR = new TextField();
        
        Button selectBtn = new Button("select");
        
        RadioButton aBtn = new RadioButton("111");
        RadioButton bBtn = new RadioButton("222");
        RadioButton cBtn = new RadioButton("333");
        selectBtn.setOnAction(event -> {
            if (textR.getText().equals("111")) aBtn.setSelected(true);
            else {
                if (textR.getText().equals("222")) bBtn.setSelected(true);
                else
                {
                    if (textR.getText().equals("333")) cBtn.setSelected(true);
                    else { Alert errorAlert = new Alert(AlertType.ERROR);
        errorAlert.setHeaderText("error");
        errorAlert.setContentText("not valid");
        errorAlert.showAndWait();}
                }
            }
        });
        
        
        ToggleGroup group = new ToggleGroup();
        
        aBtn.setToggleGroup(group);
        bBtn.setToggleGroup(group);
        cBtn.setToggleGroup(group);
        
        

        Label lbl = new Label();
        TextField textField = new TextField();
        textField.setPrefColumnCount(11);
        Button btn = new Button("Click");
        btn.setOnAction(event -> lbl.setText("Input: " + textField.getText()));
       
        Label t2 = new Label();
        TextField text2 = new TextField();
        text2.setPrefColumnCount(11);
        Button btn2 = new Button("Button1");
        Button btn21 = new Button("Button2");
        btn2.setOnAction(event -> btn21.setText( text2.getText()));
        btn21.setOnAction(event -> btn2.setText( btn21.getText()));
         
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10);
        root.getChildren().addAll(aBtn, bBtn, cBtn,textR, selectBtn, selectedLB1,btn,lbl,textField,t2,text2,btn2,btn21);
        Scene scene = new Scene(root, 500, 500);
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
   

   
    
