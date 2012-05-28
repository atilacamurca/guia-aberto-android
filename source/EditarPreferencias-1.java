package app.contatos.view;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import app.contatos.R;

public class EditarPreferencias extends PreferenceActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.preferencias);
	}
}
