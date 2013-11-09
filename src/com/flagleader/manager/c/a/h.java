package com.flagleader.manager.c.a;

import com.flagleader.manager.builder.b;
import com.flagleader.manager.r;
import com.flagleader.repository.db.CustomSql;
import com.flagleader.repository.db.DBModel;
import java.sql.SQLException;

public class h
  implements com.flagleader.manager.c.c.a
{
  public h(f paramf)
  {
  }

  public int a()
  {
    return 4;
  }

  public String b()
  {
    return this.a.f().getSqlCustom();
  }

  public com.flagleader.manager.c.a c()
  {
    return new i(this);
  }

  public boolean a(String paramString)
  {
    if (!this.a.f().getSqlCustom().equals(paramString))
    {
      try
      {
        this.a.f().getDBModel().checkCustomSql(paramString);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        f.a(this.a).b().showError(localClassNotFoundException.getLocalizedMessage());
        return false;
      }
      catch (SQLException localSQLException)
      {
        f.a(this.a).b().showError("你的语句可能有错误" + localSQLException.getLocalizedMessage());
        return false;
      }
      catch (Throwable localThrowable)
      {
      }
      this.a.f().changeSqlText(paramString.toString());
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
 * Qualified Name:     com.flagleader.manager.c.a.h
 * JD-Core Version:    0.6.0
 */