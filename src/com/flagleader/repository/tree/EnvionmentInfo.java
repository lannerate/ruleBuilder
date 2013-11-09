package com.flagleader.repository.tree;

import com.flagleader.repository.f;
import com.flagleader.util.TempID;

public class EnvionmentInfo
  implements f
{
  public static final String FILEEXT = ".env";
  private String displayName = "";
  private String fileName = "";
  private String uuid = null;

  public String getUuid()
  {
    if ((this.uuid == null) || (this.uuid.length() == 0))
      this.uuid = TempID.newShortTempID();
    return this.uuid;
  }

  public String getDisplayName()
  {
    return this.displayName;
  }

  public void setDisplayName(String paramString)
  {
    this.displayName = paramString;
  }

  public String getFileName()
  {
    if (this.fileName.length() == 0)
      return getDisplayName() + ".env";
    return this.fileName;
  }

  public void setFileName(String paramString)
  {
    this.fileName = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.EnvionmentInfo
 * JD-Core Version:    0.6.0
 */