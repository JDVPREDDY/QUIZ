package com.example.android.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class scoreBoard extends AppCompatActivity {

    String user_name;
    String user_mailId;
    int q1_mark;
    int q2_mark;
    int q3_mark;
    int q4_mark;
    int q5_mark;
    int total;
    int q_num;
    String grade;
    String score_details;

    @Override
    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.scoreboard);

        Intent intent = getIntent();
        Bundle user_score_packed = intent.getExtras();
        user_name = user_score_packed.getString("user_name");
        user_mailId = user_score_packed.getString("user_mailId");
        q1_mark = user_score_packed.getInt("q1_mark");
        q2_mark = user_score_packed.getInt("q2_mark");
        q3_mark = user_score_packed.getInt("q3_mark");
        q4_mark = user_score_packed.getInt("q4_mark");
        q5_mark = user_score_packed.getInt("q5_mark");
        total = user_score_packed.getInt("total");
        q_num = user_score_packed.getInt("noq");

        TextView score_view = (TextView) findViewById(R.id.score_tv_id);
        score_details = "your score is " + total;
        if (total >=3)
            grade="good";
                    else if (total < 3)
                        grade="average";
                                else if (total==0)
                                    grade = "poor";

        score_details = score_details + "\n your performance is " + grade;

        if(q1_mark==1){
            score_details=score_details+"\nyour question-1 is correct";
        }else{
            score_details=score_details+"\nyour question-1 is wrong";
        }

        if(q2_mark==1){
            score_details=score_details+"\nyour question-2 is correct";
        }else{
            score_details=score_details+"\nyour question-2 is wrong";
        }

        if(q3_mark==1){
            score_details=score_details+"\nyour question-3 is correct";
        }else{
            score_details=score_details+"\nyour question-3 is wrong";
        }

        if(q4_mark==1){
            score_details=score_details+"\nyour question-4 is correct";
        }else{
            score_details=score_details+"\nyour question-4 is wrong";
        }

        if(q5_mark==1){
            score_details=score_details+"\nyour question-5 is correct";
        }else{
            score_details=score_details+"\nyour question-5 is wrong";
        }

        if(total==0){
            score_details=score_details+"\nread well, know what is happening around you";
        }else{
            score_details=score_details+"\ngood, keep going";
        }

score_view.setText(score_details);

    }
public void mailMe (View view){
        
}



}
