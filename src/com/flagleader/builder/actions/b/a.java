package com.flagleader.builder.actions.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.builder.dialogs.b.c;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.tree.BOContainerGroup;
import com.flagleader.repository.tree.ITreeNode;
import java.sql.SQLException;
import org.eclipse.swt.widgets.Shell;

public class a extends bl
{
  public a(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    a(paramITreeNode, "");
  }

  public String a()
  {
    return "AddEnumTable";
  }

  public void a(ITreeNode paramITreeNode, String paramString)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()))
    {
      Object localObject;
      c localc;
      if ((paramITreeNode instanceof DBModel))
      {
        localObject = (DBModel)paramITreeNode;
        localc = new c(new Shell(), (DBModel)localObject, paramString);
        if ((localc.open() == 0) && (localc.b().length() > 0))
        {
          try
          {
            ((DBModel)localObject).createEnumTable(localc.b(), localc.a());
          }
          catch (ClassNotFoundException localClassNotFoundException)
          {
            this.a.showError("class not found");
          }
          catch (SQLException localSQLException)
          {
            this.a.showError(localSQLException.getMessage());
          }
          ((DBModel)localObject).updateTree();
          ((DBModel)localObject).updateViewer();
        }
      }
      if ((paramITreeNode instanceof BOContainerGroup))
      {
        localObject = (BOContainerGroup)paramITreeNode;
        localc = new c(new Shell(), null, paramString);
        if ((localc.open() == 0) && (localc.a().length() > 0))
        {
          ((BOContainerGroup)localObject).createEnumTable(localc.a());
          ((BOContainerGroup)localObject).updateTree();
          ((BOContainerGroup)localObject).updateViewer();
        }
      }
    }
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return ((paramITreeNode instanceof DBModel)) || ((paramITreeNode instanceof BOContainerGroup));
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.b.a
 * JD-Core Version:    0.6.0
 */