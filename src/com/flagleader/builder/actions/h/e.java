package com.flagleader.builder.actions.h;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.builder.dialogs.e.d;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.ITreeNode;
import java.util.List;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class e extends bl
{
  public e(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof IPackageElement;
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (!(paramITreeNode instanceof IPackageElement))
      return;
    FileDialog localFileDialog = new FileDialog(new Shell(), 4096);
    localFileDialog.setFilterExtensions(new String[] { "*.xls", "*.xlsx" });
    localFileDialog.setFileName(paramITreeNode.getDisplayName() + ".xls");
    String str = localFileDialog.open();
    if (str != null)
    {
      d locald = new d(this.a, paramITreeNode);
      if (locald.open() == 0)
      {
        List localList = locald.a();
        this.a.getRulesManager().l().a((IPackageElement)paramITreeNode, str, localList, true);
      }
    }
  }

  public String a()
  {
    return "CompareRuleExcel";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.h.e
 * JD-Core Version:    0.6.0
 */