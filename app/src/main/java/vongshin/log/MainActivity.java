package vongshin.log;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(()->{
                    for (int i = 0; i < 10000; i++) {
                        Log.i(TAG, "MainActivity onClick: " + i);
                    }
                }).start();
            }
        });
    }
    public static File getDirAndMake(File file){
        File rootDir = file.getParentFile();
        System.out.println(rootDir.getPath() + rootDir.exists());
        if(!rootDir.exists()){
            boolean re = rootDir.mkdir();
            System.out.println("re" + re);
            System.out.println("re" + rootDir.isDirectory());
        }
        return rootDir;
    }
}