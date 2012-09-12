public static final String _GRUPO = "contatos.app._GRUPO";

@Override
public void onCreate(Bundle savedInstanceState) {
	/* ... */
	configurar();
}

private void configurar() {
	grid.setOnItemClickListener(new OnItemClickListener() {
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			irPara(MainActivity.class, String.valueOf(position));
		}
	});
}

private void irPara(Class<?> clazz, String id) {
	Intent intent = new Intent(GruposActivity.this, clazz);
	if (id != null) {
		intent.putExtra(_GRUPO, id);
	}
	startActivity(intent);
}
