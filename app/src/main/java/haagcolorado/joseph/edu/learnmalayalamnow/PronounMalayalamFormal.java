package haagcolorado.joseph.edu.learnmalayalamnow;

/**
 * Created by josephhaag on 2/10/17.
 */

/*
    The class for a formal pronoun in Malayalam is a concrete class that provides a lexicon for the
    standard Malayalam pronouns as well as some useful methods for implementing them in conjunction
    with other syntactic components within the app
 */

public class PronounMalayalamFormal extends Pronoun
{
    //Define constants to provide symbolic ordering for arbitrary attributes like gender etc.
    //Symbolic array indexes with English equivalent
    private static final int I = 0;
    private static final int YOU = 1;
    private static final int HE =2;
    private static final int SHE = 3;
    private static final int WE = 4;
    private static final int YOUALL=5;
    private static final int THEY = 6;
    private static final int NUMPERSON=7;

    //Gender symbolic constants
    private static final int MASCULINE = 0;
    private static final int FEMININE = 1;
    private static final int NEUTRAL= 2;
    private static final int NUMGENDERS=3;

    //Person symbolic constants
    private static final int FIRSTPERSON=1;
    private static final int SECONDPERSON=2;
    private static final int THIRDPERSON=3;
    private static final int NUMPERSONS=4;

    //Number symbolic constants
    private static final int SINGULAR=0;
    private static final int PLURAL = 1;
    private static final int NUMNUMBERS=2;

    //Case symblic constants
    private static final int NOMINITIVE= 0;
    private static final int ACCUSATIVE =1;
    private static final int GENITIVE =2;
    private static final int DATIVE = 3;
    private static final int INSTRUMENTAL=4;
    private static final int LOCATIVE=5;
    private static final int SOCIATIVE=6;

    //Include a basic lexicon of Strings representing the possible Malayalam formal pronouns
    //The base lexicon just contains the non-decline nominitive form
    private static String[] formalPronounLexicon = {
            "Njan", //I
            "Ningal", // You singular formal
            "Avan", //he
            "Aval", //she
            "Njangal", //we
            "Ninnal",//You all
            "Avar" //they
    };

    //Provide additional lexicons for each of the other cases
    //Dummy methods- not compelte yet
    private static String[] accusativePronounLexicon = {
            ""
    };

    private static String[] genitivePronounLexicon = {
            ""
    };

    private static String[] dativePronounLexicon = {
            ""
    };

    private static String[] instrumentalPronounLexicon = {
            ""
    };

    private static String[] locativePronounLexicon = {
            ""
    };

    private static String[] sociativePronounLexicon = {
            ""
    };

    //Use a nested array of strings in which each of the pronouns is given its own nested array, with
    //cases organized according symbolic constant index. For example, the 0'th
    //entry of the I array contains the nominitive fully decline result
    private static String[][] allCasesByPronoun = {
            {""},
            {""},
            {""},
            {""},
            {""},
            {""},
            {""},
            {""}
    };




    //Constructor for new formal pronoun object

    PronounMalayalamFormal()
    {
        ;
    }


    //Provide a method where a request for a certain combination of person, case, number, and register
    //returns the given word from the lexicon
    //Provide a validation method that is the only place from which returnPronoun can be called.
    //If an invalid index is given, in other words, than returnPronoun will never get called
    public String validateIndices(int person, int number, int gender)
    {
        if((person<NUMPERSON) && (number < NUMNUMBERS) && (gender < NUMGENDERS))
        {
            return this.returnPronoun(person, number, gender);
        }
        else
            return "";
    }


    //returnPronoun returns only the nominitive or base form of the pronoun. Malyalam has 9
    //cases though
    public String returnPronoun(int person, int number, int gender)
    {
        //Use local variables to store the correct combination of current requested attribute
        switch(person)
        {
            case FIRSTPERSON:
                switch(number)
                {
                    case SINGULAR:
                        return formalPronounLexicon[I]; //If first person and singular, it's I

                    case PLURAL:
                        return formalPronounLexicon[WE]; //Likewise, We

                }

            case SECONDPERSON:
                switch(number)
                {
                    case SINGULAR:
                        return formalPronounLexicon[YOU]; //Second person singular is you
                    case PLURAL:
                        return formalPronounLexicon[YOUALL]; //Second person plural

                }
            case THIRDPERSON:
                switch(number)
                {
                    case SINGULAR:
                        switch(gender)
                        {
                            case MASCULINE:
                                return formalPronounLexicon[HE];  //3rd person, singular, and masculine

                            case FEMININE:
                                return formalPronounLexicon[SHE];  //3rd person, singular, and feminine

                        }

                    case PLURAL:
                        return formalPronounLexicon[THEY];        //3rd person, plural, and neutral

                }

            default:
                break;
        }
        return "";
    }

    //Provide a set of methods that utilize returnPronoun but with shortcuts
    //to return the desired pronoun on demand without having to pass through
    //the task of passing in numbers each time
    //Return I
    @Override
    protected String returnI()
    {
        return returnPronoun(FIRSTPERSON, SINGULAR, NEUTRAL);
    }

    //Return You
    protected String returnYou()
    {
        return returnPronoun(SECONDPERSON, SINGULAR, NEUTRAL);
    }

    //Return He
    protected String returnHe()
    {
        return returnPronoun(THIRDPERSON, SINGULAR, MASCULINE);
    }

    //Return She
    protected String returnShe()
    {
        return returnPronoun(THIRDPERSON, SINGULAR, FEMININE);
    }

    //Return We
    protected String returnWe()
    {
        return returnPronoun(FIRSTPERSON, PLURAL, NEUTRAL);
    }

    //Return They
    protected String returnThey()
    {
        return returnPronoun(THIRDPERSON, PLURAL, NEUTRAL);
    }

}
