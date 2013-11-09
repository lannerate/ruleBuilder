package com.flagleader.repository.rlm;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.l;
import com.flagleader.repository.rlm.editen.ISelectorEditen;

public abstract class AbstractSelectObject extends AbstractRuleObject
  implements ISelectorEditen
{
  public AbstractSelectObject()
  {
  }

  public AbstractSelectObject(AbstractRuleObject paramAbstractRuleObject)
  {
    super(paramAbstractRuleObject);
  }

  public AbstractSelectObject(String paramString)
  {
    setDisplayName(paramString);
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    return false;
  }

  public boolean canEdit()
  {
    return false;
  }

  public boolean checkValue(String paramString)
  {
    return false;
  }

  public IElement getBusinessObject()
  {
    return null;
  }

  public String getColorType()
  {
    return "default";
  }

  public String getHint()
  {
    return null;
  }

  public l[] getLeftPopupMenus()
  {
    return null;
  }

  public boolean hasHint()
  {
    return false;
  }

  public boolean hasLeftPopupMenus()
  {
    return false;
  }

  public boolean pasteBusinessObject(Object paramObject)
  {
    return false;
  }

  public void setText(String paramString)
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return null;
  }

  public IElement deepClone()
  {
    return null;
  }

  public String getName()
  {
    return null;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.AbstractSelectObject
 * JD-Core Version:    0.6.0
 */