package com.flagleader.repository.excel;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IPropertyObject;

public class ExcelCellModel extends AbstractExcelFieldModel
  implements IPropertyObject
{
  public static String[] DATETYPES = { "string", "double", "date", "boolean" };

  public ExcelCellModel(ExcelCellModel paramExcelCellModel)
  {
    super(paramExcelCellModel);
  }

  public ExcelCellModel()
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitExcelCellModel(this);
  }

  public String getName()
  {
    return "ExcelCellModel";
  }

  public String getShowGroupName()
  {
    if ((this.groupName == null) || (this.groupName.equals("p")))
      return getLocalString("excelcell.text");
    return super.getShowGroupName();
  }

  public IElement deepClone()
  {
    return new ExcelCellModel(this);
  }

  public String getGetMethodName()
  {
    return getSheetTable().getVarValue() + ".get" + getJavaType().N() + "CellValue(" + getFieldPos() + ")";
  }

  public String getVarSaveValue()
  {
    return getSheetTable().getVarValue() + ".getSavedCellValue(" + getFieldPos() + ")";
  }

  public String getSetMethodPreName()
  {
    return getSheetTable().getVarValue() + ".setCellValue(" + getFieldPos() + ",";
  }

  public String getSetMethodSufName()
  {
    return ")";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.excel.ExcelCellModel
 * JD-Core Version:    0.6.0
 */