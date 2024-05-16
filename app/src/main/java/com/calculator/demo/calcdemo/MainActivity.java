package com.calculator.demo.calcdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtResult;
    private TextView txtSeven, txtEight, txtNine, txtDivide;
    private TextView txtFour, txtFive, txtSix, txtMultiply;
    private TextView txtOne, txtTwo, txtThree, txtMinus;
    private TextView txtZero, txtBack, txtDot, txtPlus;
    private TextView txtEqual;
    private boolean operation = false;
    StringBuilder sb1 = new StringBuilder();
    StringBuilder sb2 = new StringBuilder();
    int s3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtResult = (TextView) findViewById(R.id.txtResult);
        txtSeven = (TextView) findViewById(R.id.txtSeven);
        txtEight = (TextView) findViewById(R.id.txtEight);
        txtNine = (TextView) findViewById(R.id.txtNine);
        txtDivide = (TextView) findViewById(R.id.txtDivide);
        txtFour = (TextView) findViewById(R.id.txtFour);
        txtFive = (TextView) findViewById(R.id.txtFive);
        txtSix = (TextView) findViewById(R.id.txtSix);
        txtMultiply = (TextView) findViewById(R.id.txtMultiply);
        txtOne = (TextView) findViewById(R.id.txtOne);
        txtTwo = (TextView) findViewById(R.id.txtTwo);
        txtThree = (TextView) findViewById(R.id.txtThree);
        txtMinus = (TextView) findViewById(R.id.txtMinus);
        txtZero = (TextView) findViewById(R.id.txtZero);
        txtBack = (TextView) findViewById(R.id.txtBack);
        txtDot = (TextView) findViewById(R.id.txtDot);
        txtPlus = (TextView) findViewById(R.id.txtPlus);
        txtEqual = (TextView) findViewById(R.id.txtEqual);

        txtResult.setOnClickListener(this);
        txtSeven.setOnClickListener(this);
        txtEight.setOnClickListener(this);
        txtNine.setOnClickListener(this);
        txtDivide.setOnClickListener(this);
        txtFour.setOnClickListener(this);
        txtFive.setOnClickListener(this);
        txtSix.setOnClickListener(this);
        txtMultiply.setOnClickListener(this);
        txtOne.setOnClickListener(this);
        txtTwo.setOnClickListener(this);
        txtThree.setOnClickListener(this);
        txtMinus.setOnClickListener(this);
        txtZero.setOnClickListener(this);
        txtBack.setOnClickListener(this);
        txtDot.setOnClickListener(this);
        txtPlus.setOnClickListener(this);
        txtEqual.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.txtResult:
                operation = false;
                break;
            case R.id.txtDivide:
                if (!operation) {
                    s3 = R.string.divide;
                    operation = true;
                    if (sb1.length()>0)
                        txtResult.setText(sb1.toString() + getResources().getString(s3) + sb2.toString());
                    else
                    {
                        if (txtResult.getText().length() > 0) {
                            sb1.append(txtResult.getText().toString());
                            if(txtResult.getText().length()>10)
                                sb1.setLength(sb1.length()-1);
                            txtResult.setText(sb1.toString() + getResources().getString(s3) + sb2.toString());
                        }else
                            txtResult.setText(sb1.toString());
                    }
                }
                break;
            case R.id.txtMultiply:
                if (!operation) {
                    s3 = R.string.multiply;
                    operation = true;
                    if (sb1.length()>0)
                        txtResult.setText(sb1.toString() + getResources().getString(s3) + sb2.toString());
                    else
                    {
                        if (txtResult.getText().length() > 0) {
                            sb1.append(txtResult.getText().toString());
                            if(txtResult.getText().length()>10)
                                sb1.setLength(sb1.length()-1);
                            txtResult.setText(sb1.toString() + getResources().getString(s3) + sb2.toString());
                        }else
                            txtResult.setText(sb1.toString());
                    }
                }
                break;
            case R.id.txtMinus:
                if (!operation) {
                    s3 = R.string.minus;
                    operation = true;
                    if (sb1.length()>0)
                        txtResult.setText(sb1.toString() + getResources().getString(s3) + sb2.toString());
                    else
                    {
                        if (txtResult.getText().length() > 0) {
                            sb1.append(txtResult.getText().toString());
                            if(txtResult.getText().length()>10)
                                sb1.setLength(sb1.length()-1);
                            txtResult.setText(sb1.toString() + getResources().getString(s3) + sb2.toString());
                        }else
                            txtResult.setText(sb1.toString());
                    }
                }
                break;
            case R.id.txtPlus:
                if (!operation) {
                    s3 = R.string.plus;
                    operation = true;
                    if (sb1.length()>0)
                        txtResult.setText(sb1.toString() + getResources().getString(s3) + sb2.toString());
                    else
                    {
                        if (txtResult.getText().length() > 0) {
                            sb1.append(txtResult.getText().toString());
                            if(txtResult.getText().length()>10)
                            sb1.setLength(sb1.length()-1);
                            txtResult.setText(sb1.toString() + getResources().getString(s3) + sb2.toString());
                        }else
                        txtResult.setText(sb1.toString());
                    }
                }
                break;
            case R.id.txtEqual:
                if (operation) {
                    String s1 = sb1.toString();
                    String s2 = sb2.toString();

                    switch (s3) {
                        case R.string.divide:
                            txtResult.setText("" + divide(s1, s2));
                            break;
                        case R.string.plus:
                            txtResult.setText("" + add(s1, s2));
                            break;
                        case R.string.minus:
                            txtResult.setText("" + minus(s1, s2));
                            break;
                        case R.string.multiply:
                            txtResult.setText("" + multiply(s1, s2));
                            break;
                    }
                }
                operation = false;
                break;
            case R.id.txtBack:
                clear();
                break;

            case R.id.txtZero:
                if (operation)
                    sb2.append("0");
                else
                    sb1.append("0");
                if (s3 != 0) {
                    if(txtResult.getText().length()>10)
                        sb1.setLength(sb1.length()-1);
                    txtResult.setText(sb1.toString() + getResources().getString(s3) + sb2.toString());
                }
                else
                    txtResult.setText(sb1.toString());
                break;
            case R.id.txtOne:
                if (operation)
                    sb2.append("1");
                else
                    sb1.append("1");
                if (s3 != 0){
                    if(txtResult.getText().length()>10)
                        sb1.setLength(sb1.length()-1);
                    txtResult.setText(sb1.toString() + getResources().getString(s3) + sb2.toString());
                }
                else
                    txtResult.setText(sb1.toString());
                // txtResult.append("1");
                break;
            case R.id.txtTwo:
                if (operation)
                    sb2.append("2");
                else
                    sb1.append("2");
                if (s3 != 0){
                    if(txtResult.getText().length()>10)
                        sb1.setLength(sb1.length()-1);
                    txtResult.setText(sb1.toString() + getResources().getString(s3) + sb2.toString());
                }
                else
                    txtResult.setText(sb1.toString());
                //txtResult.append("2");
                break;
            case R.id.txtThree:
                if (operation)
                    sb2.append("3");
                else
                    sb1.append("3");
                if (s3 != 0){
                    if(txtResult.getText().length()>10)
                        sb1.setLength(sb1.length()-1);
                    txtResult.setText(sb1.toString() + getResources().getString(s3) + sb2.toString());
                }
                else
                    txtResult.setText(sb1.toString());
                //txtResult.append("3");
                break;
            case R.id.txtFour:
                if (operation)
                    sb2.append("4");
                else
                    sb1.append("4");
                if (s3 != 0){
                    if(txtResult.getText().length()>10)
                        sb1.setLength(sb1.length()-1);
                    txtResult.setText(sb1.toString() + getResources().getString(s3) + sb2.toString());
                }
                else
                    txtResult.setText(sb1.toString());
                //txtResult.append("4");
                break;
            case R.id.txtFive:
                if (operation)
                    sb2.append("5");
                else
                    sb1.append("5");
                if (s3 != 0){
                    if(txtResult.getText().length()>10)
                        sb1.setLength(sb1.length()-1);
                    txtResult.setText(sb1.toString() + getResources().getString(s3) + sb2.toString());
                }
                else
                    txtResult.setText(sb1.toString());
                //txtResult.append("5");
                break;
            case R.id.txtSix:
                if (operation)
                    sb2.append("6");
                else
                    sb1.append("6");
                if (s3 != 0){
                    if(txtResult.getText().length()>10)
                        sb1.setLength(sb1.length()-1);
                    txtResult.setText(sb1.toString() + getResources().getString(s3) + sb2.toString());
                }
                else
                    txtResult.setText(sb1.toString());
                //txtResult.append("6");
                break;
            case R.id.txtSeven:
                if (operation)
                    sb2.append("7");
                else
                    sb1.append("7");
                if (s3 != 0){
                    if(txtResult.getText().length()>10)
                        sb1.setLength(sb1.length()-1);
                    txtResult.setText(sb1.toString() + getResources().getString(s3) + sb2.toString());
                }
                else
                    txtResult.setText(sb1.toString());
                //txtResult.append("7");
                break;
            case R.id.txtEight:
                if (operation)
                    sb2.append("8");
                else
                    sb1.append("8");
                if (s3 != 0){
                    if(txtResult.getText().length()>10)
                        sb1.setLength(sb1.length()-1);
                    txtResult.setText(sb1.toString() + getResources().getString(s3) + sb2.toString());
                }
                else
                    txtResult.setText(sb1.toString());
                // txtResult.append("8");
                break;
            case R.id.txtNine:
                if (operation)
                    sb2.append("9");
                else
                    sb1.append("9");
                if (s3 != 0){
                    if(txtResult.getText().length()>10)
                        sb1.setLength(sb1.length()-1);
                    txtResult.setText(sb1.toString() + getResources().getString(s3) + sb2.toString());
                }
                else
                    txtResult.setText(sb1.toString());
                break;
            case R.id.txtDot:
                if (operation)
                    sb2.append(".");
                else
                    sb1.append(".");
                if (s3 != 0){
                    if(txtResult.getText().length()>10)
                        sb1.setLength(sb1.length()-1);
                    txtResult.setText(sb1.toString() + getResources().getString(s3) + sb2.toString());
                }
                else
                    txtResult.setText(sb1.toString());
                break;

        }


    }

    private void clear() {
        txtResult.setText("");
        sb1.setLength(0);
        sb2.setLength(0);
        s3 = 0;
    }

    private String multiply(String d1, String d2) {
        String t1 = "" + (Double.parseDouble(d1) * Double.parseDouble(d2));
        if (t1.substring(t1.indexOf("."), t1.length()).equals(".0"))
            t1 = t1.replace(".0", "");
        clear();
        return t1;
    }

    private String minus(String d1, String d2) {
        String t1 = "" + (Double.parseDouble(d1) - Double.parseDouble(d2));
        if (t1.substring(t1.indexOf("."), t1.length()).equals(".0"))
            t1 = t1.replace(".0", "");
        clear();
        return t1;
    }

    private String add(String d1, String d2) {
        String t1 = "" + (Double.parseDouble(d1) + Double.parseDouble(d2));
        if (t1.substring(t1.indexOf("."), t1.length()).equals(".0"))
            t1 = t1.replace(".0", "");
        clear();
        return t1;

    }

    private String divide(String d1, String d2) {
        String t1 = "";
        if(d2.equals("0") || d2.equals("0.0")) {
            Toast.makeText(MainActivity.this, "Can not divide by Zero", Toast.LENGTH_SHORT).show();
            clear();
        }else{
            t1 = "" + (Double.parseDouble(d1) / Double.parseDouble(d2));
            if (t1.substring(t1.indexOf("."), t1.length()).equals(".0"))
                t1 = t1.replace(".0", "");
            clear();
        }
        return t1;
    }

}
