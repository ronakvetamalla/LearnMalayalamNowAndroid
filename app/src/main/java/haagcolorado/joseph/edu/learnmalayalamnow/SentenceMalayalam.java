package haagcolorado.joseph.edu.learnmalayalamnow;

/**
 * Created by josephhaag on 2/11/17.
 */

public class SentenceMalayalam extends Sentence
{
    RegularVerbMalayalam verbBuilder=new RegularVerbMalayalam();
    SentenceEnglish englishSentence=new SentenceEnglish();
    private String currentSentence;
    //Constructor
    SentenceMalayalam( )
    {
        this.currentSentence="";
    }

    //Use objects from external vocabulary Word classes to fetch
    //inputs for sentences
    RegularVerbMalayalam myReg= new RegularVerbMalayalam();
    PronounMalayalamFormal myPro=new PronounMalayalamFormal();



    //Generic sentence building methods. Verb must, however, first be conjugated in a separate method.
    protected String joinNounVerb(String noun, String verb)
    {
        return  noun + " " + verb;
    }

    protected String joinNounVerbObject(String noun, String verb, String obj)
    {
        //Word order in Malayalam is SUBJ OBJ VERB
        //However, a verb passed in as an infintivie straight form the lexicon must still
        //be conjugated to a given tense first. So, conjugation function Verb subclass applied first
        return noun + " " + obj + " " + verb;
    }

    //Set of SOV sentences
    //Simple Aspect
    public String returnPresentSimpleSentenceSOV(String subj, String verb, String obj)
    {
        verb=verbBuilder.stripInfinitive(verb);  //Change from infinitive to root form
        verb=verbBuilder.returnPresentSimple(verb); //Conjugate proper tense ending to root form
        return joinNounVerbObject(subj, verb, obj);
    }

    public String returnPastSimpleSentenceSOV(String subj, String verb, String obj)
    {
        verb=verbBuilder.stripInfinitive(verb);  //Change from infinitive to root form
        verb=verbBuilder.returnPastSimple(verb);
        return joinNounVerbObject(subj, verb, obj);
    }

    public String returnFutureSimpleSentenceSOV(String subj, String verb, String obj)
    {
        verb=verbBuilder.stripInfinitive(verb);  //Change from infinitive to root form
        verb=verbBuilder.returnFutureSimple(verb);
        return joinNounVerbObject(subj, verb, obj);
    }

    //Progressive Aspect
    public String returnPresentProgressiveSentenceSOV(String subj, String verb, String obj)
    {
        verb=verbBuilder.stripInfinitive(verb);
        verb=verbBuilder.returnPresentProgressive(verb);
        return joinNounVerbObject(subj, verb, obj);
    }

    public String returnPastProgressiveSentenceSOV(String subj, String verb, String obj)
    {
        verb=verbBuilder.stripInfinitive(verb);
        verb=verbBuilder.returnPastProgressive(verb);
        return joinNounVerbObject(subj, verb, obj);
    }

    public String returnFutureProgressiveSentenceSOV(String subj, String verb, String obj)
    {
        verb=verbBuilder.stripInfinitive(verb);
        verb=verbBuilder.returnFutureProgressive(verb);
        return joinNounVerbObject(subj, verb, obj);
    }

    //Perfect Aspect
    public String returnPresentPerfectSentenceSOV(String subj, String verb, String obj)
    {
        verb=verbBuilder.stripInfinitive(verb);
        verb=verbBuilder.returnPresentPerfect(verb);
        return joinNounVerbObject(subj, verb, obj);
    }

    public String returnPastPerfectSentenceSOV(String subj, String verb, String obj)
    {
        verb=verbBuilder.stripInfinitive(verb);
        verb=verbBuilder.returnPastPerfect(verb);
        return joinNounVerbObject(subj, verb, obj);
    }

    public String returnFuturePerfectSentenceSOV(String subj, String verb, String obj)
    {
        verb=verbBuilder.stripInfinitive(verb);
        verb=verbBuilder.returnFuturePerfect(verb);
        return joinNounVerbObject(subj, verb, obj);
    }

    //Perfect Continuous Aspect
    public String returnPresentPerfectContinuousSentenceSOV(String subj, String verb, String obj)
    {
        verb=verbBuilder.stripInfinitive(verb);
        verb=verbBuilder.returnPresentPerfectContinuous(verb);
        return joinNounVerbObject(subj, verb, obj);
    }

    public String returnPastPerfectContinuousSentenceSOV(String subj, String verb, String obj)
    {
        verb=verbBuilder.stripInfinitive(verb);
        verb=verbBuilder.returnPastPerfectContinuous(verb);
        return joinNounVerbObject(subj, verb, obj);
    }

    public String returnFuturePerfectContinuousSentenceSOV(String subj, String verb, String obj)
    {
        verb=verbBuilder.stripInfinitive(verb);
        verb=verbBuilder.returnFuturePerfectContinuous(verb);
        return joinNounVerbObject(subj, verb, obj);
    }

    //SV Sentences
    //Simple Aspect
    String returnPresentSimpleSV(String subj, String verb)
    {
        verb=verbBuilder.stripInfinitive(verb);
        verb=verbBuilder.returnPresentSimple(verb);
        return joinNounVerb(subj, verb);
    }

    String returnPastSimpleSV(String subj, String verb)
    {
        verb=verbBuilder.stripInfinitive(verb);
        verb=verbBuilder.returnPastSimple(verb);
        return joinNounVerb(subj, verb);
    }

    String returnFutureSimpleSV(String subj, String verb)
    {
        verb=verbBuilder.stripInfinitive(verb);
        verb=verbBuilder.returnFutureSimple(verb);
        return joinNounVerb(subj, verb);
    }

    //Finish later

}
