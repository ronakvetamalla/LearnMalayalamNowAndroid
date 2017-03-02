package haagcolorado.joseph.edu.learnmalayalamnow;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by josephhaag on 2/16/17.
 */

public class ProgressScreen extends Activity {

    //Ideally, one would query a database to find the information on a specific user's progress.
    //Due to time constraints, this feature will not be utilized yet.
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progressscreen);
    }
}
