package com.flagleader.manager.c.a;

import com.flagleader.manager.c.l;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.ClassContainer;
import com.flagleader.repository.tree.ITreeNode;

public class b extends com.flagleader.manager.c.e
{
  public static String[] e = com.flagleader.manager.d.c.d("loadtypes.ClassContainerProperties");
  public static String[] f;

  static
  {
    for (int i = 0; i < e.length; i++)
      e[i] = com.flagleader.manager.d.c.b(e[i] + ".ClassContainerProperties");
    f = com.flagleader.manager.d.c.d("multitypes.ClassContainerProperties");
    for (i = 0; i < f.length; i++)
      f[i] = com.flagleader.manager.d.c.b(f[i] + ".ClassContainerProperties");
  }

  public b(com.flagleader.manager.c.c paramc, ClassContainer paramClassContainer, r paramr)
  {
    super(paramc, paramClassContainer, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), d().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("disName.TreeNodePropertiesEditor"), new l(this));
    a(com.flagleader.manager.d.c.b("nodeName.ClassContainerProperties"), new e(this));
    a(com.flagleader.manager.d.c.b("loadtype.ClassContainerProperties"), new c(this));
    a(com.flagleader.manager.d.c.b("multitype.ClassContainerProperties"), new d(this));
  }

  public ClassContainer f()
  {
    if ((d() != null) && ((d() instanceof ClassContainer)))
      return (ClassContainer)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.b
 * JD-Core Version:    0.6.0
 */