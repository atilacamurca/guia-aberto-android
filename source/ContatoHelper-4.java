public Cursor ler(String id) {
	return getReadableDatabase().rawQuery("SELECT _id, nome, telefone, " +
      "email FROM contato WHERE _id = ?", new String[]{id});
}

public void atualizar(String id, ContentValues values) {
	getWritableDatabase().update("contato", values, "_id = ?", new String[]{id});
}
