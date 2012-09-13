/* ... */
@Override
protected void onCreate(Bundle savedInstanceState) {
	/* ... */
	forceLocale("pt", "BR");
	carregar();
	ir();
}

private void forceLocale(String language, String country) {
	Locale locale = new Locale(language, country);
	Locale.setDefault(locale);
	Configuration configuration = new Configuration();
	configuration.locale = locale;
	getBaseContext().getResources()
	   .updateConfiguration(configuration, 
	      getBaseContext().getResources().getDisplayMetrics());
}
