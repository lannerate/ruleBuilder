package com.flagleader.builder.a.f;

import com.flagleader.builder.a.c.a;
import com.flagleader.repository.tree.DecisionRule;

public class ay extends a
{
  public ay(af paramaf)
  {
  }

  public boolean b()
  {
    return !af.a(this.a).isLocked();
  }

  public boolean h()
  {
    return af.a(this.a).getSheetOther() == 1;
  }

  public boolean a(boolean paramBoolean)
  {
    if ((paramBoolean) && (af.a(this.a).getSheetOther() == 0))
    {
      af.a(this.a).setSheetOther(1);
      af.a(this.a).setModified(true);
      af.a(this.a).updateViewer();
    }
    else if ((!paramBoolean) && (af.a(this.a).getSheetOther() == 1))
    {
      af.a(this.a).setSheetOther(0);
      af.a(this.a).setModified(true);
      af.a(this.a).updateViewer();
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
 * Qualified Name:     com.flagleader.builder.a.f.ay
 * JD-Core Version:    0.6.0
 */