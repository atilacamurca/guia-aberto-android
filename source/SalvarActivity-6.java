public class SalvarActivity extends Activity {
	/* ... */
	private Spinner spGrupo = null;

	private void carregar() {
		/* ... */
		spGrupo = (Spinner) findViewById(R.id.sp_grupo);
		ArrayAdapter<CharSequence> adapter = 
				ArrayAdapter.createFromResource(this,
						R.array.array_grupos, android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spGrupo.setAdapter(adapter);
		/* antes de verificar o parâmetro contatoId */
	}

	private void carregarContato() {
		spGrupo.setSelection(helper.getGrupo(c));
		c.close();
	}

	private void ir() {
		btSalvar.setOnClickListener(new View.OnClickListener() {
			/* ... */
			contato.setGrupo(spGrupo.getSelectedItemPosition());
			/* antes de validar e salvar */
		}
	}
}
