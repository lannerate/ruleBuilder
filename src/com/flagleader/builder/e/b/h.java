package com.flagleader.builder.e.b;

import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.TableModel;
import java.util.ArrayList;
import java.util.List;

public class h
{
  private TableModel a;
  private c b = null;
  private String c = "";
  private ArrayList d = new ArrayList();

  public h(TableModel paramTableModel)
  {
    this.a = paramTableModel;
  }

  public c a()
  {
    return this.b;
  }

  public void a(c paramc)
  {
    this.b = paramc;
  }

  public String b()
  {
    List localList = this.a.getFields();
    for (int i = 0; i < localList.size(); i++)
      if (((FieldModel)localList.get(i)).isPrimaryKey())
        return ((FieldModel)localList.get(i)).getFieldName();
    return "";
  }

  public TableModel c()
  {
    return this.a;
  }

  public void a(TableModel paramTableModel)
  {
    this.a = paramTableModel;
  }

  public String d()
  {
    return this.c;
  }

  public void a(String paramString)
  {
    this.c = paramString;
  }

  public ArrayList e()
  {
    return this.d;
  }

  public void b(c paramc)
  {
    this.d.add(paramc);
  }

  public String f()
  {
    if (d().length() == 0)
      return this.a.getTableName();
    return this.a.getTableName() + " " + d();
  }

  public String g()
  {
    if (d().length() == 0)
      return this.a.getTableName();
    return d();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.b.h
 * JD-Core Version:    0.6.0
 */