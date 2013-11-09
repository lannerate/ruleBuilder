package com.flagleader.builder.actions.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.builder.dialogs.e.B;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RuleGroup;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleProject;
import java.util.List;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class w extends bl
{
  public w(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    Object localObject;
    List localList1;
    List localList2;
    int i;
    if ((paramITreeNode != null) && ((paramITreeNode instanceof RuleProject)))
    {
      localObject = (RuleProject)paramITreeNode;
      this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
      try
      {
        localList1 = ((RuleProject)localObject).getClosedPackages();
      }
      catch (Exception localException1)
      {
        this.a.getShell().setCursor(null);
        return;
      }
      this.a.getShell().setCursor(null);
      B localB1 = new B(this.a.getShell(), localList1);
      if (localB1.open() == 0)
      {
        localList2 = localB1.a();
        for (i = 0; i < localList2.size(); i++)
          ((RuleProject)localObject).addChildElement((RulePackage)localList2.get(i));
        ((RuleProject)localObject).setModified(true);
        ((RuleProject)localObject).updateTree();
      }
    }
    if ((paramITreeNode != null) && ((paramITreeNode instanceof RuleGroup)))
    {
      localObject = (RuleGroup)paramITreeNode;
      this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
      try
      {
        localList1 = ((RuleProject)((RuleGroup)localObject).getProject()).getClosedPackages();
      }
      catch (Exception localException2)
      {
        this.a.getShell().setCursor(null);
        return;
      }
      this.a.getShell().setCursor(null);
      B localB2 = new B(this.a.getShell(), localList1);
      if (localB2.open() == 0)
      {
        localList2 = localB2.a();
        for (i = 0; i < localList2.size(); i++)
          ((RuleGroup)localObject).addChildElement((RulePackage)localList2.get(i));
        ((RuleGroup)localObject).setModified(true);
        ((RuleGroup)localObject).updateTree();
      }
    }
  }

  public String a()
  {
    return "RestoreRulePackage";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.g.w
 * JD-Core Version:    0.6.0
 */