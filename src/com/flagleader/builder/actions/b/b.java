package com.flagleader.builder.actions.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.b.e;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import java.sql.SQLException;

public class b extends i
{
  public b(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    a(paramITreeNode, "");
  }

  public String a()
  {
    return "AddProcedure";
  }

  public void a(ITreeNode paramITreeNode, String paramString)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof DBModel)))
    {
      DBModel localDBModel = (DBModel)paramITreeNode;
      boolean bool = false;
      if (new File(localDBModel.getDbFilePath()).exists())
        bool = a(new File(localDBModel.getDbFilePath()), paramITreeNode);
      else if (new File(this.a.getConfigManager().a, localDBModel.getDbFilePath()).exists())
        bool = a(new File(this.a.getConfigManager().a, localDBModel.getDbFilePath()), paramITreeNode);
      if (!bool)
      {
        e locale = new e(localDBModel);
        if (locale.open() == 0)
        {
          try
          {
            localDBModel.createProcedure(locale.a());
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
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.b.b
 * JD-Core Version:    0.6.0
 */