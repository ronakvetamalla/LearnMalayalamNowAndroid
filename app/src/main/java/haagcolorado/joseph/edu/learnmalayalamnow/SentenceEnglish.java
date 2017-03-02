package haagcolorado.joseph.edu.learnmalayalamnow;

/**
 * Created by josephhaag on 2/23/17.
 */

//Because English follows different syntactic rules and has different vocabulary than Malayalma,
// a separate class is needed to provide English translations of equivalent sentences
public class SentenceEnglish extends Sentence {
    //Have both classes inherit the same set of answeres to allow an intrinsic correlation
    //between the two for quizing purposes

    protected String[] answerKey;
    private String currentSentence="";
    private PronounEnglish pronoun = new PronounEnglish();
    //private RegularVerbEnglish englishVerbBuilder= new RegularVerbEnglish();

    SentenceEnglish()
    {
        this.currentSentence="";
    }

    //Sentence genreating metods
    protected String joinPronounVerbObject(String pronounWord, String verbWord, String objectWord)
    {
        //English syntax dictates that word order of a valid sentence is SVO, in Malayalm it is SOV
        return pronoun + " " + verbWord + " " + " the " + objectWord;
    }

    protected String joinPronounVerb(String pronoun, String verb)
    {
        return pronoun + " " + verb;
    }

    protected String joinNounVerbObject(String noun, String verb, String objectGrammar)
    {
        return "The " + noun + " " + verb + " " + " the " + objectGrammar;
    }

    protected String joinNounVerb(String noun, String verb)
    {
        return "The " + noun + " " + verb;
    }

    protected String jounNounVerb(String noun, String verb)
    {
        return noun + " " + verb;
    }

}
