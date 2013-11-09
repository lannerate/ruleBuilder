package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.excel.ExcelSheetModel;

public class H
  implements f
{
  public H(D paramD)
  {
  }

  public String a()
  {
    return D.a(this.a).getSheetReg();
  }

  public boolean a(String paramString)
  {
    if (!D.a(this.a).getSheetReg().equals(paramString))
    {
      D.a(this.a).setSheetReg(paramString);
      D.a(this.a).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.H
 * JD-Core Version:    0.6.0
 */