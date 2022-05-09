package ru.mirea.anichkov.viewmodel;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        // получение доступа к создайнной ViewModel
        ViewModelProvider viewModelProvider =  new ViewModelProvider(this);
        ProgressViewModel viewModel =
                viewModelProvider.get(ProgressViewModel.class);
        viewModel.getProgressState().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean isVisibleProgressBar) {
                if (isVisibleProgressBar) {
                    progressBar.setVisibility(View.VISIBLE);
                } else {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
        viewModel.showProgress();
    }
}