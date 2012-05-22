/* ... */
private ContatoHelper helper;
private Button btSalvar;

@Override
public void onCreate(Bundle icicle) {
	/* ... */
   helper = new ContatoHelper(this);
   carregar();
   ir();
   /* ... */
}

public void carregar() {
	/* ... */
   btSalvar = (Button) findViewById(R.id.btSalvar);
}

public void ir() {
   btSalvar.setOnClickListener(new OnClickListener() {

      public void onClick(View view) {
         Contato contato = new Contato();
         contato.setNome(etNome.getText().toString());
         contato.setFone(etFone.getText().toString());
         contato.setEmail(etEmail.getText().toString());
         helper.criar(contato);
         finish();
      }
   });
}

@Override
protected void onDestroy() {
   super.onDestroy();
   helper.close();
}
