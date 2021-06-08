package com.example.managetournamentapp.view.Tournament.RoundGames.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Game;
import java.util.ArrayList;


/**
 * This fragment represents a list of games
 * Every activity that contains this fragment must
 * implement the {@link OnListFragmentInteractionListener} interface
 */
public class GamesListFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 5;
    private OnListFragmentInteractionListener mListener;

    /**
     * Default constructor
     */
    public GamesListFragment() { }

    @SuppressWarnings("unused")
    /**
     *
     * @param columnCount  the number of columns in the list
     * @return the fragment
     */
    public static GamesListFragment newInstance(int columnCount) {
        GamesListFragment fragment = new GamesListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Creates the layout and initializes the fragment
     * @param savedInstanceState the Instance state
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    /**
     * @param inflater
     * @param container
     * @param savedInstanceState the Instance state
     * @return the  view
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_games_list, container, false);

        ArrayList<Game> gamesList = mListener.getGamesList();
        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new GamesListRecyclerViewAdapter(new ArrayList<Game>(gamesList), mListener));
        }
        return view;
    }

    /**
     * When the fragment attaches on an activity
     * @param context the context of the activity
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof GamesListFragment.OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    /**
     * When the fragment detaches from the activity
     */
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * Every activity that contains this fragment must implement this interface, so
     * that the activity or the other fragments, can interact with the fragment.
     */
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Game item);

        /**
         * get the games that will take place in this round
         * @return the ArrayList of games in this round
         */
        ArrayList<Game> getGamesList();
    }


}


