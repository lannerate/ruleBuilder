package com.flagleader.manager.dialog.c;

public abstract class n
  implements j
{
  public String a()
  {
    return "";
  }

  public void a(String paramString)
  {
  }

  public String b(String paramString)
  {
    if ((!b()) && ((paramString == null) || (paramString.length() == 0)))
      return "can not empty!";
    if (c())
      try
      {
        Integer.parseInt(paramString);
      }
      catch (Exception localException1)
      {
        return "must be integer!";
      }
    if (g())
      try
      {
        Double.parseDouble(paramString);
      }
      catch (Exception localException2)
      {
        return "must be float!";
      }
    return "";
  }

  public boolean b()
  {
    return true;
  }

  public boolean c()
  {
    return false;
  }

  public boolean g()
  {
    return false;
  }

  public String d()
  {
    return "";
  }

  public String e()
  {
    return "";
  }

  public int f()
  {
    return 80;
  }

  public int h()
  {
    return 320;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.dialog.c.n
 * JD-Core Version:    0.6.0
 */