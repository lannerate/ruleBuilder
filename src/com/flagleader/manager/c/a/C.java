package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.excel.ExcelBookModel;
import com.flagleader.repository.tree.Envionment;

public class C
  implements f
{
  public C(z paramz)
  {
  }

  public String a()
  {
    return this.a.f().getModelFile();
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getModelFile().equals(paramString))
    {
      this.a.f().setModelFile(paramString.toString());
      this.a.f().getEnvionment().registBusinessObject(this.a.f());
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.C
 * JD-Core Version:    0.6.0
 */