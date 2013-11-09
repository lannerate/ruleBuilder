package com.flagleader.builder.a.f;

import com.flagleader.repository.tree.DecisionMultiRule;

public class k extends com.flagleader.builder.a.c.a
{
  public k(a parama)
  {
  }

  public boolean b()
  {
    return !a.b(this.a).isLocked();
  }

  public boolean h()
  {
    return a.b(this.a).getSheetOther() == 1;
  }

  public boolean a(boolean paramBoolean)
  {
    if ((paramBoolean) && (a.b(this.a).getSheetOther() == 0))
    {
      a.b(this.a).setSheetOther(1);
      a.b(this.a).setModified(true);
      a.b(this.a).updateViewer();
    }
    else if ((!paramBoolean) && (a.b(this.a).getSheetOther() == 1))
    {
      a.b(this.a).setSheetOther(0);
      a.b(this.a).setModified(true);
      a.b(this.a).updateViewer();
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
 * Qualified Name:     com.flagleader.builder.a.f.k
 * JD-Core Version:    0.6.0
 */