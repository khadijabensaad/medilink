package essths.li3.medilink;

import essths.li3.medilink.SignInActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.Map;
import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextFullName;
    private EditText editTextPhoneNumber;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private EditText editTextPasswordConfirmation;
    private Button buttonSignUp;
    private Map<String, String> userDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);


        // Get references to UI elements
        editTextFullName = Objects.requireNonNull(findViewById(R.id.editTextFullName));
        editTextPhoneNumber = Objects.requireNonNull(findViewById(R.id.editTextPhoneNumber));
        editTextEmail = Objects.requireNonNull(findViewById(R.id.editTextEmailSignUp));
        editTextPassword = Objects.requireNonNull(findViewById(R.id.editTextPasswordSignUp));
        editTextPasswordConfirmation = Objects.requireNonNull(findViewById(R.id.editTextPasswordConfirmation));
        buttonSignUp = Objects.requireNonNull(findViewById(R.id.buttonSignUp));

        // Set click listener for the sign-up button
        buttonSignUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.buttonSignUp) {
            handleSignUp();
        }
    }

    private void handleSignUp() {
        String fullName = editTextFullName.getText().toString();
        String phoneNumber = editTextPhoneNumber.getText().toString();
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        String passwordConfirmation = editTextPasswordConfirmation.getText().toString();

        // Simple validation for password matching
        if (!password.equals(passwordConfirmation)) {
            showToast("Passwords do not match");
            return;
        }

        userDatabase = SignInActivity.getUserDatabase();
        if(userDatabase.containsKey(email)){
            showToast("Email already exists");
            return;
        }

        SignInActivity.addUserToDatabase(email, password);
        // Perform the sign-up logic here
        // You can add your own logic to store user information, such as in a database.

        showToast("Sign-up successful!");
        Intent i = new intent(SignInActivity.this,layoutElliba3dou.class);
        startActivity(i);
        // Optionally, you can navigate to the next screen or perform any other action after sign-up.
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }


}
