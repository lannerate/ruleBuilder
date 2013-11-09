package com.flagleader.repository.rom;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.List;

public class TempVariable extends CustomVariable
{
  public TempVariable(TempVariable paramTempVariable)
  {
    super(paramTempVariable);
  }

  public TempVariable(MappingVariable paramMappingVariable)
  {
    super(paramMappingVariable);
  }

  public TempVariable(IPropertyObject paramIPropertyObject)
  {
    super(paramIPropertyObject);
  }

  public TempVariable()
  {
  }

  public TempVariable(String paramString)
  {
    setVariableName(paramString);
    setDisplayName(paramString);
    changeValueType("string");
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitTempVariable(this);
  }

  public IElement deepClone()
  {
    return new TempVariable(this);
  }

  public String getName()
  {
    return "TempVariable";
  }

  public List getParams()
  {
    return new ArrayList(0);
  }

  public String getVarValue()
  {
    if (StringUtil.isJavaIdentifier(getVariableName()))
      return getVariableName();
    if (getParent() != null)
      return "temp" + getParent().getElementPos(this);
    return "";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.TempVariable
 * JD-Core Version:    0.6.0
 */