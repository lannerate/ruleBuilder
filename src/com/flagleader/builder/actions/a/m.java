package com.flagleader.builder.actions.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;
import com.flagleader.manager.d.b;
import com.flagleader.manager.d.c;
import com.flagleader.manager.r;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleRepository;

public class m extends u
{
  public m(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  protected String e()
  {
    return "RulePackage";
  }

  public String a()
  {
    return "NewRulePackage";
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (a(paramITreeNode))
    {
      this.a.getProjectTree().a("RulePackage");
    }
    else
    {
      RulePackage localRulePackage = new RulePackage(RulePackage.DISPLAYNAME);
      localRulePackage.setModified(true);
      RuleRepository localRuleRepository;
      if (this.a.getRulesManager().d() != null)
      {
        if ((this.a.getRulesManager().d() instanceof RuleRepository))
        {
          localRuleRepository = (RuleRepository)this.a.getRulesManager().d();
          IRulePackage localIRulePackage = localRuleRepository.exitsPackage(localRulePackage.getExeRulePackageName());
          if (localIRulePackage != null)
            if (this.a.showQuestion(c.b("importPackError.importpackage")))
              localIRulePackage.dispose();
            else
              return;
          localRuleRepository.addRulePackage(localRulePackage);
          localRuleRepository.setModified(true);
          localRuleRepository.updateTree();
        }
      }
      else
      {
        localRuleRepository = new RuleRepository();
        localRuleRepository.addRulePackage(localRulePackage);
        localRuleRepository.setModified(true);
        b.a().a(localRuleRepository);
        this.a.getRulesManager().a(localRuleRepository);
        this.a.getProjectTree().i();
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.a.m
 * JD-Core Version:    0.6.0
 */