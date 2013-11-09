package com.flagleader.builder.actions.i;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.a.bs;
import com.flagleader.builder.a.bu;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IOpenNode;
import com.flagleader.repository.tree.IRuleClass;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.TestCase;
import com.flagleader.repository.tree.TestCaseLib;
import java.util.Iterator;

public class s extends bl
{
  public s(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode instanceof TestCaseLib))
    {
      this.a.getRulesManager().l().a((TestCaseLib)paramITreeNode);
    }
    else if ((paramITreeNode instanceof TestCase))
    {
      this.a.getRulesManager().l().a((TestCase)paramITreeNode);
    }
    else if ((this.a.getRuleEditor().e() instanceof bs))
    {
      ((bs)this.a.getRuleEditor().e()).a_();
    }
    else if (((paramITreeNode instanceof RulePackage)) || ((paramITreeNode instanceof IOpenNode)))
    {
      Iterator localIterator = paramITreeNode.getAcceptElements(new t(this));
      while (localIterator.hasNext())
      {
        Object localObject = localIterator.next();
        if ((localObject instanceof TestCase))
        {
          this.a.getRulesManager().l().a((TestCase)localObject);
        }
        else
        {
          if (!(localObject instanceof TestCaseLib))
            continue;
          ((TestCaseLib)localObject).getVarnames();
          this.a.getRulesManager().l().a((TestCaseLib)localObject);
        }
      }
    }
  }

  public String a()
  {
    return "TestItem";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return ((paramITreeNode instanceof TestCaseLib)) || ((paramITreeNode instanceof TestCase)) || ((paramITreeNode instanceof IRuleClass)) || ((paramITreeNode instanceof RulePackage)) || ((paramITreeNode instanceof IRuleGroup));
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    if (((paramITreeNode instanceof RulePackage)) || ((paramITreeNode instanceof IRuleGroup)))
      return true;
    return super.a(paramITreeNode);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.i.s
 * JD-Core Version:    0.6.0
 */