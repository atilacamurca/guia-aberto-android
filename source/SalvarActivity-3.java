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
         Contato contato = new Contato();
         contato.setNome(etNome.getText().toString());
         contato.setFone(etFone.getText().toString());
         contato.setEmail(etEmail.getText().toString());
         if (contatoId == null) {
            helper.criar(contato);
         } else {
            helper.atualizar(contatoId, contato);
         }
         finish();
      }
   });
}
