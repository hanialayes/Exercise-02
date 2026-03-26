package com.example.exercise02;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.example.exercise02.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private static final String WALL_COLOR = "white";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSubmit.setOnClickListener(v -> validateLogin());
    }

    private void validateLogin() {
        String studentId = binding.etStudentId.getText().toString().trim();
        String password  = binding.etPassword.getText().toString().trim();

        if (studentId.length() < 2) {
            binding.tvResult.setText("Invalid Student ID.");
            return;
        }

        String lastTwo = studentId.substring(studentId.length() - 2);

        String expectedPassword = WALL_COLOR.concat(lastTwo);

        if (password.equals(expectedPassword)) {
            binding.tvResult.setText("Access Granted! Welcome.");
        } else {
            binding.tvResult.setText("Access Denied. Wrong password.");
        }
    }
}
