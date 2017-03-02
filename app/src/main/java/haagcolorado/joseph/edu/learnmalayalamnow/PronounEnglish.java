package haagcolorado.joseph.edu.learnmalayalamnow;

/**
 * Created by josephhaag on 2/23/17.
 */


//Sister class to PronounFormalMalayalam
public class PronounEnglish extends Pronoun {
    //Because the objective of the app is to learn Malayalma, any English translation will be
    //dependent upon the value of the sentence generated first in Malayalm.
   String currentValue= "";

    PronounEnglish(){
        //Current value stores the last called Pronoun change. It is used
        //with Verb subclasses to conjugate a verb to the correct number and person
        this.currentValue="";
    }

    @Override
    protected String returnI()
    {
        this.currentValue="I";
        return "I";
    }

    protected String returnYou()
    {
        this.currentValue="You";
        return "You";
    }

    protected String returnHe()
    {
        this.currentValue="He";
        return "He";
    }

    protected String returnShe()
    {
        this.currentValue="She";
        return "She";
    }

    protected String returnWe()
    {
        this.currentValue="We";
        return "We";
    }

    protected String returnThey()
    {
        this.currentValue="They";
        return "They";
    }
}
