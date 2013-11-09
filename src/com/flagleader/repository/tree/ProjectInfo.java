package com.flagleader.repository.tree;

import com.flagleader.repository.f;
import com.flagleader.repository.f.p;
import com.flagleader.util.StringUtil;
import com.flagleader.util.TempID;
import java.util.ArrayList;
import java.util.List;

public class ProjectInfo
  implements f, al
{
  private List filePathNames = new ArrayList();
  private String displayName = "";
  p a;
  private String uuid = "";
  private String projver = "";
  private int saveType = 0;
  private List packageInfos = new ArrayList();
  private String document = "";

  public p getWebProject()
  {
    return this.a;
  }

  public void setWebProject(p paramp)
  {
    this.a = paramp;
  }

  public void addFilePathName(String paramString)
  {
    this.filePathNames.add(paramString);
  }

  public List getFilePathNames()
  {
    return this.filePathNames;
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

  public int getSaveType()
  {
    return this.saveType;
  }

  public void setSaveType(int paramInt)
  {
    this.saveType = paramInt;
  }

  public String getProjver()
  {
    return this.projver;
  }

  public void setProjver(String paramString)
  {
    this.projver = paramString;
  }

  public String getDocument()
  {
    return this.document;
  }

  public void setDocument(String paramString)
  {
    this.document = paramString;
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

  public String getIconName()
  {
    return "RuleProject";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.ProjectInfo
 * JD-Core Version:    0.6.0
 */