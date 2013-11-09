package com.flagleader.repository.d;

import com.flagleader.engine.Property;
import com.flagleader.engine.RuleEngine;
import com.flagleader.engine.RuleEngineClassLoader;
import com.flagleader.engine.RuleEngineException;
import com.flagleader.engine.RuleEngineFactory;
import com.flagleader.engine.impl.RuleRecordServer;
import com.flagleader.repository.h;
import com.flagleader.repository.m;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestCaseLib;
import com.flagleader.repository.tree.TestObjectInfo;
import com.flagleader.util.EngineLogger;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import com.flagleader.util.filesystem.FileUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang.SystemUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class A
{
  Workbook a = null;
  CellStyle b;
  Sheet c = null;
  FormulaEvaluator d;
  CellStyle e;
  CellStyle f;
  CellStyle g;
  CellStyle h;
  CellStyle i;
  n j;
  int k = 0;
  private static final int l = 3;

  public A(n paramn)
  {
    this.j = paramn;
  }

  private void a(int paramInt1, int paramInt2, String paramString)
  {
    Row localRow = this.c.createRow(paramInt1);
    Cell localCell = localRow.createCell(paramInt2);
    localCell.setCellValue(paramString);
    CellStyle localCellStyle = this.a.createCellStyle();
    Font localFont = this.a.createFont();
    localFont.setBoldweight(700);
    localCellStyle.setAlignment(2);
    localCellStyle.setFont(localFont);
    localCell.setCellStyle(localCellStyle);
  }

  private void b()
  {
    Font localFont = this.a.createFont();
    this.e = this.a.createCellStyle();
    localFont.setColor(IndexedColors.RED.getIndex());
    this.e.setFont(localFont);
    this.e.setWrapText(true);
    this.f = this.a.createCellStyle();
    localFont = this.a.createFont();
    localFont.setColor(IndexedColors.BLUE.getIndex());
    this.f.setFont(localFont);
    this.f.setWrapText(true);
  }

  private String a(int paramInt1, int paramInt2)
  {
    Row localRow = this.c.getRow(paramInt1);
    if (localRow != null)
    {
      Cell localCell = localRow.getCell(paramInt2);
      if (localCell != null)
        return b(localCell);
    }
    return null;
  }

  private Object a(Cell paramCell)
  {
    if (paramCell != null)
      switch (paramCell.getCellType())
      {
      case 4:
        return new Boolean(paramCell.getBooleanCellValue());
      case 0:
        if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(paramCell))
          return paramCell.getDateCellValue();
        return new Double(paramCell.getNumericCellValue());
      case 1:
        return paramCell.getStringCellValue();
      case 3:
        break;
      case 5:
        break;
      case 2:
        try
        {
          CellValue localCellValue = this.d.evaluate(paramCell);
          switch (localCellValue.getCellType())
          {
          case 4:
            return new Boolean(localCellValue.getBooleanValue());
          case 0:
            return new Double(localCellValue.getNumberValue());
          case 1:
            return localCellValue.getStringValue();
          case 3:
            break;
          case 5:
          case 2:
          }
        }
        catch (Exception localException)
        {
        }
      }
    return null;
  }

  private String b(Cell paramCell)
  {
    if (paramCell != null)
      switch (paramCell.getCellType())
      {
      case 4:
        return String.valueOf(paramCell.getBooleanCellValue());
      case 0:
        if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(paramCell))
          return Property.getInstance().formatDate(paramCell.getDateCellValue());
        return StringUtil.stringValue(paramCell.getNumericCellValue());
      case 1:
        return paramCell.getStringCellValue();
      case 3:
        break;
      case 5:
        break;
      case 2:
        try
        {
          CellValue localCellValue = this.d.evaluate(paramCell);
          switch (localCellValue.getCellType())
          {
          case 4:
            return String.valueOf(localCellValue.getBooleanValue());
          case 0:
            return StringUtil.stringValue(localCellValue.getNumberValue());
          case 1:
            return localCellValue.getStringValue();
          case 3:
            break;
          case 5:
          case 2:
          }
        }
        catch (Exception localException)
        {
        }
      }
    return null;
  }

  private void a(int paramInt, RulePackage paramRulePackage)
  {
    Row localRow1 = this.c.createRow(paramInt);
    Cell localCell1 = localRow1.createCell(0);
    localCell1.setCellStyle(this.g);
    localCell1.setCellValue(paramRulePackage.getExeRulePackageName());
    localCell1 = localRow1.createCell(1);
    localCell1.setCellStyle(this.g);
    localCell1.setCellValue(paramRulePackage.getDisplayName());
    Iterator localIterator = paramRulePackage.getEnvionment().getAcceptElements(new B(this));
    int m = 3;
    localCell1 = localRow1.createCell(m++);
    localCell1.setCellValue(u.a("testcaseresult.text"));
    ArrayList localArrayList1 = new ArrayList();
    while (localIterator.hasNext())
    {
      localObject = (MappingVariable)localIterator.next();
      if ((((MappingVariable)localObject).getInout() == 1) || (((MappingVariable)localObject).getInout() == 3))
      {
        localCell1 = localRow1.createCell(m++);
        localCell1.setCellStyle(this.h);
        localCell1.setCellValue(((MappingVariable)localObject).getShowDisplayName());
        localArrayList1.add(new G(this, ((MappingVariable)localObject).getShowDisplayName(), true, m));
      }
      if ((((MappingVariable)localObject).getInout() != 2) && (((MappingVariable)localObject).getInout() != 3))
        continue;
      localCell1 = localRow1.createCell(m++);
      localCell1.setCellStyle(this.i);
      localCell1.setCellValue(((MappingVariable)localObject).getShowDisplayName());
      localArrayList1.add(new G(this, ((MappingVariable)localObject).getShowDisplayName(), false, m));
    }
    Object localObject = paramRulePackage.getAcceptChildren(new C(this));
    int n = 0;
    int i1 = this.k;
    while (((Iterator)localObject).hasNext())
    {
      TestCaseLib localTestCaseLib = (TestCaseLib)((Iterator)localObject).next();
      localTestCaseLib.initTestInfo();
      ArrayList localArrayList2 = localTestCaseLib.getTestInfos();
      for (int i2 = 0; i2 < localArrayList2.size(); i2++)
      {
        n++;
        Row localRow2 = this.c.createRow(++this.k);
        Cell localCell2 = localRow2.createCell(0);
        localCell2.setCellStyle(this.g);
        localCell2.setCellValue(paramRulePackage.getExeRulePackageName());
        Cell localCell3 = localRow2.createCell(2);
        localCell3.setCellValue("test" + n);
        TestCase localTestCase = (TestCase)localArrayList2.get(i2);
        for (int i3 = 0; i3 < localArrayList1.size(); i3++)
        {
          G localG = (G)localArrayList1.get(i3);
          localCell3 = localRow2.createCell(i3 + 4);
          TestObjectInfo localTestObjectInfo = localTestCase.getMatchTestObjectInfo(localG.a);
          if (localTestObjectInfo == null)
            continue;
          if (localG.b)
            localCell3.setCellValue(localTestObjectInfo.getInitialValue());
          else
            localCell3.setCellValue(localTestObjectInfo.getExpectValue());
        }
      }
    }
    if (this.k - 1 > i1)
      this.c.groupRow(i1, this.k - 1);
  }

  public void a(IRuleGroup paramIRuleGroup, File paramFile)
  {
    if (paramFile.getName().endsWith(".xls"))
      this.a = new HSSFWorkbook();
    else
      this.a = new XSSFWorkbook();
    this.b = this.a.createCellStyle();
    this.b.setDataFormat(this.a.getCreationHelper().createDataFormat().getFormat("m/d/yy"));
    this.g = this.a.createCellStyle();
    Font localFont = this.a.createFont();
    this.g.setFont(localFont);
    this.h = this.a.createCellStyle();
    localFont = this.a.createFont();
    localFont.setColor(IndexedColors.PINK.getIndex());
    this.h.setFont(localFont);
    this.i = this.a.createCellStyle();
    localFont = this.a.createFont();
    localFont.setColor(IndexedColors.GREEN.getIndex());
    this.i.setFont(localFont);
    this.c = this.a.createSheet(paramIRuleGroup.getDisplayName());
    a(0, 0, paramIRuleGroup.getDisplayName());
    this.c.addMergedRegion(new CellRangeAddress(0, 0, 0, 5));
    this.c.createFreezePane(0, 2, 0, 2);
    this.k = 0;
    this.k = 2;
    Iterator localIterator = paramIRuleGroup.getAcceptElements(new D(this));
    ArrayList localArrayList = new ArrayList();
    while (localIterator.hasNext())
    {
      RulePackage localRulePackage1 = (RulePackage)localIterator.next();
      localArrayList.add(localRulePackage1);
    }
    for (int m = 0; m < localArrayList.size(); m++)
    {
      RulePackage localRulePackage2 = (RulePackage)localArrayList.get(m);
      this.j.a(m * 100 / localArrayList.size());
      a(this.k, localRulePackage2);
      this.k += 2;
    }
    this.c.autoSizeColumn(0);
    if (!paramFile.exists())
      paramFile.createNewFile();
    FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
    this.a.write(localFileOutputStream);
    localFileOutputStream.flush();
    localFileOutputStream.close();
    this.j.a(100);
  }

  private void a(RulePackage paramRulePackage)
  {
    int m = -1;
    for (int n = 0; n < 65533; n++)
    {
      String str1 = a(n, 0);
      if (!paramRulePackage.getExeRulePackageName().equalsIgnoreCase(str1))
        continue;
      m = n;
      break;
    }
    if (m >= 0)
    {
      Iterator localIterator1 = paramRulePackage.getEnvionment().getAcceptElements(new E(this));
      int i1 = 4;
      HashMap localHashMap1 = new HashMap();
      HashMap localHashMap2 = new HashMap();
      Row localRow = this.c.getRow(m);
      String str3;
      while (localIterator1.hasNext())
      {
        localObject = (MappingVariable)localIterator1.next();
        if (((MappingVariable)localObject).getInout() == 1)
          for (i2 = 4; i2 < 256; i2++)
          {
            str3 = b(localRow.getCell(i2));
            if (!((MappingVariable)localObject).getShowDisplayName().equalsIgnoreCase(str3))
              continue;
            localHashMap1.put(((MappingVariable)localObject).getValueName(), new Integer(i2));
            break;
          }
        if (((MappingVariable)localObject).getInout() == 2)
          for (i2 = 4; i2 < 256; i2++)
          {
            str3 = b(localRow.getCell(i2));
            if (!((MappingVariable)localObject).getShowDisplayName().equalsIgnoreCase(str3))
              continue;
            localHashMap2.put(((MappingVariable)localObject).getValueName(), new Integer(i2));
            break;
          }
        if (((MappingVariable)localObject).getInout() != 3)
          continue;
        for (int i2 = 4; i2 < 256; i2++)
        {
          str3 = b(localRow.getCell(i2));
          if (!((MappingVariable)localObject).getShowDisplayName().equalsIgnoreCase(str3))
            continue;
          localHashMap1.put(((MappingVariable)localObject).getValueName(), new Integer(i2));
          break;
        }
        while (i2 < 256)
        {
          str3 = b(localRow.getCell(i2));
          if (((MappingVariable)localObject).getShowDisplayName().equalsIgnoreCase(str3))
          {
            localHashMap2.put(((MappingVariable)localObject).getValueName(), new Integer(i2));
            break;
          }
          i2++;
        }
      }
      b(paramRulePackage);
      Object localObject = new HashMap();
      m++;
      for (localRow = this.c.getRow(m); (localRow != null) && (a(localRow, (HashMap)localObject, paramRulePackage, localHashMap1)); localRow = this.c.getRow(m))
      {
        try
        {
          a(paramRulePackage, (HashMap)localObject);
          String str2 = "";
          str3 = "";
          Iterator localIterator2 = localHashMap2.keySet().iterator();
          while (localIterator2.hasNext())
          {
            String str4 = (String)localIterator2.next();
            int i3 = ((Integer)localHashMap2.get(str4)).intValue();
            String str5 = b(localRow.getCell(i3));
            if (!a(str5, ((HashMap)localObject).get(str4)))
            {
              if (str2.length() > 0)
                str2 = str2 + FileUtil.newline;
              str2 = str2 + str4 + ":" + StringUtil.stringValue(str5) + " != " + StringUtil.stringValue(((HashMap)localObject).get(str4));
            }
            if (str3.length() > 0)
              str3 = str3 + FileUtil.newline;
            str3 = str3 + StringUtil.stringValue(((HashMap)localObject).get(str4));
          }
          if (str2.length() > 0)
            a(localRow, str2);
          else
            b(localRow, str3);
        }
        catch (Exception localException)
        {
          a(localRow, localException.getLocalizedMessage());
        }
        m++;
      }
    }
  }

  private boolean a(Object paramObject1, Object paramObject2)
  {
    if (paramObject1 == null)
    {
      if (paramObject2 == null)
        return true;
      if ((paramObject2 instanceof String))
        return ((String)paramObject2).length() == 0;
      if ((paramObject2 instanceof Number))
        return ((Number)paramObject2).doubleValue() == 0.0D;
      return StringUtil.isEmpty(paramObject2.toString());
    }
    if (((paramObject1 instanceof Number)) || ((paramObject2 instanceof Number)))
      return NumberUtil.getDouble(paramObject1) == NumberUtil.getDouble(paramObject2);
    String str;
    if ((paramObject1 instanceof String))
    {
      str = (String)paramObject1;
      if (str.length() == 0)
      {
        if (paramObject2 == null)
          return true;
        if ((paramObject2 instanceof String))
          return ((String)paramObject2).length() == 0;
        if ((paramObject2 instanceof Number))
          return ((Number)paramObject2).doubleValue() == 0.0D;
        return StringUtil.isEmpty(paramObject2.toString());
      }
      return StringUtil.equalsCase(str, StringUtil.stringValue(paramObject2));
    }
    if ((paramObject2 instanceof String))
    {
      str = (String)paramObject2;
      if (str.length() == 0)
      {
        if (paramObject1 == null)
          return true;
        if ((paramObject1 instanceof String))
          return ((String)paramObject1).length() == 0;
        if ((paramObject1 instanceof Number))
          return ((Number)paramObject1).doubleValue() == 0.0D;
        return StringUtil.isEmpty(paramObject1.toString());
      }
      return StringUtil.equalsCase(str, StringUtil.stringValue(paramObject1));
    }
    if (((paramObject1 instanceof Date)) || ((paramObject2 instanceof Date)))
      return com.flagleader.util.DateUtil.getDate(paramObject1).equals(com.flagleader.util.DateUtil.getDate(paramObject2));
    return paramObject1.equals(paramObject2);
  }

  private void a(Row paramRow, String paramString)
  {
    Cell localCell = paramRow.getCell(3);
    if (localCell == null)
      localCell = paramRow.createCell(3);
    localCell.setCellValue(paramString);
    localCell.setCellStyle(this.e);
  }

  private void b(Row paramRow, String paramString)
  {
    Cell localCell = paramRow.getCell(3);
    if (localCell == null)
      localCell = paramRow.createCell(3);
    localCell.setCellValue(paramString);
    localCell.setCellStyle(this.f);
  }

  private boolean a(Row paramRow, HashMap paramHashMap1, RulePackage paramRulePackage, HashMap paramHashMap2)
  {
    paramHashMap1.clear();
    String str1 = b(paramRow.getCell(2));
    String str2 = b(paramRow.getCell(0));
    if (!StringUtil.isEmpty(str1))
    {
      if ((!StringUtil.isEmpty(str2)) && (!str2.equalsIgnoreCase(paramRulePackage.getExeRulePackageName())))
        return false;
      Iterator localIterator = paramHashMap2.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str3 = (String)localIterator.next();
        int m = ((Integer)paramHashMap2.get(str3)).intValue();
        String str4 = b(paramRow.getCell(m));
        if ((str4 == null) || (StringUtil.isEmpty(str4.toString())))
          continue;
        paramHashMap1.put(str3, str4);
      }
      return true;
    }
    return false;
  }

  private void b(RulePackage paramRulePackage)
  {
    try
    {
      RuleEngineClassLoader localRuleEngineClassLoader = RuleEngineFactory.getInstance(paramRulePackage.getUuid()).getClassLoader();
      localRuleEngineClassLoader.addResourceFile(new File(paramRulePackage.getCompilePath()));
      localRuleEngineClassLoader.addResourceFile(new File(paramRulePackage.getExportDirPath()));
      localRuleEngineClassLoader.addResourceFiles(paramRulePackage.getClassPaths());
      localRuleEngineClassLoader.addResourceFiles(paramRulePackage.getEnvionment().getClassDirs());
      localRuleEngineClassLoader.addResourceFile(new File(SystemUtils.JAVA_IO_TMPDIR));
      localRuleEngineClassLoader.addResourceFiles(a.d());
      RuleEngineFactory.newInstance().getClassLoader().addResourceFile(new File(paramRulePackage.getCompilePath()));
      RuleEngineFactory.newInstance().getClassLoader().addResourceFile(new File(SystemUtils.JAVA_IO_TMPDIR));
      RuleEngineFactory.newInstance().getClassLoader().addResourceFiles(paramRulePackage.getClassPaths());
      RuleEngineFactory.newInstance().getClassLoader().addResourceFiles(paramRulePackage.getEnvionment().getClassDirs());
      RuleEngineFactory.newInstance().getClassLoader().addResourceFiles(a.d());
      RuleRecordServer.clearUnused();
    }
    catch (Exception localException)
    {
      EngineLogger.getEngineLogger().info(localException.getLocalizedMessage(), localException);
    }
  }

  protected void a(RulePackage paramRulePackage, HashMap paramHashMap)
  {
    try
    {
      RuleEngine localRuleEngine = RuleEngineFactory.getInstance(paramRulePackage.getUuid()).getRuleEngine();
      localRuleEngine.putAll(paramHashMap);
      localRuleEngine.excute(paramRulePackage.getExeRulePackageName());
      paramHashMap.clear();
      paramHashMap.putAll(localRuleEngine.getAll());
      System.gc();
    }
    catch (RuleEngineException localRuleEngineException)
    {
      a().a(localRuleEngineException.getMessage());
    }
    catch (Exception localException)
    {
      a().a(localException.getMessage());
    }
  }

  protected h a()
  {
    return m.a().j();
  }

  public void b(IRuleGroup paramIRuleGroup, File paramFile)
  {
    if (paramFile.getName().endsWith(".xls"))
      this.a = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(paramFile)));
    else
      this.a = new XSSFWorkbook(paramFile.getPath());
    this.c = this.a.getSheet(paramIRuleGroup.getDisplayName());
    this.d = this.a.getCreationHelper().createFormulaEvaluator();
    b();
    int m = 0;
    Iterator localIterator = paramIRuleGroup.getAcceptElements(new F(this));
    ArrayList localArrayList = new ArrayList();
    while (localIterator.hasNext())
    {
      RulePackage localRulePackage1 = (RulePackage)localIterator.next();
      localArrayList.add(localRulePackage1);
    }
    for (int n = 0; n < localArrayList.size(); n++)
    {
      RulePackage localRulePackage2 = (RulePackage)localArrayList.get(n);
      this.j.a(n * 100 / localArrayList.size());
      a(localRulePackage2);
    }
    FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
    this.a.write(localFileOutputStream);
    localFileOutputStream.flush();
    localFileOutputStream.close();
    this.j.a(100);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.d.A
 * JD-Core Version:    0.6.0
 */