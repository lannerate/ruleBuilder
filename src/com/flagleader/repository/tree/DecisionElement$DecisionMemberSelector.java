package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.l;
import com.flagleader.repository.rlm.AbstractRuleObject;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import com.flagleader.util.exception.UnsupportOperationException;

public class DecisionElement$DecisionMemberSelector extends AbstractRuleObject
  implements ISelectorEditen
{
  public DecisionElement$DecisionMemberSelector(DecisionElement paramDecisionElement)
  {
  }

  public DecisionElement$DecisionMemberSelector(DecisionElement paramDecisionElement, DecisionMemberSelector paramDecisionMemberSelector)
  {
    super(paramDecisionMemberSelector);
  }

  public DecisionElement$DecisionMemberSelector(DecisionElement paramDecisionElement, String paramString)
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
    return this.this$0.a;
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
    return this.this$0.getShowDisplayName();
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
    return this.this$0.pasteBusinessObject(paramObject);
  }

  public String getUuid()
  {
    return this.this$0.getUuid();
  }

  public String getDisplayName()
  {
    return this.this$0.getShowDisplayName();
  }

  public IPackageElement getRuleTree()
  {
    return this.this$0.getRuleTree();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.DecisionElement.DecisionMemberSelector
 * JD-Core Version:    0.6.0
 */