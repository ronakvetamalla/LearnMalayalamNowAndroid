package haagcolorado.joseph.edu.learnmalayalamnow;

import android.renderscript.ScriptIntrinsicYuvToRGB;

/**
 * Created by josephhaag on 2/10/17.
 */

/*
Concrete class that extends Verb but is Malayalam specific and also restricted to providing
operations valid for regular verbs of the language. Useful in conjunction with Pronoun objects.
 */

public class RegularVerbMalayalam extends Verb
{
    //Lexicons available for specific Strings of the Malayalam language's verb, but narrowed down
    //according to infinitive, root, suffix etc. categories

    //Although cumbersome, a set of symbolic constants with the correct English equivalent of
    //of a Malayalam verb in the lexicon is necessary to eliminate magic numbers. As the lexicon expands,
    //there is otherwise simply no clear and easy way to retrieve a given item from it.

    private static final int WALK = 0; //The 0'th entry in the lexicon is the word for walk.
    private static final int STUDY=1; //The 1'th entry in the lexicon is the word for study
    private static final int LIVE=2;
    private static final int DRINK=3;
    private static final int LAUGH=4;
    private static final int TALK=5;
    private static final int SING=6;
    private static final int SEE=7;
    private static final int SWIM=8;
    private static final int REMEMBER=9;

    //Set of symbolic constants to access various suffixes according to grammatical category
    //There are actually two indices for any given resolution to an item with a nested array.
    //THere is both aspect and tense to consider. Only if both are provided can a definite lexeme
    //be reached in the nested array.

    //Aspect constants
    private static final int SIMPLE=0;
    private static final int PROGRESSIVE=1;
    private static final int PERFECT =2;
    private static final int PERFECTCONTINUOUS=3;

    //Tense constants
    private static final int PAST=0;
    private static final int PRESENT=1;
    private static final int FUTURE=2;

    //Open set- expandable arbitrarily as language app grows to new topics
    public static String[] roots = {
            "Nadak", //root for walk
            "Padik", //root for study
            "Thamasik", //root for live such as Njan americayil thamasikkunnu
            "Kudik", //root for drink
            "Chirik", //laugh
            "Samsarik", //talk
            "Paada", //SING
            "Kaana", //SEE
            "Neendha", //SWIM
            "Ormikka" //REMEMBER
    };

    //Open set- expandable arbitrarily as language app grows to new topics
    private static String [] infinitives= {
            "Nadakkuka", //infinitive for to walk
            "Padikkuka",//infinitive for study
            "Thamasikkuka", //infintive for live
            "Kudikkuka", //drink
            "Chirikkuka",//laugh
            "Samsarikkuka", //talk
            "Paaduka",//SING
            "Kaanuka", //SEE
            "Neendhuka", //SWIM
            "Ormikkuka" //REMEMBER
    };

    public String returnInfinitive(int index)
    {
        return infinitives[index];
    }

    public String returnRoot(int index)
    {
        return roots[index];
    }

    //Store size of lexicon as a value not to be exceeded in operations fetching from array
    private static int sizeOfLexicon= roots.length;

    //Closed set- arbitrarily applicable to any given variable input String that satisfies the
    //syntactic requirement
    private static String[][] suffixes = {
            //Simple aspect
            //Nested nested array of past, present, and future simple
            {
                    "nnu", //Past simple
                    "arund", //Present simple
                    "um",  //Future simple

            }
            ,

            //Progressive aspect
            //Nested nested array of past, present, and future progressive
            {
                    "ayayirunnu", //Past progressive
                    "unnu", //Present progressive
                    "um"  //Future progressive
            }
            ,

            //Perfect aspect
            //Nested nested array of past, present, and future perfect
            {
                    "nnirunnu", //Past perfect
                    "nnittund", //Present perfect
                    "nnene"  //Future perfect
            }
            ,

            //Perfect Continuous aspect
            //Nested nested array of past, present, and future perfect continuous
            {
                    "aya-yirunnu", //Past perfect continuous
                    "nnukondi-rikunnu", //Present perfect continuous
                    "a-yayirikkum"  //Future perfect continuous
            }
    };

    //Method for feeding root
    @Override
    public String feedRoot(int indexInt, String[] lexicon)
    {
        if(indexInt < sizeOfLexicon )
            return lexicon[indexInt];
        else
            return "";
    }

    //One irregularity of Malayalam is that for some aspect/tense combinations, the trailing
    //k at the end of the root must be stripped but for other tenses it must be left on.
    public static String stripKs(String root)
    {
        boolean endsWithK=root.endsWith("k");
        String newRoot="";
        if(endsWithK)
        {
            root=root.replace('k', 'a');
        }
        return root;
    }

    //Malayalam verb infinitives end with 'kuka' that must be stripped to enter root form
    public static String stripInfinitive(String infinitive)
    {
        String root;
        root=infinitive.substring(0,infinitive.length()-4);
        return root;
    }

    public static String returnSuffix(int aspect, int tense)
    {
        if((aspect <4)  && (tense < 3))
            return suffixes[aspect][tense];
        else
            return "";
    }

    //Method for adding suffix to root- obviously, this must be called with the return values
    //of the preceding two functions
    //Because of the grammatical irregularities of the language, this function should
    //be called only secondarily to the direct tense aspect combination functions
    //listed below
    public String joinSuffixToRoot(String root, String suffix)
    {
        return root + suffix;
    }

    //Methods for returning each of the given tense/aspect combinations on demand
    //Without such methods, retrieving a given tense aspect combination would rely
    //on magic numbers that would quickly become unmanageable
    public String returnPastSimple(String root)
    {
        root=stripKs(root);
        return root + returnSuffix(0, 0);
    }

    public String returnPresentSimple(String root)
    {
        return root + returnSuffix(0,1);
    }

    public String returnFutureSimple(String root)
    {
        return root + returnSuffix(0,2);
    }

    public String returnPastProgressive(String root)
    {
        return root + returnSuffix(1,0);
    }

    public String returnPresentProgressive(String root)
    {
        return root + returnSuffix(1,1);
    }

    public String returnFutureProgressive(String root)
    {
        return root + returnSuffix(1,2);
    }

    public String returnPastPerfect(String root)
    {
        root=stripKs(root);
        return root + returnSuffix(2,0);
    }

    public String returnPresentPerfect(String root)
    {
        root=stripKs(root);
        return root + returnSuffix(2,1);
    }

    public String returnFuturePerfect(String root)
    {
        root=stripKs(root);
        return root + returnSuffix(2,2);
    }

    public String returnPastPerfectContinuous(String root)
    {
        return root + returnSuffix(3,0);
    }

    public String returnPresentPerfectContinuous(String root)
    {
        root=stripKs(root);
        return root + returnSuffix(3,1);
    }

    public String returnFuturePerfectContinuous(String root)
    {
        return root + returnSuffix(3,2);
    }

    //Methods for returning fully conjugated verb with pronoun

}
