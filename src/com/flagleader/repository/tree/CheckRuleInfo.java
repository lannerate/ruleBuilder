package com.flagleader.repository.tree;

import com.flagleader.engine.Property;
import com.flagleader.repository.AbstractElement;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d.u;
import com.flagleader.repository.f;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CheckRuleInfo extends AbstractElement
  implements f, ao, Serializable
{
  private String excelFile = "";
  private String initValues = "";
  private String willValues = "";
  private transient ArrayList testInfos = new ArrayList();
  private transient boolean inited = false;
  CellStyle a;
  int b;

  public CheckRuleInfo()
  {
  }

  public CheckRuleInfo(CheckRuleInfo paramCheckRuleInfo)
  {
    this.initValues = paramCheckRuleInfo.initValues;
    this.willValues = paramCheckRuleInfo.willValues;
    this.excelFile = paramCheckRuleInfo.excelFile;
  }

  public IRulePackage getRuleSet()
  {
    return getMainPackage();
  }

  protected Object clone()
  {
    return new CheckRuleInfo(this);
  }

  public String[] getVarnames()
  {
    if (this.initValues.length() == 0)
      refreshInit();
    if (!this.inited)
      initTestInfo();
    String[] arrayOfString = this.initValues.split(";");
    if (arrayOfString.length > 0)
      return arrayOfString[0].split(",");
    return null;
  }

  public boolean refreshInit()
  {
    if (this.testInfos.size() == 0)
      initTestInfo();
    StringBuffer localStringBuffer1 = new StringBuffer();
    StringBuffer localStringBuffer2 = new StringBuffer();
    String[] arrayOfString = (String[])null;
    StringBuffer localStringBuffer3 = new StringBuffer();
    if (getEnvionment() != null)
    {
      List localList1 = getEnvionment().getValueLibrary().getChildrenList();
      arrayOfString = new String[localList1.size()];
      for (int j = 0; j < localList1.size(); j++)
      {
        MappingVariable localMappingVariable = (MappingVariable)localList1.get(j);
        arrayOfString[j] = localMappingVariable.getDisplayName();
      }
    }
    else
    {
      arrayOfString = getVarnames();
    }
    for (int i = 0; i < arrayOfString.length; i++)
    {
      localStringBuffer3.append(arrayOfString[i]);
      if (i >= arrayOfString.length - 1)
        continue;
      localStringBuffer3.append(",");
    }
    localStringBuffer1.append(localStringBuffer3).append(";");
    localStringBuffer2.append(localStringBuffer3).append(";");
    for (i = 0; i < this.testInfos.size(); i++)
    {
      TestCase localTestCase = (TestCase)this.testInfos.get(i);
      for (int k = 0; k < arrayOfString.length; k++)
      {
        List localList2 = localTestCase.getChildrenList();
        int m = 0;
        for (int n = 0; n < localList2.size(); n++)
        {
          TestObjectInfo localTestObjectInfo = (TestObjectInfo)localList2.get(n);
          if (!arrayOfString[k].equalsIgnoreCase(localTestObjectInfo.getDisplayName()))
            continue;
          localStringBuffer1.append(parseValue(localTestObjectInfo.getInitialValue()));
          localStringBuffer2.append(parseValue(localTestObjectInfo.getExpectValue()));
          m = 1;
          break;
        }
        if (k >= arrayOfString.length - 1)
          continue;
        localStringBuffer1.append(",");
        localStringBuffer2.append(",");
      }
      if (i >= this.testInfos.size() - 1)
        continue;
      localStringBuffer1.append(";");
      localStringBuffer2.append(";");
    }
    this.initValues = localStringBuffer1.toString();
    this.willValues = localStringBuffer2.toString();
    initTestInfo();
    return true;
  }

  public Envionment getEnvionment()
  {
    if ((getParent() != null) && ((getParent() instanceof IPackageElement)))
      return ((IPackageElement)getParent()).getEnvionment();
    return null;
  }

  public void initTestInfo()
  {
    this.testInfos.clear();
    if (getEnvionment() == null)
      return;
    List localList = getEnvionment().getValueLibrary().getChildrenList();
    String[] arrayOfString1 = this.initValues.split(";");
    String[] arrayOfString2 = this.willValues.split(";");
    if (arrayOfString1.length > 1)
    {
      String[] arrayOfString3 = arrayOfString1[0].split(",");
      String[] arrayOfString4;
      Object localObject1;
      int m;
      Object localObject2;
      for (int i = 1; i < arrayOfString1.length; i++)
      {
        arrayOfString4 = StringUtil.split(arrayOfString1[i], ",");
        if (i >= arrayOfString2.length)
        {
          localObject1 = new String[arrayOfString4.length];
          for (int j = 0; j < localObject1.length; j++)
            localObject1[j] = "";
        }
        else
        {
          localObject1 = StringUtil.split(arrayOfString2[i], ",");
        }
        TestCase localTestCase = new TestCase();
        localTestCase.setParent(this);
        for (m = 0; m < arrayOfString3.length; m++)
          for (int n = 0; n < localList.size(); n++)
          {
            localObject2 = (MappingVariable)localList.get(n);
            if (!((MappingVariable)localObject2).getDisplayName().equalsIgnoreCase(arrayOfString3[m]))
              continue;
            TestObjectInfo localTestObjectInfo = new TestObjectInfo("", ((MappingVariable)localObject2).getValueName(), ((MappingVariable)localObject2).getDisplayName(), ((MappingVariable)localObject2).getValueType());
            localTestObjectInfo.setInitialValue(reverseValue(arrayOfString4[m]));
            localTestObjectInfo.setExpectValue(reverseValue(localObject1[m]));
            localTestCase.addChildElement(localTestObjectInfo);
          }
        this.testInfos.add(localTestCase);
      }
      if (arrayOfString1.length < arrayOfString2.length)
        for (i = arrayOfString1.length; i < arrayOfString2.length; i++)
        {
          arrayOfString4 = StringUtil.split(arrayOfString2[i], ",");
          localObject1 = new TestCase();
          ((TestCase)localObject1).setParent(this);
          for (int k = 0; k < arrayOfString3.length; k++)
            for (m = 0; m < localList.size(); m++)
            {
              MappingVariable localMappingVariable = (MappingVariable)localList.get(m);
              if (!localMappingVariable.getDisplayName().equalsIgnoreCase(arrayOfString3[k]))
                continue;
              localObject2 = new TestObjectInfo("", localMappingVariable.getValueName(), localMappingVariable.getDisplayName(), localMappingVariable.getValueType());
              ((TestObjectInfo)localObject2).setInitialValue("");
              ((TestObjectInfo)localObject2).setExpectValue(reverseValue(arrayOfString4[k]));
              ((TestCase)localObject1).addChildElement((IElement)localObject2);
            }
          this.testInfos.add(localObject1);
        }
    }
    this.inited = true;
  }

  public String getInitValues()
  {
    return this.initValues;
  }

  public void setInitValues(String paramString)
  {
    this.initValues = paramString;
  }

  public String getWillValues()
  {
    return this.willValues;
  }

  public void setWillValues(String paramString)
  {
    this.willValues = paramString;
  }

  public ArrayList getTestInfos()
  {
    return this.testInfos;
  }

  public IRulePackage getMainPackage()
  {
    if ((getParent() != null) && ((getParent() instanceof IPackageElement)))
      return ((IPackageElement)getParent()).getMainPackage();
    return null;
  }

  public String getRuleSetName()
  {
    if (getParent() != null)
    {
      if ((getParent() instanceof IRulePackage))
        return getMainPackage().getExeRulePackageName();
      return getMainPackage().getExeRulePackageName() + "@" + getParent().getDisplayName();
    }
    return "";
  }

  public String getExcelFile()
  {
    return this.excelFile;
  }

  public void setExcelFile(String paramString)
  {
    this.excelFile = paramString;
  }

  protected int a(Workbook paramWorkbook)
  {
    if ((paramWorkbook instanceof HSSFWorkbook))
      return 65536;
    return 1048576;
  }

  public void loadDataFromExcel(File paramFile)
  {
    Object localObject = null;
    if (paramFile.getName().endsWith(".xls"))
      localObject = new HSSFWorkbook(new POIFSFileSystem(new FileInputStream(paramFile)));
    else
      localObject = new XSSFWorkbook(paramFile.getPath());
    Sheet localSheet1 = ((Workbook)localObject).getSheetAt(0);
    Sheet localSheet2 = ((Workbook)localObject).getSheetAt(1);
    int i = 0;
    StringBuffer localStringBuffer1 = new StringBuffer();
    StringBuffer localStringBuffer2 = new StringBuffer();
    StringBuffer localStringBuffer3 = new StringBuffer();
    Row localRow = localSheet1.getRow(0);
    for (int j = 0; j < a((Workbook)localObject); j++)
    {
      Cell localCell1 = localRow.getCell(j);
      if (localCell1 == null)
        break;
      if (localCell1.getCellType() != 1)
        continue;
      i++;
      localStringBuffer1.append(localCell1.getStringCellValue()).append(",");
    }
    if (localStringBuffer1.length() == 0)
      return;
    localStringBuffer2.append(localStringBuffer1.substring(0, localStringBuffer1.length() - 1)).append(";");
    localStringBuffer3.append(localStringBuffer1.substring(0, localStringBuffer1.length() - 1)).append(";");
    FormulaEvaluator localFormulaEvaluator = ((Workbook)localObject).getCreationHelper().createFormulaEvaluator();
    for (int k = 1; k < a((Workbook)localObject); k++)
    {
      localRow = localSheet1.getRow(k);
      String[] arrayOfString = new String[i];
      for (int m = 0; m < i; m++)
        if (localRow != null)
        {
          Cell localCell2 = localRow.getCell(m);
          arrayOfString[m] = parseValue(a(localCell2, localFormulaEvaluator, localRow));
        }
        else
        {
          arrayOfString[m] = "";
        }
      m = 1;
      for (int n = 0; n < arrayOfString.length; n++)
      {
        if ((arrayOfString[n] == null) || (arrayOfString[n].length() <= 0))
          continue;
        m = 0;
        break;
      }
      boolean bool;
      if (m != 0)
        bool = a(k, i, localSheet1, localSheet2, localFormulaEvaluator);
      if (bool)
        continue;
      for (n = 0; n < i; n++)
      {
        localStringBuffer2.append(arrayOfString[n]);
        if (n >= i - 1)
          continue;
        localStringBuffer2.append(",");
      }
      localStringBuffer2.append(";");
      localRow = localSheet2.getRow(k);
      arrayOfString = new String[i];
      for (n = 0; n < i; n++)
        if (localRow != null)
        {
          Cell localCell3 = localRow.getCell(n);
          arrayOfString[n] = parseValue(a(localCell3, localFormulaEvaluator, localRow));
        }
        else
        {
          arrayOfString[n] = "";
        }
      for (n = 0; n < i; n++)
      {
        localStringBuffer3.append(arrayOfString[n]);
        if (n >= i - 1)
          continue;
        localStringBuffer3.append(",");
      }
      localStringBuffer3.append(";");
    }
    this.initValues = localStringBuffer2.substring(0, localStringBuffer2.length());
    this.willValues = localStringBuffer3.substring(0, localStringBuffer3.length());
    initTestInfo();
  }

  private boolean a(int paramInt1, int paramInt2, Sheet paramSheet1, Sheet paramSheet2, FormulaEvaluator paramFormulaEvaluator)
  {
    int i = 1;
    Row localRow = paramSheet1.getRow(paramInt1 + 1);
    String[] arrayOfString;
    int j;
    Cell localCell;
    if (localRow != null)
    {
      arrayOfString = new String[paramInt2];
      for (j = 0; j < paramInt2; j++)
      {
        localCell = localRow.getCell(j);
        arrayOfString[j] = parseValue(a(localCell, paramFormulaEvaluator, localRow));
      }
      for (j = 0; j < arrayOfString.length; j++)
      {
        if ((arrayOfString[j] == null) || (arrayOfString[j].length() <= 0))
          continue;
        i = 0;
        break;
      }
      if (i == 0)
        return false;
    }
    if (i != 0)
    {
      localRow = paramSheet2.getRow(paramInt1);
      if (localRow != null)
      {
        arrayOfString = new String[paramInt2];
        for (j = 0; j < paramInt2; j++)
        {
          localCell = localRow.getCell(j);
          arrayOfString[j] = parseValue(a(localCell, paramFormulaEvaluator, localRow));
        }
        for (j = 0; j < arrayOfString.length; j++)
        {
          if ((arrayOfString[j] == null) || (arrayOfString[j].length() <= 0))
            continue;
          i = 0;
          break;
        }
        if (i == 0)
          return false;
      }
    }
    if (i != 0)
    {
      localRow = paramSheet2.getRow(paramInt1 + 1);
      if (localRow != null)
      {
        arrayOfString = new String[paramInt2];
        for (j = 0; j < paramInt2; j++)
        {
          localCell = localRow.getCell(j);
          arrayOfString[j] = parseValue(a(localCell, paramFormulaEvaluator, localRow));
        }
        for (j = 0; j < arrayOfString.length; j++)
        {
          if ((arrayOfString[j] == null) || (arrayOfString[j].length() <= 0))
            continue;
          i = 0;
          break;
        }
        if (i == 0)
          return false;
      }
    }
    return true;
  }

  public String parseValue(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return "";
    paramString = StringUtil.replace(",", "\\`", paramString);
    paramString = StringUtil.replace(";", "\\~", paramString);
    return paramString;
  }

  public String reverseValue(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
      return "";
    paramString = StringUtil.replace("\\`", ",", paramString);
    paramString = StringUtil.replace("\\~", ";", paramString);
    return paramString;
  }

  private String a(Cell paramCell, FormulaEvaluator paramFormulaEvaluator, Row paramRow)
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
          CellValue localCellValue = paramFormulaEvaluator.evaluate(paramCell);
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
    return "";
  }

  public void exportXsl(File paramFile)
  {
    if (this.testInfos.size() == 0)
      initTestInfo();
    String[] arrayOfString1 = this.initValues.split(";");
    String[] arrayOfString2 = this.willValues.split(";");
    if (arrayOfString1.length > 0)
    {
      String[] arrayOfString3 = arrayOfString1[0].split(",");
      Object localObject = null;
      if (paramFile.getName().endsWith(".xls"))
        localObject = new HSSFWorkbook();
      else
        localObject = new XSSFWorkbook();
      a(arrayOfString3, (Workbook)localObject);
      if (!paramFile.exists())
        paramFile.createNewFile();
      FileOutputStream localFileOutputStream = new FileOutputStream(paramFile);
      ((Workbook)localObject).write(localFileOutputStream);
      localFileOutputStream.flush();
      localFileOutputStream.close();
    }
  }

  private Workbook a(String[] paramArrayOfString, Workbook paramWorkbook)
  {
    this.a = paramWorkbook.createCellStyle();
    this.a.setDataFormat(paramWorkbook.getCreationHelper().createDataFormat().getFormat("m/d/yy"));
    a(paramWorkbook, 0, paramArrayOfString);
    a(paramWorkbook, 1, paramArrayOfString);
    a(paramWorkbook, 2, paramArrayOfString);
    return paramWorkbook;
  }

  private void a(Workbook paramWorkbook, int paramInt, String[] paramArrayOfString)
  {
    Sheet localSheet = null;
    if (paramInt == 0)
      localSheet = paramWorkbook.createSheet(u.a("testcaseinit.text"));
    else if (paramInt == 1)
      localSheet = paramWorkbook.createSheet(u.a("testcasewill.text"));
    else if (paramInt == 2)
      localSheet = paramWorkbook.createSheet(u.a("testcaseresult.text"));
    this.b = 0;
    Row localRow = localSheet.createRow(this.b++);
    Font localFont = paramWorkbook.createFont();
    CellStyle localCellStyle = paramWorkbook.createCellStyle();
    localCellStyle = paramWorkbook.createCellStyle();
    localCellStyle.setFont(localFont);
    localCellStyle.setWrapText(true);
    for (int i = 0; i < paramArrayOfString.length; i++)
    {
      Cell localCell = localRow.createCell(i);
      localCell.setCellValue(paramArrayOfString[i]);
      localCell.setCellStyle(localCellStyle);
    }
    localSheet.createFreezePane(0, 1, 0, 1);
    if (this.testInfos.size() > 0)
      for (i = 0; i < this.testInfos.size(); i++)
        a(localSheet, (TestCase)this.testInfos.get(i), paramInt, paramArrayOfString);
  }

  private void a(Sheet paramSheet, TestCase paramTestCase, int paramInt, String[] paramArrayOfString)
  {
    Row localRow = paramSheet.createRow(this.b++);
    Iterator localIterator = paramTestCase.getChildrenIterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      TestObjectInfo localTestObjectInfo = (TestObjectInfo)localIterator.next();
      Cell localCell = localRow.createCell(i++);
      Object localObject = null;
      if (paramInt == 0)
        localObject = localTestObjectInfo.getInitialValue();
      else if (paramInt == 1)
        localObject = localTestObjectInfo.getExpectValue();
      else if (paramInt == 2)
        localObject = localTestObjectInfo.getResultValue();
      if (localObject == null)
        continue;
      if ((localTestObjectInfo.getJavaType().b()) || (localTestObjectInfo.getJavaType().j()))
        localCell.setCellValue(NumberUtil.getDouble(localObject));
      else if (localTestObjectInfo.getJavaType().e())
        localCell.setCellValue(NumberUtil.getBoolean(localObject));
      else if ((localTestObjectInfo.getJavaType().v()) || (localTestObjectInfo.getJavaType().x()) || (localTestObjectInfo.getJavaType().w()))
        try
        {
          localCell.setCellValue(com.flagleader.util.DateUtil.getDate(localObject));
          localCell.setCellStyle(this.a);
        }
        catch (Exception localException)
        {
          localCell.setCellValue(StringUtil.stringValue(localObject));
        }
      else
        localCell.setCellValue(StringUtil.stringValue(localObject));
    }
  }

  public IRuleRepository getRepository()
  {
    if ((getParent() != null) && ((getParent() instanceof IRuleRepository)))
      return (IRuleRepository)getParent();
    if ((getParent() != null) && ((getParent() instanceof IRuleProject)))
      return ((IRuleProject)getParent()).getRepository();
    if ((getParent() != null) && ((getParent() instanceof RuleGroup)))
      return ((RuleGroup)getParent()).getRepository();
    return new RuleRepository();
  }

  public String getFilePathName()
  {
    return getRuleSetName() + ".check";
  }

  public String getName()
  {
    return "CheckRuleInfo";
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitCheckRuleInfo(this);
  }

  public IElement deepClone()
  {
    return new CheckRuleInfo(this);
  }

  public int getVarinout(String paramString)
  {
    if (getEnvionment() == null)
      return 3;
    List localList = getEnvionment().getValueLibrary().getChildrenList();
    for (int i = 0; i < localList.size(); i++)
    {
      MappingVariable localMappingVariable = (MappingVariable)localList.get(i);
      if (localMappingVariable.getDisplayName().equalsIgnoreCase(paramString))
        return localMappingVariable.getInout();
    }
    return 3;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.CheckRuleInfo
 * JD-Core Version:    0.6.0
 */