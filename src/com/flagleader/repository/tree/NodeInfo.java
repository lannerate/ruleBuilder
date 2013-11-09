package com.flagleader.repository.tree;

import com.flagleader.repository.f;
import com.flagleader.util.TempID;

public class NodeInfo
  implements f
{
  private String name = "";
  private String hint = "";
  private String displayName = "";
  private String uuid = null;

  public String getUuid()
  {
    if ((this.uuid == null) || (this.uuid.length() == 0))
      this.uuid = TempID.newShortTempID();
    return this.uuid;
  }

  public NodeInfo(String paramString1, String paramString2, String paramString3)
  {
    this.name = paramString1;
    this.hint = paramString2;
    this.displayName = paramString3;
  }

  public String getDisplayName()
  {
    return this.displayName;
  }

  public String getHint()
  {
    return this.hint;
  }

  public String getName()
  {
    return this.name;
  }

  public void setDisplayName(String paramString)
  {
    this.displayName = paramString;
  }

  public void setHint(String paramString)
  {
    this.hint = paramString;
  }

  public void setName(String paramString)
  {
    this.name = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.NodeInfo
 * JD-Core Version:    0.6.0
 */