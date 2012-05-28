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
         ContentValues values = new ContentValues();
			values.put("nome", etNome.getText().toString());
			values.put("telefone", etTefone.getText().toString());
			values.put("email", etEmail.getText().toString());
         helper.criar(values);
         finish();
      }
   });
}

@Override
protected void onDestroy() {
   super.onDestroy();
   helper.close();
}
