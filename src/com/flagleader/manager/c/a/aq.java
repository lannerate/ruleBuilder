package com.flagleader.manager.c.a;

import com.flagleader.manager.c.c.f;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SelectTable;
import com.flagleader.repository.tree.Envionment;

public class aq
  implements f
{
  public aq(al paramal)
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
 * Qualified Name:     com.flagleader.manager.c.a.aq
 * JD-Core Version:    0.6.0
 */