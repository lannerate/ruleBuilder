package com.flagleader.builder.a.f;

import com.flagleader.builder.a.c.a;
import com.flagleader.repository.tree.Rule;

public class cy extends a
{
  public cy(ck paramck)
  {
  }

  public boolean b()
  {
    return !ck.a(this.a).isLocked();
  }

  public boolean h()
  {
    return ck.a(this.a).isSupportInit();
  }

  public boolean a(boolean paramBoolean)
  {
    if (ck.a(this.a).isSupportInit() != paramBoolean)
    {
      ck.a(this.a).setSupportInit(paramBoolean);
      ck.a(this.a).setModified(true);
      ck.a(this.a).updateViewer();
    }
    return true;
  }

  public String c()
  {
    return "InitSupport";
  }

  public int g()
  {
    return 1;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cy
 * JD-Core Version:    0.6.0
 */