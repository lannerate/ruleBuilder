package com.flagleader.builder.a.d;

import com.flagleader.builder.BuilderManager;
import com.flagleader.manager.d.b;
import com.flagleader.repository.db.DBModel;
import com.flagleader.repository.db.TableModel;
import com.flagleader.repository.db.a.a;
import com.flagleader.repository.db.a.e;
import com.flagleader.repository.export.IPage;
import com.flagleader.repository.export.PageFieldModel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

class ad
  implements Listener
{
  ad(W paramW, Item[] paramArrayOfItem)
  {
  }

  public void handleEvent(Event paramEvent)
  {
    String[] arrayOfString = { "*.dbs" };
    FileDialog localFileDialog = new FileDialog(new Shell());
    localFileDialog.setFilterExtensions(arrayOfString);
    File localFile1 = new File(W.c(this.a).getConfigManager().B());
    if (localFile1.exists())
    {
      localFileDialog.setFilterPath(localFile1.getParent());
      localFileDialog.setFileName(localFile1.getName());
    }
    String str1 = localFileDialog.open();
    if (str1 != null)
    {
      File localFile2 = new File(str1);
      try
      {
        DBModel localDBModel = com.flagleader.repository.e.c.a(localFile2);
        com.flagleader.builder.e.e.c localc = new com.flagleader.builder.e.e.c(localDBModel);
        WizardDialog localWizardDialog = new WizardDialog(new Shell(), localc);
        if (localWizardDialog.open() == 0)
        {
          localc.e();
          a locala = new a(localDBModel);
          String str2 = locala.a((TableModel)localc.e().get(0), localc.g(), new ArrayList());
          str2 = str2 + " where " + ((e)locala.c().get(0)).e() + " like '?%' ";
          ((PageFieldModel)this.b[0].getData()).setPropertyValue("sql", str2);
          ((PageFieldModel)this.b[0].getData()).setPropertyValue("connection", localDBModel.getDatasourceName());
          ((PageFieldModel)this.b[0].getData()).setPropertyValue("valueField", ((e)locala.c().get(0)).e());
          ((PageFieldModel)this.b[0].getData()).setPropertyValue("textField", ((e)locala.c().get(1)).e());
          this.a.q().setModified(true);
          this.a.update();
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.a.d.ad
 * JD-Core Version:    0.6.0
 */