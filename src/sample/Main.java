package sample;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.GUI.LeadingTeacherActionsView;
import sample.GUI.RootGuiElement;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        RootGuiElement root = RootGuiElement.getInstance();
        primaryStage.setTitle("EMPIRE - Language School");
        primaryStage.setScene(new Scene(root, 990, 640));
        primaryStage.show();


        // Start the teacher actions screen
        LeadingTeacherController.getInstance().showLeadingTeacherActions();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
