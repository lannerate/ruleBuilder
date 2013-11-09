package com.flagleader.builder.a.f;

import com.flagleader.builder.a.c.a;
import com.flagleader.repository.tree.Rule;

public class cu extends a
{
  public cu(ck paramck)
  {
  }

  public boolean b()
  {
    return !ck.a(this.a).isLocked();
  }

  public boolean h()
  {
    return ck.a(this.a).getSheetOther() == 1;
  }

  public boolean a(boolean paramBoolean)
  {
    if ((paramBoolean) && (ck.a(this.a).getSheetOther() == 0))
    {
      ck.a(this.a).setSheetOther(1);
      ck.a(this.a).setModified(true);
      ck.a(this.a).updateViewer();
    }
    else if ((!paramBoolean) && (ck.a(this.a).getSheetOther() == 1))
    {
      ck.a(this.a).setSheetOther(0);
      ck.a(this.a).setModified(true);
      ck.a(this.a).updateViewer();
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
 * Qualified Name:     com.flagleader.builder.a.f.cu
 * JD-Core Version:    0.6.0
 */