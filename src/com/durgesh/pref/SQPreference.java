/**Copyright (c) 2013 Durgesh Trivedi

  This program is free software; you can redistribute it and/or modify
  it under the terms of the GNU General Public License as published by
  the Free Software Foundation; either version 3 of the License, or
  (at your option) any later version.

  This program is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
  GNU General Public License for more details.

  You should have received a copy of the GNU General Public License
  along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.durgesh.pref;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;

import com.durgesh.R;

/**
 * Display Preference Screen of the App
 * 
 * @author durgesht
 */
public class SQPreference extends PreferenceActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);

        String ver = "unknown";
        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.durgesh", PackageManager.GET_META_DATA);
            ver = info.versionName;
        } catch (Exception e) {
        }

        Preference version = findPreference("pref_version");
        version.setSummary(getString(R.string.pref_version_summary, ver));

        findPreference("pref_help").setOnPreferenceClickListener(new OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                triggerHelp();
                return false;
            }
        });
    }

    private void triggerHelp() {
        // Intent intent = new Intent(this, HelpDoc.class);
        // intent.putExtra("type", "help");
        // startActivity(intent);
    }
}