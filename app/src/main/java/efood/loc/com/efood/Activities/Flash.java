package efood.loc.com.efood.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import efood.loc.com.efood.MainActivity;
import efood.loc.com.efood.R;

public class Flash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fl);
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(3000);
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                } catch (Exception e) {
                    Log.e("ValueError", e.getMessage());
                }
            }
        };
        thread.start();
    }
}
