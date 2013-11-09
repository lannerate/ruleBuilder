package com.flagleader.manager.c.a;

import com.flagleader.manager.c.e;
import com.flagleader.manager.c.l;
import com.flagleader.manager.c.m;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.xml.TreeValueNode;

public class bc extends e
{
  public static String[] e = com.flagleader.manager.d.c.d("multitypes.TreeValueNodePropertiesEditor");

  static
  {
    for (int i = 0; i < e.length; i++)
      e[i] = com.flagleader.manager.d.c.b(e[i] + ".TreeValueNodePropertiesEditor");
  }

  public bc(com.flagleader.manager.c.c paramc, TreeValueNode paramTreeValueNode, r paramr)
  {
    super(paramc, paramTreeValueNode, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), d().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("disName.TreeNodePropertiesEditor"), new l(this));
    a(com.flagleader.manager.d.c.b("nodeName.TreeNodePropertiesEditor"), new bg(this));
    a(com.flagleader.manager.d.c.b("multitype.TreeNodePropertiesEditor"), new bf(this));
    a(com.flagleader.manager.d.c.b("order.dialog"), new m(this));
    if (f().isRootElement())
      a(com.flagleader.manager.d.c.b("outtype.ValueLibraryEditor"), new be(this));
  }

  public TreeValueNode f()
  {
    if ((d() != null) && ((d() instanceof TreeValueNode)))
      return (TreeValueNode)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.bc
 * JD-Core Version:    0.6.0
 */