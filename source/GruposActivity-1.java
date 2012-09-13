public class GruposActivity extends Activity {

	private GridView grid = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.grupos);
		carregar();
	}
	
	private void carregar() {
		grid = (GridView) findViewById(R.id.gv_grupos);
	}
}
