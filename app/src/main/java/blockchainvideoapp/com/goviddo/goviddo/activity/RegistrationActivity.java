package blockchainvideoapp.com.goviddo.goviddo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.service.autofill.RegexValidator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import blockchainvideoapp.com.goviddo.goviddo.R;
import blockchainvideoapp.com.goviddo.goviddo.coreclass.LoginUserDetails;

public class RegistrationActivity extends AppCompatActivity {

    android.support.design.widget.TextInputLayout mTextInputLayoutUserName,mTextInputLayoutUserPassword, mTextInputLayoutUserConfirmPassword,mTextInputLayoutUseFirstName,mTextInputLayoutUserLastName,mTextInputLayoutUserWalletName;
    android.support.design.widget.TextInputEditText mEdtUserName,mEdtUserPassword, mEdtUserConfirmPassword,mEdtUserFirstName,mEdtUserLastName,mEdtUserWalletName;
    Button mBtnSignup;
    String mUserName, mPassword, mConfirmPassword,mUserFirstName,mUserLastName,mUserWalletName;
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
        mTextInputLayoutUseFirstName = findViewById(R.id.textInputLayoutUserFirstName);
        mTextInputLayoutUserLastName = findViewById(R.id.textInputLayoutUserLastName);
        mTextInputLayoutUserWalletName = findViewById(R.id.textInputLayoutUserWalletName);

        mEdtUserName = findViewById(R.id.edtUserNameRegistration);
        mEdtUserPassword = findViewById(R.id.edtUserPasswordRegistration);
        mEdtUserConfirmPassword = findViewById(R.id.edtUserReenterPasswordRegistration);
        mEdtUserFirstName = findViewById(R.id.edtUserFirstName);
        mEdtUserLastName = findViewById(R.id.edtUserLastName);
        mEdtUserWalletName = findViewById(R.id.edtUserWalletName);




        mBtnSignup = findViewById(R.id.btnSignUp);

        mBtnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mUserName = mEdtUserName.getText().toString();
                mPassword = mEdtUserPassword.getText().toString();
                mConfirmPassword = mEdtUserConfirmPassword.getText().toString();
                mUserFirstName = mEdtUserFirstName.getText().toString();
                mUserLastName = mEdtUserLastName.getText().toString();
                mUserWalletName = mEdtUserWalletName.getText().toString();


                submitForm(mUserFirstName,mUserLastName,mUserWalletName,mUserName,mPassword, mConfirmPassword);
                }
        });
        }


    private boolean checkFirstName(String userName) {

        userName = userName.trim();

        if(userName.trim().isEmpty() || (userName.length() <= 3)){
            mTextInputLayoutUseFirstName.setErrorEnabled( true );
            mTextInputLayoutUseFirstName.setError( "Please Enter Valid First Name" );
            return false;
        }
        mTextInputLayoutUseFirstName.setErrorEnabled( false );
        return true;
    }


    private boolean checkLastName(String userName) {

        userName = userName.trim();

        if(userName.trim().isEmpty() || (userName.length() <= 3)){
            mTextInputLayoutUserLastName.setErrorEnabled( true );
            mTextInputLayoutUserLastName.setError( "Please Enter Valid Last Name" );
            return false;
        }
        mTextInputLayoutUserLastName.setErrorEnabled( false );
        return true;
    }


    private boolean checkWalletName(String userName) {

        userName = userName.trim();

        if(userName.trim().isEmpty() || !isValidWalletName(userName)){
            mTextInputLayoutUserWalletName.setErrorEnabled( true );
            mTextInputLayoutUserWalletName.setError( "Please Enter Valid Wallet Name" );
            return false;
        }
        mTextInputLayoutUserWalletName.setErrorEnabled( false );
        return true;
    }

    private boolean isValidWalletName(String userName) {

        String pattern = "(?=.*[0-9])(?=.*[a-z]).{12,12}";
        String pattern1 = "(?=.*[a-z]).{12,12}";

        if(userName.matches( pattern ) || userName.matches( pattern1 ))
        {
            return true;
        }
        else{
            return false;
        }

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

    private boolean chkPass(String pass)
    {
        String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}";

       return pass.matches(pattern);

    }

    private boolean checkPassword(String password) {
        if (password.trim().isEmpty() || (password.length() < 7) ){
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


    public void submitForm(String firstname,String lastname,String walletName,String userName, String password, String confirmPassword)
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
        else if (!checkFirstName(firstname)){
            mVibrator.vibrate(1000);
            return;

        }
        else if (!checkLastName(lastname)){
            mVibrator.vibrate(1000);
            return;

        }
        else if (!checkWalletName(walletName)){
            mVibrator.vibrate(1000);
            return;

        }
        else {
            mTextInputLayoutUserName.setErrorEnabled(false);
            mTextInputLayoutUserPassword.setErrorEnabled(false);
            mTextInputLayoutUserConfirmPassword.setErrorEnabled(false);
            mTextInputLayoutUseFirstName.setErrorEnabled(false);
            mTextInputLayoutUserLastName.setErrorEnabled(false);
            mTextInputLayoutUserWalletName.setErrorEnabled(false);

            JSONObject params = new JSONObject();
            try {

                params.put("action", "Add_Employee");
                params.put("email",userName);
                params.put("password", password);
                params.put("firstName",firstname);
                params.put("lastName", lastname);
                params.put("walletName", walletName);


            } catch (JSONException e) {
                e.printStackTrace();

            }




            RequestQueue requestQueue = Volley.newRequestQueue(RegistrationActivity.this);

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, "http://178.128.173.51:3000/register\n"                    , new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {

                    Toast.makeText(RegistrationActivity.this, response.toString(), Toast.LENGTH_SHORT).show();

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(RegistrationActivity.this, error.getMessage().toString(), Toast.LENGTH_SHORT).show();

                }
            })
            {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("Content-Type", "application/json");
                    return headers;
                }
            };

            requestQueue.add(jsonObjectRequest);


              // mLoginUserDetails.setEmail(userName);
              // mLoginUserDetails.setPassword(password);




           /* Toast.makeText(RegistrationActivity.this, "Registration Successfull Please Verify Email", Toast.LENGTH_LONG).show();
            Intent loginIntent = new Intent(RegistrationActivity.this,HomeActivity.class);
            loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(loginIntent);
            finish();*/
        }


    }


}
