package com.flagleader.manager.c.a;

import com.flagleader.manager.builder.b;
import com.flagleader.manager.c.c.f;
import com.flagleader.manager.r;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.TableModel;

public class aZ
  implements f
{
  public aZ(aX paramaX)
  {
  }

  public String a()
  {
    return this.a.f().getTableName();
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getTableName().equals(paramString))
    {
      String str = paramString.toString();
      this.a.f().setTableName(paramString.toString());
      int i = str.lastIndexOf(".");
      if (str.lastIndexOf(".") >= 0)
        str = str.substring(i + 1);
      this.a.f().setShortTableName(str);
      try
      {
        this.a.f().getDBModel().updateTableModel(this.a.f());
      }
      catch (Exception localException)
      {
        aX.a(this.a).b().showError(localException.getLocalizedMessage());
      }
      this.a.f().setModified(true);
      this.a.f().updateViewer();
      this.a.f().updateTree();
      return true;
    }
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.c.a.aZ
 * JD-Core Version:    0.6.0
 */