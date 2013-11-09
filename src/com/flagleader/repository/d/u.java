package com.flagleader.repository.d;

import com.flagleader.engine.Property;
import com.flagleader.util.prefs.Messages;
import com.flagleader.util.prefs.Preferences;
import com.flagleader.util.prefs.PropertyBundle;

public class u
{
  private static PropertyBundle a = Messages.getMessages().getPropertyBundle("repository");
  private static PropertyBundle b = Preferences.getPreferences().getPropertyBundle("repository");

  public static String a(String paramString)
  {
    return Messages.getMessage(a, paramString, "");
  }

  public static String a(String paramString1, String paramString2)
  {
    return Messages.getMessage(a, paramString1, paramString2);
  }

  public static String a(String paramString, Object[] paramArrayOfObject)
  {
    return Messages.getMessage(a, paramString, "", paramArrayOfObject);
  }

  public static String a()
  {
    return Property.getInstance().getDateFormat();
  }

  public static String b()
  {
    return Property.getInstance().getTimeFormat();
  }

  public static String c()
  {
    return Property.getInstance().getDatetimeFormat();
  }

  public static String[] b(String paramString)
  {
    return Preferences.getStringArray(b, paramString);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.d.u
 * JD-Core Version:    0.6.0
 */