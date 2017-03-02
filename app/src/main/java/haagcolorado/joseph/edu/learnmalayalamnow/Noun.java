package haagcolorado.joseph.edu.learnmalayalamnow;

/**
 * Created by josephhaag on 2/11/17.
 */

/*
Just as a verb is a subclass of Word that itself branches out to several
Malayalam specific types, nouns are important as a component of language learning
but require their own set of methods that are distinct of those for handling verbs.
 */


public abstract class Noun extends Word {
    protected String baseForm;
    protected int caseUsed;

    protected abstract String declineNoun(int caseUsed);
    protected abstract String feedNoun(String baseForm);
    protected abstract String retrieveNoun(int index);
}
