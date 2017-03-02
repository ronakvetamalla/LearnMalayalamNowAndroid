package haagcolorado.joseph.edu.learnmalayalamnow;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;

import java.util.ArrayList;

/**
 * Created by josephhaag on 2/16/17.
 */

public class ReviewScreen extends Activity {
    //Declare widgets
    TextView txtI;
    TextView txtYou;
    TextView txtHe;
    TextView txtShe;
    TextView txtWe;
    TextView txtYou2;
    TextView txtThey;
    Spinner spinnerGrammarChoices;

    //Utilize the help of pronoun and verb classes
    PronounEnglish englishPronounBuilder= new PronounEnglish();
    PronounMalayalamFormal malayalamPronounBuilder= new PronounMalayalamFormal();
    RegularVerbMalayalam malayalamVerbBuilder = new RegularVerbMalayalam();
    RegularVerbEnglish englishVerbBuilder = new RegularVerbEnglish();
    SentenceMalayalam malayalamSentenceBuilder= new SentenceMalayalam();

    //For the purposes of this example, just perform conjugations on the verb walk.
    String verbMalayalm=malayalamVerbBuilder.returnRoot(0); //0 is the index of Walk in the lexicon
    String verbEnglish="Walk";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reviewscreen);

        //Bind widgets
        txtI=(TextView)findViewById(R.id.txtI);
        txtYou=(TextView)findViewById(R.id.txtYou);
        txtHe=(TextView)findViewById(R.id.txtHe);
        txtShe=(TextView)findViewById(R.id.txtShe);
        txtWe=(TextView)findViewById(R.id.txtWe);
        txtYou2=(TextView)findViewById(R.id.txtYou2);
        txtThey=(TextView)findViewById(R.id.txtThey);
        spinnerGrammarChoices=(Spinner)findViewById(R.id.spinnerGrammarChoices);

        //Set initial text values
        txtI.setText(englishPronounBuilder.returnI() + " \n "  + malayalamPronounBuilder.returnI());
        txtYou.setText(englishPronounBuilder.returnYou() + "\n" + malayalamPronounBuilder.returnYou());
        txtHe.setText(englishPronounBuilder.returnHe() + "\n" + malayalamPronounBuilder.returnHe());
        txtShe.setText(englishPronounBuilder.returnShe() + "\n" + malayalamPronounBuilder.returnShe());
        txtWe.setText(englishPronounBuilder.returnWe() + "\n" + malayalamPronounBuilder.returnWe());
        txtThey.setText(englishPronounBuilder.returnThey() + "\n" + malayalamPronounBuilder.returnThey());

        //Add to Spinner
        List<String> lstGrammarChoices = new ArrayList<String>();
        lstGrammarChoices.add("Present Simple Tense");
        lstGrammarChoices.add("Past Simple Tense");
        lstGrammarChoices.add("Future Simple Tense");
        lstGrammarChoices.add("Present Progressive Tense");
        lstGrammarChoices.add("Past Progressive Tense");
        lstGrammarChoices.add("Future Progressive Tense");
        lstGrammarChoices.add("Past Perfect Tense");
        lstGrammarChoices.add("Future Perfect Tense");
        ArrayAdapter<String> aspnGrammar =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lstGrammarChoices);
        aspnGrammar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGrammarChoices.setAdapter(aspnGrammar);
        //Set up callback
        spinnerGrammarChoices.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        //Call set tense with the String param fed from the Spinner choice.
                        setTense(spinnerGrammarChoices.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        setTense("Present Simple Tense");
                    }
                });
    }
    //Use methods to change text of all widgets according to tense
    //Parameter tenseAspectCombo is just an alias for a Spinner choice
    private void setTense(String tenseAspectCombo)
    {
        if(tenseAspectCombo=="Present Simple Tense")
        {
            setPresentSimple();
        }
        else if(tenseAspectCombo=="Past Simple Tense")
        {
            setPastSimple();
        }
        else if(tenseAspectCombo=="Future Simple Tense")
        {
            setFutureSimple();
        }
        else if(tenseAspectCombo=="Present Progressive Tense")
        {
            setPresentProgressive();
        }
        else if(tenseAspectCombo=="Past Progressive Tense")
        {
            setPastProgressive();
        }
        else if(tenseAspectCombo=="Future Progressive Tense")
        {
            setFutureProgressive();
        }
        else if(tenseAspectCombo=="Past Perfect Tense")
        {
            setPastPerfect();
        }
        else if(tenseAspectCombo=="Future Perfect Tense")
        {
            setFuturePerfect();
        }
        else
            ;
    }

    //Generic String joining function to return both English and Malayalm conjugations with newline separator
    private String joinWords(String engPro, String engVerb, String malayPro, String malayVerb, boolean addS)
    {
        if(addS)
        {
            return (engPro + " " + engVerb + "s" +  "\n" + malayPro + " " + malayVerb);
        }
        else
        {
            return (engPro + " " + engVerb +  "\n" + malayPro + " " + malayVerb);
        }
    }

    //Aspect: Simple
    private void setPresentSimple()
    {
        String malayalmVerbConjugated=malayalamVerbBuilder.returnPresentSimple(verbMalayalm);

        //Reset I
        txtI.setText(joinWords(englishPronounBuilder.returnI(),
                verbEnglish,
                malayalamPronounBuilder.returnI(),
                malayalmVerbConjugated, //Feed root and conjugate
                false));
        //Reset You
        txtYou.setText(joinWords(englishPronounBuilder.returnYou(),
                verbEnglish,
                malayalamPronounBuilder.returnYou(),
                malayalmVerbConjugated,
                false));
        //Reset He
        txtHe.setText(joinWords(englishPronounBuilder.returnHe(),
                verbEnglish,
                malayalamPronounBuilder.returnHe(),
                malayalmVerbConjugated,
                true));
        //Reset She
        txtShe.setText(joinWords(englishPronounBuilder.returnShe(),
                verbEnglish,
                malayalamPronounBuilder.returnShe(),
                malayalmVerbConjugated,
                true));
        //Reset We
        txtWe.setText(joinWords(englishPronounBuilder.returnWe(),
                verbEnglish,
                malayalamPronounBuilder.returnWe(),
                malayalmVerbConjugated,
                false));
        //Reset They
        txtThey.setText(joinWords(englishPronounBuilder.returnThey(),
                verbEnglish,
                malayalamPronounBuilder.returnThey(),
                malayalmVerbConjugated,
                false));
    }
    private void setPastSimple()
    {
        String malayalmVerbConjugated=malayalamVerbBuilder.returnPastSimple(verbMalayalm);
        String verbEnglishConjugated=englishVerbBuilder.addPastSimpleSuffix(verbEnglish);

        //Reset I
        txtI.setText(joinWords(englishPronounBuilder.returnI(),
                verbEnglishConjugated, //"ed" added through addPastSimpleSuffix method
                malayalamPronounBuilder.returnI(),
                malayalmVerbConjugated, //Feed root and conjugate
                false));
        //Reset You
        txtYou.setText(joinWords(englishPronounBuilder.returnYou(),
                verbEnglishConjugated,
                malayalamPronounBuilder.returnYou(),
                malayalmVerbConjugated,
                false));
        //Reset He
        txtHe.setText(joinWords(englishPronounBuilder.returnHe(),
                verbEnglishConjugated,
                malayalamPronounBuilder.returnHe(),
                malayalmVerbConjugated,
                false));
        //Reset She
        txtShe.setText(joinWords(englishPronounBuilder.returnShe(),
                verbEnglishConjugated,
                malayalamPronounBuilder.returnShe(),
                malayalmVerbConjugated,
                false));
        //Reset We
        txtWe.setText(joinWords(englishPronounBuilder.returnWe(),
                verbEnglishConjugated,
                malayalamPronounBuilder.returnWe(),
                malayalmVerbConjugated,
                false));
        //Reset They
        txtThey.setText(joinWords(englishPronounBuilder.returnThey(),
                verbEnglishConjugated,
                malayalamPronounBuilder.returnThey(),
                malayalmVerbConjugated,
                false));
    }
    private void setFutureSimple()
    {
        String malayalmVerbConjugated=malayalamVerbBuilder.returnFutureSimple(verbMalayalm);
        String verbEnglishConjugated=englishVerbBuilder.addHelperVerbFutureSimple(verbEnglish);

        //Reset I
        txtI.setText(joinWords(englishPronounBuilder.returnI(),
                verbEnglishConjugated, //"ed" added through addPastSimpleSuffix method
                malayalamPronounBuilder.returnI(),
                malayalmVerbConjugated, //Feed root and conjugate
                false));
        //Reset You
        txtYou.setText(joinWords(englishPronounBuilder.returnYou(),
                verbEnglishConjugated,
                malayalamPronounBuilder.returnYou(),
                malayalmVerbConjugated,
                false));
        //Reset He
        txtHe.setText(joinWords(englishPronounBuilder.returnHe(),
                verbEnglishConjugated,
                malayalamPronounBuilder.returnHe(),
                malayalmVerbConjugated,
                false));
        //Reset She
        txtShe.setText(joinWords(englishPronounBuilder.returnShe(),
                verbEnglishConjugated,
                malayalamPronounBuilder.returnShe(),
                malayalmVerbConjugated,
                false));
        //Reset We
        txtWe.setText(joinWords(englishPronounBuilder.returnWe(),
                verbEnglishConjugated,
                malayalamPronounBuilder.returnWe(),
                malayalmVerbConjugated,
                false));
        //Reset They
        txtThey.setText(joinWords(englishPronounBuilder.returnThey(),
                verbEnglishConjugated,
                malayalamPronounBuilder.returnThey(),
                malayalmVerbConjugated,
                false));
    }

    //Aspect: Progressive
    private void setPresentProgressive()
    {
        String malayalmVerbConjugated=malayalamVerbBuilder.returnPresentProgressive(verbMalayalm);
        String verbEnglishConjugated=englishVerbBuilder.addGerund(verbEnglish); //Add ing to end

        //Reset I
        txtI.setText(joinWords(englishPronounBuilder.returnI(),
                "am " + verbEnglishConjugated, //I am walking
                malayalamPronounBuilder.returnI(),
                malayalmVerbConjugated, //Feed root and conjugate
                false));
        //Reset You
        txtYou.setText(joinWords(englishPronounBuilder.returnYou(),
                "are " + verbEnglishConjugated,
                malayalamPronounBuilder.returnYou(),
                malayalmVerbConjugated,
                false));
        //Reset He
        txtHe.setText(joinWords(englishPronounBuilder.returnHe(),
                "is " + verbEnglishConjugated,
                malayalamPronounBuilder.returnHe(),
                malayalmVerbConjugated,
                false));
        //Reset She
        txtShe.setText(joinWords(englishPronounBuilder.returnShe(),
                "is " + verbEnglishConjugated,
                malayalamPronounBuilder.returnShe(),
                malayalmVerbConjugated,
                false));
        //Reset We
        txtWe.setText(joinWords(englishPronounBuilder.returnWe(),
                "are " + verbEnglishConjugated,
                malayalamPronounBuilder.returnWe(),
                malayalmVerbConjugated,
                false));
        //Reset They
        txtThey.setText(joinWords(englishPronounBuilder.returnThey(),
                "are " + verbEnglishConjugated,
                malayalamPronounBuilder.returnThey(),
                malayalmVerbConjugated,
                false));
    }
    private void setPastProgressive()
    {
        String malayalmVerbConjugated=malayalamVerbBuilder.returnPastProgressive(verbMalayalm);
        String verbEnglishConjugated=englishVerbBuilder.addGerund(verbEnglish); //Add ing to end


        //Reset I
        txtI.setText(joinWords(englishPronounBuilder.returnI(),
                "was " + verbEnglishConjugated, //I am walking
                malayalamPronounBuilder.returnI(),
                malayalmVerbConjugated, //Feed root and conjugate
                false));
        //Reset You
        txtYou.setText(joinWords(englishPronounBuilder.returnYou(),
                "were " + verbEnglishConjugated,
                malayalamPronounBuilder.returnYou(),
                malayalmVerbConjugated,
                false));
        //Reset He
        txtHe.setText(joinWords(englishPronounBuilder.returnHe(),
                "was " + verbEnglishConjugated,
                malayalamPronounBuilder.returnHe(),
                malayalmVerbConjugated,
                false));
        //Reset She
        txtShe.setText(joinWords(englishPronounBuilder.returnShe(),
                "was " + verbEnglishConjugated,
                malayalamPronounBuilder.returnShe(),
                malayalmVerbConjugated,
                false));
        //Reset We
        txtWe.setText(joinWords(englishPronounBuilder.returnWe(),
                "were " + verbEnglishConjugated,
                malayalamPronounBuilder.returnWe(),
                malayalmVerbConjugated,
                false));
        //Reset They
        txtThey.setText(joinWords(englishPronounBuilder.returnThey(),
                "were " + verbEnglishConjugated,
                malayalamPronounBuilder.returnThey(),
                malayalmVerbConjugated,
                false));
    }
    private void setFutureProgressive()
    {
        String malayalmVerbConjugated=malayalamVerbBuilder.returnFutureProgressive(verbMalayalm);
        String verbEnglishConjugated=englishVerbBuilder.addHelperVerbFutureProgressive(verbEnglish); //Add will be
        verbEnglishConjugated=englishVerbBuilder.addGerund(verbEnglishConjugated);  //Add ing

        //Reset I
        txtI.setText(joinWords(englishPronounBuilder.returnI(),
                verbEnglishConjugated, //"ed" added through addPastSimpleSuffix method
                malayalamPronounBuilder.returnI(),
                malayalmVerbConjugated, //Feed root and conjugate
                false));
        //Reset You
        txtYou.setText(joinWords(englishPronounBuilder.returnYou(),
                verbEnglishConjugated,
                malayalamPronounBuilder.returnYou(),
                malayalmVerbConjugated,
                false));
        //Reset He
        txtHe.setText(joinWords(englishPronounBuilder.returnHe(),
                verbEnglishConjugated,
                malayalamPronounBuilder.returnHe(),
                malayalmVerbConjugated,
                false));
        //Reset She
        txtShe.setText(joinWords(englishPronounBuilder.returnShe(),
                verbEnglishConjugated,
                malayalamPronounBuilder.returnShe(),
                malayalmVerbConjugated,
                false));
        //Reset We
        txtWe.setText(joinWords(englishPronounBuilder.returnWe(),
                verbEnglishConjugated,
                malayalamPronounBuilder.returnWe(),
                malayalmVerbConjugated,
                false));
        //Reset They
        txtThey.setText(joinWords(englishPronounBuilder.returnThey(),
                verbEnglishConjugated,
                malayalamPronounBuilder.returnThey(),
                malayalmVerbConjugated,
                false));
    }

    //Aspect: Perfect
    private void setPastPerfect()
    {
        String malayalmVerbConjugated=malayalamVerbBuilder.returnPastPerfect(verbMalayalm);
        String verbEnglishConjugated=englishVerbBuilder.addPastSimpleSuffix(verbEnglish); //Add ed

        //Reset I
        txtI.setText(joinWords(englishPronounBuilder.returnI(),
                englishVerbBuilder.addPerfectHelperNonThirdPerson(verbEnglishConjugated), //"ed" added through addPastSimpleSuffix method
                malayalamPronounBuilder.returnI(),
                malayalmVerbConjugated, //Feed root and conjugate
                false));
        //Reset You
        txtYou.setText(joinWords(englishPronounBuilder.returnYou(),
                englishVerbBuilder.addPerfectHelperNonThirdPerson(verbEnglishConjugated),
                malayalamPronounBuilder.returnYou(),
                malayalmVerbConjugated,
                false));
        //Reset He
        txtHe.setText(joinWords(englishPronounBuilder.returnHe(),
                englishVerbBuilder.addPerfectHelperThirdPerson(verbEnglishConjugated),
                malayalamPronounBuilder.returnHe(),
                malayalmVerbConjugated,
                false));
        //Reset She
        txtShe.setText(joinWords(englishPronounBuilder.returnShe(),
                englishVerbBuilder.addPerfectHelperThirdPerson(verbEnglishConjugated),
                malayalamPronounBuilder.returnShe(),
                malayalmVerbConjugated,
                false));
        //Reset We
        txtWe.setText(joinWords(englishPronounBuilder.returnWe(),
                englishVerbBuilder.addPerfectHelperNonThirdPerson(verbEnglishConjugated),
                malayalamPronounBuilder.returnWe(),
                malayalmVerbConjugated,
                false));
        //Reset They
        txtThey.setText(joinWords(englishPronounBuilder.returnThey(),
                englishVerbBuilder.addPerfectHelperNonThirdPerson(verbEnglishConjugated),
                malayalamPronounBuilder.returnThey(),
                malayalmVerbConjugated,
                false));
    }
    private void setFuturePerfect()
    {
        String malayalmVerbConjugated=malayalamVerbBuilder.returnFuturePerfect(verbMalayalm);
        String verbEnglishConjugated=englishVerbBuilder.addPastSimpleSuffix(verbEnglish);
        verbEnglishConjugated=englishVerbBuilder.addPerfectHelperNonThirdPerson(verbEnglish);
        verbEnglishConjugated=englishVerbBuilder.addHelperVerbFutureSimple(verbEnglishConjugated);
        //Reset I
        txtI.setText(joinWords(englishPronounBuilder.returnI(),
                verbEnglishConjugated, //"ed" added through addPastSimpleSuffix method
                malayalamPronounBuilder.returnI(),
                malayalmVerbConjugated, //Feed root and conjugate
                false));
        //Reset You
        txtYou.setText(joinWords(englishPronounBuilder.returnYou(),
                verbEnglishConjugated,
                malayalamPronounBuilder.returnYou(),
                malayalmVerbConjugated,
                false));
        //Reset He
        txtHe.setText(joinWords(englishPronounBuilder.returnHe(),
                verbEnglishConjugated,
                malayalamPronounBuilder.returnHe(),
                malayalmVerbConjugated,
                false));
        //Reset She
        txtShe.setText(joinWords(englishPronounBuilder.returnShe(),
                verbEnglishConjugated,
                malayalamPronounBuilder.returnShe(),
                malayalmVerbConjugated,
                false));
        //Reset We
        txtWe.setText(joinWords(englishPronounBuilder.returnWe(),
                verbEnglishConjugated,
                malayalamPronounBuilder.returnWe(),
                malayalmVerbConjugated,
                false));
        //Reset They
        txtThey.setText(joinWords(englishPronounBuilder.returnThey(),
                verbEnglishConjugated,
                malayalamPronounBuilder.returnThey(),
                malayalmVerbConjugated,
                false));
    }


}
