package com.flagleader.repository.rlm.action;

import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rlm.value.ConstantToken;
import com.flagleader.repository.rlm.value.MemberToken;
import com.flagleader.repository.rlm.value.ValueToken;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.Iterator;

public class PackageFieldGet extends AbstractPackageField
  implements ILineEditen, IRuleContainer
{
  public PackageFieldGet()
  {
  }

  public PackageFieldGet(IBusinessObject paramIBusinessObject1, IBusinessObject paramIBusinessObject2, String paramString)
  {
    this.a = paramIBusinessObject1.getValueName();
    this.b = paramIBusinessObject1.getValueType();
    setDisplayName(paramIBusinessObject1.getShowDisplayName());
    ValueToken localValueToken;
    if (paramIBusinessObject2 != null)
    {
      localValueToken = new ValueToken(1, getJavaType().K(), "");
      localValueToken.setFieldType(1);
      addChildElement(localValueToken);
      ((MemberToken)localValueToken.getValueElement()).setMemberElement(paramIBusinessObject2);
    }
    else
    {
      localValueToken = new ValueToken(2, getJavaType().K(), "");
      localValueToken.setFieldType(2);
      addChildElement(localValueToken);
      ((ConstantToken)localValueToken.getValueElement()).setValue(paramString);
    }
  }

  public PackageFieldGet(String paramString1, IBusinessObject paramIBusinessObject, String paramString2)
  {
    this.a = paramString1;
    if (paramIBusinessObject != null)
      this.b = paramIBusinessObject.getValueType();
    else
      this.b = "string";
    setDisplayName(paramString1);
    ValueToken localValueToken;
    if (paramIBusinessObject != null)
    {
      localValueToken = new ValueToken(1, getJavaType().K(), "");
      localValueToken.setFieldType(1);
      addChildElement(localValueToken);
      ((MemberToken)localValueToken.getValueElement()).setMemberElement(paramIBusinessObject);
    }
    else
    {
      localValueToken = new ValueToken(2, getJavaType().K(), "");
      localValueToken.setFieldType(2);
      addChildElement(localValueToken);
      ((ConstantToken)localValueToken.getValueElement()).setValue(paramString2);
    }
  }

  public PackageFieldGet(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }

  public PackageFieldGet(PackageFieldGet paramPackageFieldGet)
  {
    super(paramPackageFieldGet);
  }

  public IElement deepClone()
  {
    return new PackageFieldGet(this);
  }

  public String getName()
  {
    return "PackageFieldGet";
  }

  public IValueContainerToken getAssignValue()
  {
    ValueToken localValueToken = null;
    Iterator localIterator = getChildrenIterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (!(localObject instanceof ValueToken))
        continue;
      localValueToken = (ValueToken)localObject;
      break;
    }
    if (localValueToken == null)
    {
      localValueToken = new ValueToken(2, getJavaType().K(), "");
      localValueToken.setFieldType(2);
      addChildElement(localValueToken);
    }
    else if (!localValueToken.getJavaType().equals(getJavaType()))
    {
      localValueToken.changeValueType(getJavaType().K());
    }
    return localValueToken;
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

  public boolean isTextValue()
  {
    return (getAssignValue() != null) && (getAssignValue().getValueElement() != null) && ((getAssignValue().getValueElement() instanceof ConstantToken));
  }

  public void setValue(String paramString)
  {
    if ((getAssignValue() != null) && (getAssignValue().getValueElement() != null) && ((getAssignValue().getValueElement() instanceof ConstantToken)))
      ((ConstantToken)getAssignValue().getValueElement()).setText(paramString);
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
        if ((localObject instanceof IValueContainerToken))
          return pasteElement((IValueContainerToken)localObject);
      }
    }
    else if ((paramIElement instanceof IValueContainerToken))
    {
      removeElement(0);
      addChildElement(paramIElement);
      setModified(true);
      return true;
    }
    return false;
  }

  public boolean canPasteElement(IElement paramIElement)
  {
    return paramIElement instanceof IValueContainerToken;
  }

  public String toString()
  {
    return getValue() + "->" + getDisplayName();
  }

  protected Object clone()
  {
    return new PackageFieldGet(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.PackageFieldGet
 * JD-Core Version:    0.6.0
 */