package com.flagleader.repository.e;

import com.flagleader.repository.d.u;
import com.flagleader.repository.n;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.xml.XmlReader;
import java.io.File;
import java.io.InputStream;

public class d extends XmlReader
{
  protected String getXmlRuleFileName()
  {
    return "com/flagleader/repository/parsepackage.xml";
  }

  public Object load(File paramFile)
  {
    RulePackage localRulePackage = (RulePackage)super.load(paramFile);
    if (localRulePackage.getFileVersion() > 6)
      n.a().a(u.a("fileVersion.error", new String[] { localRulePackage.getDisplayName() }));
    return localRulePackage;
  }

  public Object load(InputStream paramInputStream)
  {
    RulePackage localRulePackage = (RulePackage)super.load(paramInputStream);
    if (localRulePackage.getFileVersion() > 6)
      n.a().a(u.a("fileVersion.error", new String[] { localRulePackage.getDisplayName() }));
    return localRulePackage;
  }

  public Object load(String paramString)
  {
    RulePackage localRulePackage = (RulePackage)super.load(paramString);
    if (localRulePackage.getFileVersion() > 6)
      n.a().a(u.a("fileVersion.error", new String[] { localRulePackage.getDisplayName() }));
    return localRulePackage;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.e.d
 * JD-Core Version:    0.6.0
 */