public Cursor listar() {
   return getReadableDatabase()
      .rawQuery("SELECT _id, nome, telefone, email FROM contato ORDER BY nome",
        null);
}

public String getNome(Cursor c) {
   return c.getString(1);
}

public String getFone(Cursor c) {
   return c.getString(2);
}

public String getEmail(Cursor c) {
   return c.getString(3);
}
