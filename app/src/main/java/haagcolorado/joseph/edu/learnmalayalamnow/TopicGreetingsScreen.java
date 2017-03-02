package haagcolorado.joseph.edu.learnmalayalamnow;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageButton;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by josephhaag on 2/18/17.
 */

public class TopicGreetingsScreen extends Activity {
    //Use an object from GreetingMalayalam class to supply data and methods
    GreetingMalayalam greetingObj;

    //Fields
    int currentIndex;
    boolean isRandom=false;
    String currentEnglish = "";
    String currentMalayalam = "";
    String englishTranslation= "English Translation: " + currentEnglish;
    String malayalamPrompt = "Malayalam Greeting: " + currentMalayalam;

    //GUI Widgets
    TextView txtEnglishGreeting;
    TextView txtMalayalamGreeting;
    Button btnRandomize;
    AppCompatImageButton btnNextMalayalmGreeting;
    AppCompatImageButton btnLastMalayalamGreeting;


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topicgreetings);

        //Use an object of GreetingMalayalam class to fetch data
        greetingObj= new GreetingMalayalam();
        currentIndex=0;

        //Bind widgets
        txtEnglishGreeting=(TextView) findViewById(R.id.txtGreetingEnglish);
        txtMalayalamGreeting=(TextView)findViewById(R.id.txtGreetingMalayalam);
        //btnRandomize=(Button)findViewById(R.id.btnRandomizeGreetings);
        btnNextMalayalmGreeting=(AppCompatImageButton)findViewById(R.id.btnNexGreetings);
        btnLastMalayalamGreeting=(AppCompatImageButton)findViewById(R.id.btnBackGreetings);

        //findViewById(R.id.btnRandomizeGreetings).setOnClickListener(new HandleRandomize());
        findViewById(R.id.btnBackGreetings).setOnClickListener(new Handleback());
        findViewById(R.id.btnNexGreetings).setOnClickListener(new HandleNext());

        //Temporarily disable randomize button
        //btnRandomize.setVisibility(View.INVISIBLE);
        //btnRandomize.setEnabled(false);

        //Set initiail greeting
        setNewGreeting(currentIndex);

    }

    public void setNewGreeting(int currentIndex)
    {
        //Set default text values before randomization and next/back button click events
        currentEnglish=greetingObj.returnEnglish(currentIndex);
        currentMalayalam=greetingObj.returnVocab(currentIndex);

        englishTranslation= "English Translation: " + currentEnglish;
        malayalamPrompt = "Malayalam Greeting: " + currentMalayalam;

        txtEnglishGreeting.setText(englishTranslation);
        txtMalayalamGreeting.setText(malayalamPrompt);
    }

    private class HandleNext implements View.OnClickListener {
        public void onClick(View arg0)
        {
            AppCompatImageButton btn=(AppCompatImageButton)arg0;
            if(isRandom)
            {
                //If empty string result, skip right to the next iteration
                if(greetingObj.nextRandomEnglish(currentIndex) == "" || greetingObj.nextRandomMalayalam(currentIndex) == "")
                {
                    if(currentIndex < greetingObj.getNumIndices())
                        currentIndex++;
                    else
                        currentIndex=0;
                }
                else
                {
                    if(currentIndex < greetingObj.getNumIndices())
                        currentIndex++;
                    else
                        currentIndex=0;

                    setNewGreeting(currentIndex);
                }

            }
            else if(!isRandom)
            {
                if(currentIndex < greetingObj.getNumIndices())
                    currentIndex++;
                else
                    currentIndex=0;
                setNewGreeting(currentIndex);
            }
        }
    }

    private class Handleback implements View.OnClickListener {
        public void onClick(View arg0)
        {
            AppCompatImageButton btn=(AppCompatImageButton)arg0;

            if(isRandom)
            {
                //If empty string result, skip right to the next iteration
                if(greetingObj.nextRandomEnglish(currentIndex) == "" || greetingObj.nextRandomMalayalam(currentIndex) == "")
                {
                    if(currentIndex < greetingObj.getNumIndices())
                        currentIndex++;
                    else
                        currentIndex=0;
                }
                else
                {
                    if(currentIndex ==0)
                        currentIndex=greetingObj.getNumIndices();
                    else if(currentIndex <= greetingObj.getNumIndices())
                        currentIndex--;
                    setNewGreeting(currentIndex);
                }

            }
            else if(!isRandom)
            {
                if(currentIndex < greetingObj.getNumIndices())
                    currentIndex++;
                else
                    currentIndex=0;
                setNewGreeting(currentIndex);
            }
        }
    }

    private class HandleRandomize implements View.OnClickListener {
        public void onClick(View arg0)
        {
            Button btn=(Button)arg0;
            isRandom=true;
            //Randomize both English and Malayalam lexicons
            greetingObj.randomizeBoth(greetingObj.getNumIndices()-1);
            //If empty string result, skip right to the next iteration
            //Feed new values firs to String fields then to setText methods
            setNewGreeting(currentIndex);
            if(currentIndex < greetingObj.getNumIndices()-1)
                currentIndex++;
            else
                currentIndex=0;
        }

    }
}
