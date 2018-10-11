package blockchainvideoapp.com.goviddo.goviddo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import blockchainvideoapp.com.goviddo.goviddo.R;
import blockchainvideoapp.com.goviddo.goviddo.coreclass.LoginUserDetails;

public class RegistrationActivity extends AppCompatActivity {

    android.support.design.widget.TextInputLayout mTextInputLayoutUserName,mTextInputLayoutUserPassword, mTextInputLayoutUserConfirmPassword;
    android.support.design.widget.TextInputEditText mEdtUserName,mEdtUserPassword, mEdtUserConfirmPassword;
    Button mBtnSignup;
    String mUserName, mPassword, mConfirmPassword;
    Vibrator mVibrator;
    LoginUserDetails mLoginUserDetails;

    TextView mTextViewNewUserRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        mLoginUserDetails = new LoginUserDetails(this);

        mVibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


        if (mLoginUserDetails.getEmail() != "")
        {
            Intent loginIntent = new Intent(RegistrationActivity.this,HomeActivity.class);
            loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(loginIntent);
            finish();
        }



        mTextInputLayoutUserName = findViewById(R.id.textInputLayoutUserNameRegistration);
        mTextInputLayoutUserPassword = findViewById(R.id.textInputLayoutUserPasswordRegistration);
        mTextInputLayoutUserConfirmPassword = findViewById(R.id.textInputLayoutUserReenterPasswordRegistration);



        mEdtUserName = findViewById(R.id.edtUserNameRegistration);
        mEdtUserPassword = findViewById(R.id.edtUserPasswordRegistration);
        mEdtUserConfirmPassword = findViewById(R.id.edtUserReenterPasswordRegistration);


        mBtnSignup = findViewById(R.id.btnSignUp);



        mBtnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mUserName = mEdtUserName.getText().toString();
                mPassword = mEdtUserPassword.getText().toString();
                mConfirmPassword = mEdtUserConfirmPassword.getText().toString();

                submitForm(mUserName,mPassword, mConfirmPassword);



            }
        });



    }





    private boolean checkUserName(String userName) {

        userName = userName.trim();

        if (userName.trim().isEmpty() || !isValidEmail(userName)){
            mTextInputLayoutUserName.setErrorEnabled(true);
            mTextInputLayoutUserName.setError("Please Enter Valid Email ID");
            return false;
        }
        mTextInputLayoutUserName.setErrorEnabled(false);
        return true;
    }

    private boolean isValidEmail(String email){
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }


    private boolean checkPassword(String password) {
        if (password.trim().isEmpty() || (password.length() < 7)){
            mTextInputLayoutUserPassword.setErrorEnabled(true);
            mTextInputLayoutUserPassword.setError("Please enter password length greater than 6");
            return false;
        }
        mTextInputLayoutUserPassword.setErrorEnabled(false);
        return true;

    }



    private boolean checkConfirmPassword(String confirmPassword, String password) {
        if (confirmPassword.trim().isEmpty() || (confirmPassword.length() < 7) ){
            mTextInputLayoutUserConfirmPassword.setErrorEnabled(true);
            mTextInputLayoutUserConfirmPassword.setError("Please re-enter password length greater than 6");
            return false;
        }
        else {

            if(!confirmPassword.equals(password))
            {
                mTextInputLayoutUserConfirmPassword.setErrorEnabled(true);
                mTextInputLayoutUserConfirmPassword.setError("Password does not matched please enter again");
                return false;
            }
            else {
                mTextInputLayoutUserConfirmPassword.setErrorEnabled(false);
                return true;
            }
        }

    }










    public void submitForm(String userName, String password, String confirmPassword)
    {

        if (!checkUserName(userName)){
            mVibrator.vibrate(1000);
            return;
        }
        else if (!checkPassword(password)){
            mVibrator.vibrate(1000);
            return;

        }
        else if (!checkConfirmPassword(confirmPassword, password)){
            mVibrator.vibrate(1000);
            return;

        }
        else {
            mTextInputLayoutUserName.setErrorEnabled(false);
            mTextInputLayoutUserPassword.setErrorEnabled(false);

               mLoginUserDetails.setEmail(userName);
               mLoginUserDetails.setPassword(password);

            Toast.makeText(RegistrationActivity.this, "Registration Successfull Please Verify Email", Toast.LENGTH_LONG).show();
            Intent loginIntent = new Intent(RegistrationActivity.this,HomeActivity.class);
            loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(loginIntent);
            finish();
        }


    }







}
