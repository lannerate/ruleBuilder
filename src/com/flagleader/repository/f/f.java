package com.flagleader.repository.f;

import com.flagleader.repository.tree.PackageInfo;
import com.flagleader.repository.tree.ProjectInfo;
import java.io.File;
import java.util.List;

public class f
  implements p
{
  ProjectInfo a;
  private h b;

  public f(h paramh)
  {
    this.b = paramh;
  }

  public f(h paramh, ProjectInfo paramProjectInfo)
  {
    this.b = paramh;
    this.a = paramProjectInfo;
    paramProjectInfo.setWebProject(this);
  }

  public synchronized void a()
  {
  }

  public synchronized void b()
  {
    try
    {
      this.b.c(this.a.getDisplayName());
      this.b.d().remove(this);
    }
    catch (Exception localException)
    {
    }
  }

  public ProjectInfo c()
  {
    return this.a;
  }

  public void a(ProjectInfo paramProjectInfo)
  {
    this.a = paramProjectInfo;
  }

  public String d()
  {
    return this.a.getDisplayName();
  }

  public File a(PackageInfo paramPackageInfo)
  {
    return null;
  }

  public long b(PackageInfo paramPackageInfo)
  {
    return paramPackageInfo.getFileTime();
  }

  private boolean a(String paramString)
  {
    return this.a.exitsPackage(paramString);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.f.f
 * JD-Core Version:    0.6.0
 */