package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.d;
import com.flagleader.repository.excel.ExcelBookModel;

public class B
  implements d
{
  public B(z paramz)
  {
  }

  public String a()
  {
    return this.a.f().getXlsFile();
  }

  public boolean a(String paramString)
  {
    if (paramString == null)
      paramString = "";
    if (!this.a.f().getXlsFile().equalsIgnoreCase(paramString))
    {
      this.a.f().setXlsFile(paramString);
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }

  public String[] b()
  {
    return new String[] { "*.xls;*.csv" };
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.B
 * JD-Core Version:    0.6.0
 */