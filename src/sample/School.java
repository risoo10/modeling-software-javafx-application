package sample;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Riso on 12/9/2017.
 */
public class School implements Serializable {

    private List<Course> courses = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();


    public School(){

        courses.add(new Course(false, "English for beginners", "English", 56.5));
        courses.add(new Course(false, "Spanish for beginners", "Spanish", 33.5));
        courses.add(new Course(false, "Slovak for foreigners", "Slovak", 120.0));



    }

    public List<Course> getCourses() {
        return courses;
    }
}
