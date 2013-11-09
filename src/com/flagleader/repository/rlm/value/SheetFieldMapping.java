package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rlm.AbstractRuleObject;
import com.flagleader.repository.rlm.editen.b;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IPropertyObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleContainer;
import java.util.List;

public class SheetFieldMapping extends AbstractRuleObject
{
  private String fieldUuid = "";
  private String fieldUnique = "";
  private String mappingUuid = "";
  private String mappingUnique = "";
  private int mappingType = 0;
  public static final int DEFAULTTYPE = 0;
  public static final int WHERETYPE = 1;

  public SheetFieldMapping()
  {
  }

  public SheetFieldMapping(IBusinessObject paramIBusinessObject1, IBusinessObject paramIBusinessObject2)
  {
    this.fieldUuid = paramIBusinessObject2.getUuid();
    this.fieldUnique = paramIBusinessObject2.getUniqueName();
    setMappingField(paramIBusinessObject1);
  }

  public SheetFieldMapping(SheetFieldMapping paramSheetFieldMapping)
  {
    super(paramSheetFieldMapping);
    this.fieldUuid = paramSheetFieldMapping.fieldUuid;
    this.fieldUnique = paramSheetFieldMapping.fieldUnique;
    this.mappingUuid = paramSheetFieldMapping.mappingUuid;
    this.mappingUnique = paramSheetFieldMapping.mappingUnique;
    this.mappingType = paramSheetFieldMapping.mappingType;
  }

  public IBusinessObject getField()
  {
    Object localObject = getEnvionment().getBusinessObject(getFieldUuid(), getFieldUnique());
    if ((localObject == null) && ((getParent() instanceof b)))
    {
      String str = getFieldUnique();
      if (str.indexOf(".") >= 0)
        str = str.substring(str.indexOf(".") + 1);
      List localList = ((b)getParent()).getCanSelectFields();
      for (int i = 0; (localList != null) && (i < localList.size()); i++)
      {
        if ((localList.get(i) instanceof FieldModel))
        {
          if ((!str.equalsIgnoreCase(((FieldModel)localList.get(i)).getFieldName())) && (!str.equalsIgnoreCase(((FieldModel)localList.get(i)).getDisplayName())))
            continue;
          localObject = (FieldModel)localList.get(i);
          break;
        }
        if ((!(localList.get(i) instanceof IPropertyObject)) || ((!str.equalsIgnoreCase(((IPropertyObject)localList.get(i)).getVariableName())) && (!str.equalsIgnoreCase(((IPropertyObject)localList.get(i)).getDisplayName()))))
          continue;
        localObject = (IPropertyObject)localList.get(i);
        break;
      }
    }
    if ((localObject != null) && ((!((IBusinessObject)localObject).getUuid().equals(getFieldUuid())) || (!((IBusinessObject)localObject).getUniqueName().equals(getFieldUnique()))))
    {
      setField((IBusinessObject)localObject);
      if (getRoot() != null)
        getRoot().setNeedSave();
    }
    return (IBusinessObject)localObject;
  }

  public void setField(IBusinessObject paramIBusinessObject)
  {
    this.fieldUuid = paramIBusinessObject.getUuid();
    this.fieldUnique = paramIBusinessObject.getUniqueName();
  }

  public IBusinessObject getMappingField()
  {
    Object localObject = getEnvionment().getBusinessObject(getMappingUuid(), getMappingUnique());
    if ((localObject == null) && ((getParent() instanceof b)))
    {
      String str = getMappingUnique();
      if (str.indexOf(".") >= 0)
        str = str.substring(str.indexOf(".") + 1);
      List localList = ((b)getParent()).getCanSelectSourceFields();
      for (int i = 0; (localList != null) && (i < localList.size()); i++)
      {
        if ((localList.get(i) instanceof FieldModel))
        {
          if ((!str.equalsIgnoreCase(((FieldModel)localList.get(i)).getFieldName())) && (!str.equalsIgnoreCase(((FieldModel)localList.get(i)).getDisplayName())))
            continue;
          localObject = (FieldModel)localList.get(i);
          break;
        }
        if ((!(localList.get(i) instanceof IPropertyObject)) || ((!str.equalsIgnoreCase(((IPropertyObject)localList.get(i)).getVariableName())) && (!str.equalsIgnoreCase(((IPropertyObject)localList.get(i)).getDisplayName()))))
          continue;
        localObject = (IPropertyObject)localList.get(i);
        break;
      }
    }
    if ((localObject != null) && ((!((IBusinessObject)localObject).getUuid().equals(getMappingUuid())) || (!((IBusinessObject)localObject).getUniqueName().equals(getMappingUnique()))))
    {
      setMappingField((IBusinessObject)localObject);
      if (getRoot() != null)
        getRoot().setNeedSave();
    }
    return (IBusinessObject)localObject;
  }

  public void setMappingField(IBusinessObject paramIBusinessObject)
  {
    this.mappingUuid = paramIBusinessObject.getUuid();
    this.mappingUnique = paramIBusinessObject.getUniqueName();
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitSheetFieldMapping(this);
  }

  public IElement deepClone()
  {
    return new SheetFieldMapping(this);
  }

  public String getName()
  {
    return "SheetFieldMapping";
  }

  public IBusinessObject getMemberElement()
  {
    IBusinessObject localIBusinessObject = null;
    if ((getFieldUuid().length() > 0) || (getFieldUnique().length() > 0))
      localIBusinessObject = a(getFieldUuid(), getFieldUnique());
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

  public g getJavaType()
  {
    IBusinessObject localIBusinessObject = a(getFieldUuid(), getFieldUnique());
    if ((localIBusinessObject != null) && ((localIBusinessObject instanceof IBusinessObject)))
      return localIBusinessObject.getJavaType();
    return getTypeManager().a("");
  }

  public String getFieldUuid()
  {
    return this.fieldUuid;
  }

  public void setFieldUuid(String paramString)
  {
    this.fieldUuid = paramString;
  }

  public String toString()
  {
    return "(" + this.fieldUnique + ") as " + getMappingUnique();
  }

  protected Object clone()
  {
    return new SheetFieldMapping(this);
  }

  public String getFieldUnique()
  {
    return this.fieldUnique;
  }

  public void setFieldUnique(String paramString)
  {
    this.fieldUnique = paramString;
  }

  public String getMappingUuid()
  {
    return this.mappingUuid;
  }

  public void setMappingUuid(String paramString)
  {
    this.mappingUuid = paramString;
  }

  public String getMappingUnique()
  {
    return this.mappingUnique;
  }

  public void setMappingUnique(String paramString)
  {
    this.mappingUnique = paramString;
  }

  public int getMappingType()
  {
    return this.mappingType;
  }

  public void setMappingType(int paramInt)
  {
    this.mappingType = paramInt;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.SheetFieldMapping
 * JD-Core Version:    0.6.0
 */