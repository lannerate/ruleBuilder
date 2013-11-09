package com.flagleader.repository.rlm;

import com.flagleader.repository.IElement;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleContainer;

public abstract class AbstractBOToken extends AbstractElementToken
{
  private String valueType = "";

  public AbstractBOToken()
  {
  }

  public AbstractBOToken(String paramString)
  {
    this.valueType = paramString;
  }

  public AbstractBOToken(AbstractBOToken paramAbstractBOToken)
  {
    super(paramAbstractBOToken);
    this.valueType = paramAbstractBOToken.valueType;
  }

  protected IElement d()
  {
    IBusinessObject localIBusinessObject = null;
    Envionment localEnvionment = getEnvionment();
    if (localEnvionment != null)
      localIBusinessObject = localEnvionment.getBusinessObject(getElementUuid(), getUniqueName());
    return localIBusinessObject;
  }

  protected void b(IElement paramIElement)
  {
    if ((paramIElement instanceof IBusinessObject))
      setUniqueName(((IBusinessObject)paramIElement).getUniqueName());
  }

  public String getValueType()
  {
    return this.valueType;
  }

  public g getJavaType()
  {
    if ((d() != null) && ((d() instanceof IBusinessObject)))
      return ((IBusinessObject)d()).getJavaType();
    return getTypeManager().a(this.valueType);
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    return ((paramObject instanceof IBusinessObject)) && (getJavaType().b(((IBusinessObject)paramObject).getValueType()));
  }

  public boolean pasteBusinessObject(Object paramObject)
  {
    if ((paramObject instanceof IBusinessObject))
    {
      setMemberElement((IBusinessObject)paramObject);
      if (getRoot() != null)
        getRoot().setModified(true);
      update();
      return true;
    }
    return false;
  }

  public void setValueType(String paramString)
  {
    this.valueType = paramString;
  }

  public String getNote()
  {
    if (getRoot() != null)
    {
      IElement localIElement = getMemberElement();
      if ((localIElement != null) && ((localIElement instanceof IBusinessObject)))
      {
        if (getRoot().getRuleTree().isDevelopModel())
          return ((IBusinessObject)localIElement).getValueName() + " : " + ((IBusinessObject)localIElement).getUniqueName();
        return ((IBusinessObject)localIElement).getValueName();
      }
      return this.valueType;
    }
    return super.getNote();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.AbstractBOToken
 * JD-Core Version:    0.6.0
 */