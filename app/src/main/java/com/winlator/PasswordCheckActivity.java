public class PasswordCheckActivity {
    
}
package com.winlator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PasswordCheckActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences prefs = getSharedPreferences("AppPrefs", Context.MODE_PRIVATE);
        String savedPassword = prefs.getString("password", "");

        if (savedPassword.isEmpty()) {
            // لا توجد كلمة سر → انتقل مباشرة إلى MainActivity
            startActivity(new Intent(this, MainActivity.class));
            finish();
            return;
        }

        setContentView(R.layout.activity_password_check);

        EditText passwordInput = findViewById(R.id.passwordInput);
        Button submitPassword = findViewById(R.id.submitPassword);

        submitPassword.setOnClickListener(v -> {
            String enteredPassword = passwordInput.getText().toString().trim();
            if (enteredPassword.equals(savedPassword)) {
                startActivity(new Intent(this, MainActivity.class));
                finish();
            } else {
                Toast.makeText(this, "كلمة السر غير صحيحة", Toast.LENGTH_SHORT).show();
            }
        });
    }
}