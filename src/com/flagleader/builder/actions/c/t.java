package com.flagleader.builder.actions.c;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.e.h.j;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import java.util.LinkedHashMap;
import org.eclipse.jface.wizard.WizardDialog;

public class t extends r
{
  public t(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode == null) || (paramITreeNode.isLocked()) || (!(paramITreeNode instanceof IRuleTree)))
      return;
    IRuleTree localIRuleTree = (IRuleTree)paramITreeNode;
    j localj = new j(localIRuleTree);
    WizardDialog localWizardDialog = new WizardDialog(this.a.getShell(), localj);
    if (localWizardDialog.open() == 0)
    {
      LinkedHashMap localLinkedHashMap = localj.e();
      localIRuleTree.replaceVariable(localLinkedHashMap);
      localIRuleTree.updateViewer();
    }
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof IRuleTree;
  }

  public String a()
  {
    return "VariableReplace";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.c.t
 * JD-Core Version:    0.6.0
 */