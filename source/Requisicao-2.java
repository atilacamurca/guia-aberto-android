private void enviar(String saudacao) {
   try {
      DefaultHttpClient httpClient = new DefaultHttpClient();
      HttpPost post = new HttpPost(URL);
      List<NameValuePair> params = new ArrayList<NameValuePair>();
      params.add(new BasicNameValuePair("saudacao", saudacao));
      UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params);
      post.setEntity(formEntity);
      
      HttpResponse response = httpClient.execute(post);
      HttpEntity entity = response.getEntity();
      instream = entity.getContent();
   } catch (Exception e) {
      Log.e("Requisicao", "erro ao enviar requisição", e);
   }
}