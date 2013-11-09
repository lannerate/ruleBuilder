package com.flagleader.repository.rom;

import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.ClassContainer;
import com.flagleader.repository.tree.InterfaceContainer;
import java.util.List;

public class BusinessObjectConstructor extends BusinessObjectMethod
  implements IConstructorFunction
{
  public BusinessObjectConstructor(BusinessObjectConstructor paramBusinessObjectConstructor)
  {
    super(paramBusinessObjectConstructor);
  }

  public BusinessObjectConstructor()
  {
  }

  public BusinessObjectConstructor(String paramString)
  {
    super(paramString);
  }

  public String getVarValue()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    ClassContainer localClassContainer = getClassContainer();
    if (localClassContainer != null)
    {
      localStringBuffer.append(localClassContainer.getVarValue());
      localStringBuffer.append(".insert(");
    }
    else if ((getParent() instanceof InterfaceContainer))
    {
      localStringBuffer.append(((InterfaceContainer)getParent()).getVarValue());
      localStringBuffer.append(" = ");
    }
    localStringBuffer.append("new " + getMemberClassName());
    localStringBuffer.append("(");
    for (int i = 1; i <= this.a.size(); i++)
    {
      localStringBuffer.append("{arg" + i + "}");
      if (i == this.a.size())
        continue;
      localStringBuffer.append(",");
    }
    localStringBuffer.append(")");
    if (localClassContainer != null)
      localStringBuffer.append(")");
    return localStringBuffer.toString();
  }

  public ClassContainer getClassContainer()
  {
    IBusinessObjectContainer localIBusinessObjectContainer = getContainer();
    if ((localIBusinessObjectContainer instanceof ClassContainer))
      return (ClassContainer)localIBusinessObjectContainer;
    return null;
  }

  public IElement deepClone()
  {
    return new BusinessObjectConstructor(this);
  }

  public String getName()
  {
    return "BusinessObjectConstructor";
  }

  public String getValueType()
  {
    return getMemberClassName();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.BusinessObjectConstructor
 * JD-Core Version:    0.6.0
 */