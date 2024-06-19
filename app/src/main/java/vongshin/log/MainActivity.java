package vongshin.log;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File file = new File("sdcard/alog/");
        File rootDir = file.getParentFile();
        String name = file.getName();
        Log.d(TAG, "rootDir: " + file.exists());
        Log.d(TAG, "rootDir: " + rootDir);
        Log.d(TAG, "name: " + name);
    }
}