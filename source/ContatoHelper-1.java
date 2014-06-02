package contatos.app.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContatoHelper extends SQLiteOpenHelper {

   private static final String DATABASE_NAME = "contatos.db";
   private static final int VERSION = 1;
   
   public ContatoHelper(Context context) {
      super(context, DATABASE_NAME, null, VERSION);
   }
   
   @Override
   public void onCreate(SQLiteDatabase db) {
      db.execSQL("CREATE TABLE contato (_id INTEGER PRIMARY KEY AUTOINCREMENT,"
              + " nome TEXT, telefone TEXT, email TEXT);");
   }

   @Override
   public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
      // nada a fazer por enquanto ...
   }
}
