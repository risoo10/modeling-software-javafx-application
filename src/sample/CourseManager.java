package sample;

/**
 * Created by Riso on 12/11/2017.
 */
public class CourseManager {

    private static CourseManager instance = null;

    private School school;

    public static CourseManager getInstance(){
        if(instance == null){
            instance = new CourseManager();
        }

        return instance;
    }

    private CourseManager(){
        school = new School();
    }


    public void createNewCourse(){
        Course newCourse = new Course();
        CourseEditingController cec = new CourseEditingController(newCourse);
        cec.startEditing();
    }


    public School getSchool() {
        return school;
    }

}
