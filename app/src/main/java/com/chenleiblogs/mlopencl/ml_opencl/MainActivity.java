package com.chenleiblogs.mlopencl.ml_opencl;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


// 2018.05.13 陈雷 编译不过去 我能说什么呢？@西安电子科技大学

public class MainActivity extends AppCompatActivity {

    private Button neon,opencl;
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        final TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

        neon = (Button) findViewById(R.id.try_neon);
        opencl = (Button)findViewById(R.id.try_opencl);


        //实现点击逻辑 （NEON）
        neon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(alexnetWithNeon());
            }
        });

        //实现点击逻辑 （OpenCL）
        opencl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(alexnetWithOpenCL());
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public static native String stringFromJNI();
    public static native String alexnetWithNeon();
    public static native String alexnetWithOpenCL();
}
