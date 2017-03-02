package haagcolorado.joseph.edu.learnmalayalamnow;

/**
 * Created by josephhaag on 2/10/17.
 */

/*
NumberWordMalayalam is a direct subclass of NumberWord and implicit subclass of Word. Unlike the previous
abstract classes, it provides concrete methods specific to Malayalam vocabulary, grammatical rules, and pronunciation.
 */

public class NumberWordMalayalam extends NumberWord
{
    //Most of the work in this class is only relevant internally. The main interface to the outside
    //classes and app in general is the getNumWordStr() which converts one int parameter
    //to a string representation in Malayalam of that word
    private int integerEquivalent;
    private String numWordStr;

    //Provide a set of Class methods and static fields to allow correlation between
    //a raw integer value and the Malayalam lexeme for that value
    //Numerical index is equivalent to desired number. For example, array index 1 contains the number 1
  private static String [] numsToTen  = {
            "",       //Zero
            "onn",    //One
            "randd",  //Two
            "moonn",  //Three
            "naal",  //Four
            "anj",   //Five
            "aar",   //Six
            "ezhu",  //Seven
            "ettu",  //Eight
            "onpath",//Nine
            "patth",//Ten
    };

    //Number can be retrieved by adding 10 to index. For example, index 1 contains the number 11.
    private static  String [] numsElevenToTwenty = {
            "",                                 //empty
            numsToTen[10] + "in" + numsToTen[1], //Eleven
            numsToTen[10] + numsToTen[2],        //Twelve
            numsToTen[10] + "i" + numsToTen[3],  //Thirteen
            numsToTen[10] + "i" + numsToTen[4],  //Fourteen
            numsToTen[10] + "in" + numsToTen[5], //Fifteen
            numsToTen[10] + "in" + numsToTen[6], //Sixteen
            numsToTen[10] + "inez",             //Seventeen
            numsToTen[10] + "inett",            //Eighteen
            numsToTen[10] + "inpath",           //Ninteen
            "irupath"                          //Twenty
    };


    //Following numbers are by ten. Equivalent to desired index times ten. For example, index 1 contains number 10
    private static String [] numsTenToHundredByTens= {
        "",  //empty
        numsToTen[10], //Index 1 is 10
        numsElevenToTwenty[10], //Index 2 is 20
        "Mup" + numsToTen[10], //Index 3 is 30
        numsToTen[4] + numsToTen[10], //40
        "Ambath", //50
        "Arupath", //60
        numsToTen[7] + numsToTen[10], //70
        "Enpath", //80
        "Thonnur", //90
        "Nooru"
    };

    public  static String[] numsTwentyOneOn = {
            numsElevenToTwenty[10], //20
            "irupathi onnu", //21
            "irupathi randu", //22
            "irupathi moonnu", //23
            "irupathi naalu", //24
            "irupathi anchu", //25
            "irupathi aaru", //26
            "irupathi ezhu", //27
            "irupathi ettu", //28
            "irupathi onpathu", //29
            " muppathu" //20
    };

    //Structure of the language holds that the same endings
    //as String can be refilled for numbers from 21 to 99
    //For example the ending of 39 is the same as the ending
    //for 79 so feed the endings from here witha  method
    public static String[] endingsTwentyOneOn = {
            //Index arithmetic to access desired ending is
            //that ending for 31 etc is index 1.
            "",
            " onnu", //Ending for 21, 31, 41 etc
            " randu",// Ending for 22, 32 etc.
            " moonnu", //Ending for 33 etc.
            " naalu",  //Ending for 34 etc.
            " anchu", //Ending for 35 etc
            " aaru", //Ending for 36 etc.
            " ezhu", //Ending for 37 etc.
            " ettu", //Ending for 38 etc.
            " onpathu", //Ending for 39 etc
    };

    //Use the following method to join first and second place digits and add the i ending
    //For example, the number 33 is mupatthi moonu with the added i to the end of the first half
    //Feed first parameter from array numsTenToHundredByTens
    //Feed second parameter from array endingsTwentyOneOn
    public String joinFirstAndSecondDigit(String first, String second)
    {
        String middle= "i";
        return first + middle + second;
    }

    //Use the following method to parse two digit characters from a numerical string
    //that is greater than one character in length. For example, the digits 3 and 1
    //must be parsed from the string 31, with each digit assigned its appropriate
    //location within that ordering.
    public int[] parseDigitsFromInt(int integerEquivalent)
    {
        //Store the results as an int array to feed them into a switch statement in another method
        int[] parsedDigits={
                0,  //Store parsed digit from the ones column as index 0
                0   //Store parsed digit from the tens column as index 1
        };

        //Proceed only if integerEquivaent parameter is greater than 9- that is,
        //only if it has 2 or more digit spots anyhow.
        //First, run tests for the ones column
        if(integerEquivalent>9)
        {
            //If it is 21 or 31, then subtracting 1 and dividing by ten will have no remainder
            if(((integerEquivalent - 1)%10 == 0))
            {
                parsedDigits[0]=1;
            }
            else if(((integerEquivalent - 2)%10 == 0))
            {
                parsedDigits[0]=2;
            }
            else if(((integerEquivalent - 3)%10 == 0))
            {
                parsedDigits[0]=3;
            }
            else if(((integerEquivalent - 4)%10 == 0))
            {
                parsedDigits[0]=4;
            }
            else if(((integerEquivalent - 5)%10 == 0))
            {
                parsedDigits[0]=5;
            }
            else if(((integerEquivalent - 6)%10 == 0))
            {
                parsedDigits[0]=6;
            }
            else if(((integerEquivalent - 7)%10 == 0))
            {
                parsedDigits[0]=7;
            }
            else if(((integerEquivalent - 8)%10 == 0))
            {
                parsedDigits[0]=8;
            }
            else if(((integerEquivalent - 9)%10 == 0))
            {
                parsedDigits[0]=9;
            }
        }
        //Then run a second set of tests for the tens column
        for(int i=10; i<100; i+=10)
        {
            if(integerEquivalent-parsedDigits[0]==i)
            {
                parsedDigits[1]=(int)((double)i/10.0);
            }
        }

        return parsedDigits;
    }

    //Use another method to call joinFirstAndSecondDigit with an int parameter
    //to resolve correct string from a number
    public String getNumWordStrTwetnyOneOn(int integerEquivalent)
    {
        int[] parsedDigits={0,0};
        parsedDigits=parseDigitsFromInt(integerEquivalent);
        int onesDigit=parsedDigits[0];
        int tensDigit=parsedDigits[1];

        //The correct word will be formed by following conditional arithmetic
        //For example, to get 21 the formula is to call function as f(2,1)
        //since 20 is at index 2 in the numsTenToHundredByTens array
        //and the ending for 21 is at index 1. This is intentional
        //to remove the ambiguities and frustrations of an off by one indexing

        return joinFirstAndSecondDigit(numsTenToHundredByTens[tensDigit], endingsTwentyOneOn[onesDigit]);
    }

    //Constructor for a new Malayalam Number object
    NumberWordMalayalam(int integerEquivalent){
            this.integerEquivalent=integerEquivalent;
            this.numWordStr = getNumWordStr(this.integerEquivalent);
    }

    public void changeNumber(int newNumber)
    {
        this.integerEquivalent=newNumber;

    }


    //Override the conversion method to return a String word from a given desired integer value

    //The most important method here and the main one that interfaces to outside classes and the app itself
    @Override
    public String getNumWordStr(int integerEquivalent)
    {
        //Cannot convert for a number beyond the range of strings accounted for
        int maxAcceptedNumber = 101;

        if((integerEquivalent < maxAcceptedNumber) && (integerEquivalent >0))
        {
            //If Number less than ten, index is same as desired number
            if(integerEquivalent < 11)
            {
                return numsToTen[integerEquivalent];
            }
            //If number between 11 and 20, desired string is equal to index plus 10
            //Conversely, the actual index is the integer equivalent minus 10
            else if(integerEquivalent <21)
            {
                return (numsElevenToTwenty [integerEquivalent - 10]);
            }
            else if((integerEquivalent <101) && ((integerEquivalent % 10) == 0))
            {
                return (numsTenToHundredByTens[integerEquivalent/10]);
            }
            //If number is over 20, use this method to return a composite
            //string that follows the valid rules of the language
            else if((integerEquivalent <101) && ((integerEquivalent % 10) != 0))
            {
                return getNumWordStrTwetnyOneOn(integerEquivalent);
            }
            else if(integerEquivalent==100)
            {
                return "Nooru";
            }


        }
        return "";
    }
}
