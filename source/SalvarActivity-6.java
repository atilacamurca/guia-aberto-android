public class SalvarActivity extends Activity {
	/* ... */
	private Spinner spGrupo = null;

	public void carregar() {
		/* ... */
		spGrupo = (Spinner) findViewById(R.id.spGrupo);
		ArrayAdapter<CharSequence> adapter = 
				ArrayAdapter.createFromResource(this,
						R.array.array_grupos, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spGrupo.setAdapter(adapter);
		/* antes de verificar o parâmetro contatoId */
	}

	public void carregarContato() {
		spGrupo.setSelection(helper.getGrupo(c));
		c.close();
	}

	public void ir() {
		btSalvar.setOnClickListener(new View.OnClickListener() {
			/* ... */
			contato.setGrupo(spGrupo.getSelectedItemPosition());
			/* antes de validar e salvar */
		}
	}
}
