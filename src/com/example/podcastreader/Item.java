package com.example.podcastreader;

public class Item {
	// �L���̃^�C�g��
	private CharSequence mTitle;
	// �L���̖{��
	private CharSequence mDescription;

	public Item() {
		mTitle = "";
		mDescription = "";
	}

	public CharSequence getDescription() {
		return mDescription;
	}

	public void setDescription(CharSequence description) {
		mDescription = description;
	}

	public CharSequence getTitle() {
		return mTitle;
	}

	public void setTitle(CharSequence title) {
		mTitle = title;
	}
}