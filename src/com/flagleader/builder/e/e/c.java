package com.flagleader.builder.e.e;

import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.FKModel;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.db.a.e;
import com.flagleader.repository.db.a.f;
import com.flagleader.repository.tree.AdvancedProperty;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.Wizard;

public class c extends Wizard
{
  private d a;
  private a b;
  private ISelection c;
  private String d = "";
  private DBModel e = null;
  private ArrayList f = new ArrayList();
  private ArrayList g = new ArrayList();
  private ArrayList h = new ArrayList();
  private ArrayList i = new ArrayList();

  public c(DBModel paramDBModel)
  {
    setNeedsProgressMonitor(true);
    this.e = paramDBModel;
  }

  public void addPages()
  {
    this.a = new d(this);
    this.b = new a(this);
    addPage(this.a);
    addPage(this.b);
  }

  public boolean performFinish()
  {
    if (this.b.a().size() > 0)
    {
      j();
      this.d = (k() + m() + l()).toLowerCase();
    }
    return true;
  }

  public DBModel a()
  {
    return this.e;
  }

  public d b()
  {
    return this.a;
  }

  public a c()
  {
    return this.b;
  }

  public String d()
  {
    return this.d;
  }

  private void j()
  {
    this.f.clear();
    this.g.clear();
    this.h.clear();
    List localList = this.a.a();
    if (localList.size() > 0)
    {
      f localf = new f((TableModel)localList.get(0));
      b(localf);
      a(localf);
    }
  }

  private f a(TableModel paramTableModel)
  {
    for (int j = 0; j < this.f.size(); j++)
      if (((f)this.f.get(j)).c().equals(paramTableModel))
        return (f)this.f.get(j);
    return null;
  }

  private f a(String paramString)
  {
    for (int j = 0; j < this.f.size(); j++)
      if (((f)this.f.get(j)).c().getTableName().equalsIgnoreCase(paramString))
        return (f)this.f.get(j);
    return null;
  }

  private void a(f paramf)
  {
    List localList = this.b.a();
    Object localObject1;
    Object localObject2;
    for (int j = 0; j < localList.size(); j++)
    {
      localObject1 = (FieldModel)localList.get(j);
      f localf1 = a((TableModel)((FieldModel)localObject1).getParent());
      if (localf1 == null)
      {
        localf1 = new f((TableModel)((FieldModel)localObject1).getParent());
        b(localf1);
      }
      localObject2 = new e((FieldModel)localObject1);
      ((e)localObject2).a(localf1);
      a((e)localObject2);
    }
    for (j = 1; j < this.f.size(); j++)
    {
      localObject1 = ((f)this.f.get(j)).c().getFKModels();
      for (int k = 0; k < ((List)localObject1).size(); k++)
      {
        localObject2 = (FKModel)((List)localObject1).get(k);
        f localf2 = a(((FKModel)localObject2).getPkTableName());
        f localf3 = a(((FKModel)localObject2).getFKTableName());
        if ((localf2 == null) || (localf3 == null))
          continue;
        com.flagleader.repository.db.a.d locald = a(((FKModel)localObject2).getPkTableName(), ((FKModel)localObject2).getFKTableName());
        if (locald == null)
        {
          locald = new com.flagleader.repository.db.a.d(localf2, localf3, paramf);
          locald.a(((FKModel)localObject2).getDeleteRule());
          this.i.add(locald);
        }
        for (int m = 0; m < ((FKModel)localObject2).getKeys().size(); m++)
        {
          locald.f().add(((AdvancedProperty)((FKModel)localObject2).getKeys().get(m)).getKey());
          locald.e().add(((AdvancedProperty)((FKModel)localObject2).getKeys().get(m)).getProperty());
        }
      }
    }
  }

  private com.flagleader.repository.db.a.d a(String paramString1, String paramString2)
  {
    for (int j = 0; j < this.i.size(); j++)
    {
      com.flagleader.repository.db.a.d locald = (com.flagleader.repository.db.a.d)this.i.get(j);
      if ((locald.a().c().getTableName().equalsIgnoreCase(paramString1)) && (locald.d().c().getTableName().equalsIgnoreCase(paramString2)))
        return locald;
    }
    return null;
  }

  private void a(e parame)
  {
    int j = 0;
    for (int k = 0; k < this.g.size(); k++)
    {
      if (!((e)this.g.get(k)).a().getFieldName().equalsIgnoreCase(parame.a().getFieldName()))
        continue;
      j++;
    }
    if (this.b.b())
    {
      if (j > 0)
        parame.a(parame.a().getDisplayName() + j);
      else
        parame.a(parame.a().getDisplayName());
    }
    else if (j > 0)
      parame.a(parame.a().getFieldName() + j);
    this.g.add(parame);
  }

  private void b(f paramf)
  {
    int j = 0;
    for (int k = 0; k < this.f.size(); k++)
    {
      if (!((f)this.f.get(k)).c().getTableName().equalsIgnoreCase(paramf.c().getTableName()))
        continue;
      j++;
    }
    if (j > 0)
      paramf.a(paramf.c().getTableName() + j);
    this.f.add(paramf);
  }

  private String k()
  {
    String str = "select ";
    for (int j = 0; j < this.g.size(); j++)
    {
      e locale = (e)this.g.get(j);
      str = str + locale.d();
      if (j == this.g.size() - 1)
        continue;
      str = str + ",";
    }
    return str;
  }

  private String l()
  {
    String str = "\n where ";
    for (int j = 0; j < this.h.size(); j++)
    {
      e locale = (e)this.h.get(j);
      str = str + locale.f();
      if (j == this.h.size() - 1)
        continue;
      str = str + " and ";
    }
    if (str.length() < 10)
      return " ";
    return str;
  }

  private String m()
  {
    String str = "\n from ";
    if (this.f.size() > 0)
      str = str + ((f)this.f.get(0)).f();
    for (int j = 0; j < this.i.size(); j++)
    {
      com.flagleader.repository.db.a.d locald = (com.flagleader.repository.db.a.d)this.i.get(j);
      str = str + locald.b();
    }
    return str;
  }

  public List e()
  {
    return this.a.a();
  }

  public List f()
  {
    return this.b.a();
  }

  public ArrayList g()
  {
    return this.g;
  }

  public ArrayList h()
  {
    return this.f;
  }

  public ArrayList i()
  {
    return this.h;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.e.c
 * JD-Core Version:    0.6.0
 */