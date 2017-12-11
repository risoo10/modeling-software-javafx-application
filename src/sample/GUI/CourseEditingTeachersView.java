package sample.GUI;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import sample.Teacher;



/**
 * Created by Riso on 12/11/2017.
 */
public class CourseEditingTeachersView extends AnchorPane {

    // Gui Elements
    TableView<Teacher> addedTeachersTable = new TableView<>();
    TableColumn<Teacher, String> addedFirstNameCol = new TableColumn<>("First name");
    TableColumn<Teacher, String> addedLastNameCol = new TableColumn<>("LastName");

    TableView<Teacher> allTeachersTable = new TableView<>();
    TableColumn<Teacher, String> allFirstNameCol = new TableColumn<>("First name");
    TableColumn<Teacher, String> allLastNameCol = new TableColumn<>("LastName");


    private static CourseEditingTeachersView instance = null;

    public static CourseEditingTeachersView getInstance(){
        if(instance == null){
            instance = new CourseEditingTeachersView();
        }

        return instance;
    }

    private CourseEditingTeachersView(){

        // Add label
        Label screenTitle = new Label("Editing Course - add teachers");
        screenTitle.setFont(new Font(18));
        this.getChildren().add(screenTitle);
        this.setTopAnchor(screenTitle, 20.0);
        this.setLeftAnchor(screenTitle, 20.0);

        // Left vbox with table
        VBox left = new VBox();
        left.setSpacing(10);
        left.setPrefWidth(450);
        // Label
        left.getChildren().add(new Label("Teachers teaching this course:"));
        // Setup table
        addedTeachersTable.getColumns().addAll(addedFirstNameCol, addedLastNameCol);
        addedTeachersTable.setPrefHeight(350);
        left.getChildren().add(addedTeachersTable);
        // Button
        Button removeSelectedBtn = new Button("Remove selected teacher");
        removeSelectedBtn.setOnAction(event -> removeSelectedTeacher(event));
        left.getChildren().add(removeSelectedBtn);
        // Add to pane
        this.getChildren().add(left);
        this.setTopAnchor(left, 80.0);
        this.setLeftAnchor(left, 20.0);


        // Right vbox with table
        VBox right = new VBox();
        right.setSpacing(10);
        right.setPrefWidth(450);

        // Label
        right.getChildren().add(new Label("Available teachers:"));

        // Setup other table
        allTeachersTable.getColumns().addAll(allFirstNameCol, allLastNameCol);
        allTeachersTable.setPrefHeight(350);
        right.getChildren().add(allTeachersTable);

        // Button to add teacher to course
        Button addSelectedTeacherBTN = new Button("Add teacher to course");
        addSelectedTeacherBTN.setOnAction(event -> addSelectedTeacher(event));
        right.getChildren().add(addSelectedTeacherBTN);

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

    void nextScreen(ActionEvent event) {

    }

    // Remove added teacher
    private void removeSelectedTeacher(ActionEvent event){

    }


    private void addSelectedTeacher(ActionEvent event){

    }

    private void updateValues(){

    }
}
