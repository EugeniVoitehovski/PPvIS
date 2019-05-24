package ppvis2;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author eugeni
 */
public class Controller {

    public Product comps = new Product();

    public void add(Product writes) {
        comps.addItem(writes);
    }

    public void set(Product items) {
        for (ArrayList<Product> writes : items) {
            add(writes);
        }
    }
}
