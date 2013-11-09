package com.flagleader.manager.dialog.b;

import com.flagleader.manager.dialog.d;
import com.flagleader.repository.db.DBModel;

public class b extends com.flagleader.manager.dialog.b
{
  private DBModel b = null;
  private String c;
  private String d;

  public b(d paramd, DBModel paramDBModel)
  {
    super(paramd);
    this.b = paramDBModel;
  }

  public String a()
  {
    return this.c;
  }

  public void b(String paramString)
  {
    this.c = paramString;
  }

  public String b()
  {
    return this.d;
  }

  public void c(String paramString)
  {
    this.d = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.dialog.b.b
 * JD-Core Version:    0.6.0
 */