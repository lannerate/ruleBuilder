package com.flagleader.manager.e;

import com.flagleader.engine.MessageUtil;
import com.flagleader.manager.d.c;
import com.flagleader.repository.h;
import com.flagleader.repository.tree.IRule;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class E extends Thread
{
  E(D paramD, String paramString, List paramList)
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
        localObject2 = new HSSFWorkbook();
      else
        localObject2 = new XSSFWorkbook();
      Sheet localSheet = null;
      Font localFont = ((Workbook)localObject2).createFont();
      localFont.setFontName(MessageUtil.getString("excelDefaultFontName"));
      localFont.setFontHeightInPoints(12);
      CellStyle localCellStyle = ((Workbook)localObject2).createCellStyle();
      localCellStyle.setBorderBottom(1);
      localCellStyle.setBorderLeft(1);
      localCellStyle.setBorderRight(1);
      localCellStyle.setBorderTop(1);
      localCellStyle.setFont(localFont);
      localCellStyle.setWrapText(true);
      for (int i = 0; i < this.c.size(); i++)
      {
        this.a.a(100 / this.c.size());
        if (!(this.c.get(i) instanceof IRule))
          continue;
        localSheet = ((Workbook)localObject2).createSheet(((IRule)this.c.get(i)).getDisplayName());
        ((IRule)this.c.get(i)).exportExcelSheet(localSheet, localCellStyle);
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
 * Qualified Name:     com.flagleader.manager.e.E
 * JD-Core Version:    0.6.0
 */