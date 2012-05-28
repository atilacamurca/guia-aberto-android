public class ContatoHelper extends SQLiteOpenHelper {
	/* ... */
	private static final int VERSAO = 2;
	private static final String TAG = "ContatoHelper";

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE contato ( _id INTEGER PRIMARY KEY AUTOINCREMENT," +
				"nome TEXT, telefone TEXT, email TEXT," +
				// versao 2
				"grupo INTEGER NOT NULL DEFAULT 0 );");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(TAG, "Atualizando banco de dados da versão "
				+ oldVersion + " para " + newVersion + ".");
		if (newVersion > oldVersion) {
			switch (oldVersion) {
			case 2:
				try {
					db.execSQL("ALTER TABLE contato " +
							"ADD COLUMN grupo INTEGER NOT NULL DEFAULT 0");
				} catch (SQLException e) {
					Log.e(TAG, "Erro ao executar SQL: ", e);
				}
			default:
				Log.w(TAG, "Versão desconhecida: " + oldVersion +
				   ". Criando novo banco de dados.");
            db.execSQL("DROP TABLE IF EXISTS contato");
            onCreate(db);
			}
		}
	}
}
