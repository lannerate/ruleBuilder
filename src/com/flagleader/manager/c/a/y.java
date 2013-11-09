package com.flagleader.manager.c.a;

import com.flagleader.manager.c.e;
import com.flagleader.manager.c.l;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;

public class y extends e
{
  public y(com.flagleader.manager.c.c paramc, Envionment paramEnvionment, r paramr)
  {
    super(paramc, paramEnvionment, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), d().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("name.dialog"), new l(this));
  }

  private Envionment f()
  {
    if ((d() != null) && ((d() instanceof Envionment)))
      return (Envionment)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.y
 * JD-Core Version:    0.6.0
 */