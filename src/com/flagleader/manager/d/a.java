package com.flagleader.manager.d;

import com.flagleader.util.prefs.PropertyBundle;
import com.flagleader.util.prefs.PropertyManager;

public class a extends PropertyManager
{
  private static a a;

  protected String getBaseClassName()
  {
    return "rulebuilder";
  }

  public static boolean a(PropertyBundle paramPropertyBundle, String paramString, boolean paramBoolean)
  {
    String str = a(paramPropertyBundle, paramString);
    if (str == null)
      return paramBoolean;
    Boolean localBoolean = Boolean.valueOf(str);
    return localBoolean.booleanValue();
  }

  public static boolean a(String paramString, boolean paramBoolean)
  {
    return a(null, paramString, paramBoolean);
  }

  public static char a(PropertyBundle paramPropertyBundle, String paramString, char paramChar)
  {
    String str = a(paramPropertyBundle, paramString);
    if ((str == null) || (str.length() == 0))
      return paramChar;
    return str.charAt(0);
  }

  public static char a(String paramString, char paramChar)
  {
    return a(null, paramString, paramChar);
  }

  public static float a(PropertyBundle paramPropertyBundle, String paramString, float paramFloat)
  {
    String str = a().getValue(paramString);
    if (str == null)
      return paramFloat;
    try
    {
      return Float.parseFloat(str);
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return paramFloat;
  }

  public static float a(String paramString, float paramFloat)
  {
    return a(null, paramString, paramFloat);
  }

  public static int a(PropertyBundle paramPropertyBundle, String paramString, int paramInt)
  {
    String str = a(paramPropertyBundle, paramString);
    if (str == null)
      return paramInt;
    try
    {
      return Integer.parseInt(str);
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    return paramInt;
  }

  public static int a(String paramString, int paramInt)
  {
    return a(null, paramString, paramInt);
  }

  protected static String a(PropertyBundle paramPropertyBundle, String paramString)
  {
    if (paramPropertyBundle == null)
      return a().getValue(paramString);
    return paramPropertyBundle.getString(paramString);
  }

  public static a a()
  {
    if (a == null)
    {
      a = new a();
      a.setPrefixes(new String[] { "" });
      a.setSuffixes(new String[] { "" });
    }
    return a;
  }

  public static String b(PropertyBundle paramPropertyBundle, String paramString)
  {
    return a(paramPropertyBundle, paramString);
  }

  public static String a(PropertyBundle paramPropertyBundle, String paramString1, String paramString2)
  {
    String str = b(paramPropertyBundle, paramString1);
    if (str == null)
      return paramString2;
    return str;
  }

  public static String a(String paramString)
  {
    return b(null, paramString);
  }

  public static String a(String paramString1, String paramString2)
  {
    return a(null, paramString1, paramString2);
  }

  public static String[] c(PropertyBundle paramPropertyBundle, String paramString)
  {
    String str = a(paramPropertyBundle, paramString);
    if (str == null)
      return null;
    return PropertyBundle.tokenize(str);
  }

  public static String[] b(PropertyBundle paramPropertyBundle, String paramString1, String paramString2)
  {
    String str = a(paramPropertyBundle, paramString1);
    if (str == null)
      return null;
    return PropertyBundle.tokenize(str, " \t\n\r\f,;", paramString2);
  }

  public static String[] b(String paramString)
  {
    return c(null, paramString);
  }

  public static String[] b(String paramString1, String paramString2)
  {
    return b(null, paramString1, paramString2);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.d.a
 * JD-Core Version:    0.6.0
 */