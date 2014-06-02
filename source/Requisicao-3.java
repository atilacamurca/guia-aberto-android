private void lerResposta() {
   try {
      BufferedReader reader = new BufferedReader(new InputStreamReader(instream));
      StringBuilder builder = new StringBuilder();
      String line = null;
      while ((line = reader.readLine()) != null) {
         builder.append(line);
      }
      instream.close();
      resposta = builder.toString();
   } catch (Exception e) {
      Log.e("Requisicao", "erro ao ler resposta", e);
   }
}