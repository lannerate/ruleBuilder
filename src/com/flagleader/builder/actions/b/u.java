package com.flagleader.builder.actions.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.b.a;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.widgets.Shell;

public class u extends i
{
  public u(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof DBModel)))
    {
      DBModel localDBModel = (DBModel)paramITreeNode;
      a locala = new a(new Shell(), localDBModel);
      if ((locala.open() == 0) && (locala.b().length() > 0))
      {
        localDBModel.createCustomSql(locala.b(), locala.a(), locala.c());
        localDBModel.updateTree();
        localDBModel.updateViewer();
      }
    }
  }

  public String a()
  {
    return "NewSql";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.b.u
 * JD-Core Version:    0.6.0
 */