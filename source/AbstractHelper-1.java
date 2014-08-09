package exemplo.android.guia.contatos.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public abstract class AbstractHelper extends SQLiteOpenHelper {

   private static final String DATABASE_NAME = "contatos.db";
   private static final int VERSION = 1;
   
   public AbstractHelper(Context context) {
      super(context, DATABASE_NAME, null, VERSION);
   }
}
