package haagcolorado.joseph.edu.learnmalayalamnow;

/**
 * Created by josephhaag on 2/11/17.
 */

public class NounAnimalMalayalam extends Noun {

    //Utilize verb capabilities with RegularVerbMalayalm constructor
    RegularVerbMalayalam verbBuilderMalayalm=new RegularVerbMalayalam();

    //Database of case constants for declension functions
    private static final int NOMINITIVE=0;
    private static final int ACCUSATIVE=1;
    private static final int GENITIVE=2;
    private static final int DATIVE =3;
    private static final int LOCATIVE =4;

    //Symbolic cosntant references to proper index within nested array of lexicon
    private static final int ENGLISH=0;
    private static final int MALAYALAM=1;
    //Lexicon of animal base forms
    public String[][] animalsLexicon = {
            {"Cat", "Poocha"}, //0
            {"Dog", "Naya"}, //1
            {"Dog", "Patti"}, //2
            {"Fish", "Meen"}, //3
            {"Fish", "Malsyam"}, //4
            {"Chicken", "Kozhi"}, //5
            {"Duck", "Thaaraavu"}, //6
            {"Cow", "Pashu"}, //7
            {"Bull", "Kaala"}, //8
            {"Buffalo female", "Eruma"}, //9
            {"Buffalo male", "Pothu"} //10
    };

    protected String baseForm;
    protected int caseUsed;

    //Constructor
    NounAnimalMalayalam()
    {
        this.baseForm="";
        this.caseUsed=0;
    }

    //Noun declension will be deferred to the iOS version of the app
    protected String declineNoun(int caseUsed){return"";}

    //Feed the base form of the noun in Malayalam to a noun declension method.
    protected String feedNoun(String baseForm){return baseForm;}

    //Return both English and Malayalam forms of a given word to an external class
    public String retrieveNoun(int index){
        if(index<=10)
        {
            return animalsLexicon[index][MALAYALAM];
        }
        else
        {
            return "";
        }
    }
}
