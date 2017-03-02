package haagcolorado.joseph.edu.learnmalayalamnow;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageButton;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by josephhaag on 2/16/17.
 */

//Screen for Alphabet Lesson activity. Accessed by clicking button on home screen. Use
//data and methods from external class AlphabetMalayalam

public class AlphabetLesson extends Activity {
    //Use an instantiation of AlphabetMalayalam class to access external data and methods
    AlphabetMalayalam alphabet = new AlphabetMalayalam();

    //GUI Widgets
    AppCompatImageButton backBtn;
    AppCompatImageButton nextBtn;
    AppCompatImageButton letterBtn;
    Button btnRandomize;
    TextView clickToPlay;
    TextView txtEnglishLetterIs;

    //Data
    String currentLetter="Cha"; //Cha just happens to be the first letter so the default
    String englishTranslation="English Sound: " + currentLetter;
    int currentLetterIndex= 0;
    boolean isRandom= false; //User has option to randomize order of letters

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alphabetlesson);

        //cast AFTER setContentView
        btnRandomize=(Button)findViewById(R.id.btnRandom);
        backBtn=(AppCompatImageButton) findViewById(R.id.btnBackLetter);
        nextBtn=(AppCompatImageButton) findViewById(R.id.btnNextLetter);
        letterBtn=(AppCompatImageButton) findViewById(R.id.btnLetter);
        txtEnglishLetterIs=(TextView)findViewById(R.id.txtEnglishLetterIs);
        txtEnglishLetterIs.setText(englishTranslation);

        //Program logic is that pressing the next and back buttons will show a different letter
        //by feeding a different numerical index to the methods of the alphabet object

        //Randomize order of letters event handler
        findViewById(R.id.btnRandom).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                isRandom=true;
                alphabet.randomizeAlphabet();
                if (currentLetterIndex < 17) {
                    currentLetterIndex++;
                } else {
                    currentLetterIndex= 0;
                }
                currentLetter = alphabet.returnEnglishLetter(alphabet.getNextRandom(currentLetterIndex));
                englishTranslation = "English Sound: " + currentLetter;
                txtEnglishLetterIs.setText(englishTranslation);
                alphabet.returnImageId(alphabet.getNextRandom(currentLetterIndex));
                letterBtn.setImageResource(alphabet.returnImageId(alphabet.getNextRandom(currentLetterIndex)));
                //btnRandomize.setEnabled(false);
            }
        });

        findViewById(R.id.btnBackLetter).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0)
            {
                if (!isRandom) {
                    if(currentLetterIndex==0)
                    {
                        currentLetterIndex=17;
                    }
                    else if (currentLetterIndex <= 17) {
                        currentLetterIndex--;
                    }
                    AppCompatImageButton btn = (AppCompatImageButton) arg0;
                    currentLetter = alphabet.returnEnglishLetter(currentLetterIndex);
                    englishTranslation = "English Sound: " + currentLetter;
                    txtEnglishLetterIs.setText(englishTranslation);
                    alphabet.returnImageId(currentLetterIndex);
                    letterBtn.setImageResource(alphabet.returnImageId(currentLetterIndex));
                } else if (isRandom) {
                    if(currentLetterIndex==0)
                    {
                        currentLetterIndex=17;
                    }
                    else if (currentLetterIndex <= 17) {
                        currentLetterIndex--;
                    }
                    AppCompatImageButton btn = (AppCompatImageButton) arg0;
                    currentLetter = alphabet.returnEnglishLetter(alphabet.getNextRandom(currentLetterIndex));
                    englishTranslation = "English Sound: " + currentLetter;
                    txtEnglishLetterIs.setText(englishTranslation);
                    alphabet.returnImageId(alphabet.getNextRandom(currentLetterIndex));
                    letterBtn.setImageResource(alphabet.returnImageId(alphabet.getNextRandom(currentLetterIndex)));
                }
            }
        });


        //Next Button handler
        findViewById(R.id.btnNextLetter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (!isRandom) {
                    if (currentLetterIndex < 17) {
                        currentLetterIndex++;
                    } else {
                        currentLetterIndex= 0;
                    }
                    AppCompatImageButton btn = (AppCompatImageButton) arg0;
                    currentLetter = alphabet.returnEnglishLetter(currentLetterIndex);
                    englishTranslation = "English Sound: " + currentLetter;
                    txtEnglishLetterIs.setText(englishTranslation);
                    alphabet.returnImageId(currentLetterIndex);
                    letterBtn.setImageResource(alphabet.returnImageId(currentLetterIndex));
                } else if (isRandom) {
                    if (currentLetterIndex < 17) {
                        currentLetterIndex++;
                    } else {
                        currentLetterIndex= 0;
                    }
                    AppCompatImageButton btn = (AppCompatImageButton) arg0;
                    currentLetter = alphabet.returnEnglishLetter(alphabet.getNextRandom(currentLetterIndex));
                    englishTranslation = "English Sound: " + currentLetter;
                    txtEnglishLetterIs.setText(englishTranslation);
                    alphabet.returnImageId(alphabet.getNextRandom(currentLetterIndex));
                    letterBtn.setImageResource(alphabet.returnImageId(alphabet.getNextRandom(currentLetterIndex)));
                }
            }});
    }

}
