package org.agilemore.agilegrid;

import org.eclipse.core.runtime.AssertionFailedException;

public final class F
{
  public static boolean a(boolean paramBoolean)
  {
    return a(paramBoolean, "");
  }

  public static boolean a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean)
      throw new IllegalArgumentException(paramString);
    return paramBoolean;
  }

  public static void a(Object paramObject)
  {
    a(paramObject, "");
  }

  public static void a(Object paramObject, String paramString)
  {
    if (paramObject == null)
      throw new AssertionFailedException("null argument:" + paramString);
  }

  public static boolean b(boolean paramBoolean)
  {
    return b(paramBoolean, "");
  }

  public static boolean b(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean)
      throw new AssertionFailedException("assertion failed: " + paramString);
    return paramBoolean;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.F
 * JD-Core Version:    0.6.0
 */