package haagcolorado.joseph.edu.learnmalayalamnow;

/**
 * Created by josephhaag on 2/10/17.
 */

/*
The Pronoun class is abstract but a useful branch to more concrete classes such as FormalPronoun
and InformalPronoun, which can eventually subclass down to langauge-specific classes implementing
Malayalam informal and formal pronouns
 */

public abstract class Pronoun extends Word
{
    //Though abstract, there are a few properties any given pronoun
    //should embody, irrespective of language.
    //For example, there should be a return value for the following pronouns
    protected abstract String returnI();
    protected abstract String returnYou();
    protected abstract String returnHe();
    protected abstract String returnShe();
    protected abstract String returnWe();
    protected abstract String returnThey();

    //In addition, handle the different grammatical cases as subjective, objective etc.
    /*
    protected boolean formalRegister, informalReigster;
    protected int personGrammatical;
    protected int genderGrammatical;
    protected int numberGrammatical;
    protected boolean nominitive;
    protected boolean accusative;
    protected boolean dative;
    protected boolean genitive;
    protected boolean locative;
    */

}
