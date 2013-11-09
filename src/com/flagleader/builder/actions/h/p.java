package com.flagleader.builder.actions.h;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.builder.dialogs.g.t;
import com.flagleader.repository.IElement;
import com.flagleader.repository.tree.IPackageElement;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import java.io.File;
import java.util.List;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class p extends bl
{
  public p(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "RuleReloadItem";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof RulePackage;
  }

  private String a(IElement paramIElement)
  {
    if ((paramIElement instanceof IRulePackage))
      return paramIElement.getDisplayName();
    if ((paramIElement.getParent() instanceof IPackageElement))
      return a((IPackageElement)paramIElement.getParent()) + File.separator + paramIElement.getDisplayName();
    return "";
  }

  private File a(ITreeNode paramITreeNode, String paramString)
  {
    String str = a(paramITreeNode.getParent());
    if (str.length() == 0)
      return new File(paramString, paramITreeNode.getDisplayName() + "." + paramITreeNode.getName());
    return new File(paramString + File.separator + str, paramITreeNode.getDisplayName() + "." + paramITreeNode.getName());
  }

  public void b(ITreeNode paramITreeNode)
  {
    if (!(paramITreeNode instanceof RulePackage))
      return;
    RulePackage localRulePackage = (RulePackage)paramITreeNode;
    DirectoryDialog localDirectoryDialog = new DirectoryDialog(this.a.getShell());
    String str = localDirectoryDialog.open();
    if (str == null)
      return;
    t localt = new t(this.a, str, paramITreeNode);
    if (localt.open() == 0)
    {
      List localList = localt.a();
      this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
      for (int i = 0; i < localList.size(); i++)
      {
        if (!(localList.get(i) instanceof ITreeNode))
          continue;
        ((ITreeNode)localList.get(i)).reloadFromFile(a((ITreeNode)localList.get(i), str));
      }
      this.a.getShell().setCursor(null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.h.p
 * JD-Core Version:    0.6.0
 */