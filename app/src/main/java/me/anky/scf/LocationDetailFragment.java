package me.anky.scf;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class LocationDetailFragment extends Fragment implements OnMapReadyCallback {

    private double mCampusLat;
    private double mCampusLong;
    private String campusName;

    @BindView(R.id.pastor_family_IV)
    ImageView mPastorFamilyIV;

    @BindView(R.id.campus_name_TV)
    TextView mCampusNameTv;

    @BindView(R.id.pastors_names_tv)
    TextView mPastorsNamesTv;

    @BindView(R.id.meeting_time_TV)
    TextView mMeetingTimeTv;

    @BindView(R.id.meeting_venue_TV)
    TextView mMeetingVenueTv;

    @BindView(R.id.meeting_address_TV)
    TextView mMeetingAddressTv;

    @BindView(R.id.meeting_building_TV)
    TextView mMeetingBuildingTv;

    @BindView(R.id.pastor1_IV)
    ImageView mPastor1Iv;

    @BindView(R.id.pastor1_name_TV)
    TextView mPastor1NameTv;

    @BindView(R.id.pastor1_bg_tv)
    TextView mPastor1BgTv;

    @BindView(R.id.pastor2_iv_container)
    CardView mPastor2IvContainer;

    @BindView(R.id.pastor2_IV)
    ImageView mPastor2Iv;

    @BindView(R.id.pastor2_name_TV)
    TextView mPastor2NameTv;

    @BindView(R.id.pastor2_bg_tv)
    TextView mPastor2BgTv;

    @BindView(R.id.map)
    MapView mMapView;

    public LocationDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_location_detail, container, false);
        ButterKnife.bind(this, rootView);

//        // Get the screen width in pixels
//        DisplayMetrics metrics = new DisplayMetrics();
//        getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
//        int widthPixels = metrics.widthPixels;
//        int pastorFamilyIvHeight = (int)(widthPixels * 0.8);
//        mPastorFamilyIV.getLayoutParams().height = pastorFamilyIvHeight;

        Intent intent = getActivity().getIntent();
        if (intent != null) {
            MeetingLocation meetingLocation = intent.getParcelableExtra(LocationsFragment.LOCATION_INTENT_TEXT);

            int pastorFamilyImageRes = meetingLocation.getPastorFamilyImageRes();
            campusName = meetingLocation.getCampusName();
            String pastorsNames = meetingLocation.getPastorsNames();
            String meetingTime = meetingLocation.getMeetingTime();
            String meetingVenue = meetingLocation.getMeetingVanue();
            String meetingAddress = meetingLocation.getMeetingAddress();
            String meetingBuilding = meetingLocation.getMeetingBuilding(); // May be null
            mCampusLat = meetingLocation.getCampusLat();
            mCampusLong = meetingLocation.getCampusLong();
            String pastor1Name = meetingLocation.getPastor1Name();
            String pastor1Title = meetingLocation.getPastor1Title();
            String pastor1Bg = meetingLocation.getPastor1Bg();
            int pastor1ImageRes = meetingLocation.getPastor1ImageRes();
            String pastor2Name = meetingLocation.getPastor2Name(); // May be null
            String pastor2Title = meetingLocation.getPastor2Title(); // Null if pastor2Name is null
            String pastor2Bg = meetingLocation.getPastor2Bg(); // Null if pastor2Name is null
            int pastor2ImageRes = meetingLocation.getPastor2ImageRes(); // 0 if pastor2Name is null

            mPastorFamilyIV.setImageResource(pastorFamilyImageRes);
            mCampusNameTv.setText(campusName);
            mPastorsNamesTv.setText(pastorsNames);
            mMeetingTimeTv.setText(meetingTime);
            mMeetingVenueTv.setText(meetingVenue);
            mMeetingAddressTv.setText(meetingAddress);
            if (meetingBuilding != null) {
                mMeetingBuildingTv.setText(meetingBuilding);
            } else {
                mMeetingBuildingTv.setVisibility(View.GONE);
            }
            mPastor1Iv.setImageResource(pastor1ImageRes);
            mPastor1NameTv.setText(pastor1Name);
            mPastor1BgTv.setText(pastor1Bg);

            if (pastor2Name != null) {
                mPastor2Iv.setImageResource(pastor2ImageRes);
                mPastor2NameTv.setText(pastor2Name);
                mPastor2BgTv.setText(pastor2Bg);
            } else {
                mPastor2IvContainer.setVisibility(View.GONE);
                mPastor2NameTv.setVisibility(View.GONE);
                mPastor2BgTv.setVisibility(View.GONE);
            }
        }

        MapsInitializer.initialize(getActivity());
        mMapView.onCreate(savedInstanceState);
        mMapView.getMapAsync(this);

        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mMapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng campusLocation = new LatLng(mCampusLat, mCampusLong);
        googleMap.addMarker(new MarkerOptions().position(campusLocation)
                .title(campusName));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(campusLocation, 16));
        UiSettings settings = googleMap.getUiSettings();
        settings.setZoomControlsEnabled(true);
    }
}
