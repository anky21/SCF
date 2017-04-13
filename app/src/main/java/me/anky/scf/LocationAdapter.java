package me.anky.scf;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Anky An on 29/03/2017.
 * anky25@gmail.com
 */

/**
 * {@link LocationAdapter} is an {@link MeetingLocation} that provides the layout for each item
 * of a list of {@link MeetingLocation} objects
 */
public class LocationAdapter extends ArrayAdapter<MeetingLocation> {

    public LocationAdapter(@NonNull Context context, List<MeetingLocation> meetingLocations) {
        super(context, 0, meetingLocations);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.location_list_item, parent, false);
        }

        ImageView pastorFamilyImageIV = (ImageView) listItemView.findViewById(R.id.pastor_family_IV);
        TextView campusNameTV = (TextView) listItemView.findViewById(R.id.campus_name_TV);
        TextView meetingTimeTV = (TextView) listItemView.findViewById(R.id.meeting_time_TV);
        TextView meetingVenueTV = (TextView) listItemView.findViewById(R.id.meeting_venue_TV);
        TextView meetingAddressTV = (TextView) listItemView.findViewById(R.id.meeting_address_TV);

        MeetingLocation currentMeetingLocation = getItem(position);

        int pastorFamilyImageResID = currentMeetingLocation.getPastorFamilyImageRes();
        pastorFamilyImageIV.setImageResource(pastorFamilyImageResID);

        // Get the screen width in pixels
        DisplayMetrics metrics = getContext().getResources().getDisplayMetrics();

//        int widthPixels = metrics.widthPixels;
//        int pastorFamilyIvHeight = (int)(widthPixels * 0.8 * 1 / getContext()
//                .getResources().getInteger(R.integer.numColumnsGridView));
//        pastorFamilyImageIV.getLayoutParams().height = pastorFamilyIvHeight;

        String campusName = currentMeetingLocation.getCampusName();
        campusNameTV.setText(campusName);

        String meetingTime = currentMeetingLocation.getMeetingTime();
        meetingTimeTV.setText(meetingTime);

        String meetingVenue = currentMeetingLocation.getMeetingVanue();
        meetingVenueTV.setText(meetingVenue);

        String meetingAddress = currentMeetingLocation.getMeetingAddress();
        meetingAddressTV.setText(meetingAddress);

        return listItemView;
    }
}
