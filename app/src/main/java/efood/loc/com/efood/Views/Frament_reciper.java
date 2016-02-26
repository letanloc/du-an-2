package efood.loc.com.efood.Views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import efood.loc.com.efood.R;

/**
 * Created by loc on 26/02/2016.
 */
public class Frament_reciper extends Fragment {
    View v;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.frament_reciper, container, false);
        return v;
    }

}
