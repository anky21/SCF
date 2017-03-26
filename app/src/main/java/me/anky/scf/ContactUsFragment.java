package me.anky.scf;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUsFragment extends Fragment {

    @BindView(R.id.compose_email_tv)
    TextView mComposeEmailTv;

    public ContactUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_contact_us, container, false);
        ButterKnife.bind(this, rootView);

        // OnClickListener when "General Enquiry" is clicked
        mComposeEmailTv.setOnClickListener(composeEmailOCL);

        return rootView;
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

}
