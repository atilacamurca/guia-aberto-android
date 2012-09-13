/* ... */
private void configurar() {
	listView.setOnItemLongClickListener(new OnItemLongClickListener() {
		public boolean onItemLongClick(AdapterView<?> parent, View view,
				final int position, final long id) {
			final String[] itens = {"Editar", "Deletar", "Chamar",
			    "Enviar e-mail"};
			/* ... */
			dialogo.setItems(itens, new OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					switch (which) {
					   /* ... */
					   case 3: // enviar e-mail
							model.moveToPosition(position);
							Intent email = new Intent(Intent.ACTION_SEND);
							email.setType("plain/text");
							email.putExtra(Intent.EXTRA_EMAIL, 
							   new String[]{ helper.getEmail(model) });
							startActivity(Intent.createChooser(email, 
							   "Enviar e-mail..."));
							break;
					}
				}
			});
			dialogo.show();
			return true;
		}
	});
}
