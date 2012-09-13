private EditText etNome, etFone, etEmail;
/* ... */

@Override
public void onCreate(Bundle icicle) {
   super.onCreate(icicle);
   setContentView(R.layout.salvar);
   carregar();
}

private void carregar() {
   etNome = (EditText) findViewById(R.id.et_nome);
   etTefone = (EditText) findViewById(R.id.et_telefone);
   etEmail = (EditText) findViewById(R.id.et_email);
}
