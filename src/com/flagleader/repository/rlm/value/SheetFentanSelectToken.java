package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.db.ISelectObject;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rlm.AbstractValueToken;
import com.flagleader.repository.rlm.editen.ISheetFentanEditen;
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

public class SheetFentanSelectToken extends AbstractValueToken
  implements ISheetFentanEditen, b, IValueToken
{
  private String elementUuid = "";
  private String uniqueName = "";
  private String sheetUuid = "";
  private String sheetUnique = "";
  private String bSheetUuid = "";
  private String bSheetUnique = "";
  private String afentanUuid = "";
  private String afentanUnique = "";
  private String cfentanUuid = "";
  private String cfentanUnique = "";
  private String byingziUuid = "";
  private String byingziUnique = "";
  private String cyingziUuid = "";
  private String cyingziUnique = "";
  private transient IBusinessObject rootSheet;

  public IBusinessObject getAFentanField()
  {
    IBusinessObject localIBusinessObject = getEnvionment().getBusinessObject(getAfentanUuid(), getAfentanUnique());
    if ((localIBusinessObject != null) && ((!localIBusinessObject.getUuid().equals(getAfentanUuid())) || (!localIBusinessObject.getUniqueName().equals(getAfentanUnique()))))
    {
      this.afentanUuid = localIBusinessObject.getUuid();
      this.afentanUnique = localIBusinessObject.getUniqueName();
      if (getRoot() != null)
        getRoot().setNeedSave();
    }
    return localIBusinessObject;
  }

  public IBusinessObject getCFentanField()
  {
    IBusinessObject localIBusinessObject = getEnvionment().getBusinessObject(getCfentanUuid(), getCfentanUnique());
    if ((localIBusinessObject != null) && ((!localIBusinessObject.getUuid().equals(getCfentanUuid())) || (!localIBusinessObject.getUniqueName().equals(getCfentanUnique()))))
    {
      this.cfentanUuid = localIBusinessObject.getUuid();
      this.cfentanUnique = localIBusinessObject.getUniqueName();
      if (getRoot() != null)
        getRoot().setNeedSave();
    }
    return localIBusinessObject;
  }

  public IBusinessObject getByingziField()
  {
    IBusinessObject localIBusinessObject = getEnvionment().getBusinessObject(getByingziUuid(), getByingziUnique());
    if ((localIBusinessObject != null) && ((!localIBusinessObject.getUuid().equals(getByingziUuid())) || (!localIBusinessObject.getUniqueName().equals(getByingziUnique()))))
    {
      this.byingziUuid = localIBusinessObject.getUuid();
      this.byingziUnique = localIBusinessObject.getUniqueName();
      if (getRoot() != null)
        getRoot().setNeedSave();
    }
    return localIBusinessObject;
  }

  public IBusinessObject getCyingziField()
  {
    IBusinessObject localIBusinessObject = getEnvionment().getBusinessObject(getCyingziUuid(), getCyingziUnique());
    if ((localIBusinessObject != null) && ((!localIBusinessObject.getUuid().equals(getCyingziUuid())) || (!localIBusinessObject.getUniqueName().equals(getCyingziUnique()))))
    {
      this.cyingziUuid = localIBusinessObject.getUuid();
      this.cyingziUnique = localIBusinessObject.getUniqueName();
      if (getRoot() != null)
        getRoot().setNeedSave();
    }
    return localIBusinessObject;
  }

  public SheetFentanSelectToken()
  {
  }

  public SheetFentanSelectToken(SheetFentanSelectToken paramSheetFentanSelectToken)
  {
    super(paramSheetFentanSelectToken);
    this.uniqueName = paramSheetFentanSelectToken.uniqueName;
    this.elementUuid = paramSheetFentanSelectToken.elementUuid;
    this.sheetUuid = paramSheetFentanSelectToken.sheetUuid;
    this.sheetUnique = paramSheetFentanSelectToken.sheetUnique;
    this.bSheetUuid = paramSheetFentanSelectToken.bSheetUuid;
    this.bSheetUnique = paramSheetFentanSelectToken.bSheetUnique;
    this.afentanUuid = paramSheetFentanSelectToken.afentanUuid;
    this.afentanUnique = paramSheetFentanSelectToken.afentanUnique;
    this.cfentanUuid = paramSheetFentanSelectToken.cfentanUuid;
    this.cfentanUnique = paramSheetFentanSelectToken.cfentanUnique;
    this.byingziUuid = paramSheetFentanSelectToken.byingziUuid;
    this.byingziUnique = paramSheetFentanSelectToken.byingziUnique;
    this.cyingziUuid = paramSheetFentanSelectToken.cyingziUuid;
    this.cyingziUnique = paramSheetFentanSelectToken.cyingziUnique;
  }

  public SheetFentanSelectToken(String paramString, IBusinessObject paramIBusinessObject)
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

  public IBusinessObject getSourceSheet(boolean paramBoolean)
  {
    IBusinessObject localIBusinessObject = null;
    if (paramBoolean)
    {
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
    }
    else
    {
      if ((getbSheetUuid().length() > 0) || (getbSheetUnique().length() > 0))
        localIBusinessObject = a(getbSheetUuid(), getbSheetUnique());
      if (localIBusinessObject != null)
      {
        if (!localIBusinessObject.getUuid().equals(getbSheetUuid()))
        {
          setbSheetUuid(localIBusinessObject.getUuid());
          if (getRoot() != null)
            getRoot().setNeedSave();
        }
        setbSheetUnique(localIBusinessObject.getUniqueName());
      }
    }
    return localIBusinessObject;
  }

  public void setSourceSheet(IBusinessObject paramIBusinessObject, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.sheetUuid = paramIBusinessObject.getUuid();
      this.sheetUnique = paramIBusinessObject.getUniqueName();
    }
    else
    {
      this.bSheetUuid = paramIBusinessObject.getUuid();
      this.bSheetUnique = paramIBusinessObject.getUniqueName();
    }
  }

  public IBusinessObject getSourceField(int paramInt)
  {
    if (paramInt == 0)
      return getEnvionment().getBusinessObject(this.afentanUuid, this.afentanUnique);
    if (paramInt == 1)
      return getEnvionment().getBusinessObject(this.cfentanUuid, this.cfentanUnique);
    if (paramInt == 2)
      return getEnvionment().getBusinessObject(this.byingziUuid, this.byingziUnique);
    if (paramInt == 3)
      return getEnvionment().getBusinessObject(this.cyingziUuid, this.cyingziUnique);
    return null;
  }

  public void setSourcrField(IBusinessObject paramIBusinessObject, int paramInt)
  {
    if (paramInt == 0)
    {
      this.afentanUuid = paramIBusinessObject.getUuid();
      this.afentanUnique = paramIBusinessObject.getUniqueName();
    }
    else if (paramInt == 1)
    {
      this.cfentanUuid = paramIBusinessObject.getUuid();
      this.cfentanUnique = paramIBusinessObject.getUniqueName();
    }
    else if (paramInt == 2)
    {
      this.byingziUuid = paramIBusinessObject.getUuid();
      this.byingziUnique = paramIBusinessObject.getUniqueName();
    }
    else if (paramInt == 3)
    {
      this.cyingziUuid = paramIBusinessObject.getUuid();
      this.cyingziUnique = paramIBusinessObject.getUniqueName();
    }
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

  public List getSelectedFields(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    for (int i = 0; i < getChildrenCount(); i++)
    {
      if (!(a().get(i) instanceof SheetFieldMapping))
        continue;
      IBusinessObject localIBusinessObject = ((SheetFieldMapping)a().get(i)).getMappingField();
      if ((localIBusinessObject == null) || (localIBusinessObject.getParent() == null) || (!localIBusinessObject.getParent().equals(getSourceSheet(paramBoolean))))
        continue;
      localArrayList.add(a().get(i));
    }
    return localArrayList;
  }

  private boolean d()
  {
    return getValueType().equals("resultfentan");
  }

  public void resetFieldMappings(boolean paramBoolean)
  {
    List localList1 = getCanSelectSourceFields(paramBoolean);
    if ((localList1 != null) && (localList1.size() > 0))
    {
      List localList2 = getCanSelectFields();
      if (localList2 == null)
        return;
      clearAllChildren();
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
    List localList = getCanSelectSourceFields(true);
    localList.addAll(getCanSelectSourceFields(false));
    return localList;
  }

  public List getCanSelectSourceFields(boolean paramBoolean)
  {
    IBusinessObject localIBusinessObject = getSourceSheet(paramBoolean);
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
    Iterator localIterator = getEnvionment().getAcceptElements(new x(this));
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
    return paramRepositoryVisitor.visitSheetFentanSelectToken(this);
  }

  public IElement deepClone()
  {
    return new SheetFentanSelectToken(this);
  }

  public String getName()
  {
    return "SheetFentanSelectToken";
  }

  public String getDisplayName()
  {
    if ((getSourceSheet(true) != null) && (getSourceSheet(false) != null) && (getAFentanField() != null) && (getByingziField() != null))
      return format("sheetfentan.edit", new String[] { getSourceSheet(true).getDisplayName(), getAFentanField().getDisplayName(), getSourceSheet(false).getDisplayName(), getByingziField().getDisplayName() });
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
      if (!(a().get(i) instanceof SheetFentanMapping))
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
      if (!(a().get(i) instanceof SheetFieldMapping))
        continue;
      localObject = (SheetFieldMapping)a().get(i);
      if ((((SheetFieldMapping)localObject).getField() == null) || (((SheetFieldMapping)localObject).getMappingField() == null))
        continue;
      localStringBuffer.append(((SheetFieldMapping)localObject).getField().getShowDisplayName()).append("->").append(((SheetFieldMapping)localObject).getMappingField().getShowDisplayName()).append("\n");
    }
    for (i = 0; i < getChildrenCount(); i++)
    {
      if (!(a().get(i) instanceof SheetFentanMapping))
        continue;
      localObject = (SheetFentanMapping)a().get(i);
      if ((((SheetFentanMapping)localObject).getField() == null) || (((SheetFentanMapping)localObject).getBField() == null) || (((SheetFentanMapping)localObject).getMappingField() == null))
        continue;
      localStringBuffer.append(((SheetFentanMapping)localObject).getField().getShowDisplayName()).append("->").append(((SheetFentanMapping)localObject).getBField().getShowDisplayName()).append("->").append(((SheetFentanMapping)localObject).getMappingField().getShowDisplayName()).append("\n");
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

  public String getAfentanUuid()
  {
    return this.afentanUuid;
  }

  public void setAfentanUuid(String paramString)
  {
    this.afentanUuid = paramString;
  }

  public String getAfentanUnique()
  {
    return this.afentanUnique;
  }

  public void setAfentanUnique(String paramString)
  {
    this.afentanUnique = paramString;
  }

  public String getCfentanUuid()
  {
    return this.cfentanUuid;
  }

  public void setCfentanUuid(String paramString)
  {
    this.cfentanUuid = paramString;
  }

  public String getCfentanUnique()
  {
    return this.cfentanUnique;
  }

  public void setCfentanUnique(String paramString)
  {
    this.cfentanUnique = paramString;
  }

  public String getByingziUuid()
  {
    return this.byingziUuid;
  }

  public void setByingziUuid(String paramString)
  {
    this.byingziUuid = paramString;
  }

  public String getByingziUnique()
  {
    return this.byingziUnique;
  }

  public void setByingziUnique(String paramString)
  {
    this.byingziUnique = paramString;
  }

  public String getCyingziUuid()
  {
    return this.cyingziUuid;
  }

  public void setCyingziUuid(String paramString)
  {
    this.cyingziUuid = paramString;
  }

  public String getCyingziUnique()
  {
    return this.cyingziUnique;
  }

  public void setCyingziUnique(String paramString)
  {
    this.cyingziUnique = paramString;
  }

  public String getbSheetUuid()
  {
    return this.bSheetUuid;
  }

  public void setbSheetUuid(String paramString)
  {
    this.bSheetUuid = paramString;
  }

  public String getbSheetUnique()
  {
    return this.bSheetUnique;
  }

  public void setbSheetUnique(String paramString)
  {
    this.bSheetUnique = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.SheetFentanSelectToken
 * JD-Core Version:    0.6.0
 */