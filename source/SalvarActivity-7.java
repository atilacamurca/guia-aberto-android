private void carregar() {
   /* ... */
   contatoId = getIntent().getStringExtra(MainActivity._ID);
	if (contatoId != null) {
		carregarContato();
	} else {
		SharedPreferences preferencias = 
		      PreferenceManager.getDefaultSharedPreferences(this);
		spGrupo.setSelection(
		      Integer.parseInt(preferencias.getString("lista_grupos", "0")));
	}
}
