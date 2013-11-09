package com.flagleader.builder.dialogs.e;

import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.dialogs.r;
import com.flagleader.builder.widget.i;
import com.flagleader.repository.tree.RulePackage;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class B extends r
{
  protected List a = null;
  protected List b = new ArrayList();
  private i c = new i(true, true);
  private Table d;

  public B(Shell paramShell, List paramList)
  {
    super(paramShell);
    this.a = paramList;
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.RestoreRulePackageDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    localComposite2.setLayoutData(a(650, 350));
    this.d = this.c.a(localComposite2, 67618);
    this.d.setLinesVisible(true);
    String[] arrayOfString1 = ResourceTools.getStringArray("columns.RestoreRulePackageDialog");
    while (this.d.getColumnCount() > 0)
      this.d.getColumn(0).dispose();
    String[] arrayOfString2 = new String[arrayOfString1.length];
    int[] arrayOfInt = new int[arrayOfString1.length];
    String[] arrayOfString3 = new String[arrayOfString1.length];
    for (int i = 0; i < arrayOfString1.length; i++)
    {
      arrayOfString2[i] = ResourceTools.getMessage(arrayOfString1[i] + ".RestoreRulePackageDialog");
      arrayOfInt[i] = 160;
      arrayOfString3[i] = "string";
    }
    this.c.a(arrayOfString2, arrayOfInt, arrayOfString3);
    this.d.setHeaderVisible(true);
    this.d.setLayoutData(new GridData(1808));
    for (i = 0; i < this.a.size(); i++)
    {
      TableItem localTableItem = new TableItem(this.d, 0);
      RulePackage localRulePackage = (RulePackage)this.a.get(i);
      localTableItem.setData(localRulePackage);
      a(localTableItem, localRulePackage.getDisplayName(), localRulePackage.getLastModifyTime(), localRulePackage.getExeRulePackageName());
    }
    for (i = 0; i < this.d.getColumnCount(); i++)
      this.d.getColumn(i).pack();
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
    TableItem[] arrayOfTableItem = this.d.getItems();
    this.b.clear();
    for (int i = 0; i < arrayOfTableItem.length; i++)
    {
      if (!arrayOfTableItem[i].getChecked())
        continue;
      this.b.add(arrayOfTableItem[i].getData());
    }
    super.okPressed();
  }

  protected void cancelPressed()
  {
    super.cancelPressed();
  }

  public List a()
  {
    return this.b;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.e.B
 * JD-Core Version:    0.6.0
 */