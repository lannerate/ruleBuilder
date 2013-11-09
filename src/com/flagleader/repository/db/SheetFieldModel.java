package com.flagleader.repository.db;

import com.flagleader.database.SQLColumn;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d.q;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.AbstractBOEditen;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IPropertyObject;
import com.flagleader.repository.tree.Envionment;
import java.util.ArrayList;
import java.util.List;

public class SheetFieldModel extends AbstractBOEditen
  implements IPropertyObject
{
  private String fieldName = "";
  private boolean loged;
  public static final String[] DATATYPES = { "string", "int", "double", "boolean", "long", "short", "float", "decimal", "date", "time", "datetime" };

  public SheetFieldModel(SheetFieldModel paramSheetFieldModel)
  {
    super(paramSheetFieldModel);
    this.fieldName = paramSheetFieldModel.fieldName;
  }

  public SheetFieldModel(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    setFieldName(paramString1);
    setDisplayName(paramString2);
    setValueType(paramString3);
    setVisible(paramBoolean);
  }

  public SheetFieldModel(FieldModel paramFieldModel)
  {
    setFieldName(paramFieldModel.getValueName());
    setDisplayName(paramFieldModel.getDisplayName());
    setValueType(paramFieldModel.getValueType());
    setVisible(true);
  }

  public SheetFieldModel()
  {
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitSheetFieldModel(this);
  }

  public String toString()
  {
    return this.fieldName + " " + getDisplayName();
  }

  public String getUniqueName()
  {
    IElement localIElement = getParent();
    if ((localIElement != null) && ((localIElement instanceof SheetTable)))
      return ((SheetTable)localIElement).getUniqueName() + "." + getDisplayName();
    return "";
  }

  public String getShowDisplayName()
  {
    if (getParent() != null)
      return getDisplayName() + "(" + getParent().getDisplayName() + ")";
    return getDisplayName();
  }

  public String getName()
  {
    return "SheetFieldModel";
  }

  public String getFieldName()
  {
    return this.fieldName;
  }

  public void setFieldName(String paramString)
  {
    this.fieldName = paramString;
  }

  public IElement deepClone()
  {
    return new SheetFieldModel(this);
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

  public void update(SQLColumn paramSQLColumn)
  {
    int i = 0;
    if (!paramSQLColumn.getName().equals(getFieldName()))
      i = 1;
    setFieldName(paramSQLColumn.getName());
    if (getDisplayName().equals(getFieldName()))
      setDisplayName(paramSQLColumn.getDisName());
    setValueType(paramSQLColumn.getJavaType());
  }

  public String getValueName()
  {
    return this.fieldName;
  }

  public void setValueName(String paramString)
  {
    this.fieldName = paramString;
  }

  public String getVarValue()
  {
    return getGetMethodName();
  }

  public List getParams()
  {
    return new ArrayList(0);
  }

  public int getFieldPos()
  {
    if ((getParent() != null) && ((getParent() instanceof SheetTable)))
    {
      List localList = ((SheetTable)getParent()).getFields();
      return localList.indexOf(this);
    }
    return 0;
  }

  public void setGroupName(String paramString)
  {
    super.setGroupName(paramString);
  }

  public String getShowGroupName()
  {
    if ((this.groupName == null) || (this.groupName.equals("p")))
      return getLocalString("sheetfield.text");
    return super.getShowGroupName();
  }

  public SheetTable getSheetTable()
  {
    if ((getParent() != null) && ((getParent() instanceof SheetTable)))
      return (SheetTable)getParent();
    throw new q();
  }

  public String getGetMethodName()
  {
    return getSheetTable().getVarValue() + ".get" + getJavaType().N() + "(" + getFieldPos() + ")";
  }

  public String getVarSaveValue()
  {
    return getSheetTable().getVarValue() + ".getSaveObject(" + getFieldPos() + ")";
  }

  public String getSetMethodPreName()
  {
    return getSheetTable().getVarValue() + ".set" + getJavaType().N() + "(" + getFieldPos() + ",";
  }

  public String getSetMethodSufName()
  {
    return ")";
  }

  public boolean canSetLoged()
  {
    return true;
  }

  public String getVariableName()
  {
    return this.fieldName;
  }

  public boolean isLoged()
  {
    return this.loged;
  }

  public void setLoged(boolean paramBoolean)
  {
    this.loged = paramBoolean;
  }

  public boolean isGroupEditable()
  {
    return true;
  }

  public boolean isTypeEditable()
  {
    return true;
  }

  public boolean isValueEditable()
  {
    return true;
  }

  public void changeDisplayName(String paramString1, String paramString2)
  {
    super.changeDisplayName(paramString1, paramString2);
    getSheetTable().getEnvionment().registBusinessObject(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.SheetFieldModel
 * JD-Core Version:    0.6.0
 */