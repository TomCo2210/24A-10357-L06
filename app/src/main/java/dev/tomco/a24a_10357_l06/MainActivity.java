package dev.tomco.a24a_10357_l06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import dev.tomco.a24a_10357_l06.Interfaces.Callback_highScoreClicked;
import dev.tomco.a24a_10357_l06.Utilities.TimeTicker;
import dev.tomco.a24a_10357_l06.Views.ListFragment;
import dev.tomco.a24a_10357_l06.Views.MapFragment;

public class MainActivity extends AppCompatActivity {

    private FrameLayout main_FRAME_list;
    private FrameLayout main_FRAME_map;

    private MapFragment mapFragment;
    private ListFragment listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();

        listFragment = new ListFragment();
        listFragment.setCallbackHighScoreClicked(new Callback_highScoreClicked() {
            @Override
            public void highScoreClicked(double lat, double lon) {
                mapFragment.zoom(lat,lon);
            }
        });
        mapFragment = new MapFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.main_FRAME_list, listFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_FRAME_map, mapFragment).commit();


        new TimeTicker(() -> {}).startTimer();
    }

    private void findViews() {

        main_FRAME_list = findViewById(R.id.main_FRAME_list);
        main_FRAME_map = findViewById(R.id.main_FRAME_map);
    }
}