package com.flagleader.builder.e.b;

import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.TableModel;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.wizard.Wizard;

public class a extends Wizard
{
  private d a;
  private f b;
  private String c = "";
  private DBModel d = null;
  private ArrayList e = new ArrayList();
  private ArrayList f = new ArrayList();

  public a(DBModel paramDBModel)
  {
    setNeedsProgressMonitor(true);
    this.d = paramDBModel;
  }

  public void addPages()
  {
    this.a = new d(this);
    this.b = new f();
    addPage(this.a);
    addPage(this.b);
  }

  public boolean performFinish()
  {
    if (this.a.a().size() > 0)
    {
      h();
      this.c = (j() + i()).toLowerCase();
    }
    return true;
  }

  public DBModel a()
  {
    return this.d;
  }

  public d b()
  {
    return this.a;
  }

  public f c()
  {
    return this.b;
  }

  public String d()
  {
    return this.c;
  }

  private void h()
  {
    this.e.clear();
    this.f.clear();
    List localList = this.a.a();
    if (localList.size() > 0)
    {
      h localh = new h((TableModel)localList.get(0));
      b(localh);
      a(localh);
    }
  }

  private h a(TableModel paramTableModel)
  {
    for (int i = 0; i < this.e.size(); i++)
      if (((h)this.e.get(i)).c().equals(paramTableModel))
        return (h)this.e.get(i);
    return null;
  }

  private h a(String paramString)
  {
    for (int i = 0; i < this.e.size(); i++)
      if (((h)this.e.get(i)).c().getTableName().equalsIgnoreCase(paramString))
        return (h)this.e.get(i);
    return null;
  }

  private void a(h paramh)
  {
    List localList = this.b.a();
    for (int i = 0; i < localList.size(); i++)
    {
      FieldModel localFieldModel = (FieldModel)localList.get(i);
      h localh = a((TableModel)localFieldModel.getParent());
      if (localh == null)
      {
        localh = new h((TableModel)localFieldModel.getParent());
        b(localh);
      }
      c localc = new c(localFieldModel);
      localc.a(localh);
      this.f.add(localc);
    }
  }

  private void b(h paramh)
  {
    this.e.add(paramh);
  }

  private String i()
  {
    String str = "\n where ";
    for (int i = 0; i < this.f.size(); i++)
    {
      c localc = (c)this.f.get(i);
      str = str + localc.f();
      if (i == this.f.size() - 1)
        continue;
      str = str + " and ";
    }
    if (str.length() < 10)
      return " ";
    return str;
  }

  private String j()
  {
    String str = "delete from ";
    if (this.e.size() > 0)
      str = str + ((h)this.e.get(0)).f();
    return str;
  }

  public List e()
  {
    return this.a.a();
  }

  public TableModel f()
  {
    return (TableModel)this.a.a().get(0);
  }

  public List g()
  {
    return this.f;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.b.a
 * JD-Core Version:    0.6.0
 */