package com.flagleader.builder.e.i;

import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.lang.g;

public class c
{
  private FieldModel a;
  private String b = "";
  private j c;

  public c(FieldModel paramFieldModel)
  {
    this.a = paramFieldModel;
  }

  public FieldModel a()
  {
    return this.a;
  }

  public void a(FieldModel paramFieldModel)
  {
    this.a = paramFieldModel;
  }

  public j b()
  {
    return this.c;
  }

  public void a(j paramj)
  {
    this.c = paramj;
  }

  public String c()
  {
    return this.b;
  }

  public void a(String paramString)
  {
    this.b = paramString;
  }

  public String d()
  {
    String str = b().d();
    if (str.length() == 0)
      str = b().c().getTableName();
    if (c().length() == 0)
      return str + "." + this.a.getFieldName();
    return str + "." + this.a.getFieldName() + " as " + c();
  }

  public String e()
  {
    if (c().length() == 0)
      return this.a.getFieldName();
    return c();
  }

  public String f()
  {
    return b().g() + "." + this.a.getFieldName() + " = {" + this.a.getJavaType().K() + "} ";
  }

  public String g()
  {
    return b().g() + "." + this.a.getFieldName();
  }

  public String h()
  {
    return this.a.getDisplayName();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.i.c
 * JD-Core Version:    0.6.0
 */