package com.flagleader.repository;

import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.EnumLibrary;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.FunctionLibrary;
import com.flagleader.repository.tree.ValueLibrary;
import com.flagleader.repository.tree.VariableLibrary;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ElementContainer extends AbstractElement
  implements IElement
{
  public ElementContainer()
  {
  }

  public ElementContainer(String paramString)
  {
    super(paramString);
  }

  public ElementContainer(AbstractElement paramAbstractElement)
  {
    super(paramAbstractElement);
  }

  public String getName()
  {
    return "ElementContainer";
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return null;
  }

  public IElement deepClone()
  {
    return new ElementContainer(this);
  }

  private IElement b(IElement paramIElement)
  {
    if (paramIElement.getParent() != null)
    {
      if ((paramIElement.getParent() instanceof Envionment))
        return paramIElement;
      if ((paramIElement.getParent() instanceof EnumLibrary))
        return paramIElement;
      if ((paramIElement.getParent() instanceof ValueLibrary))
        return paramIElement;
      if ((paramIElement.getParent() instanceof VariableLibrary))
        return paramIElement;
      if ((paramIElement.getParent() instanceof FunctionLibrary))
        return paramIElement;
      return b(paramIElement.getParent());
    }
    return paramIElement;
  }

  public void copyNotSameChild(Map paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      IElement localIElement1 = (IElement)localIterator.next();
      IElement localIElement2 = b(localIElement1);
      if (!(localIElement2 instanceof IBusinessObject))
        continue;
      int i = 0;
      for (int j = 0; j < a().size(); j++)
      {
        Object localObject = a().get(j);
        if ((!(localObject instanceof IBusinessObject)) || (!((IBusinessObject)localObject).getVarValue().equals(((IBusinessObject)localIElement2).getVarValue())))
          continue;
        i = 1;
        break;
      }
      if (i != 0)
        continue;
      addChildElement(((IBusinessObject)localIElement2).deepClone());
    }
  }

  public void addChildElement(IElement paramIElement, int paramInt)
  {
    if (paramIElement == null)
      return;
    if (paramInt < 0)
      paramInt = 0;
    if (paramInt > getChildrenCount())
      paramInt = getChildrenCount();
    a().add(paramInt, paramIElement);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.ElementContainer
 * JD-Core Version:    0.6.0
 */