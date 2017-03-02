package haagcolorado.joseph.edu.learnmalayalamnow;

//import Object;

/**
 * Created by josephhaag on 2/10/17.
 */

/*
A sentence is a combination of words, which are themselves instantiations of abstract grammatical
categories such as verbs, pronouns, adjectives, numbers etc.
Much of learning a language is getting practice with sentences that embody previously learned
vocabulary in context.

Although it may seem that only a Malayalam subclass of sentence would be needed for a language learning
app, on the contrary, this will be subclassed for English as well. The reason is that many of the
language quiz techniques will involve matching a set of incorrect English sentences and one correct
English sentence to a given Malayalam sentence.
 */

public abstract class Sentence extends Object
{
    //Have both classes inherit the same set of answeres to allow an intrinsic correlation
    //between the two for quizing purposes
    protected String[] answerKey;

    //protected abstract  String joinPronounVerbObject(String pronounWord, String verbWord, String objectWord);
    //protected abstract String joinPronounVerb(String pronoun, String verb);
    protected abstract String joinNounVerbObject(String noun, String verb, String objectGrammar);
    //protected abstract String jounNounVerb(String noun, String verb);
}
