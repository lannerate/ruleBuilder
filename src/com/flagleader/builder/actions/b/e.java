package com.flagleader.builder.actions.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.dialogs.b.l;
import com.flagleader.builder.dialogs.b.v;
import com.flagleader.manager.d.b;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.ViewModel;
import com.flagleader.repository.e.c;
import com.flagleader.repository.tree.Envionment;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import java.sql.SQLException;
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class e extends i
{
  public e(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof DBModel)))
    {
      DBModel localDBModel = (DBModel)paramITreeNode;
      boolean bool = false;
      if (new File(localDBModel.getDbFilePath()).exists())
        bool = c(new File(localDBModel.getDbFilePath()), paramITreeNode);
      else if (new File(this.a.getConfigManager().a, localDBModel.getDbFilePath()).exists())
        bool = c(new File(this.a.getConfigManager().a, localDBModel.getDbFilePath()), paramITreeNode);
      if (!bool)
      {
        l locall = new l(localDBModel);
        if (locall.open() == 0)
        {
          try
          {
            localDBModel.addViewModel(locall.a());
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

  public String a()
  {
    return "AddView";
  }

  private boolean c(File paramFile, ITreeNode paramITreeNode)
  {
    try
    {
      if (paramFile.getName().endsWith(".dbs"))
      {
        DBModel localDBModel1 = c.a(paramFile);
        v localv = new v(this.a.getShell(), localDBModel1.getViews());
        if (localv.open() == 0)
        {
          List localList = localv.a();
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
            ViewModel localViewModel = (ViewModel)localList.get(i);
            localDBModel2.addChildElement(localViewModel);
            try
            {
              localDBModel2.updateViewModel(localViewModel);
            }
            catch (ClassNotFoundException localClassNotFoundException)
            {
              MessageDialog.openError(this.a.getShell(), "", localClassNotFoundException.getLocalizedMessage());
              ((ViewModel)localList.get(i)).dispose();
            }
            catch (SQLException localSQLException)
            {
              MessageDialog.openError(this.a.getShell(), "", localSQLException.getLocalizedMessage());
              ((ViewModel)localList.get(i)).dispose();
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
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.b.e
 * JD-Core Version:    0.6.0
 */