package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rlm.AbstractValueToken;
import com.flagleader.repository.rlm.editen.ISheetFunctionEditen;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SheetFunctionsSelectToken extends AbstractValueToken
  implements ISheetFunctionEditen, IValueToken
{
  private String elementUuid = "";
  private String uniqueName = "";
  public static String[] SHEETFUNCTIONS = { "", "sum", "average", "count", "max", "min", "last", "first", "append", "unique" };

  public SheetFunctionsSelectToken()
  {
  }

  public SheetFunctionsSelectToken(SheetFunctionsSelectToken paramSheetFunctionsSelectToken)
  {
    super(paramSheetFunctionsSelectToken);
    this.uniqueName = paramSheetFunctionsSelectToken.uniqueName;
    this.elementUuid = paramSheetFunctionsSelectToken.elementUuid;
  }

  public SheetFunctionsSelectToken(String paramString, IBusinessObject paramIBusinessObject)
  {
    super(paramString);
    this.elementUuid = paramIBusinessObject.getUuid();
    this.uniqueName = paramIBusinessObject.getUniqueName();
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

  public boolean exitsSelectField(IBusinessObject paramIBusinessObject)
  {
    for (int i = 0; i < getChildrenCount(); i++)
      if (((a().get(i) instanceof SheetFunction)) && (paramIBusinessObject.equals(((SheetFunction)a().get(i)).getField())))
        return true;
    return false;
  }

  public List getSelectedElements()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    for (int i = 0; i < getChildrenCount(); i++)
    {
      if (!(a().get(i) instanceof SheetFunction))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  public boolean checkValue(String paramString)
  {
    return false;
  }

  public List getSelects()
  {
    IBusinessObject localIBusinessObject = getMemberElement();
    SheetTable localSheetTable = null;
    if ((localIBusinessObject instanceof SheetTable))
      localSheetTable = (SheetTable)localIBusinessObject;
    else if ((localIBusinessObject.getParent() instanceof SheetTable))
      localSheetTable = (SheetTable)localIBusinessObject.getParent();
    if (localSheetTable != null)
      return localSheetTable.getFields();
    return new ArrayList(0);
  }

  public List getAsTargetSelects()
  {
    if ((getParent() != null) && (getParent().getParent() != null) && ((getParent().getParent().getParent().getParent() instanceof MemberToken)))
    {
      IElement localIElement = ((MemberToken)getParent().getParent().getParent().getParent()).getMemberElement();
      if ((localIElement != null) && ((localIElement.getParent() instanceof SheetTable)))
      {
        SheetTable localSheetTable = (SheetTable)localIElement.getParent();
        return localSheetTable.getFields();
      }
    }
    return new ArrayList(0);
  }

  public Iterator getSelectedGroupFields()
  {
    if ((getParent() != null) && ((getParent().getParent() instanceof MemberToken)))
      return ((MemberToken)getParent().getParent()).getAcceptElements(new y(this));
    return null;
  }

  public String[] getAsNameSelects()
  {
    if ((getParent() != null) && (getParent().getParent() != null) && ((getParent().getParent().getParent().getParent() instanceof MemberToken)))
    {
      IElement localIElement = ((MemberToken)getParent().getParent().getParent().getParent()).getMemberElement();
      if ((localIElement != null) && ((localIElement.getParent() instanceof SheetTable)))
      {
        SheetTable localSheetTable = (SheetTable)localIElement.getParent();
        return localSheetTable.getFieldDisNames();
      }
    }
    return new String[0];
  }

  public void resetFieldMappings()
  {
    List localList = getSelects();
    if (localList.size() > 0)
    {
      String[] arrayOfString = getAsNameSelects();
      HashMap localHashMap = new HashMap(localList.size());
      for (int i = 0; i < arrayOfString.length; i++)
      {
        String str = arrayOfString[i];
        for (int j = 0; j < localList.size(); j++)
        {
          if (!((IBusinessObject)localList.get(j)).getDisplayName().equalsIgnoreCase(str))
            continue;
          localHashMap.put(arrayOfString[i], localList.remove(j));
          break;
        }
      }
      for (i = 0; i < arrayOfString.length; i++)
      {
        if ((localHashMap.get(arrayOfString[i]) != null) || (localList.size() <= 0))
          continue;
        localHashMap.put(arrayOfString[i], localList.remove(0));
      }
      for (i = 0; i < arrayOfString.length; i++)
      {
        if (localHashMap.get(arrayOfString[i]) == null)
          continue;
        addChildElement(new SheetFunction("", (IBusinessObject)localHashMap.get(arrayOfString[i]), arrayOfString[i]));
      }
      getRoot().setModified(true);
    }
  }

  public String[] getFunctionNames()
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
    return paramRepositoryVisitor.visitSheetFunctionsSelectToken(this);
  }

  public IElement deepClone()
  {
    return new SheetFunctionsSelectToken(this);
  }

  public String getName()
  {
    return "SheetFunctionsSelectToken";
  }

  public String getDisplayName()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (int i = 0; i < getChildrenCount(); i++)
    {
      if (!(a().get(i) instanceof SheetFunction))
        continue;
      SheetFunction localSheetFunction = (SheetFunction)a().get(i);
      Envionment localEnvionment = getEnvionment();
      if (localEnvionment == null)
        continue;
      IBusinessObject localIBusinessObject = localEnvionment.getBusinessObject(localSheetFunction.getFieldUuid(), localSheetFunction.getFieldUnique());
      if (localIBusinessObject == null)
        continue;
      if (localStringBuffer.length() > 0)
        localStringBuffer.append(",");
      if (localSheetFunction.getFuncName().length() > 0)
        localStringBuffer.append(localSheetFunction.getFuncName()).append("(").append(localIBusinessObject.getDisplayName()).append(") ");
      else
        localStringBuffer.append(localIBusinessObject.getDisplayName());
    }
    if (localStringBuffer.length() > 0)
      return localStringBuffer.substring(0, localStringBuffer.length() - 1);
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
      if (!(a().get(i) instanceof SheetFunction))
        continue;
      SheetFunction localSheetFunction = (SheetFunction)a().get(i);
      IBusinessObject localIBusinessObject = getEnvionment().getBusinessObject(localSheetFunction.getFieldUuid(), localSheetFunction.getFieldUnique());
      if (localIBusinessObject == null)
        continue;
      if (localSheetFunction.getFuncName().length() > 0)
        localStringBuffer.append(localSheetFunction.getFuncName()).append("(").append(localIBusinessObject.getShowDisplayName()).append(") -> ").append(localSheetFunction.getAsName()).append("\n");
      else
        localStringBuffer.append(localIBusinessObject.getShowDisplayName()).append(" -> ").append(localSheetFunction.getAsName()).append("\n");
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
 * Qualified Name:     com.flagleader.repository.rlm.value.SheetFunctionsSelectToken
 * JD-Core Version:    0.6.0
 */