package com.flagleader.builder.actions.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.builder.dialogs.b.t;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.tree.ITreeNode;
import java.util.List;
import org.eclipse.swt.widgets.Shell;

public class c extends bl
{
  public c(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof SheetTable)))
    {
      SheetTable localSheetTable = (SheetTable)paramITreeNode;
      t localt = new t(new Shell(), localSheetTable);
      if ((localt.open() == 0) && (localt.a().size() > 0))
      {
        if (localt.b())
          localSheetTable.addInsertFunction(localt.a());
        else
          localSheetTable.addUpdateFunction(localt.a());
        localSheetTable.updateViewer();
      }
    }
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof SheetTable;
  }

  protected boolean d()
  {
    return true;
  }

  public String a()
  {
    return "AddSheetInserts";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.b.c
 * JD-Core Version:    0.6.0
 */