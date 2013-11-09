package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.excel.ExcelXYSheetModel;

public class W
  implements e
{
  public W(Q paramQ)
  {
  }

  public int a()
  {
    return Q.a(this.a).getEmptycol();
  }

  public String[] b()
  {
    return Q.e;
  }

  public boolean a(int paramInt)
  {
    if (paramInt != Q.a(this.a).getEmptycol())
    {
      Q.a(this.a).setEmptycol(paramInt);
      Q.a(this.a).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.W
 * JD-Core Version:    0.6.0
 */