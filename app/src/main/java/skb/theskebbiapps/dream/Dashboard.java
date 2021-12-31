package skb.theskebbiapps.dream;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;

import android.os.Bundle;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import skb.theskebbiapps.dream.ListActivites.MainActivity;
import skb.theskebbiapps.dream.ListActivites.MainActivity2;
import skb.theskebbiapps.dream.ListActivites.MainActivity3;
import skb.theskebbiapps.dream.ListActivites.MainActivity4;
import skb.theskebbiapps.dream.ListActivites.MainActivity5;
import skb.theskebbiapps.dream.ListActivites.MainActivity6;

public class Dashboard extends AppCompatActivity {
    Animation topAnim;
    Uri urinotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        CardView FirstCard=(CardView)findViewById(R.id.FirstCard);
        // Animations
        topAnim = AnimationUtils.loadAnimation(this, R.anim.botton_animation);
        FirstCard.setAnimation(topAnim);

        Button cardBtn1=(Button)findViewById(R.id.cardBtn1);
        Button cardBtn2=(Button)findViewById(R.id.cardBtn2);
        Button cardBtn3=(Button)findViewById(R.id.cardBtn3);
        Button cardBtn4=(Button)findViewById(R.id.cardBtn4);
        Button cardBtn5=(Button)findViewById(R.id.cardBtn5);
        Button cardBtn6=(Button)findViewById(R.id.cardBtn6);
        Button cardBtn7=(Button)findViewById(R.id.cardBtn7);

        ImageView imageview1= (ImageView) findViewById(R.id.imageview1);
        ImageView imageview2= (ImageView) findViewById(R.id.imageview2);
        ImageView imageview3= (ImageView) findViewById(R.id.imageview3);
        ImageView imageview4= (ImageView) findViewById(R.id.imageview4);
        ImageView imageview5= (ImageView) findViewById(R.id.imageview5);
        ImageView imageview6= (ImageView) findViewById(R.id.imageview6);
        ImageView imageview7= (ImageView) findViewById(R.id.imageview7);


        topAnim = AnimationUtils.loadAnimation(this, R.anim.botton_animation);


//This is a restart button with a  click Listener that take the user back to the main Dashboard so the user can start a new Quiz.
        cardBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        cardBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), MainActivity2.class);
                startActivity(intent);
            }
        });

        cardBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), MainActivity3.class);
                startActivity(intent);
            }
        });

        cardBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotification();
                Intent intent=new Intent(getApplicationContext(), MainActivity4.class);
                startActivity(intent);
            }
        });


        cardBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), MainActivity5.class);
                startActivity(intent);
            }
        });

        cardBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), MainActivity6.class);
                startActivity(intent);
            }
        });

        cardBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DeveloperInfo.class);
                startActivity(intent);
            }
        });



        imageview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        imageview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
                startActivity(intent);
            }
        });


        imageview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity3.class);
                startActivity(intent);
            }
        });

        imageview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity4.class);
                startActivity(intent);
            }
        });





        imageview5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity5.class);
                startActivity(intent);
            }
        });


        imageview6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),MainActivity6.class);
                startActivity(intent);
            }
        });

        imageview7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),DeveloperInfo.class);
                startActivity(intent);
            }
        });}



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
                        .setContentTitle("Contact Our Developers Team ")
                        .setSound(urinotification)
                        .setContentText("Developed By Devub Team,Abuja Nigeria +2349065211228.");

        Intent notificationIntent = new Intent(this, DeveloperInfo.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }


}

