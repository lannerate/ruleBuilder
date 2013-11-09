package com.flagleader.builder.actions.j;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.g.m;
import com.flagleader.manager.a.a.g;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.util.NumberUtil;
import com.flagleader.util.StringUtil;
import java.util.List;

public class e extends x
{
  public e(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (!e())
      return;
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof RulePackage)))
    {
      RulePackage localRulePackage = (RulePackage)paramITreeNode;
      try
      {
        m localm = new m(this.a, localRulePackage.getExeRulePackageName(), localRulePackage.getRulesid());
        if (localm.open() == 0)
        {
          List localList = localm.c();
          if (localList.size() > 0)
            try
            {
              g localg = this.a.getRulesManager().e();
              if (localg.a(NumberUtil.getInt(StringUtil.stringValue(((List)localList.get(0)).get(3))), ((List)localList.get(0)).get(1).toString(), ((List)localList.get(0)).get(0).toString()))
              {
                String str = localg.e();
                localRulePackage.comparePack(str);
              }
              else
              {
                this.a.showError(localg.i());
              }
            }
            catch (Exception localException2)
            {
              localException2.printStackTrace();
              this.a.showError(c.a("error.CompareDB", new String[] { localException2.getMessage() }));
            }
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        this.a.showError(c.a("error.CompareDB", new String[] { localException1.getMessage() }));
      }
    }
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof RulePackage;
  }

  public String a()
  {
    return "CompareDBRulePackage";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.j.e
 * JD-Core Version:    0.6.0
 */