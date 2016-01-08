package es.tta.ejemploclase.model;

/**
 * Created by maitane on 28/12/15.
 */
public class Status {

    private int id;
    private String user;
    private int lesson;
    private String lessonTitle;
    private int nextTest;
    private int nextExercise;
    private String userDni;
    private String userPassword;


    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public int getLesson() {
        return lesson;
    }

    public String getLessonTitle() {
        return lessonTitle;
    }

    public int getNextTest() {
        return nextTest;
    }

    public int getNextExercise() {
        return nextExercise;
    }

    public String getUserDni() {
        return userDni;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setLesson(int lesson) {
        this.lesson = lesson;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public void setNextTest(int nextTest) {
        this.nextTest = nextTest;
    }

    public void setNextExercise(int nextExercise) {
        this.nextExercise = nextExercise;
    }

    public void setUserDni(String userDni) {
        this.userDni = userDni;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


}
