package com.example.seifmostafa.easyparking;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.zxing.WriterException;
import com.google.zxing.qrcode.encoder.QRCode;

public class MainActivity extends AppCompatActivity {

    Button GENERATE, PRINT;
    EditText PHONENUMBER;
    String phonenum;
    int smallerDimension=0;
    ImageView GeneratedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WindowManager wm = (WindowManager) MainActivity.this.getSystemService(MainActivity.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        Log.i("WIDTH_HIGHT" , width +" "+height);
        smallerDimension = width < height ? width : height;
        smallerDimension = smallerDimension * 3/4;
        buttons();
    }
    void buttons()
    {
        GENERATE= (Button)findViewById(R.id.button_generate);
        PRINT=(Button)findViewById(R.id.button_print);

        GENERATE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GeneratedImage =(ImageView)findViewById(R.id.imageView_generatedQr);
                PHONENUMBER=(EditText)findViewById(R.id.editText_phoneNum);
                phonenum=PHONENUMBER.getText().toString();
                SecuredPhoneNum securedPhoneNum = new SecuredPhoneNum(phonenum);
                securedPhoneNum.setSecured();
                phonenum = securedPhoneNum.getSecured();
                Bitmap bitmap=null;
                try {
                   bitmap=Utility.encodeAsBitmap(phonenum, smallerDimension);
                } catch (Exception e) {
                    Log.e("CALLGENERATOR",e.toString());
                }
                GeneratedImage.setImageBitmap(bitmap);
            }
        });

    }
}
