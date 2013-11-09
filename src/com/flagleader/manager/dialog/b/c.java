package com.flagleader.manager.dialog.b;

import com.flagleader.manager.dialog.b;
import com.flagleader.manager.dialog.d;
import com.flagleader.repository.db.DBModel;

public class c extends b
{
  private String b;
  private String c;
  private String d;
  private DBModel e;

  public c(d paramd, DBModel paramDBModel)
  {
    super(paramd);
    this.e = paramDBModel;
  }

  public String a()
  {
    return this.b;
  }

  public void b(String paramString)
  {
    this.b = paramString;
  }

  public String b()
  {
    return this.c;
  }

  public void c(String paramString)
  {
    this.c = paramString;
  }

  public String c()
  {
    return this.d;
  }

  public void d(String paramString)
  {
    this.d = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.dialog.b.c
 * JD-Core Version:    0.6.0
 */