package me.anky.scf;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
public class ContactUsFragment extends Fragment implements OnMapReadyCallback {

    @BindView(R.id.compose_email_tv)
    TextView mComposeEmailTv;

    @BindView(R.id.map)
    MapView mMapView;

    GoogleMap mMap;

    public ContactUsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_contact_us, container, false);
        ButterKnife.bind(this, rootView);

        MapsInitializer.initialize(getContext());
        mMapView.onCreate(savedInstanceState);
        mMapView.getMapAsync(this);

        // OnClickListener when "General Enquiry" is clicked
        mComposeEmailTv.setOnClickListener(composeEmailOCL);

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
        if (mMapView != null) {
            mMapView.onDestroy();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mMapView != null) {
            mMapView.onSaveInstanceState(outState);
        }
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

    private View.OnClickListener composeEmailOCL = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:" + getString(R.string.email_address_general_enquiry))); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.email_subject_general_enquiry));
            if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                startActivity(intent);
            }
        }
    };

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng ministryCentre = new LatLng(-27.642, 152.918);
        googleMap.addMarker(new MarkerOptions().position(ministryCentre)
                .title(getString(R.string.map_marker_for_ministry_centre)));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(ministryCentre, 16));
        UiSettings settings = googleMap.getUiSettings();
        settings.setZoomControlsEnabled(true);
    }
}