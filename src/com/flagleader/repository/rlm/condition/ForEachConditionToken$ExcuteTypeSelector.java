package com.flagleader.repository.rlm.condition;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.l;
import com.flagleader.repository.rlm.AbstractRuleObject;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import com.flagleader.util.exception.UnsupportOperationException;

public class ForEachConditionToken$ExcuteTypeSelector extends AbstractRuleObject
  implements ISelectorEditen
{
  public ForEachConditionToken$ExcuteTypeSelector(ForEachConditionToken paramForEachConditionToken)
  {
  }

  public ForEachConditionToken$ExcuteTypeSelector(ForEachConditionToken paramForEachConditionToken, ExcuteTypeSelector paramExcuteTypeSelector)
  {
    super(paramExcuteTypeSelector);
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
    return getLocalString("ForEachConditionToken.note");
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
    if (ForEachConditionToken.access$0(this.this$0) == 0)
      return getLocalString("foreachadd1.edit");
    if (ForEachConditionToken.access$0(this.this$0) == 1)
      return getLocalString("foreachminus1.edit");
    if (ForEachConditionToken.access$0(this.this$0) == 2)
      return getLocalString("foreacharray1.edit");
    if (ForEachConditionToken.access$0(this.this$0) == 3)
      return getLocalString("foreachlist1.edit");
    if (ForEachConditionToken.access$0(this.this$0) == 3)
      return getLocalString("foreachmap1.edit");
    return getLocalString("selectAction.edit");
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
 * Qualified Name:     com.flagleader.repository.rlm.condition.ForEachConditionToken.ExcuteTypeSelector
 * JD-Core Version:    0.6.0
 */