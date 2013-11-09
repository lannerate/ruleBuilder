package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.l;
import com.flagleader.repository.rlm.AbstractRuleObject;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import com.flagleader.util.exception.UnsupportOperationException;

public class ExeDecisionToken$ExcuteTypeSelector extends AbstractRuleObject
  implements ISelectorEditen
{
  public ExeDecisionToken$ExcuteTypeSelector(ExeDecisionToken paramExeDecisionToken)
  {
  }

  public ExeDecisionToken$ExcuteTypeSelector(ExeDecisionToken paramExeDecisionToken, ExcuteTypeSelector paramExcuteTypeSelector)
  {
    super(paramExcuteTypeSelector);
  }

  public ExeDecisionToken$ExcuteTypeSelector(ExeDecisionToken paramExeDecisionToken, String paramString)
  {
    setDisplayName(paramString);
  }

  public boolean canEdit()
  {
    return false;
  }

  public String getColorType()
  {
    return "rulepackage";
  }

  public String getHint()
  {
    return getLocalString("ExcuteRuleToken.note");
  }

  public l[] getLeftPopupMenus()
  {
    return this.this$0.getLeftPopupMenus();
  }

  public String getText()
  {
    throw new UnsupportOperationException();
  }

  public boolean hasHint()
  {
    return false;
  }

  public ILineEditen getParentLine()
  {
    return this.this$0.getParentLine();
  }

  public boolean hasLeftPopupMenus()
  {
    return true;
  }

  public void setText(String paramString)
  {
    throw new UnsupportOperationException();
  }

  public IElement deepClone()
  {
    return new ExcuteTypeSelector(this.this$0, this);
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return null;
  }

  public boolean checkValue(String paramString)
  {
    return false;
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
    return getLocalString(ExeDecisionToken.access$0()[this.this$0.getReturnType()].substring(1) + ".edit", ExeDecisionToken.access$0()[this.this$0.getReturnType()].substring(1));
  }

  public IElement getBusinessObject()
  {
    return null;
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    return false;
  }

  public boolean pasteBusinessObject(Object paramObject)
  {
    return false;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.ExeDecisionToken.ExcuteTypeSelector
 * JD-Core Version:    0.6.0
 */