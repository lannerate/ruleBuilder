package com.flagleader.repository.tree;

import com.flagleader.repository.AbstractElement;
import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.lang.g;
import com.flagleader.repository.lang.h;
import com.flagleader.repository.rom.MappingVariable;
import com.flagleader.util.DataType;

public class TestObjectInfo extends AbstractElement
{
  private String className = "";
  private String attributeName = "";
  private String type = "";
  private String initialValue = "";
  private String expectValue = "";
  private Object resultValue = null;

  public TestObjectInfo()
  {
  }

  public TestObjectInfo(TestObjectInfo paramTestObjectInfo)
  {
    super(paramTestObjectInfo);
    this.className = paramTestObjectInfo.className;
    this.attributeName = paramTestObjectInfo.attributeName;
    this.type = paramTestObjectInfo.type;
    this.initialValue = paramTestObjectInfo.initialValue;
    this.expectValue = paramTestObjectInfo.expectValue;
  }

  public TestObjectInfo(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.className = paramString1;
    this.attributeName = paramString2;
    this.type = paramString4;
    setDisplayName(paramString3);
  }

  public String getMemberName()
  {
    if ((this.className != null) && (this.className.length() > 0))
      return this.className + "." + this.attributeName;
    return this.attributeName;
  }

  public String getAttributeName()
  {
    return this.attributeName;
  }

  public String getClassName()
  {
    return this.className;
  }

  public String getExpectValue()
  {
    return this.expectValue;
  }

  public String getInitialValue()
  {
    return this.initialValue;
  }

  public String getType()
  {
    return this.type;
  }

  public g getJavaType()
  {
    return getTypeManager().a(this.type);
  }

  public boolean checkValue(String paramString)
  {
    return getJavaType().a(paramString);
  }

  public void setAttributeName(String paramString)
  {
    this.attributeName = paramString;
  }

  public void setClassName(String paramString)
  {
    this.className = paramString;
  }

  public void setExpectValue(String paramString)
  {
    this.expectValue = paramString;
  }

  public void setInitialValue(String paramString)
  {
    this.initialValue = paramString;
  }

  public void setType(String paramString)
  {
    this.type = paramString;
  }

  public TestCase getTestCase()
  {
    if ((getParent() != null) && ((getParent() instanceof TestCase)))
      return (TestCase)getParent();
    return null;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitTestObjectInfo(this);
  }

  public IElement deepClone()
  {
    return new TestObjectInfo(this);
  }

  public String getName()
  {
    return "TestObjectInfo";
  }

  public boolean isOutVariable()
  {
    if ((getParent() != null) && ((getParent() instanceof TestCase)))
    {
      Envionment localEnvionment = ((TestCase)getParent()).getEnvionment();
      if (localEnvionment != null)
      {
        MappingVariable localMappingVariable = localEnvionment.getValueLibrary().getVariable(this.attributeName);
        if ((localMappingVariable != null) && ((localMappingVariable.getInout() & 0x2) > 0))
          return true;
      }
    }
    return false;
  }

  public boolean isChanged()
  {
    if (this.resultValue == null)
      return false;
    return !DataType.equalsValue(this.type, this.expectValue, this.resultValue);
  }

  public boolean isEqualValue(String paramString)
  {
    if (DataType.equalsValue(this.type, this.expectValue, paramString))
      return true;
    return this.expectValue.equals(paramString);
  }

  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(getDisplayName() + ":");
    localStringBuffer.append(getLocalString("initialValue.text") + ":" + this.initialValue);
    localStringBuffer.append(getLocalString("expectValue.text") + ":" + this.expectValue);
    return localStringBuffer.toString();
  }

  public Object getResultValue()
  {
    return this.resultValue;
  }

  public void setResultValue(Object paramObject)
  {
    this.resultValue = paramObject;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.TestObjectInfo
 * JD-Core Version:    0.6.0
 */