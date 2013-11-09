package com.flagleader.builder.e.i;

import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.FKModel;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.tree.AdvancedProperty;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.wizard.Wizard;

public class a extends Wizard
{
  private f a;
  private d b;
  private h c;
  private ISelection d;
  private String e = "";
  private DBModel f = null;
  private ArrayList g = new ArrayList();
  private ArrayList h = new ArrayList();
  private ArrayList i = new ArrayList();
  private ArrayList j = new ArrayList();

  public a(DBModel paramDBModel)
  {
    setNeedsProgressMonitor(true);
    this.f = paramDBModel;
  }

  public void addPages()
  {
    this.a = new f(this);
    this.b = new d();
    this.c = new h();
    addPage(this.a);
    addPage(this.b);
    addPage(this.c);
  }

  public boolean performFinish()
  {
    if (this.b.a().size() > 0)
    {
      j();
      this.e = (k() + m() + l()).toLowerCase();
    }
    return true;
  }

  public DBModel a()
  {
    return this.f;
  }

  public f b()
  {
    return this.a;
  }

  public d c()
  {
    return this.b;
  }

  public h d()
  {
    return this.c;
  }

  public String e()
  {
    return this.e;
  }

  private void j()
  {
    this.g.clear();
    this.h.clear();
    this.i.clear();
    List localList = this.a.a();
    if (localList.size() > 0)
    {
      j localj = new j((TableModel)localList.get(0));
      b(localj);
      a(localj);
    }
  }

  private j a(TableModel paramTableModel)
  {
    for (int k = 0; k < this.g.size(); k++)
      if (((j)this.g.get(k)).c().equals(paramTableModel))
        return (j)this.g.get(k);
    return null;
  }

  private j a(String paramString)
  {
    for (int k = 0; k < this.g.size(); k++)
      if (((j)this.g.get(k)).c().getTableName().equalsIgnoreCase(paramString))
        return (j)this.g.get(k);
    return null;
  }

  private void a(j paramj)
  {
    List localList = this.b.a();
    Object localObject1;
    j localj1;
    Object localObject2;
    for (int k = 0; k < localList.size(); k++)
    {
      localObject1 = (FieldModel)localList.get(k);
      localj1 = a((TableModel)((FieldModel)localObject1).getParent());
      if (localj1 == null)
      {
        localj1 = new j((TableModel)((FieldModel)localObject1).getParent());
        b(localj1);
      }
      localObject2 = new c((FieldModel)localObject1);
      ((c)localObject2).a(localj1);
      a((c)localObject2);
    }
    localList = this.c.a();
    for (k = 0; k < localList.size(); k++)
    {
      localObject1 = (FieldModel)localList.get(k);
      localj1 = a((TableModel)((FieldModel)localObject1).getParent());
      if (localj1 == null)
      {
        localj1 = new j((TableModel)((FieldModel)localObject1).getParent());
        b(localj1);
      }
      localObject2 = new c((FieldModel)localObject1);
      ((c)localObject2).a(localj1);
      this.i.add(localObject2);
    }
    for (k = 1; k < this.g.size(); k++)
    {
      localObject1 = ((j)this.g.get(k)).c().getFKModels();
      for (int m = 0; m < ((List)localObject1).size(); m++)
      {
        localObject2 = (FKModel)((List)localObject1).get(m);
        j localj2 = a(((FKModel)localObject2).getPkTableName());
        j localj3 = a(((FKModel)localObject2).getFKTableName());
        if ((localj2 == null) || (localj3 == null))
          continue;
        b localb = a(((FKModel)localObject2).getPkTableName(), ((FKModel)localObject2).getFKTableName());
        if (localb == null)
        {
          localb = new b(localj2, localj3, paramj);
          localb.a(((FKModel)localObject2).getDeleteRule());
          this.j.add(localb);
        }
        for (int n = 0; n < ((FKModel)localObject2).getKeys().size(); n++)
        {
          localb.f().add(((AdvancedProperty)((FKModel)localObject2).getKeys().get(n)).getKey());
          localb.e().add(((AdvancedProperty)((FKModel)localObject2).getKeys().get(n)).getProperty());
        }
      }
    }
  }

  private b a(String paramString1, String paramString2)
  {
    for (int k = 0; k < this.j.size(); k++)
    {
      b localb = (b)this.j.get(k);
      if ((localb.a().c().getTableName().equalsIgnoreCase(paramString1)) && (localb.d().c().getTableName().equalsIgnoreCase(paramString2)))
        return localb;
    }
    return null;
  }

  private void a(c paramc)
  {
    int k = 0;
    for (int m = 0; m < this.h.size(); m++)
    {
      if (!((c)this.h.get(m)).a().getFieldName().equalsIgnoreCase(paramc.a().getFieldName()))
        continue;
      k++;
    }
    if (this.b.b())
    {
      if (k > 0)
        paramc.a(paramc.a().getDisplayName() + k);
      else
        paramc.a(paramc.a().getDisplayName());
    }
    else if (k > 0)
      paramc.a(paramc.a().getFieldName() + k);
    this.h.add(paramc);
  }

  private void b(j paramj)
  {
    int k = 0;
    for (int m = 0; m < this.g.size(); m++)
    {
      if (!((j)this.g.get(m)).c().getTableName().equalsIgnoreCase(paramj.c().getTableName()))
        continue;
      k++;
    }
    if (k > 0)
      paramj.a(paramj.c().getTableName() + k);
    this.g.add(paramj);
  }

  private String k()
  {
    String str = "select ";
    for (int k = 0; k < this.h.size(); k++)
    {
      c localc = (c)this.h.get(k);
      str = str + localc.d();
      if (k == this.h.size() - 1)
        continue;
      str = str + ",";
    }
    return str;
  }

  private String l()
  {
    String str = "\n where ";
    for (int k = 0; k < this.i.size(); k++)
    {
      c localc = (c)this.i.get(k);
      str = str + localc.f();
      if (k == this.i.size() - 1)
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
    if (this.g.size() > 0)
      str = str + ((j)this.g.get(0)).f();
    for (int k = 0; k < this.j.size(); k++)
    {
      b localb = (b)this.j.get(k);
      str = str + localb.b();
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
    return this.h;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.e.i.a
 * JD-Core Version:    0.6.0
 */