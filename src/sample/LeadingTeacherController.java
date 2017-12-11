package sample;

import javafx.collections.FXCollections;
import sample.GUI.CourseEditingBasicInfoView;
import sample.GUI.LeadingTeacherActionsView;
import sample.GUI.RootGuiElement;

/**
 * Created by Riso on 12/11/2017.
 */
public class LeadingTeacherController {

    private static LeadingTeacherController instance = null;

    public static LeadingTeacherController getInstance(){
        if(instance == null){
            instance = new LeadingTeacherController();
        }

        return instance;
    }

    private LeadingTeacherController(){

    }


    public void showLeadingTeacherActions(){
        RootGuiElement root = RootGuiElement.getInstance();
        LeadingTeacherActionsView leadingTeacherView = LeadingTeacherActionsView.getInstance();
        // Update with curent data
        leadingTeacherView.updpateData(FXCollections.observableArrayList(CourseManager.getInstance().getSchool().getCourses()));
        root.setScene(leadingTeacherView);
    }




}
