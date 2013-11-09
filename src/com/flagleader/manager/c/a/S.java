package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.e;
import com.flagleader.repository.excel.ExcelSheetModel;
import com.flagleader.repository.excel.ExcelXYSheetModel;

public class S
  implements e
{
  public S(Q paramQ)
  {
  }

  public int a()
  {
    return Q.a(this.a).getChangedType();
  }

  public String[] b()
  {
    return ExcelSheetModel.COLORTYPES;
  }

  public boolean a(int paramInt)
  {
    if (paramInt != Q.a(this.a).getChangedType())
    {
      Q.a(this.a).setChangedType(paramInt);
      Q.a(this.a).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.S
 * JD-Core Version:    0.6.0
 */