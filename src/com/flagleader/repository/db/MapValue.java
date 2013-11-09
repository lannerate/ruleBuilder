package com.flagleader.repository.db;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d.q;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.AbstractBOEditen;
import com.flagleader.repository.rom.IBusinessObjectEditen;
import com.flagleader.repository.rom.IPropertyObject;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.util.StringUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MapValue extends AbstractBOEditen
  implements IPropertyObject, Serializable
{
  private String value = "";
  private String key = "";
  private boolean loged;
  public static final String[] DATATYPES = { "string", "int", "double", "boolean", "long", "short", "float", "decimal", "date", "time", "datetime" };

  public MapValue()
  {
  }

  public MapValue(String paramString1, String paramString2)
  {
    this.key = paramString1;
    this.value = paramString2;
  }

  public MapValue(MapValue paramMapValue)
  {
    this.value = paramMapValue.value;
    this.key = paramMapValue.key;
  }

  public String getValue()
  {
    return this.value;
  }

  public String getParsedValue()
  {
    return StringUtil.replace("\"", "\\\"", this.value);
  }

  public String getParsedKey()
  {
    return StringUtil.replace("\"", "\\\"", this.key);
  }

  public void setValue(String paramString)
  {
    this.value = paramString;
  }

  protected Object clone()
  {
    return new MapValue(this);
  }

  public String getKey()
  {
    return this.key;
  }

  public void setKey(String paramString)
  {
    this.key = paramString;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitMapValue(this);
  }

  public IElement deepClone()
  {
    return new MapValue(this);
  }

  public String getName()
  {
    return "MapValue";
  }

  public String toString()
  {
    return this.key + " " + getDisplayName();
  }

  public String getUniqueName()
  {
    IElement localIElement = getParent();
    if ((localIElement != null) && ((localIElement instanceof SheetMap)))
      return ((SheetMap)localIElement).getUniqueName() + ".." + getDisplayName();
    return "";
  }

  public String getShowDisplayName()
  {
    if (getParent() != null)
      return getDisplayName() + "(" + getParent().getDisplayName() + ")";
    return getDisplayName();
  }

  public String getDisplayName()
  {
    if (super.getDisplayName().length() == 0)
      return getKey();
    return super.getDisplayName();
  }

  public String getVarName()
  {
    return this.key.toLowerCase();
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

  public String getValueName()
  {
    return this.key;
  }

  public void setValueName(String paramString)
  {
    this.key = paramString;
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
    if ((getParent() != null) && ((getParent() instanceof SheetMap)))
    {
      List localList = ((SheetMap)getParent()).getFields();
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

  public SheetMap getSheetTable()
  {
    if ((getParent() != null) && ((getParent() instanceof SheetMap)))
      return (SheetMap)getParent();
    throw new q();
  }

  public String getGetMethodName()
  {
    return getSheetTable().getVarValue() + ".get" + getJavaType().N() + "(\"" + getKey() + "\")";
  }

  public String getVarSaveValue()
  {
    return getSheetTable().getVarValue() + ".getSaveObject(\"" + getKey() + "\")";
  }

  public String getSetMethodPreName()
  {
    return getSheetTable().getVarValue() + ".set" + getJavaType().N() + "(\"" + getKey() + "\",";
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
    return this.key;
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

  public String getValueType()
  {
    String str = super.getValueType();
    if (str.length() == 0)
      return "string";
    return str;
  }

  public void changeDisplayName(String paramString1, String paramString2)
  {
    super.changeDisplayName(paramString1, paramString2);
    getSheetTable().getEnvionment().registBusinessObject(this);
  }

  public boolean isLoged()
  {
    return this.loged;
  }

  public void setLoged(boolean paramBoolean)
  {
    this.loged = paramBoolean;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.db.MapValue
 * JD-Core Version:    0.6.0
 */