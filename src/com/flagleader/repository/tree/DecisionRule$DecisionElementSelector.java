package com.flagleader.repository.tree;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rlm.AbstractRuleContainer;
import com.flagleader.repository.rlm.editen.ILineEditen;
import com.flagleader.repository.rlm.lang.ILangToken;

public class DecisionRule$DecisionElementSelector extends AbstractRuleContainer
  implements ILineEditen, ILangToken, IRuleContainer
{
  public DecisionRule$DecisionElementSelector(DecisionRule paramDecisionRule)
  {
    addChildElement(new DecisionRule.DecisionMemberSelector(paramDecisionRule));
  }

  public String getName()
  {
    return "DecisionElementSelector";
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitContainer(this);
  }

  public IElement deepClone()
  {
    return new DecisionElementSelector(this.this$0);
  }

  public boolean canPasteElement(IElement paramIElement)
  {
    return this.this$0.canPasteValueElement(paramIElement);
  }

  public boolean canCut()
  {
    return false;
  }

  public boolean canCopy()
  {
    return this.this$0.getMemberElement() != null;
  }

  public IElement copyElement()
  {
    return this.this$0.getMemberElement();
  }

  public boolean pasteElement(IElement paramIElement)
  {
    return this.this$0.pasteValueElement(paramIElement);
  }

  public IElement cutElement()
  {
    return null;
  }

  public boolean isEmpty()
  {
    return false;
  }

  public boolean paste(IElement paramIElement)
  {
    return this.this$0.pasteValueElement(paramIElement);
  }

  public IPackageElement getRuleTree()
  {
    return this.this$0;
  }

  public IElement getParent()
  {
    return this.this$0;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.tree.DecisionRule.DecisionElementSelector
 * JD-Core Version:    0.6.0
 */