package com.example.managetournamentapp.view.Tournament.RoundGames.fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Game;
import com.example.managetournamentapp.view.Tournament.RoundGames.fragment.GamesListFragment.OnListFragmentInteractionListener;

import java.util.ArrayList;


public class GamesListRecyclerViewAdapter extends RecyclerView.Adapter<GamesListRecyclerViewAdapter.ViewHolder> {
    private final ArrayList<Game> mValues;
    private final OnListFragmentInteractionListener mListener;

    public GamesListRecyclerViewAdapter(ArrayList<Game> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_games_list_item, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Game currentGame = mValues.get(position);
        holder.mItem = currentGame;

        if (currentGame.getTeamA().getName() != null) {
            holder.txtTeamA.setText(currentGame.getTeamA().getName());
            holder.txtTeamB.setText(currentGame.getTeamB().getName());
            holder.scoreA.setText(String.valueOf(currentGame.getScoreA()));
            holder.scoreB.setText(String.valueOf(currentGame.getScoreB()));
        } else {
            holder.txtTeamA.setText("To Be Announced");
            holder.txtTeamB.setText("To Be Announced");
            holder.scoreA.setText(" ");
            holder.scoreB.setText(" ");
        }
        holder.date.setText(currentGame.getDate().toString());

        holder.btnSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView txtTeamA;
        public final TextView txtTeamB;
        public final EditText scoreA;
        public final EditText scoreB;
        public final TextView date;
        public final LinearLayout btnSelect;
        public Game mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtTeamA = view.findViewById(R.id.txt_teamA);
            txtTeamB = view.findViewById(R.id.txt_teamB);
            scoreA = view.findViewById(R.id.scoreA);
            scoreB = view.findViewById(R.id.scoreB);
            date = view.findViewById(R.id.txt_date);
            btnSelect = view.findViewById(R.id.game_selected_btn);

        }

        @Override
        public String toString() {
            return super.toString() + " '" + txtTeamA.getText() + "'" + txtTeamB.getText();
        }
    }


}
