package com.example.lukesartori.myapp;


import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Tab1 extends Fragment implements View.OnClickListener {

    private DatabaseReference mDatabase;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_tab1, container, false);

        return rootView;
    }



    @Override
    public void onClick(View v) {


    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) { //When activity loads produce method
        super.onActivityCreated(savedInstanceState);
        final double[] Total = new double[1]; //Sets total data type to double so that it can represent decimals and sets its index
        Total[0] = 0.00; //Sets total value to 0.00 to start with

        mDatabase = FirebaseDatabase.getInstance().getReference().child("Order");
       // mDatabase.child("Order").setValue("Break");

        /*
        The following on click listeners are all menu items that have been set to add to the total
        value and change background on click while showing a toast message to make it clear to the
        Stakeholder that the item has been added.
         */


        final Button BaconButton = (Button) getActivity().findViewById(R.id.BaconButton);
        BaconButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Total[0] += 4.00;
                final TextView TotalView = (TextView) getActivity().findViewById(R.id.TotalView);
                TotalView.setText("£  " + String.valueOf(Total[0])); //Present new total price to the Stakeholder
                BaconButton.setBackgroundResource(R.drawable.buttonchange);
                mDatabase.child("Bacon Sandwich").setValue("£4.00");

            }
        });

        final Button SausageButton = (Button) getActivity().findViewById(R.id.SausageButton);
        SausageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Total[0] += 4.00;
                final TextView TotalView = (TextView) getActivity().findViewById(R.id.TotalView);
                TotalView.setText("£  " + String.valueOf(Total[0]));
                SausageButton.setBackgroundResource(R.drawable.buttonchange);

                mDatabase.child("Sausage Sandwich").setValue("£4.00");

            }
        });

        final Button ToastButton = (Button) getActivity().findViewById(R.id.ToastButton);
        ToastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Total[0] += 2.50;
                final TextView TotalView = (TextView) getActivity().findViewById(R.id.TotalView);
                TotalView.setText("£  " + String.valueOf(Total[0]));
                ToastButton.setBackgroundResource(R.drawable.buttonchange);

                mDatabase.child("Toast").setValue("£2.50");
            }
        });

        final Button ChocolateButton = (Button) getActivity().findViewById(R.id.ChocolateButton);
        ChocolateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Total[0] += 1.20;
                final TextView TotalView = (TextView) getActivity().findViewById(R.id.TotalView);
                TotalView.setText("£  " + String.valueOf(Total[0]));
                ChocolateButton.setBackgroundResource(R.drawable.buttonchange);

                mDatabase.child("Chocolate Croissant").setValue("£1.20");
            }
        });


        final Button PlainButton = (Button) getActivity().findViewById(R.id.PlainButton);
        PlainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Total[0] += 0.80;
                final TextView TotalView = (TextView) getActivity().findViewById(R.id.TotalView);
                TotalView.setText("£  " + String.valueOf(Total[0]));
                PlainButton.setBackgroundResource(R.drawable.buttonchange);

                mDatabase.child("Plain Croissant").setValue("£0.80");
            }
        });

        final Button FruitButton = (Button) getActivity().findViewById(R.id.FruitButton);
        FruitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Total[0] += 2.50;
                final TextView TotalView = (TextView) getActivity().findViewById(R.id.TotalView);
                TotalView.setText("£  " + String.valueOf(Total[0]));
                FruitButton.setBackgroundResource(R.drawable.buttonchange);

                mDatabase.child("Fruit Cup").setValue("£2.50");
            }
        });

            /*
        The following on click listeners are all menu items that have been set to add to the total
        value and change background on click while showing a toast message to make it clear to the
        Stakeholder that the item has been added.
         */


        final Button BologneseButton = (Button) getActivity().findViewById(R.id.BologneseButton);
        BologneseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Total[0] += 5.00;
                final TextView TotalView = (TextView) getActivity().findViewById(R.id.TotalView);
                TotalView.setText("£  " + String.valueOf(Total[0]));
                BologneseButton.setBackgroundResource(R.drawable.buttonchange);

                mDatabase.child("Bolognese Pasta").setValue("£5.00");
            }
        });

        final Button CarbonaraButton = (Button) getActivity().findViewById(R.id.CarbonaraButton);
        CarbonaraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Total[0] += 5.00;
                final TextView TotalView = (TextView) getActivity().findViewById(R.id.TotalView);
                TotalView.setText("£  " + String.valueOf(Total[0]));
                CarbonaraButton.setBackgroundResource(R.drawable.buttonchange);

                mDatabase.child("Carbonara Pasta").setValue("£5.00");
            }
        });

        final Button VegButton = (Button) getActivity().findViewById(R.id.VegButton);
        VegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Total[0] += 5.00;
                final TextView TotalView = (TextView) getActivity().findViewById(R.id.TotalView);
                TotalView.setText("£  " + String.valueOf(Total[0]));
                VegButton.setBackgroundResource(R.drawable.buttonchange);

                mDatabase.child("Vegetable Pasta").setValue("£5.00");

            }
        });

        final Button HamButton = (Button) getActivity().findViewById(R.id.HamButton);
        HamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Total[0] += 3.00;
                final TextView TotalView = (TextView) getActivity().findViewById(R.id.TotalView);
                TotalView.setText("£  " + String.valueOf(Total[0]));
                HamButton.setBackgroundResource(R.drawable.buttonchange);

                mDatabase.child("Ham and Cheese Sandwich").setValue("£3.00");

            }
        });

        final Button SaladButton = (Button) getActivity().findViewById(R.id.SaladButton);
        SaladButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Total[0] += 4.50;
                final TextView TotalView = (TextView) getActivity().findViewById(R.id.TotalView);
                TotalView.setText("£  " + String.valueOf(Total[0]));
                SaladButton.setBackgroundResource(R.drawable.buttonchange);

                mDatabase.child("Salad Box").setValue("£4.50");
            }
        });

        final Button MLasagnaButton = (Button) getActivity().findViewById(R.id.MLasagnaButton);
        MLasagnaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Total[0] += 6.00;
                final TextView TotalView = (TextView) getActivity().findViewById(R.id.TotalView);
                TotalView.setText("£  " + String.valueOf(Total[0]));
                MLasagnaButton.setBackgroundResource(R.drawable.buttonchange);

                mDatabase.child("Meat Lasagna").setValue("£6.00");
            }
        });

        final Button VLasagnaButton = (Button) getActivity().findViewById(R.id.VLasagnaButton);
        VLasagnaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Total[0] += 6.00;
                final TextView TotalView = (TextView) getActivity().findViewById(R.id.TotalView);
                TotalView.setText("£  " + String.valueOf(Total[0]));
                VLasagnaButton.setBackgroundResource(R.drawable.buttonchange);

                mDatabase.child("Vegetable Lasagna").setValue("£6.00");
            }
        });

               /*
        The following on click listeners are all menu items that have been set to add to the total
        value and change background on click while showing a toast message to make it clear to the
        Stakeholder that the item has been added.
         */

        final Button CokeButton = (Button) getActivity().findViewById(R.id.CokeButton);
        CokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Total[0] += 1.00;
                final TextView TotalView = (TextView) getActivity().findViewById(R.id.TotalView);
                TotalView.setText("£  " + String.valueOf(Total[0]));
                CokeButton.setBackgroundResource(R.drawable.buttonchange);

                mDatabase.child("Coke").setValue("£1.00");
            }
        });

        final Button DietCokeButton = (Button) getActivity().findViewById(R.id.DietCokeButton);
        DietCokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Total[0] += 1.00;
                final TextView TotalView = (TextView) getActivity().findViewById(R.id.TotalView);
                TotalView.setText("£  " + String.valueOf(Total[0]));
                DietCokeButton.setBackgroundResource(R.drawable.buttonchange);
                mDatabase.child("Diet Coke").setValue("£1.00");
            }
        });

        final Button FantaButton = (Button) getActivity().findViewById(R.id.FantaButton);
        FantaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Total[0] += 1.00;
                final TextView TotalView = (TextView) getActivity().findViewById(R.id.TotalView);
                TotalView.setText("£  " + String.valueOf(Total[0]));
                FantaButton.setBackgroundResource(R.drawable.buttonchange);
                mDatabase.child("Fanta").setValue("£1.00");
            }
        });

        final Button SpriteButton = (Button) getActivity().findViewById(R.id.SpriteButton);
        SpriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Total[0] += 1.00;
                final TextView TotalView = (TextView) getActivity().findViewById(R.id.TotalView);
                TotalView.setText("£  " + String.valueOf(Total[0]));
                SpriteButton.setBackgroundResource(R.drawable.buttonchange);

                mDatabase.child("Sprite").setValue("£1.00");
            }
        });

        final Button WaterButton = (Button) getActivity().findViewById(R.id.WaterButton);
        WaterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Total[0] += 1.20;
                final TextView TotalView = (TextView) getActivity().findViewById(R.id.TotalView);
                TotalView.setText("£  " + String.valueOf(Total[0]));
                WaterButton.setBackgroundResource(R.drawable.buttonchange);
                mDatabase.child("Water").setValue("£1.20");
            }
        });

        final Button SparklingWaterButton = (Button) getActivity().findViewById(R.id.SparklingWaterButton);
        SparklingWaterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Total[0] += 1.50;
                final TextView TotalView = (TextView) getActivity().findViewById(R.id.TotalView);
                TotalView.setText("£  " + String.valueOf(Total[0]));
                SparklingWaterButton.setBackgroundResource(R.drawable.buttonchange);

                mDatabase.child("Sparkling Water").setValue("£1.50");
            }
        });

        final TextView ConfirmView = (TextView) getActivity().findViewById(R.id.ConfirmView);
        final TextView CashView = (TextView) getActivity().findViewById(R.id.CashView);
        CashView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmView.setVisibility(View.VISIBLE);
                if (Total[0] > 3.0 && Total[0] < 30.01) {
                    ConfirmView.setVisibility(View.VISIBLE);
                    Toast.makeText(getActivity(), "Confirm Order", Toast.LENGTH_SHORT).show();
                    SparklingWaterButton.setEnabled(false);
                    WaterButton.setEnabled(false);
                    SpriteButton.setEnabled(false);
                    FantaButton.setEnabled(false);
                    DietCokeButton.setEnabled(false);
                    CokeButton.setEnabled(false);
                    VLasagnaButton.setEnabled(false);
                    MLasagnaButton.setEnabled(false);
                    SaladButton.setEnabled(false);
                    HamButton.setEnabled(false);
                    VegButton.setEnabled(false);
                    CarbonaraButton.setEnabled(false);
                    BologneseButton.setEnabled(false);
                    FruitButton.setEnabled(false);
                    PlainButton.setEnabled(false);
                    ChocolateButton.setEnabled(false);
                    ToastButton.setEnabled(false);
                    SausageButton.setEnabled(false);
                    BaconButton.setEnabled(false);


                }else{
                    ConfirmView.setVisibility(View.INVISIBLE);
                }
            }
        });
            ConfirmView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), Checkout.class);
                    startActivity(intent);
                    mDatabase.child("Order Confirmed").setValue("Order Confirmed");
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






/*
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
*/


  /*
    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);

        }
    }
*/
  /*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }
*/


 /*
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
*/