package skb.theskebbiapps.dream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.os.Bundle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
public class SplashScreen extends AppCompatActivity {

    private  static  int SPLASH_SCREEN = 5000;
    Uri urinotification;
    Animation topAnim,bottonAnim;
    TextView textViewH,textView23,textView2,textView10;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        // Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.botton_animation);
        bottonAnim = AnimationUtils.loadAnimation(this, R.anim.botton_animation);


        //Hooks
        imageView = findViewById(R.id.image);
        textView2 = findViewById(R.id.textview2);
        textView23 = findViewById(R.id.textView23);
        textViewH = findViewById(R.id.textViewH);
        textView10 = findViewById(R.id.textView10);


        imageView.setAnimation(bottonAnim);
        imageView.setAnimation(bottonAnim);
        textViewH.setAnimation(bottonAnim);
        textView23.setAnimation(topAnim);
        textView10.setAnimation(topAnim);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Dashboard.class);
                startActivity(intent);
                addNotification();
                finish();
            }
        }, SPLASH_SCREEN);
    }
    private void addNotification() {
        try {
            urinotification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), urinotification);
            r.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.daco)
                        .setContentTitle("More Questions Are waiting")
                        .setSound(urinotification)
                        .setContentText("You Have More Then 100+ Questions To Answer.");

        Intent notificationIntent = new Intent(this, Dashboard.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
}
