package com.flagleader.builder.actions.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.builder.dialogs.e.A;
import com.flagleader.repository.e.d;
import com.flagleader.repository.n;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RuleGroup;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleProject;
import java.io.File;
import java.util.List;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class o extends bl
{
  public o(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    Object localObject;
    List localList1;
    A localA;
    List localList2;
    int i;
    if ((paramITreeNode != null) && ((paramITreeNode instanceof RuleProject)))
    {
      localObject = (RuleProject)paramITreeNode;
      this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
      localList1 = ((RuleProject)localObject).getHistoryPack();
      this.a.getShell().setCursor(null);
      localA = new A(this.a.getShell(), localList1);
      if (localA.open() == 0)
      {
        localList2 = localA.b();
        for (i = 0; i < localList2.size(); i++)
          try
          {
            RulePackage localRulePackage1 = (RulePackage)new d().load(new File(((List)localList2.get(i)).get(2).toString()));
            ((RuleProject)localObject).addChildElement(localRulePackage1);
          }
          catch (Exception localException1)
          {
            n.a().b(((List)localList2.get(i)).get(2).toString() + " is error!", localException1);
          }
        ((RuleProject)localObject).setModified(true);
        ((RuleProject)localObject).updateTree();
      }
    }
    if ((paramITreeNode != null) && ((paramITreeNode instanceof RuleGroup)))
    {
      localObject = (RuleGroup)paramITreeNode;
      this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
      localList1 = ((RuleProject)((RuleGroup)localObject).getProject()).getHistoryPack();
      this.a.getShell().setCursor(null);
      localA = new A(this.a.getShell(), localList1);
      if (localA.open() == 0)
      {
        localList2 = localA.b();
        for (i = 0; i < localList2.size(); i++)
          try
          {
            RulePackage localRulePackage2 = (RulePackage)new d().load(new File(((List)localList2.get(i)).get(2).toString()));
            ((RuleGroup)localObject).addChildElement(localRulePackage2);
          }
          catch (Exception localException2)
          {
            n.a().b(((List)localList2.get(i)).get(2).toString() + " is error!", localException2);
          }
        ((RuleGroup)localObject).setModified(true);
        ((RuleGroup)localObject).updateTree();
      }
    }
  }

  public String a()
  {
    return "ImportRulePackageHistory";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.g.o
 * JD-Core Version:    0.6.0
 */