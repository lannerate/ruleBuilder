package com.flagleader.repository.rom;

import com.flagleader.repository.IElement;

public class ClassFunction extends AbstractSubFunction
{
  public ClassFunction(AbstractSubFunction paramAbstractSubFunction)
  {
    super(paramAbstractSubFunction);
  }

  public ClassFunction()
  {
  }

  public boolean isTypeEditable()
  {
    return true;
  }

  public IElement deepClone()
  {
    return new ClassFunction(this);
  }

  public String getName()
  {
    return "ClassFunction";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.ClassFunction
 * JD-Core Version:    0.6.0
 */