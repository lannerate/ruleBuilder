package com.flagleader.repository.rom;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import java.util.ArrayList;
import java.util.List;

public class BusinessObjectAttribute extends BusinessObjectMember
  implements IAttributeObject
{
  public BusinessObjectAttribute(BusinessObjectAttribute paramBusinessObjectAttribute)
  {
    super(paramBusinessObjectAttribute);
  }

  public BusinessObjectAttribute()
  {
  }

  public BusinessObjectAttribute(String paramString)
  {
    super(paramString);
  }

  public IElement deepClone()
  {
    return new BusinessObjectAttribute(this);
  }

  public String getName()
  {
    return "BusinessObjectAttribute";
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitBusinessObjectAttribute(this);
  }

  public String getVarValue()
  {
    if (getClassObject() != null)
      return getClassObject().getVarValue() + "." + getShortMemberName();
    return getShortMemberName();
  }

  public String getVarSaveValue()
  {
    return getVarValue();
  }

  public String getVariableName()
  {
    return getVarValue();
  }

  public List getParams()
  {
    return new ArrayList(0);
  }

  public boolean isLoged()
  {
    return false;
  }

  public void setLoged(boolean paramBoolean)
  {
  }

  public boolean canSetLoged()
  {
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.BusinessObjectAttribute
 * JD-Core Version:    0.6.0
 */