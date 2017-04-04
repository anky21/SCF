package me.anky.scf;


import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {

    @BindView(R.id.event_recycler_view)
    RecyclerView mRecyclerView;

    private StaggeredGridLayoutManager mLayoutManager;

    //Getting reference to Firebase Database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mDatabaseReference = database.getReference();
    private FirebaseRecyclerAdapter<ChurchEvent, EventHolder> mAdapter;

    public EventsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_events, container, false);
        ButterKnife.bind(this, rootView);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new StaggeredGridLayoutManager(getResources().getInteger(R.integer.numColumnsGridView), StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new FirebaseRecyclerAdapter<ChurchEvent, EventHolder>(ChurchEvent.class,
                R.layout.event_list_item, EventHolder.class, mDatabaseReference.child("events").getRef()) {
            @Override
            protected void populateViewHolder(EventHolder viewHolder, ChurchEvent model, int position) {
                viewHolder.setImage(model.getImageUrl());
                viewHolder.setTitle(model.getTitle());
                viewHolder.setDate(model.getDate());
                viewHolder.setLocation(model.getLocation());
                viewHolder.setTime(model.getTime());
                viewHolder.setContext(model.getEventContext());
            }
        };
        mRecyclerView.setAdapter(mAdapter);

        return rootView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mAdapter.cleanup();
    }

    // ViewHolder for Firebase UI
    public static class EventHolder extends RecyclerView.ViewHolder {
        private final ImageView mEventImage;
        private final TextView mTitle;
        private final TextView mDate;
        private final TextView mLocation;
        private final TextView mTime;
        private final TextView mContext;

        public EventHolder(View v) {
            super(v);
            mEventImage = (ImageView) v.findViewById(R.id.iv_event);
            mTitle = (TextView) v.findViewById(R.id.tv_event_title);
            mDate = (TextView) v.findViewById(R.id.tv_event_date);
            mLocation = (TextView) v.findViewById(R.id.tv_event_location);
            mTime = (TextView) v.findViewById(R.id.tv_event_time);
            mContext = (TextView) v.findViewById(R.id.tv_event_context);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), R.string.add_to_calendar_message,
                            Toast.LENGTH_SHORT).show();
                }
            });

            v.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_INSERT)
                            .setData(CalendarContract.Events.CONTENT_URI)
                            .putExtra(CalendarContract.Events.TITLE, mTitle.getText().toString())
                            .putExtra(CalendarContract.Events.EVENT_LOCATION, mLocation.getText().toString());
                    if (intent.resolveActivity(v.getContext().getPackageManager()) != null) {
                        v.getContext().startActivity(intent);
                    }
                    return true;
                }
            });
        }

        public void setTitle(String title) {
            mTitle.setText(title);
        }

        public void setDate(String date) {
            mDate.setText(date);
        }

        public void setLocation(String location) {
            mLocation.setText(location);
        }

        public void setTime(String time) {
            mTime.setText(time);
        }

        public void setContext(String eventContext) {
            mContext.setText(eventContext);
        }

        public void setImage(String imageUrl) {
            Glide.with(mEventImage.getContext())
                    .load(imageUrl)
                    .into(mEventImage);
        }
    }
}
