package com.africa.cloud.basefirebase;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.africa.cloud.basefirebase.model.Tarifs;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TarifsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TarifsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TarifsFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private OnButtonClickedListener mCallback;

    View view;
ImageView img, igm, monim, image, visage;
CardView cardV, cardVi, cardVie, cardView;
TextView repassage, repss;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public TarifsFragment() {
        // un fragment doit toujours avoir un constructeur vide implémenté par défaut
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TarifsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TarifsFragment newInstance(String param1, String param2) {
        TarifsFragment fragment = new TarifsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @SuppressLint("WrongViewCast")
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
        // permet de récupérer le layout fragment_tarifs.xml  afin de le définir comme layout principal de notre fragment
        View result = inflater.inflate(R.layout.fragment_tarifs, container, false);

        result.findViewById(R.id.image_repassage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RepassageActivity.class);
                startActivity(intent);
            }
        });

        //click sur la cardview repassage
        result.findViewById(R.id.bankcardId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), RepassageActivity.class);
                startActivity(intent);
            }
        });

        //cardview nettoyage
        result.findViewById(R.id.bankcardId1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), NettoyageActivity.class);
                startActivity(intent);
            }
        });


        //cardView teinture
        result.findViewById(R.id.bankcardId2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), TeintureActivity.class);
                startActivity(intent);
            }
        });


        //tarif retouche
        result.findViewById(R.id.bankcardId3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), RetoucheActivity.class);
                startActivity(intent);
            }
        });

        //prix nettoyage tapis
        result.findViewById(R.id.bankcardId5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), NettoyageTapisActivity.class);
                startActivity(intent);
            }
        });


        return result;



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

        mCallback.onButtonClicked(v);
    }


    private void createCallbackToParentActivity(){
        try {
            //Parent activity will automatically subscribe to callback
            mCallback = (OnButtonClickedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString()+ " must implement OnButtonClickedListener");
        }
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


    public  void AllerSurAciviteTarifs()
                {
                    Intent intent = new Intent(getActivity(), TarifsActivity.class);
                    startActivity(intent);
                }

//declaration de l'interface
    public interface OnButtonClickedListener {
        public void onButtonClicked(View view);
    }
}
