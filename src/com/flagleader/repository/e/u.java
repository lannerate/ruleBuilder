package com.flagleader.repository.e;

import com.flagleader.repository.tree.RuleTemplate;
import com.flagleader.xml.XmlReader;
import java.io.File;
import java.io.InputStream;

public class u extends XmlReader
{
  protected String getXmlRuleFileName()
  {
    return "com/flagleader/repository/parsetemplate.xml";
  }

  public Object load(File paramFile)
  {
    RuleTemplate localRuleTemplate = (RuleTemplate)super.load(paramFile);
    return localRuleTemplate;
  }

  public Object load(InputStream paramInputStream)
  {
    RuleTemplate localRuleTemplate = (RuleTemplate)super.load(paramInputStream);
    return localRuleTemplate;
  }

  public Object load(String paramString)
  {
    RuleTemplate localRuleTemplate = (RuleTemplate)super.load(paramString);
    return localRuleTemplate;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.e.u
 * JD-Core Version:    0.6.0
 */