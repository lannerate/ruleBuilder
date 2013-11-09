package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.b;
import com.flagleader.repository.excel.ExcelTableSheetModel;

public class M
  implements b
{
  public M(J paramJ)
  {
  }

  public boolean a()
  {
    return J.a(this.a).isMergeSame();
  }

  public boolean a(boolean paramBoolean)
  {
    if (J.a(this.a).isMergeSame() != paramBoolean)
    {
      J.a(this.a).setMergeSame(paramBoolean);
      J.a(this.a).setModified(true);
    }
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.M
 * JD-Core Version:    0.6.0
 */