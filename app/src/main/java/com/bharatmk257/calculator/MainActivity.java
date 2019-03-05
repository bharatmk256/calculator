package com.bharatmk257.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    //    Button btnClear, btnSeven, btnFour, btnOne, btnZero, btnPercent, btnEight, btnFive, btnTwo, btnDot, btnDevide, btnNine, btnSix, btnThree, btnMinus, btnMultiple, btnPlus, btnResult;


    TextView txtMath, txtDisplay;
    // instance variable
    private String currentNumber;
    private String stringNumberAtLeft;
    private String stringNumberAtRight;
    private OPERATOR currentOperator;
    private double calculationsResult;
    private String calculationString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentNumber = "";
        calculationsResult = 0;
        calculationString = "";

        txtMath = findViewById(R.id.txtMath);
        txtDisplay = findViewById(R.id.txtDisplay);

        findViewById(R.id.btnZero).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnOne).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnTwo).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnThree).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnFour).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnFive).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnSix).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnSeven).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnEight).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnNine).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnClear).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnPercent).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnDot).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnDevide).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnMinus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnMultiple).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnPlus).setOnClickListener(MainActivity.this);
        findViewById(R.id.btnResult).setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.btnZero:
                numberIsTapped(0);
                break;
            case R.id.btnOne:
                numberIsTapped(1);
                break;
            case R.id.btnTwo:
                numberIsTapped(2);
                break;
            case R.id.btnThree:
                numberIsTapped(3);
                break;
            case R.id.btnFour:
                numberIsTapped(4);
                break;
            case R.id.btnFive:
                numberIsTapped(5);
                break;
            case R.id.btnSix:
                numberIsTapped(6);
                break;
            case R.id.btnSeven:
                numberIsTapped(7);
                break;
            case R.id.btnEight:
                numberIsTapped(8);
                break;
            case R.id.btnNine:
                numberIsTapped(9);
                break;
            case R.id.btnClear:
                clearTapped();
                break;
            case R.id.btnPercent:
                break;
            case R.id.btnDot:
                break;
            case R.id.btnDevide:
                operatorIsTapped(OPERATOR.DEVIDE);
                break;
            case R.id.btnMinus:
                operatorIsTapped(OPERATOR.MINUS);
                break;
            case R.id.btnMultiple:
                operatorIsTapped(OPERATOR.MULTIPLY);
                break;
            case R.id.btnPlus:
                operatorIsTapped(OPERATOR.PLUS);
                break;
            case R.id.btnResult:
                operatorIsTapped(OPERATOR.RESULT);
                break;

        }

    }

    private void numberIsTapped(int tappedNumber) {

        currentNumber = currentNumber + String.valueOf(tappedNumber);
        txtDisplay.setText(currentNumber);
    }

    private void operatorIsTapped(OPERATOR tappedOperator) {

        if (currentOperator != null) {
            if (currentNumber != "") {

                stringNumberAtRight = currentNumber;
                currentNumber = "";
                switch (currentOperator) {

                    case PLUS:
                        calculationsResult = Double.parseDouble(stringNumberAtLeft) + Double.parseDouble(stringNumberAtRight);
                        break;
                    case MINUS:
                        calculationsResult = Double.parseDouble(stringNumberAtLeft) - Double.parseDouble(stringNumberAtRight);
                        break;
                    case DEVIDE:
                        calculationsResult = Double.parseDouble(stringNumberAtLeft) / Double.parseDouble(stringNumberAtRight);
                        break;
                    case MULTIPLY:
                        calculationsResult = Double.parseDouble(stringNumberAtLeft) * Double.parseDouble(stringNumberAtRight);
                        break;
                }
                stringNumberAtLeft = String.valueOf(calculationsResult);
                txtDisplay.setText(stringNumberAtLeft);

            }
        } else {
            stringNumberAtLeft = currentNumber;
            currentNumber = "";
        }
        currentOperator = tappedOperator;

    }

    private void clearTapped() {

            stringNumberAtLeft = "";
            stringNumberAtRight = "";
            calculationsResult = 0;
            currentNumber = "";
            currentOperator = null;
            txtDisplay.setText("0");

    }

    private enum OPERATOR {

        PLUS, MINUS, MULTIPLY, DEVIDE, RESULT;

    }

}
