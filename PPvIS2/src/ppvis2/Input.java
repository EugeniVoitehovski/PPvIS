/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppvis2;

import java.util.ArrayList;
import javax.xml.transform.TransformerException;

/**
 *
 * @author eugeni
 */
public class Input {
    
    private ArrayList<Product> info;
  

    public Input(ArrayList<Product> info) throws TransformerException {
        this.info = info;
    }
}
