package com.flagleader.builder.actions;

import com.flagleader.repository.tree.IRulePackage;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

class as
  implements Runnable
{
  as(aq paramaq, IRulePackage paramIRulePackage)
  {
  }

  public void run()
  {
    TreeItem localTreeItem1 = this.a.a(this.b);
    if (localTreeItem1 != null)
    {
      aq.a(this.a, localTreeItem1, this.b);
    }
    else if (this.b.hasError())
    {
      TreeItem localTreeItem2 = new TreeItem(aq.k(this.a), 0);
      localTreeItem2.setText(new String[] { this.b.getDisplayName(), this.b.getExeRulePackageName() });
      localTreeItem2.setData(this.b);
      aq.a(this.a, localTreeItem2, this.b);
    }
    if (aq.k(this.a).getItemCount() > 0)
      aq.j(this.a).setSelection(1);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.as
 * JD-Core Version:    0.6.0
 */