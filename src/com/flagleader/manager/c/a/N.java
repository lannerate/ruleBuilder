package com.flagleader.manager.c.a;

import com.flagleader.manager.builder.b;
import com.flagleader.manager.c.c.f;
import com.flagleader.manager.r;
import com.flagleader.repository.excel.ExcelTableSheetModel;

public class N
  implements f
{
  public N(J paramJ)
  {
  }

  public String a()
  {
    return String.valueOf(J.a(this.a).getRowAmountLine());
  }

  public boolean a(String paramString)
  {
    try
    {
      short s = Short.parseShort(paramString);
      if (J.a(this.a).getRowAmountLine() != s)
      {
        J.a(this.a).setRowAmountLine(s);
        J.a(this.a).setModified(true);
        return true;
      }
    }
    catch (Exception localException)
    {
      this.a.e().b().showError(localException.getLocalizedMessage());
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.N
 * JD-Core Version:    0.6.0
 */