package com.flagleader.manager.c.a;

import com.flagleader.manager.c.e;
import com.flagleader.manager.c.l;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.InterfaceContainer;

public class ad extends e
{
  public ad(com.flagleader.manager.c.c paramc, InterfaceContainer paramInterfaceContainer, r paramr)
  {
    super(paramc, paramInterfaceContainer, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), d().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("disName.TreeNodePropertiesEditor"), new l(this));
    a(com.flagleader.manager.d.c.b("nodeName.InterfaceContainerProperties"), new ae(this));
    a(com.flagleader.manager.d.c.b("interfaceName.InterfaceContainerProperties"), f().getInterfaceName());
    a(com.flagleader.manager.d.c.b("initStatement.InterfaceContainerProperties"), new af(this));
  }

  public InterfaceContainer f()
  {
    if ((d() != null) && ((d() instanceof InterfaceContainer)))
      return (InterfaceContainer)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.ad
 * JD-Core Version:    0.6.0
 */