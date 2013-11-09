package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.b;
import com.flagleader.repository.excel.ExcelSheetModel;

public class E
  implements b
{
  public E(D paramD)
  {
  }

  public boolean a()
  {
    return D.a(this.a).isMergeValue();
  }

  public boolean a(boolean paramBoolean)
  {
    if (D.a(this.a).isMergeValue() != paramBoolean)
    {
      D.a(this.a).setMergeValue(paramBoolean);
      D.a(this.a).setModified(true);
    }
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.E
 * JD-Core Version:    0.6.0
 */