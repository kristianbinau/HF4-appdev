package com.example.calculatorjavabasic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {
    private Button btnZero;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button btnFive;
    private Button btnSix;
    private Button btnSeven;
    private Button btnEight;
    private Button btnNine;
    private Button btnAdd;
    private Button btnSubtract;
    private Button btnMultiply;
    private Button btnDivide;
    private Button btnEquals;

    private Button btnClear;
    private Button btnBack;

    private TextView txtInput;
    private TextView txtSolution;

    private Integer firstField;
    private Integer secondField;
    private String operator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("WAR", "efheybuiwfuiwb");

        this.txtInput = (TextView) this.findViewById(R.id.txtInput);
        this.txtSolution = (TextView) this.findViewById(R.id.txtSolution);

        this.btnZero = (Button) this.findViewById(R.id.btnZero);
        this.btnZero.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                numberClick(0);
                updateInputField();
            }
        });

        this.btnOne = (Button) this.findViewById(R.id.btnOne);
        this.btnOne.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                numberClick(1);
                updateInputField();
            }
        });

        this.btnTwo = (Button) this.findViewById(R.id.btnTwo);
        this.btnTwo.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                numberClick(2);
                updateInputField();
            }
        });

        this.btnThree = (Button) this.findViewById(R.id.btnThree);
        this.btnThree.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                numberClick(3);
                updateInputField();
            }
        });

        this.btnFour = (Button) this.findViewById(R.id.btnFour);
        this.btnFour.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                numberClick(4);
                updateInputField();
            }
        });

        this.btnFive = (Button) this.findViewById(R.id.btnFive);
        this.btnFive.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                numberClick(5);
                updateInputField();
            }
        });

        this.btnSix = (Button) this.findViewById(R.id.btnSix);
        this.btnSix.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                numberClick(6);
                updateInputField();
            }
        });

        this.btnSeven = (Button) this.findViewById(R.id.btnSeven);
        this.btnSeven.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                numberClick(7);
                updateInputField();
            }
        });

        this.btnEight = (Button) this.findViewById(R.id.btnEight);
        this.btnEight.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                numberClick(8);
                updateInputField();
            }
        });

        this.btnNine = (Button) this.findViewById(R.id.btnNine);
        this.btnNine.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                numberClick(9);
                updateInputField();
            }
        });

        this.btnSubtract = (Button) this.findViewById(R.id.btnSubtract);
        this.btnSubtract.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                operatorClick("-");
                updateInputField();
            }
        });

        this.btnMultiply = (Button) this.findViewById(R.id.btnMultiply);
        this.btnMultiply.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                operatorClick("*");
                updateInputField();
            }
        });

        this.btnDivide = (Button) this.findViewById(R.id.btnDivide);
        this.btnDivide.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                operatorClick("/");
                updateInputField();
            }
        });

        this.btnAdd = (Button) this.findViewById(R.id.btnAdd);
        this.btnAdd.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                operatorClick("+");
                updateInputField();
            }
        });

        this.btnEquals = (Button) this.findViewById(R.id.btnEquals);
        this.btnEquals.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                operatorClick("=");
                updateInputField();
            }
        });

        this.btnClear = (Button) this.findViewById(R.id.btnClear);
        this.btnClear.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                clearClick();
                updateInputField();
            }
        });

        this.btnBack = (Button) this.findViewById(R.id.btnBack);
        this.btnBack.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                backClick();
                updateInputField();
            }
        });
    }

    protected void numberClick(Integer clickedNumber) {
        Log.i("ClickedOnNumber", clickedNumber.toString());
        txtInput.setText(clickedNumber.toString());
        if (this.operator == null) {
            if (this.firstField != null) {
                this.firstField = Integer.parseInt(this.firstField + "" + clickedNumber);
            } else {
                this.firstField = clickedNumber;
            }
        } else {
            if (this.secondField != null) {
                this.secondField = Integer.parseInt(this.secondField + "" + clickedNumber);
            } else {
                this.secondField = clickedNumber;
            }
        }
    }

    protected void operatorClick(String clickedOperator) {
        Log.i("ClickedOnOperator", clickedOperator);

        if (this.secondField == null) {
            this.operator = clickedOperator;
            return;
        }

        if (this.operator == "+") {
            this.firstField = this.firstField + this.secondField;
        }

        if (this.operator == "-") {
            this.firstField = this.firstField - this.secondField;
        }

        if (this.operator == "/") {
            this.firstField = this.firstField / this.secondField;
        }

        if (this.operator == "*") {
            this.firstField = this.firstField * this.secondField;
        }

        if (clickedOperator == "=") {
            this.operator = null;
        } else {
            this.operator = clickedOperator;
        }
        this.secondField = null;
    }

    protected void updateInputField() {
        String inputFieldText = "";

        if (this.firstField != null) {
            inputFieldText = inputFieldText.concat(this.firstField.toString());
        }

        if (this.operator != null) {
            inputFieldText = inputFieldText.concat(this.operator);
        }

        if (this.secondField != null) {
            inputFieldText = inputFieldText.concat(this.secondField.toString());
        }

        Log.i("setText:", inputFieldText);
        this.txtInput.setText(inputFieldText);
    }

    protected void clearClick() {
        this.firstField = null;
        this.secondField = null;
        this.operator = null;
    }

    protected void backClick() {
        if (this.secondField != null) {
            String secondFieldString = this.secondField.toString();

            if (secondFieldString.length() > 1) {
                this.secondField = Integer.parseInt(secondFieldString.substring(0, secondFieldString.length() - 1));
            } else {
                this.secondField = null;
            }
        } else if (this.operator != null) {
            this.operator = null;
        } else if (this.firstField != null) {
            String firstFieldString = this.firstField.toString();

            if (firstFieldString.length() > 1) {
                this.firstField = Integer.parseInt(firstFieldString.substring(0, firstFieldString.length() - 1));
            } else {
                this.firstField = null;
            }
        }
    }
}