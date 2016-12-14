package com.example.random.calculator;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.util.Stack;

import static java.math.RoundingMode.CEILING;
import static java.math.RoundingMode.DOWN;
import static java.math.RoundingMode.FLOOR;
import static java.math.RoundingMode.HALF_DOWN;
import static java.math.RoundingMode.HALF_UP;
import static java.math.RoundingMode.UNNECESSARY;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button brackets;
    private Button delete;
    private Button clear;
    private Button divide;
    private Button btn_7;
    private Button btn_8;
    private Button btn_9;
    private Button multiply;
    private Button btn_4;
    private Button btn_5;
    private Button btn_6;
    private Button reduce;
    private Button btn_1;
    private Button btn_2;
    private Button btn_3;
    private Button add;
    private Button btn_0;
    private Button point;
    private Button save;
    private Button equal;
    private EditText Edit_text;
    private TextView textview;
    private int left_brackets = 0;
    private int right_brackets = 0;
    Stack numStack = new Stack();//创建一个存放后缀表达式的堆栈
    Stack operaStack = new Stack();//创建一个存放运算符号的堆栈


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.introduction:
                final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("功能介绍");
                dialog.setMessage("<     删除一位" + '\n' +
                        "c     清除所有" + '\n' +
                        "s     保存结果作为运算内容");
                dialog.setCancelable(false);
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                dialog.show();
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        EditText edit = (EditText) findViewById(R.id.Edit_text);
        init();
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(edit.getWindowToken(), 0);
        View view = this.getCurrentFocus();
        if (view != null) {
            imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void init() {
        Edit_text = (EditText) findViewById(R.id.Edit_text);
        brackets = (Button) findViewById(R.id.brackets);
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        delete = (Button) findViewById(R.id.delete);
        clear = (Button) findViewById(R.id.clear);
        divide = (Button) findViewById(R.id.divide);
        multiply = (Button) findViewById(R.id.multiply);
        reduce = (Button) findViewById(R.id.reduce);
        add = (Button) findViewById(R.id.add);
        point = (Button) findViewById(R.id.point);
        save = (Button) findViewById(R.id.save);
        equal = (Button) findViewById(R.id.equal);
        textview = (TextView) findViewById(R.id.Text_out);
        brackets.setOnClickListener(this);
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        delete.setOnClickListener(this);
        clear.setOnClickListener(this);
        divide.setOnClickListener(this);
        multiply.setOnClickListener(this);
        reduce.setOnClickListener(this);
        add.setOnClickListener(this);
        point.setOnClickListener(this);
        save.setOnClickListener(this);
        equal.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_0:
                String Mystring = Edit_text.getText().toString();
                try {
                    String lastword_zero = Mystring.substring(Mystring.length() - 1, Mystring.length());
                    if (lastword_zero.equals("0")) {

                    } else {
                        Mystring += "0";
                    }
                } catch (Exception E) {
                    Mystring = "0";
                }
                Edit_text.setText(Mystring);
                Edit_text.setSelection(Edit_text.getText().length());
                break;
            case R.id.btn_1:
                String Mystring1 = Edit_text.getText().toString();
                Mystring1 += "1";
                Edit_text.setText(Mystring1);
                Edit_text.setSelection(Edit_text.getText().length());
                break;
            case R.id.btn_2:
                String Mystring2 = Edit_text.getText().toString();
                Mystring2 += "2";
                Edit_text.setText(Mystring2);
                Edit_text.setSelection(Edit_text.getText().length());
                break;
            case R.id.btn_3:
                String Mystring3 = Edit_text.getText().toString();
                Mystring3 += "3";
                Edit_text.setText(Mystring3);
                Edit_text.setSelection(Edit_text.getText().length());
                break;
            case R.id.btn_4:
                String Mystring4 = Edit_text.getText().toString();
                Mystring4 += "4";
                Edit_text.setText(Mystring4);
                Edit_text.setSelection(Edit_text.getText().length());
                break;
            case R.id.btn_5:
                String Mystring5 = Edit_text.getText().toString();
                Mystring5 += "5";
                Edit_text.setText(Mystring5);
                Edit_text.setSelection(Edit_text.getText().length());
                break;
            case R.id.btn_6:
                String Mystring6 = Edit_text.getText().toString();
                Mystring6 += "6";
                Edit_text.setText(Mystring6);
                Edit_text.setSelection(Edit_text.getText().length());
                break;
            case R.id.btn_7:
                String Mystring7 = Edit_text.getText().toString();
                Mystring7 += "7";
                Edit_text.setText(Mystring7);
                Edit_text.setSelection(Edit_text.getText().length());
                break;
            case R.id.btn_8:
                String Mystring8 = Edit_text.getText().toString();
                Mystring8 += "8";
                Edit_text.setText(Mystring8);
                Edit_text.setSelection(Edit_text.getText().length());
                break;
            case R.id.btn_9:
                String Mystring9 = Edit_text.getText().toString();
                Mystring9 += "9";
                Edit_text.setText(Mystring9);
                Edit_text.setSelection(Edit_text.getText().length());
                break;
            case R.id.brackets:
                String Mybrackets = Edit_text.getText().toString();
                try {
                    String lastword_brackets;
                    if (Mybrackets.length() == 0) {
                        lastword_brackets = null;
                    } else {
                        lastword_brackets = Mybrackets.substring(Mybrackets.length() - 1, Mybrackets.length());
                    }
                    if (lastword_brackets.equals("(") || lastword_brackets.equals("+") || lastword_brackets.equals("-") || lastword_brackets.equals("×") || lastword_brackets.equals("/") || lastword_brackets.equals(null)) {
                        Mybrackets = Mybrackets + "(";
                        left_brackets++;
//                    Log.d("brackets:", String.valueOf(left_brackets)+String.valueOf(right_brackets));
//                   以上log是调试左右括号数量所用
                    } else if (left_brackets > right_brackets) {
                        Mybrackets = Mybrackets + ")";
                        right_brackets++;
//                    Log.d("brackets:", String.valueOf(left_brackets)+String.valueOf(right_brackets));
                    } else {
                        Mybrackets = Mybrackets + "×(";
                        left_brackets++;
//                    Log.d("brackets:", String.valueOf(left_brackets)+String.valueOf(right_brackets));
                    }
                } catch (Exception E) {
                    Mybrackets = Mybrackets + "(";
                    left_brackets++;
//                    Log.d("brackets:", String.valueOf(left_brackets)+String.valueOf(right_brackets));
                }
                Edit_text.setText(Mybrackets);
                Edit_text.setSelection(Edit_text.getText().length());
                break;
            case R.id.point:
                String Mypoint = Edit_text.getText().toString();
                if (Mypoint.equals("")) {
                    Mypoint += "0.";
                } else {
                    Mypoint += ".";
                }
                Edit_text.setText(Mypoint);
                Edit_text.setSelection(Edit_text.getText().length());
                break;
            case R.id.divide:
                String Mydivide = Edit_text.getText().toString();
                Mydivide += "/";
                Edit_text.setText(Mydivide);
                Edit_text.setSelection(Edit_text.getText().length());
                break;
            case R.id.multiply:
                String Mymultiply = Edit_text.getText().toString();
                Mymultiply += "×";
                Edit_text.setText(Mymultiply);
                Edit_text.setSelection(Edit_text.getText().length());
                break;
            case R.id.reduce:
                String Myreduce = Edit_text.getText().toString();
                Myreduce += "-";
                Edit_text.setText(Myreduce);
                Edit_text.setSelection(Edit_text.getText().length());
                break;
            case R.id.add:
                String Myadd = Edit_text.getText().toString();
                Myadd += "+";
                Edit_text.setText(Myadd);
                Edit_text.setSelection(Edit_text.getText().length());
                break;
            case R.id.clear:
                Edit_text.setText(null);
                textview.setText("0");
                break;
            case R.id.delete:
                String Mydelete = Edit_text.getText().toString();
                String lastword_delete = Mydelete.substring(Mydelete.length() - 1, Mydelete.length());
                if (lastword_delete.equals("(")) {
                    left_brackets--;
                } else if (lastword_delete.equals(")")) {
                    right_brackets--;
                }
                try {
                    Mydelete = Mydelete.substring(0, Edit_text.length() - 1);
                } catch (Exception E) {
                    Edit_text.setText("");
                }
                Edit_text.setText(Mydelete);
                Edit_text.setSelection(Edit_text.getText().length());
                break;
            case R.id.equal:
                trans();
                /*因为用户输入的中缀表达式不易被理解，所以需要进行两个步骤
                1.将用户输入的中缀表达式转换为后缀表达式
                2.将后缀表达式计算得出结果
                */
                compete();
            default:
                break;
        }
    }

    private void compete() {
        BigDecimal num1;
        BigDecimal num2;
        //这个方法进行计算中缀表达式
        while (!numStack.peek().equals('#')) {
            operaStack.push(numStack.pop());
        }//之前的中缀表达式在堆栈中是倒着的
        //现在operaStack中存放后缀表达式
        //numStack为空
        //两个堆栈有栈底分别有两个'#'作为标示
        String temp = "";
        String b = "";
        String c = "";
        double number;

        while (!(numStack.search('#') == 2) || !(operaStack.search('#') == 1)) {
//            Log.d("activity_main",String.valueOf(numStack.search('#')));
            //当numStack中只剩下一个数字，并且opera中没有留下数字，说明计算计算完毕，numStack中的那个数字就是计算结果
            temp = operaStack.pop().toString();
            switch (temp) {
                case "+":
                    b = numStack.pop().toString();
                    num1 = new BigDecimal(b);
                    c = numStack.pop().toString();
                    num2 = new BigDecimal(c);
                    num2 = num2.add(num1);
                    numStack.push(num2.toString());
                    break;
                case "-":
                    b = numStack.pop().toString();
                    num1 = new BigDecimal(b);
                    c = numStack.pop().toString();
                    num2 = new BigDecimal(c);
                    num2 = num2.subtract(num1);
                    numStack.push(num2.toString());
                    break;
                case "×":
                    b = numStack.pop().toString();
                    num1 = new BigDecimal(b);
                    c = numStack.pop().toString();
                    num2 = new BigDecimal(c);
                    num2 = num2.multiply(num1);
                    numStack.push(num2.toString());
                    break;
                case "/":
                    b = numStack.pop().toString();
                    num1 = new BigDecimal(b);
                    c = numStack.pop().toString();
                    num2 = new BigDecimal(c);
                    try {
                        num2 = num2.divide(num1);
                    } catch (Exception E) {
                        num2 = num2.divide(num1, 10, HALF_DOWN);
                    }
                    numStack.push(num2.toString());
                    break;
                default:
                    numStack.push(temp);
                    break;
            }
        }
        temp = numStack.pop().toString();
        textview.setText(temp);
    }

    private void trans() {
        //这里把中缀表达式转换成后缀表达式
        String Myequal = Edit_text.getText().toString();//获取用户输入的所有字符
        String num = new String();
        operaStack.push('#');//"#"作为表示栈顶的标识
        numStack.push('#');
        int i;
        for (i = 0; i < Myequal.length(); i++) {
            char temp = '0';
            temp = Myequal.charAt(i);//获取用户输入的每个字符
            Log.d("MainActivity", String.valueOf(temp));
            if (isDigit(temp)) {//判断temp是否是数字
                while ((isDigit(temp) || temp == '.') && i < Myequal.length()) {
                    num = num + temp;
                    i++;
                    if (!(i == Myequal.length())) {
                        temp = Myequal.charAt(i);
                    }
                }
                numStack.push(num);//把提取出的数字压栈
                num = "";
                i--;
            } else if ((i == 0 && (temp == '-' || temp == '+')) || (i >= 1 && (Myequal.charAt(i - 1) == '-' || Myequal.charAt(i - 1) == '+'))) {
                numStack.push('0');
            } else {
                switch (temp) {
                    case '+':
                    case '-':
                        if (operaStack.peek().equals('(') || operaStack.peek().equals("#")) {
                            operaStack.push(temp);//当栈顶是括号或者是没有运算符的时候，正常压栈
                        } else {
                            while (!(operaStack.peek().equals('(') || operaStack.peek().equals('#'))) {
                                numStack.push(operaStack.pop());//由于+的优先级不大于任何运算符号的优先级，所以将上一个运算符号出栈
                            }
                            operaStack.push(temp);//将符号压栈。
                        }
                        break;
                    case '×':
                    case '/':
                        while (operaStack.peek().equals('/') && operaStack.peek().equals('×')) {
                            //因为乘除运算为最高优先级运算符，碰到乘除在栈顶的情况就出栈栈顶一个元素，依次循环
                            numStack.push(operaStack.pop());
                        }
                        operaStack.push(temp);
                        break;
                    case '(':
                        operaStack.push(temp);
                        break;
                    case ')':
                        while (true) {
                            temp = (Character) operaStack.pop();
                            if (temp == '(') {
                                break;
                            }
                            numStack.push(temp);
                        }
                    default:
                        break;
                }
            }
        }
        while (!operaStack.peek().equals('#')) {
            numStack.push(operaStack.pop());
        }
    }

    public boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}
