package com.example.calculator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.calculator.R;
public class MainActivity extends AppCompatActivity {
    private EditText editOp1;
    private EditText editOp2;
    private TextView textResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editOp1 = findViewById(R.id.editOp1);
        editOp2 = findViewById(R.id.editOp2);
        textResult = findViewById(R.id.textResult);
        Button btnAdd = findViewById(R.id.btnAdd);
        Button btnSubtract = findViewById(R.id.btnSubtract);
        Button btnMultiply = findViewById(R.id.btnMultiply);
        Button btnDivide = findViewById(R.id.btnDivide);
        Button btnReset = findViewById(R.id.btnReset);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('+');
            }
        });
        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('-');
            }
        });
        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('*');
            }
        });
        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate('/');
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearInputsAndResult();
            }
        });
    }
    private void calculate(char operator) {
        double num1 = Double.parseDouble(editOp1.getText().toString());
        double num2 = Double.parseDouble(editOp2.getText().toString());
        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    result = Double.NaN; // Handle division by zero
                }
                break;
            default:
                result = 0;
        }
        textResult.setText("Result: " + result);
    }
    private void clearInputsAndResult() {
        editOp1.setText("");
        editOp2.setText("");
        textResult.setText("");
    }
}
