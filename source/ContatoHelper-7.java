public class ContatoHelper extends SQLiteOpenHelper {
	/* ... */
	public Cursor listar() {
		return getReadableDatabase()
			.rawQuery("SELECT _id, nome, telefone, email, grupo " +
					"FROM contato ORDER BY nome", null);
	}

	public int getGrupo(Cursor c) {
		return c.getInt(4);
	}

	public Cursor ler(String id) {
		String[] params = {id};
		return getReadableDatabase()
			.rawQuery("SELECT _id, nome, telefone, email, grupo " +
					"FROM contato WHERE _id = ?", params);
	}
}
