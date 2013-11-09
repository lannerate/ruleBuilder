package com.flagleader.manager.c.a;

import com.flagleader.manager.c.e;
import com.flagleader.manager.c.l;
import com.flagleader.manager.c.m;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.BOContainerGroup;
import com.flagleader.repository.tree.ITreeNode;

public class a extends e
{
  public a(com.flagleader.manager.c.c paramc, BOContainerGroup paramBOContainerGroup, r paramr)
  {
    super(paramc, paramBOContainerGroup, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), d().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("disName.TreeNodePropertiesEditor"), new l(this));
    a(com.flagleader.manager.d.c.b("order.dialog"), new m(this));
  }

  public BOContainerGroup f()
  {
    if ((d() != null) && ((d() instanceof BOContainerGroup)))
      return (BOContainerGroup)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.a
 * JD-Core Version:    0.6.0
 */