package com.flagleader.repository.rlm.value;

import com.flagleader.repository.IElement;
import com.flagleader.repository.l;
import com.flagleader.repository.rlm.AbstractSelectObject;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.editen.ISelectorEditen;

public class RuleInfoToken$InfoTypeSelector extends AbstractSelectObject
  implements ISelectorEditen
{
  public RuleInfoToken$InfoTypeSelector(RuleInfoToken paramRuleInfoToken)
  {
  }

  public RuleInfoToken$InfoTypeSelector(RuleInfoToken paramRuleInfoToken, InfoTypeSelector paramInfoTypeSelector)
  {
    super(paramInfoTypeSelector);
  }

  public RuleInfoToken$InfoTypeSelector(RuleInfoToken paramRuleInfoToken, String paramString)
  {
    setDisplayName(paramString);
  }

  public String getColorType()
  {
    return "rulepackage";
  }

  public l[] getLeftPopupMenus()
  {
    return this.this$0.getLeftPopupMenus();
  }

  public ILineEditen getParentLine()
  {
    return this.this$0.getParentLine();
  }

  public boolean hasLeftPopupMenus()
  {
    return true;
  }

  public IElement deepClone()
  {
    return new InfoTypeSelector(this.this$0, this);
  }

  public boolean isLocked()
  {
    return this.this$0.isLocked();
  }

  public String getName()
  {
    return "ExcuteTypeSelector";
  }

  public String getNote()
  {
    return this.this$0.getNote();
  }

  public String getDisplayName()
  {
    return getLocalString(RuleInfoToken.access$0()[this.this$0.getReturnType()].substring(1) + ".edit", RuleInfoToken.access$0()[this.this$0.getReturnType()].substring(1));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.value.RuleInfoToken.InfoTypeSelector
 * JD-Core Version:    0.6.0
 */