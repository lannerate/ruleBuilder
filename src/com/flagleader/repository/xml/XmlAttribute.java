package com.flagleader.repository.xml;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d.q;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.AbstractBOEditen;
import com.flagleader.repository.rom.IPropertyObject;
import java.util.ArrayList;
import java.util.List;

public class XmlAttribute extends AbstractBOEditen
  implements IPropertyObject
{
  public static final String NAME = "XmlAttribute";
  private String key = "";
  private boolean loged;
  public static String[] DATETYPES = { "string", "int", "double", "boolean", "long", "short", "float", "date", "time", "datetime" };

  public XmlAttribute()
  {
  }

  public XmlAttribute(String paramString1, String paramString2, String paramString3)
  {
    setDisplayName(paramString3);
    this.key = paramString1;
    setValueType(paramString2);
  }

  public XmlAttribute(XmlAttribute paramXmlAttribute)
  {
    super(paramXmlAttribute);
    this.key = paramXmlAttribute.key;
  }

  public String getName()
  {
    return "XmlAttribute";
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitXmlAttribute(this);
  }

  public void dispose()
  {
    if ((getParent() != null) && ((getParent() instanceof XmlNode)))
    {
      if (((XmlNode)getParent()).getGetFunction(this) != null)
        ((XmlNode)getParent()).getGetFunction(this).dispose();
      if (((XmlNode)getParent()).getSetFunction(this) != null)
        ((XmlNode)getParent()).getSetFunction(this).dispose();
    }
    super.dispose();
  }

  public IElement deepClone()
  {
    return new XmlAttribute(this);
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
    if ((getParent() != null) && ((getParent() instanceof XmlNode)))
    {
      if (((XmlNode)getParent()).getGetFunction(this) != null)
        ((XmlNode)getParent()).getGetFunction(this).dispose();
      if (((XmlNode)getParent()).getSetFunction(this) != null)
        ((XmlNode)getParent()).getSetFunction(this).dispose();
    }
    setKey(paramString1);
    setValueType(paramString2);
    setDisplayName(paramString3);
    if ((getParent() != null) && ((getParent() instanceof XmlNode)))
      ((XmlNode)getParent()).addFunction(this.key, getValueType(), getDisplayName());
  }

  public XmlNode getSheetTable()
  {
    if ((getParent() != null) && ((getParent() instanceof XmlNode)))
      return (XmlNode)getParent();
    throw new q();
  }

  public String getUniqueName()
  {
    if ((getParent() != null) && ((getParent() instanceof XmlNode)))
      return ((XmlNode)getParent()).getUniqueName() + ":" + getKey();
    return "";
  }

  public String getShowDisplayName()
  {
    if (getParent() != null)
      return getDisplayName() + "(" + getParent().getDisplayName() + ")";
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
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.xml.XmlAttribute
 * JD-Core Version:    0.6.0
 */