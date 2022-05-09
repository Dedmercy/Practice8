package ru.mirea.anichkov.practice8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private Server server;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        server = new Server();
        getLifecycle().addObserver(server);
    }

    public class Server implements LifecycleObserver {
        private String TAG = "lifecycle";

        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        public void connect() {
            Log.d(TAG, "connect to web-server");
        }

        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        public void disconnect() {
            Log.d(TAG, "disconnect");
        }
    }
}