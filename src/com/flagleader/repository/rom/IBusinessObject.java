package com.flagleader.repository.rom;

import com.flagleader.repository.IBusinessObjectContainer;
import com.flagleader.repository.IElement;
import com.flagleader.repository.d;
import com.flagleader.repository.lang.g;
import java.util.List;

public abstract interface IBusinessObject extends IElement
{
  public abstract boolean isVisible();

  public abstract boolean isEditVisible();

  public abstract void setVisible(boolean paramBoolean);

  public abstract g getJavaType();

  public abstract String getValueType();

  public abstract void changeValueType(String paramString);

  public abstract String getValueName();

  public abstract String getVarValue();

  public abstract String getUniqueName();

  public abstract List getParams();

  public abstract List getAllParams();

  public abstract void disposeAndUpdate();

  public abstract void setObjectEditor(d paramd);

  public abstract IBusinessObjectContainer getContainer();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.IBusinessObject
 * JD-Core Version:    0.6.0
 */