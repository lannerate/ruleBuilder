package com.flagleader.builder.actions.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.actions.bl;
import com.flagleader.builder.dialogs.b.q;
import com.flagleader.builder.e.d.d;
import com.flagleader.manager.t;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.FieldModel;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.IRulePackage;
import com.flagleader.repository.tree.ITreeNode;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

public class r extends bl
{
  public r(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    String[] arrayOfString = { "*.dbs" };
    if ((paramITreeNode != null) && (!paramITreeNode.isLocked()) && ((paramITreeNode instanceof IRuleGroup)))
    {
      FileDialog localFileDialog = new FileDialog(this.a.getShell());
      localFileDialog.setFilterExtensions(arrayOfString);
      File localFile1 = new File(this.a.getConfigManager().B());
      if (localFile1.exists())
      {
        localFileDialog.setFilterPath(localFile1.getParent());
        localFileDialog.setFileName(localFile1.getName());
      }
      String str = localFileDialog.open();
      if (str != null)
      {
        File localFile2 = new File(str);
        this.a.getConfigManager().t(localFile2.getAbsolutePath());
        if (this.a.isMainApplication())
          this.a.getConfigManager().b();
        a(localFile2, paramITreeNode);
      }
    }
  }

  protected boolean a(File paramFile, ITreeNode paramITreeNode)
  {
    try
    {
      if (paramFile.getName().endsWith(".dbs"))
      {
        DBModel localDBModel = com.flagleader.repository.e.c.a(paramFile);
        q localq = new q(this.a.getShell(), localDBModel.getTables());
        if ((localq.open() == 0) && (localq.b().size() > 0))
        {
          com.flagleader.builder.e.d.c localc = new com.flagleader.builder.e.d.c(localDBModel, a(localq.b()));
          localc.b().a(localq.b());
          WizardDialog localWizardDialog = new WizardDialog(this.a.getShell(), localc);
          if (localWizardDialog.open() == 0)
          {
            this.a.getShell().setCursor(this.a.getShell().getDisplay().getSystemCursor(1));
            List localList = localq.b();
            if (localList.size() > 0)
            {
              com.flagleader.repository.g.b localb = new com.flagleader.repository.g.b((IRuleGroup)paramITreeNode, localDBModel, localList, localc.i(), localc.k(), localc.m(), "query/" + localq.c(), localq.a());
              localb.a();
              paramITreeNode.setModified(true);
              paramITreeNode.updateTree();
              paramITreeNode.updateViewer();
              Iterator localIterator = ((IRuleGroup)paramITreeNode).getRulePackages();
              while (localIterator.hasNext())
                this.a.getRulesManager().l().a((IRulePackage)localIterator.next());
            }
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

  private TableModel a(List paramList)
  {
    List localList = null;
    for (int i = 0; i < paramList.size(); i++)
    {
      TableModel localTableModel = (TableModel)paramList.get(i);
      localList = localTableModel.getPrimaryKeys();
      if ((localList.size() > 0) && (a(localList, paramList)))
      {
        if ((((FieldModel)localList.get(0)).isAutoIncrement()) || (((FieldModel)localList.get(0)).isReadOnly()))
          return localTableModel;
      }
      else
      {
        paramList.remove(i);
        i--;
      }
    }
    return (TableModel)paramList.get(0);
  }

  protected boolean a(List paramList1, List paramList2)
  {
    for (int i = 0; i < paramList2.size(); i++)
    {
      TableModel localTableModel = (TableModel)paramList2.get(i);
      int j = 1;
      for (int k = 0; k < paramList1.size(); k++)
      {
        if (localTableModel.getField(((FieldModel)paramList1.get(k)).getFieldName()) != null)
          continue;
        j = 0;
        break;
      }
      if (j == 0)
        return false;
    }
    return true;
  }

  public String a()
  {
    return "InitQueryJsp";
  }

  protected boolean c(ITreeNode paramITreeNode)
  {
    return paramITreeNode instanceof IRuleGroup;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.g.r
 * JD-Core Version:    0.6.0
 */