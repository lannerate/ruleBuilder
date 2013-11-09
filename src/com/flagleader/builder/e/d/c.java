package com.flagleader.builder.e.d;

import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.FKModel;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.db.a.e;
import com.flagleader.repository.tree.AdvancedProperty;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.Wizard;

public class c extends Wizard
{
  private d a;
  private a b;
  private f c;
  private ISelection d;
  private String e = "";
  private DBModel f = null;
  private TableModel g;
  private ArrayList h = new ArrayList();
  private ArrayList i = new ArrayList();
  private ArrayList j = new ArrayList();
  private ArrayList k = new ArrayList();
  private ArrayList l = new ArrayList();

  public c(DBModel paramDBModel, TableModel paramTableModel)
  {
    setNeedsProgressMonitor(true);
    this.f = paramDBModel;
    this.g = paramTableModel;
    this.a = new d(this);
    this.b = new a(this);
    this.c = new f(this);
  }

  public void addPages()
  {
    addPage(this.b);
    addPage(this.c);
    addPage(this.a);
  }

  public boolean performFinish()
  {
    if (this.b.a().size() > 0)
      n();
    return true;
  }

  public DBModel a()
  {
    return this.f;
  }

  public d b()
  {
    return this.a;
  }

  public a c()
  {
    return this.b;
  }

  public f d()
  {
    return this.c;
  }

  public String e()
  {
    return this.e;
  }

  private void n()
  {
    this.h.clear();
    this.i.clear();
    this.k.clear();
    this.j.clear();
    com.flagleader.repository.db.a.f localf = new com.flagleader.repository.db.a.f(this.g);
    b(localf);
    a(localf);
  }

  private com.flagleader.repository.db.a.f a(TableModel paramTableModel)
  {
    for (int m = 0; m < this.h.size(); m++)
      if (((com.flagleader.repository.db.a.f)this.h.get(m)).c().equals(paramTableModel))
        return (com.flagleader.repository.db.a.f)this.h.get(m);
    return null;
  }

  private com.flagleader.repository.db.a.f a(String paramString)
  {
    for (int m = 0; m < this.h.size(); m++)
      if (((com.flagleader.repository.db.a.f)this.h.get(m)).c().getTableName().equalsIgnoreCase(paramString))
        return (com.flagleader.repository.db.a.f)this.h.get(m);
    return null;
  }

  private void a(com.flagleader.repository.db.a.f paramf)
  {
    List localList = this.a.a();
    Object localObject1;
    com.flagleader.repository.db.a.f localf1;
    Object localObject2;
    for (int m = 0; m < localList.size(); m++)
    {
      localObject1 = (FieldModel)localList.get(m);
      localf1 = a((TableModel)((FieldModel)localObject1).getParent());
      if (localf1 == null)
      {
        localf1 = new com.flagleader.repository.db.a.f((TableModel)((FieldModel)localObject1).getParent());
        b(localf1);
      }
      localObject2 = new e((FieldModel)localObject1);
      ((e)localObject2).a(localf1);
      a((e)localObject2);
    }
    localList = this.b.a();
    for (m = 0; m < localList.size(); m++)
    {
      localObject1 = (FieldModel)localList.get(m);
      localf1 = a((TableModel)((FieldModel)localObject1).getParent());
      if (localf1 == null)
      {
        localf1 = new com.flagleader.repository.db.a.f((TableModel)((FieldModel)localObject1).getParent());
        b(localf1);
      }
      localObject2 = new e((FieldModel)localObject1);
      ((e)localObject2).a(localf1);
      b((e)localObject2);
    }
    localList = this.c.a();
    for (m = 0; m < localList.size(); m++)
    {
      localObject1 = (FieldModel)localList.get(m);
      localf1 = a((TableModel)((FieldModel)localObject1).getParent());
      if (localf1 == null)
      {
        localf1 = new com.flagleader.repository.db.a.f((TableModel)((FieldModel)localObject1).getParent());
        b(localf1);
      }
      localObject2 = new e((FieldModel)localObject1);
      ((e)localObject2).a(localf1);
      this.j.add(localObject2);
    }
    for (m = 1; m < this.h.size(); m++)
    {
      localObject1 = ((com.flagleader.repository.db.a.f)this.h.get(m)).c().getFKModels();
      for (int n = 0; n < ((List)localObject1).size(); n++)
      {
        localObject2 = (FKModel)((List)localObject1).get(n);
        com.flagleader.repository.db.a.f localf2 = a(((FKModel)localObject2).getPkTableName());
        com.flagleader.repository.db.a.f localf3 = a(((FKModel)localObject2).getFKTableName());
        if ((localf2 == null) || (localf3 == null))
          continue;
        com.flagleader.repository.db.a.d locald = a(((FKModel)localObject2).getPkTableName(), ((FKModel)localObject2).getFKTableName());
        if (locald == null)
        {
          locald = new com.flagleader.repository.db.a.d(localf2, localf3, paramf);
          locald.a(((FKModel)localObject2).getDeleteRule());
          this.l.add(locald);
        }
        for (int i1 = 0; i1 < ((FKModel)localObject2).getKeys().size(); i1++)
        {
          locald.f().add(((AdvancedProperty)((FKModel)localObject2).getKeys().get(i1)).getKey());
          locald.e().add(((AdvancedProperty)((FKModel)localObject2).getKeys().get(i1)).getProperty());
        }
      }
    }
  }

  private com.flagleader.repository.db.a.d a(String paramString1, String paramString2)
  {
    for (int m = 0; m < this.l.size(); m++)
    {
      com.flagleader.repository.db.a.d locald = (com.flagleader.repository.db.a.d)this.l.get(m);
      if ((locald.a().c().getTableName().equalsIgnoreCase(paramString1)) && (locald.d().c().getTableName().equalsIgnoreCase(paramString2)))
        return locald;
    }
    return null;
  }

  private void a(e parame)
  {
    int m = 0;
    for (int n = 0; n < this.k.size(); n++)
    {
      if (!((e)this.k.get(n)).a().getFieldName().equalsIgnoreCase(parame.a().getFieldName()))
        continue;
      m++;
    }
    if (this.a.c())
    {
      if (m > 0)
        parame.a(parame.a().getDisplayName() + m);
      else
        parame.a(parame.a().getDisplayName());
    }
    else if (m > 0)
      parame.a(parame.a().getFieldName() + m);
    this.k.add(parame);
  }

  private void b(e parame)
  {
    int m = 0;
    for (int n = 0; n < this.i.size(); n++)
    {
      if (!((e)this.i.get(n)).a().getFieldName().equalsIgnoreCase(parame.a().getFieldName()))
        continue;
      m++;
    }
    if (this.b.b())
    {
      if (m > 0)
        parame.a(parame.a().getDisplayName() + m);
      else
        parame.a(parame.a().getDisplayName());
    }
    else if (m > 0)
      parame.a(parame.a().getFieldName() + m);
    this.i.add(parame);
  }

  private void b(com.flagleader.repository.db.a.f paramf)
  {
    int m = 0;
    for (int n = 0; n < this.h.size(); n++)
    {
      if (!((com.flagleader.repository.db.a.f)this.h.get(n)).c().getTableName().equalsIgnoreCase(paramf.c().getTableName()))
        continue;
      m++;
    }
    if (m > 0)
      paramf.a(paramf.c().getTableName() + m);
    this.h.add(paramf);
  }

  private String o()
  {
    String str = "select ";
    for (int m = 0; m < this.i.size(); m++)
    {
      e locale = (e)this.i.get(m);
      str = str + locale.d();
      if (m == this.i.size() - 1)
        continue;
      str = str + ",";
    }
    return str;
  }

  private String p()
  {
    String str = "\n where ";
    for (int m = 0; m < this.j.size(); m++)
    {
      e locale = (e)this.j.get(m);
      str = str + locale.f();
      if (m == this.j.size() - 1)
        continue;
      str = str + " and ";
    }
    if (str.length() < 10)
      return " ";
    return str;
  }

  private String q()
  {
    String str = "\n from ";
    if (this.h.size() > 0)
      str = str + ((com.flagleader.repository.db.a.f)this.h.get(0)).f();
    for (int m = 0; m < this.l.size(); m++)
    {
      com.flagleader.repository.db.a.d locald = (com.flagleader.repository.db.a.d)this.l.get(m);
      str = str + locald.b();
    }
    return str;
  }

  public List f()
  {
    return this.a.a();
  }

  public List g()
  {
    return this.b.a();
  }

  public List h()
  {
    return this.c.a();
  }

  public ArrayList i()
  {
    return this.i;
  }

  public ArrayList j()
  {
    return this.h;
  }

  public ArrayList k()
  {
    return this.j;
  }

  public TableModel l()
  {
    return this.g;
  }

  public ArrayList m()
  {
    return this.k;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.d.c
 * JD-Core Version:    0.6.0
 */