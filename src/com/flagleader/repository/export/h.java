package com.flagleader.repository.export;

import com.flagleader.engine.Property;
import com.flagleader.xml.XmlReader;
import java.io.File;
import java.net.URL;

public class h extends XmlReader
{
  public static final String a = "rsptags.xml";

  protected String getXmlRuleFileName()
  {
    return "com/flagleader/repository/parseRspTags.xml";
  }

  public static RspTags a()
  {
    File localFile = new File(Property.getInstance().getRuleEngineClassDir(), "rsptags.xml");
    RspTags localRspTags;
    if (localFile.exists())
    {
      localRspTags = (RspTags)new h().load(localFile);
      localRspTags.setTagsFile(localFile);
      return localRspTags;
    }
    if (h.class.getClassLoader().getResource("rsptags.xml") != null)
    {
      localRspTags = (RspTags)new h().load(h.class.getClassLoader().getResource("rsptags.xml").openStream());
      return localRspTags;
    }
    return new RspTags();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.export.h
 * JD-Core Version:    0.6.0
 */