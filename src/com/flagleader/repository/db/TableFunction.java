package com.flagleader.repository.db;

import com.flagleader.repository.IElement;
import com.flagleader.repository.rom.AbstractSubFunction;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.tree.AbstractTreeNode;
import java.util.List;

public class TableFunction extends AbstractSubFunction
  implements IFunctionObject
{
  public TableFunction(AbstractSubFunction paramAbstractSubFunction)
  {
    super(paramAbstractSubFunction);
  }

  public TableFunction(String paramString1, String paramString2, String paramString3, String paramString4, List paramList, String paramString5)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramList);
    setGroupName(paramString5);
  }

  public TableFunction(String paramString1, String paramString2, String paramString3, String paramString4, List paramList, boolean paramBoolean, String paramString5)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramList);
    setVisible(paramBoolean);
    setGroupName(paramString5);
  }

  public TableFunction()
  {
  }

  public IElement deepClone()
  {
    return new TableFunction(this);
  }

  public String getName()
  {
    return "TableFunction";
  }

  public String getVarValue()
  {
    if ((getParent() != null) && ((getParent() instanceof IBOAndContainer)))
    {
      if (getVariableName().startsWith(((IBOAndContainer)getParent()).getVarValue() + "."))
        return getVariableName();
      return ((IBOAndContainer)getParent()).getVarValue() + "." + getVariableName();
    }
    if ((getParent() != null) && ((getParent() instanceof CustomSql)))
    {
      if (getVariableName().startsWith(((CustomSql)getParent()).getEnglishName() + "."))
        return getVariableName();
      return ((CustomSql)getParent()).getEnglishName() + "." + getVariableName();
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
    if ((getParent() instanceof IBOAndContainer))
    {
      if ((this.groupName == null) || (this.groupName.equals("p")))
        return getLocalString("sheetfunc.text");
      return this.groupName;
    }
    if ((getParent() instanceof CustomSql))
      return "";
    if ((getParent() instanceof DBModel))
      return ((DBModel)getParent()).getDisplayName();
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
 * Qualified Name:     com.flagleader.repository.db.TableFunction
 * JD-Core Version:    0.6.0
 */