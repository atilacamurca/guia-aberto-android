/* ... */
public static final String _ID = "contatos.app._ID";

@Override
public void onCreate(Bundle icicle) {
   /* ... */
   configurar();
}

private void irParaSalvar() {
	irParaSalvar(null);
}

private void irParaSalvar(String id) {
	Intent intent = new Intent(MainActivity.this, SalvarActivity.class);
	if (id != null) {
		intent.putExtra(_ID, id);
	}
	startActivity(intent);
}

private void configurar() {
	listView.setOnItemClickListener(new OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View view,
				int position, long id) {
			irParaSalvar(String.valueOf(id));
		}
	});
}
