package com.flagleader.manager.e;

import com.flagleader.manager.d.c;
import com.flagleader.repository.a.b;
import com.flagleader.repository.export.IPage;

public class n extends W
{
  b a = new b();

  public n(IPage paramIPage, String paramString, boolean paramBoolean)
  {
    super(paramIPage);
    this.g = new o(this, paramIPage, paramString, paramBoolean);
  }

  public String a()
  {
    return c.b("ExportPageThread.info");
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.n
 * JD-Core Version:    0.6.0
 */