package sample.GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import sample.Course;
import sample.CourseManager;
import sample.School;

import java.util.Date;

public class LeadingTeacherActionsView extends AnchorPane{

    private static LeadingTeacherActionsView instance = null;

    private TableView<Course> courseTable = new TableView<>();
    private TableColumn<Course, String> titleCol = new TableColumn<>("Title");
    private TableColumn<Course, String> languageCol = new TableColumn<>("Language");
    private TableColumn<Course, Boolean> availableCol = new TableColumn<>("Available");
    private TableColumn<Course, Date> endDateCol = new TableColumn<>("End");
    private TableColumn<Course, Date> startDateCol = new TableColumn<>("Start");
    private TableColumn<Course, Double> costCol = new TableColumn<>("Cost");

    public static LeadingTeacherActionsView getInstance(){
        if(instance == null){
            instance = new LeadingTeacherActionsView();
        }

        return instance;
    }


    void createNewCourse(ActionEvent event) {

        // Inform Course Manager about creating new course
        CourseManager.getInstance().createNewCourse();

    }

    private LeadingTeacherActionsView(){
        super();
        // Labels
        VBox labels = new VBox();
        labels.setSpacing(5);
        labels.setPrefWidth(200);
        labels.setAlignment(Pos.TOP_RIGHT);
        Label leadingTeacher = new Label("Mgr. James Lockman");
        leadingTeacher.setFont(new Font(18));
        Label position = new Label("leading teacher");
        labels.getChildren().addAll(leadingTeacher, position);

        // Button
        Button createNewCourseButton = new Button("Create new course");
        createNewCourseButton.setOnAction(event -> createNewCourse(event));

        // Setup Table view
        courseTable.setPrefHeight(500);
        courseTable.getColumns().addAll(titleCol, availableCol, languageCol, costCol, startDateCol, endDateCol);

        // Position things
        this.getChildren().addAll(labels, createNewCourseButton, courseTable);
        // Posititon Button
        this.setTopAnchor(createNewCourseButton, 20.0);
        this.setLeftAnchor(createNewCourseButton, 20.0);

        // Position Labels
        this.setTopAnchor(labels, 20.0);
        this.setRightAnchor(labels, 20.0);

        // Position Table
        this.setTopAnchor(courseTable, 100.0);
        this.setLeftAnchor(courseTable, 20.0);
        this.setRightAnchor(courseTable, 20.0);

    }

    public void updpateData(ObservableList items){

        titleCol.setCellValueFactory(c->c.getValue().titleProperty());
        languageCol.setCellValueFactory(c->c.getValue().languageProperty());
        availableCol.setCellValueFactory(c->c.getValue().availableProperty().asObject());
        costCol.setCellValueFactory(c->c.getValue().costProperty().asObject());

        courseTable.setItems(items);
    }

}
