package haagcolorado.joseph.edu.learnmalayalamnow;

import java.util.Random;

/**
 * Created by josephhaag on 2/23/17.
 */

/*
The TopicFood class provides food related vocabulary as well as string processing methods to provide
vocabilary lecture, quiz, and review for Food Topic. Meant to be used with the TopicFoodScreen java
activity class.
 */

public class TopicFood extends Topic {
    //Get help from other classes to teach pronouns and verbs in valid sentences

    //Use an object from Sentence to generate grammatically-valid strings of more than one word
    public SentenceMalayalam sentenceFoodMalayalam = new SentenceMalayalam();

    //Also use English sentence class for equivalent purpose but in English translation
    public SentenceEnglish sentenceFoodEnglish= new SentenceEnglish();

    //Use an object from Pronoun type to teach pronouns and feed pronouns into sentences
    public PronounMalayalamFormal pronounFoodMalayalam= new PronounMalayalamFormal();
    public PronounEnglish pronounFoodEnglish = new PronounEnglish();

    //Use an object of Verb type to provide valid conjugations of verbs
    public RegularVerbMalayalam verbFood= new RegularVerbMalayalam();

    //Use a Random generator
    public Random randomGen=new Random();

    protected int lessonNumber=3;
    protected String topicName="Food";

    @Override
    protected String returnTopicName()
    {
        return topicName;
    }
    protected int returnTopicNumber()
    {
        return lessonNumber;
    }

    //Constructor
    TopicFood()
    {
        this.topicName=this.returnTopicName();
        this.lessonNumber=this.returnTopicNumber();
    }

    //Store vocabulary in two equivalently-indexed String arrays with a set of
    //symbolic constants to store the English key for each lexicon.
    //These arrays contain base forms of the words that are fed into the verb, pronoun, and sentene
    //objects to provide correct conjugation for final viewing.
    //First entry of each nested array is Malayalm, second is English.
    //Access by feeding symbolic constant into second index and lexical key into first index. For example,
    //foodNounLexicon[COOK][ENGLISH] will return the English value of the word for cook.
    private static final int ENGLISH=0;
    private static final int MALAYALAM= 1;

    //Noun symbolic constant indices
    private static final int RICEUNCOOKED=0;
    private static final int RICECOOKED=1;
    private static final int POTATO=2;
    private static final int CHICKEN=3;
    private static final int MEAT= 4;
    private static final int CURRY= 5;
    private static final int FISH=6;
    private static final int CORN=7;
    private static final int WHEAT=8;
    private static final int BEANS=9;
    private static final int EGGS=10;
    private static final int WATER1=11;
    private static final int WATER2=12;
    private static final int FRUIT=13;
    private static final int BANANA=14;
    private static final int FLATBREAD=15;
    private static final int RICEPANCAKE=16;
    private static final int VEGETABLES=17;
    private static final int LENTILS=18;
    private static final int PEPPER=19;
    private static final int ONION=20;
    private static final int TOMATO=21;
    public static final int numFoodNouns=22;

    public int foodNounCount() { return numFoodNouns; }

    private final static int numLexemes=1;
    private String[][] foodNounLexicon= {
            {"Rice (uncooked)","Ari"}, //0
            {"Rice (cooked)","Choru"}, //1
            {"Potato","Urulakkizhangu"}, //2
            {"Chicken","Kozhi"}, //3
            {"Meat","Maamsam"}, //4
            {"Curry","curry"}, //5
            {"Fish","Malsyam"}, //6
            {"Corn","Cholam"}, //7
            {"Wheat","Gothambu"}, //8
            {"Beans","Payaru"}, //9
            {"Eggs","Mutta"}, //10
            {"Water","Vellam"}, //11
            {"Water","Jalam"}, //12
            {"Fruit","Pazham"}, //13
            {"Banana","Pazham"}, //14
            {"Flatbread (wheat)","Chapaati"}, //15
            {"Pancake (rice)","Appam"}, //16
            {"Vegetables","Pachakkari"}, //17
            {"Lentils","Parippu"}, //18
            {"Pepper","Kurumulaku"}, //19
            {"Onion","Ulli"}, //20
            {"Tomato","Thakkali"}, //21
    };

    //Symbolic constant table for verb lexicon
    private static final int COOK=0;
    private static final int SERVE=1;
    private static final int BUY=2;
    private static final int CHOP=3;
    private static final int EAT=4;
    private static final int DRINK=5;
    private static final int MAKE =6;
    public static final int NUMFOODVERBS=7;

    public int foodVerbCount()
    {
        return NUMFOODVERBS;
    }

    private String[][] foodVerbLexicon={
            {"Cook","paakam cheyyuka"}, //0
            {"Serve","Vilambuka"}, //1
            {"Buy","Vaanguka"}, //2
            {"Chop","Murikkukka"}, //3
            {"Eat","Kazhikkuka"}, //4
            {"Drink","Kudikkuka"}, //5
            {"Make","Undakkuka"} //6
    };

    //Store nouns related to human roles rather than food items. For example, waiter, cook etc
    //private static final int
    private static final int COOKMAN=0;
    private static final int COOKWOMAN=1;
    private static final int WAITER =2;
    private static final int WAITRESS=3;
    private static final int GUEST=4;

    private String[][] foodHumanRoleLexicon={
            {"Cook (man)","Paachakakkaaran"}, //0
            {"Cook (woman)","Paachakakkaari"}, //1
            {"Waiter (one who serves)","Vilambukaaran"}, //2
            {"Waitress","Vilambukaari"}, //3
            {"Guest", "Athidhi" }
    };

    //Beverage Nouns
    private static final int TEA=0;
    private static final int COFFEE=1;
    private static final int ALCOHOL=2;

    private String[][] drinkNounLexicon={
            {"Tea","Chaaya"}, //0
            {"Coffee","Kaappi"}, //1
            {"Alcohol","Madyam"} //2
    };

    //The String array that actually interfaces to external Activity subclass will be just this one
    //large index so allow one consistent set of indices to query from using the method
    //queryMasterLexicon for both languages
    public String[][] masterLexicon={
            //Food nouns
            {"Rice","Ari"}, //0
            {"Rice","Choru"}, //1
            {"Potato","Urulakkizhangu"}, //2
            {"Chicken","Kozhi"}, //3
            {"Meat","Maamsam"}, //4
            {"Curry","curry"}, //5
            {"Fish","Malsyam"}, //6
            {"Corn","Cholam"}, //7
            {"Wheat","Gothambu"}, //8
            {"Beans","Payaru"}, //9
            {"Eggs","Mutta"}, //10
            {"Fish","Malsyam"}, //11
            //{"Water","Vellam"}, //
            {"Water","Jalam"}, //12
            {"Fruit","Pazham"}, //13
            {"Banana","Pazham"}, //14
            {"Wheat Flatbread","Chapaati"}, //15
            {"Rice Pancake","Appam"}, //16
            {"Vegetables","Pachakkari"}, //17
            {"Lentils","Parippu"}, //18
            {"Pepper","Kurumulaku"}, //19
            {"Onion","Ulli"}, //20
            {"Tomato","Thakkali"}, //21
            //Verbs
            {"Cook","paakam cheyyuka"}, //22
            {"Serve","Vilambuka"}, //23
            {"Buy","Vaanguka"}, //24
            {"Chop","Murikkukka"}, //25
            {"Chop","Murikkukka"},
            {"Eat","Kazhikkuka"}, //27
            //{"Drink","Kudikkuka"}, //27
            {"Make","Undakkuka"}, //28
            //Roles
            {"Cook (man)","Paachakakkaaran"}, //29
            {"Cook (woman)","Paachakakkaari"}, //30
            {"Waiter","Vilambukaaran"}, //31
            {"Waitress","Vilambukaari"}, //32
            {"Guest", "Athidhi" }, //33
            //Drinks
            {"Tea","Chaaya"}, //34
            {"Coffee","Kaappi"}, //35
            {"Alcohol","Madyam"} //36
    };

    //Meal times
    private static final int BREAKFAST=0;

    /*
    He serves the rice- Avan choru vilambunnu
    The guest eats the meat- Athidhi maamsam kazhikkunnu
    I chop the vegetables- Njan pachakkari murikkunnu
    The cook makes the curry- Paachakakkaaran curry undaakkunnu
    The woman buys tomatoes- Sthree thakkaali vaangunnu
    The chef cooks the fish- Paachakakkaari malsyam paakam cheyyunnu
    The guest eats the rice- Athidhi choru kazhikkunnu
    Minu George Vettamala
    Minu


    That man drinks the coffee- Aa manushyan kappi kudikkunnu
    Kaappi

    'll be okay with a cup of coffee
    Kaappi kudichaal sheriyaavum
     */
    private String[][] mealLexicon = {
            {"Breakfast","Praathal"},
            {"Lunch","Uchabhakshanam"},
            {"Supper","Athaazham"}
    };


    //Use a method to fetch a vocabulary item from a given topic.
    protected String returnVocab(int index, String[][] lexicon) {
        //Use generic parameter lexicon for any String array. Index here should be a symbolic constant
        //referring to the leixcal key in English. For example, return
        //foodVerbLexicon[EAT][MALAYALAM] as returnVocab(EAT, foodVerbLexicon) will give you the Malayalm
        //word for eat
        return lexicon[index][MALAYALAM];
    }
    protected String returnEnglish(int index, String[][] lexicon)
    {
        //Repeat the same process but for English
        return lexicon[index][ENGLISH];
    }

    public String queryMasterLexiconMalayalam(int index)
    {
        return masterLexicon[index][MALAYALAM];
    }

    public String queryMasterLexiconEnglish(int index)
    {
        return masterLexicon[index][ENGLISH];
    }

    //Iterate over lexicons one item at a time
    public String nextFoodNounMalayalam(int index)
    {
        if(index<numFoodNouns)
            return returnVocab(index, foodNounLexicon);
        else
            return "";
    }

    public String nextFoodNounEnglish(int index)
    {
        if(index<numFoodNouns)
            return returnEnglish(index, foodNounLexicon);
        else
            return "";
    }

    public String nextFoodVerbMalayalam(int index)
    {
        index= index - this.foodNounCount();
        return returnVocab(index, foodVerbLexicon);
    }

    public String nextFoodVerbEnglish(int index)
    {
        index=index - this.foodNounCount();
        return returnEnglish(index, foodVerbLexicon);
    }


    //Handle verb conjugation
    private String conjugateVerbMalayalam(int index, String[][] lexicon, RegularVerbMalayalam verbBuilder)
    {
        //Since we are feeding from the Food lexicon in this class, we will not use the
        //lexicon embedded in the Verb class.
        //Also, since we will defer more complicated verb conjugations til topic 4, Animals, just return simple present
        //Because Malayalm does not add endings for differnt person or number, just call one unconditional method
        String conjugatedVerb= verbBuilder.returnPresentSimple(lexicon[index][MALAYALAM]);
        return conjugatedVerb;
    }


    //By topic 3, string processing methods are required that return full, albeit simple, but still
    //syntactically correct sentences rather than single words. The logic of returning
    //a full sentence that follows non-English gramatical rules is inherently more sophisticated
    //than previous methods that return only one word. Enlist the aid of the Sentence object to do so

}
