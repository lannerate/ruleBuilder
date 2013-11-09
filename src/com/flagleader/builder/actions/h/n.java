package com.flagleader.builder.actions.h;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.repository.e.u;
import com.flagleader.repository.tree.IRuleTree;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RuleTemplate;
import java.io.File;
import org.eclipse.swt.widgets.FileDialog;

public class n extends bl
{
  public n(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof IRuleTree;
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (!(paramITreeNode instanceof IRuleTree))
      return;
    String[] arrayOfString = { "*.rmk" };
    FileDialog localFileDialog = new FileDialog(this.a.getShell(), 4096);
    localFileDialog.setFilterExtensions(arrayOfString);
    String str = localFileDialog.open();
    if (str != null)
      try
      {
        RuleTemplate localRuleTemplate = (RuleTemplate)new u().load(new File(str));
        if ((localRuleTemplate != null) && ((paramITreeNode.getParent() instanceof ITreeNode)))
        {
          IRuleTree localIRuleTree = localRuleTemplate.getRule();
          ((ITreeNode)paramITreeNode.getParent()).replacePos(paramITreeNode, localIRuleTree.deepClone());
          ((ITreeNode)paramITreeNode.getParent()).updateTree();
        }
      }
      catch (Exception localException)
      {
        this.a.showError(localException.getLocalizedMessage());
      }
  }

  public String a()
  {
    return "LoadTemplateLocal";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.h.n
 * JD-Core Version:    0.6.0
 */