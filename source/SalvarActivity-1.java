private EditText etNome, etTelefone, etEmail;
/* ... */

@Override
public void onCreate(Bundle icicle) {
   super.onCreate(icicle);
   setContentView(R.layout.activity_salvar);
   carregar();
}

private void carregar() {
   etNome = (EditText) findViewById(R.id.et_nome);
   etTelefone = (EditText) findViewById(R.id.et_telefone);
   etEmail = (EditText) findViewById(R.id.et_email);
}
