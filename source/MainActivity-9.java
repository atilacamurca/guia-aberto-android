/* ... */
private void configurar() {
	/* ... */
	listView.setOnItemLongClickListener(new OnItemLongClickListener() {
		public boolean onItemLongClick(AdapterView<?> parent, View view,
				int position, final long id) {
			/* ... */
			dialogo.setItems(itens, new OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					switch (which) {
					case 0: // editar
						irParaSalvar(String.valueOf(id));
						break;
					case 1: // deletar
					   AlertDialog.Builder confirmacao = 
					      new AlertDialog.Builder(MainActivity.this);
						confirmacao.setTitle("Deletar");
						confirmacao.setMessage("Deseja realmente deletar este contato?");
						confirmacao.setPositiveButton("Sim", new OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								int linhasAfetadas = helper.deletar(String.valueOf(id));
								if (linhasAfetadas > 0) {
									exibirMensagem("Contatos deletado com sucesso");
									carregar();
								} else {
									exibirMensagem("Falha ao deletar contato :(");
								}
							}
						});
						confirmacao.setNegativeButton("Não", null);
						confirmacao.show();
						break;
					}
				}
			});
			dialogo.show();
			return true;
		}
	});
}
