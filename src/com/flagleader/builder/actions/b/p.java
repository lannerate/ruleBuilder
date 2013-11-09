package com.flagleader.builder.actions.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.d.b;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import org.eclipse.swt.widgets.FileDialog;

public class p extends i
{
  public p(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    String[] arrayOfString = { "*.dbs" };
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && (((paramITreeNode instanceof DBModel)) || ((paramITreeNode instanceof Envionment))))
    {
      FileDialog localFileDialog = new FileDialog(this.a.getShell());
      localFileDialog.setFilterExtensions(arrayOfString);
      if (this.a.getConfigManager().B() != null)
      {
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
          b(localFile2, paramITreeNode);
        }
      }
    }
  }

  public String a()
  {
    return "LoadDbsItem";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return ((paramITreeNode instanceof DBModel)) || ((paramITreeNode instanceof Envionment));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.b.p
 * JD-Core Version:    0.6.0
 */