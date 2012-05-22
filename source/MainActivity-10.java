/* ... */
public void configurar() {
	listView.setOnItemLongClickListener(new OnItemLongClickListener() {
		public boolean onItemLongClick(AdapterView<?> parent, View view,
				final int position, final long id) {
			final String[] itens = {"Editar", "Deletar", "Chamar"};
			/* ... */
			dialogo.setItems(itens, new OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					switch (which) {
					   /* ... */
					   case 2: // chamar
							model.moveToPosition(position);
							startActivity(new Intent(Intent.ACTION_CALL,
											Uri.parse("tel:" + helper.getTelefone(model))
										 )
							);
							break;
					}
				}
			});
			dialogo.show();
			return true;
		}
	});
}
