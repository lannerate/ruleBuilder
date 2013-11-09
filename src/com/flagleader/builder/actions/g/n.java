package com.flagleader.builder.actions.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.manager.d.c;
import com.flagleader.repository.e.d;
import com.flagleader.repository.m;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.repository.tree.RuleProject;
import java.io.File;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class n extends bl
{
  public n(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public String a()
  {
    return "ImportPackage";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof RuleProject;
  }

  public void b(ITreeNode paramITreeNode)
  {
    String[] arrayOfString1 = { "*.rpk" };
    FileDialog localFileDialog = new FileDialog(this.a.getShell(), 4098);
    localFileDialog.setFilterExtensions(arrayOfString1);
    if (localFileDialog.open() == null)
      return;
    if ((paramITreeNode != null) && ((paramITreeNode instanceof RuleProject)))
    {
      RuleProject localRuleProject = (RuleProject)paramITreeNode;
      this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
      String[] arrayOfString2 = localFileDialog.getFileNames();
      for (int i = 0; i < arrayOfString2.length; i++)
        try
        {
          File localFile = new File(localFileDialog.getFilterPath() + File.separator + arrayOfString2[i]);
          RulePackage localRulePackage1 = (RulePackage)new d().load(localFile);
          if (!m.a().a(localRulePackage1.getExeRulePackageName()))
          {
            this.a.showError(c.b("noright.importpackage"));
            return;
          }
          RulePackage localRulePackage2 = localRuleProject.exitsPackage(localRulePackage1.getExeRulePackageName());
          if (localRulePackage2 != null)
            if (this.a.showQuestion(c.b("importPackError.importpackage")))
            {
              localRulePackage2.dispose();
            }
            else
            {
              this.a.getShell().setCursor(null);
              return;
            }
          localRuleProject.addChildElement(localRulePackage1);
          localRulePackage1.setDirPath("");
          localRulePackage1.setFilePathName("");
          if (!localFile.canWrite())
            localRulePackage1.setLocked(true);
          localRulePackage1.selfSave();
          localRuleProject.setNeedSave(true);
          localRuleProject.updateTree();
        }
        catch (Exception localException)
        {
          this.a.showError(c.a("error_package_file", new String[] { localException.getMessage() }));
        }
      this.a.getShell().setCursor(null);
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.g.n
 * JD-Core Version:    0.6.0
 */