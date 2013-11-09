package com.flagleader.builder.actions.f;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.e.W;
import com.flagleader.manager.r;
import com.flagleader.manager.t;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class c extends b
{
  public c(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode instanceof IPage))
    {
      IPage localIPage = (IPage)paramITreeNode;
      DirectoryDialog localDirectoryDialog = new DirectoryDialog(this.a.getShell());
      if (localIPage.getExportFile().length() > 0)
      {
        localObject = new File(this.a.getConfigManager().a + File.separator + localIPage.getExportFile());
        if (!((File)localObject).exists())
          localObject = new File(localIPage.getExportFile());
        localDirectoryDialog.setFilterPath(((File)localObject).getPath());
      }
      else if (this.a.getConfigManager().e().length() > 0)
      {
        localObject = "";
        localDirectoryDialog.setFilterPath(this.a.getConfigManager().e());
      }
      Object localObject = localDirectoryDialog.open();
      if (localObject != null)
      {
        if ((new File((String)localObject, localIPage.getDisplayName()).exists()) && (!this.a.showQuestion(com.flagleader.manager.d.c.b("savefileexits.question"))))
        {
          this.a.getShell().setCursor(null);
          return;
        }
        if ((this.a.getConfigManager().a.length() > 0) && (((String)localObject).toLowerCase().startsWith(this.a.getConfigManager().a.toLowerCase())))
          localIPage.setExportFile(((String)localObject).substring(this.a.getConfigManager().a.length() + File.separator.length()));
        else
          localIPage.setExportFile((String)localObject);
        W localW = this.a.getRulesManager().l().a(localIPage, (String)localObject, false, true);
        d locald = new d(this, localW, (String)localObject);
        Display.getCurrent().timerExec(100, locald);
      }
    }
  }

  public String a()
  {
    return "ExportPageItem";
  }

  public boolean a(ITreeNode paramITreeNode)
  {
    if (paramITreeNode == null)
      return false;
    return (paramITreeNode instanceof IPage);
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.f.c
 * JD-Core Version:    0.6.0
 */