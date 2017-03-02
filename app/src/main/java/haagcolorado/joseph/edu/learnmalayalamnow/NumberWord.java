package haagcolorado.joseph.edu.learnmalayalamnow;

/**
 * Created by josephhaag on 2/10/17.
 */

/*
    NumberWord is a subclass of abstract class Word. Because it is not language specific, it is
    also abstract in the sense that one could never insantiate a Number Word that is not
    a Number Word from a specific language such as Malayalam or Hindi etc. NumberWord supports a set of
    abstract methods that should hold for handling and dealing with number words in a given
    language.
*/

public abstract class NumberWord extends Word
{
    //A given word is a linguistic representation of an integer or double value.
    //For the purposes of simplification, most language education software just deals with
    //linguistic representations of integer values. Still, convertibility from string
    //to integer should be supported and the integer value should therefore form an intrinsic component
    //of the class
    protected static int integerEquivalent;

    //private string representation of the numbe word in any given specific language.
    //Necessary because the word for one is not the same in Hindi, English, and Malayalam
    protected String numWordStr;

    ///Provide a method stub for conversion from string to int
    //public abstract int convertToInt(String numWordStr);

    //Method stub supporting linguistic incrementation and decrementation. For example,
    //the linguistic incrementation of one is two etc.
    //public abstract String incrementNumWord(String numWordStr);
    //public abstract String decrementNumWord(String numWordStr);

    //Method stub for returning string representation of a given number word
    public abstract String getNumWordStr(int integerEquivalent);

}
