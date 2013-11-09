package com.flagleader.builder.a.f;

import com.flagleader.builder.a.c.a;
import com.flagleader.repository.tree.AbstractRuleSet;

public class bc extends a
{
  public bc(bb parambb)
  {
  }

  public boolean b()
  {
    return !this.a.k().isLocked();
  }

  public boolean h()
  {
    return this.a.k().getSheetOther() == 1;
  }

  public boolean a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.a.k().getSheetOther() == 0))
    {
      this.a.k().setSheetOther(1);
      this.a.k().setModified(true);
      this.a.k().updateViewer();
    }
    else if ((!paramBoolean) && (this.a.k().getSheetOther() == 1))
    {
      this.a.k().setSheetOther(0);
      this.a.k().setModified(true);
      this.a.k().updateViewer();
    }
    return true;
  }

  public String c()
  {
    return "AllowSheet";
  }

  public int g()
  {
    return 1;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.f.bc
 * JD-Core Version:    0.6.0
 */