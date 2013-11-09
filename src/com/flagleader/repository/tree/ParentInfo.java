package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.f;
import java.util.ArrayList;
import java.util.List;

public class ParentInfo
  implements f
{
  private IElement elements;
  private String displayName = "";
  private String uuid = "";
  private long modifyTime;
  private List childNodeInfos = new ArrayList();

  public IElement getElements()
  {
    return this.elements;
  }

  public void addPackageInfo(f paramf)
  {
    this.childNodeInfos.add(paramf);
  }

  public void addChildElement(IElement paramIElement)
  {
    this.elements = paramIElement;
  }

  public List getChildNodeInfos()
  {
    return this.childNodeInfos;
  }

  public String getDisplayName()
  {
    return this.displayName;
  }

  public String getUuid()
  {
    return this.uuid;
  }

  public void setDisplayName(String paramString)
  {
    this.displayName = paramString;
  }

  public void setUuid(String paramString)
  {
    this.uuid = paramString;
  }

  public long getModifyTime()
  {
    return this.modifyTime;
  }

  public void setModifyTime(long paramLong)
  {
    this.modifyTime = paramLong;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.ParentInfo
 * JD-Core Version:    0.6.0
 */