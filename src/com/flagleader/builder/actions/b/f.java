package com.flagleader.builder.actions.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.builder.dialogs.b.m;
import com.flagleader.repository.db.AbstractTableModel;
import com.flagleader.repository.tree.ITreeNode;
import org.eclipse.swt.widgets.Shell;

public class f extends bl
{
  public f(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof AbstractTableModel)))
    {
      AbstractTableModel localAbstractTableModel = (AbstractTableModel)paramITreeNode;
      m localm = new m(new Shell(), null);
      if ((localm.open() == 0) && (localm.c().length() > 0) && (localm.a().length() > 0))
      {
        localAbstractTableModel.addWhereFunction(localm.a(), localm.c(), localm.b());
        localAbstractTableModel.updateViewer();
      }
    }
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof AbstractTableModel;
  }

  protected boolean d()
  {
    return true;
  }

  public String a()
  {
    return "AddWhere";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.b.f
 * JD-Core Version:    0.6.0
 */