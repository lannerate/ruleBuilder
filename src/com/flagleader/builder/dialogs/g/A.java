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

public class A extends com.flagleader.builder.dialogs.r
{
  private List a = new ArrayList();
  private i b = new i(true, true);
  private IRuleGroup c;
  private Button d;
  private List e;
  private BuilderManager f;
  private int g = 0;
  private Table h;

  public A(BuilderManager paramBuilderManager, IRuleGroup paramIRuleGroup, int paramInt)
  {
    super(paramBuilderManager.getShell());
    this.c = paramIRuleGroup;
    this.f = paramBuilderManager;
    this.g = paramInt;
    super.setShellStyle(1168);
  }

  protected Control createDialogArea(Composite paramComposite)
  {
    setMessage(a("title.RuleSaveSelectDialog"));
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
    this.e = b();
    String[] arrayOfString1 = ResourceTools.getStringArray("Columns.RuleLoadSelectDialog");
    String[] arrayOfString2 = ResourceTools.getStringArray("Types.RuleLoadSelectDialog");
    String[] arrayOfString3 = ResourceTools.getStringArray("lengths.RuleLoadSelectDialog");
    int[] arrayOfInt = new int[arrayOfString3.length];
    for (int i = 0; i < arrayOfString3.length; i++)
      arrayOfInt[i] = Integer.parseInt(arrayOfString3[i]);
    for (i = 0; i < arrayOfString1.length; i++)
      arrayOfString1[i] = a(arrayOfString1[i] + ".RuleLoadSelectDialog");
    this.b.a(arrayOfString1, arrayOfInt, arrayOfString2);
    this.h.setHeaderVisible(true);
    this.h.setLayoutData(new GridData(1808));
    Iterator localIterator = this.c.getRulePackages();
    while (localIterator.hasNext())
    {
      localObject = (RulePackage)localIterator.next();
      if (((RulePackage)localObject).isLocked())
        continue;
      j = 0;
      for (int k = 0; (this.e != null) && (k < this.e.size()); k++)
      {
        List localList = (List)this.e.get(k);
        if (!localList.get(2).toString().equalsIgnoreCase(((RulePackage)localObject).getExeRulePackageName()))
          continue;
        TableItem localTableItem2 = new TableItem(this.h, 0);
        localTableItem2.setData(localObject);
        localTableItem2.setText(0, StringUtil.stringValue(localList.get(0)));
        localTableItem2.setText(1, StringUtil.stringValue(localList.get(1)));
        localTableItem2.setText(2, StringUtil.stringValue(localList.get(2)));
        localTableItem2.setText(3, DateUtil.stringDatetime(new Date(((RulePackage)localObject).getMaxModifyTime())));
        localTableItem2.setText(4, ((RulePackage)localObject).getVersion());
        localTableItem2.setText(5, StringUtil.stringValue(localList.get(5)));
        localTableItem2.setText(6, StringUtil.stringValue(localList.get(8)));
        localTableItem2.setText(7, StringUtil.stringValue(localList.get(6)));
        localTableItem2.setText(8, StringUtil.stringValue(localList.get(7)));
        localTableItem2.setText(9, StringUtil.stringValue(localList.get(4)));
        if (((RulePackage)localObject).getMaxModifyTime() >= ((Date)localList.get(5)).getTime() + 1000L)
          localTableItem2.setChecked(true);
        j = 1;
        break;
      }
      if (j != 0)
        continue;
      TableItem localTableItem1 = new TableItem(this.h, 0);
      localTableItem1.setData(localObject);
      localTableItem1.setText(0, "");
      localTableItem1.setText(1, ((RulePackage)localObject).getDisplayName());
      localTableItem1.setText(2, ((RulePackage)localObject).getExeRulePackageName());
      localTableItem1.setText(3, DateUtil.stringDatetime(new Date(((RulePackage)localObject).getMaxModifyTime())));
      localTableItem1.setText(4, ((RulePackage)localObject).getVersion());
      localTableItem1.setText(5, "");
      localTableItem1.setText(6, "");
      localTableItem1.setText(7, "");
      localTableItem1.setText(8, "");
      localTableItem1.setText(9, "");
      localTableItem1.setChecked(true);
    }
    Object localObject = new Button(localComposite1, 32);
    ((Button)localObject).setText(a("selectall.dialog"));
    ((Button)localObject).addSelectionListener(new B(this, (Button)localObject));
    for (int j = 0; j < this.h.getColumnCount(); j++)
      this.h.getColumn(j).pack();
    return (Control)localComposite1;
  }

  private List b()
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
    for (int i = 0; i < arrayOfTableItem.length; i++)
    {
      if (!arrayOfTableItem[i].getChecked())
        continue;
      this.a.add(arrayOfTableItem[i].getData());
    }
    if (this.a.size() < 1)
    {
      MessageDialog.openError(getShell(), "", "nothing select");
      return;
    }
    super.okPressed();
  }

  public List a()
  {
    return this.a;
  }
}

/* Location:           D:\Dev_tools\ruleEngine\rbuilder.jar
 * Qualified Name:     com.flagleader.builder.dialogs.g.A
 * JD-Core Version:    0.6.0
 */