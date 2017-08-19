package com.sparkle.activitytest;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private int zuoNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.frist_layout);

        Intent intent = getIntent();
        zuoNum = intent.getIntExtra("zuoNum",0);
        if(zuoNum != 0){
            Toast.makeText(FirstActivity.this,"作死 x"+zuoNum,Toast.LENGTH_SHORT).show();
            Log.d("作死",zuoNum+"");
        }

        Log.d("创建", this.toString());

        Button button1 = (Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FirstActivity.this, "将跳转到活动2", Toast.LENGTH_SHORT).show();
                Intent  intent = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.button_1_1);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent("lalalala");
                intent2.putExtra("msg","你是从第二条路进来的");
                startActivity(intent2);
            }
        });

        Button zuo = (Button) findViewById(R.id.zuo);
        zuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i=0;i<100;i++) {
                    Intent intent = new Intent(FirstActivity.this, FirstActivity.class);
                    zuoNum++;
                    intent.putExtra("zuoNum", zuoNum);
                    startActivity(intent);
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this,"你按了Add按钮",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete_item:
                Toast.makeText(this,"你按了Delete按钮",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }
}
