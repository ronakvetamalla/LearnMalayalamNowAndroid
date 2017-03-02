package haagcolorado.joseph.edu.learnmalayalamnow;

/**
 * Created by josephhaag on 2/10/17.
 */

/*
Abstract supercalss Verb outlines some of the general properties of a Verb irrespective of language.
For example, any given verb has an infinitive form, a root, and a set of tenses.
 */


public abstract class Verb extends Word
{
    protected int tense;
    protected String infinitive;
    protected String root;

    //One of the basic Verb operations is conjugation. This presupposes that a root form of the verb
    //be fed into that operation.
    protected abstract String feedRoot(int indexInt, String[] lexicon);
    //public abstract String conjugatePresent();
    //public abstract String conjugatePast();
    //public abstract String conjugateFuture();

    //In addition, pairing a given verb form with its proper pronoun match is a basic opereation
    //public abstract String matchPronoun(String conjugatedVerb);
}
