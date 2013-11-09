package org.agilemore.agilegrid.samples;

public class j
{
  private String a;
  private String b;
  private Boolean c;

  public j(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = Boolean.valueOf(paramBoolean);
  }

  public j(j paramj)
  {
    this(paramj.a, paramj.b, paramj.c.booleanValue());
  }

  public String a()
  {
    return this.a;
  }

  public void a(String paramString)
  {
    this.a = paramString;
  }

  public Boolean b()
  {
    return this.c;
  }

  public void a(Boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public String c()
  {
    return this.b;
  }

  public void b(String paramString)
  {
    this.b = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     org.agilemore.agilegrid.samples.j
 * JD-Core Version:    0.6.0
 */