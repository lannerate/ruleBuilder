package com.flagleader.builder.actions.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.builder.dialogs.b.a;
import com.flagleader.builder.dialogs.b.f;
import com.flagleader.builder.dialogs.b.s;
import com.flagleader.builder.dialogs.b.v;
import com.flagleader.manager.d.b;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.FKModel;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.ProcedureModel;
import com.flagleader.repository.db.SelectTable;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public abstract class i extends bl
{
  public i(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof DBModel;
  }

  protected boolean d()
  {
    return true;
  }

  protected boolean a(File paramFile, ITreeNode paramITreeNode)
  {
    try
    {
      if (paramFile.getName().endsWith(".dbs"))
      {
        DBModel localDBModel1 = com.flagleader.repository.e.c.a(paramFile);
        s locals = new s(this.a.getShell(), localDBModel1.getProcedures());
        if (locals.open() == 0)
        {
          List localList = locals.a();
          DBModel localDBModel2 = null;
          if ((paramITreeNode instanceof DBModel))
          {
            localDBModel2 = (DBModel)paramITreeNode;
            if ((!localDBModel2.getDriver().equalsIgnoreCase(localDBModel1.getDriver())) || (!localDBModel2.getUrl().equalsIgnoreCase(localDBModel1.getUrl())) || (!localDBModel2.getUserName().equalsIgnoreCase(localDBModel1.getUserName())) || (!localDBModel2.getPasswd().equalsIgnoreCase(localDBModel1.getPasswd())) || (!localDBModel2.getSchemaName().equalsIgnoreCase(localDBModel1.getSchemaName())) || (!localDBModel2.getCatalogName().equalsIgnoreCase(localDBModel1.getCatalogName())))
            {
              localDBModel2.setDriver(localDBModel1.getDriver());
              localDBModel2.setUrl(localDBModel1.getUrl());
              localDBModel2.setUserName(localDBModel1.getUserName());
              localDBModel2.setPasswd(localDBModel1.getPasswd());
              localDBModel2.setDatasourceName(localDBModel1.getDisplayName());
              localDBModel2.setDisplayName(localDBModel1.getDisplayName());
              localDBModel2.setSchemaName(localDBModel1.getSchemaName());
              localDBModel2.setCatalogName(localDBModel1.getCatalogName());
              if (paramFile.getAbsolutePath().indexOf(this.a.getConfigManager().a) == 0)
                localDBModel2.setDbFilePath(paramFile.getAbsolutePath().substring(this.a.getConfigManager().a.length() + 1));
              else
                localDBModel2.setDbFilePath(paramFile.getAbsolutePath());
              localDBModel2.setModified(true);
              if ((paramITreeNode.getParent() instanceof ITreeNode))
                ((ITreeNode)paramITreeNode.getParent()).updateTree();
            }
          }
          else
          {
            localDBModel2 = new DBModel();
            localDBModel2.setDriver(localDBModel1.getDriver());
            localDBModel2.setUrl(localDBModel1.getUrl());
            localDBModel2.setUserName(localDBModel1.getUserName());
            localDBModel2.setPasswd(localDBModel1.getPasswd());
            localDBModel2.setDatasourceName(localDBModel1.getDisplayName());
            localDBModel2.setDisplayName(localDBModel1.getDisplayName());
            localDBModel2.setSchemaName(localDBModel1.getSchemaName());
            localDBModel2.setCatalogName(localDBModel1.getCatalogName());
            if (paramFile.getAbsolutePath().indexOf(this.a.getConfigManager().a) == 0)
              localDBModel2.setDbFilePath(paramFile.getAbsolutePath().substring(this.a.getConfigManager().a.length() + 1));
            else
              localDBModel2.setDbFilePath(paramFile.getAbsolutePath());
            ((Envionment)paramITreeNode).addChildElement(localDBModel2);
            localDBModel2.setModified(true);
            ((Envionment)paramITreeNode).updateTree();
          }
          this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
          for (int i = 0; i < localList.size(); i++)
          {
            ProcedureModel localProcedureModel = (ProcedureModel)localList.get(i);
            localDBModel2.addChildElement(localProcedureModel);
            try
            {
              localDBModel2.updateProcedureModel(localProcedureModel);
            }
            catch (ClassNotFoundException localClassNotFoundException)
            {
              MessageDialog.openError(this.a.getShell(), "", localClassNotFoundException.getLocalizedMessage());
            }
            catch (SQLException localSQLException)
            {
              MessageDialog.openError(this.a.getShell(), "", localSQLException.getLocalizedMessage());
            }
          }
          if (localList.size() > 0)
          {
            localDBModel2.setModified(true);
            localDBModel2.updateTree();
            localDBModel2.updateViewer();
          }
        }
        this.a.getShell().setCursor(null);
        return true;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.showError(localException.getLocalizedMessage());
    }
    finally
    {
      this.a.getShell().setCursor(null);
    }
    this.a.getShell().setCursor(null);
    return false;
  }

  protected boolean b(File paramFile, ITreeNode paramITreeNode)
  {
    try
    {
      if (paramFile.getName().endsWith(".dbs"))
      {
        DBModel localDBModel1 = com.flagleader.repository.e.c.a(paramFile);
        v localv = new v(this.a.getShell(), localDBModel1.getTables());
        if (localv.open() == 0)
        {
          List localList1 = localv.a();
          DBModel localDBModel2 = null;
          if ((paramITreeNode instanceof DBModel))
          {
            localDBModel2 = (DBModel)paramITreeNode;
            if ((!localDBModel2.getDriver().equalsIgnoreCase(localDBModel1.getDriver())) || (!localDBModel2.getUrl().equalsIgnoreCase(localDBModel1.getUrl())) || (!localDBModel2.getUserName().equalsIgnoreCase(localDBModel1.getUserName())) || (!localDBModel2.getPasswd().equalsIgnoreCase(localDBModel1.getPasswd())) || (!localDBModel2.getSchemaName().equalsIgnoreCase(localDBModel1.getSchemaName())) || (!localDBModel2.getCatalogName().equalsIgnoreCase(localDBModel1.getCatalogName())))
            {
              localDBModel2.setDriver(localDBModel1.getDriver());
              localDBModel2.setUrl(localDBModel1.getUrl());
              localDBModel2.setUserName(localDBModel1.getUserName());
              localDBModel2.setPasswd(localDBModel1.getPasswd());
              localDBModel2.setDatasourceName(localDBModel1.getDisplayName());
              localDBModel2.setDisplayName(localDBModel1.getDisplayName());
              localDBModel2.setSchemaName(localDBModel1.getSchemaName());
              localDBModel2.setCatalogName(localDBModel1.getCatalogName());
              if (paramFile.getAbsolutePath().indexOf(this.a.getConfigManager().a) == 0)
                localDBModel2.setDbFilePath(paramFile.getAbsolutePath().substring(this.a.getConfigManager().a.length() + 1));
              else
                localDBModel2.setDbFilePath(paramFile.getAbsolutePath());
              localDBModel2.setModified(true);
              if ((paramITreeNode.getParent() instanceof ITreeNode))
                ((ITreeNode)paramITreeNode.getParent()).updateTree();
            }
          }
          else
          {
            localDBModel2 = new DBModel();
            localDBModel2.setDriver(localDBModel1.getDriver());
            localDBModel2.setUrl(localDBModel1.getUrl());
            localDBModel2.setUserName(localDBModel1.getUserName());
            localDBModel2.setPasswd(localDBModel1.getPasswd());
            localDBModel2.setDatasourceName(localDBModel1.getDisplayName());
            localDBModel2.setDisplayName(localDBModel1.getDisplayName());
            localDBModel2.setSchemaName(localDBModel1.getSchemaName());
            localDBModel2.setCatalogName(localDBModel1.getCatalogName());
            if (paramFile.getAbsolutePath().indexOf(this.a.getConfigManager().a) == 0)
              localDBModel2.setDbFilePath(paramFile.getAbsolutePath().substring(this.a.getConfigManager().a.length() + 1));
            else
              localDBModel2.setDbFilePath(paramFile.getAbsolutePath());
            ((Envionment)paramITreeNode).addChildElement(localDBModel2);
            localDBModel2.setModified(true);
            ((Envionment)paramITreeNode).updateTree();
          }
          this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
          for (int i = 0; i < localList1.size(); i++)
          {
            TableModel localTableModel = (TableModel)localList1.get(i);
            List localList2 = localDBModel1.getFKModels(localTableModel.getTableName());
            for (int j = 0; j < localList2.size(); j++)
              localTableModel.addChildElement((FKModel)localList2.get(j));
            localDBModel2.addChildElement(localTableModel);
            try
            {
              localDBModel2.updateTableModel(localTableModel);
            }
            catch (ClassNotFoundException localClassNotFoundException)
            {
              MessageDialog.openError(this.a.getShell(), "", localClassNotFoundException.getLocalizedMessage());
            }
            catch (SQLException localSQLException)
            {
              MessageDialog.openError(this.a.getShell(), "", localSQLException.getLocalizedMessage());
            }
          }
          if (localList1.size() > 0)
          {
            localDBModel2.setModified(true);
            localDBModel2.updateTree();
            localDBModel2.updateViewer();
          }
        }
        this.a.getShell().setCursor(null);
        return true;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.a.showError(localException.getLocalizedMessage());
    }
    finally
    {
      this.a.getShell().setCursor(null);
    }
    this.a.getShell().setCursor(null);
    return false;
  }

  public void a(ITreeNode paramITreeNode, String paramString, List paramList)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof DBModel)))
    {
      DBModel localDBModel = (DBModel)paramITreeNode;
      f localf = new f(new Shell(), localDBModel, paramString);
      if ((localf.open() == 0) && (localf.b().length() > 0))
      {
        try
        {
          SelectTable localSelectTable = localDBModel.createSelectTable(localf.b(), localf.a(), localDBModel.getVarTableName(localf.c()));
          int i = 0;
          do
          {
            FieldModel localFieldModel = localSelectTable.getField(((com.flagleader.builder.e.i.c)paramList.get(i)).e());
            if ((localFieldModel != null) && (!localFieldModel.getDisplayName().equalsIgnoreCase(((com.flagleader.builder.e.i.c)paramList.get(i)).h())))
            {
              localFieldModel.setDisplayName(((com.flagleader.builder.e.i.c)paramList.get(i)).h());
              localSelectTable.changeFieldDisplayName(localFieldModel);
            }
            i++;
            if (paramList == null)
              break;
          }
          while (i < paramList.size());
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          this.a.showError("class not found");
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

  public void a(ITreeNode paramITreeNode, String paramString, List paramList, TableModel paramTableModel)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof DBModel)))
    {
      DBModel localDBModel = (DBModel)paramITreeNode;
      String str = com.flagleader.manager.d.c.a("deletefrom.DBAction", new Object[] { paramTableModel.getDisplayName() });
      a locala = new a(new Shell(), localDBModel, paramString, str);
      if ((locala.open() == 0) && (locala.b().length() > 0))
      {
        localDBModel.createCustomSql(locala.b(), locala.a(), locala.c());
        localDBModel.updateTree();
        localDBModel.updateViewer();
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.b.i
 * JD-Core Version:    0.6.0
 */