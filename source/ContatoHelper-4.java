public Cursor ler(String id) {
	String[] params = {id};
	return getReadableDatabase()
		.rawQuery("SELECT _id, nome, telefone, email FROM contato WHERE _id = ?",
			params);
}

public void atualizar(String id, Contato contato) {
	ContentValues cv = new ContentValues();
	cv.put("nome", contato.getNome());
	cv.put("telefone", contato.getTelefone());
	cv.put("email", contato.getEmail());
	String[] params = {id};
	getWritableDatabase().update("contato", cv, "_id = ?", params);
}
