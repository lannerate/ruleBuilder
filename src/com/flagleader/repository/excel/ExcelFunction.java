package com.flagleader.repository.excel;

import com.flagleader.repository.IElement;
import com.flagleader.repository.rom.AbstractSubFunction;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.tree.AbstractTreeNode;
import java.util.List;

public class ExcelFunction extends AbstractSubFunction
  implements IFunctionObject
{
  public ExcelFunction(AbstractSubFunction paramAbstractSubFunction)
  {
    super(paramAbstractSubFunction);
  }

  public ExcelFunction(String paramString1, String paramString2, String paramString3, String paramString4, List paramList, String paramString5)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramList);
    setGroupName(paramString5);
  }

  public ExcelFunction(String paramString1, String paramString2, String paramString3, String paramString4, List paramList, boolean paramBoolean, String paramString5)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramList);
    setVisible(paramBoolean);
    setGroupName(paramString5);
  }

  public ExcelFunction()
  {
  }

  public IElement deepClone()
  {
    return new ExcelFunction(this);
  }

  public String getName()
  {
    return "ExcelFunction";
  }

  public String getVarValue()
  {
    if (getParent() != null)
    {
      IExcelObject localIExcelObject = null;
      if ((getParent() instanceof IExcelObject))
        localIExcelObject = (IExcelObject)getParent();
      else if ((getParent().getParent() instanceof IExcelObject))
        localIExcelObject = (IExcelObject)getParent().getParent();
      if (localIExcelObject != null)
      {
        if (getVariableName().startsWith(localIExcelObject.getVarValue() + "."))
          return getVariableName();
        return localIExcelObject.getVarValue() + "." + getVariableName();
      }
    }
    return getVariableName();
  }

  public String getGroupName()
  {
    if (this.groupName != null)
      return this.groupName;
    return "p";
  }

  public String getShowGroupName()
  {
    if ((getParent() instanceof IExcelObject))
    {
      if ((this.groupName == null) || (this.groupName.equals("p")))
        return getLocalString("sheetfunc.text");
      return this.groupName;
    }
    return super.getShowGroupName();
  }

  public boolean isEditVisible()
  {
    if ((getParent() instanceof AbstractTreeNode))
      return (((AbstractTreeNode)getParent()).canVmlShow()) && (isVisible());
    return super.isEditVisible();
  }

  public boolean canDelete()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.excel.ExcelFunction
 * JD-Core Version:    0.6.0
 */