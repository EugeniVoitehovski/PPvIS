package ppvis2;

import java.util.ArrayList;

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

     ArrayList <Product> info = new ArrayList<>();
    
    private int number;
    private String name;
    private String nameofmanufacturer;
    private int num;
    private int kol;
    private String adr;

    public Product(int number, String name, String nameofmanufacturer, int num, int kol, String adr) {
        this.number = number;
        this.name = name;
        this.nameofmanufacturer = nameofmanufacturer;
        this.num = num;
        this.kol = kol;
        this.adr = adr;
    }

   

    public int getNumber() {
        return number;
    }

    public void setNumber() {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName() {
        this.name = name;
    }

    public String getNameOfManufacturer() {
        return nameofmanufacturer;
    }

    public void setNameOfManufacturer() {
        this.nameofmanufacturer = nameofmanufacturer;
    }

    public int getNum() {
        return num;
    }

    public void setNum() {
        this.num = num;
    }

    public int getKol() {
        return kol;
    }

    public void setKol() {
        this.kol = kol;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr() {
        this.adr = adr;
    }

    public ArrayList <Product> getItems() {
        return info;
    }

    public void addItem(Product writes) {
        info.add(writes);
    }

    public void deleteWrites(Product writes){
        info.remove(writes);
    }
}
