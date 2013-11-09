package com.flagleader.builder.actions.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.e.W;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.widgets.FileDialog;

public class A extends bl
{
  public A(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "zipproject";
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode instanceof IRuleGroup))
    {
      IRuleGroup localIRuleGroup = (IRuleGroup)paramITreeNode;
      String[] arrayOfString = { "*.zip", "*.jar" };
      FileDialog localFileDialog = new FileDialog(this.a.getShell(), 8192);
      localFileDialog.setFilterExtensions(arrayOfString);
      localFileDialog.setFileName(paramITreeNode.getDisplayName() + ".jar");
      String str = localFileDialog.open();
      if (str != null)
        W localW = this.a.getRulesManager().l().a(localIRuleGroup, str, true);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.g.A
 * JD-Core Version:    0.6.0
 */