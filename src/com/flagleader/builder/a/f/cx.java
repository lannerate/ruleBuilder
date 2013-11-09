package com.flagleader.builder.a.f;

import com.flagleader.builder.a.c.a;
import com.flagleader.repository.tree.Rule;

public class cx extends a
{
  public cx(ck paramck)
  {
  }

  public boolean b()
  {
    return !ck.a(this.a).isLocked();
  }

  public boolean h()
  {
    return ck.a(this.a).isSupportElse();
  }

  public boolean a(boolean paramBoolean)
  {
    if (ck.a(this.a).isSupportElse() != paramBoolean)
    {
      ck.a(this.a).setSupportElse(paramBoolean);
      ck.a(this.a).setModified(true);
      ck.a(this.a).updateViewer();
    }
    return true;
  }

  public String c()
  {
    return "InitElse";
  }

  public int g()
  {
    return 1;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.cx
 * JD-Core Version:    0.6.0
 */