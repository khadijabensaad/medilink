package essths.li3.medilink;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class SignInActivity extends AppCompatActivity {

    // In a real app, you would use a database or a secure method for user authentication.
    public static Map<String, String> userDatabase;

     EditText editTextEmail;
     EditText editTextPassword;
     Button buttonLogin;
    private Button buttonSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_in);

        // Initialize user database
        userDatabase = new HashMap<>();
        userDatabase.put("khadija@gmail.com", "12345678");
        userDatabase.put("abdou@gmail.com", "123456789");
        userDatabase.put("nethyr@gmail.com", "11223344");
        userDatabase.put("aya@gmail.com", "1244578");



        // Get references to UI elements
        editTextEmail =(EditText) findViewById(R.id.editTextEmail);
        editTextPassword =(EditText) findViewById(R.id.editTextPassword);
        buttonLogin =(Button) findViewById(R.id.buttonLogin);
        buttonSignup =(Button) findViewById(R.id.buttonSignup);

        // Set click listeners for buttons
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    handleLogin();
            }
        });
        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(i);

            }
        });
        }

    public static Map<String, String> getUserDatabase() {
        return userDatabase;
    }

    public static void addUserToDatabase(String email, String password) {
        // Add a new user to the database
        userDatabase.put(email, password);
    }


    private void handleLogin() {
        String email = editTextEmail.getText().toString();
        String password =editTextPassword.getText().toString();

        if (userDatabase.containsKey(email) && userDatabase.get(email).equals(password)) {
            // Successful login
            showToast("Login successful!");
        } else {
            // Invalid credentials
            showToast("Invalid email or password");
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}
