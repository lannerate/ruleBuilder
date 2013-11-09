package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.f;
import com.flagleader.util.TempID;
import java.util.ArrayList;
import java.util.List;

public class RuleTemplate
  implements f
{
  private String displayName = "";
  private String packageName = "";
  private List packageInfos = new ArrayList(1);
  private String uuid = null;

  public String getUuid()
  {
    if ((this.uuid == null) || (this.uuid.length() == 0))
      this.uuid = TempID.newShortTempID();
    return this.uuid;
  }

  public void addChildElement(IElement paramIElement)
  {
    this.packageInfos.add(paramIElement);
  }

  public IRuleTree getRule()
  {
    if ((this.packageInfos.size() > 0) && ((this.packageInfos.get(0) instanceof IRuleTree)))
      return (IRuleTree)this.packageInfos.get(0);
    return null;
  }

  public List getPackageInfos()
  {
    return this.packageInfos;
  }

  public String getDisplayName()
  {
    return this.displayName;
  }

  public String getPackageName()
  {
    return this.packageName;
  }

  public void setDisplayName(String paramString)
  {
    this.displayName = paramString;
  }

  public void setPackageName(String paramString)
  {
    this.packageName = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.RuleTemplate
 * JD-Core Version:    0.6.0
 */