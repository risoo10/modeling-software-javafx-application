package sample.GUI;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import sample.CourseEditingController;
import sample.CourseInvariantException;

/**
 * Created by Riso on 12/7/2017.
 */
public class CourseEditingBasicInfoView extends AnchorPane{

    private CourseEditingController controller;

    private static CourseEditingBasicInfoView instance = null;

    public static CourseEditingBasicInfoView getInstance(){
        if(instance == null){
            instance = new CourseEditingBasicInfoView();
        }

        return instance;
    }

    private TextArea descriptionArea = new TextArea();
    private TextField difficultyField = new TextField();
    private TextField costField = new TextField();
    private CheckBox availableCheckbox = new CheckBox();
    private TextField titleField = new TextField();
    private TextField languageField = new TextField();
    private DatePicker endDate =  new DatePicker();
    private DatePicker startDate = new DatePicker();


    private CourseEditingBasicInfoView(){

        // Add label
        Label screenTitle = new Label("Editing Course - fill in basic information");
        screenTitle.setFont(new Font(18));
        this.getChildren().add(screenTitle);
        this.setTopAnchor(screenTitle, 20.0);
        this.setLeftAnchor(screenTitle, 20.0);


        // Left VBOX
        VBox left = new VBox();
        left.setSpacing(10);
        left.getChildren().addAll(
                new Label("Title:"),
                titleField,
                new Label("Language:"),
                languageField,
                new Label("Description:"),
                descriptionArea,
                new Label("Difficulty (1 - 5):"),
                difficultyField
        );
        left.setPrefWidth(450);
        this.getChildren().add(left);
        this.setTopAnchor(left, 80.0);
        this.setLeftAnchor(left, 20.0);

        // Right VBOX
        VBox right = new VBox();
        right.setSpacing(10);
        right.setPrefWidth(450);
        right.getChildren().addAll(
                new Label("Start date:"),
                startDate,
                new Label("End date:"),
                endDate,
                new Separator(),
                new Label("Cost:"),
                costField,
                new Label("Available:"),
                availableCheckbox
        );
        this.getChildren().add(right);
        this.setTopAnchor(right, 80.0);
        this.setRightAnchor(right, 20.0);


        // Button next
        Button nextScreenBtn = new Button("NEXT STEP");
        nextScreenBtn.setOnAction(event -> nextScreen(event));
        this.getChildren().add(nextScreenBtn);
        this.setBottomAnchor(nextScreenBtn, 20.0);
        this.setRightAnchor(nextScreenBtn, 20.0);

    }

    public void attachController(CourseEditingController controller){
        this.controller = controller;
    }


    private void nextScreen(ActionEvent event)  {
        try {
            controller.gatherBasicInfoAboutCourse(
                    titleField.getText(),
                    descriptionArea.getText(),
                    languageField.getText(),
                    Integer.parseInt(difficultyField.getText()),
                    java.sql.Date.valueOf(startDate.getValue()),
                    java.sql.Date.valueOf(endDate.getValue()),
                    Double.parseDouble(costField.getText()),
                    availableCheckbox.isSelected()
            );
        } catch (CourseInvariantException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Difficulty invariant bounds");
            alert.setContentText("Difficulty must be numbers from 1 to 5 including 5!");
            alert.showAndWait();
        }
    }




}
