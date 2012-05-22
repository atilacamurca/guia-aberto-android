private ContatoHelper helper;
/* ... */

private class ContatoAdapter extends CursorAdapter {

	public ContatoAdapter(Cursor c) {
      super(MainActivity.this, c);
   }

   @Override
   public View newView(Context cntxt, Cursor cursor, ViewGroup vg) {
      LayoutInflater inflater =  getLayoutInflater();
      View linha = inflater.inflate(R.layout.linha, vg, false);
      ContatoHolder holder = new ContatoHolder(linha);
      linha.setTag(holder);
      return linha;
   }

   @Override
   public void bindView(View view, Context cntxt, Cursor cursor) {
      ContatoHolder holder = (ContatoHolder) view.getTag();
      holder.popularForm(cursor, helper);
   }
}
