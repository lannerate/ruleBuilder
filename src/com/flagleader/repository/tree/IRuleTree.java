package com.flagleader.repository.tree;

import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.repository.rom.IWhileObject;
import java.util.List;
import java.util.Map;

public abstract interface IRuleTree extends IPackageElement, IRuleClass
{
  public static final int NEEDLOG = 0;
  public static final int NOLOG = 1;
  public static final int NOCHILDLOG = 2;

  public abstract int getPos();

  public abstract int getLogtype();

  public abstract void setLogtype(int paramInt);

  public abstract boolean isActived();

  public abstract void setActived(boolean paramBoolean);

  public abstract boolean noChildLog();

  public abstract boolean needLog();

  public abstract boolean isChangedshint();

  public abstract List getRelateVarNames();

  public abstract long getEndTime();

  public abstract void setEndTime(long paramLong);

  public abstract long getStartTime();

  public abstract void setStartTime(long paramLong);

  public abstract boolean isEmpty();

  public abstract boolean isSheetWhile();

  public abstract boolean hasSheetWhile();

  public abstract List getAllWhileSheets();

  public abstract void setSheetWhile(boolean paramBoolean);

  public abstract String getSheetUuid();

  public abstract void setSheetTable(IWhileObject paramIWhileObject);

  public abstract boolean isActiveSheetWhile();

  public abstract boolean isRunBreak();

  public abstract void setRunBreak(boolean paramBoolean);

  public abstract IWhileObject getWhileSheet();

  public abstract boolean canIncludeSheet();

  public abstract int getSheetOther();

  public abstract void setSheetOther(int paramInt);

  public abstract void setDataShap(int paramInt);

  public abstract int getDataShap();

  public abstract IBusinessObject getBusinessObject(String paramString);

  public abstract int getRestartType();

  public abstract void setRestartType(int paramInt);

  public abstract int getMatchType();

  public abstract void setMatchType(int paramInt);

  public abstract int getVmlFlowType();

  public abstract void setVmlFlowType(int paramInt);

  public abstract String getModifyUser();

  public abstract Map getRelateObjectMap(Map paramMap);

  public abstract Map getAssignObjectMap(Map paramMap, boolean paramBoolean);

  public abstract int getRuleTableCount();

  public abstract boolean replaceVariable(Map paramMap);

  public abstract boolean isSyn();

  public abstract void setSyn(boolean paramBoolean);

  public abstract IRulePackage getCompilePackage();

  public abstract String getVisitRuleName();

  public abstract boolean supportVisitRule();

  public abstract String getWebPosString();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.IRuleTree
 * JD-Core Version:    0.6.0
 */