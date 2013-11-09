package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.db.SheetFieldModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rlm.AbstractValueToken;
import com.flagleader.repository.rlm.editen.ISheetWhereEditen;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.ArrayList;
import java.util.List;

public class SheetWheresSelectToken extends AbstractValueToken
  implements ISheetWhereEditen, IValueToken
{
  private String elementUuid = "";
  private String uniqueName = "";
  public static String[] SHEETFUNCTIONS = { "<", "<=", ">", ">=", "<>", "==", "=~=", "=", "~=", "!=", "like", "in", "~in", "notin", "~notin" };

  public SheetWheresSelectToken()
  {
  }

  public SheetWheresSelectToken(SheetWheresSelectToken paramSheetWheresSelectToken)
  {
    super(paramSheetWheresSelectToken);
    this.uniqueName = paramSheetWheresSelectToken.uniqueName;
    this.elementUuid = paramSheetWheresSelectToken.elementUuid;
  }

  public SheetWheresSelectToken(String paramString, IBusinessObject paramIBusinessObject)
  {
    super(paramString);
    this.elementUuid = paramIBusinessObject.getUuid();
    this.uniqueName = paramIBusinessObject.getUniqueName();
  }

  public String[] getTypeFunctions(g paramg)
  {
    if ((paramg.b()) || (paramg.j()))
      return new String[] { "<", "<=", ">", ">=", "<>", "==", "=~=" };
    if (paramg.m())
      return new String[] { "=", "~=", "!=", "like", "in", "~in", "notin", "~notin" };
    if ((paramg.v()) || (paramg.w()) || (paramg.x()))
      return new String[] { "=", "!=", "<", "<=", ">", ">=" };
    return new String[] { "=", "!=" };
  }

  public IBusinessObject getMemberElement()
  {
    IBusinessObject localIBusinessObject = null;
    if ((getElementUuid().length() > 0) || (getUniqueName().length() > 0))
      localIBusinessObject = d();
    if (localIBusinessObject != null)
    {
      if (!localIBusinessObject.getUuid().equals(getElementUuid()))
      {
        setElementUuid(localIBusinessObject.getUuid());
        if (getRoot() != null)
          getRoot().setNeedSave();
      }
      setUniqueName(localIBusinessObject.getUniqueName());
    }
    return localIBusinessObject;
  }

  protected IBusinessObject d()
  {
    IBusinessObject localIBusinessObject = null;
    Envionment localEnvionment = getEnvionment();
    if (localEnvionment != null)
      localIBusinessObject = localEnvionment.getBusinessObject(getElementUuid(), getUniqueName());
    if ((localIBusinessObject instanceof IBusinessObject))
      return (IBusinessObject)localIBusinessObject;
    return null;
  }

  public List getSelectedFields()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    for (int i = 0; i < getChildrenCount(); i++)
    {
      if (!(a().get(i) instanceof SheetWhere))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  public boolean checkValue(String paramString)
  {
    return false;
  }

  public IBusinessObject[] getCanSelectFields()
  {
    IBusinessObject localIBusinessObject = getMemberElement();
    SheetTable localSheetTable = null;
    if ((localIBusinessObject instanceof SheetTable))
      localSheetTable = (SheetTable)localIBusinessObject;
    else if ((localIBusinessObject.getParent() instanceof SheetTable))
      localSheetTable = (SheetTable)localIBusinessObject.getParent();
    if (localSheetTable != null)
    {
      List localList = localSheetTable.getFields();
      IBusinessObject[] arrayOfIBusinessObject = new IBusinessObject[localList.size()];
      for (int i = 0; i < arrayOfIBusinessObject.length; i++)
      {
        SheetFieldModel localSheetFieldModel = (SheetFieldModel)localList.get(i);
        arrayOfIBusinessObject[i] = localSheetFieldModel;
      }
      return arrayOfIBusinessObject;
    }
    return null;
  }

  public String[] getOperators()
  {
    return SHEETFUNCTIONS;
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

  public g getJavaType()
  {
    return getTypeManager().a("string");
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitSheetWheresSelectToken(this);
  }

  public IElement deepClone()
  {
    return new SheetWheresSelectToken(this);
  }

  public String getName()
  {
    return "SheetWheresSelectToken";
  }

  public String getDisplayName()
  {
    if (getEnvionment() == null)
      return this.uniqueName;
    StringBuffer localStringBuffer = new StringBuffer();
    List localList = getSelectedFields();
    for (int i = 0; i < localList.size(); i++)
    {
      SheetWhere localSheetWhere = (SheetWhere)localList.get(i);
      IBusinessObject localIBusinessObject = getEnvionment().getBusinessObject(localSheetWhere.getFieldUuid(), localSheetWhere.getFieldUnique());
      if ((localSheetWhere.isNary()) && (i != localList.size() - 1) && ((i <= 0) || (!((SheetWhere)localList.get(i - 1)).isNary())))
        localStringBuffer.append("(");
      if (localIBusinessObject != null)
        localStringBuffer.append(localIBusinessObject.getDisplayName());
      if (localSheetWhere.getFuncName().length() > 0)
        localStringBuffer.append(localSheetWhere.getFuncName());
      if (localSheetWhere.getValue().length() > 0)
        localStringBuffer.append(localSheetWhere.getValue());
      if ((i > 0) && (((SheetWhere)localList.get(i - 1)).isNary()) && ((i == localList.size() - 1) || (!localSheetWhere.isNary())))
        localStringBuffer.append(")");
      if (i == localList.size() - 1)
        continue;
      localStringBuffer.append(" ").append(localSheetWhere.getNaryType()).append(" ");
    }
    if (localStringBuffer.length() > 0)
      return localStringBuffer.substring(0, localStringBuffer.length());
    return getLocalString("emptySelect.edit");
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
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < getChildrenCount(); i++)
    {
      if (!(a().get(i) instanceof SheetWhere))
        continue;
      SheetWhere localSheetWhere = (SheetWhere)a().get(i);
      IBusinessObject localIBusinessObject = getEnvionment().getBusinessObject(localSheetWhere.getFieldUuid(), localSheetWhere.getFieldUnique());
      if (localIBusinessObject == null)
        continue;
      localStringBuffer.append(localIBusinessObject.getShowDisplayName()).append(" ").append(localSheetWhere.getFuncName()).append(" ").append(localSheetWhere.getValue()).append("\n");
    }
    return localStringBuffer.toString();
  }

  public boolean hasHint()
  {
    return false;
  }

  public String getElementUuid()
  {
    return this.elementUuid;
  }

  public void setElementUuid(String paramString)
  {
    this.elementUuid = paramString;
  }

  public String getUniqueName()
  {
    return this.uniqueName;
  }

  public void setUniqueName(String paramString)
  {
    this.uniqueName = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.SheetWheresSelectToken
 * JD-Core Version:    0.6.0
 */