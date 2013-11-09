package com.flagleader.manager.c.a;

import com.flagleader.manager.builder.b;
import com.flagleader.manager.c.c.f;
import com.flagleader.manager.r;
import com.flagleader.repository.excel.ExcelXYSheetModel;

public class T
  implements f
{
  public T(Q paramQ)
  {
  }

  public String a()
  {
    return String.valueOf(Q.a(this.a).getColAmountLine());
  }

  public boolean a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      if (Q.a(this.a).getColAmountLine() != i)
      {
        Q.a(this.a).setColAmountLine(i);
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
 * Qualified Name:     com.flagleader.manager.c.a.T
 * JD-Core Version:    0.6.0
 */