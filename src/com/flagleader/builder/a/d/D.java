package com.flagleader.builder.a.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.IOException;
import org.apache.commons.lang.SystemUtils;

class D extends Thread
{
  D(C paramC, boolean paramBoolean)
  {
  }

  public void run()
  {
    String str1 = SystemUtils.JAVA_IO_TMPDIR;
    File localFile = new File(str1 + File.separator + this.a.e().getMainPackage().getUuid(), this.a.e().getEditUuid() + "S.java");
    int i = 0;
    String str2 = "";
    if ((localFile.exists()) && (!this.b) && (this.a.e().getModifyTime() < localFile.lastModified()))
      try
      {
        str2 = FileUtil.readFromFile(localFile);
        this.a.a(str2);
        i = 1;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
    if (i == 0)
      try
      {
        str2 = this.a.e().getDesignStr("a_");
        this.a.a(str2);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        C.b(this.a).getUserLogger().a(localClassNotFoundException.getLocalizedMessage(), localClassNotFoundException);
      }
      catch (InstantiationException localInstantiationException)
      {
        C.b(this.a).getUserLogger().a(localInstantiationException.getLocalizedMessage(), localInstantiationException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        C.b(this.a).getUserLogger().a(localIllegalAccessException.getLocalizedMessage(), localIllegalAccessException);
      }
      catch (IOException localIOException)
      {
        C.b(this.a).getUserLogger().a(localIOException.getLocalizedMessage(), localIOException);
      }
      catch (Exception localException2)
      {
        C.a(this.a, this.a.e().getDesignCompiler("a_"), localException2);
      }
    if (i == 0)
      try
      {
        localFile.getParentFile().mkdirs();
        FileUtil.saveToFile(localFile, new StringBuffer(str2));
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
      }
    this.a.b(C.c(this.a));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.D
 * JD-Core Version:    0.6.0
 */