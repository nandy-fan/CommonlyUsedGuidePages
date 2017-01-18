package com.sortout.fjn.commonlyusedguidepages.commonguidepages;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sortout.fjn.commonlyusedguidepages.R;


public class GuideFragmentThree extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.fragment_3, container, false);
		view.findViewById(R.id.guidPage).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
					getActivity().finish();
			}
		});
		return view;
	}


}
