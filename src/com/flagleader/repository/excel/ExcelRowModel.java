package com.flagleader.repository.excel;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.IPropertyObject;

public class ExcelRowModel extends AbstractExcelFieldModel
  implements IPropertyObject
{
  public static String[] DATETYPES = { "string", "double", "date", "boolean" };
  public static String[] DATEFORMATS = { "m/d/yy", "d-mmm-yy", "d-mmm", "mmm-yy", "h:mm AM/PM", "h:mm:ss AM/PM", "h:mm", "h:mm:ss" };
  private int formatStyle = 0;

  public ExcelRowModel(ExcelRowModel paramExcelRowModel)
  {
    super(paramExcelRowModel);
  }

  public ExcelRowModel()
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitExcelRowModel(this);
  }

  public String getName()
  {
    return "ExcelRowModel";
  }

  public IElement deepClone()
  {
    return new ExcelRowModel(this);
  }

  public String getShowGroupName()
  {
    if ((this.groupName == null) || (this.groupName.equals("p")))
    {
      if ((getParent() instanceof ExcelXYSheetModel))
        return getLocalString("excelrow.text");
      return getLocalString("sheetfield.text");
    }
    return super.getShowGroupName();
  }

  public String getGetMethodName()
  {
    return getSheetTable().getVarValue() + ".get" + getJavaType().N() + "RowValue(" + getFieldPos() + ")";
  }

  public String getVarSaveValue()
  {
    return getSheetTable().getVarValue() + ".getSavedRowValue(" + getFieldPos() + ")";
  }

  public String getSetMethodPreName()
  {
    return getSheetTable().getVarValue() + ".setRowValue(" + getFieldPos() + ",";
  }

  public String getSetMethodSufName()
  {
    return ")";
  }

  public int getFormatLocation()
  {
    if (getJavaType().m())
    {
      if (this.formatStyle == 49)
        return 1;
      if (this.formatStyle == 50)
        return 2;
      return 0;
    }
    if (this.formatStyle >= 49)
      return 49;
    return this.formatStyle;
  }

  public void setFormatLocation(int paramInt)
  {
    if (getJavaType().m())
    {
      if (paramInt == 2)
        this.formatStyle = 50;
      else if (paramInt == 1)
        this.formatStyle = 49;
      else
        this.formatStyle = 0;
    }
    else
      this.formatStyle = paramInt;
  }

  public int getFormatStyle()
  {
    return this.formatStyle;
  }

  public void setFormatStyle(int paramInt)
  {
    this.formatStyle = paramInt;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.excel.ExcelRowModel
 * JD-Core Version:    0.6.0
 */