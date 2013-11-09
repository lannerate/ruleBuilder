package com.flagleader.repository.rlm.editen;

import com.flagleader.repository.rlm.IRuleObject;

public abstract interface IEditen extends IRuleObject
{
  public abstract void update();

  public abstract String getNote();

  public abstract ILineEditen getParentLine();

  public abstract boolean isChanged();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.editen.IEditen
 * JD-Core Version:    0.6.0
 */