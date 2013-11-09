package com.flagleader.repository.db.a;

import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.TableModel;
import java.util.ArrayList;
import java.util.List;

public class f
{
  private TableModel a;
  private e b = null;
  private String c = "";
  private ArrayList d = new ArrayList();

  public f(TableModel paramTableModel)
  {
    this.a = paramTableModel;
  }

  public e a()
  {
    return this.b;
  }

  public void a(e parame)
  {
    this.b = parame;
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

  public void b(e parame)
  {
    this.d.add(parame);
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
 * Qualified Name:     com.flagleader.repository.db.a.f
 * JD-Core Version:    0.6.0
 */