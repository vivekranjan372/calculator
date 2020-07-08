package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button one,two,three,four,five,six,seven,eight,nine,zeo,cancel,
    multiply,add,point,equal,minus,inverse,percent,cancelAbove;
private ImageView back,square,squareRoot;
private ImageView divide,subtract;
private TextView input,result;
private String inputNumber="";
private float firstInputNumber=0;
private float secondInputNumber=0;
private String pendingInput="";
private boolean operation=false;
private float total;
private boolean singleOperation=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        back=findViewById(R.id.back);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        zeo=findViewById(R.id.zero);
        cancel=findViewById(R.id.cancel);
        divide=findViewById(R.id.divide);
        multiply=findViewById(R.id.multiply);
        add=findViewById(R.id.add);
        subtract=findViewById(R.id.subtract);
        input=findViewById(R.id.input_show);
        result=findViewById(R.id.result);
        point=findViewById(R.id.point);
        equal=findViewById(R.id.equal);
        minus=findViewById(R.id.minus);
        inverse=findViewById(R.id.inverse);
        percent=findViewById(R.id.percentage);
        cancelAbove=findViewById(R.id.cancel_above);
        square=findViewById(R.id.square);
        squareRoot=findViewById(R.id.square_root);
        back.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        zeo.setOnClickListener(this);
        add.setOnClickListener(this);
        subtract.setOnClickListener(this);
        divide.setOnClickListener(this);
        multiply.setOnClickListener(this);
        cancel.setOnClickListener(this);
        input.setOnClickListener(this);
        result.setOnClickListener(this);
        equal.setOnClickListener(this);
        point.setOnClickListener(this);
        minus.setOnClickListener(this);
        inverse.setOnClickListener(this);
        percent.setOnClickListener(this);
        cancelAbove.setOnClickListener(this);
        square.setOnClickListener(this);
        squareRoot.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {


            switch (v.getId()) {
                case R.id.back: {
                    if (inputNumber.length() == 1) {
                        inputNumber = "";
                    } else {
                        inputNumber = inputNumber.substring(0, inputNumber.length() - 1);
                    }
                    break;
                }
                case R.id.one: {

                    inputNumber += "1";

                    break;
                }
                case R.id.two: {

                    inputNumber += "2";
                    break;
                }
                case R.id.three: {

                    inputNumber += "3";

                    break;
                }
                case R.id.four: {

                    inputNumber += "4";

                    break;
                }
                case R.id.five: {

                    inputNumber += "5";

                    break;
                }
                case R.id.six: {

                    inputNumber += "6";
                    break;
                }
                case R.id.seven: {

                    inputNumber += "7";
                    break;
                }
                case R.id.eight: {

                    inputNumber += "8";


                    break;
                }
                case R.id.nine: {

                    inputNumber += "9";


                    break;
                }
                case R.id.zero: {

                    inputNumber += "0";


                    break;
                }
                case R.id.cancel: {
total=0;
firstInputNumber=0;
secondInputNumber=0;
                    input.setText(pendingInput="");
                    inputNumber="";
                    break;
                }
                case R.id.point:
                {

                    inputNumber+=".";
                    break;
                }
                case R.id.inverse:
                {
                    if(!inputNumber.equals(""))
                    {
                        input.setText("1/("+inputNumber+")");
                        firstInputNumber=Float.parseFloat(inputNumber);
                        firstInputNumber=1/firstInputNumber;
                        inputNumber=String.valueOf(firstInputNumber);
                    }


                    break;
                }
                case R.id.minus:
                {
                      if(inputNumber.charAt(0)=='-')
                      {
                          inputNumber=inputNumber.substring(1);
                      }
                      else {
                          inputNumber="-"+inputNumber;
                      }


                    break;
                }
                case R.id.cancel_above:
                {

                    pendingInput="";
                    input.setText(pendingInput);

                    break;
                }
                case R.id.percentage:
                {
                    if(firstInputNumber!=0)
                    {
                        secondInputNumber=Float.parseFloat(inputNumber);

                        total=(firstInputNumber*secondInputNumber)/100;
                        inputNumber=String.valueOf(total);
                        singleOperation=true;
                    }
                    else
                    {
                        firstInputNumber=Float.parseFloat(inputNumber);

                    }
                    
                    break;
                }
                case R.id.square:
                {
                    if(!inputNumber.equals(""))
                    {
                        input.setText("Sqr("+inputNumber+")");
                        firstInputNumber=Float.parseFloat(inputNumber);
                        firstInputNumber=firstInputNumber*firstInputNumber;
                        inputNumber=String.valueOf(firstInputNumber);
                    }

                    break;
                }
                case R.id.square_root:
                {
                   if(!(inputNumber.equals("")))
                   {
                       input.setText("Sqrt("+inputNumber+")");
                       double getNumber=Double.parseDouble(inputNumber);
                       getNumber=Math.sqrt(getNumber);

                       inputNumber=String.valueOf(getNumber);
                   }
                    break;
                }
                case R.id.add: {

                    firstInputNumber =
                            Float.parseFloat(inputNumber);
                    total+=Float.parseFloat(inputNumber);

                    pendingInput+=inputNumber+"+";
                    input.setText(pendingInput);
                    inputNumber=String.valueOf(total);
singleOperation=true;


                    break;
                }
                case R.id.subtract: {
                    if(firstInputNumber!=0)
                    {
secondInputNumber=Float.parseFloat(inputNumber);
total=firstInputNumber-secondInputNumber;
firstInputNumber=total;
                        pendingInput+=inputNumber+"-";
                        input.setText(pendingInput);
                        inputNumber=String.valueOf(total);
                        singleOperation=true;
                    }
                  else {
                        firstInputNumber =
                                Float.parseFloat(inputNumber);
                        pendingInput+=inputNumber+"-";
                        input.setText(pendingInput);
inputNumber="";


                    }

                    break;
                }
                case R.id.multiply: {
                    if(firstInputNumber!=0)
                    {
                        secondInputNumber=Float.parseFloat(inputNumber);
                        total=firstInputNumber*secondInputNumber;
                        firstInputNumber=total;
                        pendingInput+=inputNumber+"*";
                        input.setText(pendingInput);
                        inputNumber=String.valueOf(total);
                        singleOperation=true;
                    }
                    else {
                        firstInputNumber =
                                Float.parseFloat(inputNumber);
                        pendingInput+=inputNumber+"*";
                        input.setText(pendingInput);
                        inputNumber="";


                    }

                    break;
                }
                case R.id.divide: {
                    if(firstInputNumber!=0)
                    {
                        secondInputNumber=Float.parseFloat(inputNumber);
                        total=firstInputNumber/secondInputNumber;
                        firstInputNumber=total;
                        pendingInput+=inputNumber+"/";
                        input.setText(pendingInput);
                        inputNumber=String.valueOf(total);
                        singleOperation=true;
                    }
                    else {
                        firstInputNumber =
                                Float.parseFloat(inputNumber);
                        pendingInput+=inputNumber+"/";
                        input.setText(pendingInput);
                        inputNumber="";


                    }
                    break;
                }
                case R.id.equal: {
                   String getTex=input.getText().toString();
                   getTex=getTex.substring(getTex.length()-1);
                   switch (getTex)
                   {
                       case "+":
                       {
                           input.setText(pendingInput+inputNumber);
                          secondInputNumber=Float.parseFloat(inputNumber);
                          secondInputNumber=firstInputNumber+secondInputNumber;
                          inputNumber=String.valueOf(secondInputNumber);
                           operation=true;
                           break;
                       }
                       case "-":
                       { input.setText(pendingInput+inputNumber);
                           secondInputNumber=Float.parseFloat(inputNumber);
                           secondInputNumber=firstInputNumber-secondInputNumber;
                           inputNumber=String.valueOf(secondInputNumber);
                           operation=true;
                           break;
                       }
                       case "*":
                       {
                           input.setText(pendingInput+inputNumber);
                           secondInputNumber=Float.parseFloat(inputNumber);
                           secondInputNumber=firstInputNumber*secondInputNumber;
                           inputNumber=String.valueOf(secondInputNumber);
                           operation=true;
                           break;
                       }
                       case "/":
                       { input.setText(pendingInput+inputNumber);
                           secondInputNumber=Float.parseFloat(inputNumber);
                           secondInputNumber=firstInputNumber/secondInputNumber;
                           inputNumber=String.valueOf(secondInputNumber);
                           operation=true;
                           break;
                       }
                   }

                    break;
                }

            }
            if(operation)
            {

                result.setText(inputNumber);
                inputNumber="";
                secondInputNumber=0;
                firstInputNumber=0;
                pendingInput="";
               input.setText("");
                operation=false;
            }
else  if(singleOperation)
            {
                result.setText(inputNumber);
                inputNumber="";

                singleOperation=false;
            }
           else
            {
                       result.setText(inputNumber);

            }

        }
        catch (NumberFormatException | StringIndexOutOfBoundsException e)
        {
            e.printStackTrace();
        }
    }
}