package com.flagleader.repository.excel;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IPropertyObject;

public class ExcelColModel extends AbstractExcelFieldModel
  implements IPropertyObject
{
  public static String[] DATETYPES = { "string", "double", "date", "boolean" };

  public ExcelColModel(ExcelColModel paramExcelColModel)
  {
    super(paramExcelColModel);
  }

  public ExcelColModel()
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitExcelColModel(this);
  }

  public String getName()
  {
    return "ExcelColModel";
  }

  public IElement deepClone()
  {
    return new ExcelColModel(this);
  }

  public String getShowGroupName()
  {
    if ((this.groupName == null) || (this.groupName.equals("p")))
      return getLocalString("excelcol.text");
    return super.getShowGroupName();
  }

  public String getGetMethodName()
  {
    return getSheetTable().getVarValue() + ".get" + getJavaType().N() + "ColValue(" + getFieldPos() + ")";
  }

  public String getVarSaveValue()
  {
    return getSheetTable().getVarValue() + ".getSavedColValue(" + getFieldPos() + ")";
  }

  public String getSetMethodPreName()
  {
    return getSheetTable().getVarValue() + ".setColValue(" + getFieldPos() + ",";
  }

  public String getSetMethodSufName()
  {
    return ")";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.excel.ExcelColModel
 * JD-Core Version:    0.6.0
 */