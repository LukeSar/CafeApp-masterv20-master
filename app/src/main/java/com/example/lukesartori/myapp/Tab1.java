package com.example.lukesartori.myapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Tab1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Tab1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Tab1 extends Fragment implements View.OnClickListener {

    Button BaconButton, SuasageButton, ToastButton, ChocolateButton, PlainButton;





    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private OnFragmentInteractionListener mListener;

    public Tab1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Tab1.
     */
    // TODO: Rename and change types and number of parameters
    public static Tab1 newInstance(String param1, String param2) {
        Tab1 fragment = new Tab1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_tab1, container, false);




        return rootView;
        //return inflater.inflate(R.layout.fragment_tab1, container, false);

    }
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);

        final Button BaconButton = (Button) getActivity().findViewById(R.id.BaconButton);
        BaconButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BaconButton.setTextColor(Color.GREEN);
                Toast.makeText(getActivity(),"Bacon Sandwich Added",Toast.LENGTH_SHORT).show();
                    }
                });

        final Button SausageButton = (Button) getActivity().findViewById(R.id.SausageButton);
        SausageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SausageButton.setTextColor(Color.GREEN);
                Toast.makeText(getActivity(),"Sausage Sandwich Added", Toast.LENGTH_SHORT).show();

            }
        });

        final Button ToastButton = (Button) getActivity().findViewById(R.id.ToastButton);
        ToastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastButton.setTextColor(Color.GREEN);
                Toast.makeText(getActivity(), "Toast Added", Toast.LENGTH_SHORT).show();
            }
        });

        final Button ChocolateButton = (Button) getActivity().findViewById(R.id.ChocolateButton);
        ChocolateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChocolateButton.setTextColor(Color.GREEN);
                Toast.makeText(getActivity(), "Chocolate Croissant Added", Toast.LENGTH_SHORT).show();
            }
        });


        final Button PlainButton = (Button) getActivity().findViewById(R.id.PlainButton);
        PlainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlainButton.setTextColor(Color.GREEN);
                Toast.makeText(getActivity(), "Plain Croissant Added", Toast.LENGTH_SHORT).show();
            }
        });

        final Button FruitButton = (Button) getActivity().findViewById(R.id.FruitButton);
        FruitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FruitButton.setTextColor(Color.GREEN);
                Toast.makeText(getActivity(), "Fruit Salad Added", Toast.LENGTH_SHORT).show();
            }
        });

        final Button BologneseButton = (Button) getActivity().findViewById(R.id.BologneseButton);
        BologneseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BologneseButton.setTextColor(Color.GREEN);
                Toast.makeText(getActivity(), "Fruit Salad Added", Toast.LENGTH_SHORT).show();
            }
        });

        final Button CarbonaraButton = (Button) getActivity().findViewById(R.id.CarbonaraButton);
        CarbonaraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarbonaraButton.setTextColor(Color.GREEN);
                Toast.makeText(getActivity(), "Carbonara Added", Toast.LENGTH_SHORT).show();
            }
        });

        final Button VegButton = (Button) getActivity().findViewById(R.id.VegButton);
        VegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VegButton.setTextColor(Color.GREEN);
                Toast.makeText(getActivity(), "Veg Pasta Added", Toast.LENGTH_SHORT).show();
            }
        });

        final Button HamButton = (Button) getActivity().findViewById(R.id.HamButton);
        HamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HamButton.setTextColor(Color.GREEN);
                Toast.makeText(getActivity(), "Ham and Cheese Sandwich Added", Toast.LENGTH_SHORT).show();
            }
        });

        final Button SaladButton = (Button) getActivity().findViewById(R.id.SaladButton);
        SaladButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaladButton.setTextColor(Color.GREEN);
                Toast.makeText(getActivity(), "Salad Added", Toast.LENGTH_SHORT).show();
            }
        });

        final Button MLasagnaButton = (Button) getActivity().findViewById(R.id.MLasagnaButton);
        MLasagnaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MLasagnaButton.setTextColor(Color.GREEN);
                Toast.makeText(getActivity(), "Meat Lasagna Added", Toast.LENGTH_SHORT).show();
            }
        });

        final Button VLasagnaButton = (Button) getActivity().findViewById(R.id.VLasagnaButton);
        VLasagnaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VLasagnaButton.setTextColor(Color.GREEN);
                Toast.makeText(getActivity(), "Veg Lasagna Added", Toast.LENGTH_SHORT).show();
            }
        });

        final Button CokeButton = (Button) getActivity().findViewById(R.id.CokeButton);
        CokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CokeButton.setTextColor(Color.GREEN);
                Toast.makeText(getActivity(), "Coke Added", Toast.LENGTH_SHORT).show();
            }
        });

        final Button DietCokeButton = (Button) getActivity().findViewById(R.id.DietCokeButton);
        DietCokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DietCokeButton.setTextColor(Color.GREEN);
                Toast.makeText(getActivity(), "Diet Coke Added", Toast.LENGTH_SHORT).show();
            }
        });

        final Button FantaButton = (Button) getActivity().findViewById(R.id.FantaButton);
        FantaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FantaButton.setTextColor(Color.GREEN);
                Toast.makeText(getActivity(), "Fanta Added", Toast.LENGTH_SHORT).show();
            }
        });

        final Button SpriteButton = (Button) getActivity().findViewById(R.id.SpriteButton);
        SpriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpriteButton.setTextColor(Color.GREEN);
                Toast.makeText(getActivity(), "Sprite Added", Toast.LENGTH_SHORT).show();
            }
        });

        final Button WaterButton = (Button) getActivity().findViewById(R.id.WaterButton);
        WaterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WaterButton.setTextColor(Color.GREEN);
                Toast.makeText(getActivity(), "Water Added", Toast.LENGTH_SHORT).show();
            }
        });

        final Button SparklingWaterButton = (Button) getActivity().findViewById(R.id.SparklingWaterButton);
        SparklingWaterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SparklingWaterButton.setTextColor(Color.GREEN);
                Toast.makeText(getActivity(), "Sparkling Water Added", Toast.LENGTH_SHORT).show();
            }
        });



    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

