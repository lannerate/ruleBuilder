package com.flagleader.repository.rom;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.lang.g;
import java.util.ArrayList;
import java.util.List;

public class ConstantEnum extends AbstractBOEditen
  implements IConstantObject
{
  private String value = "";

  public ConstantEnum(ConstantEnum paramConstantEnum)
  {
    super(paramConstantEnum);
    this.value = paramConstantEnum.value;
  }

  public ConstantEnum()
  {
  }

  public ConstantEnum(String paramString)
  {
    this.value = paramString;
    setDisplayName(this.value);
    changeValueType("string");
  }

  public ConstantEnum(String paramString1, String paramString2, String paramString3)
  {
    this.value = paramString1;
    setDisplayName(paramString2);
    changeValueType("string");
    setGroupName(paramString3);
  }

  public ConstantEnum(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.value = paramString1;
    setDisplayName(paramString2);
    changeValueType("string");
    setVisible(paramBoolean);
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitConstantEnum(this);
  }

  public IElement deepClone()
  {
    return new ConstantEnum(this);
  }

  public String getValue()
  {
    return this.value;
  }

  public void setValue(String paramString)
  {
    this.value = paramString;
  }

  public String getVarValue()
  {
    if (getJavaType().m())
      return "\"" + getValue() + "\"";
    if ((getJavaType().v()) || (getJavaType().w()) || (getJavaType().x()))
      return "DateUtil.formatDate(\"" + getValue() + "\")";
    if (getJavaType().w())
      return "formatTime(\"" + getValue() + "\")";
    if (getJavaType().x())
      return "DateUtil.formatDatetime(\"" + getValue() + "\")";
    if (getJavaType().c())
      return getValue() + "f";
    if (getJavaType().h())
      return getValue() + "L";
    return getValue();
  }

  public String getUniqueName()
  {
    return super.getUniqueName() + "_" + getShowGroupName();
  }

  public boolean isTypeEditable()
  {
    return true;
  }

  public boolean isValueEditable()
  {
    return true;
  }

  public String getValueName()
  {
    return getValue();
  }

  public void setValueName(String paramString)
  {
    setValue(paramString);
  }

  public String getName()
  {
    return "ConstantEnum";
  }

  public List getParams()
  {
    return new ArrayList(0);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.ConstantEnum
 * JD-Core Version:    0.6.0
 */