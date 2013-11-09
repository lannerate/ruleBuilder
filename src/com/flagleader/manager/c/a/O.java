package com.flagleader.manager.c.a;

import com.flagleader.manager.builder.b;
import com.flagleader.manager.c.c.f;
import com.flagleader.manager.r;
import com.flagleader.repository.excel.ExcelTableSheetModel;

public class O
  implements f
{
  public O(J paramJ)
  {
  }

  public String a()
  {
    return String.valueOf(J.a(this.a).getStartCol());
  }

  public boolean a(String paramString)
  {
    try
    {
      short s = Short.parseShort(paramString);
      if (J.a(this.a).getStartCol() != s)
      {
        J.a(this.a).setStartCol(s);
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
 * Qualified Name:     com.flagleader.manager.c.a.O
 * JD-Core Version:    0.6.0
 */