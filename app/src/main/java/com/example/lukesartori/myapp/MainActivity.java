package com.example.lukesartori.myapp;
//import adds libraries of pre made code for commonly used functions
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{   //initialises main screen also uses app compat activity as a sub class from fragment activity with many useful API'S for supporting UI development

    //These statements initiate the values to be used on this screen.
    TextView CreateAccountView;
    EditText EmailText, PasswordText;
    Button HelpButton;
    FirebaseAuth mAuth;

    //Initiates void for when the screen has been loaded so that functions can be loaded and content layout can be set

    @Override    //allows the compiler to override previously set parent functions
    protected void onCreate(Bundle savedInstanceState) {  //used for starting the activity to start up all the components on the screen by using previously saved data
        super.onCreate(savedInstanceState); //runs code that is created in the parent class by acting as a calling method within the activity
        setContentView(R.layout.activity_main); //pairs the UI with the XML used to create it so it can show the user what has been created

        mAuth = FirebaseAuth.getInstance(); //Calls Firebase authentication from sign up class

        //These statements all help the program locate the location of these fields and initialise then for use within the on create void.
        EmailText = (EditText) findViewById(R.id.EmailText);
        PasswordText = (EditText) findViewById(R.id.PasswordText);
        findViewById(R.id.LoginButton).setOnClickListener(this);


        //This block of code sets an on click listener to the help button to start a new activity loading the help screen which presents FAQ'S to the stakeholder
        HelpButton = (Button) findViewById(R.id.HelpButton);
        HelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, HelpActivity.class));
            }
        });


        //This block of code sets an on click listener to the create account view to load the sign up activity when it is clicked, useful for first time users
        CreateAccountView = (TextView) findViewById(R.id.CreateAccountView);
        CreateAccountView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            }
        });
    }






    private void loginUser(){    //This void holds the login user function which is responsible for enabling and validating the login

       //These statements set the login information into strings so that they can be checked against the database and go through validations set by the code
       String Email = EmailText.getText().toString().trim();
       String Password = PasswordText.getText().toString().trim();

        /*
        The if statements below are used to validate the 2 string fields, checks made include: empty checks, length checks,
        equals checks to make sure values match between fields and lastly pattern checks are used to use pre made code to check
        that the email is valid.
         */

       if (Email.isEmpty()) {
           EmailText.setError("Email is Required");
           EmailText.requestFocus();
           return;

       }

       if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()) {
           EmailText.setError("Please enter valid email");
           EmailText.requestFocus();
           return;
       }

       if (Password.isEmpty()) {
           PasswordText.setError("Password is Required");
           PasswordText.requestFocus();
           return;

       }

       if (Password.length() < 6) {
           PasswordText.setError("Need 6 letters");
           PasswordText.requestFocus();
           return;
       }

        /*
        This block of code is the last step of validation calls the sign in user function built into Firebase to check the email and password
        string to the database using an on complete listener. If the data is matched the Stakeholder is notified via a toast message and they
        are also notified if it fails.
        */

        mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this, "Redirecting...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent (MainActivity.this, MenuScreen.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //Removes all previously opened activities and sets the new one as the first so that all functions just performed are set and saved correctly.
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(), "Unsuccessful",Toast.LENGTH_LONG).show();
                }
            }
        });
   }

   /*
    This void activates when the Login button or create account view is clicked.
    The login button calls the login user function and the create account view starts
    a new activity bringing the stakeholder to the sign up screen.
    These are performed using cases to allow multiple choices.
   */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.CreateAccountView:
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
                break;

            case R.id.LoginButton:
                loginUser();
                break;
        }
    }
}
























