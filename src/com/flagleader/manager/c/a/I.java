package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.b;
import com.flagleader.repository.excel.ExcelSheetModel;

public class I
  implements b
{
  public I(D paramD)
  {
  }

  public boolean a()
  {
    return D.a(this.a).isShowBorder();
  }

  public boolean a(boolean paramBoolean)
  {
    if (D.a(this.a).isShowBorder() != paramBoolean)
    {
      D.a(this.a).setShowBorder(paramBoolean);
      D.a(this.a).setModified(true);
    }
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.I
 * JD-Core Version:    0.6.0
 */