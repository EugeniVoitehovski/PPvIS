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
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author eugeni
 */
public class PPvIS1 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Expection {
        Label selectedLB1 = new Label();
        Button selectBtn = new Button("select");
        
        RadioButton aBtn = new RadioButton("111");
        RadioButton bBtn = new RadioButton("222");
        RadioButton cBtn = new RadioButton("333");
        
        ToggleGroup group = new ToggleGroup();
        
        aBtn.setToggleGroup(group);
        bBtn.setToggleGroup(group);
        cBtn.setToggleGroup(group);
        
        selectBtn.setOnAction(event -> {
            RadioButton selection = (RadioButton) group.getSelectedToggle();
            selectedLB1.setText("selected: "+selection.getText());
            
        });
        
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10);
        root.getChildren().addAll(aBtn, bBtn, cBtn, selectBtn, selectedLB1);
        
        Scene scene = new Scene(root, 250, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Buttons");
        primaryStage.show();   
      
    }  
       

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        launch(args);
    }
}
   

   
    
