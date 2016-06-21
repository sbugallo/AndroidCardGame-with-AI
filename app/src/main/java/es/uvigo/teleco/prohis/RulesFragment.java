package es.uvigo.teleco.prohis;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RulesFragment extends Fragment {

    public static RulesFragment newInstance() {
        RulesFragment fragment = new RulesFragment();
        return fragment;
    }

    public RulesFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.rules_fragment, container, false);
    }


}
