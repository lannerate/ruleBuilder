package com.flagleader.builder.actions.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.builder.d;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import java.util.List;
import org.eclipse.swt.widgets.DirectoryDialog;

public class a extends g
{
  public a(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((this.a.getProjectTree().c() != null) && (!this.a.getProjectTree().c().isLocked()) && ((this.a.getProjectTree().c() instanceof Envionment)))
    {
      Envionment localEnvionment = (Envionment)this.a.getProjectTree().c();
      DirectoryDialog localDirectoryDialog = new DirectoryDialog(this.a.getShell(), 0);
      if (localDirectoryDialog.open() == null)
        return;
      localEnvionment.getClassDirVector().add(localDirectoryDialog.getFilterPath());
      localEnvionment.setModified(true);
      localEnvionment.updateViewer();
    }
  }

  public String a()
  {
    return "AddClassDir";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.d.a
 * JD-Core Version:    0.6.0
 */