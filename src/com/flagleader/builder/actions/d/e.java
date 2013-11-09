package com.flagleader.builder.actions.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import java.util.List;
import org.eclipse.swt.widgets.FileDialog;

public class e extends g
{
  public e(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((this.a.getProjectTree().c() != null) && (!this.a.getProjectTree().c().isLocked()) && ((this.a.getProjectTree().c() instanceof Envionment)))
    {
      Envionment localEnvionment = (Envionment)this.a.getProjectTree().c();
      FileDialog localFileDialog = new FileDialog(this.a.getShell(), 4098);
      localFileDialog.setFilterExtensions(new String[] { "*.jar" });
      if (localFileDialog.open() == null)
        return;
      String[] arrayOfString = localFileDialog.getFileNames();
      for (int i = 0; i < arrayOfString.length; i++)
      {
        File localFile = new File(localFileDialog.getFilterPath(), arrayOfString[i]);
        localEnvionment.getClassDirVector().add(localFile.getPath());
      }
      localEnvionment.setModified(true);
      localEnvionment.updateViewer();
    }
  }

  public String a()
  {
    return "AddJar";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.d.e
 * JD-Core Version:    0.6.0
 */