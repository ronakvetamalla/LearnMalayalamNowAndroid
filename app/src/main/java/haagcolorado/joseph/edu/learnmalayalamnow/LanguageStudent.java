package haagcolorado.joseph.edu.learnmalayalamnow;

/**
 * Created by josephhaag on 2/18/17.
 */

//This object stores the data relating to progress, acheivements etc. of the language student.
//This data can then be accessed on the check progress page

public class LanguageStudent {
    //For data persistence, much of the data related to this object is stored and then queried
    //in an SQLite database.
    private String userName;
    private int score;
    private int progress;
    private String currentLesson;

    LanguageStudent(String userName, int score, int progress, String currentLesson)
    {
        this.userName=userName;
        this.score=score;
        this.progress=progress;
        this.currentLesson=currentLesson;
    }

    //Save Progress

}
