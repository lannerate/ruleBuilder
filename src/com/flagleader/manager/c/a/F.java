package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.excel.ExcelSheetModel;
import com.flagleader.repository.tree.Envionment;

public class F
  implements f
{
  public F(D paramD)
  {
  }

  public String a()
  {
    return D.a(this.a).getModelName();
  }

  public boolean a(String paramString)
  {
    if (!D.a(this.a).getModelName().equals(paramString))
    {
      D.a(this.a).setModelName(paramString.toString());
      D.a(this.a).getEnvionment().registBusinessObject(D.a(this.a));
      D.a(this.a).setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.F
 * JD-Core Version:    0.6.0
 */