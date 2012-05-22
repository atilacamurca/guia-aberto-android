public void criar(Contato contato) {
   ContentValues cv = new ContentValues();

   cv.put("nome", contato.getNome());
   cv.put("fone", contato.getFone());
   cv.put("email", contato.getEmail());

   getWritableDatabase().insert("contato", "fone", cv);
}
