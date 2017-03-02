package haagcolorado.joseph.edu.learnmalayalamnow;

import android.util.Log;

import java.util.Random;

/**
 * Created by josephhaag on 2/12/17.
 */

public class GreetingMalayalam extends Topic {
    //Start the app lesson with basic greeting vocabulary, in the tradition
    //of most high school and college introductory language courses

    //Start the app lesson with basic greeting vocabulary, in the tradition
    //of most high school and college introductory language courses

    //Use a set of symbolic constants to access the correct lexeme in the set.
    //Without this ordered set of constants, the lexicon would quickly become
    //an unmanageable set of magic numbers
    private static final int HELLO=0;
    private static final int THANKYOU=1;
    private static final int MYNAMEIS=2;
    private static final int MYNAMEISJOE=3;
    private static final int GOODBYEPLACE=4;
    private static final int GOODBYENORMAL=5;
    private static final int GOODMORNING=6;
    private static final int GOODNIGHT=7;
    private static final int GOODAFTERNOON=8;
    private static final int GOODEVENING=9;
    public static int numLexemes=10;

    public int currentIndex;

    public GreetingMalayalam()
    {
        this.currentIndex=0;
    }

    public int getNumIndices()
    {
        return numLexemes-1;
    }

    public static String[] greetingsLexicon= {
            "Namaskaaram", //Hello
            "Nanni", //Thank you
            "Ente peru",//My name is
            "Ente peru Joe", //My name is Joe
            "Poi varam ", //Goodbye if you're leaving a place
            "Shubha yathra", //Goodbye if you're the host bidding farewell
            "Suprabhatham", //Good morning
            "Shubha rathri", //Good night
            "Shubha madhyahnam", //Good afternoon
            "Shubha saayahnam" //Good evening
    };

    public static String[] englishKey= {
            "Hello",
            "Thank you",
            "My name is",
            "My name is Joe",
            "Goodbye (leaving a place)",
            "Goodbye (bidding farewell)",
            "Good morning",
            "Good night",
            "Good afternoon",
            "Good evening"
    };

    public static String[] greetingsRandom={
            "","","","","","","","",""
    };

    public static String[] englishGreetingsRandom={
            "","","","","","","","",""
    };

    public static String[] wrongAnswers={"","","","","","","","","",""};

    public static int[] wrongAnswerIndices= { Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
    };

    //The following array will store the ranomized indices which will then be fed to retrieve
    //the correct entry from both English and Malayalam lexicons. The logic is that the same intrinisc
    //index will be used for both, allowing randomization to be only be needed in the set of
    //integers contained below, not in the set of strings in each lexicon.
    public static int [] randomizedIndices = {
            //Because 0 is a valid index, we must use some other dummy value as the initial value
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE
    };

    protected int lessonNumber=0;
    protected String topicName="Greetings";
    protected String returnVocab(int index)
    {
        if(index<numLexemes)
        {
            return greetingsLexicon[index];
        }
        else
            return "";
    }

    protected String returnEnglish(int index)
    {
        if(index<numLexemes)
        {
            return englishKey[index];
        }
        else
            return "";
    }

    protected String[] returnEnglishAndMalayalam(int index)
    {
        int malayalam =0;
        int english=1;
        String[] bothLanguages= {"",""};
        bothLanguages[malayalam]=greetingsLexicon[index];
        bothLanguages[english]=englishKey[index];
        return bothLanguages;
    }

    //@Override
    protected String returnTopicName()
    {
        String topicName=this.topicName;
        return topicName;
    }

    protected int returnTopicNumber()
    {
        return lessonNumber;
    }

    //Provide a set of as many randomized integers as there are entires in each lexicon.
    //Then, rewrite the values of the randomIntegers index with each one.

    //This and the below methods should be applied to all Topic subclasses
    //but not to each individual class of nouns or verbs etc.
    public static void ranomdizeIndices(int numEntries, int indices[])
    {
        int numRewritten=0;
        int currentIteration=0;
        boolean alreadyIn=false;
        while(true)
        {
            for(int i=0; i<=numRewritten; i++)
            {
                Random randomizer= new Random();
                currentIteration=randomizer.nextInt(numEntries-1);
                //First test if the random number just generated is already written in randomizedIndices
                for(int j=0; j<numRewritten; j++)
                {
                    //If number is already contained ANYWHERE in array, break
                    if(indices[j]==currentIteration)
                    {
                        alreadyIn=true;
                        break;
                    }
                    else
                    {
                        alreadyIn=false;
                    }

                }

                if(!alreadyIn)
                {
                    if(indices[i]==Integer.MAX_VALUE)
                    {
                        if(currentIteration!=indices[i])
                        {
                            indices[i]=currentIteration;
                            numRewritten++;
                            //System.out.println("Iteration number " + i + " is " + indices[i]);

                        }
                    }
                }
            }
            if(numRewritten==numEntries-1)
                break;
        }
        return ;
    }

    public void resetRandomIndices(int numIndices)
    {
        for(int i=0; i<numIndices; i++)
        {
            randomizedIndices[i]=Integer.MAX_VALUE;
            //System.out.println("The value is now " + randomizedIndices[i]);
        }
        return;

    }

    //Have a function specifically for returning randomized entries of either or both languages
    //by calling the method ranomdizeIndices or resetRandomIndices

    public void randomizeBoth(int numIndices)
    {
        int currentRandomNumber;
        //Reset all values to default
        resetRandomIndices(numIndices);
        //Call a new randomization of them
        ranomdizeIndices(numIndices, randomizedIndices);
        for(int i=0; i<numIndices-1; i++)
        {
            currentRandomNumber=randomizedIndices[i];

            greetingsRandom[i]= greetingsLexicon[currentRandomNumber];
            //System.out.println("Lexeme at location " + i + " is " + greetingsRandom[i]);
            englishGreetingsRandom[i]=englishKey[currentRandomNumber];
            //System.out.println("Lexeme at location " + i + " is " + englishGreetingsRandom[i]);
        }
    }

    //Assuming the set of randoms has already been reset and already randomized by calling randomizeBoth
    public String nextRandomMalayalam(int index)
    {
        if(index < numLexemes -1)
            return greetingsRandom[index];
        else
            return englishKey[0];
    }

    public String nextRandomEnglish(int index)
    {
        if(index < numLexemes-1)
            return englishGreetingsRandom[index];
        else
            return greetingsLexicon[0];
    }

    //Provide methods for quiz mode. Randomize both lexicons, store the index
    //for the correct answer in English to a given word, but also generate three
    //additional random choices. Then, randomize the order in which the 4 appear but
    //still store the correct index as one of those numbers.
    public void randomizeWrongAnswers(){
        ranomdizeIndices(numLexemes, wrongAnswerIndices);
    }
}
