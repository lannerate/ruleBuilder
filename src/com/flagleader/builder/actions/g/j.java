package com.flagleader.builder.actions.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.builder.d;
import com.flagleader.manager.d.b;
import com.flagleader.manager.e.W;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import java.util.Iterator;

public class j extends bl
{
  public j(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return ((paramITreeNode instanceof IPage)) || ((paramITreeNode instanceof RulePackage)) || ((paramITreeNode instanceof IRuleGroup));
  }

  protected boolean d()
  {
    return true;
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (paramITreeNode == null)
      return;
    Object localObject1;
    Object localObject2;
    if ((this.a.getProjectTree().c() instanceof IPage))
    {
      localObject1 = (IPage)paramITreeNode;
      localObject2 = this.a.getRulesManager().l().a((IPage)localObject1, b.a().e());
    }
    else
    {
      Object localObject3;
      if ((this.a.getProjectTree().c() instanceof RulePackage))
      {
        localObject1 = paramITreeNode.getAcceptChildren(new k(this));
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (IPage)((Iterator)localObject1).next();
          localObject3 = this.a.getRulesManager().l().a((IPage)localObject2, b.a().e());
        }
      }
      else if ((this.a.getProjectTree().c() instanceof IRuleGroup))
      {
        localObject1 = (IRuleGroup)this.a.getProjectTree().c();
        localObject2 = ((IRuleGroup)localObject1).getAcceptElements(new l(this));
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (IPage)((Iterator)localObject2).next();
          W localW = this.a.getRulesManager().l().a((IPage)localObject3, b.a().e());
        }
      }
    }
  }

  public String a()
  {
    return "FtpPage";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.g.j
 * JD-Core Version:    0.6.0
 */