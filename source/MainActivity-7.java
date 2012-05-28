/* ... */
public static final String _ID = "contatos.app._ID";

@Override
public void onCreate(Bundle icicle) {
   /* ... */
   configurar();
}

public void irParaSalvar() {
	irParaSalvar(null);
}

public void irParaSalvar(String id) {
	Intent intent = new Intent(MainActivity.this, SalvarActivity.class);
	if (id != null) {
		intent.putExtra(_ID, id);
	}
	startActivity(intent);
}

public void configurar() {
	listView.setOnItemClickListener(new OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View view,
				int position, long id) {
			irParaSalvar(String.valueOf(id));
		}
	});
}
