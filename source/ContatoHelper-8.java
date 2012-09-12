public Cursor listar(String grupo) {
	String[] params = {grupo};
	return getReadableDatabase()
			.rawQuery("SELECT _id, nome, fone, email, grupo FROM contato " +
					"WHERE grupo = ? ORDER BY nome", params);
}
