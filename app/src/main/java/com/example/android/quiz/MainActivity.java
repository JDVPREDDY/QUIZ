package com.example.android.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
public static String  USER_NAME ="user_name";
public static String USER_MAILID = "user_mailId";
public static String USER_NAMEP = "user_name_present";
    public static String USER_MAILIDP = "user_mailId_present";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void startQuiz(View view){

        EditText editText = (EditText) findViewById(R.id.user_name);
        String message = editText.getText().toString();
        EditText editText1 = (EditText) findViewById(R.id.user_mailId);
        String mail = editText1.getText().toString();
        boolean checking = isValidEmail(mail);
        if (message != null && !message.isEmpty()) {
            if (mail != null && !mail.isEmpty() && checking) {

                Intent intent = new Intent(MainActivity.this, QuizActiviity.class);

                Bundle packs = new Bundle();
                packs.putString(USER_NAME, message);
                packs.putString(USER_MAILID, mail);
                intent.putExtras(packs);
                startActivity(intent);
            }else {
                Toast.makeText(this,getString(R.string.user_mailId_toast), Toast.LENGTH_SHORT).show();
                return;
            }
        } else {
            Toast.makeText(this, getString(R.string.user_name_toast), Toast.LENGTH_SHORT).show();
            return;
        }
        }


    @Override
protected void onSaveInstanceState(Bundle outState) {

    super.onSaveInstanceState(outState);

    EditText editText = findViewById(R.id.user_name);
    outState.putString(USER_MAILIDP, editText.getText().toString());

    EditText editText1 = findViewById(R.id.user_mailId);
    outState.putString(USER_MAILIDP,editText.getText().toString());
}
    @Override
    protected void onRestoreInstanceState(Bundle inState){
        super.onRestoreInstanceState(inState);
        EditText editText = findViewById(R.id.user_name);
        editText.setText(inState.getString(USER_NAMEP));
        EditText editText1 = findViewById(R.id.user_mailId);
        editText1.setText(inState.getString(USER_MAILIDP));
    }

    public static boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
}
