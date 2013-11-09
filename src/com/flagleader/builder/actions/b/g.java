package com.flagleader.builder.actions.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.e.b.a;
import com.flagleader.manager.d.b;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.e.c;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class g extends i
{
  public g(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    String[] arrayOfString = { "*.dbs" };
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof DBModel)))
    {
      FileDialog localFileDialog = new FileDialog(this.a.getShell());
      localFileDialog.setFilterExtensions(arrayOfString);
      File localFile1 = new File(this.a.getConfigManager().B());
      if (localFile1.exists())
      {
        localFileDialog.setFilterPath(localFile1.getParent());
        localFileDialog.setFileName(localFile1.getName());
      }
      String str1 = localFileDialog.open();
      if (str1 != null)
      {
        File localFile2 = new File(str1);
        this.a.getConfigManager().t(localFile2.getAbsolutePath());
        if (this.a.isMainApplication())
          this.a.getConfigManager().b();
        try
        {
          DBModel localDBModel = c.a(localFile2);
          a locala = new a(localDBModel);
          WizardDialog localWizardDialog = new WizardDialog(this.a.getShell(), locala);
          if (localWizardDialog.open() == 0)
          {
            String str2 = locala.d();
            a(paramITreeNode, str2, locala.g(), locala.f());
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
      }
    }
  }

  public String a()
  {
    return "CreateDelete";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.b.g
 * JD-Core Version:    0.6.0
 */