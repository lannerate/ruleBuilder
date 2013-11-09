package com.flagleader.manager.e;

import com.flagleader.manager.d.c;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.IRule;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class C extends Thread
{
  C(B paramB, String paramString, List paramList)
  {
  }

  public void run()
  {
    Object localObject1 = null;
    try
    {
      this.a.a(1);
      Object localObject2 = null;
      if (this.b.endsWith(".xls"))
      {
        localObject3 = new FileInputStream(this.b);
        POIFSFileSystem localPOIFSFileSystem = new POIFSFileSystem((InputStream)localObject3);
        localObject2 = new HSSFWorkbook(localPOIFSFileSystem);
        ((FileInputStream)localObject3).close();
      }
      else
      {
        localObject2 = new XSSFWorkbook(this.b);
      }
      Object localObject3 = null;
      for (int i = 0; i < this.c.size(); i++)
      {
        this.a.a(100 / this.c.size());
        if (!(this.c.get(i) instanceof IRule))
          continue;
        localObject3 = ((Workbook)localObject2).getSheet(((IRule)this.c.get(i)).getDisplayName());
        if (localObject3 == null)
          continue;
        ((IRule)this.c.get(i)).compareExcelSheet((Sheet)localObject3);
      }
      File localFile = new File(this.b);
      if (!localFile.exists())
        localFile.createNewFile();
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      ((Workbook)localObject2).write(localFileOutputStream);
      localFileOutputStream.flush();
      localFileOutputStream.close();
      this.a.o().c(c.a("HasBeenExport", new String[] { this.b }));
    }
    catch (Exception localException)
    {
      this.a.b(localException.getMessage());
      this.a.o().a(c.a("error.ExportRuleExcelInfo", new String[] { localException.getMessage() }), localException);
      this.a.a(100);
      return;
    }
    this.a.a(100);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.manager.e.C
 * JD-Core Version:    0.6.0
 */