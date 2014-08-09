public long criar(ContentValues values) {
	return getWritableDatabase().insert(TABLE_NAME, ContatoColumns.NOME, values);
}
