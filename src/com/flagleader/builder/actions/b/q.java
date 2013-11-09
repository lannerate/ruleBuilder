package com.flagleader.builder.actions.b;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.d.b;
import com.flagleader.manager.d.c;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.tree.ITreeNode;
import com.flagleader.sql.DBConfig;
import java.io.File;
import org.eclipse.swt.widgets.FileDialog;

public class q extends i
{
  public q(BuilderManager paramBuilderManager)
  {
    super(paramBuilderManager);
  }

  public void b(ITreeNode paramITreeNode)
  {
    if ((paramITreeNode == null) || (!(paramITreeNode instanceof DBModel)))
      return;
    DBModel localDBModel = (DBModel)paramITreeNode;
    FileDialog localFileDialog = new FileDialog(this.a.getShell(), 8192);
    localFileDialog.setFilterPath(this.a.getConfigManager().a + File.separator + "classes");
    localFileDialog.setFileName(DBConfig.getConfigFileName(localDBModel.getDatasourceName()));
    localFileDialog.setFilterExtensions(new String[] { "*.conf" });
    String str = localFileDialog.open();
    if (str != null)
    {
      DBConfig localDBConfig = new DBConfig(str);
      localDBConfig.setDataSourceName("");
      localDBConfig.setDbDriver(localDBModel.getDriver());
      localDBConfig.setDbUrl(localDBModel.getUrl());
      localDBConfig.setDbLogin(localDBModel.getUserName());
      localDBConfig.setDbPassword(localDBModel.getPasswd());
      if (localDBConfig.getDbDriver().indexOf("oracle") >= 0)
        localDBConfig.setTransactionLevel(0);
      localDBConfig.save();
      this.a.showSuccess(c.a("HasBeenExport", new String[] { str }));
    }
  }

  public String a()
  {
    return "MakeDBConfigItem";
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.actions.b.q
 * JD-Core Version:    0.6.0
 */