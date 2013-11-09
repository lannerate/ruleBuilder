package com.flagleader.repository.tree;

import com.flagleader.repository.f;
import com.flagleader.repository.f.p;
import java.util.List;

public abstract interface al
{
  public abstract String getUuid();

  public abstract List getPackageInfos();

  public abstract String getIconName();

  public abstract String getDisplayName();

  public abstract void removeInfo(Object paramObject);

  public abstract void addPackageInfo(f paramf);

  public abstract p getWebProject();

  public abstract void setDisplayName(String paramString);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.al
 * JD-Core Version:    0.6.0
 */