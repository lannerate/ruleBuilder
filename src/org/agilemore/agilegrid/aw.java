package org.agilemore.agilegrid;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class aw
{
  private static final Logger j = Logger.getLogger(aw.class.getName());
  public static final String a = "org.peertoo.agilegrid.Logging";
  private static final Level k = Level.FINEST;
  public static final Level b;
  public static final boolean c;
  public static final boolean d;
  public static final boolean e;
  public static final boolean f;
  public static final boolean g;
  public static final boolean h;
  public static final boolean i;

  static
  {
    Level localLevel = k;
    try
    {
      String str = System.getProperty("org.peertoo.agilegrid.Logging");
      if (str != null)
        localLevel = Level.parse(str);
    }
    catch (SecurityException localSecurityException)
    {
      j.log(Level.WARNING, "Could not read configuration property.", localSecurityException);
    }
    b = localLevel;
    c = b.intValue() <= Level.FINEST.intValue();
    d = b.intValue() <= Level.FINER.intValue();
    e = b.intValue() <= Level.FINE.intValue();
    f = b.intValue() <= Level.CONFIG.intValue();
    g = b.intValue() <= Level.INFO.intValue();
    h = b.intValue() <= Level.WARNING.intValue();
    i = b.intValue() <= Level.SEVERE.intValue();
    if ((f) && (j.isLoggable(Level.CONFIG)))
      j.config("Logging enabled for level : " + b);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.aw
 * JD-Core Version:    0.6.0
 */