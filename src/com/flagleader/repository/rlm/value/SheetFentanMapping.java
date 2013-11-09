package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rlm.AbstractRuleObject;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleContainer;

public class SheetFentanMapping extends AbstractRuleObject
{
  private String fieldUuid = "";
  private String fieldUnique = "";
  private String bfieldUuid = "";
  private String bfieldUnique = "";
  private String cfieldUuid = "";
  private String cfieldUnique = "";
  private int mappingType = 0;
  public static final int DEFAULTTYPE = 0;
  public static final int WHERETYPE = 1;

  public SheetFentanMapping()
  {
  }

  public SheetFentanMapping(IBusinessObject paramIBusinessObject1, IBusinessObject paramIBusinessObject2, IBusinessObject paramIBusinessObject3)
  {
    this.fieldUuid = paramIBusinessObject1.getUuid();
    this.fieldUnique = paramIBusinessObject1.getUniqueName();
    this.bfieldUuid = paramIBusinessObject2.getUuid();
    this.bfieldUnique = paramIBusinessObject2.getUniqueName();
    setMappingField(paramIBusinessObject3);
  }

  public SheetFentanMapping(SheetFentanMapping paramSheetFentanMapping)
  {
    super(paramSheetFentanMapping);
    this.fieldUuid = paramSheetFentanMapping.fieldUuid;
    this.fieldUnique = paramSheetFentanMapping.fieldUnique;
    this.cfieldUuid = paramSheetFentanMapping.cfieldUuid;
    this.cfieldUnique = paramSheetFentanMapping.cfieldUnique;
    this.mappingType = paramSheetFentanMapping.mappingType;
    this.bfieldUnique = paramSheetFentanMapping.bfieldUnique;
    this.bfieldUuid = paramSheetFentanMapping.bfieldUuid;
  }

  public IBusinessObject getField()
  {
    IBusinessObject localIBusinessObject = getEnvionment().getBusinessObject(getFieldUuid(), getFieldUnique());
    if ((localIBusinessObject != null) && ((!localIBusinessObject.getUuid().equals(getFieldUuid())) || (!localIBusinessObject.getUniqueName().equals(getFieldUnique()))))
    {
      setField(localIBusinessObject);
      if (getRoot() != null)
        getRoot().setNeedSave();
    }
    return localIBusinessObject;
  }

  public IBusinessObject getBField()
  {
    IBusinessObject localIBusinessObject = getEnvionment().getBusinessObject(getBfieldUuid(), getBfieldUnique());
    if ((localIBusinessObject != null) && ((!localIBusinessObject.getUuid().equals(getBfieldUuid())) || (!localIBusinessObject.getUniqueName().equals(getBfieldUnique()))))
    {
      this.bfieldUuid = localIBusinessObject.getUuid();
      this.bfieldUnique = localIBusinessObject.getUniqueName();
      if (getRoot() != null)
        getRoot().setNeedSave();
    }
    return localIBusinessObject;
  }

  public void setField(IBusinessObject paramIBusinessObject)
  {
    this.fieldUuid = paramIBusinessObject.getUuid();
    this.fieldUnique = paramIBusinessObject.getUniqueName();
  }

  public void setBField(IBusinessObject paramIBusinessObject)
  {
    this.bfieldUuid = paramIBusinessObject.getUuid();
    this.bfieldUnique = paramIBusinessObject.getUniqueName();
  }

  public IBusinessObject getMappingField()
  {
    IBusinessObject localIBusinessObject = getEnvionment().getBusinessObject(getCfieldUuid(), getCfieldUnique());
    if ((localIBusinessObject != null) && ((!localIBusinessObject.getUuid().equals(getCfieldUuid())) || (!localIBusinessObject.getUniqueName().equals(getCfieldUnique()))))
    {
      setMappingField(localIBusinessObject);
      if (getRoot() != null)
        getRoot().setNeedSave();
    }
    return localIBusinessObject;
  }

  public void setMappingField(IBusinessObject paramIBusinessObject)
  {
    this.cfieldUuid = paramIBusinessObject.getUuid();
    this.cfieldUnique = paramIBusinessObject.getUniqueName();
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitSheetFentanMapping(this);
  }

  public IElement deepClone()
  {
    return new SheetFentanMapping(this);
  }

  public String getName()
  {
    return "SheetFentanMapping";
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
    return "(" + this.fieldUnique + ") as " + getCfieldUnique();
  }

  protected Object clone()
  {
    return new SheetFentanMapping(this);
  }

  public String getFieldUnique()
  {
    return this.fieldUnique;
  }

  public void setFieldUnique(String paramString)
  {
    this.fieldUnique = paramString;
  }

  public String getCfieldUuid()
  {
    return this.cfieldUuid;
  }

  public void setCfieldUuid(String paramString)
  {
    this.cfieldUuid = paramString;
  }

  public String getCfieldUnique()
  {
    return this.cfieldUnique;
  }

  public void setCfieldUnique(String paramString)
  {
    this.cfieldUnique = paramString;
  }

  public int getMappingType()
  {
    return this.mappingType;
  }

  public void setMappingType(int paramInt)
  {
    this.mappingType = paramInt;
  }

  public String getBfieldUuid()
  {
    return this.bfieldUuid;
  }

  public void setBfieldUuid(String paramString)
  {
    this.bfieldUuid = paramString;
  }

  public String getBfieldUnique()
  {
    return this.bfieldUnique;
  }

  public void setBfieldUnique(String paramString)
  {
    this.bfieldUnique = paramString;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.SheetFentanMapping
 * JD-Core Version:    0.6.0
 */