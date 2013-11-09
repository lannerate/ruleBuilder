package com.flagleader.repository.f;

import com.flagleader.database.ConnectionFactory;
import com.flagleader.engine.Property;
import com.flagleader.sql.DBConfig;
import com.flagleader.util.StringUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class a
{
  private List a = new ArrayList();
  private static a b = null;

  public List a()
  {
    return this.a;
  }

  public void a(List paramList)
  {
    this.a = paramList;
  }

  public a()
  {
    c();
  }

  public static a b()
  {
    if (b == null)
      b = new a();
    return b;
  }

  public void c()
  {
    this.a.clear();
    String[] arrayOfString = new File(Property.getInstance().getRuleEngineClassDir()).list();
    for (int i = 0; i < arrayOfString.length; i++)
    {
      if ((!arrayOfString[i].endsWith(".conf")) || (arrayOfString[i].equalsIgnoreCase("engine.conf")) || (arrayOfString[i].equalsIgnoreCase("builder.conf")))
        continue;
      try
      {
        DBConfig localDBConfig = new DBConfig(arrayOfString[i]);
        localDBConfig.readConfig();
        if (!StringUtil.isEmpty(ConnectionFactory.connectAvailable(localDBConfig.getDbDriver(), localDBConfig.getDbUrl(), localDBConfig.getDbLogin(), localDBConfig.getDbPassword())))
          continue;
        this.a.add(arrayOfString[i].substring(0, arrayOfString[i].length() - 5));
      }
      catch (Exception localException)
      {
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.f.a
 * JD-Core Version:    0.6.0
 */