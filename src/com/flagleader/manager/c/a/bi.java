package com.flagleader.manager.c.a;

import com.flagleader.manager.c.f;
import com.flagleader.manager.c.l;
import com.flagleader.manager.c.m;
import com.flagleader.manager.r;
import com.flagleader.repository.db.ViewModel;
import com.flagleader.repository.tree.ITreeNode;

public class bi extends aX
{
  public bi(com.flagleader.manager.c.c paramc, ViewModel paramViewModel, r paramr)
  {
    super(paramc, paramViewModel, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), d().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("disName.SelectTableDialog"), new l(this));
    a(com.flagleader.manager.d.c.b("tableName.TableModelDialog"), new aZ(this));
    a(com.flagleader.manager.d.c.b("vmlshow.dialog"), new f(this));
    a(com.flagleader.manager.d.c.b("resultType.dialog"), new ba(this));
    a(com.flagleader.manager.d.c.b("order.dialog"), new m(this));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.bi
 * JD-Core Version:    0.6.0
 */