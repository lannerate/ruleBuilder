package com.flagleader.builder.a.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.export.ExportAction;
import com.flagleader.repository.a.a;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.export.d;
import com.flagleader.repository.export.e;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import org.apache.commons.lang.SystemUtils;

class aT extends Thread
{
  aT(aS paramaS, boolean paramBoolean)
  {
  }

  public void run()
  {
    String str1 = SystemUtils.JAVA_IO_TMPDIR;
    File localFile = new File(str1 + File.separator + this.a.e().getMainPackage().getUuid(), this.a.e().getEditUuid() + aS.b(this.a));
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
        ExportAction localExportAction = e.a().a(aS.b(this.a)).b(aS.b(this.a));
        if (localExportAction != null)
        {
          localExportAction.addModel("exportModel", this.a.e());
          str2 = localExportAction.getText();
        }
        this.a.a(str2);
      }
      catch (a locala)
      {
        aS.a(this.a, this.a.e(), locala);
        this.a.b(aS.c(this.a));
        return;
      }
      catch (Exception localException2)
      {
        aS.d(this.a).getUserLogger().a(localException2.getLocalizedMessage(), localException2);
        this.a.b(aS.c(this.a));
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
    this.a.b(aS.c(this.a));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.aT
 * JD-Core Version:    0.6.0
 */