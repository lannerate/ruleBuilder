package com.flagleader.builder.actions.h;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.e.A;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import java.util.List;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class d extends o
{
  public d(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof RulePackage)))
    {
      RulePackage localRulePackage = (RulePackage)paramITreeNode;
      this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
      List localList1 = localRulePackage.getHistoryPack();
      this.a.getShell().setCursor(null);
      A localA = new A(this.a.getShell(), localList1);
      if (localA.open() == 0)
      {
        List localList2 = localA.b();
        for (int i = 0; i < localList2.size(); i++)
          localRulePackage.comparePack((List)localList2.get(i));
      }
    }
  }

  public String a()
  {
    return "CompareHistory";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.h.d
 * JD-Core Version:    0.6.0
 */