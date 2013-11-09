package com.flagleader.builder.a.f;

import com.flagleader.builder.a.c.a;
import com.flagleader.repository.tree.DecisionRelateRule;

public class J extends a
{
  public J(o paramo)
  {
  }

  public boolean b()
  {
    return !o.a(this.a).isLocked();
  }

  public boolean h()
  {
    return o.a(this.a).getSheetOther() == 1;
  }

  public boolean a(boolean paramBoolean)
  {
    if ((paramBoolean) && (o.a(this.a).getSheetOther() == 0))
    {
      o.a(this.a).setSheetOther(1);
      o.a(this.a).setModified(true);
      o.a(this.a).updateViewer();
    }
    else if ((!paramBoolean) && (o.a(this.a).getSheetOther() == 1))
    {
      o.a(this.a).setSheetOther(0);
      o.a(this.a).setModified(true);
      o.a(this.a).updateViewer();
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
 * Qualified Name:     com.flagleader.builder.a.f.J
 * JD-Core Version:    0.6.0
 */