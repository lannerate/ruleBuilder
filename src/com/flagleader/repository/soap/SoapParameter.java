package com.flagleader.repository.soap;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.d.q;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.rom.AbstractBOEditen;
import com.flagleader.repository.rom.IPropertyObject;
import java.util.ArrayList;
import java.util.List;

public class SoapParameter extends AbstractBOEditen
  implements IPropertyObject
{
  public static final String NAME = "SoapParameter";
  private String key = "";
  private int retType = 1;
  public static final int IN = 1;
  public static final int OUT = 2;
  public static final int INOUT = 3;
  public static String[] DATETYPES = { "", "string", "int", "double", "boolean", "long", "short", "float", "date", "time", "datetime" };

  public SoapParameter()
  {
  }

  public SoapParameter(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    setDisplayName(paramString3);
    this.key = paramString1;
    setValueType(paramString2);
    this.retType = paramInt;
  }

  public SoapParameter(SoapParameter paramSoapParameter)
  {
    super(paramSoapParameter);
    this.key = paramSoapParameter.key;
  }

  public String getName()
  {
    return "SoapParameter";
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitSoapParameter(this);
  }

  public void dispose()
  {
    super.dispose();
  }

  public IElement deepClone()
  {
    return new SoapParameter(this);
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

  public SoapService getSheetTable()
  {
    if ((getParent() != null) && ((getParent() instanceof SoapService)))
      return (SoapService)getParent();
    throw new q();
  }

  public String getUniqueName()
  {
    if ((getParent() != null) && ((getParent() instanceof SoapService)))
      return ((SoapService)getParent()).getUniqueName() + "." + getDisplayName();
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
      return getLocalString("xmlprop.text");
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
    return false;
  }

  public String getVariableName()
  {
    return getValueName();
  }

  public boolean isLoged()
  {
    return false;
  }

  public void setLoged(boolean paramBoolean)
  {
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

  public int getRetType()
  {
    return this.retType;
  }

  public void setRetType(int paramInt)
  {
    this.retType = paramInt;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.soap.SoapParameter
 * JD-Core Version:    0.6.0
 */