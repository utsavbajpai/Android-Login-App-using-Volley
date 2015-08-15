package com.mycompany.samplelogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

/**
 * Created by Utsav on 7/26/2015.
 */
public class signin extends Activity {

    DataBaseHandler dataBaseHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);
        Button b = (Button)findViewById(R.id.login_b);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SignIn(v);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void setActionBar(Toolbar toolbar) {
        super.setActionBar(toolbar);
    }

    public void SignIn(View view)
    {
        Intent intent = new Intent(this,homescreen.class);

        dataBaseHandler=new DataBaseHandler(this);
        dataBaseHandler=dataBaseHandler.open();
        EditText edituser = (EditText)findViewById(R.id.user_name);
        String user = edituser.getText().toString();

        EditText editpw = (EditText)findViewById(R.id.pass_word);
        String pw = editpw.getText().toString();

        String password = dataBaseHandler.getPassword(user);

        if(pw.equals(password)) {
            Toast.makeText(this, "Login successfull", Toast.LENGTH_LONG).show();
            startActivity(intent);
        }
        else
            Toast.makeText(this, "User and Pass do not match", Toast.LENGTH_LONG).show();








    }
}
