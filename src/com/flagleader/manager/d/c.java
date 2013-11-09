package com.flagleader.manager.d;

import com.flagleader.util.prefs.Messages;
import com.flagleader.util.prefs.Preferences;
import com.flagleader.util.prefs.PropertyBundle;

public class c
{
  public static final String a = "manager.props";
  public static String b = "edit";
  public static PropertyBundle c = Messages.getMessages().getPropertyBundle("manager.props");
  public static PropertyBundle d = Preferences.getPreferences().getPropertyBundle("manager.props");
  public static PropertyBundle e = Preferences.getPreferences().getPropertyBundle("manager.props." + b);
  public static final String f = "edit";
  public static final String g = "h3c";
  public static final String h = "cdg";
  public static final String i = "plug";
  public static final String j = "free";
  public static final String k = "stan";
  public static final String l = "trail";
  public static final String m = "prof";
  public static final String n = "develop";
  public static final String o = "test";
  public static final String p = "web";

  public static boolean a()
  {
    return (b.equals("edit")) || (b.equals("web"));
  }

  public static void a(String paramString)
  {
    b = paramString;
    e = Preferences.getPreferences().getPropertyBundle("manager.props." + b);
  }

  public static String b(String paramString)
  {
    String str = Messages.getMessage(c, paramString);
    if (str == null)
      return paramString;
    return str;
  }

  public static String a(String paramString1, String paramString2)
  {
    return Messages.getMessage(c, paramString1, paramString2);
  }

  public static String b()
  {
    return Messages.getMessage(c, b + ".version", b);
  }

  public static String a(String paramString, Object[] paramArrayOfObject)
  {
    return Messages.getMessage(c, paramString, "", paramArrayOfObject);
  }

  public static String c(String paramString)
  {
    return Preferences.getString(d, paramString);
  }

  public static String b(String paramString1, String paramString2)
  {
    return Preferences.getString(d, paramString1, paramString2);
  }

  public static String[] d(String paramString)
  {
    return Preferences.getStringArray(d, paramString);
  }

  public static String[] e(String paramString)
  {
    return Preferences.getStringArray(e, paramString);
  }

  public static String c(String paramString1, String paramString2)
  {
    return Preferences.getString(e, paramString1, paramString2);
  }

  public static String f(String paramString)
  {
    return Preferences.getString(e, paramString);
  }

  public static int a(String paramString, int paramInt)
  {
    return Preferences.getInt(d, paramString, paramInt);
  }

  public static boolean a(String paramString, boolean paramBoolean)
  {
    return Preferences.getBoolean(e, paramString, paramBoolean);
  }

  public static char a(String paramString, char paramChar)
  {
    return Preferences.getChar(e, paramString, paramChar);
  }

  public static float a(String paramString, float paramFloat)
  {
    return Preferences.getFloat(e, paramString, paramFloat);
  }

  public static boolean g(String paramString)
  {
    String[] arrayOfString = e("lockEditors");
    if (arrayOfString == null)
      return false;
    for (int i1 = 0; i1 < arrayOfString.length; i1++)
      if (arrayOfString[i1].equalsIgnoreCase(paramString))
        return true;
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.d.c
 * JD-Core Version:    0.6.0
 */