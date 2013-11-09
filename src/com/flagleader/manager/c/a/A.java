package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.excel.ExcelBookModel;

public class A
  implements f
{
  public A(z paramz)
  {
  }

  public String a()
  {
    return this.a.f().getBookName();
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getBookName().equals(paramString))
    {
      this.a.f().setBookName(paramString.toString());
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.A
 * JD-Core Version:    0.6.0
 */