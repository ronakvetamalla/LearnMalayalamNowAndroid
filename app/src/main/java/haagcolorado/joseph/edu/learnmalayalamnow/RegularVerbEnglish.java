package haagcolorado.joseph.edu.learnmalayalamnow;

/**
 * Created by josephhaag on 2/23/17.
 */

public class RegularVerbEnglish extends Verb {
    protected int tense;
    protected String infinitive;
    protected String root;

    public SentenceEnglish englishSentenceBuilder= new SentenceEnglish();
    public PronounEnglish pronounEnglish= new PronounEnglish();

    private static final int ENGLISH=0;

    String currentSentence="";

    //One of the basic Verb operations is conjugation. This presupposes that a root form of the verb
    //be fed into that operation.
    @Override
    protected String feedRoot(int indexInt, String[] lexicon)
    {
        return lexicon[indexInt];
    }

    RegularVerbEnglish()
    {

        this.currentSentence="";
    }
    //Assuming an external multidimensional array stores English at 1'th inner position:
    public String fetchEnglishFromLexicon(String[][] lexicon, int index)
    {
        return lexicon[index][ENGLISH];

    }


    //English syntax is quite different from Malayalm syntax, hence any app that promises
    //to provide clear and consistent yet still algorithmic translations from one language to
    //the other must provide a series of methods for handling English tense transformations
    public String addS(String verb)
    {
        return verb + "s";
    }

    //A gerund in English is the present participle form of a verb where ing is added. For example,
    //walking is the gerund for walk. The following method automatically turns a verb into a gerund
    public String addGerund(String verb)
    {
        return verb+ "ing";
    }

    //In English, tense is signaled more by the addition of a helper verb than
    //inner morphological change, as in other langauges. The following methods add on
    //was, is, will be etc. according to tense
    public String addHelperVerbPast(String verb)
    {
        return "was " + verb;
    }

    public String addHelperVerbPresent(String verb)
    {
        return "is " + verb;
    }

    public String addHelperVerbFutureProgressive(String verb)
    {
        return "will be " + verb;
    }

    public String addHelperVerbFutureSimple(String verb)
    {
        return "will " + verb;
    }

    public String addPerfectHelperThirdPerson(String verb)
    {
        return " has " + verb;
    }

    public String addPerfectHelperNonThirdPerson(String verb)
    {
        return "have " + verb;
    }

    //English also uses added suffixes to denote tense.
    public String addPastSimpleSuffix(String verb)
    {
        return verb+"ed";
    }

    //Simple Aspects
    public String returnPresentSimpleThirdPersonSOV(String noun, String verb, String obj, boolean isPronoun)
    {
        verb=this.addS(verb);
        return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);
    }

    public String returnPastSimpleSOV(String noun, String verb, String obj, boolean isPronoun)
    {
        //Change verb irregular verb regardless of pronoun
        if((verb=="Eat") || (verb=="Make") || (verb=="Chop") || (verb=="Buy") || (verb=="Serve"))
        {
            verb=handleIrregularPast(verb); //For example, change make to made
            return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);
        }
        else
        {
            verb=this.addPastSimpleSuffix(verb);
            return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);
        }

    }

    public String returnFutureSimpleSOV(String noun, String verb, String obj, boolean isPronoun)
    {
        verb=this.addHelperVerbFutureSimple(verb);
        return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);
    }

    //Progress Aspects
    public String returnPresentProgressiveSOV(String noun, String verb, String obj, boolean isPronoun)
    {
        //Handle irregulars
        if((verb=="Make")||(verb=="Serve")||(verb=="Chop"))
        {
            verb=handleIrregularPresent(verb);
            //First add the helper verb is
            verb=this.addHelperVerbPresent(verb);
            //Thend add the gerund
            verb=this.addGerund(verb);
            return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);
        }
        else
        {
            //First add the helper verb is
            verb=this.addHelperVerbPresent(verb);
            //Thend add the gerund
            verb=this.addGerund(verb);
            return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);
        }
    }

    public String returnPastProgressiveSOV(String noun, String verb, String obj, boolean isPronoun)
    {
        if((verb=="Make")||(verb=="Serve")||(verb=="Chop"))
        {
            verb=handleIrregularPresent(verb);
            verb=this.addHelperVerbPast(verb);
            verb=this.addGerund(verb);
            return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);
        }

        else
        {
            verb=this.addHelperVerbPast(verb);
            verb=this.addGerund(verb);
            return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);
        }
    }

    public String returnFutureProgressiveSOV(String noun, String verb, String obj, boolean isPronoun)
    {
        if((verb=="Make")||(verb=="Serve")||(verb=="Chop"))
            verb=handleIrregularPresent(verb);

        //Add same extra morphological components regardless of pronoun or not
        verb=this.addHelperVerbFutureProgressive(verb);
        verb=this.addGerund(verb);
        return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);
    }

    //Perfect Aspect
    public String returnPastPerfectThirdPersonSOV(String noun, String verb, String obj, boolean isPronoun)
    {
        if(verb=="Eat")
        {
            verb=handlePastParticipleIrregular(verb);
            verb=this.addPerfectHelperThirdPerson(verb);
            return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);
        }
        //Handle irregular morphology
        else if((verb=="Make") || (verb=="Chop") || (verb=="Buy") || (verb=="Serve"))
        {
            verb=handleIrregularPast(verb);
            verb=this.addPerfectHelperThirdPerson(verb);
            return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);
        }
        else
        {
            //add the ed suffix
            verb=this.addPastSimpleSuffix(verb);
            verb=this.addPerfectHelperThirdPerson(verb);
            return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);

        }
    }

    public String returnPastPerfectNonThirdPersonSOV(String noun, String verb, String obj, boolean isPronoun)
    {
        if(verb=="Eat")
        {
            verb=handlePastParticipleIrregular(verb);
            verb=this.addPerfectHelperThirdPerson(verb);
            return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);
        }
        //Handle irregular morphology
        else if((verb=="Make") || (verb=="Chop") || (verb=="Buy") || (verb=="Serve"))
        {
            verb=handleIrregularPast(verb);
            verb=this.addPerfectHelperThirdPerson(verb);
            return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);
        }
        else
        {
            //add the ed suffix
            verb=this.addPastSimpleSuffix(verb);
            verb=this.addPerfectHelperThirdPerson(verb);
            return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);

        }
    }

    public String returnFuturePerfectSOV(String noun, String verb, String obj, boolean isPronoun)
    {
        if(verb=="Eat")
        {
            verb=handlePastParticipleIrregular(verb);
            verb=this.addPerfectHelperNonThirdPerson(verb); //add have to beginning
            verb=this.addHelperVerbFutureSimple(verb);  //add will to beginning
            return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);
        }
        else if((verb=="Make") || (verb=="Chop") || (verb=="Buy") || (verb=="Serve"))
        {
            verb=handleIrregularPast(verb);
            verb=this.addPerfectHelperNonThirdPerson(verb); //add have to beginning
            verb=this.addHelperVerbFutureSimple(verb);  //add will to beginning
            return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);
        }
        else
        {
            verb=this.addPerfectHelperNonThirdPerson(verb); //add have to beginning
            verb=this.addHelperVerbFutureSimple(verb);  //add will to beginning
            verb=this.addPastSimpleSuffix(verb); //add ed
            return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);
        }
    }

    //Continuous Aspect
    public String returnPresentContinuousSOV(String noun, String verb, String obj, boolean isPronoun)
    {
        if((verb=="Make")||(verb=="Serve")||(verb=="Chop"))
        {
            verb=handleIrregularPresent(verb);
            verb=this.addHelperVerbPresent(verb); //Add is
            verb=this.addGerund(verb); //Add ing
            return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);
        }
        else
        {
            verb=this.addHelperVerbPresent(verb); //Add is
            verb=this.addGerund(verb); //Add ing
            return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);
        }
    }

    public String returnPastContinuousSOV(String noun, String verb, String obj, boolean isPronoun)
    {
        if((verb=="Make")||(verb=="Serve")||(verb=="Chop"))
        {
            verb=handleIrregularPresent(verb);
            verb=this.addHelperVerbPast(verb); //Add has
            verb=this.addGerund(verb); //Add ing
            return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);
        }
        else
        {
            verb=this.addHelperVerbPast(verb); //Add has
            verb=this.addGerund(verb); //Add ing
            return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);
        }
    }

    public String returnFutureContinuousSOV(String noun, String verb, String obj, boolean isPronoun)
    {
        if((verb=="Make")||(verb=="Serve")||(verb=="Chop"))
        {
            verb=handleIrregularPresent(verb);
            verb=this.addHelperVerbFutureProgressive(verb); //Will be
            verb=this.addGerund(verb); //Add ing
            return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);
        }
        else
        {
            verb=this.addHelperVerbFutureProgressive(verb); //Will be
            verb=this.addGerund(verb); //Add ing
            return englishSentenceBuilder.joinNounVerbObject(noun, verb, obj);
        }
    }

    //It is more efficient to handle English irregulars with three functions rather than in each
    //separate tense forming method above.
    public String handleIrregularPresent(String verb)
    {
        //Use as:
        //if((verb=="Make")||(verb=="Serve"))
        //verb=handleIrregularPresent(verb);
        if(verb=="Make")
        {
            verb="Mak";
        }
        else if(verb=="Serve")
        {
            verb="Serv";
        }
        else if(verb=="Chop")
        {
            verb="Chopp";
        }
        return verb;
    }

    public String handleIrregularPast(String verb)
    {
        //Use as:
        //if((verb=="Eat") || (verb=="Make") || (verb=="Chop"))
        //verb=handleIrregularPast(verb);
        if (verb=="Eat")
        {
            verb="Ate";
        }
        else if(verb=="Make")
        {
            verb="Made";
        }
        else if(verb=="Chop")
        {
            verb="Chopped";
        }
        else if(verb=="Buy")
        {
            verb="Bought";
        }
        else if(verb=="Serve")
        {
            verb="Served";
        }
        return verb;
    }

    public String handlePastParticipleIrregular(String verb)
    {
        //Only verb that needs an irregular participle is eat
        if(verb=="Eat")
            return "Eaten";
        else
            return verb;
    }

}
