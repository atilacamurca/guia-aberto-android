/* ... */
private String grupo = null;

private void carregar() {
	listView = (ListView) findViewById(R.id.lv_contatos);
	grupo = getIntent().getStringExtra(GruposActivity._GRUPO);
	if (grupo == null) {
		model = helper.listar();
	} else {
		model = helper.listar(grupo);
	}
	startManagingCursor(model);
	adapter = new ContatoAdapter(model);
	listView.setAdapter(adapter);
}
