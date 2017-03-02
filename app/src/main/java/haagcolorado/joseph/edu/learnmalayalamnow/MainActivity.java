package haagcolorado.joseph.edu.learnmalayalamnow;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GreetingMalayalam myGreet=new GreetingMalayalam();
        //Bind navigation buttons and provide event handlers with nested private classes
        Button goToAlphabet=(Button)findViewById(R.id.goToAlphabet);
        Button goToTopic=(Button)findViewById(R.id.goToTopic);
        Button goToReview=(Button)findViewById(R.id.goToReview);
        Button goToQuiz=(Button)findViewById(R.id.goToQuiz);
        Button goToProgress=(Button)findViewById(R.id.goToProgress);

        //Go to Alphabet
        findViewById(R.id.goToAlphabet).setOnClickListener(new handleAlphabetClick());
        //Go to Topic Lessons
        findViewById(R.id.goToTopic).setOnClickListener(new handleTopicClick());
        //Go to Review
        findViewById(R.id.goToReview).setOnClickListener(new handleReviewClick());
        //Go to Quiz
        findViewById(R.id.goToQuiz).setOnClickListener(new handleQuizClick());
        //Load saved progress
        findViewById(R.id.goToProgress).setOnClickListener(new handleProgressClick());
    }

    //Go to Alphabet Screen on click event with nested class
    private class handleAlphabetClick implements  View.OnClickListener {
        public void onClick(View v)
        {
            Intent intent = new Intent(MainActivity.this, AlphabetLesson.class);
            startActivity(intent);
        }
    }

    //Go to Topics screen with on click event via nested class
    private class handleTopicClick implements View.OnClickListener {
        public void onClick(View v)
        {
            Intent intent = new Intent(MainActivity.this, TopicScreen.class);
            startActivity(intent);
        }
    }

    private class handleReviewClick implements View.OnClickListener {
        public void onClick(View v )
        {
            Intent intent = new Intent(MainActivity.this, ReviewScreen.class);
            startActivity(intent);
        }
    }

    private class handleQuizClick implements  View.OnClickListener
    {
        public void onClick(View v)
        {
            Intent intent = new Intent(MainActivity.this, QuizScreen.class);
            startActivity(intent);
        }
    }


    private class handleProgressClick implements  View.OnClickListener
    {
        public void onClick(View v)
        {
            Intent intent = new Intent(MainActivity.this, ProgressScreen.class);
            startActivity(intent);
        }
    }

}
