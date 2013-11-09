package com.flagleader.repository.xml;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d.q;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.AbstractBOEditen;
import com.flagleader.repository.rom.IPropertyObject;
import com.flagleader.repository.tree.Envionment;
import java.util.ArrayList;
import java.util.List;

public class TreeAttribute extends AbstractBOEditen
  implements IPropertyObject
{
  public static final String NAME = "TreeAttribute";
  private String key = "";
  private boolean loged;
  private int locate = 0;
  public static String[] DATETYPES = { "string", "int", "double", "boolean", "long", "short", "float", "date", "time", "datetime", "string[]" };

  public TreeAttribute()
  {
  }

  public TreeAttribute(String paramString1, String paramString2, String paramString3)
  {
    setDisplayName(paramString3);
    this.key = paramString1;
    setValueType(paramString2);
  }

  public TreeAttribute(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    setDisplayName(paramString3);
    this.key = paramString1;
    setValueType(paramString2);
    this.locate = paramInt;
  }

  public TreeAttribute(TreeAttribute paramTreeAttribute)
  {
    super(paramTreeAttribute);
    this.key = paramTreeAttribute.key;
    this.locate = paramTreeAttribute.locate;
  }

  public String getName()
  {
    return "TreeAttribute";
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitTreeAttribute(this);
  }

  public void dispose()
  {
    super.dispose();
  }

  public IElement deepClone()
  {
    return new TreeAttribute(this);
  }

  public String getKey()
  {
    return this.key;
  }

  public void setKey(String paramString)
  {
    this.key = paramString;
  }

  public void change(String paramString1, String paramString2, String paramString3)
  {
    setKey(paramString1);
    setValueType(paramString2);
    setDisplayName(paramString3);
  }

  public TreeValueNode getSheetTable()
  {
    if ((getParent() != null) && ((getParent() instanceof TreeValueNode)))
      return (TreeValueNode)getParent();
    throw new q();
  }

  public String getUniqueName()
  {
    IElement localIElement = getParent();
    if ((localIElement != null) && ((localIElement instanceof TreeValueNode)))
      return ((TreeValueNode)localIElement).getUniqueName() + " " + getDisplayName();
    return "";
  }

  public String getShowDisplayName()
  {
    if ((getParent() != null) && ((getParent() instanceof TreeValueNode)))
    {
      TreeValueNode localTreeValueNode1 = (TreeValueNode)getParent();
      TreeValueNode localTreeValueNode2 = localTreeValueNode1.getRootElement();
      if (localTreeValueNode2.equals(localTreeValueNode1))
        return getDisplayName() + "(" + localTreeValueNode1.getDisplayName() + ")";
      return getDisplayName() + "(" + localTreeValueNode2.getDisplayName() + "." + localTreeValueNode1.getDisplayName() + ")";
    }
    return getDisplayName();
  }

  public String getShowGroupName()
  {
    if ((this.groupName == null) || (this.groupName.equals("p")))
      return "";
    return super.getShowGroupName();
  }

  public String getGetMethodName()
  {
    return getSheetTable().getVarValue() + ".get" + getJavaType().N() + "(" + getSheetTable().getSubPos(this) + ")";
  }

  public String getVarSaveValue()
  {
    return getSheetTable().getVarSaveValue() + ".getSaveObject(" + getSheetTable().getSubPos(this) + ")";
  }

  public String getSetMethodPreName()
  {
    return getSheetTable().getVarValue() + ".set" + getJavaType().N() + "(" + getSheetTable().getSubPos(this) + ",";
  }

  public String getSetMethodSufName()
  {
    return ")";
  }

  public void setValueName(String paramString)
  {
    setKey(paramString);
  }

  public boolean canSetLoged()
  {
    return true;
  }

  public String getVariableName()
  {
    return getValueName();
  }

  public boolean isLoged()
  {
    return this.loged;
  }

  public void setLoged(boolean paramBoolean)
  {
    this.loged = paramBoolean;
  }

  public List getParams()
  {
    return new ArrayList(0);
  }

  public String getValueName()
  {
    return getKey();
  }

  public String getVarValue()
  {
    return getGetMethodName();
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

  public int getLocate()
  {
    return this.locate;
  }

  public void setLocate(int paramInt)
  {
    this.locate = paramInt;
  }

  public void changeDisplayName(String paramString1, String paramString2)
  {
    super.changeDisplayName(paramString1, paramString2);
    getSheetTable().getEnvionment().registBusinessObject(this);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.xml.TreeAttribute
 * JD-Core Version:    0.6.0
 */