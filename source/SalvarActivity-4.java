/* ... */
public void ir() {
   btSalvar.setOnClickListener(new OnClickListener() {

      public void onClick(View view) {
         ContentValues values = new ContentValues();
			values.put("nome", etNome.getText().toString());
			values.put("telefone", etTefone.getText().toString());
			values.put("email", etEmail.getText().toString());
         if (validar(values)) {
				if (contatoId == null) {
					helper.criar(values);
				} else {
					helper.atualizar(contatoId, values);
				}
				finish();
			}
      }
   });
}

public boolean validar(ContentValues values) {
	if (!Patterns.PHONE.matcher(values.getAsString("telefone")).matches()) {
		exibirMensagem("Telefone não é válido.");
		return false;
	}
	
	if (!Patterns.EMAIL_ADDRESS.matcher(values.getAsString("email")).matches()) {
		exibirMensagem("E-mail não é válido.");
		return false;
	}
	return true;
}

public void exibirMensagem(String mensagem) {
 	Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
}
/* ... */
