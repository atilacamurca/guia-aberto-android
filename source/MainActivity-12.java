/* ... */
@Override
public boolean onOptionsItemSelected(MenuItem item) {
	if (item.getItemId() == R.id.menu_add) {
		irPara(SalvarActivity.class);
		return true;
	} else if (item.getItemId() == R.id.menu_pref) {
		irPara(EditarPreferencias.class);
		return true;
	}
	return super.onOptionsItemSelected(item);
}
 
private void irPara(Class<?> clazz) {
	irPara(clazz, null);
}

private void irPara(Class<?> clazz, String id) {
 	Intent intent = new Intent(MainActivity.this, clazz);
 	if (id != null) {
 		intent.putExtra(_ID, id);
 	}
   startActivity(intent);
}
