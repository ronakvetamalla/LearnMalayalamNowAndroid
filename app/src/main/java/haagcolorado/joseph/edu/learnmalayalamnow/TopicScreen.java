package haagcolorado.joseph.edu.learnmalayalamnow;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.Button;

/**
 * Created by josephhaag on 2/16/17.
 */

public class TopicScreen extends Activity {
    //GUI Widgets
    Button goToGreetings;
    Button goToNumbers;
    Button goToFood;
    Button goToAnimals;
    Button goToTravel;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topicscreen);

        //Cast after setContentView
        goToGreetings=(Button)findViewById(R.id.btnGoToGreetings);
        goToNumbers=(Button)findViewById(R.id.btnNumbers);
        goToFood=(Button)findViewById(R.id.btnGoToFood);
        goToAnimals=(Button)findViewById(R.id.btnGoToAnimals);
        goToTravel=(Button)findViewById(R.id.btnGoToTravel);

        //Disable modules not yet created
        goToAnimals.setEnabled(false);
        goToTravel.setEnabled(false);

        //Event handlers to transition to new screen for each topic
        findViewById(R.id.btnGoToGreetings).setOnClickListener(new handleGreetings());
        findViewById(R.id.btnNumbers).setOnClickListener(new handleNumbers());
        findViewById(R.id.btnGoToFood).setOnClickListener(new handleFood());
    }

    private class handleGreetings implements View.OnClickListener
    {
        public void onClick(View v)
        {
            Intent intent=new Intent(TopicScreen.this, TopicGreetingsScreen.class);
            startActivity(intent);
        }
    }

    private class handleNumbers implements View.OnClickListener
    {
        public void onClick(View v)
        {
            Intent intent = new Intent(TopicScreen.this, NumbersScreen.class);
            startActivity(intent);
        }
    }

    private class handleFood implements View.OnClickListener
    {
        public void onClick(View v)
        {
            Intent intent= new Intent(TopicScreen.this, FoodScreen.class);
            startActivity(intent);
        }
    }

}

