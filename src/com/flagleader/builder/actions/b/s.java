package com.flagleader.builder.actions.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.builder.dialogs.b.i;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.SheetTable;
import com.flagleader.repository.tree.BOContainerGroup;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import java.sql.SQLException;
import org.eclipse.swt.widgets.Shell;

public class s extends bl
{
  public s(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return ((paramITreeNode instanceof DBModel)) || ((paramITreeNode instanceof BOContainerGroup)) || ((paramITreeNode instanceof Envionment));
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()))
    {
      Object localObject1;
      Object localObject2;
      if ((paramITreeNode instanceof DBModel))
      {
        localObject1 = (DBModel)paramITreeNode;
        localObject2 = new i(new Shell(), (DBModel)localObject1, "");
        if (((i)localObject2).open() == 0)
        {
          try
          {
            SheetTable localSheetTable1 = ((DBModel)localObject1).createSheetTable(((i)localObject2).b(), ((i)localObject2).a(), ((DBModel)localObject1).getVarTableName(((i)localObject2).c()));
          }
          catch (ClassNotFoundException localClassNotFoundException)
          {
            this.a.showError("class not found");
          }
          catch (SQLException localSQLException)
          {
            this.a.showError(localSQLException.getMessage());
          }
          ((DBModel)localObject1).updateTree();
          ((DBModel)localObject1).updateViewer();
        }
      }
      else
      {
        SheetTable localSheetTable2;
        if ((paramITreeNode instanceof Envionment))
        {
          localObject1 = new i(new Shell(), null, "");
          if (((i)localObject1).open() == 0)
          {
            localObject2 = (Envionment)paramITreeNode;
            localSheetTable2 = new SheetTable("", ((i)localObject1).a(), ((i)localObject1).c());
            ((Envionment)localObject2).addChildElement(localSheetTable2);
            ((Envionment)localObject2).setModified(true);
            ((Envionment)localObject2).updateTree();
          }
        }
        else if ((paramITreeNode instanceof BOContainerGroup))
        {
          localObject1 = new i(new Shell(), null, "");
          if (((i)localObject1).open() == 0)
          {
            localObject2 = (BOContainerGroup)paramITreeNode;
            localSheetTable2 = new SheetTable("", ((i)localObject1).a(), ((i)localObject1).c());
            ((BOContainerGroup)localObject2).addChildElement(localSheetTable2);
            ((BOContainerGroup)localObject2).setModified(true);
            ((BOContainerGroup)localObject2).updateTree();
          }
        }
      }
    }
  }

  public String a()
  {
    return "NewSheet";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.b.s
 * JD-Core Version:    0.6.0
 */