package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.ProcedureModel;
import com.flagleader.repository.tree.Envionment;

public class ak
  implements f
{
  public ak(ag paramag)
  {
  }

  public String a()
  {
    return this.a.f().getEnglishName();
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getEnglishName().equals(paramString))
    {
      this.a.f().changeVarName(paramString.toString());
      this.a.f().getEnvionment().registBusinessObject(this.a.f());
      this.a.f().setModified(true);
      this.a.f().updateViewer();
      if (this.a.f().getDBModel() != null)
        this.a.f().getDBModel().updateViewer();
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.ak
 * JD-Core Version:    0.6.0
 */