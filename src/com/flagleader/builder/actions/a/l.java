package com.flagleader.builder.actions.a;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.builder.dialogs.e.a;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RuleMirror;
import java.util.List;

public class l extends bl
{
  public l(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && ((paramITreeNode instanceof IPackageElement)) && (!paramITreeNode.isLocked()))
    {
      IPackageElement localIPackageElement = (IPackageElement)paramITreeNode;
      a locala = new a(this.a.getShell(), localIPackageElement.getEnvionment().getCommonRules());
      if (locala.open() == 0)
      {
        List localList = locala.a();
        for (int i = 0; i < localList.size(); i++)
        {
          IRuleTree localIRuleTree = (IRuleTree)localList.get(i);
          RuleMirror localRuleMirror = new RuleMirror(localIRuleTree.getDisplayName(), localIRuleTree.getUuid());
          localIPackageElement.addChildElement(localRuleMirror);
        }
        localIPackageElement.setModified(true);
        localIPackageElement.updateTree();
      }
    }
  }

  public String a()
  {
    return "NewRuleMirror";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.a.l
 * JD-Core Version:    0.6.0
 */