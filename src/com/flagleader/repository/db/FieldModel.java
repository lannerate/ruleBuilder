package com.flagleader.repository.db;

import com.flagleader.database.SQLColumn;
import com.flagleader.database.SQLType;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d.q;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rom.AbstractBOEditen;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.tree.AdvancedProperty;
import com.flagleader.sql.RuleField;
import java.util.ArrayList;
import java.util.List;

public class FieldModel extends AbstractBOEditen
{
  private String fieldName = "";
  private String fieldType = "";
  private String valueType = "";
  private String classType = "";
  private String len = "";
  private boolean unNull = true;
  private boolean primaryKey = false;
  private boolean friendKey = false;
  private boolean readOnly = false;
  private boolean autoIncrement = false;
  private boolean searchable = false;
  private boolean signed = false;
  private boolean currency = false;
  private boolean caseSensitive = true;
  private int iType = 0;
  private String defaultValue = "";
  private String defaultType = "";
  private String document = "";
  private List advanceProperties = null;

  public FieldModel(FieldModel paramFieldModel)
  {
    super(paramFieldModel);
    this.fieldName = paramFieldModel.fieldName;
    this.fieldType = paramFieldModel.fieldType;
    this.valueType = paramFieldModel.valueType;
    this.len = paramFieldModel.len;
    this.unNull = paramFieldModel.unNull;
    this.primaryKey = paramFieldModel.primaryKey;
    this.friendKey = paramFieldModel.friendKey;
    this.classType = paramFieldModel.getClassType();
    this.readOnly = paramFieldModel.readOnly;
    this.autoIncrement = paramFieldModel.autoIncrement;
    this.searchable = paramFieldModel.searchable;
    this.signed = paramFieldModel.signed;
    this.currency = paramFieldModel.currency;
    this.caseSensitive = paramFieldModel.caseSensitive;
    this.iType = paramFieldModel.iType;
    this.defaultValue = paramFieldModel.defaultValue;
    this.defaultType = paramFieldModel.defaultType;
  }

  public FieldModel()
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitFieldModel(this);
  }

  public String toString()
  {
    return this.fieldName + " " + this.fieldType;
  }

  public String getName()
  {
    return "fieldModel";
  }

  public void update(SQLColumn paramSQLColumn)
  {
    int i = 0;
    if (!paramSQLColumn.getName().equals(getFieldName()))
      i = 1;
    if (!getLen().equals(String.valueOf(paramSQLColumn.getSize())))
      i = 1;
    if (isPrimaryKey() != paramSQLColumn.isPrimaryKey())
      i = 1;
    if (isFriendKey() != paramSQLColumn.isFriendKey())
      i = 1;
    if (isUnNull() == paramSQLColumn.isNullable())
      i = 1;
    if (getIType() != paramSQLColumn.getIType())
      i = 1;
    setFieldName(paramSQLColumn.getName());
    if (getDisplayName().equals(getFieldName()))
      setDisplayName(paramSQLColumn.getDisName());
    setFieldType(paramSQLColumn.getType().getName());
    setValueType(paramSQLColumn.getJavaType());
    setDefaultType(getValueType());
    setClassType(paramSQLColumn.getClassType());
    if (paramSQLColumn.getPrecision() > 0)
      setLen(new Integer(paramSQLColumn.getPrecision()).toString());
    else
      setLen(new Integer(paramSQLColumn.getSize()).toString());
    setPrimaryKey(paramSQLColumn.isPrimaryKey());
    setFriendKey(paramSQLColumn.isFriendKey());
    setUnNull(!paramSQLColumn.isNullable());
    setAutoIncrement(paramSQLColumn.isAutoIncrement());
    setSearchable(paramSQLColumn.isSearchable());
    setCurrency(paramSQLColumn.isCurrency());
    setCaseSensitive(paramSQLColumn.isCaseSensitive());
    setSigned(paramSQLColumn.isSigned());
    setiType(paramSQLColumn.getIType());
  }

  public String getFieldName()
  {
    return this.fieldName;
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

  public String getLen()
  {
    return this.len;
  }

  public boolean isPrimaryKey()
  {
    return this.primaryKey;
  }

  public boolean isUnNull()
  {
    return this.unNull;
  }

  public void setFieldName(String paramString)
  {
    this.fieldName = paramString;
  }

  public void setFieldType(String paramString)
  {
    this.fieldType = paramString;
  }

  public void setValueType(String paramString)
  {
    this.valueType = paramString;
  }

  public void setLen(String paramString)
  {
    this.len = paramString;
  }

  public void setPrimaryKey(boolean paramBoolean)
  {
    this.primaryKey = paramBoolean;
  }

  public void setUnNull(boolean paramBoolean)
  {
    this.unNull = paramBoolean;
  }

  public IElement deepClone()
  {
    return new FieldModel(this);
  }

  public boolean isFriendKey()
  {
    return this.friendKey;
  }

  public void setFriendKey(boolean paramBoolean)
  {
    this.friendKey = paramBoolean;
  }

  public String getDisplayName()
  {
    if (super.getDisplayName().length() == 0)
      return getFieldName();
    return super.getDisplayName();
  }

  public String getVarName()
  {
    return this.fieldName.toLowerCase();
  }

  public String getGSName()
  {
    if (getVarName().length() > 1)
      return getVarName().substring(0, 1).toUpperCase() + getVarName().substring(1);
    if (getVarName().length() == 1)
      return getVarName().substring(0, 1).toUpperCase();
    return "";
  }

  public AdvancedProperty[] getAdvanceProperties()
  {
    AdvancedProperty[] arrayOfAdvancedProperty = new AdvancedProperty[getPropertiesList().size()];
    for (int i = 0; i < getPropertiesList().size(); i++)
      arrayOfAdvancedProperty[i] = ((AdvancedProperty)getPropertiesList().get(i));
    return arrayOfAdvancedProperty;
  }

  public void addAdvanceProperty(AdvancedProperty paramAdvancedProperty)
  {
    getPropertiesList().add(paramAdvancedProperty);
  }

  public List getPropertiesList()
  {
    if (this.advanceProperties == null)
      this.advanceProperties = new ArrayList(5);
    return this.advanceProperties;
  }

  public String getDefaultType()
  {
    if (this.defaultType.length() == 0)
      return getValueType();
    return this.defaultType;
  }

  public void setDefaultType(String paramString)
  {
    this.defaultType = paramString;
  }

  public int getRows()
  {
    int i = Integer.valueOf(this.len).intValue();
    if (i <= 50)
      return 1;
    return 1 + i / 50;
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

  public boolean isAutoIncrement()
  {
    return this.autoIncrement;
  }

  public boolean isCaseSensitive()
  {
    return this.caseSensitive;
  }

  public String getClassType()
  {
    return this.classType;
  }

  public boolean isCurrency()
  {
    return this.currency;
  }

  public String getDefaultValue()
  {
    return this.defaultValue;
  }

  public boolean isReadOnly()
  {
    return this.readOnly;
  }

  public boolean isSearchable()
  {
    return this.searchable;
  }

  public boolean isSigned()
  {
    return this.signed;
  }

  public void setAutoIncrement(boolean paramBoolean)
  {
    this.autoIncrement = paramBoolean;
  }

  public void setCaseSensitive(boolean paramBoolean)
  {
    this.caseSensitive = paramBoolean;
  }

  public void setClassType(String paramString)
  {
    this.classType = paramString;
  }

  public void setCurrency(boolean paramBoolean)
  {
    this.currency = paramBoolean;
  }

  public void setDefaultValue(String paramString)
  {
    if (!"null".equalsIgnoreCase(paramString))
      this.defaultValue = paramString;
  }

  public void setReadOnly(boolean paramBoolean)
  {
    this.readOnly = paramBoolean;
  }

  public void setSearchable(boolean paramBoolean)
  {
    this.searchable = paramBoolean;
  }

  public void setSigned(boolean paramBoolean)
  {
    this.signed = paramBoolean;
  }

  public int getIType()
  {
    return this.iType;
  }

  public void setiType(int paramInt)
  {
    this.iType = paramInt;
  }

  public String getDocument()
  {
    return this.document;
  }

  public void setDocument(String paramString)
  {
    this.document = paramString;
  }

  public void setIType(int paramInt)
  {
    this.iType = paramInt;
  }

  public RuleField getRuleField()
  {
    RuleField localRuleField = new RuleField(this.fieldName, getDisplayName(), this.readOnly, this.searchable, this.primaryKey, this.friendKey);
    localRuleField.setDefaultValue(this.defaultValue);
    localRuleField.setUnNull(this.unNull);
    localRuleField.setIType(this.iType);
    return localRuleField;
  }

  public List getParams()
  {
    return new ArrayList(0);
  }

  public String getValueName()
  {
    return this.fieldName;
  }

  public String getUniqueName()
  {
    if ((getParent() != null) && ((getParent() instanceof AbstractTableModel)))
      return ((AbstractTableModel)getParent()).getUniqueName() + "." + getDisplayName();
    return super.getUniqueName();
  }

  public int getFieldPos()
  {
    if ((getParent() != null) && ((getParent() instanceof ISelectObject)))
    {
      List localList = ((ISelectObject)getParent()).getFields();
      return localList.indexOf(this);
    }
    return 0;
  }

  public ISelectObject getSelectContainer()
  {
    if ((getParent() != null) && ((getParent() instanceof ISelectObject)))
      return (ISelectObject)getParent();
    throw new q();
  }

  public String getGetMethodName()
  {
    return getSelectContainer().getVarValue() + ".get" + getJavaType().N() + "(" + getFieldPos() + ")";
  }

  public String getSetMethodPreName()
  {
    return getSelectContainer().getVarValue() + ".set" + getJavaType().N() + "(" + getFieldPos() + ",";
  }

  public String getSetMethodSufName()
  {
    return ")";
  }

  public boolean canSetLoged()
  {
    return false;
  }

  public String getVariableName()
  {
    return this.fieldName;
  }

  public boolean isLoged()
  {
    return false;
  }

  public void setLoged(boolean paramBoolean)
  {
  }

  public void setValueName(String paramString)
  {
  }

  public String getVarValue()
  {
    return getGetMethodName();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.FieldModel
 * JD-Core Version:    0.6.0
 */