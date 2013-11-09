package com.flagleader.repository.tree;

import com.flagleader.repository.f;
import com.flagleader.repository.f.p;
import com.flagleader.util.StringUtil;
import com.flagleader.util.TempID;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class PackageInfo
  implements f
{
  private String exename = "";
  private String displayName = "";
  private String fileName = "";
  private int ruleEditLevel = 0;
  private int ruleid = 0;
  private double rulever = 0.0D;
  private File packFile = null;
  private long fileTime = 0L;
  private String uuid = null;
  private boolean locked = false;
  private int checkType = 0;
  private f parent;

  public File getPackFile()
  {
    if (this.packFile == null)
    {
      p localp = getWebProject();
      if (localp != null)
        this.packFile = localp.a(this);
    }
    return this.packFile;
  }

  public void setFileTime(long paramLong)
  {
    this.fileTime = paramLong;
  }

  public String getUuid()
  {
    if ((this.uuid == null) || (this.uuid.length() == 0))
      this.uuid = TempID.newShortTempID();
    return this.uuid;
  }

  public f getParent()
  {
    return this.parent;
  }

  public void setParent(f paramf)
  {
    this.parent = paramf;
  }

  public PackageInfo()
  {
  }

  public PackageInfo(String paramString, File paramFile)
  {
    this.packFile = paramFile;
    this.exename = paramString;
    this.fileTime = paramFile.lastModified();
    this.fileName = (StringUtil.replaceAll(paramString, ".", "/") + ".rpk");
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      FileInputStream localFileInputStream = new FileInputStream(paramFile);
      BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localFileInputStream));
      for (String str = localBufferedReader.readLine(); str != null; str = localBufferedReader.readLine())
      {
        if (!str.startsWith("<RulePackage"))
          continue;
        String[] arrayOfString = str.split(" ");
        for (int i = 0; i < arrayOfString.length; i++)
        {
          if (!arrayOfString[i].startsWith("displayName=\""))
            continue;
          this.displayName = arrayOfString[i].substring("displayName=\"".length(), arrayOfString[i].length() - 1);
        }
        break;
      }
      localBufferedReader.close();
      localFileInputStream.close();
    }
    catch (Exception localException)
    {
    }
  }

  public int getCheckType()
  {
    return this.checkType;
  }

  public void setCheckType(int paramInt)
  {
    this.checkType = paramInt;
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
    return this.fileName;
  }

  public void setFileName(String paramString)
  {
    this.fileName = paramString;
  }

  public boolean isLocked()
  {
    return this.locked;
  }

  public void setLocked(boolean paramBoolean)
  {
    this.locked = paramBoolean;
  }

  public String getExename()
  {
    return this.exename;
  }

  public void setExename(String paramString)
  {
    this.exename = paramString;
  }

  public p getWebProject()
  {
    if ((getParent() instanceof ProjectInfo))
      return ((ProjectInfo)getParent()).getWebProject();
    if ((getParent() instanceof GroupInfo))
      return ((GroupInfo)getParent()).getWebProject();
    return null;
  }

  public long getFileTime()
  {
    if (this.fileTime != 0L)
      return this.fileTime;
    if (this.packFile == null)
    {
      p localp = getWebProject();
      if (localp != null)
        return localp.b(this);
    }
    else if (this.packFile.exists())
    {
      return this.packFile.lastModified();
    }
    return 0L;
  }

  public String getProjectName()
  {
    if ((this.parent instanceof ProjectInfo))
      return ((ProjectInfo)this.parent).getDisplayName();
    if ((this.parent instanceof GroupInfo))
      return ((GroupInfo)this.parent).getProjectName();
    return "";
  }

  public int getRuleEditLevel()
  {
    return this.ruleEditLevel;
  }

  public void setRuleEditLevel(int paramInt)
  {
    this.ruleEditLevel = paramInt;
  }

  public int getRuleid()
  {
    return this.ruleid;
  }

  public void setRuleid(int paramInt)
  {
    this.ruleid = paramInt;
  }

  public double getRulever()
  {
    return this.rulever;
  }

  public void setRulever(double paramDouble)
  {
    this.rulever = paramDouble;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.PackageInfo
 * JD-Core Version:    0.6.0
 */