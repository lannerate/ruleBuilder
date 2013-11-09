package com.flagleader.repository.d;

public class k extends Exception
{
  private Throwable a = null;
  private String b = null;

  public k(String paramString)
  {
    super(paramString);
    this.b = paramString;
  }

  public k(Throwable paramThrowable)
  {
    this(paramThrowable.getMessage(), paramThrowable);
  }

  public k(String paramString, Throwable paramThrowable)
  {
    super(paramString);
    this.b = paramString;
    this.a = paramThrowable;
  }

  public Throwable getCause()
  {
    return this.a;
  }

  public String a()
  {
    if (this.a != null)
      return getCause().getMessage();
    return "";
  }

  public String getMessage()
  {
    if (this.b == null)
    {
      if (this.a != null)
        return this.a.getMessage();
      return super.getMessage();
    }
    if (this.a != null)
      return this.b + " : " + this.a.getMessage();
    return this.b;
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.d.k
 * JD-Core Version:    0.6.0
 */