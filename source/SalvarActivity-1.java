private EditText etNome, etFone, etEmail;
/* ... */

@Override
public void onCreate(Bundle icicle) {
   super.onCreate(icicle);
   setContentView(R.layout.save);
   carregar();
}

public void carregar() {
   etNome = (EditText) findViewById(R.id.etNome);
   etFone = (EditText) findViewById(R.id.etFone);
   etEmail = (EditText) findViewById(R.id.etEmail);
}
