/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppvis2;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author eugeni
 */
public class Interface extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        ArrayList<Product> info = new ArrayList<>();

        TableColumn<Product, Integer> numberColumn = new TableColumn<>("№");
        numberColumn.setMinWidth(25);
        TableColumn<Product, String> nameColumn = new TableColumn<>("Назание товара");
        nameColumn.setMinWidth(200);
        TableColumn<Product, String> nameOfManufacturerColumn = new TableColumn<>("Название производителя");
        nameOfManufacturerColumn.setMinWidth(200);
        TableColumn<Product, Integer> numColumn = new TableColumn<>("УНП Производителя");
        numColumn.setMinWidth(200);
        TableColumn<Product, Integer> kolColumn = new TableColumn<>("Количество на складе");
        kolColumn.setMinWidth(200);
        TableColumn<Product, String> adrColumn = new TableColumn<>("Адрес склада");
        adrColumn.setMinWidth(200);
        TableView<Product> table = new TableView<>();
        table.setMaxWidth(1100);
        ObservableList<Product> list = getUserList();
      table.setItems(list);
        //table.setItems();
        table.getColumns().addAll(numberColumn, nameColumn, nameOfManufacturerColumn, numColumn, kolColumn, adrColumn);
        Pane pane = new Pane();

        Button addbtn = new Button("Добавить");
        addbtn.setLayoutX(10);
        addbtn.setLayoutY(410);
        addbtn.setMinSize(100, 25);
        
        Button addInfoInTable = new Button("Добавить в таблицу");
        addInfoInTable.setLayoutX(10);
        addInfoInTable.setLayoutY(510);
        addInfoInTable.setMinSize(100, 25);

        Button searchbtn = new Button("Поиск");
        searchbtn.setLayoutX(150);
        searchbtn.setLayoutY(410);
        searchbtn.setMinSize(100, 25);

        Button deletebtn = new Button("Удаление");
        deletebtn.setLayoutX(290);
        deletebtn.setLayoutY(410);
        deletebtn.setMinSize(100, 25);

        addbtn.setOnAction(event -> {
            addInformationAboutProduct();
        });

        searchbtn.setOnAction(event -> {
            search();
        });

        deletebtn.setOnAction(event -> {
            delete();
        });

        addInfoInTable.setOnAction(event -> {
           
        });
        
        Label totalOfNotes = new Label("Количество записей:");
        totalOfNotes.setLayoutX(10);
        totalOfNotes.setLayoutY(460);
        pane.getChildren().addAll(addbtn, searchbtn, deletebtn, totalOfNotes, addInfoInTable);
        root.getChildren().addAll(table, pane);

        Scene scene = new Scene(root, 1200, 1000);
        primaryStage.setTitle("lab2");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    Group root = new Group();

    public void addInformationAboutProduct() {
        Pane adddialogpane = new Pane();

        TextField information = new TextField();
        information.setLayoutX(300);
        information.setLayoutY(10);
        information.setMinSize(50, 25);

        Button inputNameOfProduct = new Button("Добавить название товара");
        inputNameOfProduct.setLayoutX(10);
        inputNameOfProduct.setLayoutY(10);
        inputNameOfProduct.setMinSize(250, 15);

        Button inputNameOfManufacturer = new Button("Добавить название производителя");
        inputNameOfManufacturer.setLayoutX(10);
        inputNameOfManufacturer.setLayoutY(40);
        inputNameOfManufacturer.setMinSize(250, 15);

        Button inputUnpManufacturer = new Button("Добавить УНП Производителя");
        inputUnpManufacturer.setLayoutX(10);
        inputUnpManufacturer.setLayoutY(70);
        inputUnpManufacturer.setMinSize(250, 15);

        Button inputQuantityInStock = new Button("Добавить количество товара ");
        inputQuantityInStock.setLayoutX(10);
        inputQuantityInStock.setLayoutY(100);
        inputQuantityInStock.setMinSize(250, 15);

        Button inputAddressOfStock = new Button("Добавить адрес склада");
        inputAddressOfStock.setLayoutX(10);
        inputAddressOfStock.setLayoutY(130);
        inputAddressOfStock.setMinSize(250, 15);

        inputNameOfProduct.setOnAction(event -> {
           
        });

        adddialogpane.getChildren().addAll(information, inputNameOfProduct,
                inputNameOfManufacturer, inputUnpManufacturer,
                inputQuantityInStock, inputAddressOfStock);
        a.getChildren().addAll(adddialogpane);

        Scene scene = new Scene(a, 500, 300);
        Stage adddialog = new Stage();
        adddialog.setTitle("Добавить информацию о товаре");
        adddialog.setScene(scene);
        adddialog.show();
    }
    Group a = new Group();

    public void search() {
        Pane searchdialogpane = new Pane();

        TextField searchCriteria = new TextField();
        searchCriteria.setLayoutX(300);
        searchCriteria.setLayoutY(10);
        searchCriteria.setMinSize(50, 25);

        Button searchNameOfProduct = new Button("Название товара");
        searchNameOfProduct.setLayoutX(10);
        searchNameOfProduct.setLayoutY(10);
        searchNameOfProduct.setMinSize(250, 15);

        Button searchQuantityInStock = new Button("Количество на складе");
        searchQuantityInStock.setLayoutX(10);
        searchQuantityInStock.setLayoutY(40);
        searchQuantityInStock.setMinSize(250, 15);

        Button searchNameOfManufacturer = new Button("Название производителя");
        searchNameOfManufacturer.setLayoutX(10);
        searchNameOfManufacturer.setLayoutY(70);
        searchNameOfManufacturer.setMinSize(250, 15);

        Button searchUnpManufacturer = new Button("УНП Производителя");
        searchUnpManufacturer.setLayoutX(10);
        searchUnpManufacturer.setLayoutY(100);
        searchUnpManufacturer.setMinSize(250, 15);

        Button searchAddressOfStock = new Button("Адрес склада");
        searchAddressOfStock.setLayoutX(10);
        searchAddressOfStock.setLayoutY(130);
        searchAddressOfStock.setMinSize(250, 15);

        searchdialogpane.getChildren().addAll(searchNameOfProduct,
                searchQuantityInStock, searchNameOfManufacturer,
                searchUnpManufacturer, searchAddressOfStock, searchCriteria);
        b.getChildren().addAll(searchdialogpane);

        Scene scene = new Scene(b, 500, 300);
        Stage searchdialog = new Stage();
        searchdialog.setTitle("Поиск информации о товаре");
        searchdialog.setScene(scene);
        searchdialog.show();
    }
    Group b = new Group();

    public void delete() {
        Pane deletedialogpane = new Pane();

        TextField deleteCriteria = new TextField();
        deleteCriteria.setLayoutX(300);
        deleteCriteria.setLayoutY(10);
        deleteCriteria.setMinSize(50, 25);

        Button deleteNameOfProduct = new Button("Название товара");
        deleteNameOfProduct.setLayoutX(10);
        deleteNameOfProduct.setLayoutY(10);
        deleteNameOfProduct.setMinSize(250, 15);

        Button deleteQuantityInStock = new Button("Количество на складе");
        deleteQuantityInStock.setLayoutX(10);
        deleteQuantityInStock.setLayoutY(40);
        deleteQuantityInStock.setMinSize(250, 15);

        Button deleteNameOfManufacturer = new Button("Название производителя");
        deleteNameOfManufacturer.setLayoutX(10);
        deleteNameOfManufacturer.setLayoutY(70);
        deleteNameOfManufacturer.setMinSize(250, 15);

        Button deleteUnpManufacturer = new Button("УНП Производителя");
        deleteUnpManufacturer.setLayoutX(10);
        deleteUnpManufacturer.setLayoutY(100);
        deleteUnpManufacturer.setMinSize(250, 15);

        Button deleteAddressOfStock = new Button("Адрес склада");
        deleteAddressOfStock.setLayoutX(10);
        deleteAddressOfStock.setLayoutY(130);
        deleteAddressOfStock.setMinSize(250, 15);

        deletedialogpane.getChildren().addAll(deleteCriteria,
                deleteNameOfProduct, deleteQuantityInStock,
                deleteNameOfManufacturer, deleteUnpManufacturer,
                deleteAddressOfStock);
        c.getChildren().addAll(deletedialogpane);

        Scene scene = new Scene(c, 500, 300);
        Stage deletedialog = new Stage();
        deletedialog.setTitle("Удаление информации о товаре");
        deletedialog.setScene(scene);
        deletedialog.show();
    }
    Group c = new Group();
    
     private ObservableList<Product> getUserList() {
         
         
         
      ObservableList<Product> list = FXCollections.observableArrayList();
      return list;
  }
    
    private void addInfo(TableView table, TableColumn numberColumn ) {
      //  table.add();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller contr = new Controller();
       // launch(args); 
        contr.read();
    }
}
