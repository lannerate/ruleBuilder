package com.flagleader.manager.c.a;

import com.flagleader.manager.builder.b;
import com.flagleader.manager.c.c.f;
import com.flagleader.manager.r;
import com.flagleader.repository.excel.ExcelXYSheetModel;

public class X
  implements f
{
  public X(Q paramQ)
  {
  }

  public String a()
  {
    return String.valueOf(Q.a(this.a).getRowAmountLine());
  }

  public boolean a(String paramString)
  {
    try
    {
      short s = Short.parseShort(paramString);
      if (Q.a(this.a).getRowAmountLine() != s)
      {
        Q.a(this.a).setRowAmountLine(s);
        Q.a(this.a).setModified(true);
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
 * Qualified Name:     com.flagleader.manager.c.a.X
 * JD-Core Version:    0.6.0
 */