package com.flagleader.repository.rlm.action;

import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.value.MemberPropertyToken;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.Iterator;

public class PackageFieldSet extends AbstractPackageField
  implements ILineEditen, IRuleContainer
{
  public PackageFieldSet()
  {
  }

  public PackageFieldSet(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }

  public PackageFieldSet(IBusinessObject paramIBusinessObject1, IBusinessObject paramIBusinessObject2)
  {
    this.a = paramIBusinessObject1.getValueName();
    this.b = paramIBusinessObject1.getValueType();
    setDisplayName(paramIBusinessObject1.getShowDisplayName());
    getAssignValue().setMemberElement(paramIBusinessObject2);
  }

  public PackageFieldSet(String paramString, IBusinessObject paramIBusinessObject)
  {
    this.a = paramString;
    if (paramIBusinessObject != null)
      this.b = paramIBusinessObject.getValueType();
    else
      this.b = "string";
    setDisplayName(paramString);
    getAssignValue().setMemberElement(paramIBusinessObject);
  }

  public PackageFieldSet(PackageFieldSet paramPackageFieldSet)
  {
    super(paramPackageFieldSet);
  }

  public IElement deepClone()
  {
    return new PackageFieldSet(this);
  }

  public String getName()
  {
    return "PackageFieldSet";
  }

  public MemberPropertyToken getAssignValue()
  {
    MemberPropertyToken localMemberPropertyToken = null;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof MemberPropertyToken))
        continue;
      localMemberPropertyToken = (MemberPropertyToken)localObject;
      break;
    }
    if (localMemberPropertyToken == null)
    {
      localMemberPropertyToken = new MemberPropertyToken(getNaryType());
      addChildElement(localMemberPropertyToken);
    }
    else if (!localMemberPropertyToken.getJavaType().equals(getJavaType()))
    {
      localMemberPropertyToken.setValueType(getJavaType().K());
    }
    return localMemberPropertyToken;
  }

  public String getValue()
  {
    if (getAssignValue() != null)
    {
      String str = getAssignValue().toString();
      if (str.equals(getLocalString("emptyValue.edit", "")))
        return "";
      return str;
    }
    return "";
  }

  public g getJavaType()
  {
    return getTypeManager().a(getNaryType());
  }

  public boolean isEmpty()
  {
    return getAssignValue() == null;
  }

  public boolean paste(IElement paramIElement)
  {
    if ((paramIElement instanceof ElementContainer))
    {
      Iterator localIterator = ((ElementContainer)paramIElement).getChildrenIterator();
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof MemberPropertyToken))
          return pasteElement((MemberPropertyToken)localObject);
      }
    }
    else if ((paramIElement instanceof MemberPropertyToken))
    {
      removeElement(0);
      addChildElement(paramIElement);
      setModified(true);
      return true;
    }
    return false;
  }

  public boolean canCopy()
  {
    return true;
  }

  public boolean canCut()
  {
    return true;
  }

  public boolean canPasteElement(IElement paramIElement)
  {
    return paramIElement instanceof MemberPropertyToken;
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
    if ((paramIElement instanceof MemberPropertyToken))
    {
      removeElement(0);
      addChildElement(paramIElement);
      setModified(true);
      return true;
    }
    return false;
  }

  public String toString()
  {
    return getValue() + "<-" + getDisplayName();
  }

  protected Object clone()
  {
    return new PackageFieldSet(this);
  }

  public void addChildElement(IElement paramIElement)
  {
    if ((paramIElement instanceof MemberPropertyToken))
      super.addChildElement(paramIElement);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.PackageFieldSet
 * JD-Core Version:    0.6.0
 */