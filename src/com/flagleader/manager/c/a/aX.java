package com.flagleader.manager.c.a;

import com.flagleader.manager.c.e;
import com.flagleader.manager.c.f;
import com.flagleader.manager.c.l;
import com.flagleader.manager.c.m;
import com.flagleader.manager.r;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.tree.ITreeNode;

public class aX extends e
{
  public static String[] e = com.flagleader.manager.d.c.d("resultTypes.TableModelPropertiesEditor");

  static
  {
    for (int i = 0; i < e.length; i++)
      e[i] = com.flagleader.manager.d.c.b(e[i] + ".TableModelPropertiesEditor");
  }

  public aX(com.flagleader.manager.c.c paramc, TableModel paramTableModel, r paramr)
  {
    super(paramc, paramTableModel, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), d().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("disName.SelectTableDialog"), new l(this));
    a(com.flagleader.manager.d.c.b("tableName.TableModelDialog"), new aZ(this));
    a(com.flagleader.manager.d.c.b("varName.SelectTableDialog"), new bb(this));
    a(com.flagleader.manager.d.c.b("shorttableName.TableModelDialog"), f().getShortTableName());
    a(com.flagleader.manager.d.c.b("vmlshow.dialog"), new f(this));
    a(com.flagleader.manager.d.c.b("accessModel.TableModelDialog"), new aY(this));
    a(com.flagleader.manager.d.c.b("resultType.dialog"), new ba(this));
    a(com.flagleader.manager.d.c.b("order.dialog"), new m(this));
  }

  public TableModel f()
  {
    if ((d() != null) && ((d() instanceof TableModel)))
      return (TableModel)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.aX
 * JD-Core Version:    0.6.0
 */