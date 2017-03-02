package haagcolorado.joseph.edu.learnmalayalamnow;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageButton;
import android.view.View;
import android.widget.TextView;

/**
 * Created by josephhaag on 2/19/17.
 */

public class NumbersScreen extends Activity {
    //Use an object from NumberWordMalayalam class to fetch and process number data
    NumberWordMalayalam numObj;

    //GUI Widgets
    TextView txtBigNumber;
    TextView txtMalayalamNumber;
    AppCompatImageButton btnBackNumber;
    AppCompatImageButton btnNextNumber;

    //Fields
    int currentIndex; //Integer value incremented or decremented by user clicks
    String currentEnglishNumber; //For example, 22
    String currentMalayalamNumber; //For example, Randd
    String displayTextNumberPrompt; //For example, "Number: 22"
    String displayPartialMalayalmText; //For example, Malayalm Number:
    String displayFullMalayalmText; //For example, Malayalam Number: Randd

    @Override
    public void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        //Set to the Numbers Topic module Screen
        setContentView(R.layout.numbersscreen);

        //Call constructor with argument 1 as first number to display
        numObj=new NumberWordMalayalam(1);

        //Set initial text and number values
        displayPartialMalayalmText="Malayalam: ";
        currentIndex=1;

        //Bind GUI widgets
        txtBigNumber=(TextView)findViewById(R.id.txtBigNumber);
        txtMalayalamNumber=(TextView)findViewById(R.id.txtNumberMalayalam);
        btnBackNumber=(AppCompatImageButton)findViewById(R.id.btnBackNumbers);
        btnNextNumber=(AppCompatImageButton)findViewById(R.id.btnNextNumbers);

        //Set event handlers
        findViewById(R.id.btnNextNumbers).setOnClickListener(new HandleNextNum());
        findViewById(R.id.btnBackNumbers).setOnClickListener(new HandleLastNum());

        setNewNumber(currentIndex);
    }

    public void setNewNumber(int index)
    {
        //Set displayTextNumber to concatenation of index cast to string as
        //currentMalayalmNumber and dispalyTextNumber
        //Store an English string representation of current number to display
        currentEnglishNumber=Integer.toString(index);
        displayTextNumberPrompt= "Number: " + currentEnglishNumber;
        currentMalayalamNumber=numObj.getNumWordStr(index);
        displayFullMalayalmText= displayPartialMalayalmText + " " + currentMalayalamNumber;

        //Feed String values to widgets with setText()
        txtBigNumber.setText(displayTextNumberPrompt);
        txtMalayalamNumber.setText(displayFullMalayalmText);
    }

    private class HandleNextNum implements View.OnClickListener
    {
        public void onClick(View arg0)
        {
            AppCompatImageButton nextBtn= (AppCompatImageButton)arg0;
            if(currentIndex<100)
            {
                currentIndex++;
                setNewNumber(currentIndex);
            }
            else
            {
                currentIndex=1;
                setNewNumber(currentIndex);
            }

        }
    }

    private class HandleLastNum implements View.OnClickListener
    {
        public void onClick(View arg0)
        {
            AppCompatImageButton backBtn=(AppCompatImageButton)arg0;
            if(currentIndex==1)
            {
                currentIndex=100;
                setNewNumber(currentIndex);
            }
            else if(currentIndex<=100)
            {
                currentIndex--;
                setNewNumber(currentIndex);
            }
        }

    }

}
