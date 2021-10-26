package com.example.vebutton;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.app.Activity;
import android.graphics.Point;
import android.view.Display;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends Activity {

    Handler handlerMain;
    AtomicBoolean atomic=null;
    LinearLayout layoutdevebutton;
    Button btnOk;
    EditText edtOk;
    int sizehalf=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //lấy LinearLayout chứa Button ra
        layoutdevebutton=(LinearLayout) findViewById(R.id.layout_draw_button);
        final Random rd=new Random();
        btnOk=(Button) findViewById(R.id.btnDrawButton);
        edtOk=(EditText) findViewById(R.id.editNumber);
        handlerMain=new Handler()
        {
            @Override
            public void handleMessage(Message msg) {
                // TODO Auto-generated method stub
                super.handleMessage(msg);
                //Nhận nhãn của Button được gửi về từ tiến trình con
                int v=rd.nextInt(100);
                String nhan_button=v+"";
                //khởi tạo 1 Button
                Button b=new Button(MainActivity.this);
                //thiết lập nhãn cho Button
                b.setText(nhan_button);
                //thiết lập kiểu Layout : Width, Height
                LayoutParams params=new
                        LayoutParams(LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);
                if(msg.arg1%2==0)
                    params.gravity=Gravity.LEFT;
                else
                    params.gravity=Gravity.RIGHT;
                //thiết lập layout cho Button

                b.setWidth(sizehalf);
                b.setLayoutParams(params);
                //đưa Button vào layoutdevebutton
                layoutdevebutton.addView(b);

            }
        };
        btnOk.setOnClickListener(arg0 -> {
            // TODO Auto-generated method stub
            doStart();
        });
    }
    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        //lấy màn hình điện thoại đang sử dụng
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        sizehalf=size.x/2;
    }
    private void doStart()
    {
        layoutdevebutton.removeAllViews();
        atomic=new AtomicBoolean(false);
        final int sobutton=Integer.parseInt(edtOk.getText()+"");
        Thread thCon=new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub

                for(int i=0;i<sobutton && atomic.get();i++)
                {
                    //nghỉ 200 mili second
                    SystemClock.sleep(200);
                    //lấy message từ Main Thread
                    Message msg=handlerMain.obtainMessage();
                    //gán dữ liệu cho msg Mainthread, lưu vào biến obj
                    //chú ý ta có thể lưu bất kỳ kiểu dữ liệu nào vào obj
                    msg.arg1=i;
                    //gửi trả lại message cho Mainthread
                    handlerMain.sendMessage(msg);
                }
            }
        });
        atomic.set(true);
        //thực thi tiến trình
        thCon.start();
    }

}