package com.flagleader.builder.dialogs.g;

import com.flagleader.builder.BuilderManager;
import com.flagleader.builder.ResourceTools;
import com.flagleader.builder.widget.i;
import com.flagleader.manager.a.a.c;
import com.flagleader.repository.tree.IRuleGroup;
import com.flagleader.repository.tree.RulePackage;
import com.flagleader.util.DateUtil;
import com.flagleader.util.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class y extends com.flagleader.builder.dialogs.r
{
  private List a = new ArrayList();
  private i b = new i(true, true);
  private IRuleGroup c;
  private Button d;
  private List e;
  private BuilderManager f;
  private int g = 0;
  private Table h;
  private Button i;
  private boolean j = false;

  public y(BuilderManager paramBuilderManager, IRuleGroup paramIRuleGroup, int paramInt)
  {
    super(paramBuilderManager.getShell());
    this.c = paramIRuleGroup;
    this.f = paramBuilderManager;
    this.g = paramInt;
    super.setShellStyle(1168);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.RuleLoadSelectDialog"));
    Composite localComposite1 = (Composite)super.createDialogArea(paramComposite);
    Composite localComposite2 = new Composite(localComposite1, 0);
    localComposite2.setLayout(a(1));
    GridData localGridData = new GridData(860, 550);
    localGridData.grabExcessHorizontalSpace = true;
    localGridData.grabExcessVerticalSpace = true;
    localGridData.horizontalAlignment = 4;
    localGridData.verticalAlignment = 4;
    localComposite2.setLayoutData(localGridData);
    this.h = this.b.a(localComposite2, 67618);
    this.h.setLinesVisible(true);
    this.e = c();
    String[] arrayOfString1 = ResourceTools.getStringArray("Columns.RuleLoadSelectDialog");
    String[] arrayOfString2 = ResourceTools.getStringArray("Types.RuleLoadSelectDialog");
    String[] arrayOfString3 = ResourceTools.getStringArray("lengths.RuleLoadSelectDialog");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int k = 0; k < arrayOfString3.length; k++)
      arrayOfInt[k] = Integer.parseInt(arrayOfString3[k]);
    for (k = 0; k < arrayOfString1.length; k++)
      arrayOfString1[k] = a(arrayOfString1[k] + ".RuleLoadSelectDialog");
    this.b.a(arrayOfString1, arrayOfInt, arrayOfString2);
    this.h.setHeaderVisible(true);
    this.h.setLayoutData(new GridData(1808));
    Iterator localIterator = this.c.getRulePackages();
    while (localIterator.hasNext())
    {
      localObject = (RulePackage)localIterator.next();
      for (m = 0; (this.e != null) && (m < this.e.size()); m++)
      {
        List localList = (List)this.e.get(m);
        if (!localList.get(2).toString().equalsIgnoreCase(((RulePackage)localObject).getExeRulePackageName()))
          continue;
        TableItem localTableItem = new TableItem(this.h, 0);
        localTableItem.setData(localObject);
        localTableItem.setText(0, StringUtil.stringValue(localList.get(0)));
        localTableItem.setText(1, StringUtil.stringValue(localList.get(1)));
        localTableItem.setText(2, StringUtil.stringValue(localList.get(2)));
        localTableItem.setText(3, DateUtil.stringDatetime(new Date(((RulePackage)localObject).getMaxModifyTime())));
        localTableItem.setText(4, ((RulePackage)localObject).getVersion());
        localTableItem.setText(5, StringUtil.stringValue(localList.get(5)));
        localTableItem.setText(6, StringUtil.stringValue(localList.get(8)));
        localTableItem.setText(7, StringUtil.stringValue(localList.get(6)));
        localTableItem.setText(8, StringUtil.stringValue(localList.get(7)));
        if (((RulePackage)localObject).getMaxModifyTime() + 1000L > ((Date)localList.get(5)).getTime())
          continue;
        localTableItem.setChecked(true);
      }
    }
    Object localObject = new Button(localComposite1, 32);
    ((Button)localObject).setText(a("selectall.dialog"));
    ((Button)localObject).addSelectionListener(new z(this, (Button)localObject));
    this.i = new Button(localComposite2, 32);
    this.i.setText(a("lockcheckout.RulePackageProperties"));
    for (int m = 0; m < this.h.getColumnCount(); m++)
      this.h.getColumn(m).pack();
    return (Control)localComposite1;
  }

  private List c()
  {
    try
    {
      c localc = this.f.getRulesManager().p();
      List localList = localc.a(this.g);
      if (localList == null)
      {
        MessageDialog.openError(getShell(), "", localc.i());
        return Collections.EMPTY_LIST;
      }
      return localList;
    }
    catch (Exception localException)
    {
      MessageDialog.openError(getShell(), "", localException.getLocalizedMessage());
    }
    return Collections.EMPTY_LIST;
  }

  protected void okPressed()
  {
    TableItem[] arrayOfTableItem = this.h.getItems();
    this.a.clear();
    for (int k = 0; k < arrayOfTableItem.length; k++)
    {
      if (!arrayOfTableItem[k].getChecked())
        continue;
      this.a.add(arrayOfTableItem[k].getData());
    }
    if (this.a.size() < 1)
    {
      MessageDialog.openError(getShell(), "", "nothing select");
      return;
    }
    this.j = this.i.getSelection();
    super.okPressed();
  }

  public boolean a()
  {
    return this.j;
  }

  public void a(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }

  public List b()
  {
    return this.a;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.g.y
 * JD-Core Version:    0.6.0
 */