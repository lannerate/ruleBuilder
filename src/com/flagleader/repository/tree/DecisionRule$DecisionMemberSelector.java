package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.l;
import com.flagleader.repository.rlm.AbstractRuleObject;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import com.flagleader.repository.rom.IBusinessObject;
import com.flagleader.util.exception.UnsupportOperationException;

public class DecisionRule$DecisionMemberSelector extends AbstractRuleObject
  implements ISelectorEditen
{
  public DecisionRule$DecisionMemberSelector(DecisionRule paramDecisionRule)
  {
  }

  public DecisionRule$DecisionMemberSelector(DecisionRule paramDecisionRule, DecisionMemberSelector paramDecisionMemberSelector)
  {
    super(paramDecisionMemberSelector);
  }

  public DecisionRule$DecisionMemberSelector(DecisionRule paramDecisionRule, String paramString)
  {
    setDisplayName(paramString);
  }

  public boolean canEdit()
  {
    return false;
  }

  public String getColorType()
  {
    return this.this$0.getColorType();
  }

  public String getHint()
  {
    throw new UnsupportOperationException();
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
    return this.this$0.g;
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
    return new DecisionMemberSelector(this.this$0, this);
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitSelector(this);
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
    return "DecisionMemberSelector";
  }

  public String getNote()
  {
    return getDisplayName();
  }

  public IElement getBusinessObject()
  {
    return this.this$0.getMemberElement();
  }

  public boolean acceptBusinessObject(Object paramObject)
  {
    return this.this$0.acceptBusinessObject(paramObject);
  }

  public boolean pasteBusinessObject(Object paramObject)
  {
    return this.this$0.pasteValueElement(paramObject);
  }

  public String getUuid()
  {
    return this.this$0.getUuid();
  }

  public String getDisplayName()
  {
    IBusinessObject localIBusinessObject = this.this$0.getMemberElement();
    if (localIBusinessObject != null)
      return localIBusinessObject.getShowDisplayName();
    return getLocalString("selectMember.text");
  }

  public IPackageElement getRuleTree()
  {
    return this.this$0;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.DecisionRule.DecisionMemberSelector
 * JD-Core Version:    0.6.0
 */