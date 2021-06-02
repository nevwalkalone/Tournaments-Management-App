package com.example.managetournamentapp.view.Tournament.ParticipatingTeams.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.managetournamentapp.R;
import com.example.managetournamentapp.domain.Team;
import com.example.managetournamentapp.view.Tournament.ParticipatingTeams.fragment.TeamsListFragment.OnListFragmentInteractionListener;
import java.util.ArrayList;


public class TeamsListRecyclerViewAdapter extends RecyclerView.Adapter<TeamsListRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<Team> mValues;
    private final OnListFragmentInteractionListener mListener;


    public TeamsListRecyclerViewAdapter(ArrayList<Team> items, OnListFragmentInteractionListener listener){
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_participating_teams_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Team currentTeam= mValues.get(position);
        holder.mItem = currentTeam;
        holder.txtTeamTitle.setText(currentTeam.getName());

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
        public final TextView txtTeamTitle;
        public final ImageButton btnSelect;
        public Team mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            txtTeamTitle = view.findViewById(R.id.txt_team_name);
            btnSelect = view.findViewById(R.id.btn_select_team);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + txtTeamTitle.getText() + "'";
        }
    }

}
