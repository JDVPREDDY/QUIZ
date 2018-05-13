package com.example.android.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.quiz.R;

public class QuizActiviity extends AppCompatActivity {
    String user_name;
    String user_mailId;
    public static String  USER_NAME ="user_name";
    public static String USER_MAILID = "user_mailId";
    public static String  USER_NAME2 ="user_name";
    public static String USER_MAILID2 = "user_mailId";

    public static String Q1_M ="q1_mark";
    public static String Q2_M ="q2_mark";
    public static String Q3_M ="q3_mark";
    public static String Q4_M ="q4_mark";
    public static String Q5_M ="q5_mark";
    public static String TOTAL ="total";
    public static String NOQ ="noq";
    public static String PQ1 ="present_q1";
    public static String PQ2OP1 ="present_q2_op1";
    public static String PQ2OP2 ="present_q2_op2";
    public static String PQ2OP3 ="present_q2_op3";
    public static String PQ2OP4 ="present_q2_op4";
    public static String PQ3 ="present_q3";
    public static String PQ5 ="present_q5";
    public static String PQ4OP1 ="present_q4_op1";
    public static String PQ4OP2 ="present_q4_op2";
    public static String PQ4OP3 ="present_q4_op3";
    public static String PQ4OP4 ="present_q4_op4";


    @Override
    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.quiz_questions);

        Intent intent = getIntent();
        Bundle user_details_packed = intent.getExtras();
        user_name = user_details_packed.getString(USER_NAME);

        user_mailId = user_details_packed.getString(USER_MAILID);
        TextView welnote = (TextView) findViewById(R.id.welcome);
        welnote.setText(getString(R.string.Welcome) + user_name + getString(R.string.imp)+getString(R.string.wel2) + user_mailId + getString(R.string.atb));


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        EditText edit1 = findViewById(R.id.q1_ans);
        outState.putString(PQ1, edit1.getText().toString());

        CheckBox checkBox = findViewById(R.id.q2_p2);
        outState.putBoolean(PQ2OP1, checkBox.isChecked());
        checkBox = findViewById(R.id.q2_p3);
        outState.putBoolean(PQ2OP2, checkBox.isChecked());
        checkBox = findViewById(R.id.q2_p4);
        outState.putBoolean(PQ2OP3, checkBox.isChecked());
        checkBox = findViewById(R.id.q2_p5);
        outState.putBoolean(PQ2OP4, checkBox.isChecked());

        RadioGroup radio1 = findViewById(R.id.radio_q3);
        RadioButton radiob1 = radio1.findViewById(radio1.getCheckedRadioButtonId());
        outState.putInt(PQ3, radio1.indexOfChild(radiob1));

        CheckBox checkBox1 = findViewById(R.id.q4_p2);
        outState.putBoolean(PQ4OP1, checkBox1.isChecked());
        checkBox1 = findViewById(R.id.q4_p3);
        outState.putBoolean(PQ4OP2, checkBox1.isChecked());
        checkBox1 = findViewById(R.id.q4_p4);
        outState.putBoolean(PQ4OP3, checkBox1.isChecked());
        checkBox1 = findViewById(R.id.q4_p5);
        outState.putBoolean(PQ4OP4, checkBox1.isChecked());

        RadioGroup radio2 = findViewById(R.id.radio_q5);
        RadioButton radiob2 = radio2.findViewById(radio2.getCheckedRadioButtonId());
        outState.putInt(PQ5, radio2.indexOfChild(radiob2));
    }

    @Override
    protected void onRestoreInstanceState(Bundle inState){
        super.onRestoreInstanceState(inState);

        EditText editText = findViewById(R.id.q1_ans);
        editText.setText(inState.getString(PQ1));

        CheckBox checkBox = findViewById(R.id.q2_p2);
        checkBox.setChecked(inState.getBoolean(PQ2OP1));
        checkBox = findViewById(R.id.q2_p3);
        checkBox.setChecked(inState.getBoolean(PQ2OP2));
        checkBox = findViewById(R.id.q2_p4);
        checkBox.setChecked(inState.getBoolean(PQ2OP3));
        checkBox = findViewById(R.id.q2_p5);
        checkBox.setChecked(inState.getBoolean(PQ2OP4));

        if(inState.getInt(PQ3) != -1){
            RadioGroup radioGroup1 = findViewById(R.id.radio_q3);
            ((RadioButton) radioGroup1.getChildAt(inState.getInt(PQ3))).setChecked(true);
        }

        CheckBox checkBox1 = findViewById(R.id.q4_p2);
        checkBox1.setChecked(inState.getBoolean(PQ4OP1));
        checkBox1 = findViewById(R.id.q4_p3);
        checkBox1.setChecked(inState.getBoolean(PQ4OP2));
        checkBox1 = findViewById(R.id.q4_p4);
        checkBox1.setChecked(inState.getBoolean(PQ4OP3));
        checkBox1 = findViewById(R.id.q4_p5);
        checkBox1.setChecked(inState.getBoolean(PQ4OP4));

        if(inState.getInt(PQ5) != -1){
            RadioGroup radioGroup1 = findViewById(R.id.radio_q5);
            ((RadioButton) radioGroup1.getChildAt(inState.getInt(PQ5))).setChecked(true);
        }
    }

    int q1_mark = 0;
    int q2_mark = 0;
    int q3_mark = 0;
    int q4_mark = 0;
    int q5_mark = 0;
    int total = 0;
    int q_num =5;

    public void submitAns(View view){
        checkAns();



        Toast.makeText(this, getString(R.string.ysi) + total + getString(R.string.oof) + q_num +getString(R.string.marks),Toast.LENGTH_LONG).show();
    }

    public void viewSB (View view){
        checkAns();
        Intent intent = new Intent(QuizActiviity.this, scoreBoard.class);
        Bundle packs2 = new Bundle();
        packs2.putString(USER_NAME2, user_name);
        packs2.putString(USER_MAILID2,user_mailId);
        packs2.putInt(Q1_M, q1_mark);
        packs2.putInt(Q2_M, q2_mark);
        packs2.putInt(Q3_M, q3_mark);
        packs2.putInt(Q4_M, q4_mark);
        packs2.putInt(Q5_M, q5_mark);
        packs2.putInt(TOTAL,total);
        packs2.putInt(NOQ,q_num);
        intent.putExtras(packs2);
        startActivity(intent);
    }

    public void resetAns (View view){
        CheckBox checkBox;
        RadioGroup radioGroup;
        EditText editText;

        editText = findViewById(R.id.q1_ans);
        editText.setText("");

        checkBox = findViewById(R.id.q2_p2);
        checkBox.setChecked(false);
        checkBox = findViewById(R.id.q2_p3);
        checkBox.setChecked(false);
        checkBox = findViewById(R.id.q2_p4);
        checkBox.setChecked(false);
        checkBox = findViewById(R.id.q2_p5);
        checkBox.setChecked(false);

        radioGroup = findViewById(R.id.radio_q3);
        radioGroup.clearCheck();

        checkBox = findViewById(R.id.q4_p2);
        checkBox.setChecked(false);
        checkBox = findViewById(R.id.q4_p3);
        checkBox.setChecked(false);
        checkBox = findViewById(R.id.q4_p4);
        checkBox.setChecked(false);
        checkBox = findViewById(R.id.q4_p5);
        checkBox.setChecked(false);

        radioGroup = findViewById(R.id.radio_q5);
        radioGroup.clearCheck();

        q1_mark =0;
        q2_mark=0;
        q3_mark=0;
        q4_mark=0;
        q5_mark=0;
        total = 0;
    }


    public void checkAns(){
        EditText editText;
        RadioGroup radioGroup;
        CheckBox checkBox1;
        CheckBox checkBox2;
        CheckBox checkBox3;
        CheckBox checkBox4;



        editText = findViewById(R.id.q1_ans);
        if(String.valueOf(editText.getText()).toUpperCase().contentEquals("1947")){
            q1_mark = 1;
        } else {
            q1_mark = 0;
        }


        checkBox1 = findViewById(R.id.q2_p2);
        checkBox2 = findViewById(R.id.q2_p3);
        checkBox3 = findViewById(R.id.q2_p4);
        checkBox4 = findViewById(R.id.q2_p5);

        if(checkBox1.isChecked() && !checkBox2.isChecked() &&checkBox3.isChecked() && checkBox4.isChecked()){
            q2_mark = 1;
        }else {
            q2_mark = 0;
        }


        radioGroup = findViewById(R.id.radio_q3);
        if (radioGroup.getCheckedRadioButtonId() == R.id.q3_op1) {
            q3_mark = 1;
        }else {
            q3_mark = 0;
        }

        checkBox1 = findViewById(R.id.q4_p2);
        checkBox2 = findViewById(R.id.q4_p3);
        checkBox3 = findViewById(R.id.q4_p4);
        checkBox4 = findViewById(R.id.q4_p5);

        if(checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && !checkBox4.isChecked()){
            q4_mark = 1;
        }else {
            q4_mark = 0;
        }

        radioGroup = findViewById(R.id.radio_q5);
        if (radioGroup.getCheckedRadioButtonId() == R.id.q5_op4) {
            q5_mark = 1;
        }else {
            q5_mark = 0;
        }
        total = q1_mark + q2_mark + q3_mark + q4_mark + q5_mark;

    }

}