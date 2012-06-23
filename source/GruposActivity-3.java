public class GruposActivity extends Activity {
	/* ... */
	static final int[] icones = {
		R.drawable.ic_launcher_grupo_amigos,
		R.drawable.ic_launcher_grupo_trabalho,
		R.drawable.ic_launcher_grupo_conhecidos,
		R.drawable.ic_launcher_grupo_familia
	};
	
	private void carregar() {
		/* ... */
		grid.setAdapter(new IconeAdapter(getBaseContext()));
	}
	
	static class IconeAdapter extends BaseAdapter {
		
		public int getCount() {
			return icones.length;
		}
		
		/* ... */
		public View getView(int position, View convertView, ViewGroup parent) {
			GruposHolder holder = null;
			View v = convertView;
			if (v == null) {
				LayoutInflater inflater = (LayoutInflater) context
							.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				v = inflater.inflate(R.layout.grupos_item, null);
				holder = new GruposHolder();
				holder.texto = (TextView) v.findViewById(R.id.tv_texto);
				holder.icone = (ImageView) v.findViewById(R.id.iv_icone);
				v.setTag(holder);
			} else {
				holder = (GruposHolder) v.getTag();
			}
			holder.icone.setImageResource(icones[position]);
			holder.texto.setText(context.getResources()
					.getStringArray(R.array.array_grupos)[position]);
			return v;
		}
	}
}
