package com.example.managetournamentapp.view.Team.InvitePlayers.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Player;
import com.example.managetournamentapp.view.Team.InvitePlayers.fragment.PlayersListFragment.OnListFragmentInteractionListener;

import java.util.ArrayList;

public class PlayersListRecyclerViewAdapter extends RecyclerView.Adapter<PlayersListRecyclerViewAdapter.ViewHolder>  {

    private final ArrayList<Player> mValues;
    private final OnListFragmentInteractionListener mListener;


    public PlayersListRecyclerViewAdapter(ArrayList<Player> items, OnListFragmentInteractionListener listener){
        mValues = items;
        mListener = listener;
    }

    @Override
    public PlayersListRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_invite_players_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Player currentPlayer = mValues.get(position);
        holder.mItem = currentPlayer;
        holder.txtPlayerName.setText(currentPlayer.getName());

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
        public final TextView txtPlayerName;
        public final ImageButton btnSelect;
        public Player mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtPlayerName = view.findViewById(R.id.txt_player_name);
            btnSelect = view.findViewById(R.id.btn_select_player);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + txtPlayerName.getText() + "'";
        }
    }




}
