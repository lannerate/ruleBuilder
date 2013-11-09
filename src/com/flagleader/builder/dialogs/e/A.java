package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.i;
import com.flagleader.manager.d.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class A extends r
{
  protected com.flagleader.manager.dialog.d.d a = null;
  private i b = new i(true, true);
  private Table c;

  public A(Shell paramShell, com.flagleader.manager.dialog.d.d paramd)
  {
    super(paramShell);
    this.a = paramd;
  }

  public A(Shell paramShell, List paramList)
  {
    this(paramShell, new com.flagleader.manager.dialog.d.d(null, paramList));
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.RecoverRulePackage"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(650, 350));
    this.c = this.b.a(localComposite2, 67618);
    this.c.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.RecoverRulePackageDialog");
    while (this.c.getColumnCount() > 0)
      this.c.getColumn(0).dispose();
    String[] arrayOfString2 = new String[arrayOfString1.length];
    int[] arrayOfInt = new int[arrayOfString1.length];
    String[] arrayOfString3 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      arrayOfString2[i] = ResourceTools.getMessage(arrayOfString1[i] + ".RecoverRulePackageDialog");
      arrayOfInt[i] = 160;
      arrayOfString3[i] = "string";
    }
    this.b.a(arrayOfString2, arrayOfInt, arrayOfString3);
    this.c.setHeaderVisible(true);
    this.c.setLayoutData(new GridData(1808));
    for (i = 0; i < this.a.d().size(); i++)
    {
      TableItem localTableItem = new TableItem(this.c, 0);
      List localList = (List)this.a.d().get(i);
      localTableItem.setData(localList);
      a(localTableItem, localList.get(0).toString(), new SimpleDateFormat(b.a().i()).format(new Date(Long.parseLong(localList.get(1).toString()))), localList.get(2).toString());
    }
    for (i = 0; i < this.c.getColumnCount(); i++)
      this.c.getColumn(i).pack();
    return localComposite1;
  }

  private void a(TableItem paramTableItem, String paramString1, String paramString2, String paramString3)
  {
    paramTableItem.setText(0, paramString1);
    paramTableItem.setText(1, paramString2);
    paramTableItem.setText(2, paramString3);
  }

  protected void okPressed()
  {
    TableItem[] arrayOfTableItem = this.c.getItems();
    this.a.b().clear();
    for (int i = 0; i < arrayOfTableItem.length; i++)
    {
      if (!arrayOfTableItem[i].getChecked())
        continue;
      this.a.b().add(arrayOfTableItem[i].getData());
    }
    super.okPressed();
    if (this.a.getAfterFinish() != null)
      this.a.getAfterFinish().c();
  }

  protected void cancelPressed()
  {
    super.cancelPressed();
    if (this.a.getAfterFinish() != null)
      this.a.getAfterFinish().a();
  }

  public List b()
  {
    return this.a.b();
  }

  public List c()
  {
    return this.a.c();
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.A
 * JD-Core Version:    0.6.0
 */