package com.flagleader.builder.actions.h;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.a;
import com.flagleader.manager.a.e;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class f extends o
{
  public f(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "CreateHtmlItem";
  }

  public void b(ITreeNode paramITreeNode)
  {
    String[] arrayOfString = { "*.html" };
    if (paramITreeNode == null)
      return;
    if ((paramITreeNode instanceof RulePackage))
    {
      FileDialog localFileDialog = new FileDialog(this.a.getShell(), 8192);
      localFileDialog.setFilterExtensions(arrayOfString);
      String str = localFileDialog.open();
      if (str != null)
      {
        this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
        b().d().a((IRulePackage)paramITreeNode, str);
        this.a.getShell().setCursor(null);
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.h.f
 * JD-Core Version:    0.6.0
 */