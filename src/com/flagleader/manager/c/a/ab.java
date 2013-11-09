package com.flagleader.manager.c.a;

import com.flagleader.manager.builder.b;
import com.flagleader.manager.c.c.f;
import com.flagleader.manager.r;
import com.flagleader.repository.excel.ExcelXYSheetModel;

public class ab
  implements f
{
  public ab(Q paramQ)
  {
  }

  public String a()
  {
    return String.valueOf(Q.a(this.a).getStartRowLine());
  }

  public boolean a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      if (Q.a(this.a).getStartRowLine() != i)
      {
        Q.a(this.a).setStartRowLine(i);
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
 * Qualified Name:     com.flagleader.manager.c.a.ab
 * JD-Core Version:    0.6.0
 */