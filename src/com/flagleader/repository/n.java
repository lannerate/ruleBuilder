package com.flagleader.repository;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class n
  implements h
{
  public Logger a = null;
  private static HashMap b = new HashMap();

  private n(String paramString)
  {
    this.a = Logger.getLogger(paramString);
  }

  public static n a()
  {
    return g("flagleader");
  }

  public static n g(String paramString)
  {
    if (b.get(paramString) != null)
      return (n)b.get(paramString);
    if ((paramString == null) || (paramString.length() == 0))
      paramString = "flagleader";
    n localn = new n(paramString);
    b.put(paramString, localn);
    return localn;
  }

  public void a(String paramString)
  {
    this.a.log(Level.SEVERE, paramString);
  }

  public void a(String paramString, Throwable paramThrowable)
  {
    this.a.log(Level.SEVERE, paramString, paramThrowable);
  }

  public void b(String paramString)
  {
    this.a.log(Level.WARNING, paramString);
  }

  public void b(String paramString, Throwable paramThrowable)
  {
    this.a.log(Level.WARNING, paramString, paramThrowable);
  }

  public void c(String paramString)
  {
    this.a.log(Level.INFO, paramString);
  }

  public void c(String paramString, Throwable paramThrowable)
  {
    this.a.log(Level.INFO, paramString, paramThrowable);
  }

  public void d(String paramString)
  {
    this.a.log(Level.WARNING, paramString);
  }

  public void e(String paramString)
  {
    this.a.log(Level.FINE, paramString);
  }

  public void d(String paramString, Throwable paramThrowable)
  {
    this.a.log(Level.FINE, paramString);
  }

  public void f(String paramString)
  {
    this.a.log(Level.FINEST, paramString);
  }

  public void e(String paramString, Throwable paramThrowable)
  {
    this.a.log(Level.FINEST, paramString, paramThrowable);
  }

  public Logger b()
  {
    return this.a;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.n
 * JD-Core Version:    0.6.0
 */