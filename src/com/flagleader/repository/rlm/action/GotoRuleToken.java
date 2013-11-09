package com.flagleader.repository.rlm.action;

import com.flagleader.repository.IElement;
import com.flagleader.repository.RepositoryVisitor;
import com.flagleader.repository.rlm.AbstractElementToken;
import com.flagleader.repository.rlm.editen.ISelectorEditen;
import com.flagleader.repository.rlm.lang.IStatementToken;
import com.flagleader.repository.tree.Envionment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GotoRuleToken extends AbstractElementToken
  implements ISelectorEditen, IStatementToken
{
  public GotoRuleToken(GotoRuleToken paramGotoRuleToken)
  {
    super(paramGotoRuleToken);
  }

  public GotoRuleToken()
  {
    setDisplayName("&gotoRule");
  }

  protected Iterator e()
  {
    Object localObject = new ArrayList(0);
    if (getEnvionment() != null)
      localObject = getEnvionment().getCommonRules();
    return (Iterator)((List)localObject).iterator();
  }

  public boolean hasLeftPopupMenus()
  {
    return true;
  }

  public IElement deepClone()
  {
    return new GotoRuleToken(this);
  }

  public String getHint()
  {
    return getLocalString("gotoRule.text");
  }

  public boolean hasHint()
  {
    return true;
  }

  public Object acceptVisitor(RepositoryVisitor paramRepositoryVisitor)
  {
    return paramRepositoryVisitor.visitGotoRuleToken(this);
  }

  protected IElement d()
  {
    Iterator localIterator = e();
    while (localIterator.hasNext())
    {
      IElement localIElement = (IElement)localIterator.next();
      if ((getElementUuid().length() > 0) && (localIElement.getUuid().equals(getElementUuid())))
        return localIElement;
      if (localIElement.getDisplayName().equals(getUniqueName()))
        return localIElement;
    }
    return null;
  }

  protected void b(IElement paramIElement)
  {
  }

  public String getName()
  {
    return "GotoRuleToken";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.repository.rlm.action.GotoRuleToken
 * JD-Core Version:    0.6.0
 */