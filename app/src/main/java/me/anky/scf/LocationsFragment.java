package me.anky.scf;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class LocationsFragment extends Fragment {

    public static final String LOCATION_INTENT_TEXT = "location_data";
    
    private LocationAdapter mLocationAdapter;

    @BindView(R.id.location_grid_view)
    GridView mLocationGridView;

    public LocationsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_locations, container, false);
        ButterKnife.bind(this, rootView);

        MeetingLocation[] meetingLocations = {
                new MeetingLocation(R.drawable.springfield_campus, "Springfield Campus", "Ps. John & Deb van Bennekom",
                        "9:30am, Sunday Mornings", "Woodcrest State College", "38 Nev Smith Dr, " +
                        "Springfield", "Senior School Auditorium", -27.652, 152.922, "Ps. John & Deb van Bennekom",
                        "Church Elders and Campus Pastors", "John and Deborah were part of the planting team for SCF 20 years ago and they continue to be passionate about pastoring and developing people as well as connecting new people to Jesus in our community. They love when the Church is mobilized locally and globally. \n\n" +
                        "Family is a great joy with five adult children and they enjoy sailing, walking and being active in this beautiful nation. John is a bit of an Australian history buff and Deb is involved in leadership development here and in Central Asia.",
                        R.drawable.pastor_bennekom, null, null, null, 0),
                new MeetingLocation(R.drawable.augusta_campus, "Augusta Campus", "Ps. Mark & Aime’e Barnes and Ps. Phil Cutcliffe",
                        "9:30am, Sunday Mornings", "Augusta State School", "60-100 Brittains Rd, Augustine Heights", "Performance Hall", -27.655, 152.878, "Ps. Mark & Aime'e Barnes",
                        "Pastor", "Aime'e and Mark joined the Springfield Christian Family Team in 2008 and were appointed as Augusta Campus Pastors in 2013. Their passion is seeing people discover Gods love and the freedom that comes with knowing Jesus.\n" +
                        "\n" + "Mark works full time as a finance broker with Loan Market Greater Springfield and Aime'e shares her time between the church, study and a dental practice in Oxley. They have two children, Savannah and Noah. The family enjoy stand up paddle boarding and the beach.",
                        R.drawable.pastor_ormsby, "Ps. Phil Cutcliffe", "Pastor", "Ps. Phil and his wife, Julianne, have been pioneering the campuses of Springfield Christian Family from it's foundation in May 1996. They are passionate about loving God, their family, the Church family and Greater Springfield Community. Phil serves as the Pioneer Pastor, Church Elder and Director of SCF's charity arm Westside Community Care. Julianne serves as a Church Elder and Counsellor. Phil and Julianne have 4 grown children also serving in God's family: Ashleigh, Rebekah, Nathan and Jennifer. Phil enjoys running, playing the trumpet and gathering people back to God. Julianne enjoys reading and keeping all the family relationships strong.\n" +
                        "\n" + "Ps. Phil pastors across both Lakes and Augusta campuses.", R.drawable.pastor_cutcliffe),
                new MeetingLocation(R.drawable.springfield_lakes_campus, "Springfield Lakes Campus", "Ps. Damon Ormsby and Ps. Phil Cutcliffe",
                        "9:00am, Sunday Mornings", "Level 2 - Springfield Tower", "145 Sinnathamby Blvd, Springfield Central", null, -27.682, 152.899, "Ps. Damon Ormsby",
                        "Pastor", "Having moved from New Zealand, Damon and his wife, Lena, joined the Springfield Christian Family Church in October 2009. In 2016 Damon resigned from his career as a Police Officer to Pastor the Lakes Campus full time. His passion is not only seeing people come to Christ, but growing in the freedom and fullness of life that He brings.\n" +
                        "\n" + "Damon and Lena have 5 children, Kee-Lin, Shaye, Kalea, Jeiel, Michal, and an English Bull Terrier named Zoey. They enjoy time away at the beach together as a family and share a musical interest.",
                        R.drawable.pastor_barnes, "Ps. Phil Cutcliffe", "Pastor", "Ps. Phil and his wife, Julianne, have been pioneering the campuses of Springfield Christian Family from it's foundation in May 1996. They are passionate about loving God, their family, the Church family and Greater Springfield Community. Phil serves as the Pioneer Pastor, Church Elder and Director of SCF's charity arm Westside Community Care. Julianne serves as a Church Elder and Counsellor. Phil and Julianne have 4 grown children also serving in God's family: Ashleigh, Rebekah, Nathan and Jennifer. Phil enjoys running, playing the trumpet and gathering people back to God. Julianne enjoys reading and keeping all the family relationships strong.\n" +
                        "\n" + "Ps. Phil pastors across both Lakes and Augusta campuses.", R.drawable.pastor_cutcliffe),
                new MeetingLocation(R.drawable.springfield_central_campus, "Springfield Central Campus", "Ps. Stephen & Joanne Grosser",
                        "9:00am, Sunday Mornings", "Springfield Central State High School ", "90 Parkland Dr, Springfield Central", "Lecture Theatre", -27.690, 152.911, "Ps. Stephen & Joanne Grosser",
                        "Pastors", "After years of working in the business-world, Stephen and Joanne joined the team at Springfield Christian Family Church in January 2012. Their passion is delivering the message of God in creative ways and seeing people fulfill their God given potential.\n" +
                        "\n" + "Apart from spending time with their children: Immogen, Caeleb, Lauren and Matthew, Stephen enjoys tech gadgets and photography while Joanne loves hanging out with friends over a meal or catching a movie.",
                        R.drawable.pastor_grosser, null, null, null, 0),
        };

        mLocationAdapter = new LocationAdapter(getContext(), Arrays.asList(meetingLocations));

        mLocationGridView.setAdapter(mLocationAdapter);

        mLocationGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MeetingLocation currentMeetingLocation = mLocationAdapter.getItem(position);
                Intent intent = new Intent(getContext(), LocationDetailActivity.class);
                intent.putExtra(LOCATION_INTENT_TEXT, currentMeetingLocation);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
