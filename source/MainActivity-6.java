/* ... */
private Cursor model = null;
private ContatoAdapter adapter = null;
private ListView listView = null;

@Override
public void onCreate(Bundle icicle) {
	/* ... */
	helper = new ContatoHelper(this);
	carregar();
}

public void carregar() {
	listView = (ListView) findViewById(R.id.contatos);
	model = helper.listar();
	startManagingCursor(model);
	adapter = new ContatoAdapter(model);
	listView.setAdapter(adapter);
}

@Override
protected void onDestroy() {
   super.onDestroy();
   helper.close();
}
