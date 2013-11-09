package com.flagleader.manager.e;

import com.flagleader.manager.d.c;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.util.TempID;
import com.flagleader.util.ZipCompressor;
import com.flagleader.util.filesystem.FileUtil;
import com.flagleader.util.zip.ApacheZipTool;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang.SystemUtils;

class Y extends Thread
{
  Y(X paramX, IRuleGroup paramIRuleGroup, String paramString)
  {
  }

  public void run()
  {
    try
    {
      Iterator localIterator = this.b.getAcceptElements(new Z(this));
      ArrayList localArrayList = new ArrayList();
      while (localIterator.hasNext())
        localArrayList.add(localIterator.next());
      File localFile = new File(SystemUtils.JAVA_COMPILER, TempID.newShortTempID());
      localFile.mkdirs();
      for (int i = 0; i < localArrayList.size(); i++)
      {
        X.a(this.a, (IRulePackage)localArrayList.get(i), localFile.getPath());
        this.a.a(90 * i / localArrayList.size());
      }
      if (this.c.toLowerCase().endsWith(".zip"))
      {
        ApacheZipTool.zipFiles(localFile.getPath(), this.c);
      }
      else
      {
        ZipCompressor localZipCompressor = new ZipCompressor(this.c);
        localZipCompressor.compressDirectory(localFile.getPath());
      }
      FileUtil.deleteAllFilesThenDirectories(localFile, false);
      localFile.delete();
      this.a.o().c(c.a("HasBeenExport", new String[] { this.c }));
    }
    catch (Throwable localThrowable)
    {
      this.a.o().a(localThrowable.getLocalizedMessage());
    }
    this.a.a(100);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.Y
 * JD-Core Version:    0.6.0
 */