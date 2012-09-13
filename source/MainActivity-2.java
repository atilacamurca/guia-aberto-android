@Override
public boolean onCreateOptionsMenu(Menu menu) {
   new MenuInflater(this).inflate(R.menu.main_menu, menu);
   return super.onCreateOptionsMenu(menu);
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
   if (item.getItemId() == R.id.menu_add) {
      irParaSalvar();
      return true;
   }
   return super.onOptionsItemSelected(item);
}

private void irParaSalvar() {
   // não implementado ainda ...
}
