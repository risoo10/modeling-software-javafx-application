package sample.GUI;

import javafx.scene.Node;
import javafx.scene.layout.StackPane;

/**
 * Created by Riso on 12/11/2017.
 */
public class RootGuiElement extends StackPane {

    private static RootGuiElement instance = null;

    public static RootGuiElement getInstance(){
        if(instance == null){
            instance = new RootGuiElement();
        }
        return instance;
    }

    private RootGuiElement(){

    }

    public void setScene(Node node){
        while(this.getChildren().size() != 0)
            this.getChildren().remove(0);
        this.getChildren().add(node);
    }




}
