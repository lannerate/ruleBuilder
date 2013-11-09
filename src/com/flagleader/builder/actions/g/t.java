package com.flagleader.builder.actions.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.d.b;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.e.c;
import com.flagleader.repository.g.d;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class t extends bl
{
  public t(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    String[] arrayOfString = { "*.dbs" };
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof IRuleGroup)))
    {
      FileDialog localFileDialog = new FileDialog(this.a.getShell());
      localFileDialog.setFilterExtensions(arrayOfString);
      File localFile1 = new File(this.a.getConfigManager().B());
      if (localFile1.exists())
      {
        localFileDialog.setFilterPath(localFile1.getParent());
        localFileDialog.setFileName(localFile1.getName());
      }
      String str = localFileDialog.open();
      if (str != null)
      {
        File localFile2 = new File(str);
        this.a.getConfigManager().t(localFile2.getAbsolutePath());
        if (this.a.isMainApplication())
          this.a.getConfigManager().b();
        a(localFile2, paramITreeNode);
      }
    }
  }

  protected boolean a(File paramFile, ITreeNode paramITreeNode)
  {
    try
    {
      if (paramFile.getName().endsWith(".dbs"))
      {
        DBModel localDBModel = c.a(paramFile);
        com.flagleader.builder.dialogs.b.r localr = new com.flagleader.builder.dialogs.b.r(this.a.getShell(), localDBModel.getTables());
        if (localr.open() == 0)
        {
          this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
          List localList = localr.b();
          d locald = new d((IRuleGroup)paramITreeNode, localDBModel, localList, localr.c(), localr.a());
          locald.a();
          if (localList.size() > 0)
          {
            paramITreeNode.setModified(true);
            paramITreeNode.updateTree();
            paramITreeNode.updateViewer();
            Iterator localIterator = ((IRuleGroup)paramITreeNode).getRulePackages();
            while (localIterator.hasNext())
              this.a.getRulesManager().l().a((IRulePackage)localIterator.next());
          }
        }
        this.a.getShell().setCursor(null);
        return true;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.showError(localException.getLocalizedMessage());
    }
    finally
    {
      this.a.getShell().setCursor(null);
    }
    this.a.getShell().setCursor(null);
    return false;
  }

  public String a()
  {
    return "InitTreeJspRules";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof IRuleGroup;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.g.t
 * JD-Core Version:    0.6.0
 */