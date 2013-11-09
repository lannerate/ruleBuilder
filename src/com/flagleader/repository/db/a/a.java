package com.flagleader.repository.db.a;

import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.FKModel;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.tree.AdvancedProperty;
import java.util.ArrayList;
import java.util.List;

public class a
{
  private String a = "";
  private DBModel b = null;
  private List c = new ArrayList();
  private List d = new ArrayList();
  private List e = new ArrayList();
  private List f = new ArrayList();

  public a(DBModel paramDBModel)
  {
    this.b = paramDBModel;
  }

  public DBModel a()
  {
    return this.b;
  }

  public String b()
  {
    return this.a;
  }

  private List c(List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
    {
      TableModel localTableModel1 = (TableModel)paramList.get(i);
      f localf1 = a(localTableModel1);
      if (localf1 == null)
      {
        localf1 = new f(localTableModel1);
        b(localf1);
      }
      List localList = localTableModel1.getFields();
      for (int j = 0; j < localList.size(); j++)
      {
        FieldModel localFieldModel = (FieldModel)localList.get(j);
        int k = 0;
        if (localFieldModel.isFriendKey())
        {
          localObject = this.b.getFKModel(localTableModel1.getTableName(), localFieldModel.getFieldName());
          if (localObject != null)
          {
            String str1 = ((FKModel)localObject).getPkTableName();
            String str2 = ((AdvancedProperty)((FKModel)localObject).getKeys().get(0)).getKey();
            if (a(str1) == null)
            {
              TableModel localTableModel2 = this.b.getTableModel(str1);
              if (localTableModel2 != null)
              {
                f localf2 = new f(localTableModel2);
                b(localf2);
                for (int m = 0; m < localTableModel2.getFields().size(); m++)
                {
                  if ((!((FieldModel)localTableModel2.getFields().get(m)).getFieldName().equalsIgnoreCase(str2)) || (m + 1 >= localTableModel2.getFields().size()))
                    continue;
                  e locale = new e((FieldModel)localTableModel2.getFields().get(m + 1));
                  locale.a(localf2);
                  a(locale);
                  k = 1;
                  break;
                }
              }
            }
          }
        }
        if ((!localFieldModel.isPrimaryKey()) && ((k != 0) || (b(localFieldModel.getFieldName()))))
          continue;
        Object localObject = new e(localFieldModel);
        ((e)localObject).a(localf1);
        a((e)localObject);
      }
    }
    return (List)this.d;
  }

  public String a(List paramList)
  {
    this.c.clear();
    this.d.clear();
    this.e.clear();
    if (paramList.size() > 0)
    {
      f localf = new f((TableModel)paramList.get(0));
      b(localf);
      c(paramList);
      a(localf);
    }
    return (d() + f()).toLowerCase();
  }

  public String b(List paramList)
  {
    this.c.clear();
    this.d.clear();
    this.e.clear();
    for (int i = 0; i < paramList.size(); i++)
    {
      f localf = new f((TableModel)paramList.get(i));
      b(localf);
      List localList = ((TableModel)paramList.get(i)).getFields();
      for (int j = 0; j < localList.size(); j++)
      {
        FieldModel localFieldModel = (FieldModel)localList.get(j);
        int k = 0;
        if ((k != 0) || (b(localFieldModel.getFieldName())))
          continue;
        e locale = new e(localFieldModel);
        locale.a(localf);
        a(locale);
      }
    }
    return (d() + f()).toLowerCase();
  }

  private boolean a(FieldModel paramFieldModel, List paramList)
  {
    for (int i = 0; i < paramList.size(); i++)
      if (((e)paramList.get(i)).a().equals(paramFieldModel))
        return true;
    return false;
  }

  public String a(TableModel paramTableModel, List paramList1, List paramList2)
  {
    this.c.clear();
    this.d.clear();
    f localf = new f(paramTableModel);
    b(localf);
    List localList = paramTableModel.getPrimaryKeys();
    Object localObject1;
    Object localObject2;
    for (int i = 0; (localList != null) && (i < localList.size()); i++)
    {
      localObject1 = (FieldModel)localList.get(i);
      if (a((FieldModel)localObject1, paramList1))
        continue;
      localObject2 = new e((FieldModel)localObject1);
      ((e)localObject2).a(localf);
      a((e)localObject2);
    }
    this.d.addAll(paramList1);
    for (i = 0; (paramList1 != null) && (i < paramList1.size()); i++)
    {
      localObject1 = (e)paramList1.get(i);
      localObject2 = a((TableModel)((e)localObject1).a().getParent());
      if (localObject2 != null)
        continue;
      localObject2 = new f((TableModel)((e)localObject1).a().getParent());
      b((f)localObject2);
    }
    for (i = 0; i < paramList2.size(); i++)
    {
      localObject1 = (e)paramList2.get(i);
      if (a(((e)localObject1).a(), paramList1))
        continue;
      localObject2 = new e(((e)localObject1).a());
      ((e)localObject2).a(localf);
      a((e)localObject2);
    }
    a(localf);
    return (String)(String)(d() + f()).toLowerCase();
  }

  public String a(TableModel paramTableModel, List paramList)
  {
    this.c.clear();
    this.d.clear();
    this.e.clear();
    f localf1 = new f(paramTableModel);
    b(localf1);
    List localList = paramTableModel.getFields();
    FieldModel localFieldModel;
    Object localObject;
    for (int i = 0; i < localList.size(); i++)
    {
      localFieldModel = (FieldModel)localList.get(i);
      int j = 0;
      if (localFieldModel.isFriendKey())
      {
        localObject = this.b.getFKModel(paramTableModel.getTableName(), localFieldModel.getFieldName());
        if (localObject != null)
        {
          String str1 = ((FKModel)localObject).getPkTableName();
          String str2 = ((AdvancedProperty)((FKModel)localObject).getKeys().get(0)).getKey();
          if (a(str1) == null)
          {
            TableModel localTableModel = this.b.getTableModel(str1);
            if (localTableModel != null)
            {
              f localf3 = new f(localTableModel);
              b(localf3);
              for (int k = 0; k < localTableModel.getFields().size(); k++)
              {
                if ((!((FieldModel)localTableModel.getFields().get(k)).getFieldName().equalsIgnoreCase(str2)) || (k + 1 >= localTableModel.getFields().size()))
                  continue;
                e locale = new e((FieldModel)localTableModel.getFields().get(k + 1));
                locale.a(localf3);
                a(locale);
                j = 1;
                break;
              }
            }
          }
        }
      }
      if (b(localFieldModel.getFieldName()))
        continue;
      localObject = new e(localFieldModel);
      ((e)localObject).a(localf1);
      a((e)localObject);
    }
    for (i = 0; (paramList != null) && (i < paramList.size()); i++)
    {
      localFieldModel = (FieldModel)paramList.get(i);
      f localf2 = a((TableModel)localFieldModel.getParent());
      if (localf2 == null)
      {
        localf2 = new f((TableModel)localFieldModel.getParent());
        b(localf2);
      }
      localObject = new e(localFieldModel);
      ((e)localObject).a(localf2);
      this.e.add(localObject);
    }
    a(localf1);
    return (String)(d() + f() + e()).toLowerCase();
  }

  private f a(TableModel paramTableModel)
  {
    for (int i = 0; i < this.c.size(); i++)
      if (((f)this.c.get(i)).c().equals(paramTableModel))
        return (f)this.c.get(i);
    return null;
  }

  private f a(String paramString)
  {
    for (int i = 0; i < this.c.size(); i++)
      if (((f)this.c.get(i)).c().getTableName().equalsIgnoreCase(paramString))
        return (f)this.c.get(i);
    return null;
  }

  private boolean b(String paramString)
  {
    for (int i = 0; i < this.d.size(); i++)
      if (((e)this.d.get(i)).a().getFieldName().equalsIgnoreCase(paramString))
        return true;
    return false;
  }

  private void a(f paramf)
  {
    for (int i = 1; i < this.c.size(); i++)
    {
      List localList = ((f)this.c.get(i)).c().getFKModels();
      for (int j = 0; j < localList.size(); j++)
      {
        FKModel localFKModel = (FKModel)localList.get(j);
        f localf1 = a(localFKModel.getPkTableName());
        f localf2 = a(localFKModel.getFKTableName());
        if ((localf1 == null) || (localf2 == null))
          continue;
        d locald = a(localFKModel.getPkTableName(), localFKModel.getFKTableName());
        if (locald == null)
        {
          locald = new d(localf1, localf2, paramf);
          locald.a(localFKModel.getDeleteRule());
          this.f.add(locald);
        }
        for (int k = 0; k < localFKModel.getKeys().size(); k++)
        {
          locald.f().add(((AdvancedProperty)localFKModel.getKeys().get(k)).getKey());
          locald.e().add(((AdvancedProperty)localFKModel.getKeys().get(k)).getProperty());
        }
      }
    }
  }

  private d a(String paramString1, String paramString2)
  {
    for (int i = 0; i < this.f.size(); i++)
    {
      d locald = (d)this.f.get(i);
      if ((locald.a().c().getTableName().equalsIgnoreCase(paramString1)) && (locald.d().c().getTableName().equalsIgnoreCase(paramString2)))
        return locald;
    }
    return null;
  }

  private void a(e parame)
  {
    if (parame.a().getJavaType().z())
      return;
    int i = 0;
    for (int j = 0; j < this.d.size(); j++)
    {
      if (!((e)this.d.get(j)).a().getFieldName().equalsIgnoreCase(parame.a().getFieldName()))
        continue;
      i++;
    }
    if (i > 0)
      parame.a(parame.a().getFieldName() + i);
    this.d.add(parame);
  }

  private void b(f paramf)
  {
    int i = 0;
    for (int j = 0; j < this.c.size(); j++)
    {
      if (!((f)this.c.get(j)).c().getTableName().equalsIgnoreCase(paramf.c().getTableName()))
        continue;
      i++;
    }
    if (i > 0)
      paramf.a(paramf.c().getTableName() + i);
    this.c.add(paramf);
  }

  private String d()
  {
    String str = "select ";
    int i;
    if (this.d != null)
      for (i = 0; i < this.d.size(); i++)
      {
        e locale = (e)this.d.get(i);
        str = str + locale.d();
        if (i == this.d.size() - 1)
          continue;
        str = str + ",";
      }
    else
      for (i = 0; i < this.c.size(); i++)
      {
        str = str + ((f)this.c.get(i)).g();
        if (i == this.c.size() - 1)
          continue;
        str = str + ",";
      }
    return str;
  }

  private String e()
  {
    String str = " where ";
    for (int i = 0; i < this.e.size(); i++)
    {
      e locale = (e)this.e.get(i);
      str = str + locale.f();
      if (i == this.e.size() - 1)
        continue;
      str = str + " and ";
    }
    if (str.length() < 10)
      return " ";
    return str;
  }

  private String f()
  {
    String str = " from ";
    if (this.c.size() > 0)
      str = str + ((f)this.c.get(0)).f();
    for (int i = 0; i < this.f.size(); i++)
    {
      d locald = (d)this.f.get(i);
      str = str + locald.b();
    }
    return str;
  }

  public List c()
  {
    return this.d;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.a.a
 * JD-Core Version:    0.6.0
 */