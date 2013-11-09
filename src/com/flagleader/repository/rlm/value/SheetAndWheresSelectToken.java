package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.AbstractValueToken;
import com.flagleader.repository.rlm.editen.ISheetAndWhereEditen;
import com.flagleader.repository.rlm.editen.b;
import com.flagleader.repository.rlm.lang.IValueToken;
import com.flagleader.repository.rom.IBOAndContainer;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SheetAndWheresSelectToken extends AbstractValueToken
  implements ISheetAndWhereEditen, b, IValueToken
{
  private String elementUuid = "";
  private String uniqueName = "";
  private String sheetUuid = "";
  private String sheetUnique = "";
  private transient IBusinessObject rootSheet;

  public SheetAndWheresSelectToken()
  {
  }

  public SheetAndWheresSelectToken(SheetAndWheresSelectToken paramSheetAndWheresSelectToken)
  {
    super(paramSheetAndWheresSelectToken);
    this.uniqueName = paramSheetAndWheresSelectToken.uniqueName;
    this.elementUuid = paramSheetAndWheresSelectToken.elementUuid;
    this.sheetUuid = paramSheetAndWheresSelectToken.sheetUuid;
    this.sheetUnique = paramSheetAndWheresSelectToken.sheetUnique;
  }

  public SheetAndWheresSelectToken(String paramString, IBusinessObject paramIBusinessObject)
  {
    super(paramString);
    this.elementUuid = paramIBusinessObject.getUuid();
    this.uniqueName = paramIBusinessObject.getUniqueName();
  }

  public IBusinessObject getRootSheetElement()
  {
    if (this.rootSheet == null)
    {
      IBusinessObject localIBusinessObject = getMemberElement();
      if ((localIBusinessObject != null) && ((localIBusinessObject.getParent() instanceof IBOAndContainer)))
        this.rootSheet = ((IBusinessObject)localIBusinessObject.getParent());
    }
    return this.rootSheet;
  }

  public IBusinessObject getMemberElement()
  {
    IBusinessObject localIBusinessObject = null;
    if ((getElementUuid().length() > 0) || (getUniqueName().length() > 0))
      localIBusinessObject = a(getElementUuid(), getUniqueName());
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

  public IBusinessObject getSourceSheet()
  {
    IBusinessObject localIBusinessObject = null;
    if ((getSheetUuid().length() > 0) || (getSheetUnique().length() > 0))
      localIBusinessObject = a(getSheetUuid(), getSheetUnique());
    if (localIBusinessObject != null)
    {
      if (!localIBusinessObject.getUuid().equals(getSheetUuid()))
      {
        setSheetUuid(localIBusinessObject.getUuid());
        if (getRoot() != null)
          getRoot().setNeedSave();
      }
      setSheetUnique(localIBusinessObject.getUniqueName());
    }
    return localIBusinessObject;
  }

  public void setSourceSheet(IBusinessObject paramIBusinessObject)
  {
    this.sheetUuid = paramIBusinessObject.getUuid();
    this.sheetUnique = paramIBusinessObject.getUniqueName();
  }

  protected IBusinessObject a(String paramString1, String paramString2)
  {
    IBusinessObject localIBusinessObject = null;
    Envionment localEnvionment = getEnvionment();
    if (localEnvionment != null)
      localIBusinessObject = localEnvionment.getBusinessObject(paramString1, paramString2);
    if ((localIBusinessObject instanceof IBusinessObject))
      return (IBusinessObject)localIBusinessObject;
    return null;
  }

  public List getSelectedFields()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    for (int i = 0; i < getChildrenCount(); i++)
    {
      if ((!(a().get(i) instanceof SheetFieldMapping)) || (((SheetFieldMapping)a().get(i)).getMappingType() != 0))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  public List getSelectedWheres()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    for (int i = 0; i < getChildrenCount(); i++)
    {
      if ((!(a().get(i) instanceof SheetFieldMapping)) || (((SheetFieldMapping)a().get(i)).getMappingType() != 1))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  private boolean d()
  {
    return getValueType().equals("resultandwheres");
  }

  public void resetFieldMappings(boolean paramBoolean)
  {
    List localList1 = getCanSelectSourceFields();
    if ((localList1 != null) && (localList1.size() > 0))
    {
      for (int i = getChildrenCount() - 1; i >= 0; i--)
      {
        localObject1 = (SheetFieldMapping)a().get(i);
        if (!(localObject1 instanceof SheetFieldMapping))
          continue;
        if ((paramBoolean) && (((SheetFieldMapping)localObject1).getMappingType() == 1))
        {
          ((SheetFieldMapping)localObject1).dispose();
        }
        else
        {
          if ((paramBoolean) || (((SheetFieldMapping)localObject1).getMappingType() != 0))
            continue;
          ((SheetFieldMapping)localObject1).dispose();
        }
      }
      List localList2 = getCanSelectFields();
      if (localList2 == null)
        return;
      Object localObject1 = new HashMap(localList2.size());
      Object localObject2;
      for (int j = 0; j < localList1.size(); j++)
      {
        localObject2 = ((IBusinessObject)localList1.get(j)).getDisplayName();
        for (int k = 0; k < localList2.size(); k++)
        {
          if (!((IBusinessObject)localList2.get(k)).getDisplayName().equalsIgnoreCase((String)localObject2))
            continue;
          ((HashMap)localObject1).put(localList1.get(j), localList2.remove(k));
          break;
        }
      }
      for (j = 0; j < localList1.size(); j++)
      {
        if ((((HashMap)localObject1).get(localList1.get(j)) != null) || (localList2.size() <= 0))
          continue;
        ((HashMap)localObject1).put(localList1.get(j), localList2.remove(0));
      }
      for (j = 0; j < localList1.size(); j++)
      {
        if (((HashMap)localObject1).get(localList1.get(j)) == null)
          continue;
        localObject2 = new SheetFieldMapping((IBusinessObject)localList1.get(j), (IBusinessObject)((HashMap)localObject1).get(localList1.get(j)));
        if (paramBoolean)
          ((SheetFieldMapping)localObject2).setMappingType(1);
        addChildElement((IElement)localObject2);
      }
      getRoot().setModified(true);
    }
  }

  public boolean checkValue(String paramString)
  {
    return false;
  }

  public List getCanSelectFields()
  {
    IBusinessObject localIBusinessObject = getMemberElement();
    SheetTable localSheetTable = null;
    if (localIBusinessObject == null)
      return null;
    if ((localIBusinessObject instanceof SheetTable))
      localSheetTable = (SheetTable)localIBusinessObject;
    else if ((localIBusinessObject.getParent() instanceof SheetTable))
      localSheetTable = (SheetTable)localIBusinessObject.getParent();
    if (localSheetTable != null)
      return localSheetTable.getFields();
    ISelectObject localISelectObject = null;
    if ((localIBusinessObject instanceof ISelectObject))
      localISelectObject = (ISelectObject)localIBusinessObject;
    else if ((localIBusinessObject.getParent() instanceof ISelectObject))
      localISelectObject = (ISelectObject)localIBusinessObject.getParent();
    if (localISelectObject != null)
      return localISelectObject.getFields();
    return null;
  }

  public List getCanSelectSourceFields()
  {
    IBusinessObject localIBusinessObject = getSourceSheet();
    if (localIBusinessObject != null)
    {
      if ((localIBusinessObject instanceof SheetTable))
        return ((SheetTable)localIBusinessObject).getFields();
      if ((localIBusinessObject instanceof ISelectObject))
        return ((ISelectObject)localIBusinessObject).getFields();
    }
    return null;
  }

  public List getCanSelectSources()
  {
    Iterator localIterator = getEnvionment().getAcceptElements(new v(this));
    ArrayList localArrayList = new ArrayList();
    while (localIterator.hasNext())
      localArrayList.add(localIterator.next());
    return localArrayList;
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
    return paramRepositoryVisitor.visitSheetAndWheresSelectToken(this);
  }

  public IElement deepClone()
  {
    return new SheetAndWheresSelectToken(this);
  }

  public String getName()
  {
    return "SheetAndWheresSelectToken";
  }

  public String getDisplayName()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (getSourceSheet() != null)
      localStringBuffer.append(getSourceSheet().getDisplayName());
    if (localStringBuffer.length() > 0)
      return localStringBuffer.substring(0, localStringBuffer.length());
    return getLocalString("selectAction.edit");
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

  public List getSelectedConditions()
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
    Object localObject;
    for (int i = 0; i < getChildrenCount(); i++)
    {
      if ((!(a().get(i) instanceof SheetFieldMapping)) || (((SheetFieldMapping)a().get(i)).getMappingType() != 0))
        continue;
      localObject = (SheetFieldMapping)a().get(i);
      if ((((SheetFieldMapping)localObject).getField() == null) || (((SheetFieldMapping)localObject).getMappingField() == null))
        continue;
      localStringBuffer.append(((SheetFieldMapping)localObject).getField().getShowDisplayName()).append("->").append(((SheetFieldMapping)localObject).getMappingField().getShowDisplayName()).append("\n");
    }
    for (i = 0; i < getChildrenCount(); i++)
    {
      if ((!(a().get(i) instanceof SheetFieldMapping)) || (((SheetFieldMapping)a().get(i)).getMappingType() != 1))
        continue;
      localObject = (SheetFieldMapping)a().get(i);
      if ((((SheetFieldMapping)localObject).getField() == null) || (((SheetFieldMapping)localObject).getMappingField() == null))
        continue;
      localStringBuffer.append(((SheetFieldMapping)localObject).getField().getShowDisplayName()).append(" = ").append(((SheetFieldMapping)localObject).getMappingField().getShowDisplayName()).append("\n");
    }
    for (i = 0; i < getChildrenCount(); i++)
    {
      if (!(a().get(i) instanceof SheetWhere))
        continue;
      localObject = (SheetWhere)a().get(i);
      if ((((SheetWhere)localObject).getField() == null) || (((SheetWhere)localObject).getAssignValue() == null))
        continue;
      localStringBuffer.append(((SheetWhere)localObject).getField().getShowDisplayName()).append(((SheetWhere)localObject).getFuncName()).append(((SheetWhere)localObject).getValue()).append("\n");
    }
    return (String)localStringBuffer.toString();
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

  public String getSheetUuid()
  {
    return this.sheetUuid;
  }

  public void setSheetUuid(String paramString)
  {
    this.sheetUuid = paramString;
  }

  public String getSheetUnique()
  {
    return this.sheetUnique;
  }

  public void setSheetUnique(String paramString)
  {
    this.sheetUnique = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.SheetAndWheresSelectToken
 * JD-Core Version:    0.6.0
 */