public class PasswordManager {
package com.winlator.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PasswordManager {
private static final String PREF_NAME = "AppPrefs";
 private static final String KEY_PASSWORD = "app_password";

 public static void setPassword(Context context, String password) {
 SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
 prefs.edit().putString(KEY_PASSWORD, password).apply();
  }
 public static String getPassword(Context context) {
 SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
 return prefs.getString(KEY_PASSWORD, null);
  }
  public static boolean hasPassword(Context context) {
 return getPassword(context) != null;
  }
 public static boolean checkPassword(Context context, String input) {
  String saved = getPassword(context);
 return saved != null && saved.equals(input);
 }
 }
}
