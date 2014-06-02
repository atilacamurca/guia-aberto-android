public class MainActivity extends Activity {
	
	private TextView tvResposta = null;
	private EditText etSaudacao = null;
	private Button btEnviar = null;
   private Requisicao requisicao = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carregar();
        configurar();
    }

    private void configurar() {
		btEnviar.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String saudacao = etSaudacao.getText().toString();
				JSONObject json = requisicao.obterResposta(saudacao);
				try {
					String resposta = json.getString("resposta");
					tvResposta.setText(resposta);
				} catch (JSONException e) {
					Log.e("MainActivity", "erro ao ler json", e);
				}
			}
		});
	}

	private void carregar() {
		tvResposta = (TextView) findViewById(R.id.tv_resposta);
		etSaudacao = (EditText) findViewById(R.id.et_saudacao);
		btEnviar = (Button) findViewById(R.id.bt_enviar);
      requisicao = new Requisicao();
	}
}