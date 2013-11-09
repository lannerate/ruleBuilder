package com.flagleader.repository.rom;

import com.flagleader.a.B;
import com.flagleader.a.c.n;
import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.util.collection.IIterator;
import java.util.List;

public class FunctionClass extends BusinessObjectClass
{
  public FunctionClass()
  {
  }

  public FunctionClass(FunctionClass paramFunctionClass)
  {
    super(paramFunctionClass);
  }

  public FunctionClass(String paramString)
  {
    super("", paramString);
  }

  protected IIterator f()
  {
    return n.b(getClazz().E(), new c(this));
  }

  protected List d()
  {
    return getContainer().getEnvionment().getClassMembers(this, false);
  }

  public IElement deepClone()
  {
    return new FunctionClass(this);
  }

  public String getVarValue()
  {
    return getClassName();
  }

  public String getName()
  {
    return "FunctionClass";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.FunctionClass
 * JD-Core Version:    0.6.0
 */