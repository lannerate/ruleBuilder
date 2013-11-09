package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.tree.Envionment;

public class t
  implements f
{
  public t(j paramj)
  {
  }

  public String a()
  {
    return this.a.f().getVarName();
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getVarName().equals(paramString))
    {
      this.a.f().setVarName(paramString.toString());
      this.a.f().getEnvionment().registBusinessObject(this.a.f());
      this.a.f().setModified(true);
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.t
 * JD-Core Version:    0.6.0
 */