package project.codenicely.admin.a1mile.a1mileadmin.splash_screen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import project.codenicely.admin.a1mile.a1mileadmin.MainActivity;
import project.codenicely.admin.a1mile.a1mileadmin.R;
import project.codenicely.admin.a1mile.a1mileadmin.helper.SharedPrefs;

public class SplashScreen extends AppCompatActivity {

    private SharedPrefs sharedPrefs;
    @BindView(R.id.codeNicelyLogo)
    ImageView code_nicely_logo;

    @BindView(R.id.one_mile_logo)
    ImageView veg_word_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
        sharedPrefs = new SharedPrefs(this);
        Glide.with(this).load(R.drawable.codenicely_coloured_logo).into(code_nicely_logo);
        Glide.with(this).load(R.drawable.one_mile_logo).into(veg_word_logo);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        }, 2000);


    }
}
