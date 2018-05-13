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


    @Override
    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.quiz_questions);

        Intent intent = getIntent();
        Bundle user_details_packed = intent.getExtras();
        user_name = user_details_packed.getString("user_name");

        user_mailId = user_details_packed.getString("user_mailId");
        TextView welnote = (TextView) findViewById(R.id.welcome);
        welnote.setText("welcome " + user_name + "\n your mail Id is " + user_mailId);


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        EditText edit1 = findViewById(R.id.q1_ans);
        outState.putString("present_q1", edit1.getText().toString());

        CheckBox checkBox = findViewById(R.id.q2_p2);
        outState.putBoolean("present_q2_op1", checkBox.isChecked());
        checkBox = findViewById(R.id.q2_p3);
        outState.putBoolean("present_q2_op2", checkBox.isChecked());
        checkBox = findViewById(R.id.q2_p4);
        outState.putBoolean("present_q2_op3", checkBox.isChecked());
        checkBox = findViewById(R.id.q2_p5);
        outState.putBoolean("present_q2_op4", checkBox.isChecked());

        RadioGroup radio1 = findViewById(R.id.radio_q3);
        RadioButton radiob1 = radio1.findViewById(radio1.getCheckedRadioButtonId());
        outState.putInt("present_q3", radio1.indexOfChild(radiob1));

        CheckBox checkBox1 = findViewById(R.id.q4_p2);
        outState.putBoolean("present_q4_op1", checkBox1.isChecked());
        checkBox1 = findViewById(R.id.q4_p3);
        outState.putBoolean("present_q4_op2", checkBox1.isChecked());
        checkBox1 = findViewById(R.id.q4_p4);
        outState.putBoolean("present_q4_op3", checkBox1.isChecked());
        checkBox1 = findViewById(R.id.q4_p5);
        outState.putBoolean("present_q4_op4", checkBox1.isChecked());

        RadioGroup radio2 = findViewById(R.id.radio_q5);
        RadioButton radiob2 = radio2.findViewById(radio2.getCheckedRadioButtonId());
        outState.putInt("present_q5", radio2.indexOfChild(radiob2));
    }

    @Override
    protected void onRestoreInstanceState(Bundle inState){
        super.onRestoreInstanceState(inState);

        EditText editText = findViewById(R.id.q1_ans);
        editText.setText(inState.getString("present_q1"));

        CheckBox checkBox = findViewById(R.id.q2_p2);
        checkBox.setChecked(inState.getBoolean("present_q2_op1"));
        checkBox = findViewById(R.id.q2_p3);
        checkBox.setChecked(inState.getBoolean("present_q2_op2"));
        checkBox = findViewById(R.id.q2_p4);
        checkBox.setChecked(inState.getBoolean("present_q2_op3"));
        checkBox = findViewById(R.id.q2_p5);
        checkBox.setChecked(inState.getBoolean("present_q2_op4"));

        if(inState.getInt("present_q3") != -1){
            RadioGroup radioGroup1 = findViewById(R.id.radio_q3);
            ((RadioButton) radioGroup1.getChildAt(inState.getInt("present_q3"))).setChecked(true);
        }

        CheckBox checkBox1 = findViewById(R.id.q4_p2);
        checkBox1.setChecked(inState.getBoolean("present_q4_op1"));
        checkBox1 = findViewById(R.id.q4_p3);
        checkBox1.setChecked(inState.getBoolean("present_q4_op2"));
        checkBox1 = findViewById(R.id.q4_p4);
        checkBox1.setChecked(inState.getBoolean("present_q4_op3"));
        checkBox1 = findViewById(R.id.q4_p5);
        checkBox1.setChecked(inState.getBoolean("present_q4_op4"));

        if(inState.getInt("present_q5") != -1){
            RadioGroup radioGroup1 = findViewById(R.id.radio_q5);
            ((RadioButton) radioGroup1.getChildAt(inState.getInt("present_q5"))).setChecked(true);
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

        total = q1_mark + q2_mark + q3_mark + q4_mark + q5_mark;

        Toast.makeText(this, "Your Score is " + total + "out of " + q_num +" marks",Toast.LENGTH_LONG).show();
    }

    public void viewSB (View view){
        checkAns();
        Intent intent = new Intent(this, scoreBoard.class);
        Bundle packs2 = new Bundle();
        packs2.putString("user_name", user_name);
        packs2.putString("user_mailid",user_mailId);
        packs2.putInt("q1_mark", q1_mark);
        packs2.putInt("q2_mark", q2_mark);
        packs2.putInt("q3_mark", q3_mark);
        packs2.putInt("q4_mark", q4_mark);
        packs2.putInt("q5_mark", q5_mark);
        packs2.putInt("total",total);
        packs2.putInt("noq",q_num);
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

    }

}