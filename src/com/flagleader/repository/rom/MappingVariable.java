package com.flagleader.repository.rom;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

public class MappingVariable extends CustomVariable
{
  private int inout = 3;
  public static final int IN = 1;
  public static final int OUT = 2;
  public static final int INOUT = 3;
  private boolean webhidden = false;

  public MappingVariable(MappingVariable paramMappingVariable)
  {
    super(paramMappingVariable);
    this.inout = paramMappingVariable.inout;
  }

  public MappingVariable(TempVariable paramTempVariable)
  {
    super(paramTempVariable);
  }

  public MappingVariable(IPropertyObject paramIPropertyObject)
  {
    super(paramIPropertyObject);
  }

  public MappingVariable(FieldModel paramFieldModel)
  {
    super(paramFieldModel);
  }

  public MappingVariable()
  {
  }

  public MappingVariable(String paramString)
  {
    setVariableName(paramString);
    setDisplayName(paramString);
    changeValueType("string");
  }

  public MappingVariable(String paramString1, String paramString2, String paramString3)
  {
    setVariableName(paramString1);
    setDisplayName(paramString2);
    changeValueType(paramString3);
  }

  public MappingVariable(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    setVariableName(paramString1);
    setDisplayName(paramString2);
    changeValueType(paramString3);
    setVisible(paramBoolean);
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitMappingVariable(this);
  }

  public IElement deepClone()
  {
    return new MappingVariable(this);
  }

  public String getName()
  {
    return "MappingVariable";
  }

  public List getParams()
  {
    return new ArrayList(0);
  }

  public int getInout()
  {
    return this.inout;
  }

  public void setInout(int paramInt)
  {
    this.inout = paramInt;
  }

  public String getVarValue()
  {
    if (StringUtil.isJavaIdentifier(getVariableName()))
      return getVariableName();
    if (getParent() != null)
      return "var" + getParent().getElementPos(this);
    return "";
  }

  public boolean isWebhidden()
  {
    return this.webhidden;
  }

  public void setWebhidden(boolean paramBoolean)
  {
    this.webhidden = paramBoolean;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.MappingVariable
 * JD-Core Version:    0.6.0
 */