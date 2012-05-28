public Cursor ler(String id) {
	String[] params = {id};
	return getReadableDatabase()
		.rawQuery("SELECT _id, nome, telefone, email FROM contato WHERE _id = ?",
			params);
}

public void atualizar(String id, ContentValues values) {
	String[] params = {id};
	getWritableDatabase().update("contato", values, "_id = ?", params);
}
