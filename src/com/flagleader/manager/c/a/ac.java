package com.flagleader.manager.c.a;

import com.flagleader.manager.c.e;
import com.flagleader.manager.c.l;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.CustomFunction;
import com.flagleader.repository.tree.ITreeNode;

public class ac extends e
{
  public ac(com.flagleader.manager.c.c paramc, CustomFunction paramCustomFunction, r paramr)
  {
    super(paramc, paramCustomFunction, paramr);
  }

  public void a()
  {
    a(com.flagleader.manager.d.c.b("lasttime.dialog"), d().getLastModifyTime());
    a(com.flagleader.manager.d.c.b("name.dialog"), new l(this));
  }

  private CustomFunction f()
  {
    if ((d() != null) && ((d() instanceof CustomFunction)))
      return (CustomFunction)d();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.ac
 * JD-Core Version:    0.6.0
 */