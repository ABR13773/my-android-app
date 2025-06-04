public class SettingsActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private EditText editPassword;
    private CheckBox checkboxEnablePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // تطبيق اللغة قبل عرض الواجهة
        LocaleHelper.loadLocale(this);

        setContentView(R.layout.activity_settings);

        prefs = getSharedPreferences("AppPrefs", MODE_PRIVATE);
        editPassword = findViewById(R.id.editPassword);
        checkboxEnablePassword = findViewById(R.id.checkboxEnablePassword);

        // تحميل القيم السابقة
        editPassword.setText(prefs.getString("password", ""));
        checkboxEnablePassword.setChecked(prefs.getBoolean("enable_password", false));

        // حفظ كلمة السر
        findViewById(R.id.btnSavePassword).setOnClickListener(v -> {
            String password = editPassword.getText().toString();
            boolean enabled = checkboxEnablePassword.isChecked();

            prefs.edit()
                .putString("password", password)
                .putBoolean("enable_password", enabled)
                .apply();

            Toast.makeText(this, "تم الحفظ", Toast.LENGTH_SHORT).show();
        });

        // زر تغيير اللغة
        findViewById(R.id.btnToggleLanguage).setOnClickListener(v -> {
            String lang = LocaleHelper.getCurrentLanguage(this).equals("ar") ? "en" : "ar";
            LocaleHelper.setLocale(SettingsActivity.this, lang);
            recreate(); // إعادة تحميل الإعدادات
        });
    }
}

