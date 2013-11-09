package com.flagleader.repository.rlm.editen;

import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IRuleClass;
import java.util.List;

public abstract interface ISelectRulePackageEditen extends IElement
{
  public abstract boolean hasHint();

  public abstract String getHint();

  public abstract String getColorType();

  public abstract IRuleClass getSourceSheet();

  public abstract void setSourceSheet(IRuleClass paramIRuleClass);

  public abstract List getCanSelectSourceFields();

  public abstract List getCanSelectFields();

  public abstract void resetFieldMappings(boolean paramBoolean);

  public abstract List getSelectedFields();

  public abstract List getSelectedWheres();

  public abstract void setExeRuleName(String paramString);

  public abstract String getShowRuleDisplay();

  public abstract void setExeRuleDisplay(String paramString);

  public abstract void setDbRule(IRuleClass paramIRuleClass);

  public abstract String getExeRuleDisplay();

  public abstract String getExeRuleName();

  public abstract boolean hasGetAndSet();

  public abstract void setModified(boolean paramBoolean);

  public abstract void update();

  public abstract String getNote();

  public abstract Envionment getEnvionment();
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.editen.ISelectRulePackageEditen
 * JD-Core Version:    0.6.0
 */