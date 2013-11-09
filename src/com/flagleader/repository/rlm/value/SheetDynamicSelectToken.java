package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.AbstractValueToken;
import com.flagleader.repository.rlm.editen.ISheetDynamicEditen;
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

public class SheetDynamicSelectToken extends AbstractValueToken
  implements ISheetDynamicEditen, b, IValueToken
{
  private String elementUuid = "";
  private String uniqueName = "";
  private String sheetUuid = "";
  private String sheetUnique = "";
  private String fieldUuid = "";
  private String fieldUnique = "";
  private String valueUuid = "";
  private String valueUnique = "";
  private transient IBusinessObject rootSheet;

  public SheetDynamicSelectToken()
  {
  }

  public SheetDynamicSelectToken(SheetDynamicSelectToken paramSheetDynamicSelectToken)
  {
    super(paramSheetDynamicSelectToken);
    this.uniqueName = paramSheetDynamicSelectToken.uniqueName;
    this.elementUuid = paramSheetDynamicSelectToken.elementUuid;
    this.sheetUuid = paramSheetDynamicSelectToken.sheetUuid;
    this.sheetUnique = paramSheetDynamicSelectToken.sheetUnique;
    this.fieldUuid = paramSheetDynamicSelectToken.fieldUuid;
    this.fieldUnique = paramSheetDynamicSelectToken.fieldUnique;
    this.valueUuid = paramSheetDynamicSelectToken.valueUuid;
    this.valueUnique = paramSheetDynamicSelectToken.valueUnique;
  }

  public SheetDynamicSelectToken(String paramString, IBusinessObject paramIBusinessObject)
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

  public IBusinessObject getSheetField()
  {
    IBusinessObject localIBusinessObject1 = getMemberElement();
    if (this.fieldUuid.length() > 0)
    {
      IBusinessObject localIBusinessObject2 = null;
      List localList;
      int i;
      if ((localIBusinessObject1 != null) && ((localIBusinessObject1 instanceof SheetTable)))
      {
        localList = ((SheetTable)localIBusinessObject1).getFields();
        i = 0;
      }
      while (true)
        if (((IBusinessObject)localList.get(i)).getUuid().equals(this.fieldUuid))
        {
          localIBusinessObject2 = (IBusinessObject)localList.get(i);
        }
        else if (((IBusinessObject)localList.get(i)).getUuid().equals(this.fieldUnique))
        {
          localIBusinessObject2 = (IBusinessObject)localList.get(i);
        }
        else
        {
          i++;
          if (i < localList.size())
            continue;
          break;
          if ((localIBusinessObject1 == null) || (!(localIBusinessObject1.getParent() instanceof SheetTable)))
            break;
          localList = ((SheetTable)localIBusinessObject1.getParent()).getFields();
          for (i = 0; i < localList.size(); i++)
          {
            if (((IBusinessObject)localList.get(i)).getUuid().equals(this.fieldUuid))
            {
              localIBusinessObject2 = (IBusinessObject)localList.get(i);
              break;
            }
            if (!((IBusinessObject)localList.get(i)).getValueName().equals(this.fieldUnique))
              continue;
            localIBusinessObject2 = (IBusinessObject)localList.get(i);
            break;
          }
        }
      if (localIBusinessObject2 == null)
        localIBusinessObject2 = getEnvionment().getBusinessObject(this.fieldUuid, this.fieldUnique);
      return localIBusinessObject2;
    }
    return null;
  }

  public IBusinessObject getSheetValue()
  {
    IBusinessObject localIBusinessObject1 = getMemberElement();
    if (this.valueUuid.length() > 0)
    {
      IBusinessObject localIBusinessObject2 = null;
      List localList;
      int i;
      if ((localIBusinessObject1 != null) && ((localIBusinessObject1 instanceof SheetTable)))
      {
        localList = ((SheetTable)localIBusinessObject1).getFields();
        i = 0;
      }
      while (true)
        if (((IBusinessObject)localList.get(i)).getUuid().equals(this.valueUuid))
        {
          localIBusinessObject2 = (IBusinessObject)localList.get(i);
        }
        else if (((IBusinessObject)localList.get(i)).getUuid().equals(this.valueUnique))
        {
          localIBusinessObject2 = (IBusinessObject)localList.get(i);
        }
        else
        {
          i++;
          if (i < localList.size())
            continue;
          break;
          if ((localIBusinessObject1 == null) || (!(localIBusinessObject1.getParent() instanceof SheetTable)))
            break;
          localList = ((SheetTable)localIBusinessObject1.getParent()).getFields();
          for (i = 0; i < localList.size(); i++)
          {
            if (((IBusinessObject)localList.get(i)).getUuid().equals(this.valueUuid))
            {
              localIBusinessObject2 = (IBusinessObject)localList.get(i);
              break;
            }
            if (!((IBusinessObject)localList.get(i)).getValueName().equals(this.valueUnique))
              continue;
            localIBusinessObject2 = (IBusinessObject)localList.get(i);
            break;
          }
        }
      if (localIBusinessObject2 == null)
        localIBusinessObject2 = getEnvionment().getBusinessObject(this.valueUuid, this.valueUnique);
      return localIBusinessObject2;
    }
    return null;
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

  public void setSheetField(IBusinessObject paramIBusinessObject)
  {
    this.fieldUuid = paramIBusinessObject.getUuid();
    this.fieldUnique = paramIBusinessObject.getUniqueName();
  }

  public void setSheetValue(IBusinessObject paramIBusinessObject)
  {
    this.valueUuid = paramIBusinessObject.getUuid();
    this.valueUnique = paramIBusinessObject.getUniqueName();
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
      if (!(a().get(i) instanceof SheetFieldMapping))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  private boolean d()
  {
    return getValueType().equals("resultdynamic");
  }

  public void resetFieldMappings()
  {
    List localList1 = getCanSelectSourceFields();
    if ((localList1 != null) && (localList1.size() > 0))
    {
      clearAllChildren();
      List localList2 = getCanSelectFields();
      if (localList2 == null)
        return;
      HashMap localHashMap = new HashMap(localList2.size());
      Object localObject;
      for (int i = 0; i < localList1.size(); i++)
      {
        localObject = ((IBusinessObject)localList1.get(i)).getDisplayName();
        for (int j = 0; j < localList2.size(); j++)
        {
          if (!((IBusinessObject)localList2.get(j)).getDisplayName().equalsIgnoreCase((String)localObject))
            continue;
          localHashMap.put(localList1.get(i), localList2.remove(j));
          break;
        }
      }
      for (i = 0; i < localList1.size(); i++)
      {
        if ((localHashMap.get(localList1.get(i)) != null) || (localList2.size() <= 0))
          continue;
        localHashMap.put(localList1.get(i), localList2.remove(0));
      }
      for (i = 0; i < localList1.size(); i++)
      {
        if (localHashMap.get(localList1.get(i)) == null)
          continue;
        localObject = new SheetFieldMapping((IBusinessObject)localList1.get(i), (IBusinessObject)localHashMap.get(localList1.get(i)));
        addChildElement((IElement)localObject);
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
    if (localIBusinessObject == null)
      return null;
    SheetTable localSheetTable = null;
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
    Iterator localIterator = getEnvionment().getAcceptElements(new w(this));
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
    return paramRepositoryVisitor.visitSheetDynamicSelectToken(this);
  }

  public IElement deepClone()
  {
    return new SheetDynamicSelectToken(this);
  }

  public String getName()
  {
    return "SheetDynamicSelectToken";
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
    if (getSheetField() != null)
      localStringBuffer.append(getSheetField().getShowDisplayName()).append("\n");
    if (getSheetValue() != null)
      localStringBuffer.append(getSheetValue().getShowDisplayName()).append("\n");
    for (int i = 0; i < getChildrenCount(); i++)
    {
      if (!(a().get(i) instanceof SheetFieldMapping))
        continue;
      SheetFieldMapping localSheetFieldMapping = (SheetFieldMapping)a().get(i);
      if ((localSheetFieldMapping.getField() == null) || (localSheetFieldMapping.getMappingField() == null))
        continue;
      localStringBuffer.append(localSheetFieldMapping.getField().getShowDisplayName()).append("->").append(localSheetFieldMapping.getMappingField().getShowDisplayName()).append("\n");
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

  public String getValueUuid()
  {
    return this.valueUuid;
  }

  public void setValueUuid(String paramString)
  {
    this.valueUuid = paramString;
  }

  public String getValueUnique()
  {
    return this.valueUnique;
  }

  public void setValueUnique(String paramString)
  {
    this.valueUnique = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.SheetDynamicSelectToken
 * JD-Core Version:    0.6.0
 */