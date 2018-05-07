package com.zphaonu.zppalyer.Fragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.zphaonu.zppalyer.R;
import com.zphaonu.zppalyer.view.MyDialog;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OneFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OneFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OneFragment extends BaseFragment implements View.OnClickListener {


    public static final String TAG = OneFragment.class.getSimpleName();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public FragmentManager manager;
    public FragmentTransaction transaction;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button btnBack, btnToTwo, btnOpen, btnDialog;

    public OneFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OneFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OneFragment newInstance(String param1, String param2) {
        OneFragment fragment = new OneFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page_one, container, false);
        btnBack = view.findViewById(R.id.btn_back);
        btnToTwo = view.findViewById(R.id.btn_to_two);
        btnBack.setOnClickListener(this);
        btnToTwo.setOnClickListener(this);
        btnOpen = view.findViewById(R.id.btn_open_child_fm);
        btnDialog = view.findViewById(R.id.btn_open_dialog);
        btnDialog.setOnClickListener(this);
        btnOpen.setOnClickListener(this);
        Log.e(TAG, "onCreateView");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG, "onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(TAG, "onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(TAG, "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Log.e(TAG, "onCreate");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG, "onDetach");
    }


    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                getActivity().finish();
                break;
            case R.id.btn_to_two:
                if (manager == null) {
                    manager = getFragmentManager();
                    transaction = manager.beginTransaction();
                }
                TwoFragment two = new TwoFragment();
                transaction.replace(R.id.fl, two);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case R.id.btn_open_child_fm:
                if (manager == null) {
                    manager = getFragmentManager();
//                    transaction = manager.beginTransaction();
                }
                manager = getFragmentManager();
               FragmentTransaction transaction = manager.beginTransaction();
                ThreeFragment threeFragment = (ThreeFragment) manager.findFragmentByTag(TAG);
                if (threeFragment == null) {
                    ThreeFragment three = new ThreeFragment();
//                    transaction.add(R.id.fl,three,TAG).commit();
                    transaction.replace(R.id.fl, three);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                break;
            case R.id.btn_open_dialog:
                if (manager == null) {
                    manager = getFragmentManager();
                }
                showDialog();
                break;
        }
    }

    private void showDialog() {
        MyDialog dialog = new MyDialog();
        dialog.show(manager, "showDialog");
    }

}
