package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.excel.ExcelSheetModel;

public class G
  implements f
{
  public G(D paramD)
  {
  }

  public String a()
  {
    return D.a(this.a).getSheetName();
  }

  public boolean a(String paramString)
  {
    if (!D.a(this.a).getSheetName().equals(paramString))
    {
      D.a(this.a).setSheetName(paramString);
      D.a(this.a).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.G
 * JD-Core Version:    0.6.0
 */