/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.settings.liquid.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceScreen;

import com.android.settings.liquid.SettingsPreferenceFragment;
import com.android.settings.R;

public class AboutLiquid extends SettingsPreferenceFragment {

    public static final String TAG = "About Liquid";

    Preference mSiteUrl;
    Preference mSourceUrl;
    Preference mIrcUrl;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.prefs_about);
        mSiteUrl = findPreference("liquid_website");
        mSourceUrl = findPreference("liquid_source");
        mIrcUrl = findPreference("liquid_irc");

    }

    @Override
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
        if (preference == mSiteUrl) {
            launchUrl("http://liquidsmoothroms.com/");
        } else if (preference == mSourceUrl) {
            launchUrl("http://github.com/LiquidSmoothROMs");
        } else if (preference == mIrcUrl) {
            launchUrl("http://webchat.freenode.net/?channels=liquids");
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference);
    }

    private void launchUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent donate = new Intent(Intent.ACTION_VIEW, uriUrl);
        getActivity().startActivity(donate);
    }
}
