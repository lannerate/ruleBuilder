package com.flagleader.repository.tree;

import com.flagleader.repository.d.u;
import com.flagleader.repository.e.s;
import com.flagleader.repository.f;
import com.flagleader.repository.n;
import java.io.File;
import java.util.List;

public class ChildNodeInfo
  implements f
{
  private String nametype = "";
  private String displayName = "";
  private long modifyTime = 0L;
  private String uuid = "";

  public long getModifyTime()
  {
    return this.modifyTime;
  }

  public void setCheckType(int paramInt)
  {
    this.modifyTime = paramInt;
  }

  public String getDisplayName()
  {
    return this.displayName;
  }

  public void setDisplayName(String paramString)
  {
    this.displayName = paramString;
  }

  public String getNametype()
  {
    return this.nametype;
  }

  public void setNametype(String paramString)
  {
    this.nametype = paramString;
  }

  public void setModifyTime(long paramLong)
  {
    this.modifyTime = paramLong;
  }

  public String getUuid()
  {
    return this.uuid;
  }

  public void setUuid(String paramString)
  {
    this.uuid = paramString;
  }

  public ITreeNode loadFromFile(ITreeNode paramITreeNode, String paramString)
  {
    File localFile = new File(paramString + File.separator + this.displayName + "." + this.nametype);
    if (localFile.exists())
    {
      ParentInfo localParentInfo = (ParentInfo)new s().load(localFile);
      ITreeNode localITreeNode = (ITreeNode)localParentInfo.getElements();
      localITreeNode.setFileLastTime(localFile.lastModified());
      paramITreeNode.addChildElement(localITreeNode);
      List localList = localParentInfo.getChildNodeInfos();
      for (int i = 0; i < localList.size(); i++)
      {
        ChildNodeInfo localChildNodeInfo = (ChildNodeInfo)localList.get(i);
        localChildNodeInfo.loadFromFile(localITreeNode, paramString + File.separator + this.displayName);
      }
      return localITreeNode;
    }
    n.a().a(u.a("fileFormat.error", new String[] { localFile.getAbsolutePath() }));
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.ChildNodeInfo
 * JD-Core Version:    0.6.0
 */