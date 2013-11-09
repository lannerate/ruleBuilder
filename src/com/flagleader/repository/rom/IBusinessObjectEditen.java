package com.flagleader.repository.rom;

import com.flagleader.repository.lang.g;
import java.util.Iterator;
import java.util.List;

public abstract interface IBusinessObjectEditen extends IBusinessObject
{
  public abstract String getValueName();

  public abstract String getValueType();

  public abstract void update();

  public abstract g getJavaType();

  public abstract String getVarValue();

  public abstract String getDisplayName();

  public abstract boolean isLocked();

  public abstract boolean isValueEditable();

  public abstract boolean isTypeEditable();

  public abstract Iterator getSubEditens();

  public abstract List getAllSubEditens();

  public abstract boolean hasSubEditen();

  public abstract boolean canCreateSubFunction();

  public abstract List getCanCreateSubFunction();

  public abstract boolean createSubFunction(List paramList);

  public abstract void setValueName(String paramString);

  public abstract void changeValueType(String paramString);

  public abstract boolean canDelete();

  public abstract void setDisplayName(String paramString);

  public abstract void changeDisplayName(String paramString1, String paramString2);

  public abstract String getShowGroupName();

  public abstract void setShowGroupName(String paramString);

  public abstract boolean isGroupEditable();

  public abstract String getStringPos(int paramInt);
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rom.IBusinessObjectEditen
 * JD-Core Version:    0.6.0
 */