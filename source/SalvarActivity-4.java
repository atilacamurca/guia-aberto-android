/* ... */
public void ir() {
   btSalvar.setOnClickListener(new OnClickListener() {

      public void onClick(View view) {
         Contato contato = new Contato();
         contato.setNome(etNome.getText().toString());
         contato.setFone(etFone.getText().toString());
         contato.setEmail(etEmail.getText().toString());
         if (validar(contato)) {
				if (contatoId == null) {
					helper.criar(contato);
				} else {
					helper.atualizar(contatoId, contato);
				}
				finish();
			}
      }
   });
}

public boolean validar(Contato contato) {
	if (!Patterns.PHONE.matcher(contato.getTelefone()).matches()) {
		exibirMensagem("Telefone não é válido.");
		return false;
	}
	
	if (!Patterns.EMAIL_ADDRESS.matcher(contato.getEmail()).matches()) {
		exibirMensagem("E-mail não é válido.");
		return false;
	}
	return true;
}

public void exibirMensagem(String mensagem) {
 	Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
}
/* ... */
