package com.flagleader.repository.rom;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import java.util.List;

public class SubVariable extends AbstractSubVariable
  implements ISubVariable
{
  public SubVariable(SubVariable paramSubVariable)
  {
    super(paramSubVariable);
  }

  public SubVariable(String paramString1, String paramString2, String paramString3, String paramString4, List paramList)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramList);
  }

  public SubVariable(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, List paramList)
  {
    super(paramString1, paramString2, paramString3, paramString4, paramString5, paramList);
  }

  public SubVariable()
  {
  }

  public String getVarValue()
  {
    return getVarPre() + super.getVarValue();
  }

  public String getVarSaveValue()
  {
    return getVarValue();
  }

  public IElement deepClone()
  {
    return new SubVariable(this);
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitSubVariable(this);
  }

  public String getName()
  {
    return "SubVariable";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.SubVariable
 * JD-Core Version:    0.6.0
 */