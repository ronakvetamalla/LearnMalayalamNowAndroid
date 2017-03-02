package haagcolorado.joseph.edu.learnmalayalamnow;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

/**
 * Created by josephhaag on 2/11/17.
 */

public class Screen2 extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen2);
        findViewById(R.id.button).setOnClickListener(new handleScreen());
    }
    private class handleScreen implements View.OnClickListener {
        public void onClick(View v) {
            Intent intent = new Intent(Screen2.this, MainActivity.class);
            startActivity(intent);
        }
    }
}

