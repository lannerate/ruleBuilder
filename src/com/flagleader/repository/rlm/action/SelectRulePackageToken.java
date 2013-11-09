package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rlm.editen.ISelectRulePackageEditen;
import com.flagleader.repository.tree.IRuleContainer;

public class SelectRulePackageToken extends AbstractSelectRuleToken
  implements ISelectRulePackageEditen
{
  public SelectRulePackageToken()
  {
  }

  public SelectRulePackageToken(SelectRulePackageToken paramSelectRulePackageToken)
  {
    super(paramSelectRulePackageToken);
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitSelectRulePackageToken(this);
  }

  public IElement deepClone()
  {
    return new SelectRulePackageToken(this);
  }

  public String getName()
  {
    return "SelectRulePackageToken";
  }

  public void setModified(boolean paramBoolean)
  {
    if (getRoot() != null)
      getRoot().setModified(paramBoolean);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.SelectRulePackageToken
 * JD-Core Version:    0.6.0
 */