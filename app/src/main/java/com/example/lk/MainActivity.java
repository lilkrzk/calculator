package com.example.lk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_history, tv_result;
    private Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9;
    private Button btn_c, btn_sign, btn_del, btn_sqrt, btn_plus,
            btn_minus, btn_mult, btn_div, btn_eq, btn_dot;
    private boolean dot_flag = false;
    boolean sign_flag = false;
    private boolean result_flag = false;
    private double num1 = 0, num2 = 0, result = 0;
    private int code_operation = 0;//1=+,2=-,3=*,4=/
    private int code_operation2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        tv_history = (TextView) findViewById(R.id.tv_history);
        tv_result = (TextView) findViewById(R.id.tv_result);
        tv_result.setText("0");

        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_0.setOnClickListener(this);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_1.setOnClickListener(this);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_2.setOnClickListener(this);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_3.setOnClickListener(this);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_4.setOnClickListener(this);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_5.setOnClickListener(this);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_6.setOnClickListener(this);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_7.setOnClickListener(this);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_8.setOnClickListener(this);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_9.setOnClickListener(this);

        btn_c = (Button) findViewById(R.id.btn_c);
        btn_c.setOnClickListener(this);
        btn_sign = (Button) findViewById(R.id.btn_sign);
        btn_sign.setOnClickListener(this);
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_del.setOnClickListener(this);
        btn_sqrt = (Button) findViewById(R.id.btn_sqrt);
        btn_sqrt.setOnClickListener(this);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_plus.setOnClickListener(this);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_minus.setOnClickListener(this);
        btn_mult = (Button) findViewById(R.id.btn_mult);
        btn_mult.setOnClickListener(this);
        btn_div = (Button) findViewById(R.id.btn_div);
        btn_div.setOnClickListener(this);
        btn_eq = (Button) findViewById(R.id.btn_eq);
        btn_eq.setOnClickListener(this);
        btn_dot = (Button) findViewById(R.id.btn_dot);
        btn_dot.setOnClickListener(this);

    }

    private void putSymbol(String newNumber) {
        tv_result.setText(tv_result.getText().toString().concat(newNumber));
    }

    private void delZero() {
        if (tv_result.getText().toString() == "0")
            tv_result.setText("");
    }

    private double calculateNumber() {
        double number = 0;
        try {
            number = Double.parseDouble(tv_result.getText().toString());
        } catch (Exception e) {
            Toast.makeText(this, "Error Format Number",
                    Toast.LENGTH_SHORT).show();
        }
        return number;
    }

    private void getNumber1() {
        num1 = calculateNumber();
    }

    private void moveToTvHistory() {
        tv_history.setText(tv_history.getText().toString() + tv_result.getText().toString());
        tv_result.setText("");
    }

    private void printResults() {
        tv_history.setText(tv_history.getText().toString() + Double.toString(result));
        result_flag = true;
    }

    public void createResult() {
        switch (code_operation) {
            case 1:
                result = num1 + num2;
                printResults();
                break;
            case 2:
                result = num1 - num2;
                printResults();
                break;
            case 3:
                result = num1 * num2;
                printResults();
                break;
            case 4:
                result = num1 / num2;
                printResults();
                break;
        }
    }

    private void setResultFalse() {
        if (result_flag) {
            tv_history.setText("");
            result_flag = false;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_0:
                setResultFalse();
                delZero();
                putSymbol("0");
                break;
            case R.id.btn_1:
                setResultFalse();
                delZero();
                putSymbol("1");
                break;
            case R.id.btn_2:
                setResultFalse();
                delZero();
                putSymbol("2");
                break;
            case R.id.btn_3:
                setResultFalse();
                delZero();
                putSymbol("3");
                break;
            case R.id.btn_4:
                setResultFalse();
                delZero();
                putSymbol("4");
                break;
            case R.id.btn_5:
                setResultFalse();
                delZero();
                putSymbol("5");
                break;
            case R.id.btn_6:
                setResultFalse();
                delZero();
                putSymbol("6");
                break;
            case R.id.btn_7:
                setResultFalse();
                delZero();
                putSymbol("7");
                break;
            case R.id.btn_8:
                setResultFalse();
                delZero();
                putSymbol("8");
                break;
            case R.id.btn_9:
                setResultFalse();
                delZero();
                putSymbol("9");
                break;


            case R.id.btn_c:
                tv_result.setText("0");
                tv_history.setText("");
                dot_flag = false;
                code_operation = 0;
                code_operation2 = 0;

                break;
            case R.id.btn_sign:
                if(sign_flag)
                {
                    tv_result.setText(tv_result.getText().toString().replace("-", ""));
                    sign_flag = false;

                }
                else
                    {
                    tv_result.setText("-" + tv_result.getText().toString());
                    sign_flag = true;
                    }
                break;
            case R.id.btn_del:
                if (tv_result.getText().toString().length() == 0)
                {
                    tv_result.setText(tv_result.getText());
                }
                tv_result.setText(tv_result.getText().toString().substring(0, tv_result.getText().toString().length() -1));
                break;
            case R.id.btn_sqrt:

                break;

            case R.id.btn_plus:
                getNumber1();
                code_operation = 1;
                code_operation2 = 1;
                moveToTvHistory();
                tv_history.setText(tv_history.getText().toString() + "+");
                break;
            case R.id.btn_minus:
                getNumber1();
                code_operation = 2;
                code_operation2 = 2;
                moveToTvHistory();
                tv_history.setText(tv_history.getText().toString() + "-");
                break;
            case R.id.btn_mult:
                getNumber1();
                code_operation = 3;
                code_operation2 = 3;
                moveToTvHistory();
                tv_history.setText(tv_history.getText().toString() + "*");
                break;
            case R.id.btn_div:
                getNumber1();
                code_operation = 4;
                code_operation2 = 4;
                moveToTvHistory();
                tv_history.setText(tv_history.getText().toString() + "/");
                break;
            case R.id.btn_dot:
                if (tv_result.getText().toString().length() == 0)
                {
                    dot_flag = false;
                }
                if (code_operation2 != 0 ) {
                    dot_flag = false;
                }
                if (!dot_flag) {
                    putSymbol(".");
                    dot_flag = true;
                    code_operation2 = 0;
                }
                break;
            case R.id.btn_eq:
                num2 = calculateNumber();
                moveToTvHistory();
                tv_history.setText(tv_history.getText().toString() + "=");
                createResult();
                dot_flag = false;
                break;
        }
    }
}


