package haagcolorado.joseph.edu.learnmalayalamnow;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageButton;
import android.view.View;
import android.widget.TextView;
import java.util.Random;

import org.w3c.dom.Text;

/**
 * Created by josephhaag on 2/23/17.
 */

public class FoodScreen extends Activity {
    //GUI Widgets
    AppCompatImageButton btnNextFood;
    //AppCompatImageButton btnLastFood;
    TextView txtEnglishFood;
    TextView txtMalayalamFood;
    TextView txtFoodBanner;
    int numClicks;
    String currentEnglish;
    String currentMalayalam;

    //Helper class objects
    //Sentences
    SentenceEnglish englishSentenceBuilder=new SentenceEnglish();
    SentenceMalayalam malayalamSentenceBuilder=new SentenceMalayalam();
    //Pronouns
    PronounEnglish englishPronounBuilder=new PronounEnglish();
    PronounMalayalamFormal malayalamPronounBuilder=new PronounMalayalamFormal();
    //Verbs
    RegularVerbEnglish englishVerbBuilder=new RegularVerbEnglish();
    RegularVerbMalayalam malayalmVerbBuilder=new RegularVerbMalayalam();
    //Topic- Food (lexicon for food)
    TopicFood foodTopic=new TopicFood();

    //Random
    Random randomizer;

    //Index values to retrieve from Master Lexicon based on topic
    int foodStart;
    int foodEnd;
    int verbStart;
    int verbEnd;
    int roleStart;
    int roleEnd;
    int drinkStart;
    int drinkEnd;
    int lexiconEnd;  //Non-inclusive

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodscreen);

        //Set initial values
        numClicks=0;
        currentEnglish="Food";
        currentMalayalam="Bhakshanam";

        foodStart=0;
        foodEnd=21;
        verbStart=22;
        verbEnd=28;
        roleStart=29;
        roleEnd=33;
        drinkStart=34;
        drinkEnd=36;
        lexiconEnd=37; //Non-inclusive
        randomizer= new Random();

        //Bind GUI Widgets
        txtEnglishFood=(TextView)findViewById(R.id.txtFoodEnglish);
        txtMalayalamFood=(TextView)findViewById(R.id.txtFoodMalayalam);
        btnNextFood=(AppCompatImageButton) findViewById(R.id.btnNextFood);
        //btnLastFood=(AppCompatImageButton)findViewById(R.id.btnBackFood);
        txtFoodBanner=(TextView)findViewById(R.id.txtFoddBanner);

        //Attach event handlers
        findViewById(R.id.btnNextFood).setOnClickListener(new HandleNextFood());

        //Set first text value
        txtFoodBanner.setText("Food ");
        currentEnglish= newCurrentEnglish(foodTopic.queryMasterLexiconEnglish(numClicks));
        setNewEnglishText();
        currentMalayalam=newCurrentMalayalm(foodTopic.queryMasterLexiconMalayalam(numClicks));
        setNewMalayalmText();
    }

    private class HandleNextFood implements View.OnClickListener
    {
        public void onClick(View arg0)
        {
            //Genereate more or less random sentences where a Noun performs a Verb related to a Food Obj
            int ENGLISH=0; //Index
            int MALAYALAM=1; //Index
            String[] bothSentences={"",""};

            //Increment for new query results
            if(numClicks<9)
                numClicks++;
            else
                numClicks=1;

            //Get next random sentence

            //Set top banner TextView text
            txtFoodBanner.setText("Food (Nouns)");
            //nextRandomSentence returns a random sentence from one of the tenses
            bothSentences= nextRandomSentence(numClicks);

            //Set English TextView
            currentEnglish= newCurrentEnglish(bothSentences[ENGLISH]);
            setNewEnglishText();
            //Set Malayalam TextView
            currentMalayalam=newCurrentMalayalm(bothSentences[MALAYALAM]);
            setNewMalayalmText();

        }
    }

    private String[] nextRandomSentence(int numClicks)
    {
        String englishFullSentence="";
        String malayalamFullSentence="";
        String[] bothSentences={englishFullSentence, malayalamFullSentence};
        int ENGLISH=0;
        int MALAYALAM=1;
        switch(numClicks)
        {
            case 1:
                bothSentences=getPresentSimpleSentence();
                txtFoodBanner.setText("Food: Present Simple Tense");
                break;
            case 2:
                bothSentences=getPastSimpleSentence();
                txtFoodBanner.setText("Food: Past Simple Tense ");
                break;
            case 3:
                bothSentences=getFutureSimpleSentence();
                txtFoodBanner.setText("Food: Future Simple Tense ");
                break;
            case 4:
                bothSentences=getPresentProgressiveSentence();
                txtFoodBanner.setText("Food: Present Progressive Tense ");
                break;
            case 5:
                bothSentences=getPastProgressiveSentence();
                txtFoodBanner.setText("Food: Past Progressive Tense ");
                break;
            case 6:
                bothSentences= getFutreProgressiveSentence();
                txtFoodBanner.setText("Food: Future Progressive Tense ");
                break;
            case 7:
                bothSentences=getPastPerfectSentence();
                txtFoodBanner.setText("Food: Past Perfect Tense ");
                break;
            case 8:
                bothSentences=getFuturePerfectSentence();
                txtFoodBanner.setText("Food: Future Perfect Tense ");
                break;
            default:
                bothSentences=getPresentProgressiveSentence();
                txtFoodBanner.setText("Food: Present Progressive Tense ");
                break;
        }

        return bothSentences;
    }

    //Return random sentences in present simple tense
    private String[] getPresentSimpleSentence()
    {
        String englishFullSentence="";
        String malayalamFullSentence="";
        String[] bothSentences={englishFullSentence, malayalamFullSentence};
        int ENGLISH=0;
        int MALAYALAM=1;

        int subjRandomIndex=randomizer.nextInt(5);
        int verbRandomIndex=randomizer.nextInt(7);
        int objRandomIndex=randomizer.nextInt(20);
        int drinkRandomIndex=randomizer.nextInt(2);

        String englishSubj="";
        String englishVerb="";
        String englishObj="";
        String malayalamSubj="";
        String malayalamVerb="";
        String malayalamObj="";

        //Query the lexicon for raw data values and assign them to each syntactic role
        englishSubj=foodTopic.queryMasterLexiconEnglish(roleStart+subjRandomIndex);
        malayalamSubj=foodTopic.queryMasterLexiconMalayalam(roleStart+subjRandomIndex);
        //Sometimes, use a generic pronoun like I, he, she instead of a role like waiter for subject
        //Due to time constraints, this feature will not be utilized yet but could be expanded upon later
        boolean usePronounBool=false;
        String[] bothPronouns={"",""};
        if(usePronounBool)
        {
            bothPronouns=returnBothPronouns();
            englishSubj=bothPronouns[ENGLISH];
            malayalamSubj=bothPronouns[MALAYALAM];
        }

        malayalamVerb=foodTopic.queryMasterLexiconMalayalam(verbStart+verbRandomIndex);
        englishVerb= foodTopic.queryMasterLexiconEnglish(verbStart+verbRandomIndex);

        englishObj=foodTopic.queryMasterLexiconEnglish(foodStart+objRandomIndex);
        malayalamObj=foodTopic.queryMasterLexiconMalayalam(foodStart+objRandomIndex);

        //To get a present simple sentence in both languages use Sentence class methods
        englishFullSentence=englishVerbBuilder.returnPresentSimpleThirdPersonSOV(englishSubj, englishVerb, englishObj, usePronounBool);
        malayalamFullSentence=malayalamSentenceBuilder.returnPresentSimpleSentenceSOV(malayalamSubj,malayalamVerb, malayalamObj);

        bothSentences[ENGLISH]=englishFullSentence;
        bothSentences[MALAYALAM]=malayalamFullSentence;
        return bothSentences;
    }

    //Return random sentences in past simple tense
    private String[] getPastSimpleSentence()
    {
        String englishFullSentence="";
        String malayalamFullSentence="";
        String[] bothSentences={englishFullSentence, malayalamFullSentence};
        int ENGLISH=0;
        int MALAYALAM=1;

        int subjRandomIndex=randomizer.nextInt(5);
        int verbRandomIndex=randomizer.nextInt(7);
        int objRandomIndex=randomizer.nextInt(20);
        int drinkRandomIndex=randomizer.nextInt(2);

        String englishSubj="";
        String englishVerb="";
        String englishObj="";
        String malayalamSubj="";
        String malayalamVerb="";
        String malayalamObj="";
        int DRINK=27;

        //Query the lexicon for raw data values and assign them to each syntactic role
        englishSubj=foodTopic.queryMasterLexiconEnglish(roleStart+subjRandomIndex);
        malayalamSubj=foodTopic.queryMasterLexiconMalayalam(roleStart+subjRandomIndex);
        //Sometimes, use a generic pronoun like I, he, she instead of a role like waiter for subject
        //Due to time constraints, this feature will not be utilized yet but could be expanded upon later
        boolean usePronounBool=false;
        String[] bothPronouns={"",""};
        if(usePronounBool)
        {
            bothPronouns=returnBothPronouns();
            englishSubj=bothPronouns[ENGLISH];
            malayalamSubj=bothPronouns[MALAYALAM];
        }

        malayalamVerb=foodTopic.queryMasterLexiconMalayalam(verbStart+verbRandomIndex);
        englishVerb= foodTopic.queryMasterLexiconEnglish(verbStart+verbRandomIndex);

        englishObj=foodTopic.queryMasterLexiconEnglish(foodStart+objRandomIndex);
        malayalamObj=foodTopic.queryMasterLexiconMalayalam(foodStart+objRandomIndex);

        //To get a present simple sentence in both languages use Sentence class methods
        englishFullSentence=englishVerbBuilder.returnPastSimpleSOV(englishSubj, englishVerb, englishObj, usePronounBool);
        malayalamFullSentence=malayalamSentenceBuilder.returnPastSimpleSentenceSOV(malayalamSubj,malayalamVerb,malayalamObj);

        bothSentences[ENGLISH]=englishFullSentence;
        bothSentences[MALAYALAM]=malayalamFullSentence;
        return bothSentences;
    }


     private String[] getFutureSimpleSentence()
    {
        String englishFullSentence="";
        String malayalamFullSentence="";
        String[] bothSentences={englishFullSentence, malayalamFullSentence};
        int ENGLISH=0;
        int MALAYALAM=1;

        int subjRandomIndex=randomizer.nextInt(5);
        int verbRandomIndex=randomizer.nextInt(7);
        int objRandomIndex=randomizer.nextInt(20);
        int drinkRandomIndex=randomizer.nextInt(2);

        String englishSubj="";
        String englishVerb="";
        String englishObj="";
        String malayalamSubj="";
        String malayalamVerb="";
        String malayalamObj="";
        int DRINK=27;

        //Query the lexicon for raw data values and assign them to each syntactic role
        englishSubj=foodTopic.queryMasterLexiconEnglish(roleStart+subjRandomIndex);
        malayalamSubj=foodTopic.queryMasterLexiconMalayalam(roleStart+subjRandomIndex);
        //Sometimes, use a generic pronoun like I, he, she instead of a role like waiter for subject
        boolean usePronounBool=false;
        String[] bothPronouns={"",""};
        if(usePronounBool)
        {
            bothPronouns=returnBothPronouns();
            englishSubj=bothPronouns[ENGLISH];
            malayalamSubj=bothPronouns[MALAYALAM];
        }


        malayalamVerb=foodTopic.queryMasterLexiconMalayalam(verbStart+verbRandomIndex);
        englishVerb= foodTopic.queryMasterLexiconEnglish(verbStart+verbRandomIndex);

        englishObj=foodTopic.queryMasterLexiconEnglish(foodStart+objRandomIndex);
        malayalamObj=foodTopic.queryMasterLexiconMalayalam(foodStart+objRandomIndex);

        //To get a present simple sentence in both languages use Sentence class methods
        englishFullSentence=englishVerbBuilder.returnFutureSimpleSOV(englishSubj, englishVerb, englishObj, usePronounBool);
        malayalamFullSentence=malayalamSentenceBuilder.returnFutureSimpleSentenceSOV(malayalamSubj, malayalamVerb, malayalamObj);

        bothSentences[ENGLISH]=englishFullSentence;
        bothSentences[MALAYALAM]=malayalamFullSentence;
        return bothSentences;
    }

     private String[] getPresentProgressiveSentence()
    {
        String englishFullSentence="";
        String malayalamFullSentence="";
        String[] bothSentences={englishFullSentence, malayalamFullSentence};
        int ENGLISH=0;
        int MALAYALAM=1;

        int subjRandomIndex=randomizer.nextInt(5);
        int verbRandomIndex=randomizer.nextInt(7);
        int objRandomIndex=randomizer.nextInt(20);
        int drinkRandomIndex=randomizer.nextInt(2);

        String englishSubj="";
        String englishVerb="";
        String englishObj="";
        String malayalamSubj="";
        String malayalamVerb="";
        String malayalamObj="";
        int DRINK=27;

        //Query the lexicon for raw data values and assign them to each syntactic role
        englishSubj=foodTopic.queryMasterLexiconEnglish(roleStart+subjRandomIndex);
        malayalamSubj=foodTopic.queryMasterLexiconMalayalam(roleStart+subjRandomIndex);
        //Sometimes, use a generic pronoun like I, he, she instead of a role like waiter for subject
        boolean usePronounBool=false;
        String[] bothPronouns={"",""};
        if(usePronounBool)
        {
            bothPronouns=returnBothPronouns();
            englishSubj=bothPronouns[ENGLISH];
            malayalamSubj=bothPronouns[MALAYALAM];
        }


        malayalamVerb=foodTopic.queryMasterLexiconMalayalam(verbStart+verbRandomIndex);
        englishVerb= foodTopic.queryMasterLexiconEnglish(verbStart+verbRandomIndex);

        englishObj=foodTopic.queryMasterLexiconEnglish(foodStart+objRandomIndex);
        malayalamObj=foodTopic.queryMasterLexiconMalayalam(foodStart+objRandomIndex);

        //To get a present simple sentence in both languages use Sentence class methods
        englishFullSentence=englishVerbBuilder.returnPresentContinuousSOV(englishSubj,englishVerb,englishObj, usePronounBool);
        malayalamFullSentence=malayalamSentenceBuilder.returnPresentProgressiveSentenceSOV(malayalamSubj,malayalamVerb,malayalamObj);

        bothSentences[ENGLISH]=englishFullSentence;
        bothSentences[MALAYALAM]=malayalamFullSentence;
        return bothSentences;
    }


      private String[] getPastProgressiveSentence()
    {
        String englishFullSentence="";
        String malayalamFullSentence="";
        String[] bothSentences={englishFullSentence, malayalamFullSentence};
        int ENGLISH=0;
        int MALAYALAM=1;

        int subjRandomIndex=randomizer.nextInt(5);
        int verbRandomIndex=randomizer.nextInt(7);
        int objRandomIndex=randomizer.nextInt(20);
        int drinkRandomIndex=randomizer.nextInt(2);

        String englishSubj="";
        String englishVerb="";
        String englishObj="";
        String malayalamSubj="";
        String malayalamVerb="";
        String malayalamObj="";
        int DRINK=27;

        //Query the lexicon for raw data values and assign them to each syntactic role
        englishSubj=foodTopic.queryMasterLexiconEnglish(roleStart+subjRandomIndex);
        malayalamSubj=foodTopic.queryMasterLexiconMalayalam(roleStart+subjRandomIndex);
        //Sometimes, use a generic pronoun like I, he, she instead of a role like waiter for subject
        boolean usePronounBool=false;
        String[] bothPronouns={"",""};
        if(usePronounBool)
        {
            bothPronouns=returnBothPronouns();
            englishSubj=bothPronouns[ENGLISH];
            malayalamSubj=bothPronouns[MALAYALAM];
        }


        malayalamVerb=foodTopic.queryMasterLexiconMalayalam(verbStart+verbRandomIndex);
        englishVerb= foodTopic.queryMasterLexiconEnglish(verbStart+verbRandomIndex);

        englishObj=foodTopic.queryMasterLexiconEnglish(foodStart+objRandomIndex);
        malayalamObj=foodTopic.queryMasterLexiconMalayalam(foodStart+objRandomIndex);

        //To get a present simple sentence in both languages use Sentence class methods
        englishFullSentence=englishVerbBuilder.returnPastProgressiveSOV(englishSubj,englishVerb,englishObj, usePronounBool);
        malayalamFullSentence=malayalamSentenceBuilder.returnPastProgressiveSentenceSOV(malayalamSubj,malayalamVerb,malayalamObj);

        bothSentences[ENGLISH]=englishFullSentence;
        bothSentences[MALAYALAM]=malayalamFullSentence;
        return bothSentences;
    }

    private String[] getFutreProgressiveSentence()
    {
        String englishFullSentence="";
        String malayalamFullSentence="";
        String[] bothSentences={englishFullSentence, malayalamFullSentence};
        int ENGLISH=0;
        int MALAYALAM=1;

        int subjRandomIndex=randomizer.nextInt(5);
        int verbRandomIndex=randomizer.nextInt(7);
        int objRandomIndex=randomizer.nextInt(20);
        int drinkRandomIndex=randomizer.nextInt(2);

        String englishSubj="";
        String englishVerb="";
        String englishObj="";
        String malayalamSubj="";
        String malayalamVerb="";
        String malayalamObj="";
        int DRINK=27;

        //Query the lexicon for raw data values and assign them to each syntactic role
        englishSubj=foodTopic.queryMasterLexiconEnglish(roleStart+subjRandomIndex);
        malayalamSubj=foodTopic.queryMasterLexiconMalayalam(roleStart+subjRandomIndex);
        //Sometimes, use a generic pronoun like I, he, she instead of a role like waiter for subject
        boolean usePronounBool=false;
        String[] bothPronouns={"",""};
        if(usePronounBool)
        {
            bothPronouns=returnBothPronouns();
            englishSubj=bothPronouns[ENGLISH];
            malayalamSubj=bothPronouns[MALAYALAM];
        }


        malayalamVerb=foodTopic.queryMasterLexiconMalayalam(verbStart+verbRandomIndex);
        englishVerb= foodTopic.queryMasterLexiconEnglish(verbStart+verbRandomIndex);

        englishObj=foodTopic.queryMasterLexiconEnglish(foodStart+objRandomIndex);
        malayalamObj=foodTopic.queryMasterLexiconMalayalam(foodStart+objRandomIndex);

        //To get a present simple sentence in both languages use Sentence class methods
        englishFullSentence=englishVerbBuilder.returnFutureProgressiveSOV(englishSubj,englishVerb,englishObj, usePronounBool);
        malayalamFullSentence=malayalamSentenceBuilder.returnFutureProgressiveSentenceSOV(malayalamSubj,malayalamVerb,malayalamObj);

        bothSentences[ENGLISH]=englishFullSentence;
        bothSentences[MALAYALAM]=malayalamFullSentence;
        return bothSentences;
    }

    private String[] getPastPerfectSentence()
    {
        String englishFullSentence="";
        String malayalamFullSentence="";
        String[] bothSentences={englishFullSentence, malayalamFullSentence};
        int ENGLISH=0;
        int MALAYALAM=1;

        int subjRandomIndex=randomizer.nextInt(5);
        int verbRandomIndex=randomizer.nextInt(7);
        int objRandomIndex=randomizer.nextInt(20);
        int drinkRandomIndex=randomizer.nextInt(2);

        String englishSubj="";
        String englishVerb="";
        String englishObj="";
        String malayalamSubj="";
        String malayalamVerb="";
        String malayalamObj="";
        int DRINK=27;

        //Query the lexicon for raw data values and assign them to each syntactic role
        englishSubj=foodTopic.queryMasterLexiconEnglish(roleStart+subjRandomIndex);
        malayalamSubj=foodTopic.queryMasterLexiconMalayalam(roleStart+subjRandomIndex);
        //Sometimes, use a generic pronoun like I, he, she instead of a role like waiter for subject
        boolean usePronounBool=false;
        String[] bothPronouns={"",""};
        if(usePronounBool)
        {
            bothPronouns=returnBothPronouns();
            englishSubj=bothPronouns[ENGLISH];
            malayalamSubj=bothPronouns[MALAYALAM];
        }


        malayalamVerb=foodTopic.queryMasterLexiconMalayalam(verbStart+verbRandomIndex);
        englishVerb= foodTopic.queryMasterLexiconEnglish(verbStart+verbRandomIndex);

        englishObj=foodTopic.queryMasterLexiconEnglish(foodStart+objRandomIndex);
        malayalamObj=foodTopic.queryMasterLexiconMalayalam(foodStart+objRandomIndex);

        //To get a present simple sentence in both languages use Sentence class methods
        englishFullSentence=englishVerbBuilder.returnPastPerfectThirdPersonSOV(englishSubj,englishVerb,englishObj, usePronounBool);
        malayalamFullSentence=malayalamSentenceBuilder.returnPastPerfectSentenceSOV(malayalamSubj,malayalamVerb,malayalamObj);

        bothSentences[ENGLISH]=englishFullSentence;
        bothSentences[MALAYALAM]=malayalamFullSentence;
        return bothSentences;
    }

    private String[] getFuturePerfectSentence()
    {
        String englishFullSentence="";
        String malayalamFullSentence="";
        String[] bothSentences={englishFullSentence, malayalamFullSentence};
        int ENGLISH=0;
        int MALAYALAM=1;

        int subjRandomIndex=randomizer.nextInt(5);
        int verbRandomIndex=randomizer.nextInt(7);
        int objRandomIndex=randomizer.nextInt(20);
        int drinkRandomIndex=randomizer.nextInt(2);

        String englishSubj="";
        String englishVerb="";
        String englishObj="";
        String malayalamSubj="";
        String malayalamVerb="";
        String malayalamObj="";
        int DRINK=27;

        //Query the lexicon for raw data values and assign them to each syntactic role
        englishSubj=foodTopic.queryMasterLexiconEnglish(roleStart+subjRandomIndex);
        malayalamSubj=foodTopic.queryMasterLexiconMalayalam(roleStart+subjRandomIndex);
        //Sometimes, use a generic pronoun like I, he, she instead of a role like waiter for subject
        boolean usePronounBool=false;
        String[] bothPronouns={"",""};
        if(usePronounBool)
        {
            bothPronouns=returnBothPronouns();
            englishSubj=bothPronouns[ENGLISH];
            malayalamSubj=bothPronouns[MALAYALAM];
        }


        malayalamVerb=foodTopic.queryMasterLexiconMalayalam(verbStart+verbRandomIndex);
        englishVerb= foodTopic.queryMasterLexiconEnglish(verbStart+verbRandomIndex);

        englishObj=foodTopic.queryMasterLexiconEnglish(foodStart+objRandomIndex);
        malayalamObj=foodTopic.queryMasterLexiconMalayalam(foodStart+objRandomIndex);

        //To get a present simple sentence in both languages use Sentence class methods
        englishFullSentence=englishVerbBuilder.returnFuturePerfectSOV(englishSubj,englishVerb,englishObj, usePronounBool);
        malayalamFullSentence=malayalamSentenceBuilder.returnFuturePerfectSentenceSOV(malayalamSubj,malayalamVerb,malayalamObj);

        bothSentences[ENGLISH]=englishFullSentence;
        bothSentences[MALAYALAM]=malayalamFullSentence;
        return bothSentences;
    }


    //String processing methods for this screen
    private void setNewEnglishText()
    {
        txtEnglishFood.setText(currentEnglish);
    }

    private void setNewMalayalmText()
    {
        txtMalayalamFood.setText(currentMalayalam);
    }

    private String newCurrentEnglish(String newSentence)
    {
        currentEnglish="English: " + newSentence;
        return currentEnglish;
    }

    private String newCurrentMalayalm(String newSentence)
    {
        currentMalayalam="Malayalam: " + newSentence;
        return currentMalayalam;
    }

    //Use a random function to determine if to use a pronoun like he/I etc or a normal food noun
    //like waiter, guest etc.
    boolean usePronoun()
    {
        Random rollTheDice=new Random();
        int currentYield= rollTheDice.nextInt(100);
        if(currentYield%2==0)
        {
            return true;
        }
        else
            return false;
    }

    String[] returnBothPronouns()
    {
        int ENGLISH=0;
        int MALAYLAM=1;
        String[] bothPronouns={"",""};
        Random heOrShe=new Random();
        int currentYield=heOrShe.nextInt(7);
        return bothPronouns;
    }
}

