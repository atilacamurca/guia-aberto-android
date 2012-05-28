/* ... */
private void configurar() {
   listView.setOnItemClickListener(new OnItemClickListener() {
	   public void onItemClick(AdapterView<?> parent, View view,
			   int position, long id) {
		   irPara(SalvarActivity.class, String.valueOf(id));
	   }
   });
   
   listView.setOnItemLongClickListener(new OnItemLongClickListener() {
		public boolean onItemLongClick(AdapterView<?> parent, View view,
				final int position, final long id) {
			/* ... */
			public void onClick(DialogInterface dialog, int which) {
			   switch (which) {
			      case 0: // editar
						irPara(SalvarActivity.class, String.valueOf(id));
						break;
			      /* ... */
			      
			   }
			}
		}
	}
}
