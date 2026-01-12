package com.example.studyplanner;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvTask;
    Button btnAddTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTask = findViewById(R.id.tvTask);
        btnAddTask = findViewById(R.id.btnAddTask);

        btnAddTask.setOnClickListener(v -> {
            showAddTaskDialog();
        });
    }

    private void showAddTaskDialog() {
        EditText input = new EditText(this);
        input.setHint("Enter your task");

        new AlertDialog.Builder(this)
                .setTitle("Add Task")
                .setView(input)
                .setPositiveButton("Add", (dialog, which) -> {
                    String task = input.getText().toString().trim();
                    if (!task.isEmpty()) {
                        tvTask.setText(task);
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }
}
