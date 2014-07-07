@Override
public boolean onCreateOptionsMenu(Menu menu) {
   getMenuInflater().inflate(R.menu.main_menu, menu);
   return true;
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
   int id = item.getItemId();
   if (id == R.id.action_novo) {
       irParaSalvar();
       return true;
   }
   return super.onOptionsItemSelected(item);
}

private void irParaSalvar() {
   // não implementado ainda ...
}
