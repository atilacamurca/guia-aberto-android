public int deletar(String id) {
	String whereClause = "_id = ?";
	String[] whereArgs = {id};
	return getWritableDatabase().delete("contato", whereClause, whereArgs);
}
