/* ... */
private String contatoId = null;

public void carregar() {
	/* ... */
   contatoId = getIntent().getStringExtra(MainActivity._ID);
   if (contatoId != null) {
      carregarContato();
   }
}

public void carregarContato() {
   Cursor cursor = helper.ler(contatoId);
   cursor.moveToFirst();
   etNome.setText(helper.getNome(cursor));
   etFone.setText(helper.getFone(cursor));
   etEmail.setText(helper.getEmail(cursor));
   cursor.close();
}

public void ir() {
   btSalvar.setOnClickListener(new OnClickListener() {

      public void onClick(View view) {
         ContentValues values = new ContentValues();
			values.put("nome", etNome.getText().toString());
			values.put("telefone", etTefone.getText().toString());
			values.put("email", etEmail.getText().toString());
         if (contatoId == null) {
            helper.criar(values);
         } else {
            helper.atualizar(contatoId, values);
         }
         finish();
      }
   });
}
