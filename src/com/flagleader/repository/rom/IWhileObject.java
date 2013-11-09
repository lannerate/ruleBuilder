package com.flagleader.repository.rom;

import java.util.Iterator;
import java.util.List;

public abstract interface IWhileObject extends IBusinessObject
{
  public abstract boolean mustWhile();

  public abstract List getFields();

  public abstract Iterator getFieldIterator();

  public abstract IBusinessObjectEditen getNoCaseEditen(String paramString1, String paramString2);

  public abstract boolean exitsFields(Object paramObject);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.IWhileObject
 * JD-Core Version:    0.6.0
 */