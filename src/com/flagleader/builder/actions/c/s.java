package com.flagleader.builder.actions.c;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.IRuleProject;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleProject;
import java.util.Iterator;

public class s extends r
{
  public s(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((this.a.getProjectTree().c() == null) || ((!(this.a.getProjectTree().c() instanceof RulePackage)) && (!(this.a.getProjectTree().c() instanceof RuleProject))))
      return;
    if ((this.a.getProjectTree().c() instanceof RulePackage))
    {
      ((RulePackage)this.a.getProjectTree().c()).setLocked(false);
      ((RulePackage)this.a.getProjectTree().c()).updateTree();
      ((RulePackage)this.a.getProjectTree().c()).disposeAllViewer();
      if (((RulePackage)this.a.getProjectTree().c()).getProject() != null)
        ((RulePackage)this.a.getProjectTree().c()).getProject().setNeedSave(true);
    }
    else if ((this.a.getProjectTree().c() instanceof RuleProject))
    {
      ((RuleProject)this.a.getProjectTree().c()).setLocked(false);
      Iterator localIterator = ((RuleProject)this.a.getProjectTree().c()).getRulePackages();
      while (localIterator.hasNext())
        ((RulePackage)localIterator.next()).disposeAllViewer();
      ((RuleProject)this.a.getProjectTree().c()).updateTree();
    }
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    if (!paramITreeNode.isLocked())
      return false;
    return ((paramITreeNode instanceof IRulePackage)) || ((paramITreeNode instanceof RuleProject));
  }

  protected boolean c()
  {
    return false;
  }

  public String a()
  {
    return "Unlock";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.c.s
 * JD-Core Version:    0.6.0
 */