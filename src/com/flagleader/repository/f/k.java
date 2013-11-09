package com.flagleader.repository.f;

import com.flagleader.repository.tree.PackageInfo;
import com.flagleader.repository.tree.ProjectInfo;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class k
  implements p
{
  private String e = ".";
  public static final String a = "data";
  public static final String b = "default.prj";
  public static final String c = "bak";
  ProjectInfo d;

  public k()
  {
  }

  public synchronized void a()
  {
    try
    {
      e locale = new e(new File(this.e, "default.prj"));
      locale.a(this.d);
      locale.close();
    }
    catch (Exception localException)
    {
    }
  }

  private int b(String paramString, File paramFile)
  {
    int i = 1;
    if (paramFile.isDirectory())
      while (new File(paramFile.getPath(), c(paramString) + ".rpk~" + i + "~").exists())
        i++;
    return i;
  }

  public void a(String paramString)
  {
    File localFile = new File(e(), c(paramString) + ".rpk");
    if (localFile.exists())
      FileUtil.copy(localFile, new File(d(), c(paramString) + ".rpk" + "~" + b(paramString, localFile.getParentFile()) + "~"), true);
  }

  private String c(String paramString)
  {
    return paramString.replace('.', '/');
  }

  public synchronized void b()
  {
    try
    {
      FileUtil.deleteAllFilesThenDirectories(new File(this.e), false);
      new File(this.e).delete();
      n.e().f().remove(this);
    }
    catch (Exception localException)
    {
    }
  }

  public ProjectInfo c()
  {
    return this.d;
  }

  public void a(ProjectInfo paramProjectInfo)
  {
    this.d = paramProjectInfo;
  }

  public String d()
  {
    return new File(this.e, "bak").getPath();
  }

  public String e()
  {
    return new File(this.e, "data").getPath();
  }

  public k(String paramString, ProjectInfo paramProjectInfo)
  {
    this.e = paramString;
    this.d = paramProjectInfo;
    paramProjectInfo.setWebProject(this);
  }

  public String f()
  {
    return this.d.getDisplayName();
  }

  public File a(PackageInfo paramPackageInfo)
  {
    File localFile = new File(this.e, "data/" + paramPackageInfo.getFileName());
    return localFile;
  }

  public void b(String paramString)
  {
    this.d = new ProjectInfo();
    this.d.setDisplayName(paramString);
    this.d.setWebProject(this);
    new File(n.e().c(), paramString).mkdirs();
    this.e = new File(n.e().c(), paramString).getPath();
    new File(this.e, "data").mkdirs();
    n.e().a(this.d);
  }

  public long b(PackageInfo paramPackageInfo)
  {
    File localFile = new File(this.e, "data/" + paramPackageInfo.getFileName());
    if (localFile.exists())
      return localFile.lastModified();
    return 0L;
  }

  public void g()
  {
    File localFile = new File(this.e);
    ArrayList localArrayList = new ArrayList();
    a("", new File(localFile.getPath(), "data"));
  }

  void a(String paramString, File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles(new l(this));
    for (int i = 0; (arrayOfFile != null) && (i < arrayOfFile.length); i++)
    {
      String str;
      if (arrayOfFile[i].isDirectory())
      {
        str = arrayOfFile[i].getName();
        if (paramString.length() > 0)
          str = paramString + "." + arrayOfFile[i].getName();
        a(str, arrayOfFile[i]);
      }
      else
      {
        str = arrayOfFile[i].getName().substring(0, arrayOfFile[i].getName().length() - 4);
        if (paramString.length() > 0)
          str = paramString + "." + str;
        if (d(str))
          continue;
        PackageInfo localPackageInfo = new PackageInfo(str, arrayOfFile[i]);
        this.d.addPackageInfo(localPackageInfo);
      }
    }
  }

  private boolean d(String paramString)
  {
    return this.d.exitsPackage(paramString);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.f.k
 * JD-Core Version:    0.6.0
 */