/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;

/**
 *
 * @author Rushabh
 */
public class Product {
    
    private String name;
    private int price;
    private int id;

    private ArrayList<Feature>features;
    private static int count = 0;
    
    public Product() {
        count++;
        id = count;
        
        features= new ArrayList<Feature>();
        
    }
//    public Feature getFeature(){
////        Feature f= new Feature();
////        Product
//        return Feature;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
    
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    
    @Override
    public String toString() {
        return name;
    }

    public Feature addNewFeature() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public Iterable<Feature> getFeatures() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    
}
