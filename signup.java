package com.mycompany.samplelogin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

/**
 * Created by Utsav on 7/26/2015.
 */
public class signup extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singup);
        Button b = (Button)findViewById(R.id.singup_b);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignUp(v);
            }
        });
    }


    public void SignUp(View v)
    {
        DataBaseHandler dataBaseHandler = new DataBaseHandler(this);
        dataBaseHandler=dataBaseHandler.open();
        EditText usereditText = (EditText)findViewById(R.id.su_user);
        String signUpuser = usereditText.getText().toString();

        EditText pweditText = (EditText)findViewById(R.id.su_pw);
        String signUppassword = pweditText.getText().toString();

        EditText confirmPweditText = (EditText)findViewById(R.id.conf_pw);
        String confirmPassword = confirmPweditText.getText().toString();


        if(signUppassword.equals(confirmPassword)) {
            dataBaseHandler.insertEntry(signUpuser, signUppassword);
            Toast.makeText(this, "Succesfull added ma friend", Toast.LENGTH_LONG).show();
        }
        else
            Toast.makeText(this, "Password dont match ma friend", Toast.LENGTH_LONG).show();




    }


}
