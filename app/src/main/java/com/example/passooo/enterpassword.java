package com.example.passooo;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.Executor;


public class enterpassword extends AppCompatActivity {

    EditText editTextPassword;
    Button button;
    boolean isFingerSet = false;

    String password;
    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterpassword);

        SharedPreferences fingersetting = getSharedPreferences("FINGER", 0);
        isFingerSet = fingersetting.getBoolean("finger", false);

        Toast.makeText(enterpassword.this, "Finger: " + isFingerSet, Toast.LENGTH_SHORT).show();

       if (isFingerSet == true)
       {
           checkBioMetricSupported();


        Executor executor = ContextCompat.getMainExecutor(this);

        BiometricPrompt biometricPromt = new BiometricPrompt(enterpassword.this,
                executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
                Toast.makeText(enterpassword.this, "Authentication Error: " + errString, Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(enterpassword.this, "Authentication Succeeded!", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
                Toast.makeText(enterpassword.this, "Authentication Failed!", Toast.LENGTH_SHORT).show();
            }
        });

        Intent enrollIntent = new Intent(Settings.ACTION_BIOMETRIC_ENROLL);
        enrollIntent.putExtra(Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED,
                BiometricManager.Authenticators.BIOMETRIC_STRONG | BiometricManager.Authenticators.BIOMETRIC_WEAK);
            startActivity(enrollIntent);
        BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Biometric Authentication")
                .setSubtitle("Login using fingerprint authentication")
                .setNegativeButtonText("Cancel")
                .build();
        biometricPromt.authenticate(promptInfo);
       }

        SharedPreferences setting = getSharedPreferences("PREFS", 0);
        password = setting.getString("password", "");

        editTextPassword = (EditText) findViewById(R.id.editTextTextPassword);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editTextPassword.getText().toString();
                if(text.equals(password))
                {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(enterpassword.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void checkBioMetricSupported() {
        String info = "";
        BiometricManager manager = BiometricManager.from(this);
        switch (manager.canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_WEAK |
                BiometricManager.Authenticators.BIOMETRIC_STRONG))
        {
            case BiometricManager.BIOMETRIC_SUCCESS:
                info = "App can authenticate using biometrics.";

              break;
                case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                    info = "No biometric features available on this device.";
                    break;
                    case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                        info = "Biometric features are currently unavailable.";
                        break;
                        case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                            info = "The user hasn't associated any biometric credentials with their account.";
                            break;
            default:
                info = "Unknown error";
                break;

        }
        Toast.makeText(this, info, Toast.LENGTH_LONG).show();
    }


}