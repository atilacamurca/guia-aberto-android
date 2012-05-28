public void criar(ContentValues values) {
	getWritableDatabase().insert("contato", "telefone", values);
}
