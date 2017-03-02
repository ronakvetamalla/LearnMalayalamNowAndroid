package haagcolorado.joseph.edu.learnmalayalamnow;

/**
 * Created by josephhaag on 2/10/17.
 */

/*
    The abstract Word class is the superlcass of all Word objects used in the langauge education
    app. Word contains a set of method stubs valid for all words of any lexical class
    and any language.
*/

public abstract class Word extends Object
{
    //Abstract properties of any given word, irrespective of language
    //For example, any given word should have a base form
    protected String baseForm;

    //Every method should return the string
    //public abstract String returnString(String thisWord);
}
