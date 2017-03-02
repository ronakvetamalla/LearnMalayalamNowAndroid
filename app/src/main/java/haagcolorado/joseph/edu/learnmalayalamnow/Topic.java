package haagcolorado.joseph.edu.learnmalayalamnow;

/**
 * Created by josephhaag on 2/10/17.
 */

/*
Much of learning a language is progressing through a sequence of Topics, usually beginning with
alphabet, greetings, and personal introductions then progressing to learn and use vocabulary on topics
like food, travel, work, school etc. Topic is an abstract superclass that can subclassed
an arbitrarily high number of times to includ each of these topics as needed.
Although topics can include items from any lexical category, they will be primarily concerned with nouns.
The reason is simple- verbs already have a large set of methods available in the RegularVerbMalayalam class.
 */

public abstract class Topic extends Word
{
    //Each topic will have a lesson number which determines where it is situated within the sequence
    //of lessons in the app
    protected int lessonNumber;
    protected String topicName;

    protected abstract String returnTopicName();
    protected abstract int returnTopicNumber();
}
