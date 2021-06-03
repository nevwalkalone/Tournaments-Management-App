package com.example.managetournamentapp.view.Organizer.OrganizerTournaments.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Tournament;
import com.example.managetournamentapp.view.Organizer.OrganizerTournaments.fragment.TournamentListFragment.OnListFragmentInteractionListener;


import java.util.ArrayList;

public class TournamentListRecyclerViewAdapter extends RecyclerView.Adapter<TournamentListRecyclerViewAdapter.ViewHolder>  {

    private final ArrayList<Tournament> mValues;
    private final OnListFragmentInteractionListener mListener;


    public TournamentListRecyclerViewAdapter(ArrayList<Tournament> items, OnListFragmentInteractionListener listener){
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_tournaments_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Tournament currentTournament = mValues.get(position);
        holder.mItem = currentTournament;
        holder.txtTournamentTitle.setText(currentTournament.getTitle());

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
        public final TextView txtTournamentTitle;
        public final ImageButton btnSelect;
        public Tournament mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtTournamentTitle = view.findViewById(R.id.txt_tournament_title);
            btnSelect = view.findViewById(R.id.btn_select_tournament);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + txtTournamentTitle.getText() + "'";
        }
    }

}
