package com.flagleader.builder.actions.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.b.k;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.tree.ITreeNode;
import java.sql.SQLException;

public class v extends i
{
  public v(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof DBModel)))
    {
      DBModel localDBModel = (DBModel)paramITreeNode;
      int i = 0;
      k localk = new k(localDBModel);
      if (localk.open() == 0)
      {
        try
        {
          localDBModel.addTableModel(localk.a());
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          this.a.showError("class ont found" + localClassNotFoundException.getMessage());
        }
        catch (SQLException localSQLException)
        {
          this.a.showError(localSQLException.getMessage());
        }
        localDBModel.updateTree();
        localDBModel.updateViewer();
      }
    }
  }

  public String a()
  {
    return "NewTable";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.b.v
 * JD-Core Version:    0.6.0
 */