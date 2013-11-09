package com.flagleader.repository.rlm.value;

import com.flagleader.repository.ElementContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rlm.AbstractRuleContainer;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.lang.IValueContainerToken;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.Iterator;

public class SheetWhere extends AbstractRuleContainer
  implements ILineEditen, IRuleContainer
{
  private String funcName = "";
  private String fieldUuid = "";
  private String fieldUnique = "";
  private String naryType = "and";
  private transient IBusinessObject sheetField;

  public String getNaryType()
  {
    return this.naryType;
  }

  public void setNaryType(String paramString)
  {
    this.naryType = paramString;
  }

  public boolean isNary()
  {
    return this.naryType.equals("or");
  }

  public SheetWhere()
  {
  }

  public SheetWhere(String paramString, IBusinessObject paramIBusinessObject)
  {
    this.funcName = paramString;
    this.fieldUuid = paramIBusinessObject.getUuid();
    this.fieldUnique = paramIBusinessObject.getUniqueName();
    this.sheetField = paramIBusinessObject;
  }

  public SheetWhere(SheetWhere paramSheetWhere)
  {
    super(paramSheetWhere);
    this.funcName = paramSheetWhere.funcName;
    this.fieldUuid = paramSheetWhere.fieldUuid;
    this.fieldUnique = paramSheetWhere.fieldUnique;
    this.naryType = paramSheetWhere.naryType;
  }

  public IBusinessObject getField()
  {
    if (this.sheetField == null)
      this.sheetField = getEnvionment().getBusinessObject(getFieldUuid(), getFieldUnique());
    return this.sheetField;
  }

  public void setField(IBusinessObject paramIBusinessObject)
  {
    this.sheetField = paramIBusinessObject;
    this.fieldUuid = paramIBusinessObject.getUuid();
    this.fieldUnique = paramIBusinessObject.getUniqueName();
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitSheetWhere(this);
  }

  public IElement deepClone()
  {
    return new SheetWhere(this);
  }

  public String getName()
  {
    return "SheetWhere";
  }

  public IBusinessObject getMemberElement()
  {
    IBusinessObject localIBusinessObject = null;
    if ((getFieldUuid().length() > 0) || (getFieldUnique().length() > 0))
      localIBusinessObject = d();
    if (localIBusinessObject != null)
    {
      if (!localIBusinessObject.getUuid().equals(getFieldUuid()))
      {
        setFieldUuid(localIBusinessObject.getUuid());
        if (getRoot() != null)
          getRoot().setNeedSave();
      }
      setFieldUnique(localIBusinessObject.getUniqueName());
    }
    return localIBusinessObject;
  }

  protected IBusinessObject d()
  {
    IBusinessObject localIBusinessObject = null;
    Envionment localEnvionment = getEnvionment();
    if (localEnvionment != null)
      localIBusinessObject = localEnvionment.getBusinessObject(getFieldUuid(), getFieldUnique());
    if ((localIBusinessObject instanceof IBusinessObject))
      return (IBusinessObject)localIBusinessObject;
    return null;
  }

  public IValueContainerToken getAssignValue()
  {
    ValueToken localValueToken = null;
    Iterator localIterator = getChildrenIterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (!(localObject instanceof ValueToken))
        continue;
      localValueToken = (ValueToken)localObject;
      break;
    }
    if (localValueToken == null)
    {
      localObject = getMemberElement();
      if (localObject != null)
      {
        localValueToken = new ValueToken(2, getJavaType().K(), "");
        localValueToken.setFieldType(2);
        addChildElement(localValueToken);
      }
    }
    else if (!localValueToken.getJavaType().equals(getJavaType()))
    {
      localValueToken.changeValueType(getJavaType().K());
    }
    return (IValueContainerToken)localValueToken;
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
    IBusinessObject localIBusinessObject = d();
    if ((localIBusinessObject != null) && ((localIBusinessObject instanceof IBusinessObject)))
      return localIBusinessObject.getJavaType();
    return getTypeManager().a("");
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
    return this.funcName;
  }

  public String getFieldUuid()
  {
    return this.fieldUuid;
  }

  public void setFuncName(String paramString)
  {
    this.funcName = paramString;
  }

  public void setFieldUuid(String paramString)
  {
    this.fieldUuid = paramString;
  }

  public String toString()
  {
    return this.funcName + "(" + this.fieldUnique + ") as " + getValue();
  }

  protected Object clone()
  {
    return new SheetWhere(this);
  }

  public String getFieldUnique()
  {
    return this.fieldUnique;
  }

  public void setFieldUnique(String paramString)
  {
    this.fieldUnique = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.SheetWhere
 * JD-Core Version:    0.6.0
 */