package haagcolorado.joseph.edu.learnmalayalamnow;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageButton;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

/**
 * Created by josephhaag on 2/16/17.
 */

public class QuizScreen extends Activity {
    //GUI Widgets
    //4 Buttons to display different random letter images
    AppCompatImageButton imgQuiz1;
    AppCompatImageButton imgQuiz2;
    AppCompatImageButton imgQuiz3;
    AppCompatImageButton imgQuiz4;
    AppCompatImageButton imgBtnQuizNext;
    //Text View to prompt user for letter and to display score
    TextView txtQuizScore;
    TextView txtQuizPrompt;
    TextView txtQuizAnswer;
    //Utilize Alphabet object to draw resources and logic
    AlphabetMalayalam alphabetBuilder= new AlphabetMalayalam();
    //Use an index to access alphabet
    int correctIndex;
    int correctButton; //1, 2, 3, or 4.
    String currentEnglish= "Current Letter: "; //Current letter
    int numCorrect=0;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizscreen);

        //Bind widgets
        imgQuiz1=(AppCompatImageButton)findViewById(R.id.imgQuiz1);
        imgQuiz2=(AppCompatImageButton)findViewById(R.id.imgQuiz2);
        imgQuiz3=(AppCompatImageButton)findViewById(R.id.imgQuiz3);
        imgQuiz4=(AppCompatImageButton)findViewById(R.id.imgQuiz4);
        imgBtnQuizNext=(AppCompatImageButton)findViewById(R.id.imgBtnQuizNext);
        txtQuizAnswer=(TextView)findViewById(R.id.txtQuizAnswer);
        txtQuizPrompt=(TextView)findViewById(R.id.txtQuizPrompt);
        txtQuizScore=(TextView)findViewById(R.id.txtQuizScore);

        //Set initial random
        correctButton= setNewRanomAll();

        //Attach event handlers
        findViewById(R.id.imgBtnQuizNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtQuizAnswer.setText("");
                correctButton= setNewRanomAll();
            }
        });

        findViewById(R.id.imgQuiz1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(correctButton)
                {
                    case 1:
                        txtQuizAnswer.setText("Correct!");
                        numCorrect++;
                        txtQuizScore.setText(Integer.toString(numCorrect));
                        imgQuiz1.setEnabled(false);
                        imgQuiz2.setEnabled(false);
                        imgQuiz3.setEnabled(false);
                        imgQuiz4.setEnabled(false );
                        break;
                    case 2:
                    case 3:
                    case 4:
                    default:
                        txtQuizAnswer.setText("Wrong- Try again");
                        break;
                }
            }
        });

        findViewById(R.id.imgQuiz2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(correctButton)
                {
                    case 2:
                        txtQuizAnswer.setText("Correct!");
                        numCorrect++;
                        txtQuizScore.setText(Integer.toString(numCorrect));
                        imgQuiz1.setEnabled(false);
                        imgQuiz2.setEnabled(false);
                        imgQuiz3.setEnabled(false);
                        imgQuiz4.setEnabled(false );
                        break;
                    case 1:
                    case 3:
                    case 4:
                    default:
                        txtQuizAnswer.setText("Wrong- Try again");
                        break;
                }
            }
        });

        findViewById(R.id.imgQuiz3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(correctButton)
                {
                    case 3:
                        txtQuizAnswer.setText("Correct!");
                        numCorrect++;
                        txtQuizScore.setText(Integer.toString(numCorrect));
                        imgQuiz1.setEnabled(false);
                        imgQuiz2.setEnabled(false);
                        imgQuiz3.setEnabled(false);
                        imgQuiz4.setEnabled(false );
                        break;
                    case 1:
                    case 2:
                    case 4:
                    default:
                        txtQuizAnswer.setText("Wrong- Try again");
                        break;
                }
            }
        });

        findViewById(R.id.imgQuiz4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(correctButton)
                {
                    case 4:
                        txtQuizAnswer.setText("Correct!");
                        numCorrect++;
                        txtQuizScore.setText(Integer.toString(numCorrect));
                        imgQuiz1.setEnabled(false);
                        imgQuiz2.setEnabled(false);
                        imgQuiz3.setEnabled(false);
                        imgQuiz4.setEnabled(false );
                        break;
                    case 1:
                    case 3:
                    case 2:
                    default:
                        txtQuizAnswer.setText("Wrong- Try again");
                        break;
                }
            }
        });

    }

    int setNewRanomAll()
    {//The correct answer must be placed at a different random location each time or
        //the game will be too easy. Also, the alphabet itself must be randomized to aid this
        //Yet the correct index must still be stored to verify correct answer
        //Renable all disabled buttons
        imgQuiz1.setEnabled(true);
        imgQuiz2.setEnabled(true);
        imgQuiz3.setEnabled(true);
        imgQuiz4.setEnabled(true );

        txtQuizAnswer.setText("");
        Random randomizer= new Random();
        correctIndex=randomizer.nextInt(5);
        correctButton=0;
        alphabetBuilder.randomizeAlphabet();
        switch(correctIndex)
        {
            case 0:
                imgQuiz1.setImageResource(alphabetBuilder.returnImageId(alphabetBuilder.getNextRandom(correctIndex))); //Seed image 1 with correct answer
                imgQuiz2.setImageResource(alphabetBuilder.returnImageId(alphabetBuilder.getNextRandom(correctIndex + 1)));
                imgQuiz3.setImageResource(alphabetBuilder.returnImageId(alphabetBuilder.getNextRandom(correctIndex + 2)));
                imgQuiz4.setImageResource(alphabetBuilder.returnImageId(alphabetBuilder.getNextRandom(correctIndex + 4)));
                correctButton=1;
                break;
            case 1:
                imgQuiz1.setImageResource(alphabetBuilder.returnImageId(alphabetBuilder.getNextRandom(correctIndex + 1)));
                imgQuiz2.setImageResource(alphabetBuilder.returnImageId(alphabetBuilder.getNextRandom(correctIndex)));//Seed img2
                imgQuiz3.setImageResource(alphabetBuilder.returnImageId(alphabetBuilder.getNextRandom(correctIndex + 2)));
                imgQuiz4.setImageResource(alphabetBuilder.returnImageId(alphabetBuilder.getNextRandom(correctIndex + 3)));
                correctButton=2;
                break;
            case 2:
                imgQuiz1.setImageResource(alphabetBuilder.returnImageId(alphabetBuilder.getNextRandom(correctIndex + 1)));
                imgQuiz2.setImageResource(alphabetBuilder.returnImageId(alphabetBuilder.getNextRandom(correctIndex + 2)));
                imgQuiz3.setImageResource(alphabetBuilder.returnImageId(alphabetBuilder.getNextRandom(correctIndex)));//Seed img3
                imgQuiz4.setImageResource(alphabetBuilder.returnImageId(alphabetBuilder.getNextRandom(correctIndex + 3)));
                correctButton=3;
                break;
            case 3:
                imgQuiz1.setImageResource(alphabetBuilder.returnImageId(alphabetBuilder.getNextRandom(correctIndex + 1)));
                imgQuiz2.setImageResource(alphabetBuilder.returnImageId(alphabetBuilder.getNextRandom(correctIndex + 2)));
                imgQuiz3.setImageResource(alphabetBuilder.returnImageId(alphabetBuilder.getNextRandom(correctIndex + 3)));
                imgQuiz4.setImageResource(alphabetBuilder.returnImageId(alphabetBuilder.getNextRandom(correctIndex)));// Seed img 4
                correctButton=4;
                break;
            default:
                imgQuiz1.setImageResource(alphabetBuilder.returnImageId(alphabetBuilder.getNextRandom(correctIndex + 1)));
                imgQuiz2.setImageResource(alphabetBuilder.returnImageId(alphabetBuilder.getNextRandom(correctIndex + 2)));
                imgQuiz3.setImageResource(alphabetBuilder.returnImageId(alphabetBuilder.getNextRandom(correctIndex)));//Seed img3
                imgQuiz4.setImageResource(alphabetBuilder.returnImageId(alphabetBuilder.getNextRandom(correctIndex + 3)));
                correctButton=3;
                break;
        }


        alphabetBuilder.getNextRandom(correctIndex);
        currentEnglish= "Current Letter: " + alphabetBuilder.returnEnglishLetter(alphabetBuilder.getNextRandom(correctIndex));
        txtQuizPrompt.setText(currentEnglish);

        return correctButton;
    }
}
