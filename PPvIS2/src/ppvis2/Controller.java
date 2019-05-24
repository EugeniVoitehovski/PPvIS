package ppvis2;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

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

    private String adres = "";

    public void read() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            Product product = new Product();
            DefaultHandler handler = new DefaultHandler() {

                boolean bproduct = false;
                boolean bnumber = false;
                boolean bname = false;
                boolean bnameManuf = false;
                boolean bunp = false;
                boolean bquantity = false;
                boolean badress = false;
                boolean bcity = false;
                boolean bstreet = false;
                boolean bhouse = false;
                boolean bflat = false;
                boolean bproducts = false;

                @Override
                public void startElement(String uri, String localName, String qName,
                        Attributes attributes) throws SAXException {

                    System.out.println("Start Element :" + qName);

                    if (qName.equalsIgnoreCase("products")) {
                        bproducts = true;
                    }

                    if (qName.equalsIgnoreCase("product")) {
                        bproduct = true;
                    }

                    if (qName.equalsIgnoreCase("number")) {
                        bnumber = true;
                    }

                    if (qName.equalsIgnoreCase("name")) {
                        bname = true;
                    }

                    if (qName.equalsIgnoreCase("nameofmanufacturer")) {
                        bnameManuf = true;
                    }
                    if (qName.equalsIgnoreCase("unpofmanufacturer")) {
                        bunp = true;
                    }
                    if (qName.equalsIgnoreCase("quantityinstock")) {
                        bquantity = true;
                    }
                    if (qName.equalsIgnoreCase("adressofstock")) {
                        badress = true;
                    }
                    if (qName.equalsIgnoreCase("city")) {
                        bcity = true;
                    }
                    if (qName.equalsIgnoreCase("street")) {
                        bstreet = true;
                    }
                    if (qName.equalsIgnoreCase("house")) {
                        bhouse = true;
                    }
                    if (qName.equalsIgnoreCase("flat")) {
                        bflat = true;
                    }
                }

                @Override
                public void endElement(String uri, String localName,
                        String qName) throws SAXException {
                    if (qName.equalsIgnoreCase("adressofstock")) {
                        product.setAdr(adres);
                        adres = "";
                    }
                    if (qName.equalsIgnoreCase("product")) {
                        product.addItem(product);
                        System.out.println("Current amount of elements: " + product.getInfoSize());
                    }
                    if (qName.equalsIgnoreCase("products")) {
                        product.showMas();
                    }
                    System.out.println("End Element :" + qName);
                    System.out.println("Final amount of elements: " + product.getInfoSize());
                }

                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    if (bproduct) {
                        System.out.println("Product : " + new String(ch, start, length));
                        bproduct = false;
                    }

                    if (bnumber) {
                        System.out.println("Number : " + new String(ch, start, length));
                        bnumber = false;
                        product.setNumber(Integer.parseInt(new String(ch, start, length)));
                    }

                    if (bname) {
                        System.out.println("Name : " + new String(ch, start, length));
                        bname = false;
                        product.setName(new String(ch, start, length));
                    }

                    if (bnameManuf) {
                        System.out.println("NameOfManufacturer : " + new String(ch, start, length));
                        bnameManuf = false;
                        product.setNameOfManufacturer(new String(ch, start, length));
                    }
                    if (bunp) {
                        System.out.println("Unp : " + new String(ch, start, length));
                        bunp = false;
                        product.setNum(Integer.parseInt(new String(ch, start, length)));
                    }
                    if (bquantity) {
                        System.out.println("Quantity : " + new String(ch, start, length));
                        bquantity = false;
                        product.setKol(Integer.parseInt(new String(ch, start, length)));
                    }
                    if (badress) {
                        System.out.println("Adress : " + new String(ch, start, length));
                        badress = false;
                    }
                    if (bcity) {
                        System.out.println("City : " + new String(ch, start, length));
                        adres += new String(ch, start, length) + " ";
                        bcity = false;
                    }
                    if (bstreet) {
                        System.out.println("Street : " + new String(ch, start, length));
                        adres += new String(ch, start, length) + " ";
                        bstreet = false;
                    }
                    if (bhouse) {
                        System.out.println("House : " + new String(ch, start, length));
                        adres += new String(ch, start, length) + " ";
                        bhouse = false;
                    }
                    if (bflat) {
                        System.out.println("Flat : " + new String(ch, start, length));
                        adres += new String(ch, start, length) + " ";
                        bflat = false;
                    }

                }

            };

            saxParser.parse("products.xml", handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
