private void parseJSON() {
   try {
      obj = new JSONObject(resposta);
   } catch (Exception e) {
      Log.e("Requisicao", "erro ao converter string em json", e);
   }
}