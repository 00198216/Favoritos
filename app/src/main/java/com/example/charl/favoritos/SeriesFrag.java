package com.example.charl.favoritos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SeriesFrag.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SeriesFrag#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SeriesFrag extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    RecyclerView rv;
    SeriesAdapter adapter;
    ArrayList<Series> series;
    ArrayList<Series> series2;
    LinearLayoutManager lManager;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SeriesFrag() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SeriesFrag.
     */
    // TODO: Rename and change types and number of parameters
    public static SeriesFrag newInstance(String param1, String param2) {
        SeriesFrag fragment = new SeriesFrag();
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
        View vista=inflater.inflate(R.layout.fragment_series, container, false);



        rv=  vista.findViewById(R.id.recycler);


        series= new ArrayList<>();
        series2= new ArrayList<>();

        lManager= new LinearLayoutManager(getActivity());

        rv.setLayoutManager(lManager);
        prepareSeries();

        adapter=new SeriesAdapter(series){
            @Override
            public void onVerClick(View v, int pos) {

                if(series.get(pos).getCheck()) {

                    Favoritos frag = new Favoritos();

                    Bundle bundle = new Bundle();
                    series2.add(series.get(pos));
                    bundle.putSerializable("Pass",series2);

                    frag.setArguments(bundle);
                    final FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.Favor, frag);
                    ft.commit();
                }
            }

            public void Contador(int cont){

            }

        };


        rv.setAdapter(adapter);

        return vista;
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

    public void prepareSeries(){
        series = new ArrayList<>();
        series.add(new Series("Smesh Bras 4", "2", R.drawable.smash4, " LUCINA MAKES THIS ONE PERFECT"));
        series.add(new Series("Smesh Bras brawl", "1",R.drawable.smash3, " The akward son of the family" ));
        series.add(new Series("Smesh Bras Melee", "1", R.drawable.smash2, " Hardcore mode"));
        series.add(new Series("Smesh bras 64", "1", R.drawable.smash, " Le classic"));

    }
}
