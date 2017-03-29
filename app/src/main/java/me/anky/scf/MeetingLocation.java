package me.anky.scf;

/**
 * Created by Anky An on 29/03/2017.
 * anky25@gmail.com
 */

public class MeetingLocation {

    private int mPastorFamilyImageRes;
    private String mCampusName;
    private String mPastorsNames;
    private String mMeetingTime;
    private String mMeetingVenue;
    private String mMeetingAddress;
    private String mMeetingBuilding;
    private String mPastor1Name;
    private String mPastor1Title;
    private String mPastor1Bg;
    private int mPastor1ImageRes;
    private String mPastor2Name;
    private String mPastor2Title;
    private String mPastor2Bg;
    private int mPastor2ImageRes;


    /**
     * Construct a new {@link MeetingLocation} object
     *
     * @param pastorFamilyImageRes is the image name for the pastor family image
     * @param campusName           is the name of the campus
     * @param pastorsNames         is the names of pastors for this campus
     * @param meetingTime          is the time for the weekly meeting
     * @param meetingVenue         is the venue for the weekly meeting
     * @param meetingAddress       is the address for the meeting
     * @param meetingBuilding      is the building name for the meeting
     * @param pastor1Name          is the name for pastor 1
     * @param pastor1Title         is the title for pastor 1
     * @param pastor1Bg            is the background for pastor 1
     * @param pastor1ImageRes      is the image name for pastor 1
     * @param pastor2Name          is the name for pastor 2
     * @param pastor2Title         is the title for pastor 2
     * @param pastor2Bg            is the background for pastor 2
     * @param pastor2ImageRes      is the image name for pastor 2
     */
    public MeetingLocation(int pastorFamilyImageRes, String campusName, String pastorsNames,
                           String meetingTime, String meetingVenue, String meetingAddress,
                           String meetingBuilding, String pastor1Name, String pastor1Title,
                           String pastor1Bg, int pastor1ImageRes, String pastor2Name,
                           String pastor2Title, String pastor2Bg, int pastor2ImageRes) {
        mPastorFamilyImageRes = pastorFamilyImageRes;
        mCampusName = campusName;
        mPastorsNames = pastorsNames;
        mMeetingTime = meetingTime;
        mMeetingVenue = meetingVenue;
        mMeetingAddress = meetingAddress;
        mMeetingBuilding = meetingBuilding;
        mPastor1Name = pastor1Name;
        mPastor1Title = pastor1Title;
        mPastor1Bg = pastor1Bg;
        mPastor1ImageRes = pastor1ImageRes;
        mPastor2Name = pastor2Name;
        mPastor2Title = pastor2Title;
        mPastor2Bg = pastor2Bg;
        mPastor2ImageRes = pastor2ImageRes;
    }

    public int getPastorFamilyImageRes() {
        return mPastorFamilyImageRes;
    }

    public String getCampusName() {
        return mCampusName;
    }

    public String getPastorsNames() {
        return mPastorsNames;
    }

    public String getMeetingTime() {
        return mMeetingTime;
    }

    public String getMeetingVanue() {
        return mMeetingVenue;
    }

    public String getMeetingAddress() {
        return mMeetingAddress;
    }

    public String getMeetingBuilding() {
        return mMeetingBuilding;
    }

    public String getPastor1Name() {
        return mPastor1Name;
    }

    public String getPastor1Title() {
        return mPastor1Title;
    }

    public String getPastor1Bg() {
        return mPastor1Bg;
    }

    public int getPastor1ImageRes() {
        return mPastor1ImageRes;
    }

    public String getPastor2Name() {
        return mPastor2Name;
    }

    public String getPastor2Title() {
        return mPastor2Title;
    }

    public String getPastor2Bg() {
        return mPastor2Bg;
    }

    public int getPastor2ImageRes() {
        return mPastor2ImageRes;
    }
}
