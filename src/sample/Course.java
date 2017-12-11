package sample;

import javafx.beans.property.*;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Riso on 12/9/2017.
 */
public class Course implements Serializable{

    private BooleanProperty archived = new SimpleBooleanProperty();
    private BooleanProperty available = new SimpleBooleanProperty();

    private StringProperty title = new SimpleStringProperty();
    private StringProperty language = new SimpleStringProperty();
    private StringProperty description = new SimpleStringProperty();
    private IntegerProperty difficulty = new SimpleIntegerProperty();
    private DoubleProperty cost = new SimpleDoubleProperty();

    private Date startDate;
    private Date endDate;

    public Course(){

    }

    public Course(String title){
        this.title.set(title);
    }

    public Course(boolean available, String title, String language, double cost) {
        setAvailable(available);
        setTitle(title);
        setLanguage(language);
        setCost(cost);
    }

    // Make sure invariant is always true
    public void setDifficulty(int difficulty) throws CourseInvariantException {
        if(difficulty > 0 && difficulty <= 5){
            this.difficulty.set(difficulty);
        } else {
            throw new CourseInvariantException();
        }
    }

    public boolean isArchived() {
        return archived.get();
    }

    public BooleanProperty archivedProperty() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived.set(archived);
    }

    public boolean isAvailable() {
        return available.get();
    }

    public BooleanProperty availableProperty() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available.set(available);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getLanguage() {
        return language.get();
    }

    public StringProperty languageProperty() {
        return language;
    }

    public void setLanguage(String language) {
        this.language.set(language);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public int getDifficulty() {
        return difficulty.get();
    }

    public IntegerProperty difficultyProperty() {
        return difficulty;
    }

    public double getCost() {
        return cost.get();
    }

    public DoubleProperty costProperty() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost.set(cost);
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
