package com.flagleader.repository.db;

import com.flagleader.database.SQLParameter;
import com.flagleader.database.SQLType;
import com.flagleader.database.TypeMap;
import com.flagleader.repository.AbstractElement;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.tree.AdvancedProperty;
import java.util.ArrayList;
import java.util.List;

public class ParameterModel extends AbstractElement
{
  private String fieldName = "";
  private String fieldType = "";
  private String valueType = "";
  private String classType = "";
  private String len = "";
  private boolean unNull = true;
  private boolean signed = false;
  private int iType = 0;
  private int pos = 1;
  private int modetype = 0;
  private List advanceProperties = new ArrayList();

  public ParameterModel(ParameterModel paramParameterModel)
  {
    super(paramParameterModel);
    this.fieldType = paramParameterModel.fieldType;
    this.valueType = paramParameterModel.valueType;
    this.classType = paramParameterModel.getClassType();
    this.signed = paramParameterModel.signed;
    this.iType = paramParameterModel.iType;
    this.pos = paramParameterModel.pos;
    this.modetype = paramParameterModel.modetype;
  }

  public ParameterModel()
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitParameterModel(this);
  }

  public String toString()
  {
    return this.fieldType;
  }

  public String getName()
  {
    return "ParameterModel";
  }

  public void update(SQLParameter paramSQLParameter)
  {
    setFieldType(paramSQLParameter.getType().getName());
    if (getValueType().length() == 0)
      setValueType(TypeMap.getDefault().getJavaType(paramSQLParameter.getType()));
    setClassType(paramSQLParameter.getClassType());
    setSigned(paramSQLParameter.isSigned());
    setIType(paramSQLParameter.getIType());
    setModetype(paramSQLParameter.getModetype());
    setFieldName(paramSQLParameter.getName());
    setDisplayName(paramSQLParameter.getDisName());
    setLen(paramSQLParameter.getSize());
  }

  public String getFieldType()
  {
    return this.fieldType;
  }

  public String getValueType()
  {
    return this.valueType;
  }

  public g getJavaType()
  {
    return getTypeManager().a(this.valueType);
  }

  public void setFieldType(String paramString)
  {
    this.fieldType = paramString;
  }

  public void setValueType(String paramString)
  {
    this.valueType = paramString;
  }

  public IElement deepClone()
  {
    return new ParameterModel(this);
  }

  public AdvancedProperty[] getAdvanceProperties()
  {
    AdvancedProperty[] arrayOfAdvancedProperty = new AdvancedProperty[this.advanceProperties.size()];
    for (int i = 0; i < this.advanceProperties.size(); i++)
      arrayOfAdvancedProperty[i] = ((AdvancedProperty)this.advanceProperties.get(i));
    return arrayOfAdvancedProperty;
  }

  public void addAdvanceProperty(AdvancedProperty paramAdvancedProperty)
  {
    this.advanceProperties.add(paramAdvancedProperty);
  }

  public List getPropertiesList()
  {
    return this.advanceProperties;
  }

  public List getFunctions()
  {
    ArrayList localArrayList = new ArrayList(getChildrenCount());
    List localList = a();
    for (int i = 0; i < localList.size(); i++)
    {
      if (!(localList.get(i) instanceof IBusinessObjectEditen))
        continue;
      localArrayList.add(localList.get(i));
    }
    return localArrayList;
  }

  public String getClassType()
  {
    return this.classType;
  }

  public boolean isSigned()
  {
    return this.signed;
  }

  public void setClassType(String paramString)
  {
    this.classType = paramString;
  }

  public void setSigned(boolean paramBoolean)
  {
    this.signed = paramBoolean;
  }

  public int getIType()
  {
    return this.iType;
  }

  public void setIType(int paramInt)
  {
    this.iType = paramInt;
  }

  public int getPos()
  {
    return this.pos;
  }

  public void setPos(int paramInt)
  {
    this.pos = paramInt;
  }

  public int getModetype()
  {
    return this.modetype;
  }

  public void setModetype(int paramInt)
  {
    this.modetype = paramInt;
  }

  public boolean isModeIn()
  {
    return (this.modetype == 1) || (this.modetype == 2);
  }

  public boolean isModeOut()
  {
    return (this.modetype == 2) || (this.modetype == 4);
  }

  public String getFieldName()
  {
    return this.fieldName;
  }

  public void setFieldName(String paramString)
  {
    this.fieldName = paramString;
  }

  public String getLen()
  {
    return this.len;
  }

  public void setLen(String paramString)
  {
    this.len = paramString;
  }

  public boolean isUnNull()
  {
    return this.unNull;
  }

  public void setUnNull(boolean paramBoolean)
  {
    this.unNull = paramBoolean;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.ParameterModel
 * JD-Core Version:    0.6.0
 */