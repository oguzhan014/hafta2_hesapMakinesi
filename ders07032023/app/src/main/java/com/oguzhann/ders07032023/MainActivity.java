package com.oguzhann.ders07032023;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private String currentNumber = "";
    private String currentOperation = "";
    private Double result = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

        Button buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber = "";
                currentOperation = "";
                result = 0.0;
                textView.setText("0");
            }
        });

        Button buttonEquals = findViewById(R.id.buttonEquals);
        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation();
            }
        });

        Button buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                setOperation("+");
                textView.append("+");

            }

        });

        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation("-");textView.append("-");
            }
        });

        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation("*");
                textView.append("*");
            }
        });

        Button buttonDivide = findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setOperation("/");
                textView.append("/");  //textview de operatorleri görmek için önemli
            }
        });
        /*
        Button buttonDott = findViewById(R.id.buttonDot);
        buttonDivide.setOnClickListener(new View.OnClickListener() {   //buttondot burada ama çalışmiyor tekrar bak!!
            @Override
            public void onClick(View v) {
                setOperation(".");
                textView.append(".");
            }
        });   */

        Button buttonDot = findViewById(R.id.buttonDot);            // burada appendnumber metodu kullanıldı kaynak:stockoverflow!
        buttonDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber(".");
            }
        });



        Button button0 = findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("0");
            }
        });

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("1");
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("2");
            }
        });

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("3");
            }
        });

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("4");
            }
        });

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("5");
            }
        });

        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("6");
            }
        });

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("7");
            }
        });

        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("8");
            }
        });

        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("9");
            }
        });
    }

    private void setOperation(String operation) {
        if (!currentNumber.equals("\0")) {
            if (!currentOperation.equals("")) {
                performOperation();
            }
            currentOperation = operation;
            result = Double.parseDouble(currentNumber);
            currentNumber = "";
        }
    }



    // private void appendNumber(String number) {  asagıdaki kod satırında operatörlerden sonra sayı gelmesi için ayarlamalar yapıldı
     //   currentNumber += number;
       // textView.setText(currentNumber);
   // }
   private void appendNumber(String number) {
       if (currentOperation.equals("")) {
           currentNumber += number;
           textView.setText(currentNumber);
       } else {
           currentNumber += number;
           textView.append(number);
       }
   }

    private void performOperation() {
        if (!currentOperation.equals("") && !currentNumber.equals("")) {
            double currentNumberDouble = Double.parseDouble(currentNumber);
            if (currentOperation.equals("+")) {
                result += currentNumberDouble;
            } else if (currentOperation.equals("-")) {
                result -= currentNumberDouble;
            } else if (currentOperation.equals("*")) {
                result *= currentNumberDouble;
            } else if (currentOperation.equals("/")) {
                result /= currentNumberDouble;
            }
            currentNumber = Double.toString(result);
            textView.setText(currentNumber);
            currentOperation = "";
        }
    }

}
