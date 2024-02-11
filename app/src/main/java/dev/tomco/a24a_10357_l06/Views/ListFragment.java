package dev.tomco.a24a_10357_l06.Views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textview.MaterialTextView;

import dev.tomco.a24a_10357_l06.Interfaces.Callback_highScoreClicked;
import dev.tomco.a24a_10357_l06.R;


public class ListFragment extends Fragment {
    private MaterialTextView list_LBL_title;
    private MaterialButton list_BTN_send;

    private Callback_highScoreClicked callbackHighScoreClicked;

    public ListFragment() {
    }

    public void setCallbackHighScoreClicked(Callback_highScoreClicked callbackHighScoreClicked) {
        this.callbackHighScoreClicked = callbackHighScoreClicked;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        findViews(view);

        list_BTN_send.setOnClickListener(v -> itemClicked(32.1129923, 34.8182147));

        return view;
    }

    private void itemClicked(double lat, double lon) {
        if (callbackHighScoreClicked != null)
            callbackHighScoreClicked.highScoreClicked(lat, lon);
    }


    private void findViews(View view) {
        list_LBL_title = view.findViewById(R.id.list_LBL_title);
        list_BTN_send = view.findViewById(R.id.list_BTN_send);
    }
}