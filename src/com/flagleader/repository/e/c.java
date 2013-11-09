package com.flagleader.repository.e;

import com.flagleader.repository.db.DBModel;
import com.flagleader.xml.XmlReader;
import java.io.File;

public class c extends XmlReader
{
  protected String getXmlRuleFileName()
  {
    return "com/flagleader/repository/parsedbmodel.xml";
  }

  public static DBModel a(File paramFile)
  {
    DBModel localDBModel = (DBModel)new c().load(paramFile);
    return localDBModel;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.e.c
 * JD-Core Version:    0.6.0
 */