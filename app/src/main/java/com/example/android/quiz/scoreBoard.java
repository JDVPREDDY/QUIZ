package com.example.android.quiz;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class scoreBoard extends AppCompatActivity {
    public static String  USER_NAME ="user_name";
    public static String USER_MAILID = "user_mailId";
    public static String Q1_M ="q1_mark";
    public static String Q2_M ="q2_mark";
    public static String Q3_M ="q3_mark";
    public static String Q4_M ="q4_mark";
    public static String Q5_M ="q5_mark";
    public static String TOTAL ="total";
    public static String NOQ ="noq";
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
    //String no_message = "\nThanks for participating in this quiz. Good Luck!\n Exit application or Restart quiz or Attempt again!";

    @Override
    protected void onCreate(Bundle onSaveInstanceState) {
        super.onCreate(onSaveInstanceState);
        setContentView(R.layout.scoreboard);

        Intent intent = getIntent();
        Bundle user_score_packed = intent.getExtras();
        user_name = user_score_packed.getString(USER_NAME);
        user_mailId = user_score_packed.getString(USER_MAILID);
        q1_mark = user_score_packed.getInt(Q1_M);
        q2_mark = user_score_packed.getInt(Q2_M);
        q3_mark = user_score_packed.getInt(Q3_M);
        q4_mark = user_score_packed.getInt(Q4_M);
        q5_mark = user_score_packed.getInt(Q5_M);
        total = user_score_packed.getInt(TOTAL);
        q_num = user_score_packed.getInt(NOQ);

        TextView score_view = (TextView) findViewById(R.id.score_tv_id);
        score_details = getString(R.string.ysi)+ total;

        if (total == 0)
            grade = getString(R.string.poor);
        else if (total < 3)
            grade = getString(R.string.average);
        else if (total >= 3)
            grade = getString(R.string.good);


        score_details = score_details + getString(R.string.ypi) + grade;

        if (q1_mark == 1) {
            score_details = score_details + getString(R.string.newline)+getString(R.string.q1_sbc);
        } else {
            score_details = score_details + getString(R.string.newline)+getString(R.string.q1_sbw);
        }

        if (q2_mark == 1) {
            score_details = score_details + getString(R.string.newline)+getString(R.string.q2_sbc);
        } else {
            score_details = score_details + getString(R.string.newline)+getString(R.string.q2_sbw);
        }

        if (q3_mark == 1) {
            score_details = score_details + getString(R.string.newline)+getString(R.string.q3_sbc);
        } else {
            score_details = score_details + getString(R.string.newline)+getString(R.string.q3_sbw);
        }

        if (q4_mark == 1) {
            score_details = score_details + getString(R.string.newline)+getString(R.string.q4_sbc);
        } else {
            score_details = score_details + getString(R.string.newline)+getString(R.string.q4_sbw);
        }

        if (q5_mark == 1) {
            score_details = score_details + getString(R.string.newline)+getString(R.string.q5_sbc);
        } else {
            score_details = score_details + getString(R.string.newline)+getString(R.string.q5_sbw);
        }

        if (total == 0) {
            score_details = score_details + getString(R.string.newline)+getString(R.string.newline)+getString(R.string.rema);
        } else {
            score_details = score_details + getString(R.string.newline)+getString(R.string.newline)+getString(R.string.rema2);
        }

        score_view.setText(score_details);

    }

    public void mailMe(View view) {

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse(getString(R.string.mailto))); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{user_mailId});
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.Scorefor) + user_name +getString(R.string.inQuizApp));
        intent.putExtra(Intent.EXTRA_TEXT, score_details + getString(R.string.lastm));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    public void noButton(View view) {

        TextView mess = (TextView) findViewById(R.id.no_content);
        mess.setText(getString(R.string.lastm));
    }

    public void retake(View view) {

        Intent intent = new Intent(this, QuizActiviity.class);
        Bundle pack3 = new Bundle();
        pack3.putString(USER_NAME, user_name);
        pack3.putString(USER_MAILID, user_mailId);
        intent.putExtras(pack3);
        startActivity(intent);
        q1_mark = 0;
        q2_mark = 0;
        q3_mark = 0;
        q4_mark = 0;
        q5_mark = 0;
        total = 0;
        score_details = getString(R.string.blank);
        grade = getString(R.string.blank);

    }

    public void restart(View view) {
        q1_mark = 0;
        q2_mark = 0;
        q3_mark = 0;
        q4_mark = 0;
        q5_mark = 0;
        total = 0;
        score_details = getString(R.string.blank);
        grade = getString(R.string.blank);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
