package haagcolorado.joseph.edu.learnmalayalamnow;

import android.support.annotation.IntegerRes;
import java.util.Random;

/**
 * Created by josephhaag on 2/10/17.
 */

/*
Learning the Malayalam alphabet is indispensible to any serious undertaking, because it uses an
alphabet distinct from both the Latin alphabet and even that of other Indian languages like Hindi.
The basic philosophy here is to store the 52 letters as images, sounds, and English equivalent Strings
and providing Strings to combine these in game form.
 */

public class AlphabetMalayalam extends Topic {
    //Override inherited methods and fields

    //Each topic will have a lesson number which determines where it is situated within the sequence
    //of lessons in the app
    protected int lessonNumber=1;
    protected String topicName="Alphabet";
    //Since returning an array of Image, Sound, and String is not possible, store each as a property
    //of instantiated Alpgabet object as properties. Use methods to update each individual field
    public int currentImageId;
    public String currentEnglishLetter;
    public int currentAbsoluteIndex;

    //Constructor
    AlphabetMalayalam()
    {
        //Dummy values
        currentImageId=Integer.MAX_VALUE;
        currentEnglishLetter="";
        currentAbsoluteIndex= Integer.MAX_VALUE;
    }

    //Use a method to fetch a vocabulary item from a given topic.
    protected String returnVocab(int index)
    {
        return "";
    }
    protected String returnEnglish(int index)
    {
        return "";

    }
    protected String returnTopicName()
    {
        return topicName;
    }
    protected int returnTopicNumber()
    {
        return lessonNumber;
    }

    //Store indices as constants
    public static final int CHA = 0;
    public static final int DHA= 1;
    public static final int HA = 2;
    public static final int KA= 3;
    public static final int LA= 4;
    public static final int LAPLAY=5;
    public static final int MA = 6;
    public static final int NA = 7;
    public static final int PA =8;
    public static final int RA = 9;
    public static final int RAGRIND=10;
    public static final int RAPOSTROPHE=11;
    public static final int SA= 12;
    public static final int SHA = 13;
    public static final int TA = 14;
    public static final int THA = 15;
    public static final int VA =16;
    public static final int YA = 17;
    public static final int ZHA = 18;
    public static int numLetters= 19;

    //The alphabet class will store a set of Malayalam alphabet letters in three forms
    //First, as an image file
    //Letters as image
    //int icons[] = {R.drawable.a, R.drawable.a1, R.drawable.a2};
    int lettersImages[] = {
            //Return path to image file in drawable
            R.drawable.lettercha,
            R.drawable.letterdha,
            R.drawable.letterha,
            R.drawable.letterka,
            R.drawable.letterla,
            R.drawable.letterlaplay,
            R.drawable.letterma,
            R.drawable.letterna,
            R.drawable.letterpa,
            R.drawable.letterr,
            R.drawable.letterragrind,
            R.drawable.letterrapostrophe,
            R.drawable.lettersa,
            R.drawable.lettersha,
            R.drawable.letterta,
            R.drawable.lettertha,
            R.drawable.letterva,
            R.drawable.letterya,
            R.drawable.letterzha

    };

    //Second, as a sound file pronouned by a native speaker from India
    //Letters as sound

    //Finally, as an English String representation
    //Letters as English equivalent
    public static String[] lettersEnglish = {
            "Cha",
            "Dha",
            "Ha",
            "Ka",
            "La",
            "La",
            "Ma",
            "Na",
            "Pa",
            "Ra",
            "Ra",
            "R' ",
            "Sa",
            "Sha",
            "Ta",
            "Tha",
            "Va",
            "Ya",
            "Zha"
    };

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
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
            Integer.MAX_VALUE,
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

    //Method for fetching various combinations based on symbolic constant index
    public String returnEnglishLetter(int index)
    {
        return lettersEnglish[index];
    }

    public int returnImageId(int index)
    {
        return lettersImages[index];
    }

    //public int returnSound(int index ){ return  }

    public int updateFields(int index)
    {
        //Update fields by calling external methods for each field
        this.currentAbsoluteIndex=index;
        this.currentEnglishLetter=returnEnglishLetter(index);
        //this.currentSound = new sound;
        this.currentImageId=returnImageId(index);
        //Return index as reference for what value one is currently using
        return index;
    }


    //Generic randomization algorithm
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

    //Again, use a generic parameter for both index and array so algorithm
    //can be applied to any arbitrary number of arrays rather than just the one
    public void resetRandomIndices(int numLetters, int[] randomIndices) {
        //The randomize method will only work if all the integer values in the passed array
        //hold an initial dummy value of not zero but rather Integer.MAX_VALUE.
        for(int i=0; i<numLetters; i++)
        {
            randomIndices[i]=Integer.MAX_VALUE;
        }
    }

    public void randomizeAlphabet()
    {
        //First, reset all indices to dummy value Integer.MAX_VALUE
        resetRandomIndices(numLetters, randomizedIndices);
        //Now, the randomization algorithm will work
        ranomdizeIndices(numLetters, randomizedIndices);
    }

    public int getNextRandom(int index)
    {
        if(index<numLetters)
            return randomizedIndices[index];
        else
        {
            numLetters=0;
            return randomizedIndices[index];
        }
    };

    public void updateFieldsRandomly(int index)
    {
        randomizeAlphabet();
        this.updateFields(randomizedIndices[index]);
    }
}
