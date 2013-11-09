package com.flagleader.builder.actions.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.EnumTable;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.tree.ITreeNode;
import java.sql.SQLException;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class z extends bl
{
  public z(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()))
    {
      Object localObject1;
      if ((paramITreeNode instanceof TableModel))
      {
        localObject1 = (TableModel)paramITreeNode;
        try
        {
          this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
          ((TableModel)localObject1).getDBModel().updateTableModel((TableModel)localObject1);
          ((TableModel)localObject1).updateViewer();
        }
        catch (ClassNotFoundException localClassNotFoundException1)
        {
          this.a.showError(localClassNotFoundException1.getLocalizedMessage());
        }
        catch (SQLException localSQLException1)
        {
          this.a.showError(localSQLException1.getLocalizedMessage());
        }
        finally
        {
          this.a.getShell().setCursor(null);
        }
      }
      if ((paramITreeNode instanceof EnumTable))
      {
        localObject1 = (EnumTable)paramITreeNode;
        try
        {
          this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
          ((EnumTable)localObject1).changeSqlText(((EnumTable)localObject1).getSqlSelect());
          ((EnumTable)localObject1).setModified(true);
          ((EnumTable)localObject1).updateViewer();
        }
        catch (ClassNotFoundException localClassNotFoundException2)
        {
          this.a.showError(localClassNotFoundException2.getLocalizedMessage());
        }
        catch (SQLException localSQLException2)
        {
          this.a.showError(localSQLException2.getLocalizedMessage());
        }
        finally
        {
          this.a.getShell().setCursor(null);
        }
      }
    }
  }

  public String a()
  {
    return "UpdateTableItem";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return ((paramITreeNode instanceof TableModel)) || ((paramITreeNode instanceof EnumTable));
  }

  protected boolean d()
  {
    return true;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.b.z
 * JD-Core Version:    0.6.0
 */