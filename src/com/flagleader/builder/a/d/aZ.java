package com.flagleader.builder.a.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.repository.a.a;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import org.apache.commons.lang.SystemUtils;

class aZ extends Thread
{
  aZ(aY paramaY, boolean paramBoolean)
  {
  }

  public void run()
  {
    String str1 = SystemUtils.JAVA_IO_TMPDIR;
    File localFile = new File(str1 + File.separator + this.a.e().getMainPackage().getUuid(), this.a.e().getEditUuid() + "J.jsp");
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
        str2 = this.a.e().getExportStr();
        this.a.a(str2);
      }
      catch (a locala)
      {
        aY.a(this.a, this.a.e(), locala);
        this.a.b(aY.b(this.a));
        return;
      }
      catch (Exception localException2)
      {
        aY.c(this.a).getUserLogger().a(localException2.getLocalizedMessage(), localException2);
        this.a.b(aY.b(this.a));
        return;
      }
    if (i == 0)
      try
      {
        FileUtil.saveToFile(localFile, new StringBuffer(str2));
      }
      catch (Exception localException3)
      {
        localException3.printStackTrace();
      }
    this.a.b(aY.b(this.a));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.aZ
 * JD-Core Version:    0.6.0
 */