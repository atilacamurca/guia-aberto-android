public Cursor listar(String grupo) {
	String[] params = {grupo};
	return getReadableDatabase()
			.rawQuery("SELECT _id, nome, telefone, email, grupo FROM contato " +
					"WHERE grupo = ? ORDER BY nome", params);
}
