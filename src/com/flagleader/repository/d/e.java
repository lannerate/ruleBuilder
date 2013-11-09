package com.flagleader.repository.d;

import com.flagleader.engine.MessageUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class e
{
  private String a;
  private Workbook b;
  private CellStyle c;
  private CellStyle d;

  public e(String paramString)
  {
    this.a = paramString;
    if (this.a.endsWith(".xls"))
      this.b = new HSSFWorkbook();
    else
      this.b = new XSSFWorkbook();
    this.c = this.b.createCellStyle();
    this.c.setDataFormat(this.b.getCreationHelper().createDataFormat().getFormat("m/d/yy"));
    this.c.setBorderBottom(1);
    this.c.setBorderLeft(1);
    this.c.setBorderRight(1);
    this.c.setBorderTop(1);
    Font localFont = this.b.createFont();
    localFont.setFontName(MessageUtil.getString("excelDefaultFontName"));
    int i = MessageUtil.getInt("excelDefaultFontSize");
    if (i == 11)
      localFont.setFontHeightInPoints(12);
    else
      localFont.setFontHeightInPoints((short)i);
    CellStyle localCellStyle = this.b.createCellStyle();
    localCellStyle.setBorderBottom(1);
    localCellStyle.setBorderLeft(1);
    localCellStyle.setBorderRight(1);
    localCellStyle.setBorderTop(1);
    localCellStyle.setFont(localFont);
    localCellStyle.setWrapText(true);
  }

  public void a()
  {
    File localFile = new File(this.a);
    if (!localFile.exists())
    {
      localFile.getParentFile().mkdirs();
      localFile.createNewFile();
    }
    FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
    this.b.write(localFileOutputStream);
    localFileOutputStream.flush();
    localFileOutputStream.close();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.d.e
 * JD-Core Version:    0.6.0
 */