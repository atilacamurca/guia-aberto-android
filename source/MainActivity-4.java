private static class ContatoHolder {
   private TextView nome, fone, email = null;

   public ContatoHolder(View linha) {
      nome = (TextView) linha.findViewById(R.id.linha_nome);
      fone = (TextView) linha.findViewById(R.id.linha_fone);
      email = (TextView) linha.findViewById(R.id.linha_email);
   }

   public void popularForm(Cursor c, ContatoHelper helper) {
      nome.setText(helper.getNome(c));
      fone.setText(helper.getFone(c));
      email.setText(helper.getEmail(c));
   }
}
