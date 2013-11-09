package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rlm.AbstractRuleContainer;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.IRuleContainer;

public abstract class AbstractPackageField extends AbstractRuleContainer
  implements ILineEditen, IRuleContainer
{
  protected String a = "";
  protected String b = "string";

  public String getNaryType()
  {
    return this.b;
  }

  public void setNaryType(String paramString)
  {
    this.b = paramString;
  }

  public AbstractPackageField()
  {
  }

  public void setMappingField(IBusinessObject paramIBusinessObject)
  {
    this.a = paramIBusinessObject.getValueName();
    this.b = paramIBusinessObject.getValueType();
    setDisplayName(paramIBusinessObject.getDisplayName());
  }

  public AbstractPackageField(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }

  public AbstractPackageField(AbstractPackageField paramAbstractPackageField)
  {
    super(paramAbstractPackageField);
    this.a = paramAbstractPackageField.a;
    this.b = paramAbstractPackageField.b;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitPackageField(this);
  }

  public g getJavaType()
  {
    return getTypeManager().a(this.b);
  }

  public boolean canCopy()
  {
    return true;
  }

  public boolean canCut()
  {
    return true;
  }

  public abstract String getValue();

  public boolean canPasteElement(IElement paramIElement)
  {
    return paramIElement instanceof IValueContainerToken;
  }

  public IElement copyElement()
  {
    return getElement(0);
  }

  public IElement cutElement()
  {
    IElement localIElement = getElement(0);
    removeElement(0);
    setModified(true);
    return localIElement;
  }

  public boolean pasteElement(IElement paramIElement)
  {
    if ((paramIElement instanceof IValueContainerToken))
    {
      removeElement(0);
      addChildElement(paramIElement);
      setModified(true);
      return true;
    }
    return false;
  }

  public String getFuncName()
  {
    return this.a;
  }

  public void setFuncName(String paramString)
  {
    this.a = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.AbstractPackageField
 * JD-Core Version:    0.6.0
 */