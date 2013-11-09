package com.flagleader.repository.excel;

import com.flagleader.excel.ExcelFactory;
import com.flagleader.excel.IExcelBook;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.util.StringUtil;
import java.io.File;
import java.util.List;

public class ExcelBookModel extends AbstractExcelObject
  implements IExcelObject
{
  private String bookName = "";
  public static final String NAME = "ExcelBookModel";
  public static final String DISPLAYNAME = getLocalString("ExcelBookModel.text");
  private String xlsFile = "";
  private String modelFile = "";
  private transient IExcelBook excelData = null;

  public ExcelBookModel(ExcelBookModel paramExcelBookModel)
  {
    super(paramExcelBookModel);
    this.bookName = paramExcelBookModel.bookName;
    this.xlsFile = paramExcelBookModel.xlsFile;
  }

  public ExcelBookModel()
  {
  }

  public ExcelBookModel(String paramString1, String paramString2, String paramString3)
  {
    super(paramString1);
    this.bookName = paramString2;
    this.xlsFile = paramString3;
    updateFunction();
  }

  public IExcelBook getExcelData()
  {
    if ((this.excelData == null) && (this.xlsFile.length() > 0) && (new File(this.xlsFile).exists()))
    {
      this.excelData = ExcelFactory.newIntance().createBook();
      this.excelData.loadFromFile(this.xlsFile);
    }
    return this.excelData;
  }

  public void updateFunction()
  {
    if (getExcelFunction("loadFromFile") == null)
      addChildElement(new ExcelFunction("loadFromFile", "void", "loadFromFile({arg1})", format("loadFromFile.excel", new Object[] { "{arg1}", getDisplayName() }), a("string"), true, getLocalString("loadFromFile.excelgroup")));
    if (getExcelFunction("saveToFile") == null)
      addChildElement(new ExcelFunction("saveToFile", "void", "saveToFile({arg1})", format("saveToFile.sheet", new Object[] { getDisplayName(), "{arg1}" }), a("string"), true, getLocalString("saveToFile.excelgroup")));
    if (getExcelFunction("createWorkbook") == null)
      addChildElement(new ExcelFunction("createWorkbook", "void", "createWorkbook()", format("createWorkbook.excel", new Object[] { getDisplayName() }), null, true, getLocalString("createWorkbook.excelgroup")));
  }

  public ExcelSheetModel createExcelSheet(String paramString1, String paramString2, String paramString3)
  {
    ExcelSheetModel localExcelSheetModel = null;
    localExcelSheetModel = new ExcelSheetModel(getChildDefaultName(paramString1), paramString2, paramString3);
    addChildElement(localExcelSheetModel);
    setModified(true);
    return localExcelSheetModel;
  }

  public ExcelTableSheetModel createExcelTableSheet(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, short paramShort)
  {
    ExcelTableSheetModel localExcelTableSheetModel = null;
    localExcelTableSheetModel = new ExcelTableSheetModel(getChildDefaultName(paramString1), paramString2, paramString3, paramInt1, paramInt2, paramShort);
    addChildElement(localExcelTableSheetModel);
    setModified(true);
    return localExcelTableSheetModel;
  }

  public ExcelXYSheetModel createExcelXYSheet(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, short paramShort)
  {
    ExcelXYSheetModel localExcelXYSheetModel = null;
    localExcelXYSheetModel = new ExcelXYSheetModel(getChildDefaultName(paramString1), paramString2, paramString3, paramInt1, paramInt2, paramShort);
    addChildElement(localExcelXYSheetModel);
    setModified(true);
    return localExcelXYSheetModel;
  }

  public boolean exitsTableVarName(String paramString)
  {
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
      if (((localList.get(i) instanceof ExcelSheetModel)) && (((ExcelSheetModel)localList.get(i)).getValueName().equalsIgnoreCase(paramString)))
        return true;
    return false;
  }

  public String getVarTableName(String paramString)
  {
    String str = paramString;
    int i = 0;
    while (exitsTableVarName(str))
    {
      i++;
      str = paramString + i;
    }
    return str;
  }

  public boolean canCreateEditen()
  {
    return false;
  }

  public IBusinessObjectEditen createSubEditen(String paramString)
  {
    return null;
  }

  public boolean pasteElement(IElement paramIElement, int paramInt)
  {
    return paste(paramIElement.deepClone());
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitExcelBookModel(this);
  }

  public IElement deepClone()
  {
    return new ExcelBookModel(this);
  }

  public String getName()
  {
    return "ExcelBookModel";
  }

  public String getValueType()
  {
    return "com.flagleader.excel.IExcelBook";
  }

  public String getVarValue()
  {
    if (StringUtil.isJavaIdentifier(this.bookName))
      return this.bookName;
    if (getParent() != null)
      return "excel" + getParent().getElementPos(this);
    if (StringUtil.isJavaIdentifier(getDisplayName()))
      return getDisplayName().toLowerCase();
    return "excel";
  }

  public String getValueName()
  {
    return this.bookName;
  }

  public String getBookName()
  {
    return this.bookName;
  }

  public void setBookName(String paramString)
  {
    this.bookName = paramString;
  }

  public String getXlsFile()
  {
    return this.xlsFile;
  }

  public void setXlsFile(String paramString)
  {
    this.xlsFile = paramString;
    this.excelData = null;
  }

  public void setExcelData(IExcelBook paramIExcelBook)
  {
    this.excelData = paramIExcelBook;
  }

  public String getModelFile()
  {
    return this.modelFile;
  }

  public void setModelFile(String paramString)
  {
    this.modelFile = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.excel.ExcelBookModel
 * JD-Core Version:    0.6.0
 */