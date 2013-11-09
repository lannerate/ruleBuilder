package com.flagleader.builder.actions.h;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.aq;
import com.flagleader.repository.tree.IRuleRepository;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import java.util.ArrayList;
import java.util.Iterator;

public class r extends o
{
  public r(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof RulePackage)))
    {
      RulePackage localRulePackage = (RulePackage)paramITreeNode;
      IRuleRepository localIRuleRepository = this.a.getRulesManager().d();
      if (localIRuleRepository != null)
      {
        Iterator localIterator = localIRuleRepository.getAcceptElements(new s(this, localRulePackage));
        ArrayList localArrayList = new ArrayList();
        while (localIterator.hasNext())
          localArrayList.add(localIterator.next());
        if (localArrayList.size() > 0)
          this.a.getMessageWindow().a(localArrayList);
      }
    }
  }

  public String a()
  {
    return "SearchExeRulePackage";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.h.r
 * JD-Core Version:    0.6.0
 */