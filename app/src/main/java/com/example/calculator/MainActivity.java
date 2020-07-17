package com.example.calculator;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0,buttonAdd,buttonMul,
            buttonSub,buttonDiv,buttonOpenBrac,buttonCloseBrac,buttonClrScreen,buttonEqual,buttonDec,buttonClr;
    TextView userInput,userOutput;
    String currentInput;
    int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(this);
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(this);
        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(this);
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener(this);
        button5 = findViewById(R.id.button5);
        button5.setOnClickListener(this);
        button6 = findViewById(R.id.button6);
        button6.setOnClickListener(this);
        button7 = findViewById(R.id.button7);
        button7.setOnClickListener(this);
        button8 = findViewById(R.id.button8);
        button8.setOnClickListener(this);
        button9 = findViewById(R.id.button9);
        button9.setOnClickListener(this);
        button0 = findViewById(R.id.button0);
        button0.setOnClickListener(this);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(this);
        buttonMul = findViewById(R.id.buttonMul);
        buttonMul.setOnClickListener(this);
        buttonSub = findViewById(R.id.buttonSub);
        buttonSub.setOnClickListener(this);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonDiv.setOnClickListener(this);
        buttonOpenBrac = findViewById(R.id.buttonOpenBrac);
        buttonOpenBrac.setOnClickListener(this);
        buttonCloseBrac = findViewById(R.id.buttonCloseBrac);
        buttonCloseBrac.setOnClickListener(this);
        buttonClrScreen = findViewById(R.id.buttonClrScreen);
        buttonClrScreen.setOnClickListener(this);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(this);
        buttonDec = findViewById(R.id.buttonDec);
        buttonDec.setOnClickListener(this);
        buttonClr = findViewById(R.id.buttonClr);
        buttonClr.setOnClickListener(this);
        userInput = findViewById(R.id.userInput);
        userOutput = findViewById(R.id.userOutput);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button0){
            buttonClicked("0");
        }else if(view.getId()==R.id.button1){
            buttonClicked("1");
        }else if(view.getId()==R.id.button2){
            buttonClicked("2");
        }else if(view.getId()==R.id.button3){
            buttonClicked("3");
        }else if(view.getId()==R.id.button4){
            buttonClicked("4");
        }else if(view.getId()==R.id.button5){
            buttonClicked("5");
        }else if(view.getId()==R.id.button6){
            buttonClicked("6");
        }else if(view.getId()==R.id.button7){
            buttonClicked("7");
        }else if(view.getId()==R.id.button8){
            buttonClicked("8");
        }else if(view.getId()==R.id.button9){
            buttonClicked("9");
        }else if(view.getId()==R.id.buttonAdd){
            try{
                currentInput= userInput.getText().toString();
                int currentInputLength = currentInput.length();
                Character lastChar = currentInput.charAt(currentInputLength-1);
                if(lastChar!='+' && lastChar!='-'&& lastChar!='*'&& lastChar!='/' && lastChar!='.'){
                    buttonClicked("+");
            }
            }catch(Exception e){}
        }else if(view.getId()==R.id.buttonMul){
            try{
                currentInput= userInput.getText().toString();
                int currentInputLength = currentInput.length();
                Character lastChar = currentInput.charAt(currentInputLength-1);
                if(lastChar!='+' && lastChar!='-'&& lastChar!='*'&& lastChar!='/' && lastChar!='.'){
                    buttonClicked("*");
                }
            }catch(Exception e){}
        }else if(view.getId()==R.id.buttonSub){
            try{
                currentInput= userInput.getText().toString();
                int currentInputLength = currentInput.length();
                Character lastChar = currentInput.charAt(currentInputLength-1);
                if(lastChar!='+' && lastChar!='-'&& lastChar!='*'&& lastChar!='/' && lastChar!='.'){
                    buttonClicked("-");
                }
            }catch(Exception e){}
        }else if(view.getId()==R.id.buttonDiv){
            try{
                currentInput= userInput.getText().toString();
                int currentInputLength = currentInput.length();
                Character lastChar = currentInput.charAt(currentInputLength-1);
                if(lastChar!='+' && lastChar!='-'&& lastChar!='*'&& lastChar!='/' && lastChar!='.'){
                    buttonClicked("/");
                }
            }catch(Exception e){}
        }else if(view.getId()==R.id.buttonOpenBrac){
            buttonClicked("(");
        }else if(view.getId()==R.id.buttonCloseBrac){
            buttonClicked(")");
        }else if(view.getId()==R.id.buttonDec){
            try{
                currentInput= userInput.getText().toString();
                int currentInputLength = currentInput.length();
                Character lastChar = currentInput.charAt(currentInputLength-1);
                if(lastChar!='+' && lastChar!='-'&& lastChar!='*'&& lastChar!='/' && lastChar!='.'){
                    buttonClicked(".");
                }
            }catch(Exception e){}
        }else if(view.getId()==R.id.buttonClrScreen){
            userInput.setText("");
            userOutput.setText("");
        }else if(view.getId()==R.id.buttonClr){
            try {
                currentInput = userInput.getText().toString();
                num = currentInput.length();
                userInput.setText(currentInput.substring(0,num-1));
            }catch(Exception e){}
        }else if(view.getId()==R.id.buttonEqual){
            try{
                currentInput = userInput.getText().toString();
                double result = eval(currentInput);
                userOutput.setText(" = "+result);
            }catch(Exception e){
                Toast.makeText(this,"Wrong Input",Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void buttonClicked(String str){
        userInput.append(str);
    }

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;
            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }
            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }
            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }
            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }
            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }
            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus
                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }
                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation
                return x;
            }
        }.parse();
    }
}