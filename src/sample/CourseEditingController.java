package sample;

import javafx.scene.Node;
import sample.GUI.CourseEditingBasicInfoView;
import sample.GUI.CourseEditingTeachersView;
import sample.GUI.RootGuiElement;

import java.util.Date;

/**
 * Created by Riso on 12/11/2017.
 */
public class CourseEditingController {

    private Course editingCourse;

    public CourseEditingController(Course course){
        editingCourse = course;
    }

    public void startEditing(){
        openBasicInfoScreen();
    }

    public void gatherBasicInfoAboutCourse(
            String title,
            String description,
            String language,
            int difficulty,
            Date startDate,
            Date endDate,
            double cost,
            boolean available) throws CourseInvariantException {
        editingCourse.setTitle(title);
        editingCourse.setDescription(description);
        editingCourse.setLanguage(language);
        editingCourse.setDifficulty(difficulty);
        editingCourse.setStartDate(startDate);
        editingCourse.setEndDate(endDate);
        editingCourse.setCost(cost);
        editingCourse.setAvailable(available);
    }

    private void openBasicInfoScreen(){
        // Open screen to fill in basic info
        CourseEditingBasicInfoView editingScene = CourseEditingBasicInfoView.getInstance();
        editingScene.attachController(this);
        RootGuiElement.getInstance().setScene(editingScene);
    }

    private void openTeachersScreen(){
        // Open screen to add teachers to course
        Node editingScreen = CourseEditingTeachersView.getInstance();
        RootGuiElement.getInstance().setScene(editingScreen);

    }


}
