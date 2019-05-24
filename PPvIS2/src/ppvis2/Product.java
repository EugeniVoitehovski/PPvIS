package ppvis2;

import java.util.ArrayList;
import javafx.scene.control.TableView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author eugeni
 */
public class Product {

    ArrayList<Product> info = new ArrayList<>();

    private int number;
    private String name;
    private String nameofmanufacturer;
    private int num;
    private int kol;
    private String adr;

   
    public int getInfoSize() {
        return info.size();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameOfManufacturer() {
        return nameofmanufacturer;
    }

    public void setNameOfManufacturer(String nameofmanufacturer) {
        this.nameofmanufacturer = nameofmanufacturer;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getKol() {
        return kol;
    }

    public void setKol(int kol) {
        this.kol = kol;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public void clearProduct() {
        number = 0;
        name = "";
        nameofmanufacturer = "";
        num = 0;
        kol = 0;
        adr = "";
    }

    public ArrayList<Product> getItems() {
        return info;
    }

    public void addItem(Product writes) {
        info.add(writes);
    }

    public void showElement(Product currentElement, int index) {
        System.out.println("Number["+index+"]: " + currentElement.getNumber());
        System.out.println("Name["+index+"]:" + currentElement.getName());
        System.out.println("NameOfManufacturer["+index+"]:" + currentElement.getNameOfManufacturer());
        System.out.println("Num["+index+"]:" + currentElement.getNum());
        System.out.println("Kol["+index+"]:" + currentElement.getKol());
        System.out.println("Adress["+index+"]:" + currentElement.getAdr());
    }

    public void showMas() {
 for (int index=0; index<info.size(); index++)
     showElement(info.get(index), index);
    }

}
