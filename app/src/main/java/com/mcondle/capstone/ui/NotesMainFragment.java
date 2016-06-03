package com.mcondle.capstone.ui;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mcondle.capstone.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class NotesMainFragment extends Fragment {

    private Context context;

    public static NotesMainFragment newInstance() {
        return new NotesMainFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
