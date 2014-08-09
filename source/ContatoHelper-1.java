public class ContatoHelper extends AbstractHelper {

    private static final String TABLE_NAME = "contato";

    public ContatoHelper(Context context) {
        super(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        StringBuilder builder = new StringBuilder();
        builder.append("CREATE TABLE ");
        builder.append(TABLE_NAME);
        builder.append(" (");
        builder.append(ContatoColumns._ID);
        builder.append(" INTEGER PRIMARY KEY AUTOINCREMENT, ");
        builder.append(ContatoColumns.NOME);
        builder.append(" TEXT, ");
        builder.append(ContatoColumns.TELEFONE);
        builder.append(" TEXT, ");
        builder.append(ContatoColumns.EMAIL);
        builder.append(" TEXT); ");
        db.execSQL(builder.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // nada a fazer por enquanto ...
    }

    public static final class ContatoColumns implements BaseColumns {
        public static final String NOME = "nome";
        public static final String TELEFONE = "telefone";
        public static final String EMAIL = "email";
    }
}
