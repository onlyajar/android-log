package vongshin.log;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File file = new File("sdcard/soga/mis.log");
        File rootDir = file.getParentFile();
        String name = file.getName();
        Log.d(TAG, "rootDir: " + file.exists());
        Log.d(TAG, "rootDir: " + rootDir);
        Log.d(TAG, "name: " + name);
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