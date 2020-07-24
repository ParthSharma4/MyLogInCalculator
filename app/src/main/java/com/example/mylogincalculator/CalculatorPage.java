package com.example.mylogincalculator;

import androidx.appcompat.app.AppCompatActivity;
import java.lang.*;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CalculatorPage extends AppCompatActivity {

    //Main Calculator class from assignment 3

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btn0;
    Button btnAdd;
    Button btnSub;
    Button btnDiv;
    Button btnMul;
    Button btnEqual;
    Button btnDot;
    Button btnClear;
    EditText ed1;
    Button btnLog;
    Button btnEx;
    float Res1,Res2;
    boolean Add,Sub,Mul,Div,Ex,Log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_page);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);

        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);

        btn9 = (Button) findViewById(R.id.btn9);
        btn0 = (Button) findViewById(R.id.btn0);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);

        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnEqual = (Button) findViewById(R.id.btnEqual);
        btnDot = (Button) findViewById(R.id.btnDot);

        btnClear = (Button) findViewById(R.id.btnClear);
        ed1 = (EditText) findViewById(R.id.editText);
        btnLog = (Button) findViewById(R.id.btnLog);
        btnEx = (Button) findViewById(R.id.btnEx);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"2");
            }
        });btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"3");
            }
        });btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"4");
            }
        });btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"5");
            }
        });btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"6");
            }
        });btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"7");
            }
        });btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"8");
            }
        });btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"9");
            }
        });btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+"0");
            }
        });btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText(ed1.getText()+".");
            }
        });

        btnEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed1==null){
                    ed1.setText("");
                }else{
                    Res1 =Float.parseFloat(ed1.getText()+ "");
                    Ex = true;
                    ed1.setText(null);
                }
            }
        });

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed1==null){
                    ed1.setText("");
                }else{
                    Res1 =Float.parseFloat(ed1.getText()+ "");
                    Log = true;
                    ed1.setText(null);
                }
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed1==null){
                    ed1.setText("");
                }else{
                    Res1 = Float.parseFloat(ed1.getText()+"");
                    Add= true;
                    ed1.setText(null);
                }
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed1==null){
                    ed1.setText(ed1.getText()+"-");
                }else{
                    Res1 = Float.parseFloat(ed1.getText()+"");
                    Sub= true;
                    ed1.setText(null);
                }
            }
        });
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed1==null){
                    ed1.setText("");
                }else{
                    Res1 = Float.parseFloat(ed1.getText()+"");
                    Mul= true;
                    ed1.setText(null);
                }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ed1==null){
                    ed1.setText("");
                }else{
                    Res1 = Float.parseFloat(ed1.getText()+"");
                    Div= true;
                    ed1.setText(null);
                }
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Res2 = Float.parseFloat(ed1.getText()+"");
                if (Add==true){
                    ed1.setText(Res1+Res2+"");
                    Add=false;

                }
                if (Sub==true){
                    ed1.setText(Res1-Res2+"");
                    Sub=false;

                }if (Mul==true){
                    ed1.setText(Res1*Res2+"");
                    Mul=false;

                }if (Div==true){
                    if (Res2 == 0){
                       ed1.setText("ERROR cannot divide by zero");
                    }else {
                        ed1.setText(Res1 / Res2 + "");
                        Div = false;
                    }
                }if (Ex==true){
                    ed1.setText(Math.exp(Res1)+"");
                    Ex=false;

                }if (Log==true){
                    if(Res1<=0){
                        ed1.setText("ERROR Log cannot take negavite values or zero");
                    }else{
                        ed1.setText(Math.log(Res1)+"");
                        Log=false;
                    }

                }


            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ed1.setText("");
            }
        });
    }
}