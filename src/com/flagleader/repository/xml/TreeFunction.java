package com.flagleader.repository.xml;

import com.flagleader.repository.IElement;
import com.flagleader.repository.rom.AbstractSubFunction;
import com.flagleader.repository.rom.IFunctionObject;
import com.flagleader.repository.tree.AbstractTreeNode;
import com.flagleader.repository.tree.ClassContainer;
import java.util.List;

public class TreeFunction extends AbstractSubFunction
  implements IFunctionObject
{
  public TreeFunction(AbstractSubFunction paramAbstractSubFunction)
  {
    super(paramAbstractSubFunction);
  }

  public TreeFunction(String paramString1, String paramString2, String paramString3, String paramString4, List paramList, String paramString5)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramList);
    setGroupName(paramString5);
  }

  public TreeFunction(String paramString1, String paramString2, String paramString3, String paramString4, List paramList, boolean paramBoolean, String paramString5)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramList);
    setVisible(paramBoolean);
    setGroupName(paramString5);
  }

  public TreeFunction()
  {
  }

  public IElement deepClone()
  {
    return new TreeFunction(this);
  }

  public String getName()
  {
    return "TreeFunction";
  }

  public String getVarValue()
  {
    if ((getParent() != null) && ((getParent() instanceof TreeValueNode)))
    {
      if (getVariableName().startsWith(((TreeValueNode)getParent()).getVarValue() + "."))
        return getVariableName();
      return ((TreeValueNode)getParent()).getVarValue() + "." + getVariableName();
    }
    if ((getParent() != null) && ((getParent() instanceof ClassContainer)))
    {
      if (getVariableName().startsWith(((ClassContainer)getParent()).getVarValue() + "."))
        return getVariableName();
      return ((ClassContainer)getParent()).getVarValue() + "." + getVariableName();
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
    if ((getParent() instanceof TreeValueNode))
    {
      if ((this.groupName == null) || (this.groupName.equals("p")))
        return getLocalString("sheetfunc.text");
      return this.groupName;
    }
    if ((getParent() instanceof ClassContainer))
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
 * Qualified Name:     com.flagleader.repository.xml.TreeFunction
 * JD-Core Version:    0.6.0
 */