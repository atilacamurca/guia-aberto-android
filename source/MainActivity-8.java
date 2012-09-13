/* ... */
private void configurar() {
	/* ... */
	listView.setOnItemLongClickListener(new OnItemLongClickListener() {
		public boolean onItemLongClick(AdapterView<?> parent, View view,
				int position, final long id) {
			final String[] itens = {"Editar", "Deletar"};
			AlertDialog.Builder dialogo = 
			   new AlertDialog.Builder(MainActivity.this);
			dialogo.setTitle("Opções");
			dialogo.setItems(itens, new OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					switch (which) {
					case 0: // editar
						irParaSalvar(String.valueOf(id));
						break;
					case 1: // deletar
						int linhasAfetadas = helper.deletar(String.valueOf(id));
						if (linhasAfetadas > 0) {
							exibirMensagem("Contatos deletado com sucesso");
							carregar();
						} else {
							exibirMensagem("Falha ao deletar contato :(");
						}
						break;
					}
				}
			});
			dialogo.show();
			return true;
		}
	});
}

private void exibirMensagem(String mensagem) {
   Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
}
