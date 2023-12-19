package com.example.demo13;

import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class modal_product {
    ImageView image; 
    Text text;
    Text name;
    Text price;
    VBox box = new VBox();

    modal_product(String url, String text,String name, int price){
        this.image = new ImageView(url);
        this.text.setText(text);
        this.price.setText("$ "+price);
        this.name.setText(name);
    }

    public HBox getModal(){
        HBox hbox = new HBox();
        VBox vbox1 = new VBox();
        VBox vbox2 = new VBox();
        CheckBox select = new CheckBox("Select");
//        Region region1 = new Region();
        vbox2.getChildren().add(new Region());
        vbox2.getChildren().add(select);
        vbox1.getChildren().add(name);
        vbox1.getChildren().add(new Region());
        vbox1.getChildren().add(text);
        vbox1.getChildren().add(new Region());
        vbox1.getChildren().add(price);
        hbox.getChildren().add(image);
        hbox.getChildren().add(vbox1);
        hbox.getChildren().add(new Region());
        hbox.getChildren().add(vbox2);

        return hbox;


    }
    
}
