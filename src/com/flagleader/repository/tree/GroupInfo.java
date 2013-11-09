package com.flagleader.repository.tree;

import com.flagleader.repository.f;
import com.flagleader.repository.f.p;
import com.flagleader.util.StringUtil;
import com.flagleader.util.TempID;
import java.util.ArrayList;
import java.util.List;

public class GroupInfo
  implements f, al
{
  private String displayName = "";
  private String uuid = "";
  private f parent;
  private List packageInfos = new ArrayList();

  public f getParent()
  {
    return this.parent;
  }

  public void setParent(f paramf)
  {
    this.parent = paramf;
  }

  public void delete()
  {
    if ((this.parent != null) && ((this.parent instanceof al)))
      ((al)this.parent).removeInfo(this);
  }

  public GroupInfo()
  {
  }

  public GroupInfo(String paramString)
  {
    this.displayName = paramString;
  }

  public void removeInfo(Object paramObject)
  {
    this.packageInfos.remove(paramObject);
  }

  public void addPackageInfo(f paramf)
  {
    if ((paramf instanceof GroupInfo))
      ((GroupInfo)paramf).setParent(this);
    else if ((paramf instanceof PackageInfo))
      ((PackageInfo)paramf).setParent(this);
    this.packageInfos.add(paramf);
  }

  public List getPackageInfos()
  {
    return this.packageInfos;
  }

  public String getDisplayName()
  {
    return this.displayName;
  }

  public String getProjectName()
  {
    if ((this.parent instanceof ProjectInfo))
      return ((ProjectInfo)this.parent).getDisplayName();
    if ((this.parent instanceof GroupInfo))
      return ((GroupInfo)this.parent).getProjectName();
    return "";
  }

  public String getUuid()
  {
    if (StringUtil.isEmpty(this.uuid))
      this.uuid = TempID.newShortTempID();
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

  public boolean exitsPackage(String paramString)
  {
    for (int i = 0; i < this.packageInfos.size(); i++)
      if ((this.packageInfos.get(i) instanceof GroupInfo))
      {
        if (((GroupInfo)this.packageInfos.get(i)).exitsPackage(paramString))
          return true;
      }
      else if (((this.packageInfos.get(i) instanceof PackageInfo)) && ((paramString == null) || (((PackageInfo)this.packageInfos.get(i)).getExename().equalsIgnoreCase(paramString))))
        return true;
    return false;
  }

  public String getIconName()
  {
    return "RuleGroup";
  }

  public String getGroupNames()
  {
    if ((getParent() instanceof ProjectInfo))
      return getDisplayName();
    if ((getParent() instanceof GroupInfo))
      return ((GroupInfo)getParent()).getGroupNames() + "," + getDisplayName();
    return getDisplayName();
  }

  public GroupInfo findOrCreate(String paramString)
  {
    String str1 = null;
    String str2 = null;
    if (paramString.indexOf(",") > 0)
    {
      str1 = paramString.substring(0, paramString.indexOf(","));
      str2 = paramString.substring(paramString.indexOf(",") + 1);
    }
    else
    {
      str1 = paramString;
    }
    GroupInfo localGroupInfo = null;
    for (int i = 0; i < this.packageInfos.size(); i++)
    {
      if ((!(this.packageInfos.get(i) instanceof GroupInfo)) || (!((GroupInfo)this.packageInfos.get(i)).getDisplayName().equalsIgnoreCase(str1)))
        continue;
      localGroupInfo = (GroupInfo)this.packageInfos.get(i);
      break;
    }
    if (localGroupInfo == null)
    {
      localGroupInfo = new GroupInfo(str1);
      localGroupInfo.setParent(this);
      this.packageInfos.add(localGroupInfo);
    }
    if (str2 == null)
      return localGroupInfo;
    return localGroupInfo.findOrCreate(str2);
  }

  public p getWebProject()
  {
    if ((getParent() instanceof ProjectInfo))
      return ((ProjectInfo)getParent()).getWebProject();
    if ((getParent() instanceof GroupInfo))
      return ((GroupInfo)getParent()).getWebProject();
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.GroupInfo
 * JD-Core Version:    0.6.0
 */