package me.anky.scf;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.facebook.stetho.Stetho;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    private DatabaseReference mEventsDatabaseReference;
    private TabLayout tabLayout;
    private int[] tabIcons = {
            R.drawable.tab_icon_events,
            R.drawable.tab_icon_locations,
            R.drawable.tab_icon_contact_us
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEventsDatabaseReference = FirebaseDatabase.getInstance().getReference().child("events");

        // Write events into the database
        ChurchEvent churchEvent1 = new ChurchEvent("Good Friday Morning", "Friday, 14 April",
                "20170414", "Senior Auditorium: Woodcrest State College", "9:30am - 1 Hour Service",
                "Open to the community, this is one of two services remembering the death of Jesus.",
                "https://firebasestorage.googleapis.com/v0/b/springfieldchristianfamily.appspot.com/o/events%2Fgood_friday_morning.JPG?alt=media&token=9b806d48-b8ce-45fe-8d81-bd3c8cfee771");

        ChurchEvent churchEvent2 = new ChurchEvent("Easter Sunday - SCF UNITED Service", "Sunday, 16 April",
                "20170416", "Senior Auditorium: Woodcrest State College", "9:30am",
                "Register your kids at scfchurch.org.au/sonkidz",
                "https://firebasestorage.googleapis.com/v0/b/springfieldchristianfamily.appspot.com/o/events%2Feaster_sunday.JPG?alt=media&token=c77fae8b-5fd4-4563-a2b6-fb25bd342d4e");

        ChurchEvent churchEvent3 = new ChurchEvent("LIFT Night", "Tuesday, 18 April",
                "20170418", "Woodcrest College Staff Common Room", "7:15pm",
                "A training night for leaders and aspiring leaders in the church, marketplace or community.",
                "https://firebasestorage.googleapis.com/v0/b/springfieldchristianfamily.appspot.com/o/events%2Flift.JPG?alt=media&token=cbad5253-f90b-4d9c-8b7c-1cc6132b047a");

        ChurchEvent churchEvent4 = new ChurchEvent("Youth Retreat - Limitless Leaders", "Friday, 21 April",
                "20170421", "Drop Off/Pick Up: 389 Old Logan Road", "Friday 5pm - Sunday 1:30pm",
                "A retreat for teenagers between 12 - 18 years of age | $100",
                "https://firebasestorage.googleapis.com/v0/b/springfieldchristianfamily.appspot.com/o/events%2Flimitless_leaders.JPG?alt=media&token=9cad7bac-7cf3-415a-86fa-646de2d626cf");

        ChurchEvent churchEvent5 = new ChurchEvent("Worship Without Borders", "Sunday, 30 April",
                "20170430", "Woodcrest College Auditorium", "6 - 7pm",
                "One hour of worship with the family!",
                "https://firebasestorage.googleapis.com/v0/b/springfieldchristianfamily.appspot.com/o/events%2Fworship_without_borders.JPG?alt=media&token=4e18c14a-53a7-496c-a68c-83e4de058c73");

        mEventsDatabaseReference.push().setValue(churchEvent1);
        mEventsDatabaseReference.push().setValue(churchEvent2);
        mEventsDatabaseReference.push().setValue(churchEvent3);
        mEventsDatabaseReference.push().setValue(churchEvent4);
        mEventsDatabaseReference.push().setValue(churchEvent5);

        // Debugging: testing databases and other data
        Stetho.initializeWithDefaults(this);

        // Find the view pager to allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create an adapter that controls the display of fragments
        MainScreenFragmentAdapter adapter = new MainScreenFragmentAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Find the tab layout that shows the tabs
        tabLayout = (TabLayout) findViewById(R.id.main_screen_tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText(getString(R.string.tab_events_title));
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[0], 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText(getString(R.string.tab_locations_title));
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[1], 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText(getString(R.string.tab_contact_us_title));
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[2], 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);
    }
}
