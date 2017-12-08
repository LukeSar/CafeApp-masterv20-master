package com.example.lukesartori.myapp;
//import adds libraries of pre made code for commonly used functions
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;




//Sets up class for sign up screen and adds on click listener to call functions
public class SignUpActivity extends AppCompatActivity implements View.OnClickListener { //initialises sign up screen also uses app compat activity as a sub class from fragment activity with many useful API'S for supporting UI development


    //These statements initiate the values to be used on this screen, some are private to avoid them operating outside the appropriate screen

    TextView LoginView;
    EditText PasswordText, EmailText, PasswordConfirm;
    ImageButton FurtherInfoButton;
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private FirebaseAuth mAuth; //Initiates use of Firebase for authentication purposes

    //Initiates void for when the screen has been loaded so that functions can be loaded and content layout can be set

    @Override   //allows the compiler to override previously set parent functions
    protected void onCreate(Bundle savedInstanceState) {    //used for starting the activity to start up all the components on the screen by using previously saved
        super.onCreate(savedInstanceState); //runs code that is created in the parent class by acting as a calling method within the activity
        setContentView(R.layout.activity_signup);    //pairs the UI with the XML used to create it so it can show the user what has been created

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);   //Statement prevents keyboard from appearing when screen is loaded
        mAuth = FirebaseAuth.getInstance(); //Calls Firebase authentication from sign up class

        //These statements all help the program locate the location of these fields and initialise then for use within the on create void.
        PasswordConfirm = (EditText) findViewById(R.id.PasswordConfirm);
        LoginView = (TextView) findViewById(R.id.LoginView);
        PasswordText = (EditText) findViewById(R.id.PasswordText);
        EmailText = (EditText) findViewById(R.id.EmailText);
        findViewById(R.id.SubmitButton).setOnClickListener(this); //Later used for an on click void to call the register user function.


        /*
        This block of code locates the image for the further information popup and then sets a void for when it is clicked to call the pop up from an external layout resource called email pop.
        The sizes are then set up and its location is set to the top of the screen.
        Lastly a boolean touch listener is set so the when the screen is touched the popup is dismissed
         */
        FurtherInfoButton = (ImageButton) findViewById(R.id.FurtherInfoButton);
        FurtherInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.email_pop, null);

                popupWindow = new PopupWindow(container, 950, 350, true);
                popupWindow.showAtLocation(FurtherInfoButton, Gravity.TOP, 0, 0);

                container.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        popupWindow.dismiss();
                        return true;
                    }
                });
            }
        });


        //This block of code sets an on click listener for the login button which switches the stakeholder to the login screen by starting a new activity

        LoginView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(SignUpActivity.this, MainActivity.class));
            }
        });


    }



    private void registerUser() {   //This void holds the register user function which is responsible for enabling and validating the sign up

        //These statements set the sign up information into strings so that they can be entered into the database and checked through the code for validation purposes
        String PasswordConfirmation = PasswordConfirm.getText().toString().trim();
        String Email = EmailText.getText().toString().trim();
        String Password = PasswordText.getText().toString().trim();

        /*
        The if statements below are used to validate the 3 string fields, checks made include: empty checks, length checks,
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

        if (!PasswordConfirmation.equals(Password)){
            PasswordConfirm.setError("Passwords need to match");
            PasswordConfirm.requestFocus();
            return;
        }

        /*
        This block of code is the last step of validation calls the create user function built into Firebase to send the email and password
        string to the database using an on complete listener. If the data is sent the Stakeholder is notified via a toast message and they are also notified if it fails.
        One last notification is if the data collides with another set of data which is already in the database, so the stakeholder is notified
        that an account with these credentials has already been created.
        */
        mAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {//Uses firebase authentication service to send the email and password to the database
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this, MenuScreen.class));
                } else {
                    if(task.getException()instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(), "Already Registered", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    /*
    This void activates when the submit button is clicked and this void calls the register user function
    to start which is responsible for signing up a stakeholder, this is completed using a case statement
    to select it and the using 'break' at the end to close the void operations.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.SubmitButton:
                registerUser();
                break;
        }
    }
}







