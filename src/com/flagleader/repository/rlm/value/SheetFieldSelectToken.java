package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.AbstractValueToken;
import com.flagleader.repository.rlm.editen.ISheetFieldEditen;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IVariableObject;
import com.flagleader.repository.rom.IWhileObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleContainer;
import com.flagleader.repository.tree.IRuleTree;
import java.util.List;

public class SheetFieldSelectToken extends AbstractValueToken
  implements ISheetFieldEditen, IValueToken
{
  private String fieldUuid = "";
  private String fieldUnique = "";

  public SheetFieldSelectToken()
  {
  }

  public SheetFieldSelectToken(SheetFieldSelectToken paramSheetFieldSelectToken)
  {
    super(paramSheetFieldSelectToken);
    this.fieldUuid = paramSheetFieldSelectToken.fieldUuid;
    this.fieldUnique = paramSheetFieldSelectToken.fieldUnique;
  }

  public SheetFieldSelectToken(String paramString)
  {
    super(paramString);
  }

  public SheetFieldSelectToken(String paramString, IBusinessObject paramIBusinessObject)
  {
    super(paramString);
    this.fieldUuid = paramIBusinessObject.getUuid();
    this.fieldUnique = paramIBusinessObject.getUniqueName();
  }

  public void setSelected(IBusinessObject paramIBusinessObject)
  {
    this.fieldUuid = paramIBusinessObject.getUuid();
    this.fieldUnique = paramIBusinessObject.getUniqueName();
  }

  public IBusinessObject getSelected()
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

  public boolean checkValue(String paramString)
  {
    return false;
  }

  public g getJavaType()
  {
    if (getSelected() != null)
      return getSelected().getJavaType();
    return super.getJavaType();
  }

  public IBusinessObject[] getSelects()
  {
    IPackageElement localIPackageElement = getRoot().getRuleTree();
    if ((localIPackageElement != null) && ((localIPackageElement instanceof IRuleTree)) && (((IRuleTree)localIPackageElement).getWhileSheet() != null))
    {
      IWhileObject localIWhileObject = ((IRuleTree)localIPackageElement).getWhileSheet();
      if (localIWhileObject != null)
      {
        List localList = localIWhileObject.getFields();
        IBusinessObject[] arrayOfIBusinessObject = new IBusinessObject[localList.size()];
        for (int i = 0; i < arrayOfIBusinessObject.length; i++)
        {
          IVariableObject localIVariableObject = (IVariableObject)localList.get(i);
          arrayOfIBusinessObject[i] = localIVariableObject;
        }
        return arrayOfIBusinessObject;
      }
    }
    return null;
  }

  public String getText()
  {
    return getDisplayName();
  }

  public boolean hasSelects()
  {
    return true;
  }

  public void setText(String paramString)
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitSheetFieldSelectToken(this);
  }

  public IElement deepClone()
  {
    return new SheetFieldSelectToken(this);
  }

  public String getName()
  {
    return "SheetFieldSelectToken";
  }

  public String getDisplayName()
  {
    IBusinessObject localIBusinessObject = getSelected();
    if (localIBusinessObject != null)
      return localIBusinessObject.getDisplayName();
    return getLocalString("selectAction.edit");
  }

  public boolean canEdit()
  {
    return true;
  }

  public String getColorType()
  {
    return "value";
  }

  public String getHint()
  {
    return "";
  }

  public String getNote()
  {
    IBusinessObject localIBusinessObject = getSelected();
    if (localIBusinessObject != null)
      return localIBusinessObject.getValueName();
    return "";
  }

  public boolean hasHint()
  {
    return false;
  }

  public String getFieldUuid()
  {
    return this.fieldUuid;
  }

  public void setFieldUuid(String paramString)
  {
    this.fieldUuid = paramString;
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
 * Qualified Name:     com.flagleader.repository.rlm.value.SheetFieldSelectToken
 * JD-Core Version:    0.6.0
 */